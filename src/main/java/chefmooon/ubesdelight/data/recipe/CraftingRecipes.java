package chefmooon.ubesdelight.data.recipe;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import chefmooon.ubesdelight.common.utility.RecipeUtil;
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

import static chefmooon.ubesdelight.common.utility.RecipeUtil.simpleRecipeBuilder;

public class CraftingRecipes {
    private static RecipeOutput EXPORTER;
    public static void register(HolderGetter<Item> holderGetter, HolderLookup.Provider provider, RecipeOutput exporter) {
        EXPORTER = exporter;
        // todo - move uncommon here, organize them
        registerUncommon(holderGetter, exporter);

        /** MISC BLOCKS **/

        simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItems.UBE_CRATE.get(), 1,
                UbesDelightItems.UBE.get(), 9);
        simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItems.GARLIC_CRATE.get(), 1,
                UbesDelightItems.GARLIC.get(), 9);
        simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItems.GINGER_CRATE.get(), 1,
                UbesDelightItems.GINGER.get(), 9);
        simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItems.LEMONGRASS_CRATE.get(), 1,
                UbesDelightItems.LEMONGRASS.get(), 9);

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.MISC, UbesDelightItems.BAKING_MAT_BAMBOO.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.BAMBOO)
                .define('B', Items.HONEYCOMB)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, Items.BAMBOO, Items.HONEYCOMB))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.BAKING_MAT_BAMBOO.get())));

        /** ITEMS **/

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.TOOLS, UbesDelightItems.ROLLING_PIN_WOOD.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', ItemTags.FENCES)
                .unlockedBy(RecipeProvider.getHasName(Items.STICK), InventoryChangeTrigger.TriggerInstance.hasItems(Items.STICK))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_WOOD.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.TOOLS, UbesDelightItems.ROLLING_PIN_IRON.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', CommonTags.C_INGOTS_IRON)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_INGOTS_IRON), RecipeUtil.has(holderGetter, CommonTags.C_INGOTS_IRON))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_IRON.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.TOOLS, UbesDelightItems.ROLLING_PIN_GOLD.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', CommonTags.C_INGOTS_GOLD)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_INGOTS_GOLD), RecipeUtil.has(holderGetter, CommonTags.C_INGOTS_GOLD))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_GOLD.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.TOOLS, UbesDelightItems.ROLLING_PIN_DIAMOND.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', CommonTags.C_GEMS_DIAMOND)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_GEMS_DIAMOND), RecipeUtil.has(holderGetter, CommonTags.C_GEMS_DIAMOND))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_DIAMOND.get())));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(UbesDelightItems.ROLLING_PIN_DIAMOND.get()),
                        Ingredient.of(holderGetter.getOrThrow(ConventionalItemTags.NETHERITE_INGOTS)),
                        RecipeCategory.TOOLS,
                        UbesDelightItems.ROLLING_PIN_NETHERITE.get())
                .unlocks(RecipeUtil.hasItemTag(CommonTags.C_INGOTS_NETHERITE), RecipeUtil.has(holderGetter, CommonTags.C_INGOTS_NETHERITE))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_NETHERITE.get()) + "_smithing")); // should this be in a smithing folder instead of crafting?

        /** CROPS **/

        // Seed from crop
        RecipeUtil.simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.MISC,
                UbesDelightItems.LEMONGRASS.get(), 1,
                UbesDelightItems.LEMONGRASS_SEEDS.get(), 1);

        // Partial to full Vegetables
        RecipeUtil.simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItems.GARLIC_CHOP.get(), 2,
                UbesDelightItems.GARLIC.get(), 1);

        RecipeUtil.simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItems.GINGER_CHOP.get(), 2,
                UbesDelightItems.GINGER.get(), 1);

        /** FOODS **/

        // Cake Slices to Cake
        RecipeUtil.simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItems.UBE_CAKE_SLICE.get(), 7,
                UbesDelightItems.UBE_CAKE.get(), 1);

        RecipeUtil.simpleRecipeBuilder(holderGetter, exporter, RecipeCategory.FOOD,
                UbesDelightItems.LECHE_FLAN.get(), 5,
                UbesDelightItems.LECHE_FLAN_FEAST.get(), 1);

        /** MISC **/

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                .requires(UbesDelightItems.UBE.get(), 1)
                .group("purple_dye")
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.UBE.get()))
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(Items.PURPLE_DYE, UbesDelightItems.UBE.get())));

        /** LEAF FEASTS **/

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.MISC, UbesDelightItems.LEAF_FEAST.get())
                .requires(Ingredient.of(holderGetter.getOrThrow(CompatibilityTags.MINECRAFT_LEAVES)), 3)
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_LEAVES), RecipeUtil.has(holderGetter, CompatibilityTags.MINECRAFT_LEAVES))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, UbesDelightItems.LUMPIA_FEAST.get())
                .pattern("AAA")
                .pattern("BBB")
                .define('A', UbesDelightItems.LUMPIA.get())
                .define('B', CompatibilityTags.MINECRAFT_LEAVES)
                .group("ud_leaf_feast")
                .unlockedBy(RecipeUtil.hasAny(), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LUMPIA.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.LUMPIA_FEAST.get())));

        offerLeafFeastRecipe(holderGetter, UbesDelightItems.ENSAYMADA.get(), UbesDelightItems.LEAF_FEAST_ENSAYMADA.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItems.ENSAYMADA.get(), UbesDelightItems.LEAF_FEAST_ENSAYMADA_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItems.ENSAYMADA_UBE.get(), UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItems.ENSAYMADA_UBE.get(), UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItems.PANDESAL.get(), UbesDelightItems.LEAF_FEAST_PANDESAL.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItems.PANDESAL.get(), UbesDelightItems.LEAF_FEAST_PANDESAL_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItems.PANDESAL_UBE.get(), UbesDelightItems.LEAF_FEAST_PANDESAL_UBE.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItems.PANDESAL_UBE.get(), UbesDelightItems.LEAF_FEAST_PANDESAL_UBE_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItems.HOPIA_MUNGGO.get(), UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItems.HOPIA_MUNGGO.get(), UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItems.HOPIA_UBE.get(), UbesDelightItems.LEAF_FEAST_HOPIA_UBE.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItems.HOPIA_UBE.get(), UbesDelightItems.LEAF_FEAST_HOPIA_UBE_HALF.get());

        offerLeafFeastRecipe(holderGetter, ModItems.COOKED_RICE.get(), UbesDelightItems.LEAF_FEAST_COOKED_RICE.get());
        offerHalfLeafFeastRecipe(holderGetter, ModItems.COOKED_RICE.get(), UbesDelightItems.LEAF_FEAST_COOKED_RICE_HALF.get());

        offerLeafFeastRecipe(holderGetter, ModItems.FRIED_RICE.get(), UbesDelightItems.LEAF_FEAST_FRIED_RICE.get());
        offerHalfLeafFeastRecipe(holderGetter, ModItems.FRIED_RICE.get(), UbesDelightItems.LEAF_FEAST_FRIED_RICE_HALF.get());

        offerLeafFeastRecipe(holderGetter, UbesDelightItems.SINANGAG.get(), UbesDelightItems.LEAF_FEAST_SINANGAG.get());
        offerHalfLeafFeastRecipe(holderGetter, UbesDelightItems.SINANGAG.get(), UbesDelightItems.LEAF_FEAST_SINANGAG_HALF.get());
    }

    private static void registerUncommon(HolderGetter<Item> holderGetter, RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.MISC, UbesDelightItems.KALAN.get())
                .pattern("AAA")
                .pattern("ACA")
                .pattern("ABA")
                .define('A', CompatibilityTags.MINECRAFT_TERRACOTTA)
                .define('B', Items.CAMPFIRE)
                .define('C', CommonTags.C_INGOTS_IRON)
                .unlockedBy(RecipeProvider.getHasName(Items.CAMPFIRE), InventoryChangeTrigger.TriggerInstance.hasItems(Items.CAMPFIRE))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.KALAN.get())));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, UbesDelightItems.COOKIE_GINGER.get(), 8)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeUtil.hasAny(), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.GINGER.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.COOKIE_GINGER.get())));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, UbesDelightItems.COOKIE_UBE.get(), 8)
                .requires(CommonTags.C_CROPS_UBE)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeUtil.hasAny(), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.UBE.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.COOKIE_UBE.get())));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, UbesDelightItems.KINILAW.get())
                .requires(CommonTags.C_FOODS_SAFE_RAW_FISH)
                .requires(CommonTags.C_CROPS_ONION)
                .requires(CommonTags.C_CROPS_GARLIC)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(CommonTags.C_CROPS_LEMONGRASS)
                .requires(Items.BOWL)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, Items.BOWL, UbesDelightItems.GARLIC.get(), UbesDelightItems.GINGER.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.KINILAW.get())));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, UbesDelightItems.KINILAW.get())
                .requires(CompatibilityTags.MINECRAFT_FISHES)
                .requires(CommonTags.C_CROPS_ONION)
                .requires(CommonTags.C_CROPS_GARLIC)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(CommonTags.C_CROPS_LEMONGRASS)
                .requires(Items.BOWL)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, Items.BOWL, UbesDelightItems.GARLIC.get(), UbesDelightItems.GINGER.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.KINILAW.get()) + "_extra"));

        ShapelessRecipeBuilder.shapeless(holderGetter, RecipeCategory.FOOD, UbesDelightItems.LUMPIA_WRAPPER.get(), 32)
                .requires(CommonTags.C_CROPS_GRAIN)
                .requires(ConventionalItemTags.EGGS)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, Items.WATER_BUCKET, Items.EGG, Items.WHEAT))
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(UbesDelightItems.LUMPIA_WRAPPER.get(),Items.WATER_BUCKET)));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, UbesDelightItems.HALO_HALO_FEAST.get())
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', UbesDelightItems.HALO_HALO.get())
                .define('B', ConventionalItemTags.MILK_DRINKS)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, UbesDelightItems.HALO_HALO.get(), UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.HALO_HALO_FEAST.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, UbesDelightItems.MILK_TEA_UBE_FEAST.get())
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', UbesDelightItems.MILK_TEA_UBE.get())
                .define('B', ConventionalItemTags.MILK_DRINKS)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, UbesDelightItems.MILK_TEA_UBE.get(), UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.MILK_TEA_UBE_FEAST.get())));

        ShapedRecipeBuilder.shaped(holderGetter, RecipeCategory.FOOD, UbesDelightItems.UBE_CAKE.get())
                .pattern("AAA")
                .pattern("BEB")
                .pattern("CFC")
                .define('A', ConventionalItemTags.MILK_DRINKS)
                .define('B', CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .define('C', Items.WHEAT)
                .define('E', ConventionalItemTags.EGGS)
                .define('F', CommonTags.C_CROPS_UBE)
                .unlockedBy(RecipeProvider.getHasName(Items.EGG), InventoryChangeTrigger.TriggerInstance.hasItems(Items.EGG))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.UBE_CAKE.get())));
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
                .requires(UbesDelightItems.LEAF_FEAST.get())
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, input, UbesDelightItems.LEAF_FEAST.get()))
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
                .requires(UbesDelightItems.LEAF_FEAST.get())
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.has(holderGetter, input, UbesDelightItems.LEAF_FEAST.get()))
                .save(EXPORTER, suffix(RecipeProvider.getItemName(output) + "from_leaf_feast"));
    }

    private static String suffix(String string) {
        return "minecraft/crafting/" + string;
    }

//    private static ResourceLocation suffix(String string) {
//        return TextUtils.res("minecraft/crafting/" + string);
//    }
}
