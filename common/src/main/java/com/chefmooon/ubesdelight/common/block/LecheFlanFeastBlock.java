package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.utility.TagUtils;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
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

public class LecheFlanFeastBlock extends Block {
    public static final int MAX_BITES = 5;
    public static final IntegerProperty BITES = IntegerProperty.create("bites",0, MAX_BITES-1);
    public final Supplier<Item> serving;
    protected static VoxelShape[] BITES_TO_SHAPE = new VoxelShape[] {
            Block.box(3.0, 0.0, 3.0, 13.0, 6.0, 13.0),
            Block.box(5.0, 0.0, 3.0, 13.0, 6.0, 13.0),
            Block.box(7.0, 0.0, 3.0, 13.0, 6.0, 13.0),
            Block.box(9.0, 0.0, 3.0, 13.0, 6.0, 13.0),
            Block.box(11.0, 0.0, 3.0, 13.0, 6.0, 13.0)};
    public LecheFlanFeastBlock(Supplier<Item> serving) {
        super(BlockBehaviour.Properties.copy(Blocks.CAKE));
        this.serving = serving;
        this.registerDefaultState(this.stateDefinition.any().setValue(BITES, 0));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return BITES_TO_SHAPE[state.getValue(BITES)];
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack heldStack = player.getItemInHand(hand);

        if (level.isClientSide) {
            if (heldStack.is(TagUtils.getKifeItemTag()) && cutSlice(level, pos, state).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
            if (consumeBite(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
            if (heldStack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        if (heldStack.is(TagUtils.getKifeItemTag())) {
            return cutSlice(level, pos, state);
        }

        return consumeBite(level, pos, state, player);
    }

    public ItemStack getCakeSliceStack() {
        return new ItemStack(serving.get());
    }

    protected InteractionResult consumeBite(Level level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        } else {
            ItemStack cakeSlice = getCakeSliceStack();
            FoodProperties slice = cakeSlice.getItem().getFoodProperties();

            player.awardStat(Stats.EAT_CAKE_SLICE);
            level.gameEvent(player, GameEvent.EAT, pos);
            player.getFoodData().eat(cakeSlice.getItem(), cakeSlice);
            if (cakeSlice.isEdible() && slice != null) {
                for (Pair<MobEffectInstance, Float> pair : slice.getEffects()) {
                    if (!level.isClientSide && pair.getFirst() != null && level.random.nextFloat() < (Float)pair.getSecond()) {
                        player.addEffect(new MobEffectInstance((MobEffectInstance)pair.getFirst()));
                    }
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
        level. playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8f, 0.8f);

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
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
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
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
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
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
