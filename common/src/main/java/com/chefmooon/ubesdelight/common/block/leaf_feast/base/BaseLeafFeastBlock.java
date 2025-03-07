package com.chefmooon.ubesdelight.common.block.leaf_feast.base;

import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import com.chefmooon.ubesdelight.common.registry.UbesDelightItems;
import com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil;
import com.chefmooon.ubesdelight.common.utility.ItemStackUtil;
import com.mojang.datafixers.util.Pair;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import static com.chefmooon.ubesdelight.common.utility.VoxelShapeUtil.getRotatedShapes;

public class BaseLeafFeastBlock extends Block implements LeafFeastBlock, SimpleWaterloggedBlock {
    protected final VoxelShape[] CONNECT_SHAPES;
    protected final VoxelShape[] TIP_SHAPES;
    protected final VoxelShape[] END_SHAPES;
    public BaseLeafFeastBlock(Properties properties) {
        super(properties);
        this.CONNECT_SHAPES = getRotatedShapes(NORTH_CONNECT_SHAPE);
        this.TIP_SHAPES = getRotatedShapes(LEAF_NORTH_TIP_SHAPE);
        this.END_SHAPES = getRotatedShapes(LEAF_NORTH_END_SHAPE);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (level.isClientSide()) {
            if (heldItem.isEmpty()) {
                if (tryRemoveItem(state, level, pos, player, hand).consumesAction()) return InteractionResult.SUCCESS;
            } else {
                if (tryAddItem(state, level, pos, player, hand).consumesAction()) return InteractionResult.SUCCESS;
            }
        }

        if (heldItem.isEmpty()) {
            return tryRemoveItem(state, level, pos, player, hand);
        } else {
            return tryAddItem(state, level, pos, player, hand);
        }
    }

    protected InteractionResult tryAddItem(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (!player.isShiftKeyDown()) {
            if (addItem(heldItem, state, level, pos, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
        }

        if (heldItem.isEdible()) {
            return transformToUniversal(heldItem, state, level, pos, player);
        }

        return InteractionResult.PASS;
    }

    @ExpectPlatform
    public static InteractionResult transformToUniversal(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player) {
        throw new AssertionError();
    }

    private InteractionResult addItem(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player) {
        Block block = getLeafFeastBlock(itemStack);

        if (block != Blocks.AIR) {
            BlockState newState = getTransformState(block, state).setValue(SERVINGS, 1);
            if (block instanceof LargeLeafFeastBlock) {
                if (state.getValue(LEAF_FEAST_TYPE) == LeafFeastTypes.END || state.getValue(LEAF_FEAST_TYPE) == LeafFeastTypes.TIP) {
                    newState = newState.setValue(LEAF_FEAST_TYPE, LeafFeastTypes.MIDDLE);
                }
            }
            if (level.setBlock(pos, newState, 3)) {
                if (!player.getAbilities().instabuild) {
                    itemStack.split(1);
                    ItemStack container = ItemStackUtil.getContainer(itemStack);
                    if (!container.isEmpty()) {
//                        spawnContainer(level, pos, player.getDirection().getOpposite(), container);
                        if (!player.getInventory().add(container)) {
                            player.drop(container, false);
                        }
                    }
                }
                playAddSound(level, pos);
                LeafFeastBlock.triggerInsertAdvancement(player);
                return InteractionResult.SUCCESS;
            }

        }

        return InteractionResult.PASS; // is fail better here?
    }

    public static void tryEat(ItemStack itemStack, Level level, BlockPos pos, Player player) {
        ItemStack container = ItemStackUtil.getContainer(itemStack);
        if (!container.isEmpty()) {
            spawnContainer(level, pos, player.getDirection().getOpposite(), container);
        }
        player.eat(level, itemStack);
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

    public boolean addItemFromDispenser(ItemStack itemStack, ServerLevel level, BlockPos pos, BlockState state) {
        Block block = getLeafFeastBlock(itemStack);

        if (block != null && block != Blocks.AIR) {
            if (level.setBlock(pos, getTransformState(block, state).setValue(SERVINGS, 1), 3)) {
                playAddSound(level, pos);
                return true;
            }
        }

        return false;
    }

    public static Block getLeafFeastBlock(ItemStack itemStack) {
        if (itemStack.is(BuiltInRegistryUtil.getItem(UbesDelightItems.ENSAYMADA))) {
            return BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA);
        } else if (itemStack.is(BuiltInRegistryUtil.getItem(UbesDelightItems.ENSAYMADA_UBE))) {
            return BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE);
        } else if (itemStack.is(BuiltInRegistryUtil.getItem(UbesDelightItems.PANDESAL))) {
            return BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST_PANDESAL);
        } else if (itemStack.is(BuiltInRegistryUtil.getItem(UbesDelightItems.PANDESAL_UBE))) {
            return BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE);
        } else if (itemStack.is(BuiltInRegistryUtil.getItem(UbesDelightItems.HOPIA_MUNGGO))) {
            return BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO);
        } else if (itemStack.is(BuiltInRegistryUtil.getItem(UbesDelightItems.HOPIA_UBE))) {
            return BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE);
        } else if (itemStack.is(BuiltInRegistryUtil.getItem(UbesDelightItems.LUMPIA))) {
            return BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LUMPIA_FEAST);
        } else if (itemStack.is(BuiltInRegistries.ITEM.get(new ResourceLocation("farmersdelight", "cooked_rice")))) {
            return BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST_COOKED_RICE);
        } else if (itemStack.is(BuiltInRegistries.ITEM.get(new ResourceLocation("farmersdelight", "fried_rice")))) {
            return BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST_FRIED_RICE);
        } else if (itemStack.is(BuiltInRegistryUtil.getItem(UbesDelightItems.SINANGAG))) {
            return BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST_SINANGAG);
        }
        return Blocks.AIR;
    }

    protected InteractionResult tryRemoveItem(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand) {
        // Not sure if needed
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        LeafFeastTypes leafFeastType = state.getValue(LEAF_FEAST_TYPE);

        return Shapes.or(this.getConnectShape(leafFeastType, getConnectDirections(facing.getOpposite()), CONNECT_SHAPES), this.getBaseShape(leafFeastType, facing, TIP_SHAPES, END_SHAPES, LEAF_BASE_SHAPE));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluid = context.getLevel().getFluidState(blockPos);
        BlockGetter blockGetter = context.getLevel();
        BlockState originBlockState = blockGetter.getBlockState(blockPos); // todo - keep for testing, remove on final cleanup
        Direction facing = context.getHorizontalDirection();
        Pair<Direction, Direction> connectDirections = getConnectDirections(facing.getOpposite());
        BlockState rightBlockState = blockGetter.getBlockState(blockPos.relative(connectDirections.getSecond()));
        BlockState leftBlockState = blockGetter.getBlockState(blockPos.relative(connectDirections.getFirst()));

//        LeafFeastTypes leafFeastType = getLeafFeastType(leftBlockState.getBlock() instanceof LeafFeastBlock, rightBlockState.getBlock() instanceof LeafFeastBlock);
        LeafFeastTypes leafFeastType = getLeafFeastType(placementConnectsTo(facing, leftBlockState), placementConnectsTo(facing, rightBlockState));


        return this.defaultBlockState().setValue(FACING, facing).setValue(LEAF_FEAST_TYPE, leafFeastType).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

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

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, SERVINGS, LEAF_FEAST_TYPE);
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
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }
}
