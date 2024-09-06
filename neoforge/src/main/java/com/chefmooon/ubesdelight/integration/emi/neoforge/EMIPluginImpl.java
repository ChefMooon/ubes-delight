package com.chefmooon.ubesdelight.integration.emi.neoforge;

import com.chefmooon.ubesdelight.common.crafting.neoforge.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.neoforge.UbesDelightRecipeTypesImpl;
import com.chefmooon.ubesdelight.integration.emi.UDRecipeCategories;
import com.chefmooon.ubesdelight.integration.emi.UDRecipeWorkstations;
import com.chefmooon.ubesdelight.integration.emi.recipe.BakingMatEmiRecipe;
import dev.emi.emi.api.EmiEntrypoint;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.world.item.crafting.RecipeHolder;

@EmiEntrypoint
public class EMIPluginImpl implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(UDRecipeCategories.BAKING_MAT);

        registry.addWorkstation(UDRecipeCategories.BAKING_MAT, UDRecipeWorkstations.BAKING_MAT);

        for (RecipeHolder<BakingMatRecipeImpl> recipe : registry.getRecipeManager().getAllRecipesFor(UbesDelightRecipeTypesImpl.BAKING_MAT.get())) {
            registry.addRecipe(new BakingMatEmiRecipe(recipe.id(), EmiIngredient.of(recipe.value().getTool()), recipe.value().getIngredients().stream().map(EmiIngredient::of).toList(),
                    recipe.value().getProcessStages().stream().map(EmiIngredient::of).toList(),
                    recipe.value().getRollableResults().stream().map(chanceResult -> EmiStack.of(chanceResult.stack()).setChance(chanceResult.chance())).toList()));
        }
    }
}
