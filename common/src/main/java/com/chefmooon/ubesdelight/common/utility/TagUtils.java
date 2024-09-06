package com.chefmooon.ubesdelight.common.utility;

import com.chefmooon.ubesdelight.common.tag.CommonTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagUtils {

    // 1.21 - Common tags, yay!
    public static TagKey<Item> getKifeItemTag() {
        return CommonTags.C_TOOLS_KNIFE;
    }
}
