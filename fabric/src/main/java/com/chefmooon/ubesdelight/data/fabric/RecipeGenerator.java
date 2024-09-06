package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.data.fabric.recipe.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        CookingRecipes.register(exporter);
        CraftingRecipes.register(exporter);
        CuttingRecipes.register(exporter);
        SmeltingRecipes.register(exporter);
        BakingMatRecipes.register(exporter);
    }
}
