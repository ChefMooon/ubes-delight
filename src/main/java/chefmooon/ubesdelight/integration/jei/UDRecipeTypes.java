package chefmooon.ubesdelight.integration.jei;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import mezz.jei.api.recipe.RecipeType;

public class UDRecipeTypes {
    public static final RecipeType<BakingMatRecipe> BAKING_MAT = RecipeType.create(UbesDelight.MOD_ID, "baking_mat", BakingMatRecipe.class);
}
