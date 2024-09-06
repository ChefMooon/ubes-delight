package com.chefmooon.ubesdelight.common.crafting;

import com.chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Optional;

public class BakingMatRecipe {
    protected final String group;
    protected final NonNullList<Ingredient> ingredientList;
    protected final NonNullList<Ingredient> processStages;
    protected final Ingredient tool;
    protected final NonNullList<ChanceResult> resultList;
    protected final Optional<SoundEvent> soundEvent;

    public BakingMatRecipe(String group, NonNullList<Ingredient> ingredientList, NonNullList<Ingredient> processStages, Ingredient tool, NonNullList<ChanceResult> resultList, Optional<SoundEvent> soundEvent) {
        this.group = group;
        this.ingredientList = ingredientList;
        this.processStages = processStages;
        this.tool = tool;
        this.resultList = resultList;
        this.soundEvent = soundEvent;
    }
}
