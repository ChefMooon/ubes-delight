package com.chefmoon.ubesdelight.data.recipe;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.data.builder.CookingPotRecipeJsonBuilder;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import com.chefmoon.ubesdelight.tag.CompatibilityTags;
import com.chefmoon.ubesdelight.util.CookingPotRecipeCategory;
import com.chefmoon.ubesdelight.util.RecipeUtil;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.predicate.NumberRange;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class CookingRecipes {

    public static void register(Consumer<RecipeJsonProvider> exporter) {

        // Farmer's Delight compatibility items
        Item MILK_BOTTLE = com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry.MILK_BOTTLE.get();

        // ** INGREDIENTS **
        //TODO: V0.1.5
        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.DRINKS, ItemsRegistry.CONDENSED_MILK_BOTTLE.get(), .0F, 50,
                        List.of(Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.ofItems(MILK_BOTTLE)))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(MILK_BOTTLE), RecipeProvider.conditionsFromItem(MILK_BOTTLE))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.CONDENSED_MILK_BOTTLE.get(), MILK_BOTTLE)));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.DRINKS, ItemsRegistry.CONDENSED_MILK_BOTTLE.get(), 4, .0F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.ofItems(Items.MILK_BUCKET)))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeUtil.conditionsFromTagWithCount(4, CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(Items.MILK_BUCKET), RecipeProvider.conditionsFromItem(Items.MILK_BUCKET))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET)));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.DRINKS, ItemsRegistry.FISH_SAUCE_BOTTLE.get(), 4, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_RAW_FISHES),
                                Ingredient.ofItems(Items.WATER_BUCKET)))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_RAW_FISHES), RecipeProvider.conditionsFromTag(CommonTags.C_RAW_FISHES))
                .criterion(RecipeProvider.hasItem(Items.WATER_BUCKET), RecipeProvider.conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.FISH_SAUCE_BOTTLE.get(), Items.WATER_BUCKET)));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.DRINKS, ItemsRegistry.FISH_SAUCE_BOTTLE.get(), 4, 200,
                        List.of(Ingredient.fromTag(CompatibilityTags.MINECRAFT_FISHES),
                                Ingredient.ofItems(Items.WATER_BUCKET)))
                .criterion(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_FISHES), RecipeProvider.conditionsFromTag(CompatibilityTags.MINECRAFT_FISHES))
                .criterion(RecipeProvider.hasItem(Items.WATER_BUCKET), RecipeProvider.conditionsFromItem(Items.WATER_BUCKET))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.FISH_SAUCE_BOTTLE.get(), Items.WATER_BUCKET)) + "_extra");

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MISC, ItemsRegistry.MILK_POWDER.get(), 0.2F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_MILK_MILK_BOTTLE)))
                .criterion(RecipeProvider.hasItem(Items.SUGAR), RecipeProvider.conditionsFromItem(Items.SUGAR))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_MILK_MILK_BOTTLE), RecipeProvider.conditionsFromTag(CommonTags.C_MILK_MILK_BOTTLE))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.MILK_POWDER.get(), MILK_BOTTLE)));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.DRINKS, ItemsRegistry.SUGAR_BROWN.get(), 0.3F, 200,
                        List.of(Ingredient.ofItems(Items.SUGAR)))
                .criterion(RecipeProvider.hasItem(Items.SUGAR), RecipeProvider.conditionsFromItem(Items.SUGAR))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.SUGAR_BROWN.get())));

        // ** DRINKS **
        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.DRINKS, ItemsRegistry.MILK_TEA_UBE.get(), 0.25F, 50,
                        List.of(Ingredient.fromTag(CommonTags.C_CROPS_UBE),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.ofItems(ItemsRegistry.CONDENSED_MILK_BOTTLE.get())))
                .criterion(RecipeProvider.hasItem(Items.SUGAR), RecipeProvider.conditionsFromItem(Items.SUGAR))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_UBE))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.CONDENSED_MILK_BOTTLE.get()))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.MILK_TEA_UBE.get()) + "_single"));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.DRINKS, ItemsRegistry.MILK_TEA_UBE.get(), 4, 1.0F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_CROPS_UBE),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.ofItems(ItemsRegistry.CONDENSED_MILK_BOTTLE.get()),
                                Ingredient.ofItems(ItemsRegistry.CONDENSED_MILK_BOTTLE.get()),
                                Ingredient.ofItems(ItemsRegistry.CONDENSED_MILK_BOTTLE.get()),
                                Ingredient.ofItems(ItemsRegistry.CONDENSED_MILK_BOTTLE.get())))
                .criterion(RecipeProvider.hasItem(Items.SUGAR), RecipeProvider.conditionsFromItem(Items.SUGAR))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_UBE))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(4), ItemsRegistry.CONDENSED_MILK_BOTTLE.get()))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.MILK_TEA_UBE.get()) + "_multiple"));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.DRINKS, ItemsRegistry.HALO_HALO.get(), 1.0F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_CROPS_UBE),
                                Ingredient.ofItems(ItemsRegistry.LECHE_FLAN.get()),
                                Ingredient.ofItems(ItemsRegistry.CONDENSED_MILK_BOTTLE.get()),
                                Ingredient.ofItems(Items.SWEET_BERRIES),
                                Ingredient.ofItems(Items.GLOW_BERRIES),
                                Ingredient.ofItems(Items.MELON_SLICE)))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_UBE))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.LECHE_FLAN.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.LECHE_FLAN.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.CONDENSED_MILK_BOTTLE.get()))
                .criterion(RecipeProvider.hasItem(Items.SWEET_BERRIES), RecipeProvider.conditionsFromItem(Items.SWEET_BERRIES))
                .criterion(RecipeProvider.hasItem(Items.GLOW_BERRIES), RecipeProvider.conditionsFromItem(Items.GLOW_BERRIES))
                .criterion(RecipeProvider.hasItem(Items.MELON_SLICE), RecipeProvider.conditionsFromItem(Items.MELON_SLICE))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.HALO_HALO.get())));

        // ** FOOD **
        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.SINANGAG.get(), 1.0F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_CROPS_RICE),
                                Ingredient.fromTag(CommonTags.C_VEGETABLES_GARLIC)))
                .criterion(RecipeProvider.hasItem(Items.SUGAR), RecipeProvider.conditionsFromItem(Items.SUGAR))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_RICE), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_RICE))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_GARLIC), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_GARLIC))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.SINANGAG.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.LUMPIA.get(), 2.0F, 200,
                        List.of(Ingredient.fromTag(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS),
                                Ingredient.fromTag(CommonTags.C_SALAD_INGREDIENTS),
                                Ingredient.fromTag(CommonTags.C_CROPS_LEMONGRASS),
                                Ingredient.fromTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)))
                .criterion(RecipeUtil.hasItemTag(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS), RecipeProvider.conditionsFromTag(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_SALAD_INGREDIENTS), RecipeProvider.conditionsFromTag(CommonTags.C_SALAD_INGREDIENTS))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_LEMONGRASS))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER), RecipeProvider.conditionsFromTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.LUMPIA.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.TOCINO.get(), 2.0F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_RAW_PORK),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.fromTag(CommonTags.C_VEGETABLES_GINGER),
                                Ingredient.ofItems(Items.BEETROOT)))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_RAW_PORK), RecipeProvider.conditionsFromTag(CommonTags.C_RAW_PORK))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_GINGER), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_GINGER))
                .criterion(RecipeProvider.hasItem(Items.BEETROOT), RecipeProvider.conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.TOCINO.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.CHICKEN_INASAL.get(), 2.0F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_RAW_CHICKEN),
                                Ingredient.fromTag(CommonTags.C_CROPS_LEMONGRASS),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_RAW_CHICKEN), RecipeProvider.conditionsFromTag(CommonTags.C_RAW_CHICKEN))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_LEMONGRASS))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.CHICKEN_INASAL.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.CHICKEN_INASAL_RICE.get(), 3.0F, 200,
                        List.of(Ingredient.ofItems(ItemsRegistry.CHICKEN_INASAL.get()),
                                Ingredient.ofItems(ItemsRegistry.SINANGAG.get())))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.CHICKEN_INASAL.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.CHICKEN_INASAL.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.SINANGAG.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.SINANGAG.get()))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.CHICKEN_INASAL_RICE.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.TOSILOG.get(), 3.0F, 200,
                        List.of(Ingredient.ofItems(ItemsRegistry.TOCINO.get()),
                                Ingredient.ofItems(ItemsRegistry.SINANGAG.get()),
                                Ingredient.fromTag(CommonTags.C_COOKED_EGGS)))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.TOCINO.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.TOCINO.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.SINANGAG.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.SINANGAG.get()))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_COOKED_EGGS), RecipeProvider.conditionsFromTag(CommonTags.C_COOKED_EGGS))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.TOSILOG.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.BANGSILOG.get(), 3.0F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_RAW_FISHES),
                                Ingredient.ofItems(ItemsRegistry.SINANGAG.get()),
                                Ingredient.fromTag(CommonTags.C_COOKED_EGGS)))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_RAW_FISHES), RecipeProvider.conditionsFromTag(CommonTags.C_RAW_FISHES))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.SINANGAG.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.SINANGAG.get()))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_COOKED_EGGS), RecipeProvider.conditionsFromTag(CommonTags.C_COOKED_EGGS))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.BANGSILOG.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.BANGSILOG.get(), 3.0F, 200,
                        List.of(Ingredient.fromTag(CompatibilityTags.MINECRAFT_FISHES),
                                Ingredient.ofItems(ItemsRegistry.SINANGAG.get()),
                                Ingredient.fromTag(CommonTags.C_COOKED_EGGS)))
                .criterion(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_FISHES), RecipeProvider.conditionsFromTag(CompatibilityTags.MINECRAFT_FISHES))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.SINANGAG.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.SINANGAG.get()))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_COOKED_EGGS), RecipeProvider.conditionsFromTag(CommonTags.C_COOKED_EGGS))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.BANGSILOG.get()) + "_extra"));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.SISIG.get(), 4.0F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_RAW_PORK),
                                Ingredient.fromTag(CommonTags.C_RAW_CHICKEN),
                                Ingredient.fromTag(CommonTags.C_CROPS_ONION),
                                Ingredient.fromTag(CommonTags.C_VEGETABLES_GARLIC),
                                Ingredient.ofItems(ItemsRegistry.FISH_SAUCE_BOTTLE.get())))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_RAW_PORK), RecipeProvider.conditionsFromTag(CommonTags.C_RAW_PORK))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_RAW_CHICKEN), RecipeProvider.conditionsFromTag(CommonTags.C_RAW_CHICKEN))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_ONION))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_GARLIC), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_GARLIC))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.FISH_SAUCE_BOTTLE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.FISH_SAUCE_BOTTLE.get()))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.SISIG.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.BULALO.get(), 4.0F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_RAW_BEEF),
                                Ingredient.fromTag(CommonTags.C_BONES),
                                Ingredient.fromTag(CommonTags.C_CROPS_ONION),
                                Ingredient.fromTag(CommonTags.C_CROPS_CABBAGE),
                                Ingredient.ofItems(ItemsRegistry.FISH_SAUCE_BOTTLE.get()),
                                Ingredient.fromTag(CommonTags.C_CROPS_LEMONGRASS)))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_RAW_BEEF), RecipeProvider.conditionsFromTag(CommonTags.C_RAW_BEEF))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_BONES), RecipeProvider.conditionsFromTag(CommonTags.C_BONES))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_ONION))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_CABBAGE), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_CABBAGE))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.FISH_SAUCE_BOTTLE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.FISH_SAUCE_BOTTLE.get()))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_LEMONGRASS))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.BULALO.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.ARROZ_CALDO.get(), 4.0F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_RAW_CHICKEN),
                                Ingredient.fromTag(CommonTags.C_GRAIN),
                                Ingredient.fromTag(CommonTags.C_VEGETABLES_GARLIC),
                                Ingredient.fromTag(CommonTags.C_VEGETABLES_GINGER),
                                Ingredient.fromTag(CommonTags.C_CROPS_LEMONGRASS),
                                Ingredient.ofItems(ItemsRegistry.FISH_SAUCE_BOTTLE.get())))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_RAW_CHICKEN), RecipeProvider.conditionsFromTag(CommonTags.C_RAW_CHICKEN))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_GRAIN), RecipeProvider.conditionsFromTag(CommonTags.C_GRAIN))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_GARLIC), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_GARLIC))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_GINGER), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_GINGER))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_LEMONGRASS), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_LEMONGRASS))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.FISH_SAUCE_BOTTLE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.FISH_SAUCE_BOTTLE.get()))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.ARROZ_CALDO.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.MECHADO.get(), 4.0F, 200,
                        List.of(Ingredient.fromTag(CommonTags.C_RAW_BEEF),
                                Ingredient.fromTag(CommonTags.C_CROPS_ONION),
                                Ingredient.fromTag(CommonTags.C_VEGETABLES_GARLIC),
                                Ingredient.fromTag(CommonTags.C_CROPS_TOMATO),
                                Ingredient.fromTag(CommonTags.C_VEGETABLES),
                                Ingredient.ofItems(ItemsRegistry.FISH_SAUCE_BOTTLE.get())))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_RAW_BEEF), RecipeProvider.conditionsFromTag(CommonTags.C_RAW_BEEF))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_ONION), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_ONION))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_GARLIC), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_GARLIC))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_TOMATO), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_TOMATO))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.FISH_SAUCE_BOTTLE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.FISH_SAUCE_BOTTLE.get()))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.MECHADO.get())));

        // ** SWEETS **
        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.LECHE_FLAN.get(), 4, 0.5F, 100,
                        List.of(Ingredient.fromTag(CommonTags.C_EGGS),
                                Ingredient.fromTag(CommonTags.C_EGGS),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.ofItems(ItemsRegistry.CONDENSED_MILK_BOTTLE.get())))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_EGGS), RecipeUtil.conditionsFromTagWithCount(2, CommonTags.C_EGGS))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.CONDENSED_MILK_BOTTLE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.CONDENSED_MILK_BOTTLE.get()))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.LECHE_FLAN.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.RAW_POLVORONE.get(), 4, 100,
                        List.of(Ingredient.fromTag(CommonTags.C_GRAIN),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.ofItems(ItemsRegistry.MILK_POWDER.get())))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_GRAIN), RecipeProvider.conditionsFromTag(CommonTags.C_GRAIN))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.MILK_POWDER.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.MILK_POWDER.get()))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.RAW_POLVORONE.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.RAW_POLVORONE_PINIPIG.get(), 4, 100,
                        List.of(Ingredient.fromTag(CommonTags.C_GRAIN),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.ofItems(ItemsRegistry.MILK_POWDER.get()),
                                Ingredient.fromTag(CommonTags.C_CROPS_RICE)))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_GRAIN), RecipeProvider.conditionsFromTag(CommonTags.C_GRAIN))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.MILK_POWDER.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.MILK_POWDER.get()))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_RICE), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_RICE))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.RAW_POLVORONE_PINIPIG.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.RAW_POLVORONE_UBE.get(), 4, 100,
                        List.of(Ingredient.fromTag(CommonTags.C_GRAIN),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.ofItems(ItemsRegistry.MILK_POWDER.get()),
                                Ingredient.fromTag(CommonTags.C_CROPS_UBE)))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_GRAIN), RecipeProvider.conditionsFromTag(CommonTags.C_GRAIN))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.MILK_POWDER.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.MILK_POWDER.get()))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_CROPS_UBE), RecipeProvider.conditionsFromTag(CommonTags.C_CROPS_UBE))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.RAW_POLVORONE_UBE.get())));

        CookingPotRecipeJsonBuilder.create(CookingPotRecipeCategory.MEALS, ItemsRegistry.RAW_POLVORONE_CC.get(), 4, 100,
                        List.of(Ingredient.fromTag(CommonTags.C_GRAIN),
                                Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.ofItems(ItemsRegistry.MILK_POWDER.get()),
                                Ingredient.ofItems(Items.COOKIE)))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_GRAIN), RecipeProvider.conditionsFromTag(CommonTags.C_GRAIN))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.MILK_POWDER.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.MILK_POWDER.get()))
                .criterion(RecipeProvider.hasItem(Items.COOKIE), RecipeProvider.conditionsFromItem(Items.COOKIE))
                .offerTo(exporter, suffix(RecipeProvider.getItemPath(ItemsRegistry.RAW_POLVORONE_CC.get())));
    }

    private static Identifier suffix(String string) {
        return new Identifier(UbesDelightMod.MOD_ID, string + "_from_cooking_pot");
    }
}
