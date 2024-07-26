package com.chefmooon.ubesdelight.data.fabric.recipe;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.tag.CompatibilityTags;
import com.chefmooon.ubesdelight.common.utility.fabric.RecipeUtil;
import com.chefmooon.ubesdelight.data.fabric.builder.CookingPotRecipeJsonBuilder;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class CookingRecipes {
    // Farmer's Delight compatibility items
    static Item MILK_BOTTLE = ModItems.MILK_BOTTLE.get();

    public static void register(Consumer<FinishedRecipe> exporter) {

        //registerUncommon(exporter);

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE, 1, 50, .0F,
                        List.of(Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(MILK_BOTTLE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(MILK_BOTTLE), RecipeUtil.getTriggerfromItem(MILK_BOTTLE))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE, MILK_BOTTLE));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE, 4, 200, .0F,
                        List.of(Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(Items.MILK_BUCKET)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.getTriggerfromTagWithCount(4, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(Items.MILK_BUCKET), RecipeProvider.has(Items.MILK_BUCKET))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE, Items.MILK_BUCKET));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE, 4, 200, .0F,
                        List.of(Ingredient.of(CompatibilityTags.MINECRAFT_FISHES),
                                Ingredient.of(Items.WATER_BUCKET)))
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_FISHES), RecipeProvider.has(CompatibilityTags.MINECRAFT_FISHES))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeProvider.has(Items.WATER_BUCKET))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE, Items.WATER_BUCKET) + "_extra");

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.SUGAR_BROWN, 1,  200, 0.5F,
                        List.of(Ingredient.of(Items.SUGAR)))
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItemsImpl.SUGAR_BROWN));


        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.CHICKEN_INASAL_RICE, 1, 200, 3.0F,
                        List.of(Ingredient.of(UbesDelightItemsImpl.CHICKEN_INASAL),
                                Ingredient.of(UbesDelightItemsImpl.SINANGAG)))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.CHICKEN_INASAL), RecipeProvider.has(UbesDelightItemsImpl.CHICKEN_INASAL))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.SINANGAG), RecipeProvider.has(UbesDelightItemsImpl.SINANGAG))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.CHICKEN_INASAL_RICE));
    }

    private static void registerUncommon(Consumer<FinishedRecipe> exporter) {

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE, 4, 200, .0F,
                        List.of(Ingredient.of(CommonTags.C_FOODS_RAW_FISHES),
                                Ingredient.of(Items.WATER_BUCKET)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_FISHES), RecipeProvider.has(CommonTags.C_FOODS_RAW_FISHES))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeProvider.has(Items.WATER_BUCKET))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE, Items.WATER_BUCKET));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.MILK_POWDER, 1, 200,  0.2F,
                        List.of(Ingredient.of(CommonTags.C_MILKS_MILK_BOTTLES)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_MILKS_MILK_BOTTLES), RecipeProvider.has(CommonTags.C_MILKS_MILK_BOTTLES))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItemsImpl.MILK_POWDER, MILK_BOTTLE));

        // ** DRINKS **
        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.MILK_TEA_UBE, 1, 50, 0.25F,
                        List.of(Ingredient.of(CommonTags.C_CROPS_UBE),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE)))
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE), RecipeProvider.has(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItemsImpl.MILK_TEA_UBE) + "_single");

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.MILK_TEA_UBE, 4, 200, 1.0F,
                        List.of(Ingredient.of(CommonTags.C_CROPS_UBE),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE),
                                Ingredient.of(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE),
                                Ingredient.of(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE),
                                Ingredient.of(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE)))
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE), RecipeProvider.has(MinMaxBounds.Ints.atLeast(4), UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItemsImpl.MILK_TEA_UBE) + "_multiple");

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.HALO_HALO, 1, 200, 1.0F,
                        List.of(Ingredient.of(CommonTags.C_CROPS_UBE),
                                Ingredient.of(UbesDelightItemsImpl.LECHE_FLAN),
                                Ingredient.of(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE),
                                Ingredient.of(Items.SWEET_BERRIES),
                                Ingredient.of(Items.GLOW_BERRIES),
                                Ingredient.of(Items.MELON_SLICE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.LECHE_FLAN), RecipeProvider.has(UbesDelightItemsImpl.LECHE_FLAN))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE), RecipeProvider.has(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE))
                .unlockedBy(RecipeProvider.getHasName(Items.SWEET_BERRIES), RecipeProvider.has(Items.SWEET_BERRIES))
                .unlockedBy(RecipeProvider.getHasName(Items.GLOW_BERRIES), RecipeProvider.has(Items.GLOW_BERRIES))
                .unlockedBy(RecipeProvider.getHasName(Items.MELON_SLICE), RecipeProvider.has(Items.MELON_SLICE))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItemsImpl.HALO_HALO));

        // ** FOOD **
        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.SINANGAG, 1, 200, 1.0F,
                        List.of(Ingredient.of(CommonTags.C_CROPS_RICE),
                                Ingredient.of(CommonTags.C_CROPS_GARLIC)))
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_RICE), RecipeProvider.has(CommonTags.C_CROPS_RICE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.SINANGAG));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.LUMPIA, 1, 200, 2.0F,
                        List.of(Ingredient.of(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS),
                                Ingredient.of(CommonTags.C_SALAD_INGREDIENTS),
                                Ingredient.of(CommonTags.C_CROPS_LEMONGRASS),
                                Ingredient.of(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)))
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS), RecipeProvider.has(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_SALAD_INGREDIENTS), RecipeProvider.has(CommonTags.C_SALAD_INGREDIENTS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER), RecipeProvider.has(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.LUMPIA));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.TOCINO, 1, 200, 2.0F,
                        List.of(Ingredient.of(CommonTags.C_FOODS_RAW_MEATS_RAW_PORK),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(CommonTags.C_CROPS_GINGER),
                                Ingredient.of(Items.BEETROOT)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_MEATS_RAW_PORK), RecipeProvider.has(CommonTags.C_FOODS_RAW_MEATS_RAW_PORK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GINGER), RecipeProvider.has(CommonTags.C_CROPS_GINGER))
                .unlockedBy(RecipeProvider.getHasName(Items.BEETROOT), RecipeProvider.has(Items.BEETROOT))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.TOCINO));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.CHICKEN_INASAL, 1, 200, 2.0F,
                        List.of(Ingredient.of(CommonTags.C_FOODS_RAW_MEATS_RAW_CHICKEN),
                                Ingredient.of(CommonTags.C_CROPS_LEMONGRASS),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_MEATS_RAW_CHICKEN), RecipeProvider.has(CommonTags.C_FOODS_RAW_MEATS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.CHICKEN_INASAL));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.TOSILOG, 1, 200, 3.0F,
                        List.of(Ingredient.of(UbesDelightItemsImpl.TOCINO),
                                Ingredient.of(UbesDelightItemsImpl.SINANGAG),
                                Ingredient.of(CommonTags.C_FOODS_COOKED_MEATS_COOKED_EGGS)))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.TOCINO), RecipeProvider.has(UbesDelightItemsImpl.TOCINO))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.SINANGAG), RecipeProvider.has(UbesDelightItemsImpl.SINANGAG))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_MEATS_COOKED_EGGS), RecipeProvider.has(CommonTags.C_FOODS_COOKED_MEATS_COOKED_EGGS))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.TOSILOG));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.BANGSILOG, 1, 200, 3.0F,
                        List.of(Ingredient.of(CommonTags.C_FOODS_RAW_FISHES),
                                Ingredient.of(UbesDelightItemsImpl.SINANGAG),
                                Ingredient.of(CommonTags.C_FOODS_COOKED_MEATS_COOKED_EGGS)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_FISHES), RecipeProvider.has(CommonTags.C_FOODS_RAW_FISHES))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.SINANGAG), RecipeProvider.has(UbesDelightItemsImpl.SINANGAG))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_MEATS_COOKED_EGGS), RecipeProvider.has(CommonTags.C_FOODS_COOKED_MEATS_COOKED_EGGS))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.BANGSILOG));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.BANGSILOG, 1, 200, 3.0F,
                        List.of(Ingredient.of(CompatibilityTags.MINECRAFT_FISHES),
                                Ingredient.of(UbesDelightItemsImpl.SINANGAG),
                                Ingredient.of(CommonTags.C_FOODS_COOKED_MEATS_COOKED_EGGS)))
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_FISHES), RecipeProvider.has(CompatibilityTags.MINECRAFT_FISHES))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.SINANGAG), RecipeProvider.has(UbesDelightItemsImpl.SINANGAG))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_MEATS_COOKED_EGGS), RecipeProvider.has(CommonTags.C_FOODS_COOKED_MEATS_COOKED_EGGS))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.BANGSILOG) + "_extra"));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.SISIG, 1, 200, 4.0F,
                        List.of(Ingredient.of(CommonTags.C_FOODS_RAW_MEATS_RAW_PORK),
                                Ingredient.of(CommonTags.C_FOODS_RAW_MEATS_RAW_CHICKEN),
                                Ingredient.of(CommonTags.C_CROPS_ONION),
                                Ingredient.of(CommonTags.C_CROPS_GARLIC),
                                Ingredient.of(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_MEATS_RAW_PORK), RecipeProvider.has(CommonTags.C_FOODS_RAW_MEATS_RAW_PORK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_MEATS_RAW_CHICKEN), RecipeProvider.has(CommonTags.C_FOODS_RAW_MEATS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.has(CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE), RecipeProvider.has(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.SISIG));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.BULALO, 1, 200, 4.0F,
                        List.of(Ingredient.of(CommonTags.C_FOODS_RAW_MEATS_RAW_BEEF),
                                Ingredient.of(CommonTags.C_BONES),
                                Ingredient.of(CommonTags.C_CROPS_ONION),
                                Ingredient.of(CommonTags.C_CROPS_CABBAGE),
                                Ingredient.of(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE),
                                Ingredient.of(CommonTags.C_CROPS_LEMONGRASS)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_MEATS_RAW_BEEF), RecipeProvider.has(CommonTags.C_FOODS_RAW_MEATS_RAW_BEEF))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_BONES), RecipeProvider.has(CommonTags.C_BONES))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.has(CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_CABBAGE), RecipeProvider.has(CommonTags.C_CROPS_CABBAGE))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE), RecipeProvider.has(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.BULALO));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.ARROZ_CALDO, 1, 200, 4.0F,
                        List.of(Ingredient.of(CommonTags.C_FOODS_RAW_MEATS_RAW_CHICKEN),
                                Ingredient.of(CommonTags.C_GRAINS),
                                Ingredient.of(CommonTags.C_CROPS_GARLIC),
                                Ingredient.of(CommonTags.C_CROPS_GINGER),
                                Ingredient.of(CommonTags.C_CROPS_LEMONGRASS),
                                Ingredient.of(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_MEATS_RAW_CHICKEN), RecipeProvider.has(CommonTags.C_FOODS_RAW_MEATS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_GRAINS), RecipeProvider.has(CommonTags.C_GRAINS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GINGER), RecipeProvider.has(CommonTags.C_CROPS_GINGER))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE), RecipeProvider.has(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.ARROZ_CALDO));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.MECHADO, 1, 200, 4.0F,
                        List.of(Ingredient.of(CommonTags.C_FOODS_RAW_MEATS_RAW_BEEF),
                                Ingredient.of(CommonTags.C_CROPS_ONION),
                                Ingredient.of(CommonTags.C_CROPS_GARLIC),
                                Ingredient.of(CommonTags.C_CROPS_TOMATO),
                                Ingredient.of(CommonTags.C_FOODS_VEGETABLES),
                                Ingredient.of(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_MEATS_RAW_BEEF), RecipeProvider.has(CommonTags.C_FOODS_RAW_MEATS_RAW_BEEF))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.has(CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_TOMATO), RecipeProvider.has(CommonTags.C_CROPS_TOMATO))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_VEGETABLES), RecipeProvider.has(CommonTags.C_FOODS_VEGETABLES))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE), RecipeProvider.has(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.MECHADO));

        // ** SWEETS **
        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.LECHE_FLAN, 4, 100, 0.5F,
                        List.of(Ingredient.of(CommonTags.C_EGGS),
                                Ingredient.of(CommonTags.C_EGGS),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_EGGS), RecipeUtil.getTriggerfromTagWithCount(2, CommonTags.C_EGGS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE), RecipeProvider.has(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.LECHE_FLAN));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.RAW_POLVORONE, 4, 100, 0.0f,
                        List.of(Ingredient.of(CommonTags.C_GRAINS),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItemsImpl.MILK_POWDER)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_GRAINS), RecipeProvider.has(CommonTags.C_GRAINS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.MILK_POWDER), RecipeProvider.has(UbesDelightItemsImpl.MILK_POWDER))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.RAW_POLVORONE));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG, 4, 100, 0.0f,
                        List.of(Ingredient.of(CommonTags.C_GRAINS),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItemsImpl.MILK_POWDER),
                                Ingredient.of(CommonTags.C_CROPS_RICE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_GRAINS), RecipeProvider.has(CommonTags.C_GRAINS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.MILK_POWDER), RecipeProvider.has(UbesDelightItemsImpl.MILK_POWDER))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_RICE), RecipeProvider.has(CommonTags.C_CROPS_RICE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.RAW_POLVORONE_UBE, 4, 100, 0.0f,
                        List.of(Ingredient.of(CommonTags.C_GRAINS),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItemsImpl.MILK_POWDER),
                                Ingredient.of(CommonTags.C_CROPS_UBE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_GRAINS), RecipeProvider.has(CommonTags.C_GRAINS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.MILK_POWDER), RecipeProvider.has(UbesDelightItemsImpl.MILK_POWDER))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.RAW_POLVORONE_UBE));

        CookingPotRecipeJsonBuilder.create(UbesDelightItemsImpl.RAW_POLVORONE_CC, 4, 100, 0.0f,
                        List.of(Ingredient.of(CommonTags.C_GRAINS),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItemsImpl.MILK_POWDER),
                                Ingredient.of(Items.COOKIE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_GRAINS), RecipeProvider.has(CommonTags.C_GRAINS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.MILK_POWDER), RecipeProvider.has(UbesDelightItemsImpl.MILK_POWDER))
                .unlockedBy(RecipeProvider.getHasName(Items.COOKIE), RecipeProvider.has(Items.COOKIE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItemsImpl.RAW_POLVORONE_CC));
    }

    private static ResourceLocation recipeConversionName(Item output, Item input) {
        return suffix(RecipeProvider.getConversionRecipeName(output, input));
    }

    private static ResourceLocation recipeName(Item item) {
        return suffix(RecipeProvider.getItemName(item));
    }

    private static ResourceLocation suffix(String string) {
        return new ResourceLocation(UbesDelight.MOD_ID, string + suffix());
    }

    private static String suffix() {
        return "_from_cooking_pot";
    }
}
