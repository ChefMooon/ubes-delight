package com.chefmooon.ubesdelight.common.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CommonTags {

    public static final TagKey<Item> C_TOOLS_ROLLING_PINS = getCommonItemTagKey("tools/rolling_pins");
    public static final TagKey<Item> C_TOOLS_KNIVES = getCommonItemTagKey("tools/knives");
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

    public static final TagKey<Item> C_MILK = getCommonItemTagKey("milk");
    public static final TagKey<Item> C_MILK_MILK_BOTTLE = getCommonItemTagKey("milk/milk_bottle");

    public static final TagKey<Item> C_SALAD_INGREDIENTS = getCommonItemTagKey("salad_ingredients");
    public static final TagKey<Item> C_SALAD_INGREDIENTS_LEMONGRASS = getCommonItemTagKey("salad_ingredients/lemongrass");

    public static final TagKey<Item> C_SEEDS = getCommonItemTagKey("seeds");
    public static final TagKey<Item> C_SEEDS_LEMONGRASS = getCommonItemTagKey("seeds/lemongrass");

    public static final TagKey<Item> C_TEA_INGREDIENTS = getCommonItemTagKey("tea_ingredients");
    public static final TagKey<Item> C_TEA_INGREDIENTS_SWEET_WEAK = getCommonItemTagKey("tea_ingredients/sweet/weak");

    public static final TagKey<Item> C_FOODS_VEGETABLES = getCommonItemTagKey("foods/vegetables");
    public static final TagKey<Item> C_FOODS_VEGETABLES_GARLIC = getCommonItemTagKey("foods/vegetables/garlic");
    public static final TagKey<Item> C_FOODS_VEGETABLES_GINGER = getCommonItemTagKey("foods/vegetables/ginger");
    public static final TagKey<Item> C_FOODS_VEGETABLES_LEMONGRASS = getCommonItemTagKey("foods/vegetables/lemongrass");
    public static final TagKey<Item> C_FOODS_VEGETABLES_UBE = getCommonItemTagKey("foods/vegetables/ube");

    public static final TagKey<Item> C_RAW_BEEF = getCommonItemTagKey("raw_beef");
    public static final TagKey<Item> C_RAW_PORK = getCommonItemTagKey("raw_pork");
    public static final TagKey<Item> C_RAW_CHICKEN = getCommonItemTagKey("raw_chicken");
    public static final TagKey<Item> C_RAW_FISHES = getCommonItemTagKey("raw_fishes");
    public static final TagKey<Item> C_GRAIN = getCommonItemTagKey("grain");
    public static final TagKey<Item> C_EGGS = getCommonItemTagKey("eggs");
    public static final TagKey<Item> C_COOKED_EGGS = getCommonItemTagKey("cooked_eggs");

    public static final TagKey<Item> C_IRON_INGOTS = getCommonItemTagKey("iron_ingots");

    public static final TagKey<Item> C_DOUGH = getCommonItemTagKey("dough");

    public static final TagKey<Item> C_BONES = getCommonItemTagKey("bones");

    public static final TagKey<Item> C_FOODS_RAW_MEATS_RAW_BEEF = getCommonItemTagKey("foods/raw_meats/raw_beef");
    public static final TagKey<Item> C_FOODS_RAW_MEATS_RAW_PORK = getCommonItemTagKey("foods/raw_meats/raw_pork");
    public static final TagKey<Item> C_FOODS_RAW_MEATS_RAW_CHICKEN = getCommonItemTagKey("foods/raw_meats/raw_chicken");
    public static final TagKey<Item> C_FOODS_RAW_FISHES = getCommonItemTagKey("foods/raw_fishes");
    public static final TagKey<Item> C_GRAINS = getCommonItemTagKey("grains");
    public static final TagKey<Item> C_FOODS_COOKED_MEATS_COOKED_EGGS = getCommonItemTagKey("foods/cooked_meats/cooked_eggs");

    public static final TagKey<Item> C_MILKS = getCommonItemTagKey("milks");
    public static final TagKey<Item> C_MILKS_MILK_BOTTLES = getCommonItemTagKey("milks/milk_bottles");

    public static final TagKey<Item> C_FOODS_DOUGHS = getCommonItemTagKey("foods/doughs");

    // Extra compat (To Be Removed)
    public static final TagKey<Item> C_VEGETABLES = getCommonItemTagKey("vegetables");
    public static final TagKey<Item> C_VEGETABLES_GARLIC = getCommonItemTagKey("vegetables/garlic");
    public static final TagKey<Item> C_VEGETABLES_GINGER = getCommonItemTagKey("vegetables/ginger");
    public static final TagKey<Item> C_VEGETABLES_LEMONGRASS = getCommonItemTagKey("vegetables/lemongrass");
    public static final TagKey<Item> C_VEGETABLES_UBE = getCommonItemTagKey("vegetables/ube");

    public static TagKey<Item> getCommonItemTagKey(String path) {
        return TagKey.create(Registries.ITEM, new ResourceLocation("c", path));
    }
    public static TagKey<Block> getCommonBlockTagKey(String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation("c", path));
    }

}
