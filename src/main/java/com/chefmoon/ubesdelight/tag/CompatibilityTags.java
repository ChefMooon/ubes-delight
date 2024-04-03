package com.chefmoon.ubesdelight.tag;

import com.chefmoon.ubesdelight.util.TagUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class CompatibilityTags {

    public static final String MINECRAFT = "minecraft";
    public static final TagKey<Item> MINECRAFT_LEAVES = TagUtil.getItemTagKey(MINECRAFT, "leaves");
    public static final TagKey<Item> MINECRAFT_TERRACOTTA = TagUtil.getItemTagKey(MINECRAFT, "terracotta");
    public static final TagKey<Item> MINECRAFT_FISHES = TagUtil.getItemTagKey(MINECRAFT, "fishes");

    public static final String CREATE = "create";
    public static final TagKey<Block> CREATE_FAN_HEATERS = TagUtil.getBlockTagKey(CREATE, "fan_heaters");
    public static final TagKey<Item> CREATE_UPRIGHT_ON_BELT = TagUtil.getItemTagKey(CREATE, "upright_on_belt");

    public static final String FARMERS_DELIGHT = "farmersdelight";
    public static final TagKey<Block> FARMERS_DELIGHT_HEAT_SOURCES = TagUtil.getBlockTagKey(FARMERS_DELIGHT, "heat_sources");
    public static final TagKey<Block> FARMERS_DELIGHT_WILD_CROPS = TagUtil.getBlockTagKey(FARMERS_DELIGHT, "wild_crops");
    public static final TagKey<Item> FARMERS_DELIGHT_WILD_CROPS_ITEM = TagUtil.getItemTagKey(FARMERS_DELIGHT, "wild_crops");
    public static final TagKey<Item> FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS = TagUtil.getItemTagKey(FARMERS_DELIGHT, "cabbage_roll_ingredients");

    public static final String SUPPLEMENTARIES = "supplementaries";
    public static final TagKey<Item> SUPPLEMENTARIES_COOKIES = TagUtil.getItemTagKey(SUPPLEMENTARIES, "cookies");

    public static final String DEHYDRATION = "dehydration";
    public static final TagKey<Item> DEHYDRATION_HYDRATING_DRINKS = TagUtil.getItemTagKey(DEHYDRATION, "hydrating_drinks");
    public static final TagKey<Item> DEHYDRATION_HYDRATING_STEW = TagUtil.getItemTagKey(DEHYDRATION, "hydrating_stew");

    public static final String ORIGINS = "origins";
    public static final TagKey<Item> ORIGINS_MEAT = TagUtil.getItemTagKey(ORIGINS, "meat");
    public static final TagKey<Item> ORIGINS_IGNORE_DIET = TagUtil.getItemTagKey(ORIGINS, "ignore_diet");

}
