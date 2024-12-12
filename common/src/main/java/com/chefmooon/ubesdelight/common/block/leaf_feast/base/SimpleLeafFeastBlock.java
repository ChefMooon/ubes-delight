package com.chefmooon.ubesdelight.common.block.leaf_feast.base;

import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import com.chefmooon.ubesdelight.common.registry.UbesDelightDataComponentTypes;
import com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import static com.chefmooon.ubesdelight.common.utility.VoxelShapeUtil.getRotatedShapes;

public class SimpleLeafFeastBlock extends BaseLeafFeastBlock {
    public Supplier<Item> servingItem;
    protected final ConcurrentHashMap<LeafFeastTypes, ConcurrentHashMap<Integer, VoxelShape[]>> FEAST_VARIANTS_SERVINGS;

    public SimpleLeafFeastBlock(Supplier<Item> servingItem, Properties properties, ConcurrentHashMap<LeafFeastTypes, ConcurrentHashMap<Integer, VoxelShape>> voxelShapes) {
        super(properties);
        this.servingItem = servingItem;
        this.FEAST_VARIANTS_SERVINGS = getRotatedShapes(voxelShapes);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE).setValue(FACING, Direction.NORTH).setValue(SERVINGS, MAX_SERVINGS));
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (level.isClientSide()) {
            if (heldItem.isEmpty()) {
                if (tryRemoveItem(state, level, pos, player, hand).consumesAction()) {
                    return ItemInteractionResult.SUCCESS;
                }
            } else {
                if (tryAddItem(state, level, pos, player, hand).consumesAction()) {
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }

        if (heldItem.isEmpty()) {
            return tryRemoveItem(state, level, pos, player, hand);
        } else {
            return tryAddItem(state, level, pos, player, hand);
        }

//        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected ItemInteractionResult tryAddItem(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand) {
        int servings = state.getValue(SERVINGS);

        if (servings < MAX_SERVINGS) {
            ItemStack heldItem = player.getItemInHand(hand);
            if (heldItem.is(servingItem.get())) {
                if (state.getValue(LEAF_FEAST_TYPE).getId() == 1 || state.getValue(LEAF_FEAST_TYPE).getId() == 3) {
                    if (servings >= 3) return ItemInteractionResult.FAIL;
                }
                level.setBlock(pos, state.setValue(SERVINGS, servings + 1), 3);
                if (!player.getAbilities().instabuild) {
                    heldItem.split(1);
                    //spawnContainer(level, pos, state.getValue(FACING), heldItem); // todo - add and test when rice is added
                }
                playAddSound(level, pos);
                return ItemInteractionResult.SUCCESS;
            }
        }

        return ItemInteractionResult.FAIL;
    }

    @Override
    public boolean addItemFromDispenser(ItemStack itemStack, ServerLevel level, BlockPos pos, BlockState state) {
        int servings = state.getValue(SERVINGS);

        if (servings < MAX_SERVINGS) {
            level.setBlock(pos, state.setValue(SERVINGS, servings + 1), 3);
            playAddSound(level, pos);
            return true;
        }
        return false;
    }

    protected ItemInteractionResult tryRemoveItem(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand) {
        int servings = state.getValue(SERVINGS);
        ItemStack itemStack = new ItemStack(servingItem.get());

        if (servings > 1) {
            level.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3);
            playRemoveSound(level, pos);
            if (!player.isCreative()) {
                if (!player.getInventory().add(itemStack)) {
                    player.drop(itemStack, false);
                }
            }
            return ItemInteractionResult.SUCCESS;
        } else if (servings == 1) {
            Block block = BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST);
            level.setBlock(pos, getTransformState(block, state), 3);
            level.updateNeighbourForOutputSignal(pos, block);
            playRemoveSound(level, pos);
            if (!player.isCreative()) {
                if (!player.getInventory().add(itemStack)) {
                    player.drop(itemStack, false);
                }
            }
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.FAIL;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        LeafFeastTypes leafFeastType = state.getValue(LEAF_FEAST_TYPE);
        int servings = state.getValue(SERVINGS);
        Direction facing = state.getValue(FACING);

        if (leafFeastType == LeafFeastTypes.BASE) {
            leafFeastType = LeafFeastTypes.MIDDLE;
        }

        VoxelShape servingShape = Shapes.empty();
        if (FEAST_VARIANTS_SERVINGS.containsKey(leafFeastType)) {
            if (FEAST_VARIANTS_SERVINGS.get(leafFeastType).containsKey(servings)) {
                servingShape = FEAST_VARIANTS_SERVINGS.get(leafFeastType).get(servings)[facing.get2DDataValue()];
            }
        }

        if (servingShape != null) {
            return Shapes.or(super.getShape(state, level, pos, context), servingShape);
        } else {
            return super.getShape(state, level, pos, context);
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        FluidState fluid = context.getLevel().getFluidState(blockPos);
        BlockGetter blockGetter = context.getLevel();
        Direction facing = context.getHorizontalDirection();
        Pair<Direction, Direction> connectDirections = getConnectDirections(facing.getOpposite());
        BlockState rightBlockState = blockGetter.getBlockState(blockPos.relative(connectDirections.getSecond()));
        BlockState leftBlockState = blockGetter.getBlockState(blockPos.relative(connectDirections.getFirst()));

        int servings = context.getItemInHand().has(BuiltInRegistries.DATA_COMPONENT_TYPE.get(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS))
                ? context.getItemInHand().get((DataComponentType<Integer>) BuiltInRegistries.DATA_COMPONENT_TYPE.get(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS))
                : MAX_SERVINGS;
        LeafFeastTypes leafFeastType = servings > 3
                ? placementConnectsTo(facing, leftBlockState) || placementConnectsTo(facing, rightBlockState) ? LeafFeastTypes.MIDDLE : LeafFeastTypes.BASE
                : getLeafFeastType(placementConnectsTo(facing, leftBlockState), placementConnectsTo(facing, rightBlockState));

        return this.defaultBlockState().setValue(FACING, facing).setValue(LEAF_FEAST_TYPE, leafFeastType).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return getOutputSignal((Integer)state.getValue(SERVINGS));
    }

    public static int getOutputSignal(int servings) {
        return servings * 2;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}
