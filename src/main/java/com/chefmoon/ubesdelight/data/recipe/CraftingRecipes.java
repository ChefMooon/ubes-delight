package com.chefmoon.ubesdelight.data.recipe;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import com.chefmoon.ubesdelight.tag.CompatibilityTags;
import com.chefmoon.ubesdelight.util.RecipeUtil;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class CraftingRecipes {

    public static void register(Consumer<RecipeJsonProvider> exporter) {

        /** BLOCKS **/

        // Crate to Vegetable
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.MISC,
                ItemsRegistry.UBE_CRATE, 1,
                ItemsRegistry.UBE, 9);
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.MISC,
                ItemsRegistry.GARLIC_CRATE, 1,
                ItemsRegistry.GARLIC, 9);
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.MISC,
                ItemsRegistry.GINGER_CRATE, 1,
                ItemsRegistry.GINGER, 9);
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.MISC,
                ItemsRegistry.LEMONGRASS_CRATE, 1,
                ItemsRegistry.LEMONGRASS, 9);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemsRegistry.KALAN.get())
                .pattern("AAA")
                .pattern("ACA")
                .pattern("ABA")
                .input('A', CompatibilityTags.MINECRAFT_TERRACOTTA)
                .input('B', Items.CAMPFIRE)
                .input('C', CommonTags.C_IRON_INGOTS)
                .criterion(RecipeProvider.hasItem(Items.CAMPFIRE), RecipeProvider.conditionsFromItem(Items.CAMPFIRE))
                .offerTo(exporter, suffix(RecipeProvider.getRecipeName(ItemsRegistry.KALAN.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemsRegistry.BAKING_MAT_BAMBOO.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .input('A', Items.BAMBOO)
                .input('B', Items.HONEYCOMB)
                .criterion(RecipeUtil.hasAny(), RecipeUtil.conditionsFromItems(Items.BAMBOO, Items.HONEYCOMB))
                .offerTo(exporter, suffix(RecipeProvider.getRecipeName(ItemsRegistry.BAKING_MAT_BAMBOO.get())));

        /** ITEMS **/

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ItemsRegistry.ROLLING_PIN_WOOD.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .input('A', Items.STICK)
                .input('B', ItemTags.FENCES)
                .criterion(RecipeProvider.hasItem(Items.STICK), RecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, suffix(RecipeProvider.getRecipeName(ItemsRegistry.ROLLING_PIN_WOOD.get())));

        /** CROPS **/

        // Seed from crop
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.MISC,
                ItemsRegistry.LEMONGRASS, 1,
                ItemsRegistry.LEMONGRASS_SEEDS, 1);

        // Partial to full Vegetables
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                ItemsRegistry.GARLIC_CHOP, 2,
                ItemsRegistry.GARLIC, 1);

        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                ItemsRegistry.GINGER_CHOP, 2,
                ItemsRegistry.GINGER, 1);

        /** FOODS **/

        // Cake Slices to Cake
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                ItemsRegistry.UBE_CAKE_SLICE, 7,
                ItemsRegistry.UBE_CAKE, 1);

        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                ItemsRegistry.LECHE_FLAN, 5,
                ItemsRegistry.LECHE_FLAN_FEAST, 1);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.COOKIE_GINGER.get(), 8)
                .input(CommonTags.C_VEGETABLES_GINGER)
                .input(Items.WHEAT, 2)
                .criterion(RecipeUtil.hasAny(), RecipeProvider.conditionsFromItem(ItemsRegistry.GINGER.get()))
                .offerTo(exporter, suffix(RecipeProvider.getRecipeName(ItemsRegistry.COOKIE_GINGER.get())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.COOKIE_UBE.get(), 8)
                .input(CommonTags.C_VEGETABLES_UBE)
                .input(Items.WHEAT, 2)
                .criterion(RecipeUtil.hasAny(), RecipeProvider.conditionsFromItem(ItemsRegistry.UBE.get()))
                .offerTo(exporter, suffix(RecipeProvider.getRecipeName(ItemsRegistry.COOKIE_UBE.get())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.KINILAW.get())
                .input(CommonTags.C_RAW_FISHES)
                .input(CommonTags.C_CROPS_ONION)
                .input(CommonTags.C_VEGETABLES_GARLIC)
                .input(CommonTags.C_VEGETABLES_GINGER)
                .input(CommonTags.C_CROPS_LEMONGRASS)
                .input(Items.BOWL)
                .criterion(RecipeUtil.hasAny(), RecipeUtil.conditionsFromItems(Items.BOWL, ItemsRegistry.GARLIC.get(), ItemsRegistry.GINGER.get()))
                .offerTo(exporter, suffix(RecipeProvider.getRecipeName(ItemsRegistry.KINILAW.get())));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.KINILAW.get())
                .input(CompatibilityTags.MINECRAFT_FISHES)
                .input(CommonTags.C_CROPS_ONION)
                .input(CommonTags.C_VEGETABLES_GARLIC)
                .input(CommonTags.C_VEGETABLES_GINGER)
                .input(CommonTags.C_CROPS_LEMONGRASS)
                .input(Items.BOWL)
                .criterion(RecipeUtil.hasAny(), RecipeUtil.conditionsFromItems(Items.BOWL, ItemsRegistry.GARLIC.get(), ItemsRegistry.GINGER.get()))
                .offerTo(exporter, suffix(RecipeProvider.getRecipeName(ItemsRegistry.KINILAW.get()) + "_extra"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.LUMPIA_WRAPPER.get(), 32)
                .input(CommonTags.C_GRAIN)
                .input(CommonTags.C_EGGS)
                .input(Items.WATER_BUCKET)
                .criterion(RecipeUtil.hasAny(), RecipeUtil.conditionsFromItems(Items.WATER_BUCKET, Items.EGG, Items.WHEAT))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.LUMPIA_WRAPPER.get(),Items.WATER_BUCKET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.HALO_HALO_FEAST.get())
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .input('A', ItemsRegistry.HALO_HALO.get())
                .input('B', CommonTags.C_MILK)
                .criterion(RecipeUtil.hasAny(), RecipeUtil.conditionsFromItems(ItemsRegistry.HALO_HALO.get(), ItemsRegistry.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET))
                .offerTo(exporter, suffix(RecipeProvider.getRecipeName(ItemsRegistry.HALO_HALO_FEAST.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.MILK_TEA_UBE_FEAST.get())
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .input('A', ItemsRegistry.MILK_TEA_UBE.get())
                .input('B', CommonTags.C_MILK)
                .criterion(RecipeUtil.hasAny(), RecipeUtil.conditionsFromItems(ItemsRegistry.MILK_TEA_UBE.get(), ItemsRegistry.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET))
                .offerTo(exporter, suffix(RecipeProvider.getRecipeName(ItemsRegistry.MILK_TEA_UBE_FEAST.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.LUMPIA_FEAST.get())
                .pattern("   ")
                .pattern("AAA")
                .pattern("BBB")
                .input('A', ItemsRegistry.LUMPIA.get())
                .input('B', CompatibilityTags.MINECRAFT_LEAVES)
                .criterion(RecipeUtil.hasAny(), RecipeProvider.conditionsFromItem(ItemsRegistry.LUMPIA.get()))
                .offerTo(exporter, suffix(RecipeProvider.getRecipeName(ItemsRegistry.LUMPIA_FEAST.get())));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ItemsRegistry.UBE_CAKE.get())
                .pattern("AAA")
                .pattern("BEB")
                .pattern("CFC")
                .input('A', CommonTags.C_MILK)
                .input('B', CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .input('C', Items.WHEAT)
                .input('E', CommonTags.C_EGGS)
                .input('F', CommonTags.C_CROPS_UBE)
                .criterion(RecipeProvider.hasItem(Items.EGG), RecipeProvider.conditionsFromItem(Items.EGG))
                .offerTo(exporter, suffix(RecipeProvider.getRecipeName(ItemsRegistry.UBE_CAKE.get())));
    }

    private static Identifier suffix(String string) {
        return new Identifier(UbesDelightMod.MOD_ID, "minecraft/crafting/" + string);
    }

}
