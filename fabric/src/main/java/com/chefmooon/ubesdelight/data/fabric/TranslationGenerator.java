package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.tag.UbesDelightTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

import static com.chefmooon.ubesdelight.common.utility.TagUtils.getTranslationKey;

public class TranslationGenerator extends FabricLanguageProvider {
    public TranslationGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {

        String MOD_ID = UbesDelight.MOD_ID;
        String TOOLTIP = MOD_ID + ".tooltip.";
        String ADVANCEMENT = MOD_ID + ".advancement.";
        String SUBTITLES = MOD_ID + ".subtitles.";
        String CONFIG = MOD_ID + ".midnightconfig.";
        String REI = MOD_ID + ".rei.";
        String EMI = MOD_ID + ".emi.";
        String EMI_CATEGORY = "emi.category." + MOD_ID + ".";
        String WAILA = MOD_ID + ".tooltip.waila";
        String WAILA_CONFIG = "config.waila.plugin_" + MOD_ID;
        String FORMATTED_MOD_ID = "Ube's Delight";
        String C_TAG = "tag.item.c.";
        String UD_TAG = "tag.item." + MOD_ID + ".";

        translationBuilder.add("itemGroup." + MOD_ID, FORMATTED_MOD_ID);

        translationBuilder.add(MOD_ID + ".container.punch_bowl", "Glass Bottle Required.");
        translationBuilder.add(MOD_ID + ".container.bowl", "Bowl Required.");

        translationBuilder.add(TOOLTIP + UbesDelightItemsImpl.KALAN.get().getDescriptionId(), "Traditional Filipino Clay Oven.");
        translationBuilder.add(TOOLTIP + "knife", "Knife Required.");

        translationBuilder.add(TOOLTIP + "baking_mat.invalid_item", "Invalid Items");
        translationBuilder.add(TOOLTIP + "baking_mat.invalid_tool", "Invalid Tool");

        translationBuilder.add(TOOLTIP + "glass_cup", "Shift-right-click to place. Right-click with a tool to rotate.");

        translationBuilder.add(UbesDelightBlocksImpl.POTTED_UBE.get(), "Potted Wild Ube");
        translationBuilder.add(UbesDelightBlocksImpl.POTTED_GARLIC.get(), "Potted Wild Garlic");
        translationBuilder.add(UbesDelightBlocksImpl.POTTED_GINGER.get(), "Potted Wild Ginger");

        translationBuilder.add(UbesDelightBlocksImpl.KALAN.get(), "Kalan");
        translationBuilder.add(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get(), "Bamboo Baking Mat");

        translationBuilder.add(UbesDelightItemsImpl.ROLLING_PIN_WOOD.get(), "Wood Rolling Pin");
        translationBuilder.add(UbesDelightItemsImpl.ROLLING_PIN_IRON.get(), "Iron Rolling Pin");
        translationBuilder.add(UbesDelightItemsImpl.ROLLING_PIN_GOLD.get(), "Gold Rolling Pin");
        translationBuilder.add(UbesDelightItemsImpl.ROLLING_PIN_DIAMOND.get(), "Diamond Rolling Pin");
        translationBuilder.add(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get(), "Netherite Rolling Pin");

        translationBuilder.add(UbesDelightItemsImpl.UBE_CRATE.get(), "Ube Crate");
        translationBuilder.add(UbesDelightItemsImpl.GARLIC_CRATE.get(), "Garlic Crate");
        translationBuilder.add(UbesDelightItemsImpl.GINGER_CRATE.get(), "Ginger Crate");
        translationBuilder.add(UbesDelightItemsImpl.LEMONGRASS_CRATE.get(), "Lemongrass Crate");

        translationBuilder.add(UbesDelightItemsImpl.WILD_UBE.get(), "Wild Ube");
        translationBuilder.add(UbesDelightItemsImpl.WILD_GARLIC.get(), "Wild Garlic");
        translationBuilder.add(UbesDelightItemsImpl.WILD_GINGER.get(), "Wild Ginger");
        translationBuilder.add(UbesDelightItemsImpl.WILD_LEMONGRASS.get(), "Wild Lemongrass");

        translationBuilder.add(UbesDelightItemsImpl.SINANGAG.get(), "Sinangag");
        translationBuilder.add(UbesDelightItemsImpl.KINILAW.get(), "Kinilaw");
        translationBuilder.add(UbesDelightItemsImpl.LUMPIA.get(), "Lumpia");
        translationBuilder.add(UbesDelightItemsImpl.TOCINO.get(), "Tocino");
        translationBuilder.add(UbesDelightItemsImpl.CHICKEN_INASAL.get(), "Chicken Inasal");

        translationBuilder.add(UbesDelightItemsImpl.CHICKEN_INASAL_RICE.get(), "Chicken Inasal Plate");
        translationBuilder.add(UbesDelightItemsImpl.TOSILOG.get(), "Tosilog");
        translationBuilder.add(UbesDelightItemsImpl.BANGSILOG.get(), "Bangsilog");
        translationBuilder.add(UbesDelightItemsImpl.SISIG.get(), "Sisig");
        translationBuilder.add(UbesDelightItemsImpl.BULALO.get(), "Bulalo");
        translationBuilder.add(UbesDelightItemsImpl.ARROZ_CALDO.get(), "Arroz Caldo");
        translationBuilder.add(UbesDelightItemsImpl.MECHADO.get(), "Mechado");

        translationBuilder.add(UbesDelightItemsImpl.POISONOUS_UBE.get(), "Poisonous Ube");
        translationBuilder.add(UbesDelightItemsImpl.UBE.get(), "Ube");
        translationBuilder.add(UbesDelightItemsImpl.GARLIC.get(), "Garlic");
        translationBuilder.add(UbesDelightItemsImpl.GINGER.get(), "Ginger");
        translationBuilder.add(UbesDelightItemsImpl.LEMONGRASS.get(), "Lemongrass");
        translationBuilder.add(UbesDelightItemsImpl.LEMONGRASS_SEEDS.get(), "Lemongrass Seeds");

        translationBuilder.add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE.get(), "Condensed Milk Bottle");
        translationBuilder.add(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE.get(), "Fish Sauce Bottle");
        translationBuilder.add(UbesDelightItemsImpl.MILK_POWDER.get(), "Milk Powder");
        translationBuilder.add(UbesDelightItemsImpl.SUGAR_BROWN.get(), "Brown Sugar");
        translationBuilder.add(UbesDelightItemsImpl.LUMPIA_WRAPPER.get(), "Lumpia Wrapper");

