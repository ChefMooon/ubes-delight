package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.data.fabric.recipe.*;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                HolderGetter<Item> holderGetter = provider.lookupOrThrow(Registries.ITEM);

                CookingRecipes.register(holderGetter, provider, recipeOutput);
                CraftingRecipes.register(holderGetter, provider, recipeOutput);
                CuttingRecipes.register(holderGetter, provider, recipeOutput);
                SmeltingRecipes.register(holderGetter, provider, recipeOutput);
                BakingMatRecipes.register(holderGetter, provider, recipeOutput);
            }
        };
    }

    @Override
    public String getName() {
        return "Ube's Delight Recipes";
    }
}
