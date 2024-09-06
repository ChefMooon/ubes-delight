package com.chefmooon.ubesdelight.common.block.neoforge;

import com.chefmooon.ubesdelight.common.block.BakingMatBlock;
import com.chefmooon.ubesdelight.common.block.entity.neoforge.BakingMatBlockEntityImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class BakingMatBlockImpl extends BakingMatBlock {

    public BakingMatBlockImpl() {
        super();
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof BakingMatBlockEntityImpl bakingMatBlockEntity) {
            return bakingMatBlockEntity.getItemsQuantity();
        }
        return 0;
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemInteractionResult result = ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof BakingMatBlockEntityImpl bakingMatBlockEntity)) {
            return result;
        }

        ItemStack heldStack = player.getItemInHand(hand);
        ItemStack offHandStack = player.getOffhandItem();

        if (heldStack.getItem() instanceof ShearsItem || heldStack.getItem() instanceof TridentItem) {
            return result;
        }

        boolean isValidTool = heldStack.getItem() instanceof DiggerItem;

        if (!state.getValue(BakingMatBlock.PROCESSING) && !isValidTool) {
            if (!bakingMatBlockEntity.isFull() && !heldStack.isEmpty()) {
                return tryAddItemFromPlayerHand(level, bakingMatBlockEntity, heldStack, offHandStack, player, hand);
            } else if (!bakingMatBlockEntity.isEmpty() && heldStack.isEmpty()) {
                return tryRemoveItemFromPlayerHand(level, bakingMatBlockEntity, heldStack, offHandStack, player, hand);
            }
        }

        if (!bakingMatBlockEntity.isEmpty() && !heldStack.isEmpty() && isValidTool) {
            return tryProcessBakingMatUsingToolInHand(level, bakingMatBlockEntity, heldStack, offHandStack, player, hand);
        }

        return result;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() == newState.getBlock()) {
            return;
        }

        BlockEntity tileEntity = level.getBlockEntity(pos);
        if (tileEntity instanceof BakingMatBlockEntityImpl bakingMat) {
            if (!state.getValue(PROCESSING)) {
                Containers.dropContents(level, pos, bakingMat.getItems());
            } else {
                state.setValue(PROCESSING, false);
            }
            level.updateNeighbourForOutputSignal(pos, this);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    private ItemInteractionResult tryAddItemFromPlayerHand(Level level, BakingMatBlockEntityImpl bakingMatBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        ItemInteractionResult result = ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        if (!offHandStack.isEmpty()) {
            if (hand.equals(InteractionHand.MAIN_HAND) && !(heldStack.getItem() instanceof BlockItem)) {
                return  result;
            }
            if (hand.equals(InteractionHand.OFF_HAND)) {
                return result;
            }
        }

        if (heldStack.isEmpty()) {
            return result;
        } else if (bakingMatBlockEntity.addItem(player.getAbilities().instabuild ? heldStack.copy() : heldStack)) {
            level.playSound(null, bakingMatBlockEntity.getBlockPos(), UbesDelightSounds.BLOCK_BAKING_MAT_ADD.get(), SoundSource.BLOCKS, 1.0f, 0.8f);
            return ItemInteractionResult.SUCCESS;
        }

        return result;
    }

    private ItemInteractionResult tryRemoveItemFromPlayerHand(Level level, BakingMatBlockEntityImpl bakingMatBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        BlockPos pos = bakingMatBlockEntity.getBlockPos();
        if (!bakingMatBlockEntity.isEmpty()) {
            if (player.isCreative()) {
                bakingMatBlockEntity.removeItem();
            } else if (!player.getInventory().add(bakingMatBlockEntity.removeItem())) {
                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), bakingMatBlockEntity.removeItem());
            }

            level.playSound(null, bakingMatBlockEntity.getBlockPos(), UbesDelightSounds.BLOCK_BAKING_MAT_REMOVE.get(), SoundSource.BLOCKS, 0.25f, 0.5f);
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    private ItemInteractionResult tryProcessBakingMatUsingToolInHand(Level level, BakingMatBlockEntityImpl bakingMatBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        ItemInteractionResult result = ItemInteractionResult.CONSUME;
        if (!hand.equals(InteractionHand.MAIN_HAND)) return result;

        if (bakingMatBlockEntity.processItemUsingTool(heldStack, player)) {
            return ItemInteractionResult.SUCCESS;
        }
        return result;
    }
}
