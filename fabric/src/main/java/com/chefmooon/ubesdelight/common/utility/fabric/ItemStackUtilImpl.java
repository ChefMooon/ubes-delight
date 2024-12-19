package com.chefmooon.ubesdelight.common.utility.fabric;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ItemStackUtilImpl {
    public static ItemStack getContainer(ItemStack itemStack) {
        ItemStack container = itemStack.getRecipeRemainder();
        if (!container.isEmpty()) {
            return container;
        }
        return new ItemStack(Items.AIR);
    }
}
