package chefmooon.ubesdelight.integration.emi;

import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
import chefmooon.ubesdelight.integration.emi.recipe.BakingMatEmiRecipe;
import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.world.item.crafting.RecipeHolder;

public class EMIPlugin implements EmiPlugin {
    @Override
    public void register(EmiRegistry registry) {
        registry.addCategory(UDRecipeCategories.BAKING_MAT);

        registry.addWorkstation(UDRecipeCategories.BAKING_MAT, UDRecipeWorkstations.BAKING_MAT);

        for (RecipeHolder<BakingMatRecipe> recipe : registry.getRecipeManager().getAllRecipesFor(UbesDelightRecipeTypes.BAKING_MAT.get())) {
            registry.addRecipe(new BakingMatEmiRecipe(recipe.id(), EmiIngredient.of(recipe.value().getTool()), recipe.value().getIngredients().stream().map(EmiIngredient::of).toList(),
                    recipe.value().getProcessStages().stream().map(EmiIngredient::of).toList(),
                    recipe.value().getRollableResults().stream().map(chanceResult -> EmiStack.of(chanceResult.stack()).setChance(chanceResult.chance())).toList()));
        }
    }
}
