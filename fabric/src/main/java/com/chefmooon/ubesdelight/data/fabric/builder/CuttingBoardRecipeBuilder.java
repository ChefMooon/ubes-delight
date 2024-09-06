package com.chefmooon.ubesdelight.data.fabric.builder;

import net.minecraft.advancements.Criterion;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.crafting.CuttingBoardRecipe;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;

import java.util.Optional;

public class CuttingBoardRecipeBuilder implements RecipeBuilder {
    private final NonNullList<ChanceResult> results = NonNullList.createWithCapacity(4);
    private final Ingredient ingredient;
    private final Ingredient tool;
    private SoundEvent soundEvent;

    private CuttingBoardRecipeBuilder(Ingredient ingredient, Ingredient tool, ItemStack mainResult, int count, float chance) {
        this.results.add(new ChanceResult(new ItemStack(mainResult.getItem(), count), chance));
        this.ingredient = ingredient;
        this.tool = tool;
    }

    public static CuttingBoardRecipeBuilder create(Item input, Ingredient tool, Item output, Integer count, float chance) {
        return new CuttingBoardRecipeBuilder(Ingredient.of(input), tool, new ItemStack(output), count, chance);
    }
    public static CuttingBoardRecipeBuilder create(Item input, Ingredient tool, Item output, Integer count) {
        return new CuttingBoardRecipeBuilder(Ingredient.of(input), tool, new ItemStack(output), count, 1);
    }
    public static CuttingBoardRecipeBuilder create(Item input, Ingredient tool, Item output) {
        return new CuttingBoardRecipeBuilder(Ingredient.of(input), tool, new ItemStack(output), 1, 1);
    }

    public CuttingBoardRecipeBuilder output(Item output, Integer count, float chance) {
        this.results.add(new ChanceResult(new ItemStack(output, count), chance));
        return this;
    }

    public CuttingBoardRecipeBuilder output(Item output, float chance) {
        return this.output(output, 1, chance);
    }

    public CuttingBoardRecipeBuilder output(Item output) {
        return this.output(output, 1, 1.0F);
    }

    public CuttingBoardRecipeBuilder addSound(SoundEvent soundEvent) {
        this.soundEvent = soundEvent;
        return this;
    }

    @Override
    public RecipeBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String groupName) {
        return null;
    }

    @Override
    public Item getResult() {
        if (!this.results.isEmpty()) {
            return this.results.get(0).stack().getItem();
        }
        return null;
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        CuttingBoardRecipe recipe = new CuttingBoardRecipe(
                "",
                this.ingredient,
                this.tool,
                this.results,
                this.soundEvent == null ? Optional.empty() : Optional.of(this.soundEvent)
        );
        output.accept(id.withPrefix("farmersdelight/cutting/"), recipe, null);
    }
}
