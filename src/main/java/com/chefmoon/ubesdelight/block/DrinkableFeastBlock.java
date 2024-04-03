package com.chefmoon.ubesdelight.block;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.SoundsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
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
import org.jetbrains.annotations.Nullable;

public class DrinkableFeastBlock extends Block {

    public static final int MAX_SERVINGS = 4;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty SERVINGS = IntProperty.of("servings", 0, MAX_SERVINGS);

    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.d, .0d, 1.d, 15.d, 8.d, 15.d);

    public Item servingItem;

    public DrinkableFeastBlock(Item servingItem) {
        super(FabricBlockSettings.copyOf(Blocks.GLASS).notSolid());
        this.servingItem = servingItem;
        setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(SERVINGS, MAX_SERVINGS));
    }

    public DrinkableFeastBlock(Item servingItem, Settings settings) {
        super(settings);
        this.servingItem = servingItem;
        setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(SERVINGS, MAX_SERVINGS));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);

        if (player.getMainHandStack().isIn(CommonTags.C_TOOLS_KNIVES)) {
            DrinkableFeastBlock drinkableFeast = (DrinkableFeastBlock) state.getBlock();
            ItemStack servingItem = drinkableFeast.getServingStack(state);
            if (state.get(DrinkableFeastBlock.SERVINGS) > 0) {
                servingItem.setCount(state.get(DrinkableFeastBlock.SERVINGS));
                ItemScatterer.spawn(world, pos, DefaultedList.ofSize(1, servingItem));
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack serving = getServingStack(state);
        ItemStack heldItem = player.getStackInHand(hand);

        if (world.isClient()) {
            if (heldItem.isOf(serving.getItem())) {
                if (addDrink(world, pos, state, player, hand).isAccepted()) {
                    return ActionResult.SUCCESS;
                }
            } else {
                if (dispenseDrink(world, pos, state, player, hand).isAccepted()) {
                    return ActionResult.SUCCESS;
                }
            }
        }

        if (heldItem.isOf(serving.getItem())) {
            return addDrink(world, pos, state, player, hand);
        } else {
            return dispenseDrink(world, pos, state, player, hand);
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(getServingsProperty());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public IntProperty getServingsProperty() {
        return SERVINGS;
    }

    public ItemStack getServingStack(BlockState state) {
        return new ItemStack(servingItem);
    }

    protected ActionResult dispenseDrink(World world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand) {
        int servings = state.get(getServingsProperty());

        if (servings > 0) {
            ItemStack serving = getServingStack(state);
            ItemStack heldItem = player.getStackInHand(hand);
            if (heldItem.isOf(Items.GLASS_BOTTLE)) {
                world.setBlockState(pos, state.with(getServingsProperty(), servings - 1), 3);
                world.playSound(null, pos, SoundsRegistry.BLOCK_DRINKABLE_FEAST_REMOVE.get(), SoundCategory.PLAYERS, 0.8F, 0.8F);
                if (!player.getAbilities().creativeMode) {
                    heldItem.decrement(1);
                    if (!player.getInventory().insertStack(serving)) {
                        player.dropItem(serving, false);
                    }
                }
                return ActionResult.SUCCESS;
            } else {
                if (world.isClient()) {
                    player.sendMessage(UbesDelightMod.tooltip("container.halo_halo_feast"), true);
                }
            }
        }

        return ActionResult.FAIL;
    }

    protected ActionResult addDrink(World world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand) {
        int servings = state.get(getServingsProperty());

        if (servings < MAX_SERVINGS) {
            ItemStack heldItem = player.getStackInHand(hand);
            ItemStack container = new ItemStack(Items.GLASS_BOTTLE);
            world.setBlockState(pos, state.with(getServingsProperty(), servings + 1), 3);
            //TODO: make a add sound
            world.playSound(null, pos, SoundsRegistry.BLOCK_DRINKABLE_FEAST_ADD.get(), SoundCategory.PLAYERS, 0.8F, 0.8F);
            if (!player.getAbilities().creativeMode) {
                heldItem.decrement(1);
                if (!player.getInventory().insertStack(container)) {
                    player.dropItem(container, false);
                }
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.FAIL;
    }
}
