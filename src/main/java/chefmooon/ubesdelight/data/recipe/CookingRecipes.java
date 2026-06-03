package chefmooon.ubesdelight.data.recipe;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import chefmooon.ubesdelight.common.utility.RecipeUtil;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

public class CookingRecipes {
    // Farmer's Delight compatibility items
    static Item MILK_BOTTLE = ModItems.MILK_BOTTLE.get();

    public static void register(RecipeOutput exporter) {
        // TODO: convert to FD cooking recipe builder.
        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), 1, 50, .0F)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(MILK_BOTTLE)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(MILK_BOTTLE), RecipeUtil.getTriggerfromItem(MILK_BOTTLE))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), MILK_BOTTLE));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), 4, 200, .0F)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), 3)
                .addIngredient(Items.MILK_BUCKET)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.getTriggerfromTagWithCount(4, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(Items.MILK_BUCKET), RecipeProvider.has(Items.MILK_BUCKET))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.FISH_SAUCE_BOTTLE.get(), 4, 200, .0F)
                .addIngredient(CompatibilityTags.MINECRAFT_FISHES)
                .addIngredient(Items.WATER_BUCKET)
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_FISHES), RecipeProvider.has(CompatibilityTags.MINECRAFT_FISHES))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeProvider.has(Items.WATER_BUCKET))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItems.FISH_SAUCE_BOTTLE.get(), Items.WATER_BUCKET) + "_extra");

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.SUGAR_BROWN.get(), 1,  200, 0.5F)
                .addIngredient(Items.SUGAR)
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItems.SUGAR_BROWN.get()));


        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.CHICKEN_INASAL_RICE.get(), 1, 200, 3.0F)
                .addIngredient(UbesDelightItems.CHICKEN_INASAL.get())
                .addIngredient(UbesDelightItems.SINANGAG.get())
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CHICKEN_INASAL.get()), RecipeProvider.has(UbesDelightItems.CHICKEN_INASAL.get()))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeProvider.has(UbesDelightItems.SINANGAG.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.CHICKEN_INASAL_RICE.get()));



        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.FISH_SAUCE_BOTTLE.get(), 4, 200, .0F)
                .addIngredient(CommonTags.C_FOODS_SAFE_RAW_FISH)
                .addIngredient(Items.WATER_BUCKET)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_SAFE_RAW_FISH), RecipeProvider.has(CommonTags.C_FOODS_SAFE_RAW_FISH))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeProvider.has(Items.WATER_BUCKET))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItems.FISH_SAUCE_BOTTLE.get(), Items.WATER_BUCKET));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.MILK_POWDER.get(), 1, 200,  0.2F)
                .addIngredient(ConventionalItemTags.MILK_DRINKS)
                .unlockedBy(RecipeUtil.hasItemTag(ConventionalItemTags.MILK_DRINKS), RecipeProvider.has(ConventionalItemTags.MILK_DRINKS))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItems.MILK_POWDER.get()));

        // ** DRINKS **
        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.MILK_TEA_UBE.get(), 1, 50, 0.25F)
                        .addIngredient(CommonTags.C_CROPS_UBE)
                        .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                        .addIngredient(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItems.MILK_TEA_UBE.get()) + "_single");

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.MILK_TEA_UBE.get(), 4, 200, 1.0F)
                .addIngredient(CommonTags.C_CROPS_UBE)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), 4)
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.has(MinMaxBounds.Ints.atLeast(4), UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItems.MILK_TEA_UBE.get()) + "_multiple");

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.HALO_HALO.get(), 1, 200, 1.0F)
                .addIngredient(CommonTags.C_CROPS_UBE)
                .addIngredient(UbesDelightItems.LECHE_FLAN.get())
                .addIngredient(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .addIngredient(Items.SWEET_BERRIES)
                .addIngredient(Items.GLOW_BERRIES)
                .addIngredient(Items.MELON_SLICE)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.LECHE_FLAN.get()), RecipeProvider.has(UbesDelightItems.LECHE_FLAN.get()))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .unlockedBy(RecipeProvider.getHasName(Items.SWEET_BERRIES), RecipeProvider.has(Items.SWEET_BERRIES))
                .unlockedBy(RecipeProvider.getHasName(Items.GLOW_BERRIES), RecipeProvider.has(Items.GLOW_BERRIES))
                .unlockedBy(RecipeProvider.getHasName(Items.MELON_SLICE), RecipeProvider.has(Items.MELON_SLICE))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItems.HALO_HALO.get()));

        // ** FOOD **
        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.SINANGAG.get(), 1, 200, 1.0F)
                .addIngredient(CommonTags.C_CROPS_RICE)
                .addIngredient(CommonTags.C_CROPS_GARLIC)
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_RICE), RecipeProvider.has(CommonTags.C_CROPS_RICE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.SINANGAG.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.LUMPIA.get(), 1, 200, 2.0F)
                .addIngredient(DefaultCustomIngredients.any(
                        Ingredient.of(ConventionalItemTags.RAW_MEAT_FOODS),
                        Ingredient.of(CommonTags.C_FOODS_SAFE_RAW_FISH),
                        Ingredient.of(ConventionalItemTags.VEGETABLE_FOODS),
                        Ingredient.of(ConventionalItemTags.MUSHROOMS)
                ))
                .addIngredient(CommonTags.C_FOODS_LEAFY_GREEN)
                .addIngredient(CommonTags.C_CROPS_LEMONGRASS)
                .addIngredient(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_LEAFY_GREEN), RecipeProvider.has(CommonTags.C_FOODS_LEAFY_GREEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER), RecipeProvider.has(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.LUMPIA.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.TOCINO.get(), 1, 200, 2.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_PORK)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(CommonTags.C_CROPS_GINGER)
                .addIngredient(Items.BEETROOT)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_PORK), RecipeProvider.has(CommonTags.C_FOODS_RAW_PORK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GINGER), RecipeProvider.has(CommonTags.C_CROPS_GINGER))
                .unlockedBy(RecipeProvider.getHasName(Items.BEETROOT), RecipeProvider.has(Items.BEETROOT))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.TOCINO.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.CHICKEN_INASAL.get(), 1, 200, 2.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_CHICKEN)
                .addIngredient(CommonTags.C_CROPS_LEMONGRASS)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_CHICKEN), RecipeProvider.has(CommonTags.C_FOODS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.CHICKEN_INASAL.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.TOSILOG.get(), 1, 200, 3.0F)
                .addIngredient(UbesDelightItems.TOCINO.get())
                .addIngredient(UbesDelightItems.SINANGAG.get())
                .addIngredient(CommonTags.C_FOODS_COOKED_EGG)
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.TOCINO.get()), RecipeProvider.has(UbesDelightItems.TOCINO.get()))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeProvider.has(UbesDelightItems.SINANGAG.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_EGG), RecipeProvider.has(CommonTags.C_FOODS_COOKED_EGG))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.TOSILOG.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.BANGSILOG.get(), 1, 200, 3.0F)
                .addIngredient(CommonTags.C_FOODS_SAFE_RAW_FISH)
                .addIngredient(UbesDelightItems.SINANGAG.get())
                .addIngredient(CommonTags.C_FOODS_COOKED_EGG)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_SAFE_RAW_FISH), RecipeProvider.has(CommonTags.C_FOODS_SAFE_RAW_FISH))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeProvider.has(UbesDelightItems.SINANGAG.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_EGG), RecipeProvider.has(CommonTags.C_FOODS_COOKED_EGG))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.BANGSILOG.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.BANGSILOG.get(), 1, 200, 3.0F)
                .addIngredient(CompatibilityTags.MINECRAFT_FISHES)
                .addIngredient(UbesDelightItems.SINANGAG.get())
                .addIngredient(CommonTags.C_FOODS_COOKED_EGG)
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_FISHES), RecipeProvider.has(CompatibilityTags.MINECRAFT_FISHES))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeProvider.has(UbesDelightItems.SINANGAG.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_EGG), RecipeProvider.has(CommonTags.C_FOODS_COOKED_EGG))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.BANGSILOG.get()) + "_extra"));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.SISIG.get(), 1, 200, 4.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_PORK)
                .addIngredient(CommonTags.C_FOODS_RAW_CHICKEN)
                .addIngredient(CommonTags.C_CROPS_ONION)
                .addIngredient(CommonTags.C_CROPS_GARLIC)
                .addIngredient(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_PORK), RecipeProvider.has(CommonTags.C_FOODS_RAW_PORK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_CHICKEN), RecipeProvider.has(CommonTags.C_FOODS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.has(CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.SISIG.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.BULALO.get(), 1, 200, 4.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_BEEF)
                .addIngredient(CommonTags.C_BONES)
                .addIngredient(CommonTags.C_CROPS_ONION)
                .addIngredient(CommonTags.C_CROPS_CABBAGE)
                .addIngredient(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .addIngredient(CommonTags.C_CROPS_LEMONGRASS)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_BEEF), RecipeProvider.has(CommonTags.C_FOODS_RAW_BEEF))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_BONES), RecipeProvider.has(CommonTags.C_BONES))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.has(CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_CABBAGE), RecipeProvider.has(CommonTags.C_CROPS_CABBAGE))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.BULALO.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.ARROZ_CALDO.get(), 1, 200, 4.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_CHICKEN)
                .addIngredient(CommonTags.C_CROPS_GRAIN)
                .addIngredient(CommonTags.C_CROPS_GARLIC)
                .addIngredient(CommonTags.C_CROPS_GINGER)
                .addIngredient(CommonTags.C_CROPS_LEMONGRASS)
                .addIngredient(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_CHICKEN), RecipeProvider.has(CommonTags.C_FOODS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeProvider.has(CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GINGER), RecipeProvider.has(CommonTags.C_CROPS_GINGER))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.ARROZ_CALDO.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.MECHADO.get(), 1, 200, 4.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_BEEF)
                .addIngredient(CommonTags.C_CROPS_ONION)
                .addIngredient(CommonTags.C_CROPS_GARLIC)
                .addIngredient(CommonTags.C_CROPS_TOMATO)
                .addIngredient(CommonTags.C_FOODS_VEGETABLE)
                .addIngredient(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_BEEF), RecipeProvider.has(CommonTags.C_FOODS_RAW_BEEF))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.has(CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_TOMATO), RecipeProvider.has(CommonTags.C_CROPS_TOMATO))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_VEGETABLE), RecipeProvider.has(CommonTags.C_FOODS_VEGETABLE))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.MECHADO.get()));

        // ** SWEETS **
        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.LECHE_FLAN.get(), 4, 100, 0.5F)
                .addIngredient(CommonTags.C_EGGS)
                .addIngredient(CommonTags.C_EGGS)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_EGGS), RecipeUtil.getTriggerfromTagWithCount(2, CommonTags.C_EGGS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.LECHE_FLAN.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.RAW_POLVORONE.get(), 4, 100, 0.0f)
                .addIngredient(CommonTags.C_CROPS_GRAIN)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.MILK_POWDER.get())
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeProvider.has(CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.MILK_POWDER.get()), RecipeProvider.has(UbesDelightItems.MILK_POWDER.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.RAW_POLVORONE.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.RAW_POLVORONE_PINIPIG.get(), 4, 100, 0.0f)
                .addIngredient(CommonTags.C_CROPS_GRAIN)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.MILK_POWDER.get())
                .addIngredient(CommonTags.C_CROPS_RICE)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeProvider.has(CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.MILK_POWDER.get()), RecipeProvider.has(UbesDelightItems.MILK_POWDER.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_RICE), RecipeProvider.has(CommonTags.C_CROPS_RICE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.RAW_POLVORONE_PINIPIG.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.RAW_POLVORONE_UBE.get(), 4, 100, 0.0f)
                .addIngredient(CommonTags.C_CROPS_GRAIN)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.MILK_POWDER.get())
                .addIngredient(CommonTags.C_CROPS_UBE)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeProvider.has(CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.MILK_POWDER.get()), RecipeProvider.has(UbesDelightItems.MILK_POWDER.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.RAW_POLVORONE_UBE.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(UbesDelightItems.RAW_POLVORONE_CC.get(), 4, 100, 0.0f)
                .addIngredient(CommonTags.C_CROPS_GRAIN)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.MILK_POWDER.get())
                .addIngredient(Items.COOKIE)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeProvider.has(CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.MILK_POWDER.get()), RecipeProvider.has(UbesDelightItems.MILK_POWDER.get()))
                .unlockedBy(RecipeProvider.getHasName(Items.COOKIE), RecipeProvider.has(Items.COOKIE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.RAW_POLVORONE_CC.get()));
    }

    private static ResourceLocation recipeConversionName(Item output, Item input) {
        return suffix(RecipeProvider.getConversionRecipeName(output, input));
    }

    private static ResourceLocation recipeName(Item item) {
        return suffix(RecipeProvider.getItemName(item));
    }

    private static ResourceLocation suffix(String string) {
        return TextUtils.res(string);
    }
}
