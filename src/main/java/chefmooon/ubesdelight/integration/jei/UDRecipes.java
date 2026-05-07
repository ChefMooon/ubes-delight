package chefmooon.ubesdelight.integration.jei;

import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

public class UDRecipes {
    private final RecipeManager recipeManager;

    public UDRecipes() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;

        if (level != null) {
            this.recipeManager = level.getRecipeManager();
        } else {
            throw new NullPointerException("minecraft world must not be null.");
        }
    }

    public List<BakingMatRecipe> getBakingMatRecipes() {
        return recipeManager.getAllRecipesFor(UbesDelightRecipeTypes.BAKING_MAT.get()).stream().map(RecipeHolder::value).toList();
    }
}
