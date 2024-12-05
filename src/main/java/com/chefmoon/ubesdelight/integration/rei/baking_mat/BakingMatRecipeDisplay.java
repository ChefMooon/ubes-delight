package com.chefmoon.ubesdelight.integration.rei.baking_mat;

import com.chefmoon.ubesdelight.integration.rei.ChanceArrayIngredient;
import com.chefmoon.ubesdelight.integration.rei.UbesDelightREI;
import com.chefmoon.ubesdelight.recipe.BakingMatRecipe;
import com.google.common.collect.ImmutableList;
import me.shedaniel.math.Point;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class BakingMatRecipeDisplay extends BasicDisplay {

    private final EntryIngredient toolInput;
    protected final List<ChanceArrayIngredient> chanceOutputs;
    protected final List<EntryIngredient> mandatoryOutputs;
    protected final List<EntryIngredient> processStages;
    public BakingMatRecipeDisplay(BakingMatRecipe recipe) {
        super(EntryIngredients.ofIngredients(recipe.getIngredients()), recipe.getResultList().stream().map(EntryIngredients::of).toList());
        toolInput = EntryIngredients.ofIngredient(recipe.getTool());
        mandatoryOutputs = recipe.getMandatoryResult().stream().map(EntryIngredients::of).toList();
        chanceOutputs = recipe.getVariableResult().stream().map(ChanceArrayIngredient::new).toList();
        processStages = EntryIngredients.ofIngredients(recipe.getProcessStages());
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
        return UbesDelightREI.BAKING_MAT;
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

    public List<ChanceArrayIngredient> getChanceOutputs() {
        return chanceOutputs;
    }

    public List<EntryIngredient> getMandatoryOutputs() {
        return mandatoryOutputs;
    }

    public List<EntryIngredient> getProcessStages() {
        return processStages;
    }
}
