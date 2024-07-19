package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.utility.TagUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GlassCupBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape CUP_RIM = Block.box(1.d, 7.d, 1.d, 8.d, 8.d, 8.d);
    protected static final VoxelShape CUP_NORTH = Shapes.join(CUP_RIM, Block.box(2.d, .0d, 2.d, 7.d, 7.d, 7.d), BooleanOp.OR);
    protected static final VoxelShape CUP_RIM_EAST = Block.box(8.d, 7.d, 1.d, 15.d, 8.d, 8.d);
    protected static final VoxelShape CUP_EAST = Shapes.join(CUP_RIM_EAST, Block.box(9.d, .0d, 2.d, 14.d, 7.d, 7.d), BooleanOp.OR);
    protected static final VoxelShape CUP_RIM_SOUTH = Block.box(8.d, 7.d, 8.d, 15.d, 8.d, 15.d);
    protected static final VoxelShape CUP_SOUTH = Shapes.join(CUP_RIM_SOUTH, Block.box(9.d, .0d, 9.d, 14.d, 7.d, 14.d), BooleanOp.OR);
    protected static final VoxelShape CUP_RIM_WEST = Block.box(1.d, 7.d, 8.d, 8.d, 8.d, 15.d);
    protected static final VoxelShape CUP_WEST = Shapes.join(CUP_RIM_WEST, Block.box(2.d, .0d, 9.d, 7.d, 7.d, 14.d), BooleanOp.OR);
    public GlassCupBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.GLASS).lightLevel(value -> 4));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);
        if (level.isClientSide()) {
            if (heldStack.is(TagUtils.getKifeItemTag())) {
                return rotate(level, pos, state, player);
            }
        }
        if (heldStack.is(TagUtils.getKifeItemTag())) {
            return rotate(level, pos, state, player);
        }
        return InteractionResult.PASS;
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (state.getValue(FACING) == Direction.EAST) {
            return CUP_EAST;
        } else if (state.getValue(FACING) == Direction.SOUTH) {
            return CUP_SOUTH;
        } else if (state.getValue(FACING) == Direction.WEST) {
            return CUP_WEST;
        } else {
            return CUP_NORTH;
        }
    }

    protected InteractionResult rotate(Level level, BlockPos pos, BlockState state, Player player) {
        Direction direction = state.getValue(FACING);

        if (player.getBoundingBox().distanceToSqr(pos.getCenter()) < 0.5) return InteractionResult.PASS;

        if (direction == Direction.NORTH) {
            level.setBlock(pos, state.setValue(FACING, Direction.EAST), 3);
        } else if (direction == Direction.EAST) {
            level.setBlock(pos, state.setValue(FACING, Direction.SOUTH), 3);
        } else if (direction == Direction.SOUTH) {
            level.setBlock(pos, state.setValue(FACING, Direction.WEST), 3);
        } else {
            level.setBlock(pos, state.setValue(FACING, Direction.NORTH), 3);
        }
        return InteractionResult.SUCCESS;
    }
}
