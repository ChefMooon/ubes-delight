package chefmooon.ubesdelight.integration.jei;

import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.world.item.crafting.RecipeHolder;

public class UDRecipeTypesImpl {
    public static final IRecipeType<RecipeHolder<BakingMatRecipe>> BAKING_MAT = IRecipeType.create(UbesDelightRecipeTypes.BAKING_MAT.get());
}
