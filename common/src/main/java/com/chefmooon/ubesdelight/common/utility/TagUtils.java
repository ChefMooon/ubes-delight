package com.chefmooon.ubesdelight.common.utility;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class TagUtils {
    @ExpectPlatform
    public static TagKey<Item> getKifeItemTag() {
        throw new AssertionError();
    }
}
