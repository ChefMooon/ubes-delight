package com.chefmooon.ubesdelight.common.block.leaf_feast.base;

import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

import static com.chefmooon.ubesdelight.common.utility.VoxelShapeUtil.getRotatedShapes;

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
        builder.add(WATERLOGGED, FACING, LEAF_FEAST_TYPE, SERVINGS);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return Objects.requireNonNull(BuiltInRegistries.BLOCK_ENTITY_TYPE.get(UbesDelightBlockEntityTypes.UNIVERSAL_LEAF_FEAST)).create(pos, state);
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
}
