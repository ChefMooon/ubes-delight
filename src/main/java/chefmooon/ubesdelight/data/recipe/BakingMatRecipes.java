package chefmooon.ubesdelight.data.recipe;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.utility.TextUtils;
import chefmooon.ubesdelight.data.UDRecipes;
import chefmooon.ubesdelight.data.builder.BakingMatRecipeJsonBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.concurrent.CompletableFuture;

import static chefmooon.ubesdelight.common.utility.RecipeUtil.nonNullList;

public class BakingMatRecipes extends UDRecipes {
    private static final Item WHEAT_DOUGH = ModItems.WHEAT_DOUGH.get();
    private static final Item RAW_PASTA = ModItems.RAW_PASTA.get();
    private static final Item SWEET_BERRY_COOKIE = ModItems.SWEET_BERRY_COOKIE.get();
    private static final Item HONEY_COOKIE = ModItems.HONEY_COOKIE.get();
    private static final Item PIE_CRUST = ModItems.PIE_CRUST.get();
    private static final Item APPLE_PIE = ModItems.APPLE_PIE.get();
    private static final Item SWEET_BERRY_CHEESECAKE = ModItems.SWEET_BERRY_CHEESECAKE.get();
    private static final Item CHOCOLATE_PIE = ModItems.CHOCOLATE_PIE.get();

    public BakingMatRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static void register(RecipeOutput exporter) {
        registerAll(exporter);

    }

