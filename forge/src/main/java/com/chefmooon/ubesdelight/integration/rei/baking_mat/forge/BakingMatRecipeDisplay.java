package com.chefmooon.ubesdelight.integration.rei.baking_mat.forge;

import com.chefmooon.ubesdelight.common.crafting.forge.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.integration.rei.forge.ClientREIPluginImpl;
import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.Pair;
import me.shedaniel.math.Point;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BakingMatRecipeDisplay extends BasicDisplay {

    private final EntryIngredient toolInput;
    private final List<Pair<EntryIngredient, Float>> chanceOutputs;
    private final List<EntryIngredient> mandatoryOutputs;
    private final List<EntryIngredient> processStages;
    public BakingMatRecipeDisplay(BakingMatRecipeImpl recipe) {
        this(EntryIngredients.ofIngredients(recipe.getIngredients()), recipe.getResultList().stream().map(EntryIngredients::of).toList(), Optional.of(recipe.getId()), EntryIngredients.ofIngredient(recipe.getTool()), EntryIngredients.ofIngredients(recipe.getProcessStages()), recipe.getMandatoryResults().stream().map(EntryIngredients::of).toList(), recipe.getVariableResult().stream().map(result -> Pair.of(EntryIngredients.of(result.stack()), result.chance())).toList());
    }

    public BakingMatRecipeDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Optional<ResourceLocation> location, EntryIngredient tool, List<EntryIngredient> processStages, List<EntryIngredient> mandatoryOutputs, List<Pair<EntryIngredient, Float>> chanceOutputs) {
        super(inputs, outputs, location);
        this.toolInput = tool;
        this.mandatoryOutputs = mandatoryOutputs;
        this.chanceOutputs = chanceOutputs;
        this.processStages = processStages;
    }

    public static Point getItemOffset(int x, int y, int index) {
        final int xOffset = 17;
        final int yOffset = 17;
        final Point[] points = {
                new Point(x, y), new Point(x + xOffset, y), new Point(x - xOffset, y),
                new Point(x, y - yOffset), new Point(x, y + yOffset), new Point(x + xOffset, y - yOffset),
                new Point(x - xOffset, y - yOffset), new Point(x + xOffset, y + yOffset), new Point(x - xOffset, y + yOffset)
        };

        return points[index];
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ClientREIPluginImpl.BAKING_MAT;
    }

    @Override
    public List<EntryIngredient> getRequiredEntries() {
        List<EntryIngredient> requiredEntries = new ArrayList<>(super.getRequiredEntries());
        requiredEntries.add(getToolInput());

        return ImmutableList.copyOf(requiredEntries);
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        List<EntryIngredient> inputEntryList = new ArrayList<>(super.getInputEntries());
        inputEntryList.add(getToolInput());
        inputEntryList.addAll(getProcessStages());

        return ImmutableList.copyOf(inputEntryList);
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        List<EntryIngredient> outputEntryList = new ArrayList<>(super.getOutputEntries());
        outputEntryList.addAll(getProcessStages());

        return ImmutableList.copyOf(outputEntryList);
    }

    public List<EntryIngredient> getIngredientEntries() {
        return super.getInputEntries();
    }

    public EntryIngredient getToolInput() {
        return toolInput;
    }

    public List<Pair<EntryIngredient, Float>> getChanceOutputs() {
        return chanceOutputs;
    }

    public List<EntryIngredient> getMandatoryOutputs() {
        return mandatoryOutputs;
    }

    public List<EntryIngredient> getProcessStages() {
        return processStages;
    }
}
