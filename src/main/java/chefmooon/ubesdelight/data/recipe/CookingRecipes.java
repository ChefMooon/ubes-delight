package chefmooon.ubesdelight.data.recipe;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import chefmooon.ubesdelight.common.utility.TextUtils;
import chefmooon.ubesdelight.common.utility.RecipeUtil;
import chefmooon.ubesdelight.data.builder.CookingPotRecipeJsonBuilder;
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

import static chefmooon.ubesdelight.common.utility.RecipeUtil.nonNullList;

public class CookingRecipes {
    // Farmer's Delight compatibility items
    static Item MILK_BOTTLE = ModItems.MILK_BOTTLE.get();

    public static void register(RecipeOutput exporter) {

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), 1, 50, .0F,
                        nonNullList(Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(MILK_BOTTLE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(MILK_BOTTLE), RecipeUtil.getTriggerfromItem(MILK_BOTTLE))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), MILK_BOTTLE));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), 4, 200, .0F,
                        nonNullList(Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(Items.MILK_BUCKET)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.getTriggerfromTagWithCount(4, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(Items.MILK_BUCKET), RecipeProvider.has(Items.MILK_BUCKET))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.FISH_SAUCE_BOTTLE.get(), 4, 200, .0F,
                        nonNullList(Ingredient.of(CompatibilityTags.MINECRAFT_FISHES),
                                Ingredient.of(Items.WATER_BUCKET)))
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_FISHES), RecipeProvider.has(CompatibilityTags.MINECRAFT_FISHES))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeProvider.has(Items.WATER_BUCKET))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItems.FISH_SAUCE_BOTTLE.get(), Items.WATER_BUCKET) + "_extra");

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.SUGAR_BROWN.get(), 1,  200, 0.5F,
                        nonNullList(Ingredient.of(Items.SUGAR)))
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItems.SUGAR_BROWN.get()));


        CookingPotRecipeJsonBuilder.create(UbesDelightItems.CHICKEN_INASAL_RICE.get(), 1, 200, 3.0F,
                        nonNullList(Ingredient.of(UbesDelightItems.CHICKEN_INASAL.get()),
                                Ingredient.of(UbesDelightItems.SINANGAG.get())))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CHICKEN_INASAL.get()), RecipeProvider.has(UbesDelightItems.CHICKEN_INASAL.get()))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeProvider.has(UbesDelightItems.SINANGAG.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.CHICKEN_INASAL_RICE.get()));



        CookingPotRecipeJsonBuilder.create(UbesDelightItems.FISH_SAUCE_BOTTLE.get(), 4, 200, .0F,
                        nonNullList(Ingredient.of(CommonTags.C_FOODS_SAFE_RAW_FISH),
                                Ingredient.of(Items.WATER_BUCKET)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_SAFE_RAW_FISH), RecipeProvider.has(CommonTags.C_FOODS_SAFE_RAW_FISH))
                .unlockedBy(RecipeProvider.getHasName(Items.WATER_BUCKET), RecipeProvider.has(Items.WATER_BUCKET))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeConversionName(UbesDelightItems.FISH_SAUCE_BOTTLE.get(), Items.WATER_BUCKET));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.MILK_POWDER.get(), 1, 200,  0.2F,
                        nonNullList(Ingredient.of(ConventionalItemTags.MILK_DRINKS)))
                .unlockedBy(RecipeUtil.hasItemTag(ConventionalItemTags.MILK_DRINKS), RecipeProvider.has(ConventionalItemTags.MILK_DRINKS))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItems.MILK_POWDER.get()));

        // ** DRINKS **
        CookingPotRecipeJsonBuilder.create(UbesDelightItems.MILK_TEA_UBE.get(), 1, 50, 0.25F,
                        nonNullList(Ingredient.of(CommonTags.C_CROPS_UBE),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())))
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItems.MILK_TEA_UBE.get()) + "_single");

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.MILK_TEA_UBE.get(), 4, 200, 1.0F,
                        nonNullList(Ingredient.of(CommonTags.C_CROPS_UBE),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()),
                                Ingredient.of(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()),
                                Ingredient.of(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()),
                                Ingredient.of(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())))
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.has(MinMaxBounds.Ints.atLeast(4), UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItems.MILK_TEA_UBE.get()) + "_multiple");

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.HALO_HALO.get(), 1, 200, 1.0F,
                        nonNullList(Ingredient.of(CommonTags.C_CROPS_UBE),
                                Ingredient.of(UbesDelightItems.LECHE_FLAN.get()),
                                Ingredient.of(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()),
                                Ingredient.of(Items.SWEET_BERRIES),
                                Ingredient.of(Items.GLOW_BERRIES),
                                Ingredient.of(Items.MELON_SLICE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.LECHE_FLAN.get()), RecipeProvider.has(UbesDelightItems.LECHE_FLAN.get()))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .unlockedBy(RecipeProvider.getHasName(Items.SWEET_BERRIES), RecipeProvider.has(Items.SWEET_BERRIES))
                .unlockedBy(RecipeProvider.getHasName(Items.GLOW_BERRIES), RecipeProvider.has(Items.GLOW_BERRIES))
                .unlockedBy(RecipeProvider.getHasName(Items.MELON_SLICE), RecipeProvider.has(Items.MELON_SLICE))
                .setRecipeBookTab(CookingPotRecipeBookTab.DRINKS)
                .save(exporter, recipeName(UbesDelightItems.HALO_HALO.get()));

        // ** FOOD **
        CookingPotRecipeJsonBuilder.create(UbesDelightItems.SINANGAG.get(), 1, 200, 1.0F,
                        nonNullList(Ingredient.of(CommonTags.C_CROPS_RICE),
                                Ingredient.of(CommonTags.C_CROPS_GARLIC)))
                .unlockedBy(RecipeProvider.getHasName(Items.SUGAR), RecipeProvider.has(Items.SUGAR))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_RICE), RecipeProvider.has(CommonTags.C_CROPS_RICE))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.SINANGAG.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.LUMPIA.get(), 1, 200, 2.0F,
                        nonNullList(Ingredient.of(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS),
                                Ingredient.of(CommonTags.C_FOODS_LEAFY_GREEN),
                                Ingredient.of(CommonTags.C_CROPS_LEMONGRASS),
                                Ingredient.of(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)))
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS), RecipeProvider.has(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_LEAFY_GREEN), RecipeProvider.has(CommonTags.C_FOODS_LEAFY_GREEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER), RecipeProvider.has(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.LUMPIA.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.TOCINO.get(), 1, 200, 2.0F,
                        nonNullList(Ingredient.of(CommonTags.C_FOODS_RAW_PORK),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(CommonTags.C_CROPS_GINGER),
                                Ingredient.of(Items.BEETROOT)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_PORK), RecipeProvider.has(CommonTags.C_FOODS_RAW_PORK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GINGER), RecipeProvider.has(CommonTags.C_CROPS_GINGER))
                .unlockedBy(RecipeProvider.getHasName(Items.BEETROOT), RecipeProvider.has(Items.BEETROOT))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.TOCINO.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.CHICKEN_INASAL.get(), 1, 200, 2.0F,
                        nonNullList(Ingredient.of(CommonTags.C_FOODS_RAW_CHICKEN),
                                Ingredient.of(CommonTags.C_CROPS_LEMONGRASS),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_CHICKEN), RecipeProvider.has(CommonTags.C_FOODS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.CHICKEN_INASAL.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.TOSILOG.get(), 1, 200, 3.0F,
                        nonNullList(Ingredient.of(UbesDelightItems.TOCINO.get()),
                                Ingredient.of(UbesDelightItems.SINANGAG.get()),
                                Ingredient.of(CommonTags.C_FOODS_COOKED_EGG)))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.TOCINO.get()), RecipeProvider.has(UbesDelightItems.TOCINO.get()))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeProvider.has(UbesDelightItems.SINANGAG.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_EGG), RecipeProvider.has(CommonTags.C_FOODS_COOKED_EGG))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.TOSILOG.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.BANGSILOG.get(), 1, 200, 3.0F,
                        nonNullList(Ingredient.of(CommonTags.C_FOODS_SAFE_RAW_FISH),
                                Ingredient.of(UbesDelightItems.SINANGAG.get()),
                                Ingredient.of(CommonTags.C_FOODS_COOKED_EGG)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_SAFE_RAW_FISH), RecipeProvider.has(CommonTags.C_FOODS_SAFE_RAW_FISH))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeProvider.has(UbesDelightItems.SINANGAG.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_EGG), RecipeProvider.has(CommonTags.C_FOODS_COOKED_EGG))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.BANGSILOG.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.BANGSILOG.get(), 1, 200, 3.0F,
                        nonNullList(Ingredient.of(CompatibilityTags.MINECRAFT_FISHES),
                                Ingredient.of(UbesDelightItems.SINANGAG.get()),
                                Ingredient.of(CommonTags.C_FOODS_COOKED_EGG)))
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_FISHES), RecipeProvider.has(CompatibilityTags.MINECRAFT_FISHES))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.SINANGAG.get()), RecipeProvider.has(UbesDelightItems.SINANGAG.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_COOKED_EGG), RecipeProvider.has(CommonTags.C_FOODS_COOKED_EGG))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.BANGSILOG.get()) + "_extra"));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.SISIG.get(), 1, 200, 4.0F,
                        nonNullList(Ingredient.of(CommonTags.C_FOODS_RAW_PORK),
                                Ingredient.of(CommonTags.C_FOODS_RAW_CHICKEN),
                                Ingredient.of(CommonTags.C_CROPS_ONION),
                                Ingredient.of(CommonTags.C_CROPS_GARLIC),
                                Ingredient.of(UbesDelightItems.FISH_SAUCE_BOTTLE.get())))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_PORK), RecipeProvider.has(CommonTags.C_FOODS_RAW_PORK))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_CHICKEN), RecipeProvider.has(CommonTags.C_FOODS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.has(CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.SISIG.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.BULALO.get(), 1, 200, 4.0F,
                        nonNullList(Ingredient.of(CommonTags.C_FOODS_RAW_BEEF),
                                Ingredient.of(CommonTags.C_BONES),
                                Ingredient.of(CommonTags.C_CROPS_ONION),
                                Ingredient.of(CommonTags.C_CROPS_CABBAGE),
                                Ingredient.of(UbesDelightItems.FISH_SAUCE_BOTTLE.get()),
                                Ingredient.of(CommonTags.C_CROPS_LEMONGRASS)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_BEEF), RecipeProvider.has(CommonTags.C_FOODS_RAW_BEEF))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_BONES), RecipeProvider.has(CommonTags.C_BONES))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.has(CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_CABBAGE), RecipeProvider.has(CommonTags.C_CROPS_CABBAGE))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.BULALO.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.ARROZ_CALDO.get(), 1, 200, 4.0F,
                        nonNullList(Ingredient.of(CommonTags.C_FOODS_RAW_CHICKEN),
                                Ingredient.of(CommonTags.C_CROPS_GRAIN),
                                Ingredient.of(CommonTags.C_CROPS_GARLIC),
                                Ingredient.of(CommonTags.C_CROPS_GINGER),
                                Ingredient.of(CommonTags.C_CROPS_LEMONGRASS),
                                Ingredient.of(UbesDelightItems.FISH_SAUCE_BOTTLE.get())))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_CHICKEN), RecipeProvider.has(CommonTags.C_FOODS_RAW_CHICKEN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeProvider.has(CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GINGER), RecipeProvider.has(CommonTags.C_CROPS_GINGER))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.has(CommonTags.C_CROPS_LEMONGRASS))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.ARROZ_CALDO.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.MECHADO.get(), 1, 200, 4.0F,
                        nonNullList(Ingredient.of(CommonTags.C_FOODS_RAW_BEEF),
                                Ingredient.of(CommonTags.C_CROPS_ONION),
                                Ingredient.of(CommonTags.C_CROPS_GARLIC),
                                Ingredient.of(CommonTags.C_CROPS_TOMATO),
                                Ingredient.of(CommonTags.C_FOODS_VEGETABLE),
                                Ingredient.of(UbesDelightItems.FISH_SAUCE_BOTTLE.get())))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_RAW_BEEF), RecipeProvider.has(CommonTags.C_FOODS_RAW_BEEF))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.has(CommonTags.C_CROPS_ONION))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GARLIC), RecipeProvider.has(CommonTags.C_CROPS_GARLIC))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_TOMATO), RecipeProvider.has(CommonTags.C_CROPS_TOMATO))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_FOODS_VEGETABLE), RecipeProvider.has(CommonTags.C_FOODS_VEGETABLE))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.FISH_SAUCE_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.MECHADO.get()));

        // ** SWEETS **
        CookingPotRecipeJsonBuilder.create(UbesDelightItems.LECHE_FLAN.get(), 4, 100, 0.5F,
                        nonNullList(Ingredient.of(CommonTags.C_EGGS),
                                Ingredient.of(CommonTags.C_EGGS),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_EGGS), RecipeUtil.getTriggerfromTagWithCount(2, CommonTags.C_EGGS))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.has(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.LECHE_FLAN.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.RAW_POLVORONE.get(), 4, 100, 0.0f,
                        nonNullList(Ingredient.of(CommonTags.C_CROPS_GRAIN),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItems.MILK_POWDER.get())))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeProvider.has(CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.MILK_POWDER.get()), RecipeProvider.has(UbesDelightItems.MILK_POWDER.get()))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.RAW_POLVORONE.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.RAW_POLVORONE_PINIPIG.get(), 4, 100, 0.0f,
                        nonNullList(Ingredient.of(CommonTags.C_CROPS_GRAIN),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItems.MILK_POWDER.get()),
                                Ingredient.of(CommonTags.C_CROPS_RICE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeProvider.has(CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.MILK_POWDER.get()), RecipeProvider.has(UbesDelightItems.MILK_POWDER.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_RICE), RecipeProvider.has(CommonTags.C_CROPS_RICE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.RAW_POLVORONE_PINIPIG.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.RAW_POLVORONE_UBE.get(), 4, 100, 0.0f,
                        nonNullList(Ingredient.of(CommonTags.C_CROPS_GRAIN),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItems.MILK_POWDER.get()),
                                Ingredient.of(CommonTags.C_CROPS_UBE)))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_GRAIN), RecipeProvider.has(CommonTags.C_CROPS_GRAIN))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.has(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.MILK_POWDER.get()), RecipeProvider.has(UbesDelightItems.MILK_POWDER.get()))
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.has(CommonTags.C_CROPS_UBE))
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(exporter, recipeName(UbesDelightItems.RAW_POLVORONE_UBE.get()));

        CookingPotRecipeJsonBuilder.create(UbesDelightItems.RAW_POLVORONE_CC.get(), 4, 100, 0.0f,
                        nonNullList(Ingredient.of(CommonTags.C_CROPS_GRAIN),
                                Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(UbesDelightItems.MILK_POWDER.get()),
                                Ingredient.of(Items.COOKIE)))
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
