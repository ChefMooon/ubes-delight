package chefmooon.ubesdelight.common.block.leaf_feast.base;

import chefmooon.ubesdelight.common.block.entity.UniversalLeafFeastBlockEntity;
import chefmooon.ubesdelight.common.block.leaf_feast.base.LeafFeastBlock;
import chefmooon.ubesdelight.common.core.LeafFeastTypes;
import chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.utility.ItemStackUtil;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.ConsumableListener;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static chefmooon.ubesdelight.common.utility.VoxelShapeUtil.getRotatedShapes;

public class UniversalLeafFeastBlock extends BaseEntityBlock implements LeafFeastBlock, SimpleWaterloggedBlock {
    public static final MapCodec<UniversalLeafFeastBlock> CODEC = simpleCodec(UniversalLeafFeastBlock::new);
    private final VoxelShape[] CONNECT_SHAPES;
    private final VoxelShape[] TIP_SHAPES;
    private final VoxelShape[] END_SHAPES;

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public UniversalLeafFeastBlock(Properties properties) {
        super(properties);
        this.CONNECT_SHAPES = getRotatedShapes(NORTH_CONNECT_SHAPE);
        this.TIP_SHAPES = getRotatedShapes(LEAF_NORTH_TIP_SHAPE);
        this.END_SHAPES = getRotatedShapes(LEAF_NORTH_END_SHAPE);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SERVINGS, 1));
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        LeafFeastTypes leafFeastType = state.getValue(LEAF_FEAST_TYPE);

        return Shapes.or(this.getConnectShape(leafFeastType, getConnectDirections(facing.getOpposite()), CONNECT_SHAPES), this.getBaseShape(leafFeastType, facing, TIP_SHAPES, END_SHAPES, LEAF_BASE_SHAPE));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        BlockGetter blockGetter = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState originBlockState = blockGetter.getBlockState(blockPos);
        Direction facing = context.getHorizontalDirection();
        Pair<Direction, Direction> connectDirections = getConnectDirections(facing);
        BlockState rightBlockState = blockGetter.getBlockState(blockPos.relative(connectDirections.getFirst()));
        BlockState leftBlockState = blockGetter.getBlockState(blockPos.relative(connectDirections.getSecond()));

        return this.defaultBlockState().setValue(FACING, facing)
                .setValue(LEAF_FEAST_TYPE, getLeafFeastType(this.connectsTo(originBlockState, leftBlockState), this.connectsTo(originBlockState, rightBlockState)))
                .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) scheduledTickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

        Pair<Direction, Direction> connectDirections = getConnectDirections(state.getValue(FACING).getOpposite());
        if (direction == connectDirections.getFirst() || direction == connectDirections.getSecond())  {
            LeafFeastTypes leafFeastType = getLeafFeastType(this.connectsTo(state, level.getBlockState(pos.relative(connectDirections.getFirst()))), this.connectsTo(state, level.getBlockState(pos.relative(connectDirections.getSecond()))));
            if (state.getValue(SERVINGS) > 3) {
                if (leafFeastType == LeafFeastTypes.END || leafFeastType == LeafFeastTypes.TIP) {
                    return state.setValue(LEAF_FEAST_TYPE, LeafFeastTypes.MIDDLE);
                } else {
                    return state.setValue(LEAF_FEAST_TYPE, leafFeastType);
                }
            } else {
                return state.setValue(LEAF_FEAST_TYPE, leafFeastType);
            }
        }

        if (direction == Direction.DOWN && !state.canSurvive(level, pos)) return Blocks.AIR.defaultBlockState();

        return super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, LEAF_FEAST_TYPE, SERVINGS);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return UbesDelightBlockEntityTypes.UNIVERSAL_LEAF_FEAST.get().create(pos, state);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        InteractionResult result = InteractionResult.FAIL;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof UniversalLeafFeastBlockEntity universalLeafFeastBlockEntity)) {
            return result;
        }

        ItemStack heldStack = player.getItemInHand(hand);
        ItemStack offHandStack = player.getOffhandItem();

        if (heldStack.isEmpty()) {
            return tryRemoveItemFromPlayerHand(state, level, pos, universalLeafFeastBlockEntity, heldStack, offHandStack, player, hand);
        } else {
            return tryAddItemFromPlayerHand(state, level, pos, universalLeafFeastBlockEntity, heldStack, offHandStack, player, hand);
        }
    }

    private InteractionResult tryAddItemFromPlayerHand(BlockState state, Level level, BlockPos pos, UniversalLeafFeastBlockEntity universalLeafFeastBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        InteractionResult result = InteractionResult.PASS;
        int servings = state.getValue(SERVINGS);

        if (heldStack.isEmpty()) {
            return result;
        } else if (heldStack.has(DataComponents.FOOD)) {
            if (state.getValue(LEAF_FEAST_TYPE) == LeafFeastTypes.END || state.getValue(LEAF_FEAST_TYPE) == LeafFeastTypes.TIP) {
                if (servings >= 3) return InteractionResult.FAIL;
            }
            if (universalLeafFeastBlockEntity.addItem(player, player.getAbilities().instabuild ? heldStack.copy() : heldStack)) {
                level.setBlock(pos, state.setValue(SERVINGS, servings + 1), 3);
                playAddSound(level, universalLeafFeastBlockEntity.getBlockPos());
                LeafFeastBlock.triggerInsertAdvancement(player);
                return InteractionResult.SUCCESS;
            }
        }

        return result;
    }

    private InteractionResult tryRemoveItemFromPlayerHand(BlockState state, Level level, BlockPos pos, UniversalLeafFeastBlockEntity universalLeafFeastBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        int servings = state.getValue(SERVINGS);

        if (servings > 1) {
            if (!level.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3)) {
                return InteractionResult.PASS;
            }
        }

        playRemoveSound(level, universalLeafFeastBlockEntity.getBlockPos());
        ItemStack itemStack = universalLeafFeastBlockEntity.removeItem();
        if (!player.isCreative()) {
            if (player.isShiftKeyDown() && (player.getFoodData().needsFood() || Objects.requireNonNull(itemStack.get(DataComponents.FOOD)).canAlwaysEat())) {
                tryEat(itemStack, level, pos, player);
            } else {
                if (!player.getInventory().add(itemStack)) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), itemStack);
                }
            }
        }

        if (servings == 1) {
            if (!level.setBlock(pos, getTransformState(UbesDelightBlocks.LEAF_FEAST.get(), state), 3)) {
                return InteractionResult.PASS;
            }
        }

        return InteractionResult.SUCCESS;
    }

    public static void tryEat(ItemStack itemStack, Level level, BlockPos pos, Player player) {
        ItemStack container = ItemStackUtil.getContainer(itemStack);
        if (!container.isEmpty()) {
            spawnContainer(level, pos, player.getDirection().getOpposite(), container);
        }
        FoodProperties foodProperties = itemStack.get(DataComponents.FOOD);
        Consumable consumable = itemStack.get(DataComponents.CONSUMABLE);

        if (foodProperties != null) {
            level.gameEvent(player, GameEvent.EAT, pos);
            itemStack.getAllOfType(ConsumableListener.class).forEach(consumableListener -> consumableListener.onConsume(level, player, itemStack, consumable));
            if (!level.isClientSide() && consumable != null) {
                consumable.onConsumeEffects().forEach(consumeEffect -> consumeEffect.apply(level, itemStack, player));
            }
        }
        level.playSound(null, pos, SoundEvents.GENERIC_EAT.value(), SoundSource.PLAYERS, 0.8F, 0.8F);
        LeafFeastBlock.triggerConsumeAdvancement(player);
    }

    public static void spawnContainer(Level level, BlockPos blockPos, Direction direction, ItemStack itemStack) {
        ItemEntity entity = new ItemEntity(level,
                blockPos.getX() + 0.5 + (direction.getStepX() * 0.2),
                blockPos.getY() + 0.2,
                blockPos.getZ() + 0.5 + (direction.getStepZ() * 0.2), itemStack.copy());
        entity.setDeltaMovement(direction.getStepX() * 0.2F, 0.0F, direction.getStepZ() * 0.2F);
        level.addFreshEntity(entity);
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof UniversalLeafFeastBlockEntity universalLeafFeastBlockEntity) {
            return universalLeafFeastBlockEntity.getItemsQuantity() * 2;
        }
        return 0;
    }
}
