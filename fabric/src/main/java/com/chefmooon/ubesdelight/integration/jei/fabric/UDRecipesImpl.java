package com.chefmooon.ubesdelight.integration.jei.fabric;

import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeTypesImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

public class UDRecipesImpl {
    private final RecipeManager recipeManager;

    public UDRecipesImpl() {
        Minecraft minecraft = Minecraft.getInstance();
        ClientLevel level = minecraft.level;

        if (level != null) {
            this.recipeManager = level.getRecipeManager();
        } else {
            throw new NullPointerException("minecraft world must not be null.");
        }
    }

    public List<BakingMatRecipeImpl> getBakingMatRecipes() {
        return recipeManager.getAllRecipesFor(UbesDelightRecipeTypesImpl.BAKING_MAT.get()).stream().toList();
    }
}
