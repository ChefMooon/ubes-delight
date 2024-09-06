package com.chefmooon.ubesdelight.data.fabric.recipe;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.tag.CompatibilityTags;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.common.utility.fabric.RecipeUtil;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import static com.chefmooon.ubesdelight.common.utility.fabric.RecipeUtil.simpleRecipeBuilder;

public class CraftingRecipes {
    public static void register(RecipeOutput exporter) {

        // todo - move uncommon here, organize them
        registerUncommon(exporter);

        simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.UBE_CRATE, 1,
                UbesDelightItemsImpl.UBE, 9);
        simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.GARLIC_CRATE, 1,
                UbesDelightItemsImpl.GARLIC, 9);
        simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.GINGER_CRATE, 1,
                UbesDelightItemsImpl.GINGER, 9);
        simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.LEMONGRASS_CRATE, 1,
                UbesDelightItemsImpl.LEMONGRASS, 9);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UbesDelightItemsImpl.BAKING_MAT_BAMBOO)
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.BAMBOO)
                .define('B', Items.HONEYCOMB)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(Items.BAMBOO, Items.HONEYCOMB))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.BAKING_MAT_BAMBOO)));

        /** ITEMS **/

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UbesDelightItemsImpl.ROLLING_PIN_WOOD)
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', ItemTags.FENCES)
                .unlockedBy(RecipeProvider.getHasName(Items.STICK), RecipeProvider.has(Items.STICK))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_WOOD)));

        /** CROPS **/

        // Seed from crop
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.MISC,
                UbesDelightItemsImpl.LEMONGRASS, 1,
                UbesDelightItemsImpl.LEMONGRASS_SEEDS, 1);

        // Partial to full Vegetables
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.GARLIC_CHOP, 2,
                UbesDelightItemsImpl.GARLIC, 1);

        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.GINGER_CHOP, 2,
                UbesDelightItemsImpl.GINGER, 1);

        /** FOODS **/

        // Cake Slices to Cake
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.UBE_CAKE_SLICE, 7,
                UbesDelightItemsImpl.UBE_CAKE, 1);

        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.LECHE_FLAN, 5,
                UbesDelightItemsImpl.LECHE_FLAN_FEAST, 1);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, UbesDelightItemsImpl.LUMPIA_FEAST)
                .pattern("   ")
                .pattern("AAA")
                .pattern("BBB")
                .define('A', UbesDelightItemsImpl.LUMPIA)
                .define('B', CompatibilityTags.MINECRAFT_LEAVES)
                .unlockedBy(RecipeUtil.hasAny(), RecipeProvider.has(UbesDelightItemsImpl.LUMPIA))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.LUMPIA_FEAST)));
    }

    private static void registerUncommon(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UbesDelightItemsImpl.KALAN)
                .pattern("AAA")
                .pattern("ACA")
                .pattern("ABA")
                .define('A', CompatibilityTags.MINECRAFT_TERRACOTTA)
                .define('B', Items.CAMPFIRE)
                .define('C', CommonTags.C_IRON_INGOTS)
                .unlockedBy(RecipeProvider.getHasName(Items.CAMPFIRE), RecipeProvider.has(Items.CAMPFIRE))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.KALAN)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, UbesDelightItemsImpl.COOKIE_GINGER, 8)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeUtil.hasAny(), RecipeProvider.has(UbesDelightItemsImpl.GINGER))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.COOKIE_GINGER)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, UbesDelightItemsImpl.COOKIE_UBE, 8)
                .requires(CommonTags.C_CROPS_UBE)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeUtil.hasAny(), RecipeProvider.has(UbesDelightItemsImpl.UBE))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.COOKIE_UBE)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, UbesDelightItemsImpl.KINILAW)
                .requires(CommonTags.C_FOODS_RAW_FISH)
                .requires(CommonTags.C_CROPS_ONION)
                .requires(CommonTags.C_CROPS_GARLIC)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(CommonTags.C_CROPS_LEMONGRASS)
                .requires(Items.BOWL)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(Items.BOWL, UbesDelightItemsImpl.GARLIC, UbesDelightItemsImpl.GINGER))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.KINILAW)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, UbesDelightItemsImpl.KINILAW)
                .requires(CompatibilityTags.MINECRAFT_FISHES)
                .requires(CommonTags.C_CROPS_ONION)
                .requires(CommonTags.C_CROPS_GARLIC)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(CommonTags.C_CROPS_LEMONGRASS)
                .requires(Items.BOWL)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(Items.BOWL, UbesDelightItemsImpl.GARLIC, UbesDelightItemsImpl.GINGER))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.KINILAW) + "_extra"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, UbesDelightItemsImpl.LUMPIA_WRAPPER, 32)
                .requires(CommonTags.C_CROPS_GRAIN)
                .requires(CommonTags.C_EGGS)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(Items.WATER_BUCKET, Items.EGG, Items.WHEAT))
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(UbesDelightItemsImpl.LUMPIA_WRAPPER,Items.WATER_BUCKET)));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, UbesDelightItemsImpl.HALO_HALO_FEAST)
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', UbesDelightItemsImpl.HALO_HALO)
                .define('B', CommonTags.C_FOODS_MILK)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(UbesDelightItemsImpl.HALO_HALO, UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE, Items.MILK_BUCKET))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.HALO_HALO_FEAST)));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, UbesDelightItemsImpl.MILK_TEA_UBE_FEAST)
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', UbesDelightItemsImpl.MILK_TEA_UBE)
                .define('B', CommonTags.C_FOODS_MILK)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(UbesDelightItemsImpl.MILK_TEA_UBE, UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE, Items.MILK_BUCKET))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST)));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, UbesDelightItemsImpl.UBE_CAKE)
                .pattern("AAA")
                .pattern("BEB")
                .pattern("CFC")
                .define('A', CommonTags.C_FOODS_MILK)
                .define('B', CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .define('C', Items.WHEAT)
                .define('E', CommonTags.C_EGGS)
                .define('F', CommonTags.C_CROPS_UBE)
                .unlockedBy(RecipeProvider.getHasName(Items.EGG), RecipeProvider.has(Items.EGG))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.UBE_CAKE)));
    }

    private static ResourceLocation suffix(String string) {
        return TextUtils.res("minecraft/crafting/" + string);
    }
}
