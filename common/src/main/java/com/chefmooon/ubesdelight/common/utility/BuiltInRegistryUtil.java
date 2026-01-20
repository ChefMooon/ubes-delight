package com.chefmooon.ubesdelight.common.utility;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class BuiltInRegistryUtil {
    public static Item getItem(Identifier resourceLocation) {
        return BuiltInRegistries.ITEM.get(resourceLocation).get().value();
    }

    public static ItemStack getItemStack(Identifier resourceLocation) {
        return new ItemStack(BuiltInRegistries.ITEM.get(resourceLocation).get());
    }

    public static ItemLike getItemLike(Identifier resourceLocation) {
        return () -> BuiltInRegistries.ITEM.get(resourceLocation).get().value();
    }

    public static Block getBlock(Identifier resourceLocation) {
        return BuiltInRegistries.BLOCK.get(resourceLocation).get().value();
    }
}
