//package com.chefmooon.ubesdelight.integration.rrv.fabric;
//
//import cc.cassian.rrv.api.ReliableRecipeViewerClientPlugin;
//import cc.cassian.rrv.api.recipe.ItemView;
//import cc.cassian.rrv.client.recipe.ClientRecipeManager;
//import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeTypesImpl;
//import com.chefmooon.ubesdelight.integration.rrv.baking_mat.fabric.BakingMatClientRecipe;
//
 // TODO: fix rrv
//public class RRVPluginImpl implements ReliableRecipeViewerClientPlugin {
//    @Override
//    public void onIntegrationInitialize() {
//        ItemView.addClientRecipeProvider(recipeList -> {
//            // Baking Mat
//            ClientRecipeManager.INSTANCE.getRecipesForType(UbesDelightRecipeTypesImpl.BAKING_MAT.get()).forEach(recipeHolder -> {
//                var recipe = recipeHolder.value();
//                recipeList.add(new BakingMatClientRecipe(recipeHolder.id().identifier(), recipe.getIngredients(), recipe.getTool(), recipe.getProcessStages(), recipe.getMandatoryResults(), recipe.getVariableResult()));
//            });
//        });
//    }
//}
