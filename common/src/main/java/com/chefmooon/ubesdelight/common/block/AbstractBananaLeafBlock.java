package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.UbesDelight;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

import static com.chefmooon.ubesdelight.common.utility.VoxelShapeUtil.rotateVoxelShape;

// todo - change the whole thing. Multipart Model needed
public class AbstractBananaLeafBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final Direction[] DIRECTIONS = { Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final VoxelShape BANANA_LEAF_SHAPE = Block.box(1,0,1,15,1,15);
    private static final VoxelShape BANANA_NORTH_CONNECT = Block.box(1,0, 0,15,1,1);
    private static final VoxelShape BANANA_EAST_CONNECT = rotateVoxelShape(BANANA_NORTH_CONNECT, Direction.EAST);
    private static final VoxelShape BANANA_SOUTH_CONNECT = rotateVoxelShape(BANANA_NORTH_CONNECT, Direction.SOUTH);
    private static final VoxelShape BANANA_WEST_CONNECT = rotateVoxelShape(BANANA_NORTH_CONNECT, Direction.WEST);

    private final Object2IntMap<BlockState> stateToIndex = new Object2IntOpenHashMap();
    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = (Map)PipeBlock.PROPERTY_BY_DIRECTION.entrySet().stream().filter((entry) -> {
        return ((Direction)entry.getKey()).getAxis().isHorizontal();
    }).collect(Util.toMap());
    public AbstractBananaLeafBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        UbesDelight.LOGGER.info(state.getValue(FACING).getName());

        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction facing = state.getValue(FACING);

        VoxelShape shape = BANANA_LEAF_SHAPE;

        if (facing == Direction.NORTH || facing == Direction.SOUTH) {
            if (state.getValue(EAST)) {
                shape = Shapes.or(shape, BANANA_EAST_CONNECT);
            }
            if (state.getValue(WEST)) {
                shape = Shapes.or(shape, BANANA_WEST_CONNECT);
            }
        } else if (facing == Direction.EAST || facing == Direction.WEST) {
            if (state.getValue(NORTH)) {
                shape = Shapes.or(shape, BANANA_NORTH_CONNECT);
            }
            if (state.getValue(SOUTH)) {
                shape = Shapes.or(shape, BANANA_SOUTH_CONNECT);
            }
        }

        return shape;
    }

    protected VoxelShape[] makeShapes(float nodeWidth, float extensionWidth, float nodeHeight, float extensionBottom, float extensionHeight) {
        float f = 8.0F - nodeWidth;
        float g = 8.0F + nodeWidth;
        float h = 8.0F - extensionWidth;
        float i = 8.0F + extensionWidth;

        VoxelShape voxelShape = Block.box((double)f, 0.0, (double)f, (double)g, (double)nodeHeight, (double)g);
        VoxelShape voxelShape2 = Block.box((double)h, (double)extensionBottom, 0.0, (double)i, (double)extensionHeight, (double)i);
        VoxelShape voxelShape3 = Block.box(0.0, (double)extensionBottom, (double)h, 16.0, (double)extensionHeight, (double)i);

        VoxelShape[] voxelShapes = new VoxelShape[]{Shapes.empty(), voxelShape3, voxelShape, Shapes.or(voxelShape, voxelShape3)
        };

        for (int j = 0; j < 4; ++j) {
            voxelShapes[j] = Shapes.or(voxelShape2, voxelShapes[j]);
        }

        return voxelShapes;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, NORTH, EAST, WEST, SOUTH);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockGetter blockGetter = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockPos blockPos2 = blockPos.north();
        BlockPos blockPos3 = blockPos.east();
        BlockPos blockPos4 = blockPos.south();
        BlockPos blockPos5 = blockPos.west();
        BlockState blockState = blockGetter.getBlockState(blockPos2);
        BlockState blockState2 = blockGetter.getBlockState(blockPos3);
        BlockState blockState3 = blockGetter.getBlockState(blockPos4);
        BlockState blockState4 = blockGetter.getBlockState(blockPos5);
        return (BlockState)((BlockState)((BlockState)((BlockState)((BlockState)super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(NORTH, this.connectsTo(blockState, blockState.isFaceSturdy(blockGetter, blockPos2, Direction.SOUTH), Direction.SOUTH))).setValue(EAST, this.connectsTo(blockState2, blockState2.isFaceSturdy(blockGetter, blockPos3, Direction.WEST), Direction.WEST))).setValue(SOUTH, this.connectsTo(blockState3, blockState3.isFaceSturdy(blockGetter, blockPos4, Direction.NORTH), Direction.NORTH))).setValue(WEST, this.connectsTo(blockState4, blockState4.isFaceSturdy(blockGetter, blockPos5, Direction.EAST), Direction.EAST)));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {

        return direction.getAxis().getPlane() == Direction.Plane.HORIZONTAL ? (BlockState)state.setValue((Property)PROPERTY_BY_DIRECTION.get(direction), this.connectsTo(neighborState, neighborState.isFaceSturdy(level, neighborPos, direction.getOpposite()), direction.getOpposite())) : super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    public boolean connectsTo(BlockState state, Direction direction) {
        Block block = state.getBlock();
        return block instanceof AbstractBananaLeafBlock;
    }

    public boolean connectsTo(BlockState state, boolean isSideSolid, Direction direction) {
        Block block = state.getBlock();
        return block instanceof AbstractBananaLeafBlock;
    }

    private static int indexFor(Direction facing) {
        return 1 << facing.get2DDataValue();
    }

    protected int getAABBIndex(BlockState state) {
        return this.stateToIndex.computeIntIfAbsent(state, (arg) -> {
            int i = 0;
            if ((Boolean)arg.getValue(NORTH)) {
                i |= indexFor(Direction.NORTH);
            }

            if ((Boolean)arg.getValue(EAST)) {
                i |= indexFor(Direction.EAST);
            }

            if ((Boolean)arg.getValue(SOUTH)) {
                i |= indexFor(Direction.SOUTH);
            }

            if ((Boolean)arg.getValue(WEST)) {
                i |= indexFor(Direction.WEST);
            }

            return i;
        });
    }
}
