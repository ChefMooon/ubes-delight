package com.chefmooon.ubesdelight.data.fabric.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.crafting.ingredient.ChanceResult;
import vectorwing.farmersdelight.common.registry.ModRecipeSerializers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CuttingBoardRecipeBuilder implements RecipeBuilder {
    private final List<ChanceResult> results = new ArrayList<>(4);
    private final Ingredient ingredient;
    private final Ingredient tool;
    private String soundEventID;

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

    public CuttingBoardRecipeBuilder addSound(String soundEventID) {
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
        if (!this.results.isEmpty()) {
            return this.results.get(0).stack().getItem();
        }
        return null;
    }

    @Override
    public void save(Consumer<FinishedRecipe> finishedRecipeConsumer, ResourceLocation recipeId) {
        finishedRecipeConsumer.accept(new Result(recipeId.withPrefix("farmersdelight/cutting/"), this.results, this.ingredient, this.tool, this.soundEventID == null ? "" : this.soundEventID));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final List<ChanceResult> results;
        private final Ingredient ingredient;
        private final Ingredient tool;
        private String soundEventID;

        public Result(ResourceLocation id, List<ChanceResult> results, Ingredient ingredient, Ingredient tool, String soundEventID) {
            this.id = id;
            this.results = results;
            this.ingredient = ingredient;
            this.tool = tool;
            this.soundEventID = soundEventID;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonArray ingredients = new JsonArray();
            ingredients.add(this.ingredient.toJson());
            json.add("ingredients", ingredients);

            JsonArray jsonArray = new JsonArray();
            for (ChanceResult result : this.results) {
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
            return ModRecipeSerializers.CUTTING.get();
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
