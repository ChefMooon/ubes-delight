package com.chefmooon.ubesdelight.integration.emi.fabric;

import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeTypesImpl;
import com.chefmooon.ubesdelight.integration.emi.UDRecipeCategories;
import com.chefmooon.ubesdelight.integration.emi.UDRecipeWorkstations;
import com.chefmooon.ubesdelight.integration.emi.recipe.BakingMatEmiRecipe;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;

public class EMIPluginImpl implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(UDRecipeCategories.BAKING_MAT);

        registry.addWorkstation(UDRecipeCategories.BAKING_MAT, UDRecipeWorkstations.BAKING_MAT);

        for (BakingMatRecipeImpl recipe : registry.getRecipeManager().getAllRecipesFor(UbesDelightRecipeTypesImpl.BAKING_MAT.get())) {
            registry.addRecipe(new BakingMatEmiRecipe(recipe.getId(), EmiIngredient.of(recipe.getTool()), recipe.getIngredients().stream().map(EmiIngredient::of).toList(),
                    recipe.getProcessStages().stream().map(EmiIngredient::of).toList(),
                    recipe.getRollableResults().stream().map(chanceResult -> EmiStack.of(chanceResult.stack()).setChance(chanceResult.chance())).toList()));
        }
    }
}
