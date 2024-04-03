package com.chefmoon.ubesdelight.block;

import com.chefmoon.ubesdelight.tag.CommonTags;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class LecheFlanFeast extends Block {
    public static final int MAX_BITES = 5;
    public static final IntProperty BITES = IntProperty.of("bites",0, MAX_BITES-1);
    protected static final VoxelShape SHAPE = Block.createCuboidShape(3.d, .0d, 3.d, 13.d, 6.d, 13.d);
    protected static VoxelShape[] BITES_TO_SHAPE = new VoxelShape[] {
            Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 6.0, 13.0),
            Block.createCuboidShape(5.0, 0.0, 3.0, 13.0, 6.0, 13.0),
            Block.createCuboidShape(7.0, 0.0, 3.0, 13.0, 6.0, 13.0),
            Block.createCuboidShape(9.0, 0.0, 3.0, 13.0, 6.0, 13.0),
            Block.createCuboidShape(11.0, 0.0, 3.0, 13.0, 6.0, 13.0)};
    public final Item serving;
    public LecheFlanFeast(Item serving) {
        super(FabricBlockSettings.copyOf(Blocks.CAKE));
        this.serving = serving;
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(BITES, 0));
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(BITES);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);

        if (player.getMainHandStack().isIn(CommonTags.C_TOOLS_KNIVES)) {
            LecheFlanFeast lecheFlanFeast = (LecheFlanFeast) state.getBlock();
            ItemStack servings = lecheFlanFeast.getServing();
            servings.setCount(MAX_BITES - state.get(LecheFlanFeast.BITES));
            ItemScatterer.spawn(world, pos, DefaultedList.ofSize(1, servings));
        }
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemstack = player.getStackInHand(hand);

        if (world.isClient()) {
            if (itemstack.isIn(CommonTags.C_TOOLS_KNIVES)) {
                return cutSlice(world, pos, state);
            }

            if (consumeBite(world, pos, state, player) == ActionResult.SUCCESS) {
                return ActionResult.SUCCESS;
            }

            if (itemstack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        }

        if (itemstack.isIn(CommonTags.C_TOOLS_KNIVES)) {
            return cutSlice(world, pos, state);
        }

        return consumeBite(world, pos, state, player);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return BITES_TO_SHAPE[(Integer)state.get(BITES)];
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState() : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return MAX_BITES - state.get(BITES);
    }
    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
    public ItemStack getServing() {
        return new ItemStack(serving);
    }

    protected ActionResult consumeBite(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        }

        ItemStack slice = getServing();
        FoodComponent sliceFood = slice.getItem().getFoodComponent();

        player.getHungerManager().eat(slice.getItem(), slice);
        player.increaseStat(Stats.EAT_CAKE_SLICE, 1);
        if (getServing().getItem().isFood() && sliceFood != null) {
            for (Pair<StatusEffectInstance, Float> pair : sliceFood.getStatusEffects()) {
                if (!world.isClient() && pair.getFirst() != null && world.getRandom().nextFloat() < pair.getSecond()) {
                    player.addStatusEffect(new StatusEffectInstance(pair.getFirst()));
                }
            }
        }

        int bites = state.get(BITES);
        if (bites < MAX_BITES - 1) {
            world.setBlockState(pos, state.with(BITES, bites + 1), 3);
        } else {
            world.removeBlock(pos, false);
        }
        world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.PLAYERS, 0.8F, 0.8F);

        return ActionResult.SUCCESS;
    }
    protected ActionResult cutSlice(World world, BlockPos pos, BlockState state) {
        int bites = state.get(BITES);
        if (bites < MAX_BITES - 1) {
            world.setBlockState(pos, state.with(BITES, bites + 1), 3);
        } else {
            world.removeBlock(pos, false);
        }
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), getServing());
        world.playSound(null, pos, SoundEvents.BLOCK_WOOL_BREAK, SoundCategory.PLAYERS, 0.8F, 0.8F);

        return ActionResult.SUCCESS;
    }
}
