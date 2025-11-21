package com.chefmooon.ubesdelight.common.block.entity.fabric;

import com.chefmooon.ubesdelight.common.block.entity.UniversalLeafFeastBlockEntity;
import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlockEntityTypesImpl;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.entity.SyncedBlockEntity;
import vectorwing.farmersdelight.refabricated.inventory.ItemStackHandler;

public class UniversalLeafFeastBlockEntityImpl extends SyncedBlockEntity {
    public static final int MAX_ITEMS = UniversalLeafFeastBlockEntity.MAX_ITEMS;
    private final ItemStackHandler inventory;
    public UniversalLeafFeastBlockEntityImpl(BlockPos pos, BlockState state) {
        super(UbesDelightBlockEntityTypesImpl.UNIVERSAL_LEAF_FEAST.get(), pos, state);
        inventory = createHandler();
    }

    @Override
    public void loadAdditional(ValueInput valueInput) {
        super.loadAdditional(valueInput);
        inventory.deserialize(valueInput.childOrEmpty("Inventory"));
    }

    @Override
    public void saveAdditional(ValueOutput valueOutput) {
        super.saveAdditional(valueOutput);
        inventory.serialize(valueOutput.child("Inventory"));
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof UniversalLeafFeastBlockEntityImpl universalLeafFeastBlockEntity) {
            Containers.dropContents(level, pos, universalLeafFeastBlockEntity.getItems());
        }
        super.preRemoveSideEffects(pos, state);
    }

    public void clearInventory() {
        for (int i = 0; i < MAX_ITEMS-1; i++) {
            this.inventory.getStackInSlot(i);
        }
        inventoryChanged();
    }

    public void setInventory(NonNullList<ItemStack> list) {
        for (int i = 0; i < MAX_ITEMS-1; i++) {
            this.inventory.setStackInSlot(i, list.get(i));
        }
    }

    public int getContainerSize() {
        return MAX_ITEMS;
    }

    public NonNullList<ItemStack> getItems() {
        NonNullList<ItemStack> items = NonNullList.withSize(MAX_ITEMS, ItemStack.EMPTY);
        for (int i = 0; i < MAX_ITEMS; i++) {
            items.set(i, inventory.getStackInSlot(i));
        }
        return items;
    }

    public boolean isEmpty() {
        return inventory.getStackInSlot(0).isEmpty();
    }

    public boolean isFull() {
        return !inventory.getStackInSlot(MAX_ITEMS).isEmpty();
    }

    public boolean addItem(Player player, ItemStack itemStack) {
        for (int i = 0; i < inventory.getSlotCount(); i++) {
            ItemStack inventoryStack = inventory.getStackInSlot(i);
            if (inventoryStack.isEmpty()) {
                inventory.setStackInSlot(i, itemStack.split(1));
                inventoryChanged();
                return true;
            }
        }
        return false;
    }

    public ItemStack removeItem() {
        for (int i = MAX_ITEMS-1; i >= 0; i--) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if (!itemStack.isEmpty()) {
                inventory.setStackInSlot(i, ItemStack.EMPTY);
                inventoryChanged();
                return itemStack;
            }
        }
        return ItemStack.EMPTY;
    }

    public int getItemsQuantity() {
        int items = 0;
        for (int i = 0; i <= MAX_ITEMS-1; i++) {
            ItemStack itemstack = inventory.getStackInSlot(i);
            if (!itemstack.isEmpty()) {
                items++;
            }
        }
        return items;
    }

    public ItemStackHandler getInventory() {
        return inventory;
    }

    public static Vec2 getItemOffset(int index, LeafFeastTypes leafFeastType) {
        return UniversalLeafFeastBlockEntity.getItemOffset(index, leafFeastType);
    }

    @NotNull
    public Storage<ItemVariant> getStorage(@Nullable Direction side) {
        return getInventory();
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(MAX_ITEMS)
        {
            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }

            @Override
            protected void onContentsChanged(int slot) {
                inventoryChanged();
            }
        };
    }
}
