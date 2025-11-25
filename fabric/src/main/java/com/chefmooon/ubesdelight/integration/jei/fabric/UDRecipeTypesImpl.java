package com.chefmooon.ubesdelight.integration.jei.fabric;

import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeTypesImpl;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.world.item.crafting.RecipeHolder;

public class UDRecipeTypesImpl {
    public static final IRecipeType<RecipeHolder<BakingMatRecipeImpl>> BAKING_MAT = IRecipeType.create(UbesDelightRecipeTypesImpl.BAKING_MAT.get());
}
