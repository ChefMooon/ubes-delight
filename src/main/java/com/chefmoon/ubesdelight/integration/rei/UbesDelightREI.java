package com.chefmoon.ubesdelight.integration.rei;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.integration.rei.baking_mat.BakingMatRecipeCategory;
import com.chefmoon.ubesdelight.integration.rei.baking_mat.BakingMatRecipeDisplay;
import com.chefmoon.ubesdelight.recipe.BakingMatRecipe;
import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import com.chefmoon.ubesdelight.registry.RecipeTypesRegistry;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class UbesDelightREI implements REIClientPlugin {

    public static final CategoryIdentifier<BakingMatRecipeDisplay> BAKING_MAT = CategoryIdentifier.of(UbesDelightMod.MOD_ID, "baking_mat");

    public void registerCategories(CategoryRegistry registry) {
        registry.add(new BakingMatRecipeCategory());
        registry.addWorkstations(BAKING_MAT, EntryStacks.of(BlocksRegistry.BAKING_MAT_BAMBOO.get()));
    }

    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(BakingMatRecipe.class, RecipeTypesRegistry.BAKING_MAT_RECIPE_SERIALIZER.type(), BakingMatRecipeDisplay::new);
    }
}