        translationBuilder.add(UbesDelightItemsImpl.GARLIC_CHOP.get(), "Chopped Garlic");
        translationBuilder.add(UbesDelightItemsImpl.GINGER_CHOP.get(), "Chopped Ginger");

        translationBuilder.add(UbesDelightItemsImpl.LECHE_FLAN.get(), "Leche Flan Slice");
        translationBuilder.add(UbesDelightItemsImpl.COOKIE_UBE.get(), "Ube Cookie");
        translationBuilder.add(UbesDelightItemsImpl.COOKIE_GINGER.get(), "Ginger Cookie");

        translationBuilder.add(UbesDelightItemsImpl.POLVORONE.get(), "Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_PINIPIG.get(), "Pinipig Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_UBE.get(), "Ube Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_CC.get(), "Cookies and Cream Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.RAW_POLVORONE.get(), "Raw Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG.get(), "Raw Pinipig Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.RAW_POLVORONE_UBE.get(), "Raw Ube Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.RAW_POLVORONE_CC.get(), "Raw Cookies and Cream Polvorone");

        translationBuilder.add(UbesDelightItemsImpl.LECHE_FLAN_FEAST.get(), "Leche Flan");
        translationBuilder.add(UbesDelightItemsImpl.HALO_HALO_FEAST.get(), "Bowl of Halo Halo");
        translationBuilder.add(UbesDelightItemsImpl.HALO_HALO.get(), "Halo Halo");
        translationBuilder.add(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST.get(), "Bowl of Ube Milk Tea");
        translationBuilder.add(UbesDelightItemsImpl.MILK_TEA_UBE.get(), "Ube Milk Tea");
        translationBuilder.add(UbesDelightItemsImpl.LUMPIA_FEAST.get(), "Lumpia Leaf Feast");

        translationBuilder.add(UbesDelightItemsImpl.UBE_CAKE.get(), "Ube Cake");
        translationBuilder.add(UbesDelightItemsImpl.UBE_CAKE_SLICE.get(), "Ube Cake Slice");

        translationBuilder.add(UbesDelightItemsImpl.PANDESAL.get(), "Pandesal");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_UBE.get(), "Ube Pandesal");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA.get(), "Ensaymada");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE.get(), "Ube Ensaymada");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_MUNGGO.get(), "Hopia Munggo");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_UBE.get(), "Hopia Ube");

        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_STAGE0.get(), "Pandesal Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_STAGE1.get(), "Pandesal Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_STAGE2.get(), "Pandesal Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_RAW.get(), "Raw Pandesal");

        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_UBE_STAGE0.get(), "Ube Pandesal Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_UBE_STAGE1.get(), "Ube Pandesal Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_UBE_STAGE2.get(), "Ube Pandesal Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_UBE_RAW.get(), "Raw Ube Pandesal");

        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_STAGE0.get(), "Ensaymada Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_STAGE1.get(), "Ensaymada Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_STAGE2.get(), "Ensaymada Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_STAGE3.get(), "Ensaymada Stage 3");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_RAW.get(), "Raw Ensaymada");

        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE0.get(), "Ube Ensaymada Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE1.get(), "Ube Ensaymada Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE2.get(), "Ube Ensaymada Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE3.get(), "Ube Ensaymada Stage 3");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE_RAW.get(), "Raw Ube Ensaymada");

        translationBuilder.add(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE0.get(), "Hopia Munggo Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE1.get(), "Hopia Munggo Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE2.get(), "Hopia Munggo Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_MUNGGO_RAW.get(), "Raw Hopia Munggo");

        translationBuilder.add(UbesDelightItemsImpl.HOPIA_UBE_STAGE0.get(), "Hopia Ube Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_UBE_STAGE1.get(), "Hopia Ube Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_UBE_STAGE2.get(), "Hopia Ube Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_UBE_RAW.get(), "Raw Hopia Ube");

        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_STAGE0.get(), "Polvorone Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_STAGE1.get(), "Polvorone Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_STAGE2.get(), "Polvorone Stage 2");

        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE0.get(), "Pinipig Polvorone Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE1.get(), "Pinipig Polvorone Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE2.get(), "Pinipig Polvorone Stage 2");

        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_UBE_STAGE0.get(), "Ube Polvorone Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_UBE_STAGE1.get(), "Ube Polvorone Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_UBE_STAGE2.get(), "Ube Polvorone Stage 2");

        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_CC_STAGE0.get(), "Cookies and Cream Polvorone Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_CC_STAGE1.get(), "Cookies and Cream Polvorone Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_CC_STAGE2.get(), "Cookies and Cream Polvorone Stage 2");

        translationBuilder.add(UbesDelightBlocksImpl.UBE_CROP.get(), "Ube Crop");
        translationBuilder.add(UbesDelightBlocksImpl.GARLIC_CROP.get(), "Garlic Crop");
        translationBuilder.add(UbesDelightBlocksImpl.GINGER_CROP.get(), "Ginger Crop");

        translationBuilder.add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get(), "Lemongrass Stalk");
        translationBuilder.add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP.get(), "Lemongrass Leaves");

        translationBuilder.add(UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO.get(), "Halo Halo");
        translationBuilder.add(UbesDelightBlocksImpl.GLASS_CUP_MILK_TEA_UBE.get(), "Ube Milk Tea");

        translationBuilder.add(UbesDelightBlocksImpl.LEAF_FEAST.get(), "Leaf Feast");
        translationBuilder.add(UbesDelightBlocksImpl.UNIVERSAL_LEAF_FEAST.get(), "Leaf Feast");
        translationBuilder.add(UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA.get(), "Ensaymada Leaf Feast");
        translationBuilder.add(UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA_UBE.get(), "Ube Ensaymada Leaf Feast");
        translationBuilder.add(UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL.get(), "Pandesal Leaf Feast");
        translationBuilder.add(UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL_UBE.get(), "Ube Pandesal Leaf Feast");
        translationBuilder.add(UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_MUNGGO.get(), "Hopia Munggo Leaf Feast");
        translationBuilder.add(UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_UBE.get(), "Hopia Ube Leaf Feast");
        translationBuilder.add(UbesDelightBlocksImpl.LEAF_FEAST_COOKED_RICE.get(), "Cooked Rice Leaf Feast");
        translationBuilder.add(UbesDelightBlocksImpl.LEAF_FEAST_FRIED_RICE.get(), "Fried Rice Leaf Feast");
        translationBuilder.add(UbesDelightBlocksImpl.LEAF_FEAST_SINANGAG.get(), "Sinangag Leaf Feast");

        translationBuilder.add(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_HALF.get(), "Ensaymada Half Leaf Feast");
        translationBuilder.add(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE_HALF.get(), "Ube Ensaymada Half Leaf Feast");
        translationBuilder.add(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_HALF.get(), "Pandesal Half Leaf Feast");
        translationBuilder.add(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE_HALF.get(), "Ube Pandesal Half Leaf Feast");
        translationBuilder.add(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO_HALF.get(), "Hopia Munggo Half Leaf Feast");
        translationBuilder.add(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE_HALF.get(), "Hopia Ube Half Leaf Feast");
        translationBuilder.add(UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE_HALF.get(), "Cooked Rice Half Leaf Feast");
        translationBuilder.add(UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE_HALF.get(), "Fried Rice Half Leaf Feast");
        translationBuilder.add(UbesDelightItemsImpl.LEAF_FEAST_SINANGAG_HALF.get(), "Sinangag Half Leaf Feast");

        translationBuilder.add(ADVANCEMENT + "root", FORMATTED_MOD_ID);
        translationBuilder.add(ADVANCEMENT + "root.desc", "Cuisine from the Phillipines!");

        translationBuilder.add(ADVANCEMENT + "craft_rolling_pin", "Rolling Pin");
        translationBuilder.add(ADVANCEMENT + "craft_rolling_pin.desc", "Use sticks and a fence to make a new tool for the kitchen");

        translationBuilder.add(ADVANCEMENT + "netherite_rolling_pin", "Rolling in the Deep");
        translationBuilder.add(ADVANCEMENT + "netherite_rolling_pin.desc", "Upgrade your Rolling Pin with a Netherite Ingot! You must be serious about baking");

        translationBuilder.add(ADVANCEMENT + "craft_baking_mat", "Baking Mat");
        translationBuilder.add(ADVANCEMENT + "craft_baking_mat.desc", "Surround honeycomb with bamboo to craft a Baking Mat");

        translationBuilder.add(ADVANCEMENT + "use_baking_mat", "Ube's Baking");
        translationBuilder.add(ADVANCEMENT + "use_baking_mat.desc", "Add baking ingredients to the Baking Mat then use the Rolling Pin to craft baked goods in a new way!");

        translationBuilder.add(ADVANCEMENT + "place_drinkable_feast", "Punch Bowl");
        translationBuilder.add(ADVANCEMENT + "place_drinkable_feast.desc", "Drinks can be combined and placed. Place one, grab a bottle, and have a sip!");

        translationBuilder.add(ADVANCEMENT + "place_kalan", "Take the Kitchen Outside!");
        translationBuilder.add(ADVANCEMENT + "place_kalan.desc", "The Kalan is a traditional Filipino terracotta stove. Perfect for an outdoor kitchen, place one!");

        translationBuilder.add(ADVANCEMENT + "ube_master", "Ube Enthusiast");
        translationBuilder.add(ADVANCEMENT + "ube_master.desc", "Eat every Ube specific dish");

        translationBuilder.add(ADVANCEMENT + "ud_master", FORMATTED_MOD_ID + " Master");
        translationBuilder.add(ADVANCEMENT + "ud_master.desc", "Try all the new food and drink items from " + FORMATTED_MOD_ID);

        translationBuilder.add(ADVANCEMENT + "master_baker", "Master Baker");
        translationBuilder.add(ADVANCEMENT + "master_baker.desc", "Craft all varieties of Filipino bread!");

        translationBuilder.add(ADVANCEMENT + "plant_all_crops", "Master Farmer of the Tropics");
        translationBuilder.add(ADVANCEMENT + "plant_all_crops.desc", "Cultivate every new crop found in the Jungle!");

        translationBuilder.add(ADVANCEMENT + "get_ud_seed", "Crops of the Tropics");
        translationBuilder.add(ADVANCEMENT + "get_ud_seed.desc", "Adventure to find four new crops, only found in jungles and some village chests.");

        translationBuilder.add(ADVANCEMENT + "leaf_feast", "Leaf Feast");
        translationBuilder.add(ADVANCEMENT + "leaf_feast.desc", "Crafted with 3 leaves of any kind. When placed you can share food 'Kamayan' (by hand) style, a tradition in the Philippines");

        translationBuilder.add(ADVANCEMENT + "place_leaf_feast", "Never-ending Feast");
        translationBuilder.add(ADVANCEMENT + "place_leaf_feast.desc", "When placed and facing the same direction the shape changes. Place 2, 3, or more in a row!");

        translationBuilder.add(ADVANCEMENT + "use_leaf_feast", "Universal Leaf Feast");
        translationBuilder.add(ADVANCEMENT + "use_leaf_feast.desc", "Edible items can be placed inside, try it out!");

        translationBuilder.add(ADVANCEMENT + "leaf_feast_master", "Leaf Feast Master");
        translationBuilder.add(ADVANCEMENT + "leaf_feast_master.desc", "Feasts, including some half-feasts, can be crafted. Craft them all!");

        translationBuilder.add(ADVANCEMENT + "boodle_fight", "Boodle Fight");
        translationBuilder.add(ADVANCEMENT + "boodle_fight.desc", "While shifting and with an empty hand, you can right-click to eat directly from the Leaf Feast. Eat as much as you can!");

        translationBuilder.add(SUBTITLES + "block_baking_mat.add", "Item added");
        translationBuilder.add(SUBTITLES + "block_baking_mat.remove", "Item Removed");
        translationBuilder.add(SUBTITLES + "block_baking_mat.rolling_pin", "Rolling Pin rolls");

        translationBuilder.add(SUBTITLES + "block_drinkable_feast.add", "Drink Added");
        translationBuilder.add(SUBTITLES + "block_drinkable_feast.remove", "Drink Removed");

        translationBuilder.add(SUBTITLES + "block_lumpia_feast.remove", "Lumpia Removed");

        translationBuilder.add(CONFIG + "title", FORMATTED_MOD_ID + " Settings");
        translationBuilder.add(CONFIG + "category.common", "Common Settings");
        translationBuilder.add(CONFIG + "category.client", "Client Settings");

        translationBuilder.add(CONFIG + "enableUDCropCrates", "Enable UD Crop Crates");
        translationBuilder.add(CONFIG + "farmersBuyUDCrops", "Farmers Buy UD Crops");
        translationBuilder.add(CONFIG + "wanderingTraderSellsUDItems", "Wandering Trader Sells UD Items");

        translationBuilder.add(CONFIG + "worldGenerationSettings", "World generation");

        translationBuilder.add(CONFIG + "generateUDChestLoot", "Should this mod add its seeds as extra chest loot across Minecraft?");

        translationBuilder.add(CONFIG + "generateWildUbe", "Generate wild ube in jungles?");
        translationBuilder.add(CONFIG + "generateWildGarlic", "Generate wild garlic in jungles?");
        translationBuilder.add(CONFIG + "generateWildGinger", "Generate wild ginger in jungles?");
        translationBuilder.add(CONFIG + "generateWildLemongrass", "Generate wild lemongrass in jungles?");

        translationBuilder.add(CONFIG + "bakingMatFortuneBonus", "Sets the bonus percentage each level of \nFortune grants to Baking Mat success chances.");
        translationBuilder.add(CONFIG + "bakingMatFortuneBonus.tooltip", "Set to 0.0 to disable Fortune's effect.");

        translationBuilder.add(CONFIG + "isFoodEffectTooltip", "Should meal and drink tooltips display which effects they provide?");

        translationBuilder.add(REI + "baking_mat", "Baking Mat");
        translationBuilder.add(REI + "chance", "%1$s%% chance");

        translationBuilder.add(REI + "info.rolling_pin", "Rolling Pins are primarily used for crafting on a Baking Mat. \n\nHowever, if options are limited it can be used as a weapon. It does very little damage but has increased knockback.");

        translationBuilder.add(REI + "info.ube", "Ube can be commonly found as a wild plant in jungles.");
        translationBuilder.add(REI + "info.garlic", "Garlic can be commonly found as a wild plant in jungles.");
        translationBuilder.add(REI + "info.ginger", "Ginger can be commonly found as a wild plant in jungles.");
        translationBuilder.add(REI + "info.lemongrass", "Lemongrass can be commonly found as a wild plant in jungles.");

        translationBuilder.add(EMI_CATEGORY + "baking_mat", "Baking Mat");

        translationBuilder.add(WAILA_CONFIG, FORMATTED_MOD_ID);
        translationBuilder.add(WAILA_CONFIG + ".punchbowl_servings", "Punch Bowl Servings");

        translationBuilder.add(WAILA + ".punchbowl_servings", "Servings");

        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_FOOD_WRAPPERS), "Food Wrappers");
        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER), "Lumpia Wrappers");

        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_CROPS_UBE), "Ube Crops");
        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_CROPS_GARLIC), "Garlic Crops");
        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_CROPS_GINGER), "Ginger Crops");
        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_CROPS_LEMONGRASS), "Lemongrass Crops");

        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_FOODS_UBE), "Ube");
        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_FOODS_GARLIC), "Garlic");
        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_FOODS_GINGER), "Ginger");
        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_FOODS_LEMONGRASS), "Lemongrass");

        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_TEA_INGREDIENTS), "Tea Ingredients");
        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK), "Sweet Weak");

        translationBuilder.add(C_TAG + getTranslationKey(CommonTags.C_TOOLS_ROLLING_PIN), "Rolling Pins");
        translationBuilder.add(UD_TAG + getTranslationKey(UbesDelightTags.TOOLS_ROLLING_PIN), "Rolling Pins");
    }
}
