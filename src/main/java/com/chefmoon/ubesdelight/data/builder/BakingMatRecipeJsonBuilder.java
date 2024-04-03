package com.chefmoon.ubesdelight.data.builder;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.RecipeTypesRegistry;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nhoryzon.mc.farmersdelight.recipe.ingredient.ChanceResult;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.CriterionMerger;
import net.minecraft.advancement.criterion.CriterionConditions;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class BakingMatRecipeJsonBuilder extends RecipeJsonBuilder implements CraftingRecipeJsonBuilder  {

    private final List<Ingredient> ingredientList;
    private final List<Ingredient> processStages;
    private final List<ChanceResult> resultList = new ArrayList<>(4);
    private final Ingredient tool;
    private String soundEventID;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.createUntelemetered();
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
        return this.input(Ingredient.fromTag(tag));
    }
    public BakingMatRecipeJsonBuilder input(TagKey<Item> tag, int size) {
        return this.input(Ingredient.fromTag(tag), size);
    }
    public BakingMatRecipeJsonBuilder input(ItemConvertible itemProvider) {
        return this.input(Ingredient.ofItems(new ItemConvertible[]{itemProvider}), 1);
    }
    public BakingMatRecipeJsonBuilder input(ItemConvertible itemProvider, int size) {
        return this.input(Ingredient.ofItems(new ItemConvertible[]{itemProvider}), size);
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
        if (!this.resultList.isEmpty()) {
            return this.resultList.get(0).stack().getItem();
        }
        return null;
    }

    @Override
    public void offerTo(Consumer<RecipeJsonProvider> exporter, Identifier recipeId) {
        if (Objects.equals(recipeId.getNamespace(), "minecraft")) {
            recipeId = new Identifier(UbesDelightMod.MOD_ID, recipeId.getPath());
        }
        this.validate(recipeId);
        String prefix = "ubesdelight/baking_mat/";
        this.advancementBuilder.parent(ROOT).criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId.withPrefixedPath(prefix))).rewards(net.minecraft.advancement.AdvancementRewards.Builder.recipe(recipeId.withPrefixedPath(prefix))).criteriaMerger(CriterionMerger.OR);
        exporter.accept(new BakingMatRecipeJsonProvider(recipeId.withPrefixedPath(prefix), this.ingredientList, this.processStages, this.resultList, this.tool, this.soundEventID, this.advancementBuilder, recipeId.withPrefixedPath("recipes/food/" + prefix)));
    }

    private void validate(Identifier recipeId) {
        if (this.advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }

    public static class BakingMatRecipeJsonProvider extends RecipeJsonBuilder.CraftingRecipeJsonProvider {

        private final Identifier recipeId;
        private final List<Ingredient> ingredientList;
        private final List<Ingredient> processStages;
        private final List<ChanceResult> resultList;
        private final Ingredient tool;
        private final String soundEventID;
        private final Advancement.Builder advancementBuilder;
        private final Identifier advancementId;

        protected BakingMatRecipeJsonProvider(Identifier recipeId, List<Ingredient> ingredientList,@Nullable List<Ingredient> processStages, List<ChanceResult> resultList, Ingredient tool, String soundEventID, Advancement.Builder advancementBuilder, Identifier advancementId) {
            super(CraftingRecipeCategory.MISC);
            this.recipeId = recipeId;
            this.ingredientList = ingredientList;
            this.processStages = processStages;
            this.resultList = resultList;
            this.tool = tool;
            this.soundEventID = soundEventID;
            this.advancementBuilder = advancementBuilder;
            this.advancementId = advancementId;
        }

        public void serialize(JsonObject json) {
            JsonArray ingredientArray = new JsonArray();
            Iterator var = this.ingredientList.iterator();

            while (var.hasNext()) {
                Ingredient ingredient = (Ingredient) var.next();
                ingredientArray.add(ingredient.toJson());
            }
            json.add("ingredients", ingredientArray);

            JsonArray processArray = new JsonArray();
            if (this.processStages != null) {
                Iterator var2 = this.processStages.iterator();

                while (var2.hasNext()) {
                    Ingredient ingredient = (Ingredient) var2.next();
                    processArray.add(ingredient.toJson());
                }
            }
            json.add("processing_stages", processArray);

            JsonArray resultArray = new JsonArray();
            Iterator var3 = this.resultList.iterator();

            while (var3.hasNext()) {
                ChanceResult result = (ChanceResult)var3.next();
                resultArray.add(result.serialize());
            }
            json.add("result", resultArray);

            json.add("tool", this.tool.toJson());
        }

        @Override
        public Identifier getRecipeId() {
            return this.recipeId;
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
            return RecipeTypesRegistry.BAKING_MAT_RECIPE_SERIALIZER.serializer();
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
