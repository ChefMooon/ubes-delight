package com.chefmooon.ubesdelight.integration.jei.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.crafting.neoforge.BakingMatRecipeImpl;
import mezz.jei.api.recipe.RecipeType;

public class UDRecipeTypesImpl {
    public static final RecipeType<BakingMatRecipeImpl> BAKING_MAT = RecipeType.create(UbesDelight.MOD_ID, "baking_mat", BakingMatRecipeImpl.class);
}
