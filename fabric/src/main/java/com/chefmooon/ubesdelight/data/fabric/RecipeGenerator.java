package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.data.fabric.recipe.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        CookingRecipes.register(exporter);
        CraftingRecipes.register(exporter);
        CuttingRecipes.register(exporter);
        SmeltingRecipes.register(exporter);
        BakingMatRecipes.register(exporter);
    }
}
