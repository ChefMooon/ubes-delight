package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.utility.TagUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GlassCupBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape CUP_NORTH = Shapes.or(
            Block.box(1.d, 7.d, 1.d, 8.d, 8.d, 8.d),
            Block.box(2.d, .0d, 2.d, 7.d, 7.d, 7.d));
    protected static final VoxelShape CUP_EAST = Shapes.or(
            Block.box(8.d, 7.d, 1.d, 15.d, 8.d, 8.d),
            Block.box(9.d, .0d, 2.d, 14.d, 7.d, 7.d));
    protected static final VoxelShape CUP_SOUTH = Shapes.or(
            Block.box(8.d, 7.d, 8.d, 15.d, 8.d, 15.d),
            Block.box(9.d, .0d, 9.d, 14.d, 7.d, 14.d));
    protected static final VoxelShape CUP_WEST = Shapes.or(
            Block.box(1.d, 7.d, 8.d, 8.d, 8.d, 15.d),
            Block.box(2.d, .0d, 9.d, 7.d, 7.d, 14.d));
    // todo - 0.2.1 - use VoxelShapeUtil getRotatedShapes
    protected final VoxelShape[] SHAPES = new VoxelShape[]{CUP_SOUTH, CUP_WEST, CUP_NORTH, CUP_EAST};
    public GlassCupBlock() {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(value -> 4));
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (heldStack.is(TagUtils.getKifeItemTag())) {
            return rotate(level, pos, state, player);
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
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
        return SHAPES[state.getValue(FACING).get2DDataValue()];
    }

    protected ItemInteractionResult rotate(Level level, BlockPos pos, BlockState state, Player player) {
        if (player.getBoundingBox().distanceToSqr(pos.getCenter()) < 0.5) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        if (level.setBlock(pos, state.setValue(FACING, state.getValue(FACING).getClockWise()), 3)) return ItemInteractionResult.SUCCESS;

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
