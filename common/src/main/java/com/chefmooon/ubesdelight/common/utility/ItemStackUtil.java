package com.chefmooon.ubesdelight.common.utility;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.item.ItemStack;

public class ItemStackUtil {
    @ExpectPlatform
    public static ItemStack getContainer(ItemStack itemStack) {
        throw new AssertionError();
    }
}
