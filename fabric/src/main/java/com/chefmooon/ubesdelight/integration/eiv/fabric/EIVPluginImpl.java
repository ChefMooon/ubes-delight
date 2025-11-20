package com.chefmooon.ubesdelight.integration.eiv.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeTypesImpl;
import com.chefmooon.ubesdelight.integration.eiv.baking_mat.fabric.BakingMatServerRecipe;
import com.chefmooon.ubesdelight.integration.eiv.baking_mat.fabric.BakingMatViewRecipe;
import de.crafty.eiv.common.api.IExtendedItemViewIntegration;
import de.crafty.eiv.common.api.recipe.ItemView;
import de.crafty.eiv.common.recipe.ServerRecipeManager;
import net.minecraft.world.item.ItemStack;
import vectorwing.farmersdelight.integration.eiv.info.InfoServerRecipe;
import vectorwing.farmersdelight.integration.eiv.info.InfoViewRecipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EIVPluginImpl implements IExtendedItemViewIntegration {
    @Override
    public void onIntegrationInitialize() {

        //For the server
        ItemView.addRecipeProvider(recipeList -> {
            ServerRecipeManager.INSTANCE.getRecipesForType(UbesDelightRecipeTypesImpl.BAKING_MAT.get()).forEach(recipe -> {
                recipeList.add(new BakingMatServerRecipe(recipe.getIngredients(), recipe.getTool(), recipe.getProcessStages(), recipe.getMandatoryResults(), recipe.getVariableResult()));
            });
        });

        // For the client
        ItemView.registerRecipeWrapper(BakingMatServerRecipe.TYPE, modRecipe -> {
            return Collections.singletonList(new BakingMatViewRecipe(modRecipe));
        });

        ItemView.registerRecipeWrapper(InfoServerRecipe.TYPE, modRecipe -> {
            ArrayList<InfoViewRecipe> infoRecipes = new ArrayList<>();

            List<ItemStack> rollingPinStacks = List.of(
                    UbesDelightItemsImpl.ROLLING_PIN_WOOD.get().getDefaultInstance(),
                    UbesDelightItemsImpl.ROLLING_PIN_GOLD.get().getDefaultInstance(),
                    UbesDelightItemsImpl.ROLLING_PIN_DIAMOND.get().getDefaultInstance(),
                    UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get().getDefaultInstance()
            );
            infoRecipes.add(new InfoViewRecipe(rollingPinStacks, translationKey("rolling_pin")));

            infoRecipes.add(new InfoViewRecipe(List.of(
                    UbesDelightItemsImpl.WILD_UBE.get().getDefaultInstance(),
                    UbesDelightItemsImpl.UBE.get().getDefaultInstance()
            ), translationKey("ube")));
            infoRecipes.add(new InfoViewRecipe(List.of(
                    UbesDelightItemsImpl.WILD_GARLIC.get().getDefaultInstance(),
                    UbesDelightItemsImpl.GARLIC.get().getDefaultInstance()
            ), translationKey("garlic")));
            infoRecipes.add(new InfoViewRecipe(List.of(
                    UbesDelightItemsImpl.WILD_GINGER.get().getDefaultInstance(),
                    UbesDelightItemsImpl.GINGER.get().getDefaultInstance()
            ), translationKey("ginger")));
            infoRecipes.add(new InfoViewRecipe(List.of(
                    UbesDelightItemsImpl.WILD_LEMONGRASS.get().getDefaultInstance(),
                    UbesDelightItemsImpl.LEMONGRASS.get().getDefaultInstance()
            ), translationKey("lemongrass")));


            return infoRecipes;
        });
    }

    private String translationKey(String key) {
        return UbesDelight.MOD_ID + ".rei.info." + key;
    }
}
