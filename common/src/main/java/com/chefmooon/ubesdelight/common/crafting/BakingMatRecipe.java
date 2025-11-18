package com.chefmooon.ubesdelight.common.crafting;

import com.chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;

import java.util.List;
import java.util.Optional;

public class BakingMatRecipe {
    protected final String group;
    protected final List<Ingredient> ingredientList;
    protected final List<Ingredient> processStages;
    protected final Ingredient tool;
    protected final List<ChanceResult> resultList;
    protected final Optional<SoundEvent> soundEvent;

    protected PlacementInfo placementInfo;

    public BakingMatRecipe(String group, List<Ingredient> ingredientList, List<Ingredient> processStages, Ingredient tool, List<ChanceResult> resultList, Optional<SoundEvent> soundEvent) {
        this.group = group;
        this.ingredientList = ingredientList;
        this.processStages = processStages;
        this.tool = tool;
        this.resultList = resultList;
        this.soundEvent = soundEvent;
    }
}
