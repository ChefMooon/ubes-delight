package com.chefmoon.ubesdelight.data.builder;

import com.chefmoon.ubesdelight.util.CookingPotRecipeCategory;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.nhoryzon.mc.farmersdelight.registry.RecipeTypesRegistry;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementRewards;
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
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class CookingPotRecipeJsonBuilder extends RecipeJsonBuilder implements CraftingRecipeJsonBuilder {


    private final RecipeCategory category;
    private final CookingPotRecipeCategory cookingCategory;
    private final Item output;
    private final int outputCount;
    private final ItemStack container;
    private final List<Ingredient> inputs;
    private final float experience;
    private final int cookingTime;
    private final Advancement.Builder advancementBuilder = Advancement.Builder.createUntelemetered();
    @Nullable
    private String group;

    private CookingPotRecipeJsonBuilder(RecipeCategory category, CookingPotRecipeCategory cookingCategory, ItemConvertible output, int outputCount, ItemStack container, List<Ingredient> inputs, float experience, int cookingTime) {
        this.category = category;
        this.cookingCategory = cookingCategory;
        this.output = output.asItem();
        this.outputCount = outputCount;
        if (!container.isEmpty()) {
            this.container = container;
        } else if (output.asItem().getRecipeRemainder() != null) {
            this.container = new ItemStack(Objects.requireNonNull(output.asItem().getRecipeRemainder()));
        } else {
            this.container = ItemStack.EMPTY;
        }
        this.inputs = inputs;
        this.experience = experience;
        this.cookingTime = cookingTime;
    }

    public static CookingPotRecipeJsonBuilder create(RecipeCategory category, CookingPotRecipeCategory cookingCategory, ItemConvertible output, int outputCount, ItemStack container, List<Ingredient> inputs, float experience, int cookingTime) {
        return new CookingPotRecipeJsonBuilder(category, cookingCategory, output, outputCount, container, inputs, experience, cookingTime);
    }

    public static CookingPotRecipeJsonBuilder create(CookingPotRecipeCategory cookingCategory, ItemConvertible output, int outputCount, int cookingTime, List<Ingredient> inputs) {
        return new CookingPotRecipeJsonBuilder(RecipeCategory.FOOD, cookingCategory, output, outputCount, ItemStack.EMPTY, inputs, .0F, cookingTime);
    }

    public static CookingPotRecipeJsonBuilder create(CookingPotRecipeCategory cookingCategory, ItemConvertible output, int outputCount, float experience, int cookingTime, List<Ingredient> inputs) {
        return new CookingPotRecipeJsonBuilder(RecipeCategory.FOOD, cookingCategory, output, outputCount, ItemStack.EMPTY, inputs, experience, cookingTime);
    }

    public static CookingPotRecipeJsonBuilder create(CookingPotRecipeCategory cookingCategory, ItemConvertible output, float experience, int cookingTime, List<Ingredient> inputs) {
        return new CookingPotRecipeJsonBuilder(RecipeCategory.FOOD, cookingCategory, output, 1, ItemStack.EMPTY, inputs, experience, cookingTime);
    }

    public CookingPotRecipeJsonBuilder input(TagKey<Item> tag) {
        return this.input(Ingredient.fromTag(tag));
    }

    public CookingPotRecipeJsonBuilder input(ItemConvertible itemProvider) {
        return this.input((ItemConvertible)itemProvider, 1);
    }

    public CookingPotRecipeJsonBuilder input(ItemConvertible itemProvider, int size) {
        for(int i = 0; i < size; ++i) {
            this.input(Ingredient.ofItems(new ItemConvertible[]{itemProvider}));
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
    public CookingPotRecipeJsonBuilder criterion(String name, CriterionConditions conditions) {
        this.advancementBuilder.criterion(name, conditions);
        return this;
    }

    @Override
    public CookingPotRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    @Override
    public Item getOutputItem() {
        return this.output;
    }

    @Override
    public void offerTo(Consumer<RecipeJsonProvider> exporter, Identifier recipeId) {
        this.validate(recipeId);
        String fdCookingPrefix = "farmersdelight/cooking/";
        this.advancementBuilder.parent(ROOT).criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId.withPrefixedPath(fdCookingPrefix))).rewards(AdvancementRewards.Builder.recipe(recipeId.withPrefixedPath(fdCookingPrefix))).criteriaMerger(CriterionMerger.OR);
        exporter.accept(new CookingPotRecipeJsonProvider(recipeId.withPrefixedPath(fdCookingPrefix), this.group == null ? "" : this.group, this.cookingCategory, this.inputs, this.output, this.outputCount, this.container, this.experience, this.cookingTime, this.advancementBuilder, recipeId.withPrefixedPath("recipes/" + this.category.getName() + "/" + fdCookingPrefix)));
    }

    //TODO: Finish Validation
    private void validate(Identifier recipeId) {
        if (this.advancementBuilder.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }

    public static class CookingPotRecipeJsonProvider implements RecipeJsonProvider {
        private final Identifier recipeId;
        private final String group;
        private final CookingPotRecipeCategory category;
        private final List<Ingredient> inputs;
        private final Item result;
        private final int resultCount;
        private final ItemStack container;
        private final float experience;
        private final int cookingTime;
        private final Advancement.Builder advancementBuilder;
        private final Identifier advancementId;

        public CookingPotRecipeJsonProvider(Identifier recipeId, String group, CookingPotRecipeCategory category, List<Ingredient> inputs, Item result, int resultCount, ItemStack container, float experience, int cookingTime, Advancement.Builder advancementBuilder, Identifier advancementId) {
            this.recipeId = recipeId;
            this.group = group;
            this.category = category;
            this.inputs = inputs;
            this.result = result;
            this.container = container;
            this.resultCount = resultCount;
            this.experience = experience;
            this.cookingTime = cookingTime;
            this.advancementBuilder = advancementBuilder;
            this.advancementId = advancementId;
        }
        @Override
        public void serialize(JsonObject json) {
            if (!this.group.isEmpty()) {
                json.addProperty("group", this.group);
            }
            json.addProperty("cookingtime", this.cookingTime);

            if (this.experience > .0F) {
                json.addProperty("experience", this.experience);
            }

            JsonArray jsonArray = new JsonArray();
            Iterator iterator = this.inputs.iterator();

            while(iterator.hasNext()) {
                Ingredient ingredient = (Ingredient)iterator.next();
                jsonArray.add(ingredient.toJson());
            }
            json.add("ingredients", jsonArray);

            json.addProperty("recipe_book_tab", this.category.asString());

            JsonObject resultObject = new JsonObject();
            resultObject.addProperty("item", Registries.ITEM.getId(this.result).toString());
            if (this.resultCount > 1) {
                resultObject.addProperty("count", this.resultCount);
            }
            json.add("result", resultObject);

            if (!this.container.isEmpty() && this.result.getRecipeRemainder() != null && !this.container.isOf(this.result.getRecipeRemainder())) {
                JsonObject containerObject = new JsonObject();
                containerObject.addProperty("item", Registries.ITEM.getId(this.container.getItem()).toString());
                json.add("container", containerObject);
            }
        }

        @Override
        public RecipeSerializer<?> getSerializer() {
            return RecipeTypesRegistry.COOKING_RECIPE_SERIALIZER.serializer();
        }

        @Override
        public Identifier getRecipeId() {
            return this.recipeId;
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