    private static void registerAll(RecipeOutput exporter) {
        // Ube's Delight Recipe's
        // Ginger Cookie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(CommonTags.C_CROPS_GINGER), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.COOKIE_GINGER.get(), 8
                )
                .addOutput(UbesDelightItems.COOKIE_GINGER.get(), 4, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.COOKIE_GINGER.get()));

        // Ube Cookie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(CommonTags.C_CROPS_UBE), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.COOKIE_UBE.get(), 8
                )
                .addOutput(UbesDelightItems.COOKIE_UBE.get(), 4, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.COOKIE_UBE.get()));

        // Ube Cake
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.EGG), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(Tags.Items.DRINKS_MILK), Ingredient.of(CommonTags.C_CROPS_UBE), Ingredient.of(Tags.Items.DRINKS_MILK),
                                Ingredient.of(Tags.Items.DRINKS_MILK), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.UBE_CAKE.get()
                )
                .addOutput(UbesDelightItems.UBE_CAKE.get(), 1, 0.5f)
                .save(exporter, recipeName(UbesDelightItems.UBE_CAKE.get()));

        // Polvorone
        BakingMatRecipeJsonBuilder.create(
                        nonNullList(Ingredient.of(UbesDelightItems.RAW_POLVORONE.get()), Ingredient.of(UbesDelightItems.RAW_POLVORONE.get()),
                                Ingredient.of(UbesDelightItems.RAW_POLVORONE.get()), Ingredient.of(UbesDelightItems.RAW_POLVORONE.get())),
                        nonNullList(Ingredient.of(UbesDelightItems.POLVORONE_STAGE0.get()),
                                Ingredient.of(UbesDelightItems.POLVORONE_STAGE1.get()),
                                Ingredient.of(UbesDelightItems.POLVORONE_STAGE2.get())),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.POLVORONE.get(), 4
                )
                .addOutput(UbesDelightItems.POLVORONE.get(), 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.POLVORONE.get()));

        // Polvorone Pinipig
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(UbesDelightItems.RAW_POLVORONE_PINIPIG.get()), Ingredient.of(UbesDelightItems.RAW_POLVORONE_PINIPIG.get()),
                                Ingredient.of(UbesDelightItems.RAW_POLVORONE_PINIPIG.get()), Ingredient.of(UbesDelightItems.RAW_POLVORONE_PINIPIG.get())),
                        nonNullList(Ingredient.of(UbesDelightItems.POLVORONE_PINIPIG_STAGE0.get()),
                                Ingredient.of(UbesDelightItems.POLVORONE_PINIPIG_STAGE1.get()),
                                Ingredient.of(UbesDelightItems.POLVORONE_PINIPIG_STAGE2.get())),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.POLVORONE_PINIPIG.get(), 4
                )
                .addOutput(UbesDelightItems.POLVORONE_PINIPIG.get(), 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.POLVORONE_PINIPIG.get()));

        // Polvorone Ube
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(UbesDelightItems.RAW_POLVORONE_UBE.get()), Ingredient.of(UbesDelightItems.RAW_POLVORONE_UBE.get()),
                                Ingredient.of(UbesDelightItems.RAW_POLVORONE_UBE.get()), Ingredient.of(UbesDelightItems.RAW_POLVORONE_UBE.get())),
                        nonNullList(Ingredient.of(UbesDelightItems.POLVORONE_UBE_STAGE0.get()),
                                Ingredient.of(UbesDelightItems.POLVORONE_UBE_STAGE1.get()),
                                Ingredient.of(UbesDelightItems.POLVORONE_UBE_STAGE2.get())),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.POLVORONE_UBE.get(), 4
                )
                .addOutput(UbesDelightItems.POLVORONE_UBE.get(), 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.POLVORONE_UBE.get()));

        // Polvorone CC
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(UbesDelightItems.RAW_POLVORONE_CC.get()), Ingredient.of(UbesDelightItems.RAW_POLVORONE_CC.get()),
                                Ingredient.of(UbesDelightItems.RAW_POLVORONE_CC.get()), Ingredient.of(UbesDelightItems.RAW_POLVORONE_CC.get())),
                        nonNullList(Ingredient.of(UbesDelightItems.POLVORONE_CC_STAGE0.get()),
                                Ingredient.of(UbesDelightItems.POLVORONE_CC_STAGE1.get()),
                                Ingredient.of(UbesDelightItems.POLVORONE_CC_STAGE2.get())),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.POLVORONE_CC.get(), 4
                )
                .addOutput(UbesDelightItems.POLVORONE_CC.get(), 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.POLVORONE_CC.get()));

        // Pandesal
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(CommonTags.C_FOODS_DOUGH), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(Items.BREAD)),
                        nonNullList(Ingredient.of(UbesDelightItems.PANDESAL_STAGE0.get()),
                                Ingredient.of(UbesDelightItems.PANDESAL_STAGE1.get()),
                                Ingredient.of(UbesDelightItems.PANDESAL_STAGE2.get())),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.PANDESAL_RAW.get(), 4
                )
                .addOutput(UbesDelightItems.PANDESAL_RAW.get(), 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.PANDESAL_RAW.get()));

        // Pandesal Ube
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(CommonTags.C_FOODS_DOUGH), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(Items.BREAD), Ingredient.of(CommonTags.C_CROPS_UBE)),
                        nonNullList(Ingredient.of(UbesDelightItems.PANDESAL_UBE_STAGE0.get()),
                                Ingredient.of(UbesDelightItems.PANDESAL_UBE_STAGE1.get()),
                                Ingredient.of(UbesDelightItems.PANDESAL_UBE_STAGE2.get())),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.PANDESAL_UBE_RAW.get(), 4
                )
                .addOutput(UbesDelightItems.PANDESAL_UBE_RAW.get(), 2, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.PANDESAL_UBE_RAW.get()));

        // Ensaymada
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(CommonTags.C_FOODS_DOUGH), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(Tags.Items.DRINKS_MILK)),
                        nonNullList(Ingredient.of(UbesDelightItems.ENSAYMADA_STAGE0.get()),
                                Ingredient.of(UbesDelightItems.ENSAYMADA_STAGE1.get()),
                                Ingredient.of(UbesDelightItems.ENSAYMADA_STAGE2.get()),
                                Ingredient.of(UbesDelightItems.ENSAYMADA_STAGE3.get())),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.ENSAYMADA_RAW.get(), 2
                )
                .addOutput(UbesDelightItems.ENSAYMADA_RAW.get(), 1, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.ENSAYMADA_RAW.get()));

        // Ensaymada Ube
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(CommonTags.C_FOODS_DOUGH), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(Tags.Items.DRINKS_MILK), Ingredient.of(CommonTags.C_CROPS_UBE)),
                        nonNullList(Ingredient.of(UbesDelightItems.ENSAYMADA_UBE_STAGE0.get()),
                                Ingredient.of(UbesDelightItems.ENSAYMADA_UBE_STAGE1.get()),
                                Ingredient.of(UbesDelightItems.ENSAYMADA_UBE_STAGE2.get()),
                                Ingredient.of(UbesDelightItems.ENSAYMADA_UBE_STAGE3.get())),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.ENSAYMADA_UBE_RAW.get(), 2
                )
                .addOutput(UbesDelightItems.ENSAYMADA_UBE_RAW.get(), 1, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.ENSAYMADA_UBE_RAW.get()));

        // Hopia
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(CommonTags.C_FOODS_DOUGH), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(Items.COCOA_BEANS)),
                        nonNullList(Ingredient.of(UbesDelightItems.HOPIA_MUNGGO_STAGE0.get()),
                                Ingredient.of(UbesDelightItems.HOPIA_MUNGGO_STAGE1.get()),
                                Ingredient.of(UbesDelightItems.HOPIA_MUNGGO_STAGE2.get())),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.HOPIA_MUNGGO_RAW.get(), 2
                )
                .addOutput(UbesDelightItems.HOPIA_MUNGGO_RAW.get(), 1, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.HOPIA_MUNGGO_RAW.get()));

        // Hopia Ube
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(CommonTags.C_FOODS_DOUGH), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_CROPS_UBE)),
                        nonNullList(Ingredient.of(UbesDelightItems.HOPIA_UBE_STAGE0.get()),
                                Ingredient.of(UbesDelightItems.HOPIA_UBE_STAGE1.get()),
                                Ingredient.of(UbesDelightItems.HOPIA_UBE_STAGE2.get())),
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        UbesDelightItems.HOPIA_UBE_RAW.get(), 2
                )
                .addOutput(UbesDelightItems.HOPIA_UBE_RAW.get(), 1, 0.25f)
                .save(exporter, recipeName(UbesDelightItems.HOPIA_UBE_RAW.get()));

        // Vanilla Recipe's
        // Bread
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        Items.BREAD
                )
                .addOutput(Items.BREAD, 1, 0.2f)
                .save(exporter, recipeName(Items.BREAD));

        // Cookie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.COCOA_BEANS), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        Items.COOKIE, 8
                )
                .addOutput(Items.COOKIE, 4, 0.25f)
                .save(exporter, recipeName(Items.COOKIE) + suffix());

        // Pumpkin Pie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.PUMPKIN), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(Items.EGG)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        Items.PUMPKIN_PIE
                )
                .addOutput(Items.PUMPKIN_PIE, 1, 0.25f)
                .save(exporter, TextUtils.res(formatVanillaItem(Items.PUMPKIN_PIE) + suffix()));

        // Cake
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.EGG), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK),
                                Ingredient.of(Tags.Items.DRINKS_MILK), Ingredient.of(Items.WHEAT), Ingredient.of(Tags.Items.DRINKS_MILK),
                                Ingredient.of(Tags.Items.DRINKS_MILK), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        Items.CAKE
                )
                .addOutput(Items.CAKE, 1, 0.5f)
                .save(exporter, TextUtils.res(formatVanillaItem(Items.CAKE) + suffix()));

        // Farmer's Delight Recipe's

        // Wheat Dough (Egg)
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.EGG), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        WHEAT_DOUGH, 3
                )
                .addOutput(WHEAT_DOUGH, 1, 0.25f)
                .save(exporter, TextUtils.res(formatFDItem(WHEAT_DOUGH) + "_from_" + RecipeProvider.getItemName(Items.EGG) + suffix()));

        // Wheat Dough (Water Bucket)
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.WATER_BUCKET), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        WHEAT_DOUGH, 3
                )
                .addOutput(WHEAT_DOUGH, 1, 0.25f)
                .save(exporter, TextUtils.res(formatFDItem(WHEAT_DOUGH) + "_from_" + RecipeProvider.getItemName(Items.WATER_BUCKET) + suffix()));

        // Raw Pasta (Egg)
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.EGG), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        RAW_PASTA
                )
                .addOutput(RAW_PASTA, 1, 0.2f)
                .save(exporter, TextUtils.res(formatFDItem(RAW_PASTA) + "_from_" + RecipeProvider.getItemName(Items.EGG) + suffix()));

        // Raw Pasta (Water Bucket)
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.WATER_BUCKET), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT),
                                Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        RAW_PASTA, 2
                )
                .addOutput(RAW_PASTA, 1, 0.2f)
                .save(exporter, TextUtils.res(formatFDItem(RAW_PASTA) + "_from_" + RecipeProvider.getItemName(Items.WATER_BUCKET) + suffix()));

        // Sweet Berry Cookie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        SWEET_BERRY_COOKIE, 8
                )
                .addOutput(SWEET_BERRY_COOKIE, 4, 0.25f)
                .save(exporter, TextUtils.res(formatFDItem(SWEET_BERRY_COOKIE) + suffix()));

        //Honey Cookie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.HONEY_BOTTLE), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        HONEY_COOKIE, 8
                )
                .addOutput(HONEY_COOKIE, 4, 0.25f)
                .save(exporter, TextUtils.res(formatFDItem(HONEY_COOKIE) + suffix()));

        //Pie Crust
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Items.WHEAT), Ingredient.of(Tags.Items.DRINKS_MILK)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        PIE_CRUST
                )
                .addOutput(PIE_CRUST, 1, 0.25f)
                .save(exporter, TextUtils.res(formatFDItem(PIE_CRUST) + suffix()));

        //Apple Pie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Items.APPLE), Ingredient.of(Items.APPLE), Ingredient.of(Items.APPLE),
                                Ingredient.of(Items.WHEAT), Ingredient.of(PIE_CRUST), Ingredient.of(Items.WHEAT),
                                Ingredient.of(Items.WHEAT), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        APPLE_PIE
                )
                .addOutput(APPLE_PIE, 1, 0.5f)
                .save(exporter, TextUtils.res(formatFDItem(APPLE_PIE) + suffix()));

        //Sweet Berry Cheesecake
        BakingMatRecipeJsonBuilder.create(
                        nonNullList(Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Items.SWEET_BERRIES),
                                Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(PIE_CRUST), Ingredient.of(Items.SWEET_BERRIES),
                                Ingredient.of(Items.SWEET_BERRIES), Ingredient.of(Tags.Items.DRINKS_MILK), Ingredient.of(Tags.Items.DRINKS_MILK)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        SWEET_BERRY_CHEESECAKE
                )
                .addOutput(SWEET_BERRY_CHEESECAKE, 1, 0.5f)
                .save(exporter, TextUtils.res(formatFDItem(SWEET_BERRY_CHEESECAKE) + suffix()));

        //Chocolate Pie
        BakingMatRecipeJsonBuilder.create(
                nonNullList(Ingredient.of(Tags.Items.DRINKS_MILK), Ingredient.of(Tags.Items.DRINKS_MILK), Ingredient.of(Tags.Items.DRINKS_MILK),
                                Ingredient.of(Items.COCOA_BEANS), Ingredient.of(PIE_CRUST), Ingredient.of(Items.COCOA_BEANS),
                                Ingredient.of(Items.COCOA_BEANS), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), Ingredient.of(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)),
                        null,
                        Ingredient.of(CommonTags.C_TOOLS_ROLLING_PIN),
                        CHOCOLATE_PIE
                )
                .addOutput(CHOCOLATE_PIE, 1, 0.5f)
                .save(exporter, TextUtils.res(formatFDItem(CHOCOLATE_PIE) + suffix()));
    }

    private static String formatVanillaItem(Item item) {
        return item.getDescriptionId().replace("block.minecraft.", "").replace("item.minecraft.", "");
    }

    private static String formatFDItem(Item item) {
        return item.getDescriptionId().replace("block.farmersdelight.", "").replace("item.farmersdelight.", "");
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
