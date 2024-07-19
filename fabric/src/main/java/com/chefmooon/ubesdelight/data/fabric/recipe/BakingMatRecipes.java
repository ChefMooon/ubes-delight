package com.chefmooon.ubesdelight.data.fabric.recipe;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.data.fabric.builder.BakingMatRecipeJsonBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class BakingMatRecipes {
    private static final Item WHEAT_DOUGH = ModItems.WHEAT_DOUGH.get();
    private static final Item RAW_PASTA = ModItems.RAW_PASTA.get();
    private static final Item SWEET_BERRY_COOKIE = ModItems.SWEET_BERRY_COOKIE.get();
    private static final Item HONEY_COOKIE = ModItems.HONEY_COOKIE.get();
    private static final Item PIE_CRUST = ModItems.PIE_CRUST.get();
    private static final Item APPLE_PIE = ModItems.APPLE_PIE.get();
    private static final Item SWEET_BERRY_CHEESECAKE = ModItems.SWEET_BERRY_CHEESECAKE.get();
    private static final Item CHOCOLATE_PIE = ModItems.CHOCOLATE_PIE.get();

    public static void reigster(Consumer<FinishedRecipe> exporter) {

        // run once then transfer to Fabric/Forge
        //registerAll(exporter);

    }

    private static void registerAll(Consumer<FinishedRecipe> exporter) {
        // Ube's Delight Recipe's
        // Ginger Cookie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(CommonTags.C_CROPS_GINGER), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.COOKIE_GINGER, 8
                )
                .addOutput(UbesDelightItemsImpl.COOKIE_GINGER, 4, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.COOKIE_GINGER));

        // Ube Cookie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(CommonTags.C_CROPS_UBE), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.COOKIE_UBE, 8
                )
                .addOutput(UbesDelightItemsImpl.COOKIE_UBE, 4, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.COOKIE_UBE));

        // Ube Cake
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.EGG), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(CommonTags.C_MILKS), Ingredient.of(CommonTags.C_CROPS_UBE), Ingredient.of(CommonTags.C_MILKS),
                                Ingredient.of(CommonTags.C_MILKS), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.UBE_CAKE
                )
                .addOutput(UbesDelightItemsImpl.UBE_CAKE, 1, 0.5f)
                .save(exporter, recipeName(UbesDelightItemsImpl.UBE_CAKE));

        // Polvorone
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE),
                                Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE)),
                        List.of(Ingredient.of(UbesDelightItemsImpl.POLVORONE_STAGE0),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_STAGE1),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_STAGE2)),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.POLVORONE, 4
                )
                .addOutput(UbesDelightItemsImpl.POLVORONE, 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.POLVORONE));

        // Polvorone Pinipig
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG),
                                Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG)),
                        List.of(Ingredient.of(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE0),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE1),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE2)),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.POLVORONE_PINIPIG, 4
                )
                .addOutput(UbesDelightItemsImpl.POLVORONE_PINIPIG, 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.POLVORONE_PINIPIG));

        // Polvorone Ube
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_UBE), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_UBE),
                                Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_UBE), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_UBE)),
                        List.of(Ingredient.of(UbesDelightItemsImpl.POLVORONE_UBE_STAGE0),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_UBE_STAGE1),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_UBE_STAGE2)),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.POLVORONE_UBE, 4
                )
                .addOutput(UbesDelightItemsImpl.POLVORONE_UBE, 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.POLVORONE_UBE));

        // Polvorone CC
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_CC), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_CC),
                                Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_CC), Ingredient.of(UbesDelightItemsImpl.RAW_POLVORONE_CC)),
                        List.of(Ingredient.of(UbesDelightItemsImpl.POLVORONE_CC_STAGE0),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_CC_STAGE1),
                                Ingredient.of(UbesDelightItemsImpl.POLVORONE_CC_STAGE2)),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.POLVORONE_CC, 4
                )
                .addOutput(UbesDelightItemsImpl.POLVORONE_CC, 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.POLVORONE_CC));

        // Pandesal
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(CommonTags.C_FOODS_DOUGHS), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(Items.BREAD)),
                        List.of(Ingredient.of(UbesDelightItemsImpl.PANDESAL_STAGE0),
                                Ingredient.of(UbesDelightItemsImpl.PANDESAL_STAGE1),
                                Ingredient.of(UbesDelightItemsImpl.PANDESAL_STAGE2)),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.PANDESAL_RAW, 4
                )
                .addOutput(UbesDelightItemsImpl.PANDESAL_RAW, 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.PANDESAL_RAW));

        // Pandesal Ube
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(CommonTags.C_FOODS_DOUGHS), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(Items.BREAD), Ingredient.of(CommonTags.C_CROPS_UBE)),
                        List.of(Ingredient.of(UbesDelightItemsImpl.PANDESAL_UBE_STAGE0),
                                Ingredient.of(UbesDelightItemsImpl.PANDESAL_UBE_STAGE1),
                                Ingredient.of(UbesDelightItemsImpl.PANDESAL_UBE_STAGE2)),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.PANDESAL_UBE_RAW, 4
                )
                .addOutput(UbesDelightItemsImpl.PANDESAL_UBE_RAW, 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.PANDESAL_UBE_RAW));

        // Ensaymada
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(CommonTags.C_FOODS_DOUGHS), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_MILKS)),
                        List.of(Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_STAGE0),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_STAGE1),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_STAGE2),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_STAGE3)),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.ENSAYMADA_RAW, 2
                )
                .addOutput(UbesDelightItemsImpl.ENSAYMADA_RAW, 1, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.ENSAYMADA_RAW));

        // Ensaymada Ube
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(CommonTags.C_FOODS_DOUGHS), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_MILKS), Ingredient.of(CommonTags.C_CROPS_UBE)),
                        List.of(Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE0),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE1),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE2),
                                Ingredient.of(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE3)),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.ENSAYMADA_UBE_RAW, 2
                )
                .addOutput(UbesDelightItemsImpl.ENSAYMADA_UBE_RAW, 1, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.ENSAYMADA_UBE_RAW));

        // Hopia
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(CommonTags.C_FOODS_DOUGHS), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(Items.COCOA_BEANS)),
                        List.of(Ingredient.of(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE0),
                                Ingredient.of(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE1),
                                Ingredient.of(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE2)),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.HOPIA_MUNGGO_RAW, 2
                )
                .addOutput(UbesDelightItemsImpl.HOPIA_MUNGGO_RAW, 1, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.HOPIA_MUNGGO_RAW));

        // Hopia Ube
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(CommonTags.C_FOODS_DOUGHS), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_CROPS_UBE)),
                        List.of(Ingredient.of(UbesDelightItemsImpl.HOPIA_UBE_STAGE0),
                                Ingredient.of(UbesDelightItemsImpl.HOPIA_UBE_STAGE1),
                                Ingredient.of(UbesDelightItemsImpl.HOPIA_UBE_STAGE2)),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        UbesDelightItemsImpl.HOPIA_UBE_RAW, 2
                )
                .addOutput(UbesDelightItemsImpl.HOPIA_UBE_RAW, 1, 0.25f)
                .save(exporter, recipeName(UbesDelightItemsImpl.HOPIA_UBE_RAW));

        // Vanilla Recipe's
        // Bread
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        Items.BREAD
                )
                .addOutput(Items.BREAD, 1, 0.2f)
                .save(exporter, recipeName(Items.BREAD));

        // Cookie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.COCOA_BEANS), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        Items.COOKIE, 8
                )
                .addOutput(Items.COOKIE, 4, 0.25f)
                .save(exporter, recipeName(Items.COOKIE) + suffix());

        // Pumpkin Pie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.PUMPKIN), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(Items.EGG)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        Items.PUMPKIN_PIE
                )
                .addOutput(Items.PUMPKIN_PIE, 1, 0.25f)
                .save(exporter, Items.PUMPKIN_PIE.toString() + suffix());

        // Cake
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.EGG), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(CommonTags.C_MILKS), Ingredient.of(Items.WHEAT), Ingredient.of(CommonTags.C_MILKS),
                                Ingredient.of(CommonTags.C_MILKS), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        Items.CAKE
                )
                .addOutput(Items.CAKE, 1, 0.5f)
                .save(exporter, Items.CAKE + suffix());

        // Farmer's Delight Recipe's

        // Wheat Dough (Egg)
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.EGG), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        WHEAT_DOUGH, 3
                )
                .addOutput(WHEAT_DOUGH, 1, 0.25f)
                .save(exporter, RecipeProvider.getConversionRecipeName(WHEAT_DOUGH, Items.EGG) + suffix());

        // Wheat Dough (Water Bucket)
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.WATER_BUCKET), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        WHEAT_DOUGH, 3
                )
                .addOutput(WHEAT_DOUGH, 1, 0.25f)
                .save(exporter, RecipeProvider.getConversionRecipeName(WHEAT_DOUGH, Items.WATER_BUCKET) + suffix());

        // Raw Pasta (Egg)
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.EGG), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        RAW_PASTA
                )
                .addOutput(RAW_PASTA, 1, 0.2f)
                .save(exporter, RecipeProvider.getConversionRecipeName(RAW_PASTA, Items.EGG) + suffix());

        // Raw Pasta (Water Bucket)
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.WATER_BUCKET), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT),
                                Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        RAW_PASTA, 2
                )
                .addOutput(RAW_PASTA, 1, 0.2f)
                .save(exporter, RecipeProvider.getConversionRecipeName(RAW_PASTA, Items.WATER_BUCKET) + suffix());

        // Sweet Berry Cookie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        SWEET_BERRY_COOKIE, 8
                )
                .addOutput(SWEET_BERRY_COOKIE, 4, 0.25f)
                .save(exporter, SWEET_BERRY_COOKIE.toString() + suffix());

        //Honey Cookie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.HONEY_BOTTLE), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        HONEY_COOKIE, 8
                )
                .addOutput(HONEY_COOKIE, 4, 0.25f)
                .save(exporter, HONEY_COOKIE.toString() + suffix());

        //Pie Crust
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(CommonTags.C_MILKS)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        PIE_CRUST
                )
                .addOutput(PIE_CRUST, 1, 0.25f)
                .save(exporter, PIE_CRUST.toString() + suffix());

        //Apple Pie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.APPLE), Ingredient.of(Items.APPLE), Ingredient.of(Items.APPLE),
                                Ingredient.of(Items.WHEAT), Ingredient.of(PIE_CRUST), Ingredient.of(Items.WHEAT),
                                Ingredient.of(Items.WHEAT), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        APPLE_PIE
                )
                .addOutput(APPLE_PIE, 1, 0.5f)
                .save(exporter, APPLE_PIE.toString() + suffix());

        //Sweet Berry Cheesecake
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.SWEET_BERRIES),
                                Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(PIE_CRUST), Ingredient.of(Items.SWEET_BERRIES),
                                Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(CommonTags.C_MILKS), Ingredient.of(CommonTags.C_MILKS)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        SWEET_BERRY_CHEESECAKE
                )
                .addOutput(SWEET_BERRY_CHEESECAKE, 1, 0.5f)
                .save(exporter, SWEET_BERRY_CHEESECAKE.toString() + suffix());

        //Chocolate Pie
        BakingMatRecipeJsonBuilder.create(
                        List.of(Ingredient.of(CommonTags.C_MILKS), Ingredient.of(CommonTags.C_MILKS), Ingredient.of(CommonTags.C_MILKS),
                                Ingredient.of(Items.COCOA_BEANS), Ingredient.of(PIE_CRUST), Ingredient.of(Items.COCOA_BEANS),
                                Ingredient.of(Items.COCOA_BEANS), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PINS),
                        CHOCOLATE_PIE
                )
                .addOutput(CHOCOLATE_PIE, 1, 0.5f)
                .save(exporter, CHOCOLATE_PIE.toString() + suffix());
    }

    private static ResourceLocation recipeName(Item item) {
        return suffix(RecipeProvider.getItemName(item));
    }
    
    private static ResourceLocation suffix(String string) {
        return TextUtils.res(string + suffix());
    }

    private static String suffix() {
        return "_from_baking_mat";
    }
}
