package chefmooon.ubesdelight.common.block;

import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import chefmooon.ubesdelight.common.registry.UbesDelightSounds;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BakingMatBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<BakingMatBlock> CODEC = simpleCodec(BakingMatBlock::new);
    public static final BooleanProperty PROCESSING = BooleanProperty.create("processing");
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final Property<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE = Block.box(1.d, .0d, 1.d, 15.d, 1.d, 15.d);

    public BakingMatBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(PROCESSING, Boolean.FALSE).setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        InteractionResult result = InteractionResult.PASS;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof BakingMatBlockEntity bakingMatBlockEntity)) {
            return result;
        }

        ItemStack heldStack = player.getItemInHand(hand);
        ItemStack offHandStack = player.getOffhandItem();

        if (heldStack.getItem() instanceof ShearsItem || heldStack.getItem() instanceof TridentItem) {
            return result;
        }

        boolean isValidTool = heldStack.has(DataComponents.TOOL);

        if (!bakingMatBlockEntity.isEmpty() && !heldStack.isEmpty() && isValidTool) {
            if (tryProcessBakingMatUsingToolInHand(level, bakingMatBlockEntity, heldStack, offHandStack, player, hand).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
        }

        if (!state.getValue(BakingMatBlock.PROCESSING) && !isValidTool) {
            if (!bakingMatBlockEntity.isFull() && !heldStack.isEmpty()) {
                return tryAddItemFromPlayerHand(level, bakingMatBlockEntity, heldStack, offHandStack, player, hand);
            } else if (hand.equals(InteractionHand.MAIN_HAND) && !bakingMatBlockEntity.isEmpty() && heldStack.isEmpty()) {
                return tryRemoveItemFromPlayerHand(level, bakingMatBlockEntity, heldStack, offHandStack, player, hand);
            }
        }

        return result;
    }

    private InteractionResult tryAddItemFromPlayerHand(Level level, BakingMatBlockEntity bakingMatBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        InteractionResult result = InteractionResult.PASS;

        if (heldStack.isEmpty()) {
            return result;
        } else if (bakingMatBlockEntity.addItem(player.getAbilities().instabuild ? heldStack.copy() : heldStack)) {
            level.playSound(null, bakingMatBlockEntity.getBlockPos(), UbesDelightSounds.BLOCK_BAKING_MAT_ADD.get(), SoundSource.BLOCKS, 1.0f, 0.8f);
            return InteractionResult.SUCCESS;
        }

        return result;
    }

    private InteractionResult tryRemoveItemFromPlayerHand(Level level, BakingMatBlockEntity bakingMatBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        BlockPos pos = bakingMatBlockEntity.getBlockPos();
        if (!bakingMatBlockEntity.isEmpty()) {
            if (player.isCreative()) {
                bakingMatBlockEntity.removeItem();
            } else if (!player.getInventory().add(bakingMatBlockEntity.removeItem())) {
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), bakingMatBlockEntity.removeItem());
            }

            level.playSound(null, bakingMatBlockEntity.getBlockPos(), UbesDelightSounds.BLOCK_BAKING_MAT_REMOVE.get(), SoundSource.BLOCKS, 0.25f, 0.5f);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private InteractionResult tryProcessBakingMatUsingToolInHand(Level level, BakingMatBlockEntity bakingMatBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        InteractionResult result = InteractionResult.PASS;

        if (heldStack.has(DataComponents.TOOL) && bakingMatBlockEntity.processItemUsingTool(heldStack, player)) {
            return InteractionResult.SUCCESS;
        }
        return result;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean isPossibleToRespawnInThis(BlockState state) {
        return true;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        if (state.getValue(WATERLOGGED)) {
            scheduledTickAccess.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return direction == Direction.DOWN && !state.canSurvive(level, pos)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos floorPos = pos.below();
        return canSupportRigidBlock(level, floorPos) || canSupportCenter(level, floorPos, Direction.UP);
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(PROCESSING, WATERLOGGED, FACING);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return UbesDelightBlockEntityTypes.BAKING_MAT_BAMBOO.get().create(pos, state);
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
    protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel level, BlockPos pos, boolean movedByPiston) {
        Containers.updateNeighboursAfterDestroy(state, level, pos);
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
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof BakingMatBlockEntity bakingMatBlockEntity) {
            return bakingMatBlockEntity.getItemsQuantity();
        }
        return 0;
    }
}
