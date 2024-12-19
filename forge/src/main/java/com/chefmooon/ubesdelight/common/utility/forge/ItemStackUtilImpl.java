package com.chefmooon.ubesdelight.common.utility.forge;

import net.minecraft.world.item.ItemStack;

public class ItemStackUtilImpl {
    public static ItemStack getContainer(ItemStack itemStack) {
        return itemStack.getCraftingRemainingItem();
    }
}
