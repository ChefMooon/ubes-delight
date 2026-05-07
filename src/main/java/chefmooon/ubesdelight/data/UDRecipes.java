package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.data.recipe.*;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.CompletableFuture;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class UDRecipes extends RecipeProvider {
    public UDRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        CraftingRecipes.register(output);
        SmeltingRecipes.register(output);
        CookingRecipes.register(output);
        CuttingRecipes.register(output);
        BakingMatRecipes.register(output);
    }
}
