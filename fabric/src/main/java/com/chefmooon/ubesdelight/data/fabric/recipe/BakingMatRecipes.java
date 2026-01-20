package com.chefmooon.ubesdelight.data.fabric.recipe;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.data.fabric.builder.BakingMatRecipeJsonBuilder;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.registry.ModItems;

import static com.chefmooon.ubesdelight.common.utility.fabric.RecipeUtil.nonNullList;

public class BakingMatRecipes {
    private static final Item WHEAT_DOUGH = ModItems.WHEAT_DOUGH.get();
    private static final Item RAW_PASTA = ModItems.RAW_PASTA.get();
    private static final Item SWEET_BERRY_COOKIE = ModItems.SWEET_BERRY_COOKIE.get();
    private static final Item HONEY_COOKIE = ModItems.HONEY_COOKIE.get();
    private static final Item PIE_CRUST = ModItems.PIE_CRUST.get();
    private static final Item APPLE_PIE = ModItems.APPLE_PIE.get();
    private static final Item SWEET_BERRY_CHEESECAKE = ModItems.SWEET_BERRY_CHEESECAKE.get();
    private static final Item CHOCOLATE_PIE = ModItems.CHOCOLATE_PIE.get();

    public static void register(HolderGetter<Item> holderGetter, HolderLookup.Provider provider, RecipeOutput exporter) {
        registerAll(holderGetter, provider, exporter);

    }

