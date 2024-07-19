package com.chefmooon.ubesdelight.common.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ForgeTags {

    public static final TagKey<Item> TOOLS_KNIVES = forgeItemTag("tools/knives");

    private static TagKey<Block> forgeBlockTag(String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation("forge", path));
    }

    private static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("forge", path));
    }
}
