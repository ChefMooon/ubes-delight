package com.chefmooon.ubesdelight.integration.emi;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.render.EmiRenderable;
import net.minecraft.resources.ResourceLocation;

public class UDRecipeCategories {
    private static final ResourceLocation SIMPLIFIED_TEXTURES = TextUtils.res("textures/gui/emi/simplified.png");

    public static final EmiRecipeCategory BAKING_MAT = new EmiRecipeCategory(TextUtils.res("baking_mat"), UDRecipeWorkstations.BAKING_MAT, simplifiedRenderer(0, 0));

    private static EmiRenderable simplifiedRenderer(int u, int v) {
        return (draw, x, y, delta) -> {
            draw.blit(SIMPLIFIED_TEXTURES, x, y, u, v, 16, 16, 16, 16);
        };
    }
}
