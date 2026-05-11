package com.chefmooon.ubesdelight.common.utility.fabric;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class ItemStackUtilImpl {
    public static ItemStack getContainer(ItemStack itemStack) {
        ItemStack container = itemStack.getCraftingRemainder().create(); // TODO: review for null pointer safety
        if (!container.isEmpty()) {
            return container;
        }
        return new ItemStack(Items.AIR);
    }
}
