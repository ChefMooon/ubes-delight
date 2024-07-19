package com.chefmooon.ubesdelight.data.fabric.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModRecipeSerializers;

import java.util.List;
import java.util.function.Consumer;

public class CookingPotRecipeJsonBuilder implements RecipeBuilder {

    private CookingPotRecipeBookTab tab;
    private final Item output;
    private final int outputCount;
    private final Item container;
    private final List<Ingredient> inputs;
    private final float experience;
    private final int cookingTime;
    private final Advancement.Builder advancement = Advancement.Builder.recipeAdvancement();
    private CookingPotRecipeJsonBuilder(ItemLike output, int outputCount, @Nullable Item container, List<Ingredient> inputs, float experience, int cookingTime) {
        this.output = output.asItem();
        this.outputCount = outputCount;
        this.container = container != null ? container.asItem() : null;
        this.inputs = inputs;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    public static CookingPotRecipeJsonBuilder create(ItemLike output, int outputCount, int cookingTime, float experience, Item container, List<Ingredient> inputs) {
        return new CookingPotRecipeJsonBuilder(output, outputCount, container, inputs, experience, cookingTime);
    }

    public static CookingPotRecipeJsonBuilder create(ItemLike output, int outputCount, int cookingTime, float experience, List<Ingredient> inputs) {
        return new CookingPotRecipeJsonBuilder(output, outputCount, null, inputs, experience, cookingTime);
    }

    //public static CookingPotRecipeJsonBuilder create(ItemLike output, int outputCount, int cookingTime, List<Ingredient> inputs) {
    //    return new CookingPotRecipeJsonBuilder(output, outputCount, null, inputs, .0F, cookingTime);
    //}
    //public static CookingPotRecipeJsonBuilder create(ItemLike output, int cookingTime, List<Ingredient> inputs) {
    //    return new CookingPotRecipeJsonBuilder(output, 1, null, inputs, .0F, cookingTime);
    //}

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
    public CookingPotRecipeJsonBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        this.advancement.addCriterion(criterionName, criterionTrigger);
        return this;
    }

    public CookingPotRecipeJsonBuilder unlockedBy(String criterionName, ItemLike... items) {
        return unlockedBy(criterionName, InventoryChangeTrigger.TriggerInstance.hasItems(items));
    }

    public CookingPotRecipeJsonBuilder unlockedByAny(ItemLike ... items) {
        advancement.addCriterion("has_any_ingredient", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items).build()));
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
        return this.output;
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
        this.ensureValid(recipeId);
        String fdCookingPrefix = "farmersdelight/cooking/";
        this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(recipeId.withPrefix(fdCookingPrefix))).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(recipeId.withPrefix(fdCookingPrefix))).requirements(RequirementsStrategy.OR);
        finishedRecipeConsumer.accept(new Result(recipeId.withPrefix(fdCookingPrefix), this.tab, this.output, this.outputCount, this.container, this.inputs, this.experience, this.cookingTime, this.advancement, recipeId.withPrefix("recipes/" + fdCookingPrefix)));
    }

    private void ensureValid(ResourceLocation id) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final CookingPotRecipeBookTab tab;
        private final Item output;
        private final int outputCount;
        private final Item container;
        private final List<Ingredient> inputs;
        private final float experience;
        private final int cookingTime;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation id, CookingPotRecipeBookTab tab, Item output, int outputCount, Item container, List<Ingredient> inputs, float experience, int cookingTime, Advancement.Builder advancement, ResourceLocation advancementId) {
            this.id = id;
            this.tab = tab;
            this.output = output;
            this.outputCount = outputCount;
            this.container = container;
            this.inputs = inputs;
            this.experience = experience;
            this.cookingTime = cookingTime;
            this.advancement = advancement;
            this.advancementId = advancementId;
        }


        @Override
        public void serializeRecipeData(JsonObject json) {
            if (tab != null) {
                json.addProperty("recipe_book_tab", tab.toString());
            }

            json.addProperty("cookingtime", cookingTime);

            if (experience > 0) {
                json.addProperty("experience", experience);
            }

            JsonArray arrayIngredients = new JsonArray();

            for (Ingredient input : inputs) {
                arrayIngredients.add(input.toJson());
            }
            json.add("ingredients", arrayIngredients);

            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", BuiltInRegistries.ITEM.getKey(output).toString());
            if (outputCount > 1) {
                objectResult.addProperty("count", outputCount);
            }
            json.add("result", objectResult);

            if (container != null) {
                JsonObject objectContainer = new JsonObject();
                objectContainer.addProperty("item", BuiltInRegistries.ITEM.getKey(container).toString());
                json.add("container", objectContainer);
            }
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return ModRecipeSerializers.COOKING.get();
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
