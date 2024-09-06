package com.chefmooon.ubesdelight.common.utility.fabric;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class RecipeUtil {
    private static final ResourceLocation MINECRAFT = ResourceLocation.parse("minecraft");

    public static void simpleRecipeBuilder(RecipeOutput exporter, RecipeCategory category, Item inputItem, int inputCount, Item outputItem, int outputCount) {
        ShapelessRecipeBuilder.shapeless(category, outputItem, outputCount)
                .requires(inputItem, inputCount)
                .unlockedBy(RecipeProvider.getHasName(inputItem), InventoryChangeTrigger.TriggerInstance.hasItems(inputItem))
                .save(exporter, TextUtils.res(MINECRAFT.getNamespace() + "/crafting/"
                        + RecipeProvider.getConversionRecipeName(outputItem, inputItem)));
    }

    public static void offerSmeltCampSmokeRecipe(Item input, RecipeCategory recipeCategory, Item output, float experience, int smeltingTime, RecipeOutput exporter) {
        int campfireTime = smeltingTime * 3;
        int smokingTime = smeltingTime/2;

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), recipeCategory, output, experience, smeltingTime)
                .unlockedBy(RecipeProvider.getHasName(input), getTriggerfromItem(input))
                .save(exporter, TextUtils.res(MINECRAFT.getNamespace() + "/smelting/"
                        + RecipeProvider.getConversionRecipeName(output, input)));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), recipeCategory, output, experience, campfireTime)
                .unlockedBy(RecipeProvider.getHasName(input), getTriggerfromItem(input))
                .save(exporter, TextUtils.res(MINECRAFT.getNamespace() + "/campfire_cooking/"
                        + RecipeProvider.getConversionRecipeName(output, input)));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), recipeCategory, output, experience, smokingTime)
                .unlockedBy(RecipeProvider.getHasName(input), getTriggerfromItem(input))
                .save(exporter, TextUtils.res(MINECRAFT.getNamespace() + "/smoking/"
                        + RecipeProvider.getConversionRecipeName(output, input)));
    }

    public static void offerSmeltCampSmokeFromTag(TagKey<Item> input, Item output, float experience, int smeltingTime, RecipeOutput exporter) {
        int campfireTime = smeltingTime * 3;
        int smokingTime = smeltingTime/2;

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.FOOD, output, experience, smeltingTime)
                .unlockedBy(RecipeUtil.hasItemTag(input), RecipeProvider.has(input))
                .save(exporter, TextUtils.res(MINECRAFT.getNamespace() + "/smelting/"
                        + RecipeProvider.getItemName(output) + "_from_" + getTagName(input)));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.FOOD, output, experience, campfireTime)
                .unlockedBy(RecipeUtil.hasItemTag(input), RecipeProvider.has(input))
                .save(exporter, TextUtils.res(MINECRAFT.getNamespace() + "/campfire_cooking/"
                        + RecipeProvider.getItemName(output) + "_from_" + getTagName(input)));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.FOOD, output, experience, smokingTime)
                .unlockedBy(RecipeUtil.hasItemTag(input), RecipeProvider.has(input))
                .save(exporter, TextUtils.res(MINECRAFT.getNamespace() + "/smoking/"
                        + RecipeProvider.getItemName(output) + "_from_" + getTagName(input)));
    }

    public static String getTagName(TagKey<Item> tag) {
        return tag.location().getPath().replace("/","_");
    }

    public static String hasItemTag(TagKey<Item> tag) {
        return "has_" + tag.location().getPath().replace("/","_");
    }

    public static String hasAny() {
        return "has_any_ingredient";
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> getTriggerfromItem(Item item) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(item));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> getTriggerfromItems(Item ... items) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(items));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> getTriggerfromTag(TagKey<Item> tag) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(tag));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> getTriggerfromTagWithCount(int count, TagKey<Item> tag) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(tag).withCount(MinMaxBounds.Ints.atLeast(count)));

    }

    public static NonNullList<Ingredient> nonNullList(Ingredient ... ingredients) {
        NonNullList<Ingredient> newList = NonNullList.create();
        newList.addAll(List.of(ingredients));
        return newList;
    }
}
