package com.chefmooon.ubesdelight.data.fabric.recipe;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.tag.CompatibilityTags;
import com.chefmooon.ubesdelight.common.utility.fabric.RecipeUtil;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.registry.ModItems;

import static com.chefmooon.ubesdelight.common.utility.fabric.RecipeUtil.simpleRecipeBuilder;

public class CraftingRecipes {
    private static RecipeOutput EXPORTER;
    public static void register(HolderGetter<Item> holderGetter, HolderLookup.Provider provider, RecipeOutput exporter) {
        EXPORTER = exporter;
        // todo - move uncommon here, organize them
        registerUncommon(holderGetter, exporter);

        /** MISC BLOCKS **/

        simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.UBE_CRATE.get(), 1,
                UbesDelightItemsImpl.UBE.get(), 9);
        simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.GARLIC_CRATE.get(), 1,
                UbesDelightItemsImpl.GARLIC.get(), 9);
        simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.GINGER_CRATE.get(), 1,
                UbesDelightItemsImpl.GINGER.get(), 9);
        simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.LEMONGRASS_CRATE.get(), 1,
                UbesDelightItemsImpl.LEMONGRASS.get(), 9);

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.MISC, UbesDelightItemsImpl.BAKING_MAT_BAMBOO.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.BAMBOO)
                .define('B', Items.HONEYCOMB)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, Items.BAMBOO, Items.HONEYCOMB))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.BAKING_MAT_BAMBOO.get())));

        /** ITEMS **/

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.TOOLS, UbesDelightItemsImpl.ROLLING_PIN_WOOD.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', ItemTags.FENCES)
                .unlockedBy(RecipeProvider.getHasName(Items.STICK), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_WOOD.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.TOOLS, UbesDelightItemsImpl.ROLLING_PIN_IRON.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', CommonTags.C_INGOTS_IRON)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_INGOTS_IRON), RecipeUtil.has(holderGetter, CommonTags.C_INGOTS_IRON))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_IRON.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.TOOLS, UbesDelightItemsImpl.ROLLING_PIN_GOLD.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', CommonTags.C_INGOTS_GOLD)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_INGOTS_GOLD), RecipeUtil.has(holderGetter, CommonTags.C_INGOTS_GOLD))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_GOLD.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.TOOLS, UbesDelightItemsImpl.ROLLING_PIN_DIAMOND.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', CommonTags.C_GEMS_DIAMOND)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_GEMS_DIAMOND), RecipeUtil.has(holderGetter, CommonTags.C_GEMS_DIAMOND))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_DIAMOND.get())));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(UbesDelightItemsImpl.ROLLING_PIN_DIAMOND.get()),
                        Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.NETHERITE_INGOTS)),
                        RecipeCategory.TOOLS,
                        UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get())
                .unlocks(RecipeUtil.hasItemTag(CommonTags.C_INGOTS_NETHERITE), RecipeUtil.has(holderGetter, CommonTags.C_INGOTS_NETHERITE))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get()) + "_smithing")); // should this be in a smithing folder instead of crafting?

        /** CROPS **/

        // Seed from crop
        RecipeUtil.simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.MISC,
                UbesDelightItemsImpl.LEMONGRASS.get(), 1,
                UbesDelightItemsImpl.LEMONGRASS_SEEDS.get(), 1);

        // Partial to full Vegetables
        RecipeUtil.simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.GARLIC_CHOP.get(), 2,
                UbesDelightItemsImpl.GARLIC.get(), 1);

        RecipeUtil.simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.GINGER_CHOP.get(), 2,
                UbesDelightItemsImpl.GINGER.get(), 1);

        /** FOODS **/

        // Cake Slices to Cake
        RecipeUtil.simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.UBE_CAKE_SLICE.get(), 7,
                UbesDelightItemsImpl.UBE_CAKE.get(), 1);

        RecipeUtil.simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItemsImpl.LECHE_FLAN.get(), 5,
                UbesDelightItemsImpl.LECHE_FLAN_FEAST.get(), 1);

        /** MISC **/

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                .requires(UbesDelightItemsImpl.UBE.get(), 1)
                .group("purple_dye")
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItemsImpl.UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.UBE.get()))
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(Items.PURPLE_DYE, UbesDelightItemsImpl.UBE.get())));

        /** LEAF FEASTS **/

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.MISC, UbesDelightItemsImpl.LEAF_FEAST.get())
                .requires(Ingredient.of(holderGetter.getOrThrow(CompatibilityTags.MINECRAFT_LEAVES)), 3)
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_LEAVES), RecipeUtil.has(holderGetter, CompatibilityTags.MINECRAFT_LEAVES))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, UbesDelightItemsImpl.LUMPIA_FEAST.get())
                .pattern("AAA")
                .pattern("BBB")
                .define('A', UbesDelightItemsImpl.LUMPIA.get())
                .define('B', CompatibilityTags.MINECRAFT_LEAVES)
                .group("ud_leaf_feast")
                .unlockedBy(RecipeUtil.hasAny(), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LUMPIA.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.LUMPIA_FEAST.get())));

        offerLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.ENSAYMADA.get(), UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.ENSAYMADA.get(), UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.ENSAYMADA_UBE.get(), UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.ENSAYMADA_UBE.get(), UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.PANDESAL.get(), UbesDelightItemsImpl.LEAF_FEAST_PANDESAL.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.PANDESAL.get(), UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.PANDESAL_UBE.get(), UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.PANDESAL_UBE.get(), UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.HOPIA_MUNGGO.get(), UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.HOPIA_MUNGGO.get(), UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.HOPIA_UBE.get(), UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.HOPIA_UBE.get(), UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE_HALF.get());

        offerLeafFeastRecipe(holderGetter, ModItems.COOKED_RICE.get(), UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE.get());
        offerHalfLeafFeastRecipe(holderGetter, ModItems.COOKED_RICE.get(), UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE_HALF.get());

        offerLeafFeastRecipe(holderGetter, ModItems.FRIED_RICE.get(), UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE.get());
        offerHalfLeafFeastRecipe(holderGetter, ModItems.FRIED_RICE.get(), UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.SINANGAG.get(), UbesDelightItemsImpl.LEAF_FEAST_SINANGAG.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItemsImpl.SINANGAG.get(), UbesDelightItemsImpl.LEAF_FEAST_SINANGAG_HALF.get());
    }

    private static void registerUncommon(HolderGetter<Item> holderGetter, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.MISC, UbesDelightItemsImpl.KALAN.get())
                .pattern("AAA")
                .pattern("ACA")
                .pattern("ABA")
                .define('A', CompatibilityTags.MINECRAFT_TERRACOTTA)
                .define('B', Items.CAMPFIRE)
                .define('C', CommonTags.C_INGOTS_IRON)
                .unlockedBy(RecipeProvider.getHasName(Items.CAMPFIRE), InventoryChangeTrigger.TriggerInstance.hasItems(Items.CAMPFIRE))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.KALAN.get())));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, UbesDelightItemsImpl.COOKIE_GINGER.get(), 8)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeUtil.hasAny(), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.GINGER.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.COOKIE_GINGER.get())));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, UbesDelightItemsImpl.COOKIE_UBE.get(), 8)
                .requires(CommonTags.C_CROPS_UBE)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeUtil.hasAny(), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.UBE.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.COOKIE_UBE.get())));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, UbesDelightItemsImpl.KINILAW.get())
                .requires(CommonTags.C_FOODS_SAFE_RAW_FISH)
                .requires(CommonTags.C_CROPS_ONION)
                .requires(CommonTags.C_CROPS_GARLIC)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(CommonTags.C_CROPS_LEMONGRASS)
                .requires(Items.BOWL)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, Items.BOWL, UbesDelightItemsImpl.GARLIC.get(), UbesDelightItemsImpl.GINGER.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.KINILAW.get())));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, UbesDelightItemsImpl.KINILAW.get())
                .requires(CompatibilityTags.MINECRAFT_FISHES)
                .requires(CommonTags.C_CROPS_ONION)
                .requires(CommonTags.C_CROPS_GARLIC)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(CommonTags.C_CROPS_LEMONGRASS)
                .requires(Items.BOWL)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, Items.BOWL, UbesDelightItemsImpl.GARLIC.get(), UbesDelightItemsImpl.GINGER.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.KINILAW.get()) + "_extra"));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, UbesDelightItemsImpl.LUMPIA_WRAPPER.get(), 32)
                .requires(CommonTags.C_CROPS_GRAIN)
                .requires(ConventionalItemTags.EGGS)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, Items.WATER_BUCKET, Items.EGG, Items.WHEAT))
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(UbesDelightItemsImpl.LUMPIA_WRAPPER.get(),Items.WATER_BUCKET)));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, UbesDelightItemsImpl.HALO_HALO_FEAST.get())
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', UbesDelightItemsImpl.HALO_HALO.get())
                .define('B', ConventionalItemTags.MILK_DRINKS)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, UbesDelightItemsImpl.HALO_HALO.get(), UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.HALO_HALO_FEAST.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, UbesDelightItemsImpl.MILK_TEA_UBE_FEAST.get())
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', UbesDelightItemsImpl.MILK_TEA_UBE.get())
                .define('B', ConventionalItemTags.MILK_DRINKS)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, UbesDelightItemsImpl.MILK_TEA_UBE.get(), UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, UbesDelightItemsImpl.UBE_CAKE.get())
                .pattern("AAA")
                .pattern("BEB")
                .pattern("CFC")
                .define('A', ConventionalItemTags.MILK_DRINKS)
                .define('B', CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .define('C', Items.WHEAT)
                .define('E', ConventionalItemTags.EGGS)
                .define('F', CommonTags.C_CROPS_UBE)
                .unlockedBy(RecipeProvider.getHasName(Items.EGG), InventoryChangeTrigger.TriggerInstance.hasItems(Items.EGG))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItemsImpl.UBE_CAKE.get())));
    }

    private static void offerLeafFeastRecipe(HolderGetter<Item> holderGetter, Item input, Item output) {
        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, output)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("BBB")
                .define('A', input)
                .define('B', CompatibilityTags.MINECRAFT_LEAVES)
                .unlockedBy(RecipeUtil.hasAny(), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(EXPORTER, suffix(RecipeProvider.getItemName(output)));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, output)
                .requires(input, 6)
                .requires(UbesDelightItemsImpl.LEAF_FEAST.get())
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, input, UbesDelightItemsImpl.LEAF_FEAST.get()))
                .save(EXPORTER, suffix(RecipeProvider.getItemName(output) + "from_leaf_feast"));
    }

    private static void offerHalfLeafFeastRecipe(HolderGetter<Item> holderGetter, Item input, Item output) {
        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, output)
                .pattern("AAA")
                .pattern("BBB")
                .define('A', input)
                .define('B', CompatibilityTags.MINECRAFT_LEAVES)
                .unlockedBy(RecipeUtil.hasAny(), InventoryChangeTrigger.TriggerInstance.hasItems(input))
                .save(EXPORTER, suffix(RecipeProvider.getItemName(output)));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, output)
                .requires(input, 3)
                .requires(UbesDelightItemsImpl.LEAF_FEAST.get())
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, input, UbesDelightItemsImpl.LEAF_FEAST.get()))
                .save(EXPORTER, suffix(RecipeProvider.getItemName(output) + "from_leaf_feast"));
    }

    private static String suffix(String string) {
        return "minecraft/crafting/" + string;
    }

//    private static ResourceLocation suffix(String string) {
//        return TextUtils.res("minecraft/crafting/" + string);
//    }
}
