package com.chefmooon.ubesdelight.data.fabric.builder;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.crafting.CookingPotRecipe;

import java.util.LinkedHashMap;
import java.util.Map;

public class CookingPotRecipeJsonBuilder implements RecipeBuilder {

    private CookingPotRecipeBookTab tab;
    private final ItemStack output;
    private final int outputCount;
    private final ItemStack container;
    private final NonNullList<Ingredient> inputs;
    private final float experience;
    private final int cookingTime;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    private CookingPotRecipeJsonBuilder(ItemStack output, int outputCount, @Nullable Item container, NonNullList<Ingredient> inputs, float experience, int cookingTime) {
        this.output = output;
        this.outputCount = outputCount;
        this.container = container != null ? new ItemStack(container) : ItemStack.EMPTY;
        this.inputs = inputs;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    public static CookingPotRecipeJsonBuilder create(ItemLike output, int outputCount, int cookingTime, float experience, Item container, NonNullList<Ingredient> inputs) {
        return new CookingPotRecipeJsonBuilder(new ItemStack(output), outputCount, container, inputs, experience, cookingTime);
    }

    public static CookingPotRecipeJsonBuilder create(ItemLike output, int outputCount, int cookingTime, float experience, NonNullList<Ingredient> inputs) {
        return new CookingPotRecipeJsonBuilder(new ItemStack(output), outputCount, null, inputs, experience, cookingTime);
    }

    public CookingPotRecipeJsonBuilder input(TagKey<Item> tag) {
        return this.input(Ingredient.of(tag));
    }

    public CookingPotRecipeJsonBuilder input(ItemLike item) {
        return this.input(item, 1);
    }

    public CookingPotRecipeJsonBuilder input(ItemLike itemProvider, int size) {
        for(int i = 0; i < size; ++i) {
            this.input(Ingredient.of(itemProvider));
        }

        return this;
    }

    public CookingPotRecipeJsonBuilder input(Ingredient ingredient) {
        return this.input((Ingredient) ingredient, 1);
    }

    public CookingPotRecipeJsonBuilder input(Ingredient ingredient, int size) {
        for(int i = 0; i < size; ++i) {
            this.inputs.add(ingredient);
        }
        return this;
    }

    @Override
    public CookingPotRecipeJsonBuilder unlockedBy(String criterionName, Criterion<?> criterionTrigger) {
        this.criteria.put(criterionName, criterionTrigger);
        return this;
    }

    public CookingPotRecipeJsonBuilder unlockedBy(String criterionName, ItemLike... items) {
        return unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }

    public CookingPotRecipeJsonBuilder unlockedByAny(ItemLike ... items) {
        this.criteria.put("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
        return this;
    }

    public CookingPotRecipeJsonBuilder setRecipeBookTab(CookingPotRecipeBookTab tab) {
        this.tab = tab;
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String groupName) {
        return null;
    }

    @Override
    public Item getResult() {
        return this.output.getItem();
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        ResourceLocation recipeId = id.withPrefix("farmersdelight/cooking/");
        Advancement.Builder advancementBuilder = output.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId))
                .rewards(AdvancementRewards.Builder.recipe(recipeId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancementBuilder::addCriterion);
        CookingPotRecipe recipe = new CookingPotRecipe(
                "",
                this.tab,
                this.inputs,
                new ItemStack(this.output.getItem(), this.outputCount),
                this.container,
                this.experience,
                this.cookingTime
        );
        output.accept(recipeId, recipe, advancementBuilder.build(id.withPrefix("farmersdelight/recipes/cooking/")));
    }
}
