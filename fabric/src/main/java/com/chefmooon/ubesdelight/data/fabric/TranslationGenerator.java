package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class TranslationGenerator extends FabricLanguageProvider {
    public TranslationGenerator(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

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

        translationBuilder.add("itemGroup." + MOD_ID, FORMATTED_MOD_ID);

        translationBuilder.add(MOD_ID + ".container.punch_bowl", "Glass Bottle Required.");

        translationBuilder.add(TOOLTIP + UbesDelightItemsImpl.KALAN, "Traditional Filipino Clay Oven.");
        translationBuilder.add(TOOLTIP + "knife", "Knife Required.");

        translationBuilder.add(TOOLTIP + "baking_mat.invalid_item", "Invalid Items");
        translationBuilder.add(TOOLTIP + "baking_mat.invalid_tool", "Invalid Tool");

        translationBuilder.add(TOOLTIP + UbesDelightItemsImpl.HALO_HALO, "Right Click with a Knife to rotate. Break with Knife to pickup.");

        translationBuilder.add(UbesDelightItemsImpl.KALAN, "Kalan");
        translationBuilder.add(UbesDelightItemsImpl.BAKING_MAT_BAMBOO, "Bamboo Baking Mat");

        translationBuilder.add(UbesDelightItemsImpl.ROLLING_PIN_WOOD, "Wood Rolling Pin");

        translationBuilder.add(UbesDelightItemsImpl.UBE_CRATE, "Ube Crate");
        translationBuilder.add(UbesDelightItemsImpl.GARLIC_CRATE, "Garlic Crate");
        translationBuilder.add(UbesDelightItemsImpl.GINGER_CRATE, "Ginger Crate");
        translationBuilder.add(UbesDelightItemsImpl.LEMONGRASS_CRATE, "Lemongrass Crate");

        translationBuilder.add(UbesDelightItemsImpl.WILD_UBE, "Wild Ube");
        translationBuilder.add(UbesDelightItemsImpl.WILD_GARLIC, "Wild Garlic");
        translationBuilder.add(UbesDelightItemsImpl.WILD_GINGER, "Wild Ginger");
        translationBuilder.add(UbesDelightItemsImpl.WILD_LEMONGRASS, "Wild Lemongrass");

        translationBuilder.add(UbesDelightItemsImpl.SINANGAG, "Sinangag");
        translationBuilder.add(UbesDelightItemsImpl.KINILAW, "Kinilaw");
        translationBuilder.add(UbesDelightItemsImpl.LUMPIA, "Lumpia");
        translationBuilder.add(UbesDelightItemsImpl.TOCINO, "Tocino");
        translationBuilder.add(UbesDelightItemsImpl.CHICKEN_INASAL, "Chicken Inasal");

        translationBuilder.add(UbesDelightItemsImpl.CHICKEN_INASAL_RICE, "Chicken Inasal Plate");
        translationBuilder.add(UbesDelightItemsImpl.TOSILOG, "Tosilog");
        translationBuilder.add(UbesDelightItemsImpl.BANGSILOG, "Bangsilog");
        translationBuilder.add(UbesDelightItemsImpl.SISIG, "Sisig");
        translationBuilder.add(UbesDelightItemsImpl.BULALO, "Bulalo");
        translationBuilder.add(UbesDelightItemsImpl.ARROZ_CALDO, "Arroz Caldo");
        translationBuilder.add(UbesDelightItemsImpl.MECHADO, "Mechado");

        translationBuilder.add(UbesDelightItemsImpl.POISONOUS_UBE, "Poisonous Ube");
        translationBuilder.add(UbesDelightItemsImpl.UBE, "Ube");
        translationBuilder.add(UbesDelightItemsImpl.GARLIC, "Garlic");
        translationBuilder.add(UbesDelightItemsImpl.GINGER, "Ginger");
        translationBuilder.add(UbesDelightItemsImpl.LEMONGRASS, "Lemongrass");
        translationBuilder.add(UbesDelightItemsImpl.LEMONGRASS_SEEDS, "Lemongrass Seeds");

        translationBuilder.add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE, "Condensed Milk Bottle");
        translationBuilder.add(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE, "Fish Sauce Bottle");
        translationBuilder.add(UbesDelightItemsImpl.MILK_POWDER, "Milk Powder");
        translationBuilder.add(UbesDelightItemsImpl.SUGAR_BROWN, "Brown Sugar");
        translationBuilder.add(UbesDelightItemsImpl.LUMPIA_WRAPPER, "Lumpia Wrapper");

        translationBuilder.add(UbesDelightItemsImpl.MILK_TEA_UBE, "Ube Milk Tea");

        translationBuilder.add(UbesDelightItemsImpl.GARLIC_CHOP, "Chopped Garlic");
        translationBuilder.add(UbesDelightItemsImpl.GINGER_CHOP, "Chopped Ginger");

        translationBuilder.add(UbesDelightItemsImpl.LECHE_FLAN, "Leche Flan Slice");
        translationBuilder.add(UbesDelightItemsImpl.COOKIE_UBE, "Ube Cookie");
        translationBuilder.add(UbesDelightItemsImpl.COOKIE_GINGER, "Ginger Cookie");

        translationBuilder.add(UbesDelightItemsImpl.POLVORONE, "Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_PINIPIG, "Pinipig Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_UBE, "Ube Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_CC, "Cookies and Cream Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.RAW_POLVORONE, "Raw Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG, "Raw Pinipig Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.RAW_POLVORONE_UBE, "Raw Ube Polvorone");
        translationBuilder.add(UbesDelightItemsImpl.RAW_POLVORONE_CC, "Raw Cookies and Cream Polvorone");

        translationBuilder.add(UbesDelightItemsImpl.LECHE_FLAN_FEAST, "Leche Flan");
        translationBuilder.add(UbesDelightItemsImpl.HALO_HALO_FEAST, "Bowl of Halo Halo");
        translationBuilder.add(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST, "Bowl of Ube Milk Tea");
        translationBuilder.add(UbesDelightItemsImpl.LUMPIA_FEAST, "Lumpia Platter");

        translationBuilder.add(UbesDelightItemsImpl.UBE_CAKE, "Ube Cake");
        translationBuilder.add(UbesDelightItemsImpl.UBE_CAKE_SLICE, "Ube Cake Slice");

        translationBuilder.add(UbesDelightItemsImpl.PANDESAL, "Pandesal");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_UBE, "Ube Pandesal");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA, "Ensaymada");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE, "Ube Ensaymada");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_MUNGGO, "Hopia Munggo");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_UBE, "Hopia Ube");

        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_STAGE0, "Pandesal Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_STAGE1, "Pandesal Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_STAGE2, "Pandesal Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_RAW, "Raw Pandesal");

        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_UBE_STAGE0, "Ube Pandesal Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_UBE_STAGE1, "Ube Pandesal Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_UBE_STAGE2, "Ube Pandesal Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.PANDESAL_UBE_RAW, "Raw Ube Pandesal");

        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_STAGE0, "Ensaymada Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_STAGE1, "Ensaymada Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_STAGE2, "Ensaymada Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_STAGE3, "Ensaymada Stage 3");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_RAW, "Raw Ensaymada");

        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE0, "Ube Ensaymada Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE1, "Ube Ensaymada Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE2, "Ube Ensaymada Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE3, "Ube Ensaymada Stage 3");
        translationBuilder.add(UbesDelightItemsImpl.ENSAYMADA_UBE_RAW, "Raw Ube Ensaymada");

        translationBuilder.add(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE0, "Hopia Munggo Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE1, "Hopia Munggo Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE2, "Hopia Munggo Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_MUNGGO_RAW, "Raw Hopia Munggo");

        translationBuilder.add(UbesDelightItemsImpl.HOPIA_UBE_STAGE0, "Hopia Ube Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_UBE_STAGE1, "Hopia Ube Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_UBE_STAGE2, "Hopia Ube Stage 2");
        translationBuilder.add(UbesDelightItemsImpl.HOPIA_UBE_RAW, "Raw Hopia Ube");

        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_STAGE0, "Polvorone Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_STAGE1, "Polvorone Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_STAGE2, "Polvorone Stage 2");

        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE0, "Pinipig Polvorone Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE1, "Pinipig Polvorone Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE2, "Pinipig Polvorone Stage 2");

        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_UBE_STAGE0, "Ube Polvorone Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_UBE_STAGE1, "Ube Polvorone Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_UBE_STAGE2, "Ube Polvorone Stage 2");

        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_CC_STAGE0, "Cookies and Cream Polvorone Stage 0");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_CC_STAGE1, "Cookies and Cream Polvorone Stage 1");
        translationBuilder.add(UbesDelightItemsImpl.POLVORONE_CC_STAGE2, "Cookies and Cream Polvorone Stage 2");

        translationBuilder.add(UbesDelightBlocksImpl.UBE_CROP, "Ube Crop");
        translationBuilder.add(UbesDelightBlocksImpl.GARLIC_CROP, "Garlic Crop");
        translationBuilder.add(UbesDelightBlocksImpl.GINGER_CROP, "Ginger Crop");

        translationBuilder.add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP, "Lemongrass Stalk");
        translationBuilder.add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP, "Lemongrass Leaves");

        translationBuilder.add(UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO, "Halo Halo");

        translationBuilder.add(ADVANCEMENT + "root", FORMATTED_MOD_ID);
        translationBuilder.add(ADVANCEMENT + "root.desc", "Cuisine from the Phillipines!");

        translationBuilder.add(ADVANCEMENT + "craft_rolling_pin", "Rolling Pin");
        translationBuilder.add(ADVANCEMENT + "craft_rolling_pin.desc", "Use sticks and a fence to make a new tool for the kitchen");

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

        translationBuilder.add("tag.item.c.food_wrappers", "Food Wrappers");
        translationBuilder.add("tag.item.c.food_wrappers.lumpia_wrappers", "Lumpia Wrappers");
    }
}
