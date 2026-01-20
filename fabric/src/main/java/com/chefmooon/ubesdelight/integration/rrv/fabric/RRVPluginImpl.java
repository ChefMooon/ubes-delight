package com.chefmooon.ubesdelight.integration.rrv.fabric;

import cc.cassian.rrv.api.ReliableRecipeViewerPlugin;
import cc.cassian.rrv.api.recipe.ItemView;
import cc.cassian.rrv.common.recipe.ServerRecipeManager;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeTypesImpl;
import com.chefmooon.ubesdelight.integration.rrv.baking_mat.fabric.BakingMatServerRecipe;
import com.chefmooon.ubesdelight.integration.rrv.baking_mat.fabric.BakingMatViewRecipe;

import java.util.Collections;

public class RRVPluginImpl implements ReliableRecipeViewerPlugin {
    @Override
    public void onIntegrationInitialize() {
        ItemView.addServerRecipeProvider(recipeList -> {
            // Baking Mat - ServerSide
            ServerRecipeManager.INSTANCE.getRecipesForType(UbesDelightRecipeTypesImpl.BAKING_MAT.get()).forEach(recipe -> {
                recipeList.add(new BakingMatServerRecipe(recipe.getIngredients(), recipe.getTool(), recipe.getProcessStages(), recipe.getMandatoryResults(), recipe.getVariableResult()));
            });
        });

        // Baking Mat - ClientSide
        ItemView.addClientRecipeWrapper(BakingMatServerRecipe.TYPE, modRecipe -> Collections.singletonList(new BakingMatViewRecipe(modRecipe)));
    }
}
