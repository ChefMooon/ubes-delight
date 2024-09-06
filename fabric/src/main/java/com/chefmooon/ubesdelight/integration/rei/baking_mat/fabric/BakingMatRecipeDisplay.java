package com.chefmooon.ubesdelight.integration.rei.baking_mat.fabric;

import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.integration.rei.fabric.REICategoryIdentifiersImpl;
import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.Pair;
import me.shedaniel.math.Point;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BakingMatRecipeDisplay extends BasicDisplay {

    private EntryIngredient toolInput;
    private List<Pair<EntryIngredient, Float>> chanceOutputs;
    private final List<EntryIngredient> mandatoryOutputs;
    private final List<EntryIngredient> processStages;
    public BakingMatRecipeDisplay(RecipeHolder<BakingMatRecipeImpl> recipe) {
        this(EntryIngredients.ofIngredients(recipe.value().getIngredients()), recipe.value().getResultList().stream().map(EntryIngredients::of).toList(), Optional.of(recipe.id()), EntryIngredients.ofIngredient(recipe.value().getTool()), EntryIngredients.ofIngredients(recipe.value().getProcessStages()), recipe.value().getMandatoryResults().stream().map(EntryIngredients::of).toList(), recipe.value().getVariableResult().stream().map(result -> Pair.of(EntryIngredients.of(result.stack()), result.chance())).toList());
    }

    public BakingMatRecipeDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs, Optional<ResourceLocation> location, CompoundTag compoundTag) {
        this(inputs, outputs, location, EntryIngredient.of(EntryStack.read(compoundTag.getCompound("tool"))), deserializeProcessingStages(compoundTag), deserializeMandatoryResults(compoundTag), deserializeChanceResults(compoundTag));
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
        return REICategoryIdentifiersImpl.BAKING_MAT;
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

    private static List<Pair<EntryIngredient, Float>> deserializeChanceResults(CompoundTag tag) {
        ImmutableList.Builder<Pair<EntryIngredient, Float>> builder = new ImmutableList.Builder<>();
        ListTag innerTag = tag.getList("chance_results", Tag.TAG_COMPOUND);
        for (int i = 0; i < innerTag.size(); ++i) {
            CompoundTag entry = innerTag.getCompound(i);
            builder.add(Pair.of(EntryIngredient.of(EntryStack.read(entry.getCompound("stack"))), entry.getFloat("chance")));
        }
        return builder.build();
    }

    private static List<EntryIngredient> deserializeProcessingStages(CompoundTag tag) {
        ImmutableList.Builder<EntryIngredient> builder = new ImmutableList.Builder<>();
        ListTag innerTag = tag.getList("processing_stages", Tag.TAG_COMPOUND);
        for (int i = 0; i < innerTag.size(); ++i) {
            CompoundTag entry = innerTag.getCompound(i);
            builder.add(EntryIngredient.of(EntryStack.read(entry.getCompound("stack"))));
        }
        return builder.build();
    }

    private static List<EntryIngredient> deserializeMandatoryResults(CompoundTag tag) {
        ImmutableList.Builder<EntryIngredient> builder = new ImmutableList.Builder<>();
        ListTag innerTag = tag.getList("mandatory_results", Tag.TAG_COMPOUND);
        for (int i = 0; i < innerTag.size(); ++i) {
            CompoundTag entry = innerTag.getCompound(i);
            builder.add(EntryIngredient.of(EntryStack.read(entry.getCompound("stack"))));
        }
        return builder.build();
    }

    public static Serializer<BakingMatRecipeDisplay> serializer() {
        return Serializer.of(BakingMatRecipeDisplay::new, ((display, tag) -> {
            display.toolInput = EntryIngredient.of(EntryStack.read(tag.getCompound("tool")));
            display.chanceOutputs = deserializeChanceResults(tag);
        }));
    }
}
