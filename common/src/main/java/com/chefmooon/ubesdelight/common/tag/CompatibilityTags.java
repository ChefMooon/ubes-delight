package com.chefmooon.ubesdelight.common.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CompatibilityTags {

    public static final String MINECRAFT = "minecraft";
    public static final TagKey<Item> MINECRAFT_LEAVES = getItemTagKey(MINECRAFT, "leaves");
    public static final TagKey<Item> MINECRAFT_TERRACOTTA = getItemTagKey(MINECRAFT, "terracotta");
    public static final TagKey<Item> MINECRAFT_FISHES = getItemTagKey(MINECRAFT, "fishes");

    public static final String CREATE = "create";
    public static final TagKey<Block> CREATE_BRITTLE = getBlockTagKey(CREATE, "brittle");
    public static final TagKey<Block> CREATE_PASSIVE_BOILER_HEATERS = getBlockTagKey(CREATE, "passive_boiler_heaters");
    public static final TagKey<Item> CREATE_UPRIGHT_ON_BELT = getItemTagKey(CREATE, "upright_on_belt");

    public static final String FARMERS_DELIGHT = "farmersdelight";
    public static final TagKey<Block> FARMERS_DELIGHT_HEAT_SOURCES = getBlockTagKey(FARMERS_DELIGHT, "heat_sources");
    public static final TagKey<Block> FARMERS_DELIGHT_WILD_CROPS = getBlockTagKey(FARMERS_DELIGHT, "wild_crops");
    public static final TagKey<Item> FARMERS_DELIGHT_WILD_CROPS_ITEM = getItemTagKey(FARMERS_DELIGHT, "wild_crops");
    public static final TagKey<Item> FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS = getItemTagKey(FARMERS_DELIGHT, "cabbage_roll_ingredients");


    public static final String SUPPLEMENTARIES = "supplementaries";
    public static final TagKey<Item> SUPPLEMENTARIES_COOKIES = getItemTagKey(SUPPLEMENTARIES, "cookies");

    public static final String DEHYDRATION = "dehydration";
    public static final TagKey<Item> DEHYDRATION_HYDRATING_DRINKS = getItemTagKey(DEHYDRATION, "hydrating_drinks");
    public static final TagKey<Item> DEHYDRATION_HYDRATING_STEW = getItemTagKey(DEHYDRATION, "hydrating_stew");

    public static final String ORIGINS = "origins";
    public static final TagKey<Item> ORIGINS_MEAT = getItemTagKey(ORIGINS, "meat");
    public static final TagKey<Item> ORIGINS_IGNORE_DIET = getItemTagKey(ORIGINS, "ignore_diet");

    public static TagKey<Item> getItemTagKey(String namespace, String path) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(namespace, path));
    }
    public static TagKey<Block> getBlockTagKey(String namespace, String path) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(namespace, path));
    }
}
