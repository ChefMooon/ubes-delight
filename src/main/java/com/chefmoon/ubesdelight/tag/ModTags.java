package com.chefmoon.ubesdelight.tag;

import com.chefmoon.ubesdelight.util.TagUtil;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public class ModTags {
    // Using common tag for extra compat, is this better?
    public static final TagKey<Item> FOOD_WRAPPERS = TagUtil.registerCommonItem("food_wrappers");
    public static final TagKey<Item> FOOD_WRAPPERS_LUMPIA_WRAPPERS = TagUtil.registerCommonItem("food_wrappers/lumpia_wrappers");
}
