package com.chefmooon.ubesdelight.common.crafting;

import com.chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;

public class BakingMatRecipe {
    protected final ResourceLocation id;
    protected final String group;
    protected final NonNullList<Ingredient> ingredientList;
    protected final NonNullList<Ingredient> processStages;
    protected final Ingredient tool;
    protected final NonNullList<ChanceResult> resultList;
    protected final String soundEvent;

    public BakingMatRecipe(ResourceLocation id, String group, NonNullList<Ingredient> ingredientList, NonNullList<Ingredient> processStages, Ingredient tool, NonNullList<ChanceResult> resultList, String soundEvent) {
        this.id = id;
        this.group = group;
        this.ingredientList = ingredientList;
        this.processStages = processStages;
        this.tool = tool;
        this.resultList = resultList;
        this.soundEvent = soundEvent;
    }
}
