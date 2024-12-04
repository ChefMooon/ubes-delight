package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.UbesDelightShapes;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.utility.TagUtils;
import com.chefmooon.ubesdelight.common.utility.VoxelShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class GlassCupBlock extends Block {
    public static final int MAX_SERVINGS = 3;
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, MAX_SERVINGS);

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public Supplier<Item> servingItem;
    private final VoxelShape[] SHAPES_SERVINGS_1 = UbesDelightShapes.CUP_SHAPES_SERVINGS_1;

    private final VoxelShape[] SHAPES_SERVINGS_2 = UbesDelightShapes.CUP_SHAPES_SERVINGS_2;

    private final VoxelShape[] SHAPES_SERVINGS_3 = UbesDelightShapes.CUP_SHAPES_SERVINGS_3;

    private final VoxelShape[] SHAPES_SERVINGS_4 = UbesDelightShapes.CUP_SHAPES_SERVINGS_4;

    public GlassCupBlock(Supplier<Item> servingItem, Properties properties) {
        super(properties);
        this.servingItem = servingItem;
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(SERVINGS, 0));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {

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

        return ItemInteractionResult.FAIL;
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
        builder.add(FACING, SERVINGS);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int servings = state.getValue(SERVINGS);
        int facing = state.getValue(FACING).get2DDataValue();

        return switch (servings) {
            case 3 -> SHAPES_SERVINGS_4[facing];
            case 2 -> SHAPES_SERVINGS_3[facing];
            case 1 -> SHAPES_SERVINGS_2[facing];
            default -> SHAPES_SERVINGS_1[facing];
        };
    }

    protected ItemInteractionResult rotate(Level level, BlockPos pos, BlockState state, Player player) {
        if (player.getBoundingBox().distanceToSqr(pos.getBottomCenter()) < 0.5) return ItemInteractionResult.CONSUME;

        if (level.setBlock(pos, state.setValue(FACING, state.getValue(FACING).getClockWise()), 3)) return ItemInteractionResult.SUCCESS;

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public ItemInteractionResult addServingFromHand(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(SERVINGS);

        if (servings < MAX_SERVINGS) {
            ItemStack heldItem = player.getItemInHand(hand);
            level.setBlock(pos, state.setValue(SERVINGS, servings + 1), 3);
            level.playSound(player, pos, SoundEvents.GLASS_PLACE, SoundSource.BLOCKS, 0.8F, 0.6F);
            if (!player.isCreative()) {
                heldItem.shrink(1);
            }
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    protected ItemInteractionResult removeServingToHand(Level level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(SERVINGS);
        ItemStack servingItem = new ItemStack(this.servingItem.get());

        if (servings == 0) { // todo - decide shift key down to completely remove block?
            level.removeBlock(pos, false);
            level.playSound(player, pos, SoundEvents.GLASS_PLACE, SoundSource.BLOCKS, 0.8F, 0.8F);
            if (!player.isCreative()) {
                if (!player.getInventory().add(servingItem)) {
                    player.drop(servingItem, false);
                }
            }
            return ItemInteractionResult.SUCCESS;
        } else if (servings > 0) {
            level.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3);
            level.playSound(player, pos, SoundEvents.GLASS_PLACE, SoundSource.BLOCKS, 0.8F, 0.8F);
            if (!player.isCreative()) {
                if (!player.getInventory().add(servingItem)) {
                    player.drop(servingItem, false);
                }
            }
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
