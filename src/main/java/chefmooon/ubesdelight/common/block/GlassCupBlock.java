package chefmooon.ubesdelight.common.block;

import chefmooon.ubesdelight.common.registry.UbesDelightShapes;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.utility.VoxelShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class GlassCupBlock extends Block {
    public static final int MAX_SERVINGS = 3;
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, MAX_SERVINGS);

    public static final Property<Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public Supplier<Item> servingItem;
    protected final ConcurrentHashMap<Integer, VoxelShape[]> CUP_SHAPES;

    public GlassCupBlock(Supplier<Item> servingItem, Properties properties) {
        super(properties);
        this.servingItem = servingItem;
        CUP_SHAPES = buildShapes();
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(SERVINGS, 0));
    }

    private static ConcurrentHashMap<Integer, VoxelShape[]> buildShapes() {
        ConcurrentHashMap<Integer, VoxelShape[]> result = new ConcurrentHashMap<>();

        result.put(0, VoxelShapeUtil.getRotatedShapes(UbesDelightShapes.CUP_NORTH_SERVINGS_1));
        result.put(1, VoxelShapeUtil.getRotatedShapes(UbesDelightShapes.CUP_NORTH_SERVINGS_2));
        result.put(2, VoxelShapeUtil.getRotatedShapes(UbesDelightShapes.CUP_NORTH_SERVINGS_3));
        result.put(3, VoxelShapeUtil.getRotatedShapes(UbesDelightShapes.CUP_NORTH_SERVINGS_4));

        return result;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public InteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

        if (level.isClientSide()) {
            if (heldStack.is(CommonTags.C_TOOLS)) {
                return rotate(level, pos, state, player);
            } else if (heldStack.is(servingItem.get())) {
                return addServingFromHand(level, pos, state, player, hand);
            } else if (heldStack.isEmpty()) {
                return removeServingToHand(level, pos, state, player, hand);
            }
        }

        if (heldStack.is(CommonTags.C_TOOLS)) {
            return rotate(level, pos, state, player);
        } else if (heldStack.is(servingItem.get())) {
            return addServingFromHand(level, pos, state, player, hand);
        } else if (heldStack.isEmpty()) {
            return removeServingToHand(level, pos, state, player, hand);
        }

        return InteractionResult.FAIL;
    }

    @Override
    public BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, RandomSource random) {
        return direction == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, level, scheduledTickAccess, pos, direction, neighborPos, neighborState, random);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, SERVINGS);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int servings = state.getValue(SERVINGS);
        return CUP_SHAPES.containsKey(servings) ? CUP_SHAPES.get(servings)[state.getValue(FACING).get2DDataValue()] : Shapes.empty();
    }

    protected InteractionResult rotate(Level level, BlockPos pos, BlockState state, Player player) {
        if (player.getBoundingBox().distanceToSqr(pos.getBottomCenter()) < 0.5) return InteractionResult.CONSUME;

        if (level.setBlock(pos, state.setValue(FACING, state.getValue(FACING).getClockWise()), 3)) return InteractionResult.SUCCESS;

        return InteractionResult.PASS;
    }

    public InteractionResult addServingFromHand(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(SERVINGS);

        if (servings < MAX_SERVINGS) {
            ItemStack heldItem = player.getItemInHand(hand);
            level.setBlock(pos, state.setValue(SERVINGS, servings + 1), 3);
            level.playSound(player, pos, SoundEvents.GLASS_PLACE, SoundSource.BLOCKS, 0.8F, 0.6F);
            if (!player.isCreative()) {
                heldItem.shrink(1);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    protected InteractionResult removeServingToHand(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(SERVINGS);
        ItemStack servingItem = new ItemStack(this.servingItem.get());

        if (servings == 0) {
            level.removeBlock(pos, false);
            level.playSound(player, pos, SoundEvents.GLASS_PLACE, SoundSource.BLOCKS, 0.8F, 0.8F);
            if (!player.isCreative()) {
                if (!player.getInventory().add(servingItem)) {
                    player.drop(servingItem, false);
                }
            }
            return InteractionResult.SUCCESS;
        } else if (servings > 0) {
            level.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3);
            level.playSound(player, pos, SoundEvents.GLASS_PLACE, SoundSource.BLOCKS, 0.8F, 0.8F);
            if (!player.isCreative()) {
                if (!player.getInventory().add(servingItem)) {
                    player.drop(servingItem, false);
                }
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
