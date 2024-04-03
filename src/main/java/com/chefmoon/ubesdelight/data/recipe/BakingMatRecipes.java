package com.chefmoon.ubesdelight.data.recipe;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.data.builder.BakingMatRecipeJsonBuilder;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import com.chefmoon.ubesdelight.util.RecipeUtil;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.predicate.NumberRange;
import net.minecraft.recipe.Ingredient;

import java.util.List;
import java.util.function.Consumer;

public class BakingMatRecipes {

    public static void register(Consumer<RecipeJsonProvider> exporter) {

        //NOTE: Is NumberRange best for criterion with multiple items? Should there be multiple for a tag? Could also provide list of all ingredients in one condition
        //NOTE: does Criterion matter for this type of crafting block?

        // Farmer's Delight compatibility items
        Item WHEAT_DOUGH = com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry.WHEAT_DOUGH.get();
        Item RAW_PASTA = com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry.RAW_PASTA.get();
        Item SWEET_BERRY_COOKIE = com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry.SWEET_BERRY_COOKIE.get();
        Item HONEY_COOKIE = com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry.HONEY_COOKIE.get();
        Item PIE_CRUST = com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry.PIE_CRUST.get();
        Item APPLE_PIE = com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry.APPLE_PIE.get();
        Item SWEET_BERRY_CHEESECAKE = com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry.SWEET_BERRY_CHEESECAKE.get();
        Item CHOCOLATE_PIE = com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry.CHOCOLATE_PIE.get();

        // Ube's Delight Recipe's
        // Ginger Cookie
        BakingMatRecipeJsonBuilder.create(
                List.of(Ingredient.fromTag(CommonTags.C_VEGETABLES_GINGER), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.COOKIE_GINGER.get(), 8
                )
                .addOutput(ItemsRegistry.COOKIE_GINGER.get(), 4, 0.25f)
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(2), Items.WHEAT))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_GINGER), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_GINGER))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_ROLLING_PINS), RecipeProvider.conditionsFromTag(CommonTags.C_ROLLING_PINS))
                .offerTo(exporter, ItemsRegistry.COOKIE_GINGER.getId() + suffix());

        // Ube Cookie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.fromTag(CommonTags.C_VEGETABLES_UBE), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.COOKIE_UBE.get(), 8
                )
                .addOutput(ItemsRegistry.COOKIE_UBE.get(), 4, 0.25f)
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(2), Items.WHEAT))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_UBE), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_UBE))
                .offerTo(exporter, ItemsRegistry.COOKIE_UBE.getId() + suffix());

        // Ube Cake
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.EGG), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.fromTag(CommonTags.C_MILK), Ingredient.fromTag(CommonTags.C_VEGETABLES_UBE), Ingredient.fromTag(CommonTags.C_MILK),
                                Ingredient.fromTag(CommonTags.C_MILK), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.UBE_CAKE.get()
                )
                .addOutput(ItemsRegistry.UBE_CAKE.get(), 1, 0.5f)
                .criterion(RecipeProvider.hasItem(Items.EGG), RecipeProvider.conditionsFromItem(Items.EGG))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_MILK), RecipeProvider.conditionsFromTag(CommonTags.C_MILK))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_UBE), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_UBE))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(2), Items.WHEAT))
                .offerTo(exporter, ItemsRegistry.UBE_CAKE.getId() + suffix());

        // Polvorone
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE.get()), Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE.get()),
                                Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE.get()), Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE.get())),
                        List.of(Ingredient.ofItems(ItemsRegistry.POLVORONE_STAGE0.get()),
                                Ingredient.ofItems(ItemsRegistry.POLVORONE_STAGE1.get()),
                                Ingredient.ofItems(ItemsRegistry.POLVORONE_STAGE2.get())),
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.POLVORONE.get(), 4
                )
                .addOutput(ItemsRegistry.POLVORONE.get(), 2, 0.25f)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.RAW_POLVORONE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.RAW_POLVORONE.get()))
                .offerTo(exporter, ItemsRegistry.POLVORONE.getId() + suffix());

        // Polvorone Pinipig
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_PINIPIG.get()), Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_PINIPIG.get()),
                                Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_PINIPIG.get()), Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_PINIPIG.get())),
                        List.of(Ingredient.ofItems(ItemsRegistry.POLVORONE_PINIPIG_STAGE0.get()),
                                Ingredient.ofItems(ItemsRegistry.POLVORONE_PINIPIG_STAGE1.get()),
                                Ingredient.ofItems(ItemsRegistry.POLVORONE_PINIPIG_STAGE2.get())),
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.POLVORONE_PINIPIG.get(), 4
                )
                .addOutput(ItemsRegistry.POLVORONE_PINIPIG.get(), 2, 0.25f)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.RAW_POLVORONE_PINIPIG.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.RAW_POLVORONE_PINIPIG.get()))
                .offerTo(exporter, ItemsRegistry.POLVORONE_PINIPIG.getId() + suffix());

        // Polvorone Ube
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_UBE.get()), Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_UBE.get()),
                                Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_UBE.get()), Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_UBE.get())),
                        List.of(Ingredient.ofItems(ItemsRegistry.POLVORONE_UBE_STAGE0.get()),
                                Ingredient.ofItems(ItemsRegistry.POLVORONE_UBE_STAGE1.get()),
                                Ingredient.ofItems(ItemsRegistry.POLVORONE_UBE_STAGE2.get())),
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.POLVORONE_UBE.get(), 4
                )
                .addOutput(ItemsRegistry.POLVORONE_UBE.get(), 2, 0.25f)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.RAW_POLVORONE_UBE.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.RAW_POLVORONE_UBE.get()))
                .offerTo(exporter, ItemsRegistry.POLVORONE_UBE.getId() + suffix());

        // Polvorone CC
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_CC.get()), Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_CC.get()),
                                Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_CC.get()), Ingredient.ofItems(ItemsRegistry.RAW_POLVORONE_CC.get())),
                        List.of(Ingredient.ofItems(ItemsRegistry.POLVORONE_CC_STAGE0.get()),
                                Ingredient.ofItems(ItemsRegistry.POLVORONE_CC_STAGE1.get()),
                                Ingredient.ofItems(ItemsRegistry.POLVORONE_CC_STAGE2.get())),
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.POLVORONE_CC.get(), 4
                )
                .addOutput(ItemsRegistry.POLVORONE_CC.get(), 2, 0.25f)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.RAW_POLVORONE_CC.get()), RecipeProvider.conditionsFromItem(ItemsRegistry.RAW_POLVORONE_CC.get()))
                .offerTo(exporter, ItemsRegistry.POLVORONE_CC.getId() + suffix());

        // Pandesal
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.fromTag(CommonTags.C_DOUGH), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.ofItems(Items.BREAD)),
                        List.of(Ingredient.ofItems(ItemsRegistry.PANDESAL_STAGE0.get()),
                                Ingredient.ofItems(ItemsRegistry.PANDESAL_STAGE1.get()),
                                Ingredient.ofItems(ItemsRegistry.PANDESAL_STAGE2.get())),
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.PANDESAL_RAW.get(), 4
                )
                .addOutput(ItemsRegistry.PANDESAL_RAW.get(), 2, 0.25f)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_DOUGH), RecipeProvider.conditionsFromTag(CommonTags.C_DOUGH))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(Items.BREAD), RecipeProvider.conditionsFromItem(Items.BREAD))
                .offerTo(exporter, ItemsRegistry.PANDESAL_RAW.getId() + suffix());

        // Pandesal Ube
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.fromTag(CommonTags.C_DOUGH), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.ofItems(Items.BREAD), Ingredient.fromTag(CommonTags.C_VEGETABLES_UBE)),
                        List.of(Ingredient.ofItems(ItemsRegistry.PANDESAL_UBE_STAGE0.get()),
                                Ingredient.ofItems(ItemsRegistry.PANDESAL_UBE_STAGE1.get()),
                                Ingredient.ofItems(ItemsRegistry.PANDESAL_UBE_STAGE2.get())),
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.PANDESAL_UBE_RAW.get(), 4
                )
                .addOutput(ItemsRegistry.PANDESAL_UBE_RAW.get(), 2, 0.25f)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_DOUGH), RecipeProvider.conditionsFromTag(CommonTags.C_DOUGH))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(Items.BREAD), RecipeProvider.conditionsFromItem(Items.BREAD))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_UBE), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_UBE))
                .offerTo(exporter, ItemsRegistry.PANDESAL_UBE_RAW.getId() + suffix());

        // Ensaymada
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.fromTag(CommonTags.C_DOUGH), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.fromTag(CommonTags.C_MILK)),
                        List.of(Ingredient.ofItems(ItemsRegistry.ENSAYMADA_STAGE0.get()),
                                Ingredient.ofItems(ItemsRegistry.ENSAYMADA_STAGE1.get()),
                                Ingredient.ofItems(ItemsRegistry.ENSAYMADA_STAGE2.get()),
                                Ingredient.ofItems(ItemsRegistry.ENSAYMADA_STAGE3.get())),
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.ENSAYMADA_RAW.get(), 2
                )
                .addOutput(ItemsRegistry.ENSAYMADA_RAW.get(), 1, 0.25f)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_DOUGH), RecipeProvider.conditionsFromTag(CommonTags.C_DOUGH))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_MILK), RecipeProvider.conditionsFromTag(CommonTags.C_MILK))
                .offerTo(exporter, ItemsRegistry.ENSAYMADA_RAW.getId() + suffix());

        // Ensaymada Ube
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.fromTag(CommonTags.C_DOUGH), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.fromTag(CommonTags.C_MILK), Ingredient.fromTag(CommonTags.C_VEGETABLES_UBE)),
                        List.of(Ingredient.ofItems(ItemsRegistry.ENSAYMADA_UBE_STAGE0.get()),
                                Ingredient.ofItems(ItemsRegistry.ENSAYMADA_UBE_STAGE1.get()),
                                Ingredient.ofItems(ItemsRegistry.ENSAYMADA_UBE_STAGE2.get()),
                                Ingredient.ofItems(ItemsRegistry.ENSAYMADA_UBE_STAGE3.get())),
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.ENSAYMADA_UBE_RAW.get(), 2
                )
                .addOutput(ItemsRegistry.ENSAYMADA_UBE_RAW.get(), 1, 0.25f)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_DOUGH), RecipeProvider.conditionsFromTag(CommonTags.C_DOUGH))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_MILK), RecipeProvider.conditionsFromTag(CommonTags.C_MILK))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_UBE), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_UBE))
                .offerTo(exporter, ItemsRegistry.ENSAYMADA_UBE_RAW.getId() + suffix());

        // Hopia
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.fromTag(CommonTags.C_DOUGH), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.ofItems(Items.COCOA_BEANS)),
                        List.of(Ingredient.ofItems(ItemsRegistry.HOPIA_MUNGGO_STAGE0.get()),
                                Ingredient.ofItems(ItemsRegistry.HOPIA_MUNGGO_STAGE1.get()),
                                Ingredient.ofItems(ItemsRegistry.HOPIA_MUNGGO_STAGE2.get())),
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.HOPIA_MUNGGO_RAW.get(), 2
                )
                .addOutput(ItemsRegistry.HOPIA_MUNGGO_RAW.get(), 1, 0.25f)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_DOUGH), RecipeProvider.conditionsFromTag(CommonTags.C_DOUGH))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(Items.COCOA_BEANS), RecipeProvider.conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter, ItemsRegistry.HOPIA_MUNGGO_RAW.getId() + suffix());

        // Hopia Ube
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.fromTag(CommonTags.C_DOUGH), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.fromTag(CommonTags.C_VEGETABLES_UBE)),
                        List.of(Ingredient.ofItems(ItemsRegistry.HOPIA_UBE_STAGE0.get()),
                                Ingredient.ofItems(ItemsRegistry.HOPIA_UBE_STAGE1.get()),
                                Ingredient.ofItems(ItemsRegistry.HOPIA_UBE_STAGE2.get())),
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        ItemsRegistry.HOPIA_UBE_RAW.get(), 2
                )
                .addOutput(ItemsRegistry.HOPIA_UBE_RAW.get(), 1, 0.25f)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_DOUGH), RecipeProvider.conditionsFromTag(CommonTags.C_DOUGH))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_VEGETABLES_UBE), RecipeProvider.conditionsFromTag(CommonTags.C_VEGETABLES_UBE))
                .offerTo(exporter, ItemsRegistry.HOPIA_UBE_RAW.getId() + suffix());

        // Vanilla Recipe's
        // Bread
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        Items.BREAD
                )
                .addOutput(Items.BREAD, 1, 0.2f)
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(3), Items.WHEAT))
                .offerTo(exporter, Items.BREAD.toString() + suffix());

        // Cookie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.COCOA_BEANS), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        Items.COOKIE, 8
                )
                .addOutput(Items.COOKIE, 4, 0.25f)
                .criterion(RecipeProvider.hasItem(Items.COCOA_BEANS), RecipeProvider.conditionsFromItem(Items.COCOA_BEANS))
                //.criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(2), Items.WHEAT))
                .offerTo(exporter, RecipeProvider.getRecipeName(Items.COOKIE) + suffix());

        // Pumpkin Pie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.PUMPKIN), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.ofItems(Items.EGG)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        Items.PUMPKIN_PIE
                )
                .addOutput(Items.PUMPKIN_PIE, 1, 0.25f)
                .criterion(RecipeProvider.hasItem(Items.PUMPKIN), RecipeProvider.conditionsFromItem(Items.PUMPKIN))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(Items.EGG), RecipeProvider.conditionsFromItem(Items.EGG))
                .offerTo(exporter, Items.PUMPKIN_PIE.toString() + suffix());

        // Cake
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.EGG), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.fromTag(CommonTags.C_MILK), Ingredient.ofItems(Items.WHEAT), Ingredient.fromTag(CommonTags.C_MILK),
                                Ingredient.fromTag(CommonTags.C_MILK), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        Items.CAKE
                )
                .addOutput(Items.CAKE, 1, 0.5f)
                .criterion(RecipeProvider.hasItem(Items.EGG), RecipeProvider.conditionsFromItem(Items.EGG))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_MILK), RecipeProvider.conditionsFromTag(CommonTags.C_MILK))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(3), Items.WHEAT))
                .offerTo(exporter, Items.CAKE + suffix());

        // Farmer's Delight Recipe's

        // Wheat Dough (Egg)
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.EGG), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        WHEAT_DOUGH, 3
                )
                .addOutput(WHEAT_DOUGH, 1, 0.25f)
                .criterion(RecipeProvider.hasItem(Items.EGG), RecipeProvider.conditionsFromItem(Items.EGG))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(3), Items.WHEAT))
                .offerTo(exporter, RecipeProvider.convertBetween(WHEAT_DOUGH, Items.EGG) + suffix());

        // Wheat Dough (Water Bucket)
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.WATER_BUCKET), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        WHEAT_DOUGH, 3
                )
                .addOutput(WHEAT_DOUGH, 1, 0.25f)
                .criterion(RecipeProvider.hasItem(Items.WATER_BUCKET), RecipeProvider.conditionsFromItem(Items.WATER_BUCKET))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(3), Items.WHEAT))
                .offerTo(exporter, RecipeProvider.convertBetween(WHEAT_DOUGH, Items.WATER_BUCKET) + suffix());

        // Raw Pasta (Egg)
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.EGG), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        RAW_PASTA
                )
                .addOutput(RAW_PASTA, 1, 0.2f)
                .criterion(RecipeProvider.hasItem(Items.EGG), RecipeProvider.conditionsFromItem(Items.EGG))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(2), Items.WHEAT))
                .offerTo(exporter, RecipeProvider.convertBetween(RAW_PASTA, Items.EGG) + suffix());

        // Raw Pasta (Water Bucket)
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.WATER_BUCKET), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT),
                                Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        RAW_PASTA, 2
                )
                .addOutput(RAW_PASTA, 1, 0.2f)
                .criterion(RecipeProvider.hasItem(Items.WATER_BUCKET), RecipeProvider.conditionsFromItem(Items.WATER_BUCKET))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(2), Items.WHEAT))
                .offerTo(exporter, RecipeProvider.convertBetween(RAW_PASTA, Items.WATER_BUCKET) + suffix());

        // Sweet Berry Cookie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.SWEET_BERRIES), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        SWEET_BERRY_COOKIE, 8
                )
                .addOutput(SWEET_BERRY_COOKIE, 4, 0.25f)
                .criterion(RecipeProvider.hasItem(Items.SWEET_BERRIES), RecipeProvider.conditionsFromItem(Items.SWEET_BERRIES))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(2), Items.WHEAT))
                .offerTo(exporter, SWEET_BERRY_COOKIE.toString() + suffix());

        //Honey Cookie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.HONEY_BOTTLE), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        HONEY_COOKIE, 8
                )
                .addOutput(HONEY_COOKIE, 4, 0.25f)
                .criterion(RecipeProvider.hasItem(Items.HONEY_BOTTLE), RecipeProvider.conditionsFromItem(Items.HONEY_BOTTLE))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(2), Items.WHEAT))
                .offerTo(exporter, HONEY_COOKIE.toString() + suffix());

        //Pie Crust
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(Items.WHEAT), Ingredient.fromTag(CommonTags.C_MILK)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        PIE_CRUST
                )
                .addOutput(PIE_CRUST, 1, 0.25f)
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(3), Items.WHEAT))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_MILK), RecipeProvider.conditionsFromTag(CommonTags.C_MILK))
                .offerTo(exporter, PIE_CRUST.toString() + suffix());

        //Apple Pie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.APPLE), Ingredient.ofItems(Items.APPLE), Ingredient.ofItems(Items.APPLE),
                                Ingredient.ofItems(Items.WHEAT), Ingredient.ofItems(PIE_CRUST), Ingredient.ofItems(Items.WHEAT),
                                Ingredient.ofItems(Items.WHEAT), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        APPLE_PIE
                )
                .addOutput(APPLE_PIE, 1, 0.5f)
                .criterion(RecipeProvider.hasItem(Items.APPLE), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(3), Items.APPLE))
                .criterion(RecipeProvider.hasItem(Items.WHEAT), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(3), Items.WHEAT))
                .criterion(RecipeProvider.hasItem(PIE_CRUST), RecipeProvider.conditionsFromItem(PIE_CRUST))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .offerTo(exporter, APPLE_PIE.toString() + suffix());

        //Sweet Berry Cheesecake
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.ofItems(Items.SWEET_BERRIES), Ingredient.ofItems(Items.SWEET_BERRIES), Ingredient.ofItems(Items.SWEET_BERRIES),
                                Ingredient.ofItems(Items.SWEET_BERRIES), Ingredient.ofItems(PIE_CRUST), Ingredient.ofItems(Items.SWEET_BERRIES),
                                Ingredient.ofItems(Items.SWEET_BERRIES), Ingredient.fromTag(CommonTags.C_MILK), Ingredient.fromTag(CommonTags.C_MILK)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        SWEET_BERRY_CHEESECAKE
                )
                .addOutput(SWEET_BERRY_CHEESECAKE, 1, 0.5f)
                .criterion(RecipeProvider.hasItem(Items.SWEET_BERRIES), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(6), Items.SWEET_BERRIES))
                .criterion(RecipeProvider.hasItem(PIE_CRUST), RecipeProvider.conditionsFromItem(PIE_CRUST))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_MILK), RecipeProvider.conditionsFromTag(CommonTags.C_MILK))
                .offerTo(exporter, SWEET_BERRY_CHEESECAKE.toString() + suffix());

        //Chocolate Pie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.fromTag(CommonTags.C_MILK), Ingredient.fromTag(CommonTags.C_MILK), Ingredient.fromTag(CommonTags.C_MILK),
                                Ingredient.ofItems(Items.COCOA_BEANS), Ingredient.ofItems(PIE_CRUST), Ingredient.ofItems(Items.COCOA_BEANS),
                                Ingredient.ofItems(Items.COCOA_BEANS), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.fromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)),
                        null,
                        Ingredient.fromTag(CommonTags.C_ROLLING_PINS),
                        CHOCOLATE_PIE
                )
                .addOutput(CHOCOLATE_PIE, 1, 0.5f)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_MILK), RecipeProvider.conditionsFromTag(CommonTags.C_MILK))
                .criterion(RecipeProvider.hasItem(Items.COCOA_BEANS), RecipeProvider.conditionsFromItem(NumberRange.IntRange.atLeast(3), Items.COCOA_BEANS))
                .criterion(RecipeProvider.hasItem(PIE_CRUST), RecipeProvider.conditionsFromItem(PIE_CRUST))
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), RecipeProvider.conditionsFromTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))
                .offerTo(exporter, CHOCOLATE_PIE.toString() + suffix());
    }

    private static String suffix(String string) {
        return UbesDelightMod.MOD_ID + "/baking_mat/" + string + "_from_baking_mat";
    }

    private static String suffix() {
        return "_from_baking_mat";
    }
}
