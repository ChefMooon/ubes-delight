package com.chefmoon.ubesdelight.block;

import com.chefmoon.ubesdelight.tag.CommonTags;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
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

public class GlassCupBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    protected static final VoxelShape CUP_RIM = Block.createCuboidShape(1.d, 7.d, 1.d, 8.d, 8.d, 8.d);
    protected static final VoxelShape CUP_NORTH = VoxelShapes.combine(CUP_RIM, Block.createCuboidShape(2.d, .0d, 2.d, 7.d, 7.d, 7.d), BooleanBiFunction.OR);
    protected static final VoxelShape CUP_RIM_EAST = Block.createCuboidShape(8.d, 7.d, 1.d, 15.d, 8.d, 8.d);
    protected static final VoxelShape CUP_EAST = VoxelShapes.combine(CUP_RIM_EAST, Block.createCuboidShape(9.d, .0d, 2.d, 14.d, 7.d, 7.d), BooleanBiFunction.OR);
    protected static final VoxelShape CUP_RIM_SOUTH = Block.createCuboidShape(8.d, 7.d, 8.d, 15.d, 8.d, 15.d);
    protected static final VoxelShape CUP_SOUTH = VoxelShapes.combine(CUP_RIM_SOUTH, Block.createCuboidShape(9.d, .0d, 9.d, 14.d, 7.d, 14.d), BooleanBiFunction.OR);
    protected static final VoxelShape CUP_RIM_WEST = Block.createCuboidShape(1.d, 7.d, 8.d, 8.d, 8.d, 15.d);
    protected static final VoxelShape CUP_WEST = VoxelShapes.combine(CUP_RIM_WEST, Block.createCuboidShape(2.d, .0d, 9.d, 7.d, 7.d, 14.d), BooleanBiFunction.OR);
    // Surely there is a better way to do the above ... right?
    public GlassCupBlock() {
        super(FabricBlockSettings.copyOf(Blocks.GLASS).luminance(4));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getDefaultState().with(FACING, context.getHorizontalPlayerFacing());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient() && rotate(world, pos, state, player, hand).isAccepted()) {
            return ActionResult.SUCCESS;
        }

        return rotate(world, pos, state, player, hand);
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
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(FACING) == Direction.EAST) {
            return CUP_EAST;
        } else if (state.get(FACING) == Direction.SOUTH) {
            return CUP_SOUTH;
        } else if (state.get(FACING) == Direction.WEST) {
            return CUP_WEST;
        } else {
            return CUP_NORTH;
        }
    }

    protected ActionResult rotate(World world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand) {
        ItemStack heldItem = player.getStackInHand(hand);
        Direction direction = state.get(FACING);

        // Does this matter? will not rotate if player is inside of block
        if (player.getPos().distanceTo(pos.toCenterPos()) < 1) {
            return ActionResult.FAIL;
        }

        if (heldItem.isIn(CommonTags.C_TOOLS_KNIVES)) {
            if (direction == Direction.NORTH) {
                world.setBlockState(pos, state.with(FACING, Direction.EAST), 3);
            } else if (direction == Direction.EAST) {
                world.setBlockState(pos, state.with(FACING, Direction.SOUTH), 3);
            } else if (direction == Direction.SOUTH) {
                world.setBlockState(pos, state.with(FACING, Direction.WEST), 3);
            } else {
                world.setBlockState(pos, state.with(FACING, Direction.NORTH), 3);
            }
        } else {
            return ActionResult.FAIL;
        }

        return ActionResult.SUCCESS;
    }
}
