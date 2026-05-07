package chefmooon.ubesdelight.common.block.entity;

import chefmooon.ubesdelight.common.core.LeafFeastTypes;
import chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import vectorwing.farmersdelight.common.block.entity.SyncedBlockEntity;

public class UniversalLeafFeastBlockEntity extends SyncedBlockEntity {
    public static final int MAX_ITEMS = 6;
    private final ItemStackHandler inventory;
    public UniversalLeafFeastBlockEntity(BlockPos pos, BlockState state) {
        super(UbesDelightBlockEntityTypes.UNIVERSAL_LEAF_FEAST.get(), pos, state);
        inventory = createHandler();
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
        for (int i = 0; i < MAX_ITEMS; i++) {
            this.inventory.setStackInSlot(i, ItemStack.EMPTY);
        }
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
        return !inventory.getStackInSlot(MAX_ITEMS-1).isEmpty();
    }

    public boolean addItem(Player player, ItemStack itemStack) {
        for (int i = 0; i < inventory.getSlots(); i++) {
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

    public IItemHandler getInventory() {
        return inventory;
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

    public static Vec2 getItemOffset(int index, LeafFeastTypes leafFeastType) {
        if (leafFeastType == LeafFeastTypes.BASE || leafFeastType == LeafFeastTypes.MIDDLE) {
            final float xOffset = .3f;
            final float yOffset = .25f;
            final Vec2[] offsets = {
                    new Vec2(xOffset, yOffset),   // Top-right
                    new Vec2(0.0f, -yOffset),  // Bottom-center
                    new Vec2(-xOffset, yOffset),  // Top-left
                    new Vec2(xOffset, -yOffset),  // Bottom-right
                    new Vec2(0.0f, yOffset),   // Top-center
                    new Vec2(-xOffset, -yOffset)  // Bottom-left
            };
            return offsets[index];
        } else if (leafFeastType == LeafFeastTypes.TIP && index < 3) {
            Vec2[] offsets = {
                    new Vec2(-0.33f, 0.2f),
                    new Vec2(-0.27f, -0.2f),
                    new Vec2(0.05f, 0.0f)
            };
            return offsets[index];
        } else if (leafFeastType == LeafFeastTypes.END && index < 3) {
            Vec2[] offsets = {
                    new Vec2(0.33f, -0.2f),
                    new Vec2(0.27f, 0.2f),
                    new Vec2(-0.05f, 0.0f)
            };
            return offsets[index];
        }
        return  new Vec2(0.0f, 0.0f);
    }
}
