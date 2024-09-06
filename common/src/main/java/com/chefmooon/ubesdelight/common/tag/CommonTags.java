package com.chefmooon.ubesdelight.common.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CommonTags {

    public static final TagKey<Item> C_TOOLS = getCommonItemTagKey("tools");
    public static final TagKey<Item> C_TOOLS_ROLLING_PIN = getCommonItemTagKey("tools/rolling_pin");
    public static final TagKey<Item> C_TOOLS_KNIFE = getCommonItemTagKey("tools/knife");
    public static final TagKey<Block> C_MINEABLE_KNIFE = getCommonBlockTagKey("mineable/knife");
    public static final TagKey<Block> C_MINEABLE_ROLLING_PIN = getCommonBlockTagKey("mineable/rolling_pin");
    public static final TagKey<Block> C_FARMLAND = getCommonBlockTagKey("farmland");

    // Common Tags
    public static final TagKey<Item> C_CROPS = getCommonItemTagKey("crops");
    public static final TagKey<Item> C_CROPS_GARLIC = getCommonItemTagKey("crops/garlic");
    public static final TagKey<Item> C_CROPS_GINGER = getCommonItemTagKey("crops/ginger");
    public static final TagKey<Item> C_CROPS_LEMONGRASS = getCommonItemTagKey("crops/lemongrass");
    public static final TagKey<Item> C_CROPS_UBE = getCommonItemTagKey("crops/ube");

    public static final TagKey<Item> C_CROPS_ONION = getCommonItemTagKey("crops/onion");
    public static final TagKey<Item> C_CROPS_CABBAGE = getCommonItemTagKey("crops/cabbage");
    public static final TagKey<Item> C_CROPS_TOMATO = getCommonItemTagKey("crops/tomato");
    public static final TagKey<Item> C_CROPS_RICE = getCommonItemTagKey("crops/rice");

    public static final TagKey<Item> C_FOOD_WRAPPERS = getCommonItemTagKey("food_wrappers");
    public static final TagKey<Item> C_FOOD_WRAPPERS_LUMPIA_WRAPPER = getCommonItemTagKey("food_wrappers/lumpia_wrapper");

    public static final TagKey<Item> C_FOODS = getCommonItemTagKey("foods");

    public static final TagKey<Item> C_FOODS_LEAFY_GREEN = getCommonItemTagKey("foods/leafy_green");

    public static final TagKey<Item> C_SEEDS = getCommonItemTagKey("seeds");

    public static final TagKey<Item> C_TEA_INGREDIENTS = getCommonItemTagKey("tea_ingredients");
    public static final TagKey<Item> C_TEA_INGREDIENTS_SWEET_WEAK = getCommonItemTagKey("tea_ingredients/sweet/weak");

    public static final TagKey<Item> C_FOODS_VEGETABLE = getCommonItemTagKey("foods/vegetable");
    public static final TagKey<Item> C_FOODS_GARLIC = getCommonItemTagKey("foods/garlic");
    public static final TagKey<Item> C_FOODS_GINGER = getCommonItemTagKey("foods/ginger");
    public static final TagKey<Item> C_FOODS_LEMONGRASS = getCommonItemTagKey("foods/lemongrass");
    public static final TagKey<Item> C_FOODS_UBE = getCommonItemTagKey("foods/ube");

    public static final TagKey<Item> C_EGGS = getCommonItemTagKey("eggs");

    public static final TagKey<Item> C_IRON_INGOTS = getCommonItemTagKey("iron_ingots");

    public static final TagKey<Item> C_BONES = getCommonItemTagKey("bones");

    public static final TagKey<Item> C_FOODS_RAW_BEEF = getCommonItemTagKey("foods/raw_beef");
    public static final TagKey<Item> C_FOODS_RAW_PORK = getCommonItemTagKey("foods/raw_pork");
    public static final TagKey<Item> C_FOODS_RAW_CHICKEN = getCommonItemTagKey("foods/raw_chicken");
    public static final TagKey<Item> C_FOODS_RAW_FISH = getCommonItemTagKey("foods/raw_fish");
    public static final TagKey<Item> C_CROPS_GRAIN = getCommonItemTagKey("crops/grain");
    public static final TagKey<Item> C_FOODS_COOKED_EGG = getCommonItemTagKey("foods/cooked_egg");

    public static final TagKey<Item> C_FOODS_MILK = getCommonItemTagKey("foods/milk");
    public static final TagKey<Item> C_FOODS_MILK_BOTTLE = getCommonItemTagKey("foods/milk_bottle");

    public static final TagKey<Item> C_FOODS_DOUGH = getCommonItemTagKey("foods/dough");

    public static final TagKey<Item> C_FOODS_COOKIE = getCommonItemTagKey("foods/cookie");

    // Might but used for create compat
    public static final TagKey<Item> C_DOUGH = getCommonItemTagKey("dough");

    public static TagKey<Item> getCommonItemTagKey(String path) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("c", path));
    }
    public static TagKey<Block> getCommonBlockTagKey(String path) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("c", path));
    }

}
