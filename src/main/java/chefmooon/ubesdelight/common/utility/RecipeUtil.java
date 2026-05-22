package chefmooon.ubesdelight.common.utility;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.List;

public class RecipeUtil {
    public static final Identifier MINECRAFT = Identifier.parse("minecraft");

    public static void simpleRecipeBuilder(HolderGetter<Item> holderGetter, RecipeOutput exporter, RecipeCategory category, Item inputItem, int inputCount, Item outputItem, int outputCount) {
        ShapelessRecipeBuilder.shapeless(holderGetter, category, outputItem, outputCount)
                .requires(inputItem, inputCount)
                .unlockedBy(RecipeProvider.getHasName(inputItem), InventoryChangeTrigger.TriggerInstance.hasItems(inputItem))
                .save(exporter, ResourceKey.create(Registries.RECIPE, TextUtils.res(MINECRAFT.getNamespace() + "/crafting/"
                        + RecipeProvider.getConversionRecipeName(outputItem, inputItem))));
    }

    public static void offerSmeltCampSmokeRecipe(HolderGetter<Item> holderGetter, Item input, RecipeCategory recipeCategory, CookingBookCategory cookingBookCategory, Item output, float experience, int smeltingTime, RecipeOutput exporter) {
        int campfireTime = smeltingTime * 3;
        int smokingTime = smeltingTime/2;

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), recipeCategory, cookingBookCategory, output, experience, smeltingTime)
                .unlockedBy(RecipeProvider.getHasName(input), has(holderGetter, input))
                .save(exporter, ResourceKey.create(Registries.RECIPE, TextUtils.res(MINECRAFT.getNamespace() + "/smelting/"
                        + RecipeProvider.getConversionRecipeName(output, input))));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(input), recipeCategory, output, experience, campfireTime)
                .unlockedBy(RecipeProvider.getHasName(input), has(holderGetter, input))
                .save(exporter, ResourceKey.create(Registries.RECIPE, TextUtils.res(MINECRAFT.getNamespace() + "/campfire_cooking/"
                        + RecipeProvider.getConversionRecipeName(output, input))));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), recipeCategory, output, experience, smokingTime)
                .unlockedBy(RecipeProvider.getHasName(input), has(holderGetter, input))
                .save(exporter, ResourceKey.create(Registries.RECIPE, TextUtils.res(MINECRAFT.getNamespace() + "/smoking/"
                        + RecipeProvider.getConversionRecipeName(output, input))));
    }

    public static void offerSmeltCampSmokeFromTag(HolderGetter<Item> holderGetter, TagKey<Item> input, RecipeCategory recipeCategory, CookingBookCategory cookingBookCategory, Item output, float experience, int smeltingTime, RecipeOutput exporter) {
        int campfireTime = smeltingTime * 3;
        int smokingTime = smeltingTime/2;

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(holderGetter.getOrThrow(input)), recipeCategory, cookingBookCategory, output, experience, smeltingTime)
                .unlockedBy(RecipeUtil.hasItemTag(input), has(holderGetter, input))
                .save(exporter, ResourceKey.create(Registries.RECIPE, TextUtils.res(MINECRAFT.getNamespace() + "/smelting/"
                        + RecipeProvider.getItemName(output) + "_from_" + getTagName(input))));

        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(holderGetter.getOrThrow(input)), recipeCategory, output, experience, campfireTime)
                .unlockedBy(RecipeUtil.hasItemTag(input), has(holderGetter, input))
                .save(exporter, ResourceKey.create(Registries.RECIPE, TextUtils.res(MINECRAFT.getNamespace() + "/campfire_cooking/"
                        + RecipeProvider.getItemName(output) + "_from_" + getTagName(input))));

        SimpleCookingRecipeBuilder.smoking(Ingredient.of(holderGetter.getOrThrow(input)), recipeCategory, output, experience, smokingTime)
                .unlockedBy(RecipeUtil.hasItemTag(input), has(holderGetter, input))
                .save(exporter, ResourceKey.create(Registries.RECIPE, TextUtils.res(MINECRAFT.getNamespace() + "/smoking/"
                        + RecipeProvider.getItemName(output) + "_from_" + getTagName(input))));
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

    public static Criterion<InventoryChangeTrigger.TriggerInstance> getTriggerfromItem(HolderGetter<Item> holderGetter, Item item) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, item));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> getTriggerfromItems(HolderGetter<Item> holderGetter, Item ... items) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, items));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> getTriggerfromTag(HolderGetter<Item> holderGetter, TagKey<Item> tag) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, tag));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> getTriggerfromTagWithCount(HolderGetter<Item> holderGetter, int count, TagKey<Item> tag) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, tag).withCount(MinMaxBounds.Ints.atLeast(count)));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderGetter<Item> holderGetter, Item item) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, item));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderGetter<Item> holderGetter, Item ... items) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, items));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderGetter<Item> holderGetter, TagKey<Item> tag) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, tag));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderGetter<Item> holderGetter, int count, TagKey<Item> tag) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, tag).withCount(MinMaxBounds.Ints.atLeast(count)));
    }

    public static Criterion<InventoryChangeTrigger.TriggerInstance> has(HolderGetter<Item> holderGetter, int count, Item item) {
        return RecipeProvider.inventoryTrigger(ItemPredicate.Builder.item().of(holderGetter, item).withCount(MinMaxBounds.Ints.atLeast(count)));
    }

    public static NonNullList<Ingredient> nonNullList(Ingredient ... ingredients) {
        NonNullList<Ingredient> newList = NonNullList.create();
        newList.addAll(List.of(ingredients));
        return newList;
    }
}
