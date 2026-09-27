package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.data.recipe.*;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import vectorwing.farmersdelight.data.Recipes;

import java.util.concurrent.CompletableFuture;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, BootstrapContext<Recipe<?>> recipeBootstrapContext, BootstrapContext<Advancement> advancementBootstrapContext) {
        return new RecipeProvider(recipeBootstrapContext, advancementBootstrapContext) {
            @Override
            public void buildRecipes() {
                Recipes.recipeContext = recipeBootstrapContext;
                HolderGetter<Item> holderGetter = provider.lookupOrThrow(Registries.ITEM);

                CookingRecipes.register(holderGetter, provider, output);
                CraftingRecipes.register(holderGetter, provider, output);
                CuttingRecipes.register(holderGetter, provider, output);
                SmeltingRecipes.register(holderGetter, provider, output);
                BakingMatRecipes.register(holderGetter, provider, output);
            }
        };
    }

    @Override
    public String getName() {
        return "Ube's Delight Recipes";
    }
}
