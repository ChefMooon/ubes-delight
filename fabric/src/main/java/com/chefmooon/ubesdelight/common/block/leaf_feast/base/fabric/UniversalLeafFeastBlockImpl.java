package com.chefmooon.ubesdelight.common.block.leaf_feast.base.fabric;

import com.chefmooon.ubesdelight.common.block.entity.fabric.UniversalLeafFeastBlockEntityImpl;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.UniversalLeafFeastBlock;
import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class UniversalLeafFeastBlockImpl extends UniversalLeafFeastBlock {
    public UniversalLeafFeastBlockImpl(Properties properties) {
        super(properties);
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemInteractionResult result = ItemInteractionResult.FAIL;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof UniversalLeafFeastBlockEntityImpl universalLeafFeastBlockEntity)) {
            return result;
        }

        ItemStack heldStack = player.getItemInHand(hand);
        ItemStack offHandStack = player.getOffhandItem();

        if (heldStack.isEmpty()) {
            return tryRemoveItemFromPlayerHand(state, level, pos, universalLeafFeastBlockEntity, heldStack, offHandStack, player, hand);
        } else {
            return tryAddItemFromPlayerHand(state, level, pos, universalLeafFeastBlockEntity, heldStack, offHandStack, player, hand);
        }
    }

    private ItemInteractionResult tryAddItemFromPlayerHand(BlockState state, Level level, BlockPos pos, UniversalLeafFeastBlockEntityImpl universalLeafFeastBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        ItemInteractionResult result = ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        int servings = state.getValue(SERVINGS);

        if (heldStack.isEmpty()) {
            return result;
        } else if (heldStack.has(DataComponents.FOOD)) {
            if (state.getValue(LEAF_FEAST_TYPE) == LeafFeastTypes.END || state.getValue(LEAF_FEAST_TYPE) == LeafFeastTypes.TIP) {
                if (servings >= 3) return ItemInteractionResult.FAIL;
            }
            if (universalLeafFeastBlockEntity.addItem(player, player.getAbilities().instabuild ? heldStack.copy() : heldStack)) {
                level.setBlock(pos, state.setValue(SERVINGS, servings + 1), 3);
                playAddSound(level, universalLeafFeastBlockEntity.getBlockPos());
                return ItemInteractionResult.SUCCESS;
            }
        }

        return result;
    }

    private ItemInteractionResult tryRemoveItemFromPlayerHand(BlockState state, Level level, BlockPos pos, UniversalLeafFeastBlockEntityImpl universalLeafFeastBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        int servings = state.getValue(SERVINGS);

        if (servings > 1) {
            if (!level.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3)) {
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
        }

        playRemoveSound(level, universalLeafFeastBlockEntity.getBlockPos());
        ItemStack itemStack = universalLeafFeastBlockEntity.removeItem();
        if (!player.isCreative()) {
            if (player.isShiftKeyDown() && player.getFoodData().needsFood()) {
                player.eat(level, itemStack);
            } else {
                if (!player.getInventory().add(itemStack)) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), itemStack);
                }
            }
        }

        if (servings == 1) {
            if (!level.setBlock(pos, getTransformState(BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST), state), 3)) {
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
        }

        return ItemInteractionResult.SUCCESS;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() == newState.getBlock()) {
            return;
        }

        BlockEntity tileEntity = level.getBlockEntity(pos);
        if (tileEntity instanceof UniversalLeafFeastBlockEntityImpl universalLeafFeastBlockEntity) {
            Containers.dropContents(level, pos, universalLeafFeastBlockEntity.getItems());
            level.updateNeighbourForOutputSignal(pos, this);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof UniversalLeafFeastBlockEntityImpl universalLeafFeastBlockEntity) {
            return universalLeafFeastBlockEntity.getItemsQuantity() * 2;
        }
        return 0;
    }
}
