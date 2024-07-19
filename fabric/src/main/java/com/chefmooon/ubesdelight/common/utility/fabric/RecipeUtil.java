package com.chefmooon.ubesdelight.common.utility.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import net.minecraft.advancements.critereon.*;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Set;
import java.util.function.Consumer;

public class RecipeUtil {
    private static final ResourceLocation MINECRAFT = new ResourceLocation("minecraft");

    public static void simpleRecipeBuilder(Consumer<FinishedRecipe> exporter, RecipeCategory category, Item inputItem, int inputCount, Item outputItem, int outputCount) {
        ShapelessRecipeBuilder.shapeless(category, outputItem, outputCount)
                .requires(inputItem, inputCount)
                .unlockedBy(RecipeProvider.getHasName(inputItem), InventoryChangeTrigger.TriggerInstance.hasItems(inputItem))
                .save(exporter, new ResourceLocation(UbesDelight.MOD_ID, MINECRAFT.getNamespace() + "/crafting/"
                        + RecipeProvider.getConversionRecipeName(outputItem, inputItem)));
    }

    public static void offerSmeltCampSmokeRecipe(Item input, RecipeCategory recipeCategory, Item output, float experience, int smeltingTime, Consumer<FinishedRecipe> exporter) {
        int campfireTime = smeltingTime * 3;
        int smokingTime = smeltingTime/2;

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), recipeCategory, output, experience, smeltingTime)
                .unlockedBy(RecipeProvider.getHasName(input), getTriggerfromItem(input))
                .save(exporter, new ResourceLocation(UbesDelight.MOD_ID, MINECRAFT.getNamespace() + "/smelting/"
                        + RecipeProvider.getConversionRecipeName(output, input) + "_from_smelting"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), recipeCategory, output, experience, campfireTime)
                .unlockedBy(RecipeProvider.getHasName(input), getTriggerfromItem(input))
                .save(exporter, new ResourceLocation(UbesDelight.MOD_ID, MINECRAFT.getNamespace() + "/campfire_cooking/"
                        + RecipeProvider.getConversionRecipeName(output, input) + "_from_campfire_cooking"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), recipeCategory, output, experience, smokingTime)
                .unlockedBy(RecipeProvider.getHasName(input), getTriggerfromItem(input))
                .save(exporter, new ResourceLocation(UbesDelight.MOD_ID, MINECRAFT.getNamespace() + "/smoking/"
                        + RecipeProvider.getConversionRecipeName(output, input) + "_from_smoking"));
    }

    public static void offerSmeltCampSmokeFromTag(TagKey<Item> input, Item output, float experience, int smeltingTime, Consumer<FinishedRecipe> exporter) {
        int campfireTime = smeltingTime * 3;
        int smokingTime = smeltingTime/2;

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), RecipeCategory.FOOD, output, experience, smeltingTime)
                .unlockedBy(RecipeUtil.hasItemTag(input), RecipeProvider.has(input))
                .save(exporter, new ResourceLocation(UbesDelight.MOD_ID, MINECRAFT.getNamespace() + "/smelting/"
                        + RecipeProvider.getItemName(output) + "_from_" + getTagName(input) + "_from_smelting"));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), RecipeCategory.FOOD, output, experience, campfireTime)
                .unlockedBy(RecipeUtil.hasItemTag(input), RecipeProvider.has(input))
                .save(exporter, new ResourceLocation(UbesDelight.MOD_ID, MINECRAFT.getNamespace() + "/campfire_cooking/"
                        + RecipeProvider.getItemName(output) + "_from_" + getTagName(input) + "_from_campfire_cooking"));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), RecipeCategory.FOOD, output, experience, smokingTime)
                .unlockedBy(RecipeUtil.hasItemTag(input), RecipeProvider.has(input))
                .save(exporter, new ResourceLocation(UbesDelight.MOD_ID, MINECRAFT.getNamespace() + "/smoking/"
                        + RecipeProvider.getItemName(output) + "_from_" + getTagName(input) + "_from_smoking"));
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

    public static InventoryChangeTrigger.TriggerInstance getTriggerfromItem(Item item) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(item);
    }

    public static InventoryChangeTrigger.TriggerInstance getTriggerfromItems(Item ... items) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(items);
    }

    public static InventoryChangeTrigger.TriggerInstance getTriggerfromTag(TagKey<Item> tag) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate(tag, (Set)null, MinMaxBounds.Ints.ANY, MinMaxBounds.Ints.ANY, EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, (Potion)null, NbtPredicate.ANY));
    }

    public static InventoryChangeTrigger.TriggerInstance getTriggerfromTagWithCount(int count, TagKey<Item> tag) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(new ItemPredicate(tag, (Set)null, MinMaxBounds.Ints.atLeast(count), MinMaxBounds.Ints.ANY, EnchantmentPredicate.NONE, EnchantmentPredicate.NONE, (Potion)null, NbtPredicate.ANY));
    }
}