    private static void registerAll(HolderGetter<Item> holderGetter, HolderLookup.Provider provider, RecipeOutput exporter) {
        // Ube's Delight Recipe's
        // Ginger Cookie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(holderGetter.getOrThrow(CommonTags.C_CROPS_GINGER)), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.COOKIE_GINGER.get(), 8
                )
                .addOutput(UbesDelightItemsImpl.COOKIE_GINGER.get(), 4, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.COOKIE_GINGER.get()));

        // Ube Cookie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(holderGetter.getOrThrow(CommonTags.C_CROPS_UBE)), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.COOKIE_UBE.get(), 8
                )
                .addOutput(UbesDelightItemsImpl.COOKIE_UBE.get(), 4, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.COOKIE_UBE.get()));

        // Ube Cake
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.EGG), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)),
                                Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_CROPS_UBE)), Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS)),
                                Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS)), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.UBE_CAKE.get()
                )
                .addOutput(UbesDelightItemsImpl.UBE_CAKE.get(), 1, 0.5f)
                .build(exporter, recipeName(UbesDelightItemsImpl.UBE_CAKE.get()));

        // Polvorone
        BakingMatRecipeJsonBuilder.create(
                        nonNullList(Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE.get()), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE.get()),
                                Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE.get()), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE.get())),
                        nonNullList(Ingredient.of(UbesDelightItemsImpl.POLVORONE_STAGE0.get()),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_STAGE1.get()),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_STAGE2.get())),
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.POLVORONE.get(), 4
                )
                .addOutput(UbesDelightItemsImpl.POLVORONE.get(), 2, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.POLVORONE.get()));

        // Polvorone Pinipig
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG.get()), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG.get()),
                                Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG.get()), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG.get())),
                        nonNullList(Ingredient.of(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE0.get()),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE1.get()),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE2.get())),
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.POLVORONE_PINIPIG.get(), 4
                )
                .addOutput(UbesDelightItemsImpl.POLVORONE_PINIPIG.get(), 2, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.POLVORONE_PINIPIG.get()));

        // Polvorone Ube
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_UBE.get()), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_UBE.get()),
                                Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_UBE.get()), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_UBE.get())),
                        nonNullList(Ingredient.of(UbesDelightItemsImpl.POLVORONE_UBE_STAGE0.get()),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_UBE_STAGE1.get()),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_UBE_STAGE2.get())),
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.POLVORONE_UBE.get(), 4
                )
                .addOutput(UbesDelightItemsImpl.POLVORONE_UBE.get(), 2, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.POLVORONE_UBE.get()));

        // Polvorone CC
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_CC.get()), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_CC.get()),
                                Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_CC.get()), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_CC.get())),
                        nonNullList(Ingredient.of(UbesDelightItemsImpl.POLVORONE_CC_STAGE0.get()),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_CC_STAGE1.get()),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_CC_STAGE2.get())),
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.POLVORONE_CC.get(), 4
                )
                .addOutput(UbesDelightItemsImpl.POLVORONE_CC.get(), 2, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.POLVORONE_CC.get()));

        // Pandesal
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(holderGetter.getOrThrow(CommonTags.C_FOODS_DOUGH)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), Ingredient.of(Items.BREAD)),
                        nonNullList(Ingredient.of(UbesDelightItemsImpl.PANDESAL_STAGE0.get()),
                                Ingredient.of(UbesDelightItemsImpl.PANDESAL_STAGE1.get()),
                                Ingredient.of(UbesDelightItemsImpl.PANDESAL_STAGE2.get())),
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.PANDESAL_RAW.get(), 4
                )
                .addOutput(UbesDelightItemsImpl.PANDESAL_RAW.get(), 2, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.PANDESAL_RAW.get()));

        // Pandesal Ube
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(holderGetter.getOrThrow(CommonTags.C_FOODS_DOUGH)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), Ingredient.of(Items.BREAD), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_CROPS_UBE))),
                        nonNullList(Ingredient.of(UbesDelightItemsImpl.PANDESAL_UBE_STAGE0.get()),
                                Ingredient.of(UbesDelightItemsImpl.PANDESAL_UBE_STAGE1.get()),
                                Ingredient.of(UbesDelightItemsImpl.PANDESAL_UBE_STAGE2.get())),
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.PANDESAL_UBE_RAW.get(), 4
                )
                .addOutput(UbesDelightItemsImpl.PANDESAL_UBE_RAW.get(), 2, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.PANDESAL_UBE_RAW.get()));

        // Ensaymada
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(holderGetter.getOrThrow(CommonTags.C_FOODS_DOUGH)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS))),
                        nonNullList(Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_STAGE0.get()),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_STAGE1.get()),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_STAGE2.get()),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_STAGE3.get())),
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.ENSAYMADA_RAW.get(), 2
                )
                .addOutput(UbesDelightItemsImpl.ENSAYMADA_RAW.get(), 1, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.ENSAYMADA_RAW.get()));

        // Ensaymada Ube
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(holderGetter.getOrThrow(CommonTags.C_FOODS_DOUGH)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_CROPS_UBE))),
                        nonNullList(Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE0.get()),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE1.get()),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE2.get()),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE3.get())),
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.ENSAYMADA_UBE_RAW.get(), 2
                )
                .addOutput(UbesDelightItemsImpl.ENSAYMADA_UBE_RAW.get(), 1, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.ENSAYMADA_UBE_RAW.get()));

        // Hopia
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(holderGetter.getOrThrow(CommonTags.C_FOODS_DOUGH)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), Ingredient.of(Items.COCOA_BEANS)),
                        nonNullList(Ingredient.of(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE0.get()),
                                Ingredient.of(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE1.get()),
                                Ingredient.of(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE2.get())),
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.HOPIA_MUNGGO_RAW.get(), 2
                )
                .addOutput(UbesDelightItemsImpl.HOPIA_MUNGGO_RAW.get(), 1, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.HOPIA_MUNGGO_RAW.get()));

        // Hopia Ube
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(holderGetter.getOrThrow(CommonTags.C_FOODS_DOUGH)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_CROPS_UBE))),
                        nonNullList(Ingredient.of(UbesDelightItemsImpl.HOPIA_UBE_STAGE0.get()),
                                Ingredient.of(UbesDelightItemsImpl.HOPIA_UBE_STAGE1.get()),
                                Ingredient.of(UbesDelightItemsImpl.HOPIA_UBE_STAGE2.get())),
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        UbesDelightItemsImpl.HOPIA_UBE_RAW.get(), 2
                )
                .addOutput(UbesDelightItemsImpl.HOPIA_UBE_RAW.get(), 1, 0.25f)
                .build(exporter, recipeName(UbesDelightItemsImpl.HOPIA_UBE_RAW.get()));

        // Vanilla Recipe's
        // Bread
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        Items.BREAD
                )
                .addOutput(Items.BREAD, 1, 0.2f)
                .build(exporter, recipeName(Items.BREAD));

        // Cookie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.COCOA_BEANS), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        Items.COOKIE, 8
                )
                .addOutput(Items.COOKIE, 4, 0.25f)
                .build(exporter, recipeName(Items.COOKIE) + suffix());

        // Pumpkin Pie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.PUMPKIN), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), Ingredient.of(Items.EGG)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        Items.PUMPKIN_PIE
                )
                .addOutput(Items.PUMPKIN_PIE, 1, 0.25f)
                .build(exporter, RecipeProvider.getItemName(Items.PUMPKIN_PIE) + suffix());

        // Cake
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.EGG), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)),
                                Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS)), Ingredient.of(Items.WHEAT), Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS)),
                                Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS)), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        Items.CAKE
                )
                .addOutput(Items.CAKE, 1, 0.5f)
                .build(exporter, RecipeProvider.getItemName(Items.CAKE) + suffix());

        // Farmer's Delight Recipe's

        // Wheat Dough (Egg)
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.EGG), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        WHEAT_DOUGH, 3
                )
                .addOutput(WHEAT_DOUGH, 1, 0.25f)
                .build(exporter, RecipeProvider.getConversionRecipeName(WHEAT_DOUGH, Items.EGG) + suffix());

        // Wheat Dough (Water Bucket)
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.WATER_BUCKET), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        WHEAT_DOUGH, 3
                )
                .addOutput(WHEAT_DOUGH, 1, 0.25f)
                .build(exporter, RecipeProvider.getConversionRecipeName(WHEAT_DOUGH, Items.WATER_BUCKET) + suffix());

        // Raw Pasta (Egg)
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.EGG), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        RAW_PASTA
                )
                .addOutput(RAW_PASTA, 1, 0.2f)
                .build(exporter, RecipeProvider.getConversionRecipeName(RAW_PASTA, Items.EGG) + suffix());

        // Raw Pasta (Water Bucket)
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.WATER_BUCKET), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT),
                                Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        RAW_PASTA, 2
                )
                .addOutput(RAW_PASTA, 1, 0.2f)
                .build(exporter, RecipeProvider.getConversionRecipeName(RAW_PASTA, Items.WATER_BUCKET) + suffix());

        // Sweet Berry Cookie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        SWEET_BERRY_COOKIE, 8
                )
                .addOutput(SWEET_BERRY_COOKIE, 4, 0.25f)
                .build(exporter, RecipeProvider.getItemName(SWEET_BERRY_COOKIE) + suffix());

        //Honey Cookie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.HONEY_BOTTLE), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        HONEY_COOKIE, 8
                )
                .addOutput(HONEY_COOKIE, 4, 0.25f)
                .build(exporter, RecipeProvider.getItemName(HONEY_COOKIE) + suffix());

        //Pie Crust
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS))),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        PIE_CRUST
                )
                .addOutput(PIE_CRUST, 1, 0.25f)
                .build(exporter, RecipeProvider.getItemName(PIE_CRUST) + suffix());

        //Apple Pie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.APPLE), Ingredient.of(Items.APPLE), Ingredient.of(Items.APPLE),
                                Ingredient.of(Items.WHEAT), Ingredient.of(PIE_CRUST), Ingredient.of(Items.WHEAT),
                                Ingredient.of(Items.WHEAT), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        APPLE_PIE
                )
                .addOutput(APPLE_PIE, 1, 0.5f)
                .build(exporter, RecipeProvider.getItemName(APPLE_PIE) + suffix());

        //Sweet Berry Cheesecake
        BakingMatRecipeJsonBuilder.create(
                        nonNullList(Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.SWEET_BERRIES),
                                Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(PIE_CRUST), Ingredient.of(Items.SWEET_BERRIES),
                                Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS)), Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS))),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        SWEET_BERRY_CHEESECAKE
                )
                .addOutput(SWEET_BERRY_CHEESECAKE, 1, 0.5f)
                .build(exporter, RecipeProvider.getItemName(SWEET_BERRY_CHEESECAKE) + suffix());

        //Chocolate Pie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS)), Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS)), Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.MILK_DRINKS)),
                                Ingredient.of(Items.COCOA_BEANS), Ingredient.of(PIE_CRUST), Ingredient.of(Items.COCOA_BEANS),
                                Ingredient.of(Items.COCOA_BEANS), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK))),
                        null,
                        Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_ROLLING_PIN)),
                        CHOCOLATE_PIE
                )
                .addOutput(CHOCOLATE_PIE, 1, 0.5f)
                .build(exporter, RecipeProvider.getItemName(CHOCOLATE_PIE) + suffix());
    }

    private static String recipeName(Item item) {
        return RecipeProvider.getItemName(item) + suffix();
    }

    private static Identifier suffix(String string) {
        return TextUtils.res(string + suffix());
    }

    private static String suffix() {
        return "_from_baking_mat";
    }
}
