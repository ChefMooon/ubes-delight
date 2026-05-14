package chefmooon.ubesdelight.common.block.leaf_feast.base;

import chefmooon.ubesdelight.common.core.LeafFeastTypes;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.registry.UbesDelightDataComponentTypes;
import chefmooon.ubesdelight.common.utility.ItemStackUtil;
import chefmooon.ubesdelight.common.utility.TextUtils;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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

import static chefmooon.ubesdelight.common.utility.VoxelShapeUtil.getRotatedShapes;

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
            if (heldItem.isEmpty() || heldItem.is(Items.BOWL)) {
                if (tryRemoveItem(state, level, pos, player, hand).consumesAction()) {
                    return ItemInteractionResult.SUCCESS;
                }
            } else {
                if (tryAddItem(state, level, pos, player, hand).consumesAction()) {
                    return ItemInteractionResult.SUCCESS;
                }
            }
        }

        if (heldItem.isEmpty() || heldItem.is(Items.BOWL)) {
            return tryRemoveItem(state, level, pos, player, hand);
        } else {
            return tryAddItem(state, level, pos, player, hand);
        }
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
                    ItemStack itemStack = heldItem.split(1);
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
                return ItemInteractionResult.SUCCESS;
            }
        }

        return ItemInteractionResult.FAIL;
    }

    public static void tryEat(ItemStack itemStack, Level level, BlockPos pos, Player player) {
        player.eat(level, itemStack);
        LeafFeastBlock.triggerConsumeAdvancement(player);
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
        ItemStack heldItem = player.getItemInHand(hand);
        ItemStack container = ItemStackUtil.getContainer(itemStack);

        if (servings >= 1) {
            if (player.isShiftKeyDown() && heldItem.isEmpty() && player.canEat(itemStack.get(DataComponents.FOOD).canAlwaysEat())) {
                tryEat(itemStack, level, pos, player);
                return removeServing(state, level, pos, servings);
            } else {
                if (!container.isEmpty()) {
                    if (!container.is(player.getItemInHand(hand).getItem())) {
                        player.displayClientMessage(TextUtils.getTranslatable("container.bowl"), true);
                        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                    } else {
                        if (!player.isCreative()) heldItem.split(1);
                        if (!player.getInventory().add(itemStack)) {
                            player.drop(itemStack, false);
                        }
                        return removeServing(state, level, pos, servings);
                    }
                } else if (container.isEmpty() && !heldItem.isEmpty()) {
                    return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
                } else if (heldItem.isEmpty()) {
                    if (!player.isCreative()) {
                        if (!player.getInventory().add(itemStack)) {
                            player.drop(itemStack, false);
                        }
                    }
                    return removeServing(state, level, pos, servings);
                }
            }
        }

        return ItemInteractionResult.FAIL;
    }

    private ItemInteractionResult removeServing(BlockState state, Level level, BlockPos pos, int servings) {
        if (servings >= 1) {
            if (servings > 1) {
                level.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3);
            } else {
                Block block = UbesDelightBlocks.LEAF_FEAST.get();
                level.setBlock(pos, getTransformState(block, state), 3);
                level.updateNeighbourForOutputSignal(pos, block);
            }
            playRemoveSound(level, pos);
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.FAIL;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        LeafFeastTypes leafFeastType = state.getValue(LEAF_FEAST_TYPE);
        int servings = state.getValue(SERVINGS);
        Direction facing = state.getValue(FACING);

        if (leafFeastType == LeafFeastTypes.BASE && !FEAST_VARIANTS_SERVINGS.containsKey(leafFeastType)) {
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

        int servings = context.getItemInHand().has(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS)
                ? context.getItemInHand().get(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS)
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
