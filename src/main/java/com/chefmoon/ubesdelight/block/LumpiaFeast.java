package com.chefmoon.ubesdelight.block;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.SoundsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class LumpiaFeast extends Block {

    public static final int MAX_SERVINGS = 3;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty SERVINGS = IntProperty.of("servings", 0, MAX_SERVINGS);
    public final Item servingItem;

    private static final VoxelShape BANANA_LEAF_SHAPE = Block.createCuboidShape(1,0,1,15,1,15);
    private static final VoxelShape LUMPIA_SHAPE = Block.createCuboidShape(2,1,2,14,9,14);
    private static final VoxelShape LUMPIA_FEAST = VoxelShapes.combine(BANANA_LEAF_SHAPE, LUMPIA_SHAPE, BooleanBiFunction.OR);
    private static final VoxelShape[] SHAPES = new VoxelShape[] {
            Block.createCuboidShape(2,1,2,14,5,6),
            Block.createCuboidShape(2,1,6,14,5,10),
            Block.createCuboidShape(2,1,10,14,5,14),
            Block.createCuboidShape(2,5,2,14,9,6),
            Block.createCuboidShape(2,5,6,14,9,10),
            Block.createCuboidShape(2,5,10,14,9,14),
    };

    public LumpiaFeast(Item servingItem) {
        super(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL));
        this.servingItem = servingItem;
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(SERVINGS, MAX_SERVINGS));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);

        if (player.getMainHandStack().isIn(CommonTags.C_TOOLS_KNIVES)) {
            LumpiaFeast lumpiaFeast = (LumpiaFeast) state.getBlock();
            ItemStack servingItem = lumpiaFeast.getServingStack(state);
            if (state.get(LumpiaFeast.SERVINGS) > 0) {
                servingItem.setCount(2*state.get(LumpiaFeast.SERVINGS));
                ItemScatterer.spawn(world, pos, DefaultedList.ofSize(1, servingItem));
            }
        }
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient() && takeServing(world, pos, state, player, hand).isAccepted()) {
            return ActionResult.SUCCESS;
        }

        return takeServing(world, pos, state, player, hand);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return state.get(SERVINGS) == 0 ? BANANA_LEAF_SHAPE : LUMPIA_FEAST;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(getServingsProperty());
    }

    public IntProperty getServingsProperty() {
        return SERVINGS;
    }

    public ItemStack getServingStack(BlockState state) {
        return new ItemStack(servingItem);
    }

    @SuppressWarnings("ConstantConditions")
    private ActionResult takeServing(World world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand) {
        int servings = state.get(getServingsProperty());

        ItemStack serving = getServingStack(state);
        serving.setCount(2);

        if (servings > 0) {
            if (player.getMainHandStack().isIn(CommonTags.C_TOOLS_KNIVES)) {
                world.setBlockState(pos, state.with(getServingsProperty(), servings - 1), 3);
                world.playSound(null, pos, SoundsRegistry.BLOCK_LUMPIA_FEAST_REMOVE.get(), SoundCategory.BLOCKS, 1.f, 1.f);
                if (!player.getInventory().insertStack(serving)) {
                    player.dropItem(serving, false);
                }

                return ActionResult.SUCCESS;
            } else {
                if (world.isClient()) {
                    player.sendMessage(UbesDelightMod.tooltip("tooltip.knife"), true);
                }
            }
        }

        return ActionResult.PASS;
    }
}
