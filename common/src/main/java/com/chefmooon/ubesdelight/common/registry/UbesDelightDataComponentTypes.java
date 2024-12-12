package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.resources.ResourceLocation;

public class UbesDelightDataComponentTypes {

    public static final ResourceLocation SIMPLE_LEAF_FEAST_SERVINGS = dataComponent("simple_leaf_feast_servings");

    private static ResourceLocation dataComponent(String string) {
        return TextUtils.res(string);
    }
}
