package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import com.chefmooon.ubesdelight.common.registry.UbesDelightItems;
import com.chefmooon.ubesdelight.common.registry.UbesDelightShapes;
import com.chefmooon.ubesdelight.common.registry.UbesDelightSounds;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil;
import com.chefmooon.ubesdelight.common.utility.LeafFeastUtil;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

import static com.chefmooon.ubesdelight.common.utility.VoxelShapeUtil.getRotatedShapes;

public class LeafFeastSimpleBlock extends Block implements SimpleWaterloggedBlock {
    public Supplier<Item> servingItem;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty RIGHT_CONNECT = BooleanProperty.create("right_connect");
    public static final BooleanProperty LEFT_CONNECT = BooleanProperty.create("left_connect");

    public static final VoxelShape LEAF_BASE_SHAPE = UbesDelightShapes.LEAF_BASE_SHAPE;
    private static final VoxelShape NORTH_CONNECT_SHAPE = UbesDelightShapes.NORTH_CONNECT_SHAPE;
    private static final VoxelShape LEAF_NORTH_TIP_SHAPE = UbesDelightShapes.LEAF_NORTH_TIP_SHAPE;
    private static final VoxelShape LEAF_NORTH_END_SHAPE = UbesDelightShapes.LEAF_NORTH_END_SHAPE;
    private final VoxelShape[] CONNECT_SHAPES;
    private final VoxelShape[] TIP_SHAPES;
    private final VoxelShape[] END_SHAPES;
    public LeafFeastSimpleBlock(Properties properties) {
        this(null, properties);
    }

    public LeafFeastSimpleBlock(Supplier<Item> servingItem, Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(RIGHT_CONNECT, false).setValue(LEFT_CONNECT, false).setValue(WATERLOGGED, false));
        this.servingItem = servingItem;
        this.CONNECT_SHAPES = getRotatedShapes(NORTH_CONNECT_SHAPE);
        this.TIP_SHAPES = getRotatedShapes(LEAF_NORTH_TIP_SHAPE);
        this.END_SHAPES = getRotatedShapes(LEAF_NORTH_END_SHAPE);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (level.isClientSide()) {
            if (heldItem.is(CommonTags.C_TOOLS_ROLLING_PINS)) {
                level.setBlock(pos, LeafFeastUtil.getNextState(state), 3);
            } else if (heldItem.isEmpty()) {
                if (tryRemoveItem(state, level, pos, player, hand).consumesAction()) return InteractionResult.SUCCESS;
            } else {
                if (tryAddItem(state, level, pos, player, hand).consumesAction()) return InteractionResult.SUCCESS;
            }
        }

        if (heldItem.is(CommonTags.C_TOOLS_ROLLING_PINS)) {
            level.setBlock(pos, LeafFeastUtil.getNextState(state), 3);
        } else if (heldItem.isEmpty()) {
            if (tryRemoveItem(state, level, pos, player, hand).consumesAction()) return InteractionResult.SUCCESS;
        } else {
            if (tryAddItem(state, level, pos, player, hand).consumesAction()) return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);
        Boolean rightConnect = state.getValue(RIGHT_CONNECT);
        Boolean leftConnect = state.getValue(LEFT_CONNECT);

        return Shapes.or(this.getConnectShape(rightConnect, leftConnect, getConnectDirections(facing.getOpposite())), this.getBaseShape(rightConnect, leftConnect, facing));
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

