package com.chefmooon.ubesdelight.integration.jei.fabric;

import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeTypesImpl;
import net.fabricmc.fabric.api.recipe.v1.sync.SynchronizedRecipes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;

public class UDRecipesImpl {
    private final SynchronizedRecipes synchronizedRecipes;

    public UDRecipesImpl() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;

        if (level != null) {
            synchronizedRecipes = level.recipeAccess().getSynchronizedRecipes();
        } else {
            throw new NullPointerException("minecraft world must not be null.");
        }
    }

    public List<RecipeHolder<BakingMatRecipeImpl>> getBakingMatRecipes() {
        return List.copyOf(synchronizedRecipes.getAllOfType(UbesDelightRecipeTypesImpl.BAKING_MAT.get()));
    }
}
