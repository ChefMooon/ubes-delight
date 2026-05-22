package chefmooon.ubesdelight.integration.jei;

import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
import net.fabricmc.fabric.api.recipe.v1.sync.SynchronizedRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;

public class UDRecipes {
    private final SynchronizedRecipes synchronizedRecipes;

    public UDRecipes() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;

        if (level != null) {
            synchronizedRecipes = level.recipeAccess().getSynchronizedRecipes();
        } else {
            throw new NullPointerException("minecraft world must not be null.");
        }
    }

    public List<RecipeHolder<BakingMatRecipe>> getBakingMatRecipes() {
        return List.copyOf(synchronizedRecipes.getAllOfType(UbesDelightRecipeTypes.BAKING_MAT.get()));
    }
}