        return this.defaultBlockState().setValue(FACING, facing).setValue(RIGHT_CONNECT, this.connectsTo(originBlockState, rightBlockState)).setValue(LEFT_CONNECT, this.connectsTo(originBlockState, leftBlockState)).setValue(WATERLOGGED, fluid.getType() == Fluids.WATER);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(WATERLOGGED)) level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));

        Pair<Direction, Direction> connectDirections = getConnectDirections(state.getValue(FACING).getOpposite());

        if (direction == connectDirections.getFirst() || direction == connectDirections.getSecond()) return state.setValue(RIGHT_CONNECT, this.connectsTo(state, level.getBlockState(pos.relative(connectDirections.getFirst())))).setValue(LEFT_CONNECT, this.connectsTo(state, level.getBlockState(pos.relative(connectDirections.getSecond()))));
        if (direction == Direction.DOWN && !state.canSurvive(level, pos)) return Blocks.AIR.defaultBlockState();

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, FACING, RIGHT_CONNECT, LEFT_CONNECT);
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

    public boolean connectsTo(BlockState originState, BlockState state) {
        if (validBlock(state) && validBlock(originState)) {
            return state.getValue(FACING) == originState.getValue(FACING);
        }
        return false;
    }

    private boolean validBlock(BlockState state) {
        return state.getBlock() instanceof LeafFeastSimpleBlock;
    }

    private VoxelShape getConnectShape(Boolean rightConnect, Boolean leftConnect, Pair<Direction, Direction> connectDirections) {
        VoxelShape shape = Shapes.empty();
        if (rightConnect) shape = Shapes.or(shape, this.CONNECT_SHAPES[connectDirections.getFirst().get2DDataValue()]);
        if (leftConnect) shape = Shapes.or(shape, this.CONNECT_SHAPES[connectDirections.getSecond().get2DDataValue()]);
        return shape;
    }

    private VoxelShape getBaseShape(Boolean rightConnect, Boolean leftConnect, Direction facing) {
        VoxelShape shape = Shapes.empty();
        if (rightConnect && !leftConnect) {
            shape = Shapes.or(shape, this.TIP_SHAPES[facing.get2DDataValue()]);
        } else if (leftConnect && !rightConnect) {
            shape = Shapes.or(shape, this.END_SHAPES[facing.get2DDataValue()]);
        } else {
            shape = Shapes.or(shape, LEAF_BASE_SHAPE);
        }
        return shape;
    }

    protected static Pair<Direction, Direction> getConnectDirections(Direction facing) {
        return Pair.of(facing.getClockWise(), facing.getClockWise().getOpposite());
    }

    protected InteractionResult tryAddItem(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (heldItem.is(BuiltInRegistryUtil.getItem(new ResourceLocation("farmersdelight", "cooked_rice")))) {
            return addItem(UbesDelightBlocks.LEAF_FEAST_RICE, state, level, pos);
        } else if (heldItem.is(BuiltInRegistryUtil.getItem(UbesDelightItems.SINANGAG))){
            return addItem(UbesDelightBlocks.LEAF_FEAST_RICE_GARLIC, state, level, pos);
        } else if (heldItem.is(BuiltInRegistryUtil.getItem(UbesDelightItems.ENSAYMADA))) {
            return addItem(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA, state, level, pos);
        } else if (heldItem.is(BuiltInRegistryUtil.getItem(UbesDelightItems.ENSAYMADA_UBE))) {
            return addItem(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE, state, level, pos);
        }

        return InteractionResult.FAIL;
    }

    private InteractionResult addItem(ResourceLocation block, BlockState state, Level level, BlockPos pos) {
        if (level.setBlock(pos, getTransformState(BuiltInRegistryUtil.getBlock(block), state), 3)) {
            level.playSound(null, pos, UbesDelightSounds.BLOCK_LEAF_FEAST_ADD.get(), SoundSource.PLAYERS, 0.6F, 0.75F);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS; // is fail better here?
    }

    protected InteractionResult tryRemoveItem(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (heldItem.isEmpty()) {
            if (state.getBlock() instanceof LeafFeastRiceBlock || state.getBlock() instanceof LeafFeastBreadBlock) {
                if (level.setBlock(pos, getTransformState(BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST), state), 3)) {
                    level.playSound(null, pos, UbesDelightSounds.BLOCK_LEAF_FEAST_REMOVE.get(), SoundSource.PLAYERS, 0.6F, 1.0F);
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return InteractionResult.FAIL;
    }

    protected BlockState getTransformState(Block block, BlockState state) {
        return block.defaultBlockState().setValue(FACING, state.getValue(FACING)).setValue(RIGHT_CONNECT, state.getValue(RIGHT_CONNECT)).setValue(LEFT_CONNECT, state.getValue(LEFT_CONNECT)).setValue(WATERLOGGED, state.getValue(WATERLOGGED));
    }
}
