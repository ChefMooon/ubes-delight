package chefmooon.ubesdelight.data.recipe;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import chefmooon.ubesdelight.common.utility.TextUtils;
import chefmooon.ubesdelight.common.utility.RecipeUtil;
import chefmooon.ubesdelight.data.UDRecipes;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.concurrent.CompletableFuture;

import static chefmooon.ubesdelight.common.utility.RecipeUtil.simpleRecipeBuilder;

public class CraftingRecipes extends UDRecipes {
    private static RecipeOutput EXPORTER;

    public CraftingRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static void register(RecipeOutput exporter) {
        EXPORTER = exporter;
        // todo - move uncommon here, organize them
        registerUncommon(exporter);

        simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItems.UBE_CRATE.get(), 1,
                UbesDelightItems.UBE.get(), 9);
        simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItems.GARLIC_CRATE.get(), 1,
                UbesDelightItems.GARLIC.get(), 9);
        simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItems.GINGER_CRATE.get(), 1,
                UbesDelightItems.GINGER.get(), 9);
        simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItems.LEMONGRASS_CRATE.get(), 1,
                UbesDelightItems.LEMONGRASS.get(), 9);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UbesDelightItems.BAKING_MAT_BAMBOO.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', Items.BAMBOO)
                .define('B', Items.HONEYCOMB)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(Items.BAMBOO, Items.HONEYCOMB))
                .save(exporter, suffix(RecipeUtil.getItemName(UbesDelightItems.BAKING_MAT_BAMBOO.get())));

        // ITEMS //

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, UbesDelightItems.ROLLING_PIN_WOOD.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', ItemTags.FENCES)
                .unlockedBy(RecipeUtil.getHasName(Items.STICK), RecipeProvider.has(Items.STICK))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_WOOD.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, UbesDelightItems.ROLLING_PIN_IRON.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', CommonTags.C_INGOTS_IRON)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_INGOTS_IRON), RecipeUtil.getTriggerfromTag(CommonTags.C_INGOTS_IRON))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_IRON.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, UbesDelightItems.ROLLING_PIN_GOLD.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', CommonTags.C_INGOTS_GOLD)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_INGOTS_GOLD), RecipeUtil.getTriggerfromTag(CommonTags.C_INGOTS_GOLD))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_GOLD.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, UbesDelightItems.ROLLING_PIN_DIAMOND.get())
                .pattern("  A")
                .pattern(" B ")
                .pattern("A  ")
                .define('A', Items.STICK)
                .define('B', CommonTags.C_GEMS_DIAMOND)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_GEMS_DIAMOND), RecipeUtil.getTriggerfromTag(CommonTags.C_GEMS_DIAMOND))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_DIAMOND.get())));

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(UbesDelightItems.ROLLING_PIN_DIAMOND.get()),
                        Ingredient.of(CommonTags.C_INGOTS_NETHERITE),
                        RecipeCategory.TOOLS,
                        UbesDelightItems.ROLLING_PIN_NETHERITE.get())
                .unlocks(RecipeUtil.hasItemTag(CommonTags.C_INGOTS_NETHERITE), RecipeUtil.getTriggerfromTag(CommonTags.C_INGOTS_NETHERITE))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_NETHERITE.get()) + "_smithing")); // should this be in a smithing folder instead of crafting?

        // CROPS //

        // Seed from crop
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.MISC,
                UbesDelightItems.LEMONGRASS.get(), 1,
                UbesDelightItems.LEMONGRASS_SEEDS.get(), 1);

        // Partial to full Vegetables
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItems.GARLIC_CHOP.get(), 2,
                UbesDelightItems.GARLIC.get(), 1);

        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItems.GINGER_CHOP.get(), 2,
                UbesDelightItems.GINGER.get(), 1);

        // FOODS //

        // Cake Slices to Cake
        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItems.UBE_CAKE_SLICE.get(), 7,
                UbesDelightItems.UBE_CAKE.get(), 1);

        RecipeUtil.simpleRecipeBuilder(exporter, RecipeCategory.FOOD,
                UbesDelightItems.LECHE_FLAN.get(), 5,
                UbesDelightItems.LECHE_FLAN_FEAST.get(), 1);

        // MISC //

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PURPLE_DYE, 1)
                .requires(UbesDelightItems.UBE.get(), 1)
                .group("purple_dye")
                .unlockedBy(RecipeProvider.getHasName(UbesDelightItems.UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.UBE.get()))
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(Items.PURPLE_DYE, UbesDelightItems.UBE.get())));

        // LEAF FEASTS //

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, UbesDelightItems.LEAF_FEAST.get())
                .requires(Ingredient.of(CompatibilityTags.MINECRAFT_LEAVES), 3)
                .unlockedBy(RecipeUtil.hasItemTag(CompatibilityTags.MINECRAFT_LEAVES), RecipeUtil.getTriggerfromTag(CompatibilityTags.MINECRAFT_LEAVES))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, UbesDelightItems.LUMPIA_FEAST.get())
                .pattern("AAA")
                .pattern("BBB")
                .define('A', UbesDelightItems.LUMPIA.get())
                .define('B', CompatibilityTags.MINECRAFT_LEAVES)
                .group("ud_leaf_feast")
                .unlockedBy(RecipeUtil.hasAny(), RecipeProvider.has(UbesDelightItems.LUMPIA.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.LUMPIA_FEAST.get())));

        offerLeafFeastRecipe(UbesDelightItems.ENSAYMADA.get(), UbesDelightItems.LEAF_FEAST_ENSAYMADA.get());
        offerHalfLeafFeastRecipe(UbesDelightItems.ENSAYMADA.get(), UbesDelightItems.LEAF_FEAST_ENSAYMADA_HALF.get());

        offerLeafFeastRecipe(UbesDelightItems.ENSAYMADA_UBE.get(), UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE.get());
        offerHalfLeafFeastRecipe(UbesDelightItems.ENSAYMADA_UBE.get(), UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE_HALF.get());

        offerLeafFeastRecipe(UbesDelightItems.PANDESAL.get(), UbesDelightItems.LEAF_FEAST_PANDESAL.get());
        offerHalfLeafFeastRecipe(UbesDelightItems.PANDESAL.get(), UbesDelightItems.LEAF_FEAST_PANDESAL_HALF.get());

        offerLeafFeastRecipe(UbesDelightItems.PANDESAL_UBE.get(), UbesDelightItems.LEAF_FEAST_PANDESAL_UBE.get());
        offerHalfLeafFeastRecipe(UbesDelightItems.PANDESAL_UBE.get(), UbesDelightItems.LEAF_FEAST_PANDESAL_UBE_HALF.get());

        offerLeafFeastRecipe(UbesDelightItems.HOPIA_MUNGGO.get(), UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO.get());
        offerHalfLeafFeastRecipe(UbesDelightItems.HOPIA_MUNGGO.get(), UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO_HALF.get());

        offerLeafFeastRecipe(UbesDelightItems.HOPIA_UBE.get(), UbesDelightItems.LEAF_FEAST_HOPIA_UBE.get());
        offerHalfLeafFeastRecipe(UbesDelightItems.HOPIA_UBE.get(), UbesDelightItems.LEAF_FEAST_HOPIA_UBE_HALF.get());

        offerLeafFeastRecipe(ModItems.COOKED_RICE.get(), UbesDelightItems.LEAF_FEAST_COOKED_RICE.get());
        offerHalfLeafFeastRecipe(ModItems.COOKED_RICE.get(), UbesDelightItems.LEAF_FEAST_COOKED_RICE_HALF.get());

        offerLeafFeastRecipe(ModItems.FRIED_RICE.get(), UbesDelightItems.LEAF_FEAST_FRIED_RICE.get());
        offerHalfLeafFeastRecipe(ModItems.FRIED_RICE.get(), UbesDelightItems.LEAF_FEAST_FRIED_RICE_HALF.get());

        offerLeafFeastRecipe(UbesDelightItems.SINANGAG.get(), UbesDelightItems.LEAF_FEAST_SINANGAG.get());
        offerHalfLeafFeastRecipe(UbesDelightItems.SINANGAG.get(), UbesDelightItems.LEAF_FEAST_SINANGAG_HALF.get());
    }

    private static void registerUncommon(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, UbesDelightItems.KALAN.get())
                .pattern("AAA")
                .pattern("ACA")
                .pattern("ABA")
                .define('A', CompatibilityTags.MINECRAFT_TERRACOTTA)
                .define('B', Items.CAMPFIRE)
                .define('C', CommonTags.C_INGOTS_IRON)
                .unlockedBy(RecipeProvider.getHasName(Items.CAMPFIRE), RecipeProvider.has(Items.CAMPFIRE))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.KALAN.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, UbesDelightItems.COOKIE_GINGER.get(), 8)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeUtil.hasAny(), RecipeProvider.has(UbesDelightItems.GINGER.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.COOKIE_GINGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, UbesDelightItems.COOKIE_UBE.get(), 8)
                .requires(CommonTags.C_CROPS_UBE)
                .requires(Items.WHEAT, 2)
                .unlockedBy(RecipeUtil.hasAny(), RecipeProvider.has(UbesDelightItems.UBE.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.COOKIE_UBE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, UbesDelightItems.KINILAW.get())
                .requires(CommonTags.C_FOODS_SAFE_RAW_FISH)
                .requires(CommonTags.C_CROPS_ONION)
                .requires(CommonTags.C_CROPS_GARLIC)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(CommonTags.C_CROPS_LEMONGRASS)
                .requires(Items.BOWL)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(Items.BOWL, UbesDelightItems.GARLIC.get(), UbesDelightItems.GINGER.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.KINILAW.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, UbesDelightItems.KINILAW.get())
                .requires(CompatibilityTags.MINECRAFT_FISHES)
                .requires(CommonTags.C_CROPS_ONION)
                .requires(CommonTags.C_CROPS_GARLIC)
                .requires(CommonTags.C_CROPS_GINGER)
                .requires(CommonTags.C_CROPS_LEMONGRASS)
                .requires(Items.BOWL)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(Items.BOWL, UbesDelightItems.GARLIC.get(), UbesDelightItems.GINGER.get()))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.KINILAW.get()) + "_extra"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, UbesDelightItems.LUMPIA_WRAPPER.get(), 32)
                .requires(CommonTags.C_CROPS_GRAIN)
                .requires(CommonTags.C_EGGS)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(Items.WATER_BUCKET, Items.EGG, Items.WHEAT))
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(UbesDelightItems.LUMPIA_WRAPPER.get(),Items.WATER_BUCKET)));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, UbesDelightItems.HALO_HALO_FEAST.get())
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', UbesDelightItems.HALO_HALO.get())
                .define('B', Tags.Items.DRINKS_MILK)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(UbesDelightItems.HALO_HALO.get(), UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.HALO_HALO_FEAST.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, UbesDelightItems.MILK_TEA_UBE_FEAST.get())
                .pattern("   ")
                .pattern("ABA")
                .pattern(" A ")
                .define('A', UbesDelightItems.MILK_TEA_UBE.get())
                .define('B', Tags.Items.DRINKS_MILK)
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(UbesDelightItems.MILK_TEA_UBE.get(), UbesDelightItems.CONDENSED_MILK_BOTTLE.get(), Items.MILK_BUCKET))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.MILK_TEA_UBE_FEAST.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, UbesDelightItems.UBE_CAKE.get())
                .pattern("AAA")
                .pattern("BEB")
                .pattern("CFC")
                .define('A', Tags.Items.DRINKS_MILK)
                .define('B', CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .define('C', Items.WHEAT)
                .define('E', CommonTags.C_EGGS)
                .define('F', CommonTags.C_CROPS_UBE)
                .unlockedBy(RecipeProvider.getHasName(Items.EGG), RecipeProvider.has(Items.EGG))
                .save(exporter, suffix(RecipeProvider.getItemName(UbesDelightItems.UBE_CAKE.get())));
    }

    private static void offerLeafFeastRecipe(Item input, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, output)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("BBB")
                .define('A', input)
                .define('B', CompatibilityTags.MINECRAFT_LEAVES)
                .unlockedBy(RecipeUtil.hasAny(), RecipeProvider.has(input))
                .save(EXPORTER, suffix(RecipeProvider.getItemName(output)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, output)
                .requires(input, 6)
                .requires(UbesDelightItems.LEAF_FEAST.get())
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(input, UbesDelightItems.LEAF_FEAST.get()))
                .save(EXPORTER, suffix(RecipeProvider.getItemName(output) + "from_leaf_feast"));
    }

    private static void offerHalfLeafFeastRecipe(Item input, Item output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, output)
                .pattern("AAA")
                .pattern("BBB")
                .define('A', input)
                .define('B', CompatibilityTags.MINECRAFT_LEAVES)
                .unlockedBy(RecipeUtil.hasAny(), RecipeProvider.has(input))
                .save(EXPORTER, suffix(RecipeProvider.getItemName(output)));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, output)
                .requires(input, 3)
                .requires(UbesDelightItems.LEAF_FEAST.get())
                .unlockedBy(RecipeUtil.hasAny(), RecipeUtil.getTriggerfromItems(input, UbesDelightItems.LEAF_FEAST.get()))
                .save(EXPORTER, suffix(RecipeProvider.getItemName(output) + "from_leaf_feast"));
    }

    private static ResourceLocation suffix(String string) {
        return TextUtils.res("minecraft/crafting/" + string);
    }
}
