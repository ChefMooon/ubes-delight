package com.chefmooon.ubesdelight.integration.emi.recipe;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.integration.emi.UDRecipeCategories;
import com.mojang.datafixers.util.Pair;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BakingMatEmiRecipe implements EmiRecipe {

    ResourceLocation BACKGROUND = new ResourceLocation(UbesDelight.MOD_ID, "textures/gui/emi/baking_mat.png");
    private final ResourceLocation id;
    private final EmiIngredient tool;
    private final List<EmiIngredient> inputs;
    private final List<EmiIngredient> processStages;
    private final List<EmiStack> outputs;

    public BakingMatEmiRecipe(ResourceLocation id, EmiIngredient tool, List<EmiIngredient> inputs, List<EmiIngredient> processStages, List<EmiStack> outputs) {
        this.id = id;
        this.tool = tool;
        this.inputs = inputs;
        this.processStages = processStages;
        this.outputs = outputs;
    }

    @Override
    public EmiRecipeCategory getCategory() {
        return UDRecipeCategories.BAKING_MAT;
    }

    @Override
    public @Nullable ResourceLocation getId() {
        return id;
    }

    @Override
    public List<EmiIngredient> getInputs() {
        return inputs;
    }

    @Override
    public List<EmiIngredient> getCatalysts() {
        return List.of(tool);
    }

    @Override
    public List<EmiStack> getOutputs() {
        List<EmiStack> outputsMandatory = new ArrayList<>();
        for (EmiStack stack : outputs) {
            if (stack.getChance() == 1.0f) {
                outputsMandatory.add(stack);
            }
        }
        return outputsMandatory;
    }

    @Override
    public int getDisplayWidth() {
        return 151;
    }

    @Override
    public int getDisplayHeight() {
        return 56;
    }

    @Override
    public void addWidgets(WidgetHolder widgets) {
        List<EmiStack> outputsMandatory = new ArrayList<>();
        List<EmiStack> outputsChance = new ArrayList<>();
        for (EmiStack stack : outputs) {
            if (stack.getChance() == 1.0f) {
                outputsMandatory.add(stack);
            } else {
                outputsChance.add(stack);
            }
        }

        widgets.addTexture(BACKGROUND, 0, 0, 149, 56, 6, 9);

        // Tool
        widgets.addSlot(tool, 57, 0).drawBack(false);

        // Input
        for (int i = 0; i < inputs.size(); i++) {
            Pair<Integer, Integer> slotLoc = getInputItemOffset(19, 19, i);
            widgets.addSlot(inputs.get(i), slotLoc.getFirst(), slotLoc.getSecond())
                    .customBackground(BACKGROUND, 0, 80, 18, 18);
        }

        // Process Stages
        if (processStages.size() > 0) {
            for (int j = 0; j < processStages.size(); j++) {
                widgets.addSlot(processStages.get(j), 57 + j * 19, 38)
                        .customBackground(BACKGROUND, 0, 80, 18, 18);
            }
        }

        // Mandatory Outputs
        for (int k = 0; k < outputsMandatory.size(); k++) {
            widgets.addSlot(outputsMandatory.get(k), 78 + k * 19, 19)
                    .customBackground(BACKGROUND, 0, 80, 18, 18);
        }

        // Chance Outputs
        for (int l = 0; l < outputsChance.size(); l++) {
            widgets.addSlot(outputsChance.get(l), 78 + l * 19, 0)
                    .customBackground(BACKGROUND, 18, 80, 18, 18);
        }
    }

    public static Pair<Integer, Integer> getInputItemOffset(int x, int y, int index) {
        final int xOffset = 19;
        final int yOffset = 19;
        List<Pair<Integer, Integer>> listOfPairs = new ArrayList<>(List.of(
                Pair.of(x, y), Pair.of(x + xOffset, y), Pair.of(x - xOffset, y),
                Pair.of(x, y - yOffset), Pair.of(x, y + yOffset), Pair.of(x + xOffset, y - yOffset),
                Pair.of(x - xOffset, y - yOffset), Pair.of(x + xOffset, y + yOffset), Pair.of(x - xOffset, y + yOffset)));

        return listOfPairs.get(index);
    }
}