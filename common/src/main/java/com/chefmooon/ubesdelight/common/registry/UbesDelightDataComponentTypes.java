package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.resources.Identifier;

public class UbesDelightDataComponentTypes {

    public static final Identifier SIMPLE_LEAF_FEAST_SERVINGS = dataComponent("simple_leaf_feast_servings");

    private static Identifier dataComponent(String string) {
        return TextUtils.res(string);
    }
}
