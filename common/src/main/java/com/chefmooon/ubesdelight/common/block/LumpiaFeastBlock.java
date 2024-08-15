package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.registry.UbesDelightSounds;
import com.chefmooon.ubesdelight.common.utility.TagUtils;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

import static com.chefmooon.ubesdelight.common.utility.VoxelShapeUtil.rotateVoxelShapes;

public class LumpiaFeastBlock extends Block {
    // todo - upgrade to extend LeafFeastSimpleUniversalBlock?
    public static final int MAX_SERVINGS = 3;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, MAX_SERVINGS);
    public final Supplier<Item> servingItem;

    private static final VoxelShape BANANA_LEAF_SHAPE = Block.box(1,0,1,15,1,15);

    private static final VoxelShape[] LUMPIA_SERVINGS = new VoxelShape[] {
            Block.box(2,1,2,14,5,6),
            Block.box(2,1,6,14,5,10),
            Block.box(2,1,10,14,5,14),
            Block.box(2,5,2,14,9,6),
            Block.box(2,5,6,14,9,10),
            Block.box(2,5,10,14,9,14),
    };
    private static final VoxelShape LUMPIA_SERVING_1_OF_3 = Shapes.join(LUMPIA_SERVINGS[0], LUMPIA_SERVINGS[1], BooleanOp.OR);
    private static final VoxelShape LUMPIA_SERVING_2_OF_3 = Shapes.or(LUMPIA_SERVING_1_OF_3, LUMPIA_SERVINGS[2], LUMPIA_SERVINGS[3]);
    private static final VoxelShape LUMPIA_SERVING_3_OF_3 = Shapes.or(LUMPIA_SERVING_2_OF_3, LUMPIA_SERVINGS[4], LUMPIA_SERVINGS[5]);
    private static final VoxelShape[] SHAPES_NORTH = new VoxelShape[] {BANANA_LEAF_SHAPE,
            Shapes.join(BANANA_LEAF_SHAPE, LUMPIA_SERVING_1_OF_3, BooleanOp.OR),
            Shapes.join(BANANA_LEAF_SHAPE, LUMPIA_SERVING_2_OF_3, BooleanOp.OR),
            Shapes.join(BANANA_LEAF_SHAPE, LUMPIA_SERVING_3_OF_3, BooleanOp.OR)
    };
    private static final VoxelShape[] SHAPES_EAST = rotateVoxelShapes(SHAPES_NORTH, Direction.EAST);
    private static final VoxelShape[] SHAPES_SOUTH = rotateVoxelShapes(SHAPES_NORTH, Direction.SOUTH);
    private static final VoxelShape[] SHAPES_WEST = rotateVoxelShapes(SHAPES_NORTH, Direction.WEST);

    public LumpiaFeastBlock(Supplier<Item> servingItem) {
        super(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL));
        this.servingItem = servingItem;
        this.registerDefaultState(this.stateDefinition.any().setValue(SERVINGS, MAX_SERVINGS));
    }

    public IntegerProperty getServingsProperty() {
        return SERVINGS;
    }

    public int getMaxServings() {
        return MAX_SERVINGS;
    }

    public ItemStack getServingItem() {
        return new ItemStack(servingItem.get());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int servings = state.getValue(SERVINGS);

        return switch (state.getValue(FACING)) {
            case EAST -> SHAPES_EAST[servings];
            case SOUTH -> SHAPES_SOUTH[servings];
            case WEST -> SHAPES_WEST[servings];
            default -> SHAPES_NORTH[servings];
        };
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide()) {
            if (this.takeServing(level, pos, state, player, hand).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
        }

        return this.takeServing(level, pos, state, player, hand);
    }

    protected InteractionResult takeServing(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getServingsProperty());

        ItemStack serving = getServingItem();
        serving.setCount(2);

        if (servings > 0 ) {
            if (player.getMainHandItem().is(TagUtils.getKifeItemTag())) {
                level.setBlock(pos, state.setValue(getServingsProperty(), servings - 1), 3);
                level.playSound(null, pos, UbesDelightSounds.BLOCK_LUMPIA_FEAST_REMOVE.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
                if (!player.getInventory().add(serving)) {
                    player.drop(serving, false);
                }
                return InteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(TextUtils.getTranslatable("tooltip.knife"), true);
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
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
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
