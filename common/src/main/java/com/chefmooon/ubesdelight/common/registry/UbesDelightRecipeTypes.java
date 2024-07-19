package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public class UbesDelightRecipeTypes {
    public static final ResourceLocation BAKING_MAT = TextUtils.res("baking_mat");

    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<>()
        {
            public String toString() {
                return UbesDelight.MOD_ID + ":" + identifier;
            }
        };
    }
}
