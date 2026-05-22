package chefmooon.ubesdelight.integration.rrv;

import cc.cassian.rrv.api.ReliableRecipeViewerClientPlugin;
import cc.cassian.rrv.api.recipe.ItemView;
import cc.cassian.rrv.client.recipe.ClientRecipeManager;
import chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
import chefmooon.ubesdelight.integration.rrv.baking_mat.BakingMatClientRecipe;

public class RRVPlugin implements ReliableRecipeViewerClientPlugin {
    @Override
    public void onIntegrationInitialize() {
        ItemView.addClientRecipeProvider(recipeList -> {
            // Baking Mat
            ClientRecipeManager.INSTANCE.getRecipesForType(UbesDelightRecipeTypes.BAKING_MAT.get()).forEach(recipeHolder -> {
                var recipe = recipeHolder.value();
                recipeList.add(new BakingMatClientRecipe(recipeHolder.id().identifier(), recipe.getIngredients(), recipe.getTool(), recipe.getProcessStages(), recipe.getMandatoryResults(), recipe.getVariableResult()));
            });
        });
    }
}
