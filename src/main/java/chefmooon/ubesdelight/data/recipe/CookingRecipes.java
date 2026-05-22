package chefmooon.ubesdelight.data.recipe;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import chefmooon.ubesdelight.common.utility.TextUtils;
import chefmooon.ubesdelight.common.utility.RecipeUtil;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.crafting.CookingPotBookCategory;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

public class CookingRecipes {
    // Farmer's Delight compatibility items
    static Item MILK_BOTTLE = ModItems.MILK_BOTTLE.get();

    public static void register(HolderGetter<Item> holderGetter, HolderLookup.Provider provider, RecipeOutput exporter) {

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), 1, 50, .0F)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(MILK_BOTTLE)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.has(holderGetter, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(MILK_BOTTLE), RecipeUtil.has(holderGetter, MILK_BOTTLE))
                .setRecipeBookCategory(CookingPotBookCategory.DRINKS)
                .build(exporter, recipeConversionName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), MILK_BOTTLE));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), 4, 200, .0F)
                .addIngredient(Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), 4)
                .addIngredient(Items.MILK_BUCKET)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.has(holderGetter, 4, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(Items.MILK_BUCKET), InventoryChangeTrigger.TriggerInstance.hasItems(Items.MILK_BUCKET))
                .setRecipeBookCategory(CookingPotBookCategory.DRINKS)
                .build(exporter, recipeConversionName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.FISH_SAUCE_BOTTLE.get(), 4, 200, .0F)
                .addIngredient(CompatibilityTags.MINECRAFT_FISHES)
                .addIngredient(Items.WATER_BUCKET)
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_FISHES), RecipeUtil.has(holderGetter, CompatibilityTags.MINECRAFT_FISHES))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeUtil.has(holderGetter, Items.WATER_BUCKET))
                .setRecipeBookCategory(CookingPotBookCategory.DRINKS)
                .build(exporter, recipeConversionName(UbesDelightItems.FISH_SAUCE_BOTTLE.get(), Items.WATER_BUCKET) + "_extra");

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.SUGAR_BROWN.get(), 1,  200, 0.5F)
                .addIngredient(Items.SUGAR)
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeUtil.has(holderGetter, Items.SUGAR))
                .setRecipeBookCategory(CookingPotBookCategory.DRINKS)
                .build(exporter, recipeName(UbesDelightItems.SUGAR_BROWN.get()));


        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.CHICKEN_INASAL_RICE.get(), 1, 200, 3.0F)
                .addIngredient(UbesDelightItems.CHICKEN_INASAL.get())
                .addIngredient(UbesDelightItems.SINANGAG.get())
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CHICKEN_INASAL.get()), RecipeUtil.has(holderGetter, UbesDelightItems.CHICKEN_INASAL.get()))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeUtil.has(holderGetter, UbesDelightItems.SINANGAG.get()))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.CHICKEN_INASAL_RICE.get()));



        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.FISH_SAUCE_BOTTLE.get(), 4, 200, .0F)
                .addIngredient(CommonTags.C_FOODS_SAFE_RAW_FISH)
                .addIngredient(Items.WATER_BUCKET)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_SAFE_RAW_FISH), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_SAFE_RAW_FISH))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeUtil.has(holderGetter, Items.WATER_BUCKET))
                .setRecipeBookCategory(CookingPotBookCategory.DRINKS)
                .build(exporter, recipeConversionName(UbesDelightItems.FISH_SAUCE_BOTTLE.get(), Items.WATER_BUCKET));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.MILK_POWDER.get(), 1, 200,  0.2F)
                .addIngredient(ConventionalItemTags.MILK_DRINKS)
                .unlockedBy(RecipeUtil.hasItemTag(ConventionalItemTags.MILK_DRINKS), RecipeUtil.has(holderGetter, ConventionalItemTags.MILK_DRINKS))
                .setRecipeBookCategory(CookingPotBookCategory.DRINKS)
                .build(exporter, recipeName(UbesDelightItems.MILK_POWDER.get()));

        // ** DRINKS **
        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.MILK_TEA_UBE.get(), 1, 50, 0.25F)
                .addIngredient(CommonTags.C_CROPS_UBE)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeUtil.has(holderGetter, Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.has(holderGetter, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeUtil.has(holderGetter, UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .setRecipeBookCategory(CookingPotBookCategory.DRINKS)
                .build(exporter, recipeName(UbesDelightItems.MILK_TEA_UBE.get()) + "_single");

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.MILK_TEA_UBE.get(), 4, 200, 1.0F)
                .addIngredient(CommonTags.C_CROPS_UBE)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), 4)
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeUtil.has(holderGetter, Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.has(holderGetter, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeUtil.has(holderGetter, 4, UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .setRecipeBookCategory(CookingPotBookCategory.DRINKS)
                .build(exporter, recipeName(UbesDelightItems.MILK_TEA_UBE.get()) + "_multiple");

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.HALO_HALO.get(), 1, 200, 1.0F)
                .addIngredient(CommonTags.C_CROPS_UBE)
                .addIngredient(UbesDelightItems.LECHE_FLAN.get())
                .addIngredient(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .addIngredient(Items.SWEET_BERRIES)
                .addIngredient(Items.GLOW_BERRIES)
                .addIngredient(Items.MELON_SLICE)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.LECHE_FLAN.get()), RecipeUtil.has(holderGetter, UbesDelightItems.LECHE_FLAN.get()))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeUtil.has(holderGetter, UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .unlockedBy(RecipeProvider.getHasName(Items.SWEET_BERRIES), RecipeUtil.has(holderGetter, Items.SWEET_BERRIES))
                .unlockedBy(RecipeProvider.getHasName(Items.GLOW_BERRIES), RecipeUtil.has(holderGetter, Items.GLOW_BERRIES))
                .unlockedBy(RecipeProvider.getHasName(Items.MELON_SLICE), RecipeUtil.has(holderGetter, Items.MELON_SLICE))
                .setRecipeBookCategory(CookingPotBookCategory.DRINKS)
                .build(exporter, recipeName(UbesDelightItems.HALO_HALO.get()));

        // ** FOOD **
        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.SINANGAG.get(), 1, 200, 1.0F)
                .addIngredient(CommonTags.C_CROPS_RICE)
                .addIngredient(CommonTags.C_CROPS_GARLIC)
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeUtil.has(holderGetter, Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_RICE), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_RICE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_GARLIC))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.SINANGAG.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.LUMPIA.get(), 1, 200, 2.0F)
                .addIngredient(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS)
                .addIngredient(CommonTags.C_FOODS_LEAFY_GREEN)
                .addIngredient(CommonTags.C_CROPS_LEMONGRASS)
                .addIngredient(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS), RecipeUtil.has(holderGetter, CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_LEAFY_GREEN), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_LEAFY_GREEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER), RecipeUtil.has(holderGetter, CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.LUMPIA.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.TOCINO.get(), 1, 200, 2.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_PORK)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(CommonTags.C_CROPS_GINGER)
                .addIngredient(Items.BEETROOT)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_PORK), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_RAW_PORK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.has(holderGetter, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GINGER), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_GINGER))
                .unlockedBy(RecipeProvider.getHasName(Items.BEETROOT), RecipeUtil.has(holderGetter, Items.BEETROOT))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.TOCINO.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.CHICKEN_INASAL.get(), 1, 200, 2.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_CHICKEN)
                .addIngredient(CommonTags.C_CROPS_LEMONGRASS)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_CHICKEN), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.has(holderGetter, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.CHICKEN_INASAL.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.TOSILOG.get(), 1, 200, 3.0F)
                .addIngredient(UbesDelightItems.TOCINO.get())
                .addIngredient(UbesDelightItems.SINANGAG.get())
                .addIngredient(CommonTags.C_FOODS_COOKED_EGG)
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.TOCINO.get()), RecipeUtil.has(holderGetter, UbesDelightItems.TOCINO.get()))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeUtil.has(holderGetter, UbesDelightItems.SINANGAG.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_EGG), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_COOKED_EGG))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.TOSILOG.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.BANGSILOG.get(), 1, 200, 3.0F)
                .addIngredient(CommonTags.C_FOODS_SAFE_RAW_FISH)
                .addIngredient(UbesDelightItems.SINANGAG.get())
                .addIngredient(CommonTags.C_FOODS_COOKED_EGG)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_SAFE_RAW_FISH), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_SAFE_RAW_FISH))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeUtil.has(holderGetter, UbesDelightItems.SINANGAG.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_EGG), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_COOKED_EGG))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.BANGSILOG.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.BANGSILOG.get(), 1, 200, 3.0F)
                .addIngredient(CompatibilityTags.MINECRAFT_FISHES)
                .addIngredient(UbesDelightItems.SINANGAG.get())
                .addIngredient(CommonTags.C_FOODS_COOKED_EGG)
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_FISHES), RecipeUtil.has(holderGetter, CompatibilityTags.MINECRAFT_FISHES))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeUtil.has(holderGetter, UbesDelightItems.SINANGAG.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_EGG), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_COOKED_EGG))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.BANGSILOG.get()) + "_extra"));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.SISIG.get(), 1, 200, 4.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_PORK)
                .addIngredient(CommonTags.C_FOODS_RAW_CHICKEN)
                .addIngredient(CommonTags.C_CROPS_ONION)
                .addIngredient(CommonTags.C_CROPS_GARLIC)
                .addIngredient(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_PORK), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_RAW_PORK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_CHICKEN), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeUtil.has(holderGetter, UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.SISIG.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.BULALO.get(), 1, 200, 4.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_BEEF)
                .addIngredient(ConventionalItemTags.BONES)
                .addIngredient(CommonTags.C_CROPS_ONION)
                .addIngredient(CommonTags.C_CROPS_CABBAGE)
                .addIngredient(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .addIngredient(CommonTags.C_CROPS_LEMONGRASS)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_BEEF), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_RAW_BEEF))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_BONES), RecipeUtil.has(holderGetter, CommonTags.C_BONES))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_CABBAGE), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_CABBAGE))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeUtil.has(holderGetter, UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_LEMONGRASS))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.BULALO.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.ARROZ_CALDO.get(), 1, 200, 4.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_CHICKEN)
                .addIngredient(CommonTags.C_CROPS_GRAIN)
                .addIngredient(CommonTags.C_CROPS_GARLIC)
                .addIngredient(CommonTags.C_CROPS_GINGER)
                .addIngredient(CommonTags.C_CROPS_LEMONGRASS)
                .addIngredient(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_CHICKEN), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GINGER), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_GINGER))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeUtil.has(holderGetter, UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.ARROZ_CALDO.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.MECHADO.get(), 1, 200, 4.0F)
                .addIngredient(CommonTags.C_FOODS_RAW_BEEF)
                .addIngredient(CommonTags.C_CROPS_ONION)
                .addIngredient(CommonTags.C_CROPS_GARLIC)
                .addIngredient(CommonTags.C_CROPS_TOMATO)
                .addIngredient(ConventionalItemTags.VEGETABLE_FOODS)
                .addIngredient(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_BEEF), RecipeUtil.has(holderGetter, CommonTags.C_FOODS_RAW_BEEF))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_TOMATO), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_TOMATO))
                .unlockedBy(RecipeUtil.hasItemTag(ConventionalItemTags.VEGETABLE_FOODS), RecipeUtil.has(holderGetter, ConventionalItemTags.VEGETABLE_FOODS))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeUtil.has(holderGetter, UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.MECHADO.get()));

        // ** SWEETS **
        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.LECHE_FLAN.get(), 4, 100, 0.5F)
                .addIngredient(Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.EGGS)), 2)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .unlockedBy(RecipeUtil.hasItemTag(ConventionalItemTags.EGGS), RecipeUtil.has(holderGetter, 2, ConventionalItemTags.EGGS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.has(holderGetter, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeUtil.has(holderGetter, UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.LECHE_FLAN.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.RAW_POLVORONE.get(), 4, 100, 0.0f)
                .addIngredient(CommonTags.C_CROPS_GRAIN)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.MILK_POWDER.get())
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.has(holderGetter, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.MILK_POWDER.get()), RecipeUtil.has(holderGetter, UbesDelightItems.MILK_POWDER.get()))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.RAW_POLVORONE.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.RAW_POLVORONE_PINIPIG.get(), 4, 100, 0.0f)
                .addIngredient(CommonTags.C_CROPS_GRAIN)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.MILK_POWDER.get())
                .addIngredient(CommonTags.C_CROPS_RICE)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.has(holderGetter, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.MILK_POWDER.get()), RecipeUtil.has(holderGetter, UbesDelightItems.MILK_POWDER.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_RICE), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_RICE))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.RAW_POLVORONE_PINIPIG.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.RAW_POLVORONE_UBE.get(), 4, 100, 0.0f)
                .addIngredient(CommonTags.C_CROPS_GRAIN)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.MILK_POWDER.get())
                .addIngredient(CommonTags.C_CROPS_UBE)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.has(holderGetter, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.MILK_POWDER.get()), RecipeUtil.has(holderGetter, UbesDelightItems.MILK_POWDER.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_UBE))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.RAW_POLVORONE_UBE.get()));

        CookingPotRecipeBuilder.cookingPotRecipe(holderGetter, UbesDelightItems.RAW_POLVORONE_CC.get(), 4, 100, 0.0f)
                .addIngredient(CommonTags.C_CROPS_GRAIN)
                .addIngredient(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .addIngredient(UbesDelightItems.MILK_POWDER.get())
                .addIngredient(Items.COOKIE)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeUtil.has(holderGetter, CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.has(holderGetter, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.MILK_POWDER.get()), RecipeUtil.has(holderGetter, UbesDelightItems.MILK_POWDER.get()))
                .unlockedBy(RecipeProvider.getHasName(Items.COOKIE), RecipeUtil.has(holderGetter, Items.COOKIE))
                .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                .build(exporter, recipeName(UbesDelightItems.RAW_POLVORONE_CC.get()));
    }

    private static Identifier recipeConversionName(Item output, Item input) {
        return suffix(RecipeProvider.getConversionRecipeName(output, input));
    }

    private static Identifier recipeName(Item item) {
        return suffix(RecipeProvider.getItemName(item));
    }

    private static Identifier suffix(String string) {
        return TextUtils.res("cooking/" + string);
    }
}
