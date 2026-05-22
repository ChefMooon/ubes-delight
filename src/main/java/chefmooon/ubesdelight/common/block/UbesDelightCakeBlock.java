package chefmooon.ubesdelight.common.block;

import chefmooon.ubesdelight.common.utility.TagUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.ConsumableListener;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class UbesDelightCakeBlock extends Block {
    public static final int MAX_BITES = 7;
    public static final IntegerProperty BITES = IntegerProperty.create("bites", 0, MAX_BITES-1);
    public final Supplier<Item> cakeSlice;
    protected static VoxelShape[] BITES_TO_SHAPE = new VoxelShape[] {
            Block.box(1.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(3.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(5.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(7.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(9.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(11.0, 0.0, 1.0, 15.0, 8.0, 15.0),
            Block.box(13.0, 0.0, 1.0, 15.0, 8.0, 15.0)};
    public UbesDelightCakeBlock(Supplier<Item> cakeSlice, BlockBehaviour.Properties properties) {
        super(properties);
        this.cakeSlice = cakeSlice;
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return BITES_TO_SHAPE[state.getValue(BITES)];
    }

    @Override
    public InteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (heldStack.is(TagUtils.getKifeItemTag())) {
            return cutSlice(level, pos, state);
        }

        return InteractionResult.TRY_WITH_EMPTY_HAND;
    }

    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) {
            if (consumeBite(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return consumeBite(level, pos, state, player);
    }

    public ItemStack getCakeSliceStack() {
        return new ItemStack(cakeSlice.get());
    }

    protected InteractionResult consumeBite(Level level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            ItemStack cakeSlice = getCakeSliceStack();
            FoodProperties slice = cakeSlice.get(DataComponents.FOOD);
            Consumable sliceConsumable = cakeSlice.get(DataComponents.CONSUMABLE);

            if (slice != null) {
                level.gameEvent(player, GameEvent.EAT, pos);
                cakeSlice.getAllOfType(ConsumableListener.class).forEach(consumableListener -> consumableListener.onConsume(level, player, cakeSlice, sliceConsumable));
                if (!level.isClientSide() && sliceConsumable != null) {
                    sliceConsumable.onConsumeEffects().forEach(consumeEffect -> consumeEffect.apply(level, cakeSlice, player));
                }
            }
        }
        int bites = state.getValue(BITES);
        if (bites < MAX_BITES - 1) {
            level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
        } else {
            level.removeBlock(pos, false);
            level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
        }
        level. playSound(null, pos, SoundEvents.GENERIC_EAT.value(), SoundSource.PLAYERS, 0.8F, 0.8F);

        return InteractionResult.SUCCESS;
    }

    protected InteractionResult cutSlice(Level level, BlockPos pos, BlockState state) {
        int bites = state.getValue(BITES);
        if (bites < MAX_BITES - 1) {
            level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
            level.gameEvent(null, GameEvent.BLOCK_CHANGE, pos);
        } else {
            level.removeBlock(pos, false);
            level.gameEvent(null, GameEvent.BLOCK_DESTROY, pos);
        }
        Block.popResource(level, pos, getCakeSliceStack());
        level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.BLOCKS, 0.8f, 0.8f);

        return InteractionResult.SUCCESS;
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
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        return getOutputSignal((Integer)state.getValue(BITES));
    }

    public static int getOutputSignal(int eaten) {
        return (MAX_BITES - eaten) * 2;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}
