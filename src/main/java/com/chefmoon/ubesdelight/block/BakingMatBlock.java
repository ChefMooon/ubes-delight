package com.chefmoon.ubesdelight.block;

import com.chefmoon.ubesdelight.block.entity.BakingMatBlockEntity;
import com.chefmoon.ubesdelight.registry.SoundsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.OrderedTick;
import org.jetbrains.annotations.Nullable;

public class BakingMatBlock extends BlockWithEntity implements BlockEntityProvider, Waterloggable {

    public static final BooleanProperty PROCESSING = BooleanProperty.of("processing");
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.d, .0d, 1.d, 15.d, 1.d, 15.d);
    public BakingMatBlock() {
        super(FabricBlockSettings.copy(Blocks.WHITE_WOOL).hardness(1.f).resistance(1.f).sounds(BlockSoundGroup.BAMBOO));
        setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(PROCESSING, false).with(FACING, Direction.NORTH).with(WATERLOGGED, false));
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BakingMatBlockEntity(pos, state);
        //return BlockEntityTypesRegistry.BAKING_MAT_BAMBOO.get().instantiate(pos, state); Minecraft 1.19.2
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(PROCESSING, FACING, WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        FluidState fluidState = context.getWorld().getFluidState(context.getBlockPos());
        return getDefaultState()
                .with(PROCESSING, false)
                .with(FACING, context.getHorizontalPlayerFacing().getOpposite())
                .with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ActionResult result = ActionResult.PASS;

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (!(blockEntity instanceof BakingMatBlockEntity bakingMatBlockEntity)) {
            return result;
        }

        ItemStack itemHeld = player.getStackInHand(hand);

        if (itemHeld.getItem() instanceof ShearsItem || itemHeld.getItem() instanceof TridentItem) {
            return  result;
        }

        // Works but hate it. Would like to rework.
        // Also account for ShearsItem and TridentItem? (Shields? other equipment?)
        if (!bakingMatBlockEntity.isFull() && !itemHeld.isEmpty() && !state.get(BakingMatBlock.PROCESSING) && !(itemHeld.getItem() instanceof ToolItem)) {
            result = tryAddItemFromPlayerHand(world, bakingMatBlockEntity, player, hand);
        } else if (!bakingMatBlockEntity.isEmpty() && itemHeld.isEmpty() && !state.get(BakingMatBlock.PROCESSING) && !(itemHeld.getItem() instanceof ToolItem)) {
            result = tryRemoveItemWithPlayerHand(world, bakingMatBlockEntity, player);
        } else if (!bakingMatBlockEntity.isEmpty() && !itemHeld.isEmpty() && (itemHeld.getItem() instanceof ToolItem)) {
            result = tryProcessBakingMatUsingToolInHand(world, bakingMatBlockEntity, player, hand);
        }

        return result;
    }

    // Future potential use
    private ActionResult onUseByPlayerHand(World world, BakingMatBlockEntity bakingMatBlockEntity, PlayerEntity player, Hand hand) {
        ActionResult result = ActionResult.PASS;
        ItemStack itemHeld = player.getStackInHand(hand);
        if (!itemHeld.isEmpty() && !itemHeld.isIn(CommonTags.C_ROLLING_PINS)) {
            result = tryAddItemFromPlayerHand(world, bakingMatBlockEntity, player, hand);
        } else if (itemHeld.isEmpty() && !itemHeld.isIn(CommonTags.C_ROLLING_PINS)) {
            result = tryRemoveItemWithPlayerHand(world, bakingMatBlockEntity, player);
        }
        return result;
    }
    private ActionResult tryAddItemFromPlayerHand(World world, BakingMatBlockEntity bakingMatBlockEntity, PlayerEntity player, Hand hand) {
        ActionResult result = ActionResult.PASS;
        ItemStack itemHeld = player.getStackInHand(hand);
        ItemStack itemOffhand = player.getOffHandStack();

        if (!itemOffhand.isEmpty()) {
            if (hand.equals(Hand.MAIN_HAND) && !(itemHeld.getItem() instanceof BlockItem)) {
                return ActionResult.PASS;
            }
            if (hand.equals(Hand.OFF_HAND)) {
                return ActionResult.PASS;
            }
        }

        if (itemHeld.isEmpty()) {
            return ActionResult.PASS;
        } else if (bakingMatBlockEntity.addItem(player.getAbilities().creativeMode ? itemHeld.copy() : itemHeld)) {
            world.playSound(null, bakingMatBlockEntity.getPos(), SoundsRegistry.BLOCK_BAKING_MAT_ADD.get(), SoundCategory.BLOCKS, 1.f, .8f);
            result = ActionResult.SUCCESS;
        }

        return result;
    }
    private ActionResult tryRemoveItemWithPlayerHand(World world, BakingMatBlockEntity bakingMatBlockEntity, PlayerEntity player) {
        ActionResult result = ActionResult.PASS;
        BlockPos pos = bakingMatBlockEntity.getPos();
        if (!bakingMatBlockEntity.isEmpty()) {
            if (player.isCreative()) {
                bakingMatBlockEntity.removeItem();
            } else if (!player.getInventory().insertStack(bakingMatBlockEntity.removeItem())) {
                ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), bakingMatBlockEntity.removeItem());
            }

            world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundsRegistry.BLOCK_BAKING_MAT_REMOVE.get(), SoundCategory.BLOCKS, .25f, .5f);
            result = ActionResult.SUCCESS;
        }

        return result;
    }
    private ActionResult tryProcessBakingMatUsingToolInHand(World world, BakingMatBlockEntity bakingMatBlockEntity, PlayerEntity player, Hand hand) {
        ActionResult result = ActionResult.CONSUME;
        ItemStack itemHeld = player.getStackInHand(hand);

        if (bakingMatBlockEntity.processItemUsingTool(itemHeld, player)) {
            result = ActionResult.SUCCESS;
        }

        return result;
    }
    // Comparator output to be added with the Hopper and Dispenser update
    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return false;
    }
    /*
    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if ((blockEntity instanceof BakingMatBlockEntity bakingMatBlockEntity)) {
            return bakingMatBlockEntity.getItemsQuantity();
        }
        return 0;
    }
     */
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BakingMatBlockEntity) {
                if (!state.get(PROCESSING)) {
                    ItemScatterer.spawn(world, pos, (BakingMatBlockEntity)blockEntity);
                } else {
                    // TODO: add ingredients spawn from processingStage (if possible)
                    //ItemScatterer.spawn(world, pos, (BakingMatBlockEntity) blockEntity);
                    state.with(PROCESSING, false);
                }
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (Boolean.TRUE.equals(state.get(WATERLOGGED))) {
            world.getFluidTickScheduler().scheduleTick(OrderedTick.create(Fluids.WATER, pos));
        }
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }
    @Override
    public FluidState getFluidState(BlockState state) {
        return Boolean.TRUE.equals(state.get(WATERLOGGED)) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public boolean canMobSpawnInside(BlockState state) {
        return true;
    }

}
