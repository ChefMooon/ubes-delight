package com.chefmooon.ubesdelight.data.fabric.builder;

import com.chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeSerializersImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BakingMatRecipeJsonBuilder implements RecipeBuilder {
    private final List<Ingredient> ingredientList;
    private final List<Ingredient> processStages;
    private final List<ChanceResult> resultList = new ArrayList<>(4);
    private final Ingredient tool;
    private String soundEventID;
    private BakingMatRecipeJsonBuilder(List<Ingredient> ingredientList, @Nullable List<Ingredient> processStages, Ingredient tool, ItemStack mainResult, int count, float chance) {
        this.ingredientList = ingredientList;
        this.processStages = processStages;
        this.resultList.add(new ChanceResult(new ItemStack(mainResult.getItem(), count), chance));
        this.tool = tool;
    }

    public static BakingMatRecipeJsonBuilder create(List<Ingredient> ingredientList, @Nullable List<Ingredient> processStages, Ingredient tool, Item mainResult) {
        return new BakingMatRecipeJsonBuilder(ingredientList, processStages, tool, new ItemStack(mainResult), 1, 1);
    }
    public static BakingMatRecipeJsonBuilder create(List<Ingredient> ingredientList, @Nullable List<Ingredient> processStages, Ingredient tool, Item mainResult, int count) {
        return new BakingMatRecipeJsonBuilder(ingredientList, processStages, tool, new ItemStack(mainResult), count, 1);
    }
    public BakingMatRecipeJsonBuilder addOutput(Item item) {
        return this.addOutput(item, 1, 1.f);
    }
    public BakingMatRecipeJsonBuilder addOutput(Item item, Integer count, Float chance) {
        this.resultList.add(new ChanceResult(new ItemStack(item, count), chance));
        return this;
    }
    public BakingMatRecipeJsonBuilder input(TagKey<Item> tag) {
        return this.input(Ingredient.of(tag));
    }
    public BakingMatRecipeJsonBuilder input(TagKey<Item> tag, int size) {
        return this.input(Ingredient.of(tag), size);
    }
    public BakingMatRecipeJsonBuilder input(ItemLike itemProvider) {
        return this.input(Ingredient.of(itemProvider));
    }
    public BakingMatRecipeJsonBuilder input(ItemLike itemProvider, int size) {
        return this.input(Ingredient.of(itemProvider), size);
    }

    public BakingMatRecipeJsonBuilder input(Ingredient ingredient) {
        return this.input((Ingredient) ingredient, 1);
    }

    public BakingMatRecipeJsonBuilder input(Ingredient ingredient, int size) {
        for(int i = 0; i < size; ++i) {
            this.ingredientList.add(ingredient);
        }
        return this;
    }

    public BakingMatRecipeJsonBuilder addSound(String soundEventID) {
        this.soundEventID = soundEventID;
        return this;
    }
    @Override
    public RecipeBuilder unlockedBy(String criterionName, CriterionTriggerInstance criterionTrigger) {
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String groupName) {
        return null;
    }

    @Override
    public Item getResult() {
        if (!this.resultList.isEmpty()) return this.resultList.get(0).stack().getItem();
        return null;
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
        finishedRecipeConsumer.accept(new BakingMatRecipeJsonBuilder.Result(recipeId.withPrefix("baking_mat/"), this.ingredientList, this.processStages, this.resultList, this.tool, this.soundEventID == null ? "" : this.soundEventID));
    }


    public static class Result implements FinishedRecipe {

        private final ResourceLocation id;
        private final List<Ingredient> ingredientList;
        private final List<Ingredient> processStages;
        private final List<ChanceResult> resultList;
        private final Ingredient tool;
        private String soundEventID;

        public Result(ResourceLocation id, List<Ingredient> ingredientList, @Nullable List<Ingredient> processStages, List<ChanceResult> resultList, Ingredient tool, String soundEventID) {
            this.id = id;
            this.ingredientList = ingredientList;
            this.processStages = processStages;
            this.resultList = resultList;
            this.tool = tool;
            this.soundEventID = soundEventID;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonArray arrayIngredients = new JsonArray();
            for (Ingredient input : this.ingredientList) {
                arrayIngredients.add(input.toJson());
            }
            json.add("ingredients", arrayIngredients);

            JsonArray arrayProcessStages = new JsonArray();
            if (this.processStages != null) {
                for (Ingredient processStage : this.processStages) {
                    arrayProcessStages.add(processStage.toJson());
                }
            }
            json.add("processing_stages", arrayProcessStages);

            JsonArray jsonArray = new JsonArray();
            for (ChanceResult result : this.resultList) {
                jsonArray.add(result.serialize());
            }
            json.add("result", jsonArray);

            json.add("tool", this.tool.toJson());

            if (!this.soundEventID.isEmpty()) {
                json.addProperty("sound", this.soundEventID);
            }
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return UbesDelightRecipeSerializersImpl.BAKING_MAT.get();
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
