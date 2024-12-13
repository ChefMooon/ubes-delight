package com.chefmooon.ubesdelight.common.utility.neoforge;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemStackUtilImpl {
    public static ItemStack getContainer(ItemStack itemStack) {
        return itemStack.getCraftingRemainingItem();
    }
}
