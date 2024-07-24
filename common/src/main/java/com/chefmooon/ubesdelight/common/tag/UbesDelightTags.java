package com.chefmooon.ubesdelight.common.tag;

import com.chefmooon.ubesdelight.UbesDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class UbesDelightTags {
    public static final TagKey<Item> FOOD_WRAPPERS = getItemTagKey("food_wrappers");
    public static final TagKey<Item> FOOD_WRAPPERS_LUMPIA_WRAPPERS = getItemTagKey("food_wrappers/lumpia_wrappers");

    public static TagKey<Item> getItemTagKey(String path) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(UbesDelight.MOD_ID, path));
    }
    public static TagKey<Block> getBlockTagKey(String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(UbesDelight.MOD_ID, path));
    }

    public static final TagKey<Biome> WILD_UBE_WHITELIST = getBiomeTag("has_wild_ube_whitelist");
    public static final TagKey<Biome> WILD_UBE_BLACKLIST = getBiomeTag("has_wild_ube_blacklist");
    public static final TagKey<Biome> WILD_GARLIC_WHITELIST = getBiomeTag("has_wild_garlic_whitelist");
    public static final TagKey<Biome> WILD_GARLIC_BLACKLIST = getBiomeTag("has_wild_garlic_blacklist");
    public static final TagKey<Biome> WILD_GINGER_WHITELIST = getBiomeTag("has_wild_ginger_whitelist");
    public static final TagKey<Biome> WILD_GINGER_BLACKLIST = getBiomeTag("has_wild_ginger_blacklist");
    public static final TagKey<Biome> WILD_LEMONGRASS_WHITELIST = getBiomeTag("has_wild_lemongrass_whitelist");
    public static final TagKey<Biome> WILD_LEMONGRASS_BLACKLIST = getBiomeTag("has_wild_lemongrass_blacklist");

    private static TagKey<Biome> getBiomeTag(String path) {
        return TagKey.create(Registries.BIOME, UbesDelight.res(path));
    }
}
