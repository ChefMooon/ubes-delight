package com.chefmooon.ubesdelight.common.block.entity.fabric;

import com.chefmooon.ubesdelight.common.block.entity.UniversalLeafFeastBlockEntity;
import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlockEntityTypesImpl;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandlerContainer;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.Storage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.entity.SyncedBlockEntity;

public class UniversalLeafFeastBlockEntityImpl extends SyncedBlockEntity {
    public static final int MAX_ITEMS = UniversalLeafFeastBlockEntity.MAX_ITEMS;
    private final ItemStackHandlerContainer inventory;
    private final ItemStackHandlerContainer inputHandler;
    public UniversalLeafFeastBlockEntityImpl(BlockPos pos, BlockState state) {
        super(UbesDelightBlockEntityTypesImpl.UNIVERSAL_LEAF_FEAST.get(), pos, state);
        inventory = createHandler();
        inputHandler = inventory;
    }

    @Override
    public void loadAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.loadAdditional(compound, registries);
        inventory.deserializeNBT(registries, compound.getCompound("Inventory"));
    }

    @Override
    public void saveAdditional(CompoundTag compound, HolderLookup.Provider registries) {
        super.saveAdditional(compound, registries);
        compound.put("Inventory", inventory.serializeNBT(registries));
    }

    public void clearInventory() {
        inventory.clearContent();
    }

    public void setInventory(NonNullList<ItemStack> list) {
        for (int i = 0; i < MAX_ITEMS-1; i++) {
            this.inventory.setItem(i, list.get(i));
        }
    }

    public int getContainerSize() {
        return MAX_ITEMS;
    }

    public NonNullList<ItemStack> getItems() {
        NonNullList<ItemStack> items = NonNullList.withSize(MAX_ITEMS, ItemStack.EMPTY);
        for (int i = 0; i < MAX_ITEMS; i++) {
            items.set(i, inventory.getItem(i));
        }
        return items;
    }

    public boolean isEmpty() {
        return inventory.getItem(0).isEmpty();
    }

    public boolean isFull() {
        return !inventory.getItem(MAX_ITEMS).isEmpty();
    }

    public boolean addItem(Player player, ItemStack itemStack) {
        for (int i = 0; i < inventory.getSlotCount(); i++) {
            ItemStack inventoryStack = inventory.getItem(i);
            if (inventoryStack.isEmpty()) {
                inventory.setItem(i, itemStack.split(1));
                inventoryChanged();
                return true;
            }
        }
        return false;
    }

    public ItemStack removeItem() {
        for (int i = MAX_ITEMS-1; i >= 0; i--) {
            ItemStack itemStack = inventory.getItem(i);
            if (!itemStack.isEmpty()) {
                inventory.setItem(i, ItemStack.EMPTY);
                inventoryChanged();
                return itemStack;
            }
        }
        return ItemStack.EMPTY;
    }

    public int getItemsQuantity() {
        int items = 0;
        for (int i = 0; i <= MAX_ITEMS-1; i++) {
            ItemStack itemstack = inventory.getItem(i);
            if (!itemstack.isEmpty()) {
                items++;
            }
        }
        return items;
    }

    public ItemStackHandlerContainer getInventory() {
        return this.inventory;
    }

    public Vec2 getItemOffset(int index, LeafFeastTypes leafFeastType) {
        return UniversalLeafFeastBlockEntity.getItemOffset(index, leafFeastType);
    }

    @NotNull
    public Storage<ItemVariant> getStorage(@Nullable Direction side) {
        return inputHandler;
    }

    @Override
    public void setRemoved() {
        super.setRemoved();
    }

    private ItemStackHandlerContainer createHandler() {
        return new ItemStackHandlerContainer(MAX_ITEMS)
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
