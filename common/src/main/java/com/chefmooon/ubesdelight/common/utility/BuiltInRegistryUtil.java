package com.chefmooon.ubesdelight.common.utility;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class BuiltInRegistryUtil {
    public static Item getItem(ResourceLocation resourceLocation) {
        return BuiltInRegistries.ITEM.get(resourceLocation);
    }

    public static ItemStack getItemStack(ResourceLocation resourceLocation) {
        return new ItemStack(BuiltInRegistries.ITEM.get(resourceLocation));
    }

    public static Block getBlock(ResourceLocation resourceLocation) {
        return BuiltInRegistries.BLOCK.get(resourceLocation);
    }
}
