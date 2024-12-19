package com.chefmooon.ubesdelight.common.block.leaf_feast.base.forge;


import com.chefmooon.ubesdelight.common.block.entity.forge.UniversalLeafFeastBlockEntityImpl;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.LeafFeastBlock;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.UniversalLeafFeastBlock;
import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil;
import com.chefmooon.ubesdelight.common.utility.ItemStackUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Objects;

public class UniversalLeafFeastBlockImpl extends UniversalLeafFeastBlock {
    public UniversalLeafFeastBlockImpl(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        InteractionResult result = InteractionResult.FAIL;

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

    private InteractionResult tryAddItemFromPlayerHand(BlockState state, Level level, BlockPos pos, UniversalLeafFeastBlockEntityImpl universalLeafFeastBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        InteractionResult result = InteractionResult.PASS;
        int servings = state.getValue(SERVINGS);

        if (heldStack.isEmpty()) {
            return result;
        } else if (heldStack.isEdible()) {
            if (state.getValue(LEAF_FEAST_TYPE) == LeafFeastTypes.END || state.getValue(LEAF_FEAST_TYPE) == LeafFeastTypes.TIP) {
                if (servings >= 3) return InteractionResult.FAIL;
            }
            if (universalLeafFeastBlockEntity.addItem(player, player.getAbilities().instabuild ? heldStack.copy() : heldStack)) {
                level.setBlock(pos, state.setValue(SERVINGS, servings + 1), 3);
                playAddSound(level, universalLeafFeastBlockEntity.getBlockPos());
                LeafFeastBlock.triggerInsertAdvancement(player);
                return InteractionResult.SUCCESS;
            }
        }

        return result;
    }

    private InteractionResult tryRemoveItemFromPlayerHand(BlockState state, Level level, BlockPos pos, UniversalLeafFeastBlockEntityImpl universalLeafFeastBlockEntity, ItemStack heldStack, ItemStack offHandStack, Player player, InteractionHand hand) {
        int servings = state.getValue(SERVINGS);

        if (servings > 1) {
            if (!level.setBlock(pos, state.setValue(SERVINGS, servings - 1), 3)) {
                return InteractionResult.PASS;
            }
        }

        playRemoveSound(level, universalLeafFeastBlockEntity.getBlockPos());
        ItemStack itemStack = universalLeafFeastBlockEntity.removeItem();
        if (!player.isCreative()) {
            if (player.isShiftKeyDown() && (player.getFoodData().needsFood() || Objects.requireNonNull(itemStack.getItem().getFoodProperties(itemStack, player)).canAlwaysEat())) {
                tryEat(itemStack, level, pos, player);
            } else {
                if (!player.getInventory().add(itemStack)) {
                    Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), itemStack);
                }
            }
        }

        if (servings == 1) {
            if (!level.setBlock(pos, getTransformState(BuiltInRegistryUtil.getBlock(UbesDelightBlocks.LEAF_FEAST), state), 3)) {
                return InteractionResult.PASS;
            }
        }

        return InteractionResult.SUCCESS;
    }

    public static void tryEat(ItemStack itemStack, Level level, BlockPos pos, Player player) {
        ItemStack container = ItemStackUtil.getContainer(itemStack);
        if (!container.isEmpty()) {
            spawnContainer(level, pos, player.getDirection().getOpposite(), container);
        }
        player.eat(level, itemStack);
        LeafFeastBlock.triggerConsumeAdvancement(player);
    }

    public static void spawnContainer(Level level, BlockPos blockPos, Direction direction, ItemStack itemStack) {
        ItemEntity entity = new ItemEntity(level,
                blockPos.getX() + 0.5 + (direction.getStepX() * 0.2),
                blockPos.getY() + 0.2,
                blockPos.getZ() + 0.5 + (direction.getStepZ() * 0.2), itemStack.copy());
        entity.setDeltaMovement(direction.getStepX() * 0.2F, 0.0F, direction.getStepZ() * 0.2F);
        level.addFreshEntity(entity);
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
