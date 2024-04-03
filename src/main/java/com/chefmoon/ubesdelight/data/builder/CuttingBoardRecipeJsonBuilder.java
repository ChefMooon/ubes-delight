package com.chefmoon.ubesdelight.data.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nhoryzon.mc.farmersdelight.recipe.ingredient.ChanceResult;
import com.nhoryzon.mc.farmersdelight.registry.RecipeTypesRegistry;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CuttingBoardRecipeJsonBuilder extends RecipeJsonBuilder implements CraftingRecipeJsonBuilder {

    private final List<ChanceResult> results = new ArrayList<>(4);
    private final Ingredient ingredient;
    private final Ingredient tool;
    private String soundEventID;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.createUntelemetered();

    public CuttingBoardRecipeJsonBuilder(Ingredient ingredient, Ingredient tool, ItemStack mainResult, int count, float chance) {
        this.results.add(new ChanceResult(new ItemStack(mainResult.getItem(), count), chance));
        this.ingredient = ingredient;
        this.tool = tool;
    }

    public static CuttingBoardRecipeJsonBuilder create(Item input, Ingredient tool, Item output, Integer count, float chance) {
        return new CuttingBoardRecipeJsonBuilder(Ingredient.ofItems(input), tool, new ItemStack(output), count, chance);
    }
    public static CuttingBoardRecipeJsonBuilder create(Item input, Ingredient tool, Item output, Integer count) {
        return new CuttingBoardRecipeJsonBuilder(Ingredient.ofItems(input), tool, new ItemStack(output), count, 1);
    }
    public static CuttingBoardRecipeJsonBuilder create(Item input, Ingredient tool, Item output) {
        return new CuttingBoardRecipeJsonBuilder(Ingredient.ofItems(input), tool, new ItemStack(output), 1, 1);
    }

    public CuttingBoardRecipeJsonBuilder output(Item output, Integer count, float chance) {
        this.results.add(new ChanceResult(new ItemStack(output, count), chance));
        return this;
    }

    public CuttingBoardRecipeJsonBuilder output(Item output, float chance) {
        return this.output(output, 1, chance);
    }

    public CuttingBoardRecipeJsonBuilder output(Item output) {
        return this.output(output, 1, 1.0F);
    }

    @Override
    public CraftingRecipeJsonBuilder criterion(String name, CriterionConditions conditions) {
        this.advancementBuilder.criterion(name, conditions);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String group) {
        return null;
    }

    @Override
    public Item getOutputItem() {
        if (!this.results.isEmpty()) {
            return this.results.get(0).stack().getItem();
        }
        return null;
    }

    @Override
    public void offerTo(Consumer<RecipeJsonProvider> exporter, Identifier recipeId) {
        this.validate(recipeId);
        String fdCuttingPrefix = "farmersdelight/cutting/";
        this.advancementBuilder.parent(ROOT).criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId.withPrefixedPath(fdCuttingPrefix))).rewards(net.minecraft.advancement.AdvancementRewards.Builder.recipe(recipeId.withPrefixedPath(fdCuttingPrefix))).criteriaMerger(CriterionMerger.OR);
        exporter.accept(new CuttingBoardRecipeJsonProvider(recipeId.withPrefixedPath(fdCuttingPrefix), this.results, this.ingredient, this.tool, this.soundEventID, this.advancementBuilder, recipeId.withPrefixedPath("recipes/misc/" + fdCuttingPrefix)));
    }

    private void validate(Identifier recipeId) {
        if (this.advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }

    public CuttingBoardRecipeJsonBuilder addSound(String soundEventID) {
        this.soundEventID = soundEventID;
        return this;
    }

    public static class CuttingBoardRecipeJsonProvider extends RecipeJsonBuilder.CraftingRecipeJsonProvider {

        private final Identifier recipeId;
        private List<ChanceResult> results;
        private final Ingredient ingredient;
        private final Ingredient tool;
        private final String soundEventID;
        private final Advancement.Builder advancementBuilder;
        private final Identifier advancementId;

        public CuttingBoardRecipeJsonProvider(Identifier recipeId, List<ChanceResult> results, Ingredient ingredient, Ingredient tool, String soundEventID, Advancement.Builder advancementBuilder, Identifier advancementId) {
            super(CraftingRecipeCategory.MISC);
            this.recipeId = recipeId;
            this.results = results;
            this.ingredient = ingredient;
            this.tool = tool;
            this.soundEventID = soundEventID;
            this.advancementBuilder = advancementBuilder;
            this.advancementId = advancementId;
        }

        public void serialize(JsonObject json) {
            JsonArray ingredients = new JsonArray();
            ingredients.add(this.ingredient.toJson());
            json.add("ingredients", ingredients);

            JsonArray jsonArray = new JsonArray();
            Iterator var3 = this.results.iterator();

            while (var3.hasNext()) {
                ChanceResult result = (ChanceResult)var3.next();
                jsonArray.add(result.serialize());
            }
            json.add("result", jsonArray);

            json.add("tool", this.tool.toJson());
        }
        @Override
        public Identifier getRecipeId() {
            return this.recipeId;
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
            return RecipeTypesRegistry.CUTTING_RECIPE_SERIALIZER.serializer();
        }

        @Nullable
        @Override
        public JsonObject toAdvancementJson() {
            return this.advancementBuilder.toJson();
        }

        @Nullable
        @Override
        public Identifier getAdvancementId() {
            return this.advancementId;
        }
    }
}
