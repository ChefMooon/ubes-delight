package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class TranslationGenerator extends FabricLanguageProvider {
    protected TranslationGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        String MOD_ID = UbesDelightMod.MOD_ID;

        translationBuilder.add(UbesDelightMod.ITEM_GROUP, "Ube's Delight");
        translationBuilder.add(MOD_ID + ".container."+ItemsRegistry.HALO_HALO_FEAST.get(), "Glass Bottle Required.");

        translationBuilder.add(MOD_ID + ".tooltip."+ItemsRegistry.KALAN.get(), "Traditional Filipino Clay Oven.");
        translationBuilder.add(MOD_ID + ".tooltip.knife", "Knife Required.");

        translationBuilder.add(MOD_ID + ".tooltip.baking_mat.invalid_item", "Invalid Items");
        translationBuilder.add(MOD_ID + ".tooltip.baking_mat.invalid_tool", "Invalid Tool");

        translationBuilder.add(ItemsRegistry.KALAN.get(), "Kalan");
        translationBuilder.add(ItemsRegistry.BAKING_MAT_BAMBOO.get(), "Bamboo Baking Mat");

        translationBuilder.add(ItemsRegistry.ROLLING_PIN_WOOD.get(), "Wood Rolling Pin");

        translationBuilder.add(ItemsRegistry.UBE_CRATE.get(), "Ube Crate");
        translationBuilder.add(ItemsRegistry.GARLIC_CRATE.get(), "Garlic Crate");
        translationBuilder.add(ItemsRegistry.GINGER_CRATE.get(), "Ginger Crate");
        translationBuilder.add(ItemsRegistry.LEMONGRASS_CRATE.get(), "Lemongrass Crate");

        translationBuilder.add(ItemsRegistry.WILD_UBE.get(), "Wild Ube");
        translationBuilder.add(ItemsRegistry.WILD_GARLIC.get(), "Wild Garlic");
        translationBuilder.add(ItemsRegistry.WILD_GINGER.get(), "Wild Ginger");
        translationBuilder.add(ItemsRegistry.WILD_LEMONGRASS.get(), "Wild Lemongrass");

        translationBuilder.add(ItemsRegistry.SINANGAG.get(), "Sinangag");
        translationBuilder.add(ItemsRegistry.KINILAW.get(), "Kinilaw");
        translationBuilder.add(ItemsRegistry.LUMPIA.get(), "Lumpia");
        translationBuilder.add(ItemsRegistry.TOCINO.get(), "Tocino");
        translationBuilder.add(ItemsRegistry.CHICKEN_INASAL.get(), "Chicken Inasal");

        translationBuilder.add(ItemsRegistry.CHICKEN_INASAL_RICE.get(), "Chicken Inasal Plate");
        translationBuilder.add(ItemsRegistry.TOSILOG.get(), "Tosilog");
        translationBuilder.add(ItemsRegistry.BANGSILOG.get(), "Bangsilog");
        translationBuilder.add(ItemsRegistry.SISIG.get(), "Sisig");
        translationBuilder.add(ItemsRegistry.BULALO.get(), "Bulalo");
        translationBuilder.add(ItemsRegistry.ARROZ_CALDO.get(), "Arroz Caldo");
        translationBuilder.add(ItemsRegistry.MECHADO.get(), "Mechado");

        translationBuilder.add(ItemsRegistry.POISONOUS_UBE.get(), "Poisonous Ube");
        translationBuilder.add(ItemsRegistry.UBE.get(), "Ube");
        translationBuilder.add(ItemsRegistry.GARLIC.get(), "Garlic");
        translationBuilder.add(ItemsRegistry.GINGER.get(), "Ginger");
        translationBuilder.add(ItemsRegistry.LEMONGRASS.get(), "Lemongrass");
        translationBuilder.add(ItemsRegistry.LEMONGRASS_SEEDS.get(), "Lemongrass Seeds");

        translationBuilder.add(ItemsRegistry.CONDENSED_MILK_BOTTLE.get(), "Condensed Milk Bottle");
        translationBuilder.add(ItemsRegistry.FISH_SAUCE_BOTTLE.get(), "Fish Sauce Bottle");
        translationBuilder.add(ItemsRegistry.MILK_POWDER.get(), "Milk Powder");
        translationBuilder.add(ItemsRegistry.SUGAR_BROWN.get(), "Brown Sugar");
        translationBuilder.add(ItemsRegistry.LUMPIA_WRAPPER.get(), "Lumpia Wrapper");

        translationBuilder.add(ItemsRegistry.MILK_TEA_UBE.get(), "Ube Milk Tea");

        translationBuilder.add(ItemsRegistry.GARLIC_CHOP.get(), "Chopped Garlic");
        translationBuilder.add(ItemsRegistry.GINGER_CHOP.get(), "Chopped Ginger");

        translationBuilder.add(ItemsRegistry.LECHE_FLAN.get(), "Leche Flan Slice");
        translationBuilder.add(ItemsRegistry.COOKIE_UBE.get(), "Ube Cookie");
        translationBuilder.add(ItemsRegistry.COOKIE_GINGER.get(), "Ginger Cookie");

        translationBuilder.add(ItemsRegistry.POLVORONE.get(), "Polvorone");
        translationBuilder.add(ItemsRegistry.POLVORONE_PINIPIG.get(), "Pinipig Polvorone");
        translationBuilder.add(ItemsRegistry.POLVORONE_UBE.get(), "Ube Polvorone");
        translationBuilder.add(ItemsRegistry.POLVORONE_CC.get(), "Cookies and Cream Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE.get(), "Raw Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE_PINIPIG.get(), "Raw Pinipig Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE_UBE.get(), "Raw Ube Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE_CC.get(), "Raw Cookies and Cream Polvorone");

        translationBuilder.add(ItemsRegistry.LECHE_FLAN_FEAST.get(), "Leche Flan");
        translationBuilder.add(ItemsRegistry.HALO_HALO_FEAST.get(), "Bowl of Halo Halo");
        translationBuilder.add(ItemsRegistry.MILK_TEA_UBE_FEAST.get(), "Bowl of Ube Milk Tea");
        translationBuilder.add(ItemsRegistry.LUMPIA_FEAST.get(), "Lumpia Platter");

        translationBuilder.add(ItemsRegistry.UBE_CAKE.get(), "Ube Cake");
        translationBuilder.add(ItemsRegistry.UBE_CAKE_SLICE.get(), "Ube Cake Slice");

        translationBuilder.add(ItemsRegistry.PANDESAL.get(), "Pandesal");
        translationBuilder.add(ItemsRegistry.PANDESAL_UBE.get(), "Ube Pandesal");
        translationBuilder.add(ItemsRegistry.ENSAYMADA.get(), "Ensaymada");
        translationBuilder.add(ItemsRegistry.ENSAYMADA_UBE.get(), "Ube Ensaymada");
        translationBuilder.add(ItemsRegistry.HOPIA_MUNGGO.get(), "Hopia Munggo");
        translationBuilder.add(ItemsRegistry.HOPIA_UBE.get(), "Hopia Ube");

        translationBuilder.add(ItemsRegistry.PANDESAL_STAGE0.get(), "Pandesal Stage 0");
        translationBuilder.add(ItemsRegistry.PANDESAL_STAGE1.get(), "Pandesal Stage 1");
        translationBuilder.add(ItemsRegistry.PANDESAL_STAGE2.get(), "Pandesal Stage 2");
        translationBuilder.add(ItemsRegistry.PANDESAL_RAW.get(), "Raw Pandesal");

        translationBuilder.add(ItemsRegistry.PANDESAL_UBE_STAGE0.get(), "Ube Pandesal Stage 0");
        translationBuilder.add(ItemsRegistry.PANDESAL_UBE_STAGE1.get(), "Ube Pandesal Stage 1");
        translationBuilder.add(ItemsRegistry.PANDESAL_UBE_STAGE2.get(), "Ube Pandesal Stage 2");
        translationBuilder.add(ItemsRegistry.PANDESAL_UBE_RAW.get(), "Raw Ube Pandesal");

        translationBuilder.add(ItemsRegistry.ENSAYMADA_STAGE0.get(), "Ensaymada Stage 0");
        translationBuilder.add(ItemsRegistry.ENSAYMADA_STAGE1.get(), "Ensaymada Stage 1");
        translationBuilder.add(ItemsRegistry.ENSAYMADA_STAGE2.get(), "Ensaymada Stage 2");
        translationBuilder.add(ItemsRegistry.ENSAYMADA_STAGE3.get(), "Ensaymada Stage 3");
        translationBuilder.add(ItemsRegistry.ENSAYMADA_RAW.get(), "Raw Ensaymada");

        translationBuilder.add(ItemsRegistry.ENSAYMADA_UBE_STAGE0.get(), "Ube Ensaymada Stage 0");
        translationBuilder.add(ItemsRegistry.ENSAYMADA_UBE_STAGE1.get(), "Ube Ensaymada Stage 1");
        translationBuilder.add(ItemsRegistry.ENSAYMADA_UBE_STAGE2.get(), "Ube Ensaymada Stage 2");
        translationBuilder.add(ItemsRegistry.ENSAYMADA_UBE_STAGE3.get(), "Ube Ensaymada Stage 3");
        translationBuilder.add(ItemsRegistry.ENSAYMADA_UBE_RAW.get(), "Raw Ube Ensaymada");

        translationBuilder.add(ItemsRegistry.HOPIA_MUNGGO_STAGE0.get(), "Hopia Munggo Stage 0");
        translationBuilder.add(ItemsRegistry.HOPIA_MUNGGO_STAGE1.get(), "Hopia Munggo Stage 1");
        translationBuilder.add(ItemsRegistry.HOPIA_MUNGGO_STAGE2.get(), "Hopia Munggo Stage 2");
        translationBuilder.add(ItemsRegistry.HOPIA_MUNGGO_RAW.get(), "Raw Hopia Munggo");

        translationBuilder.add(ItemsRegistry.HOPIA_UBE_STAGE0.get(), "Hopia Ube Stage 0");
        translationBuilder.add(ItemsRegistry.HOPIA_UBE_STAGE1.get(), "Hopia Ube Stage 1");
        translationBuilder.add(ItemsRegistry.HOPIA_UBE_STAGE2.get(), "Hopia Ube Stage 2");
        translationBuilder.add(ItemsRegistry.HOPIA_UBE_RAW.get(), "Raw Hopia Ube");

        translationBuilder.add(ItemsRegistry.POLVORONE_STAGE0.get(), "Polvorone Stage 0");
        translationBuilder.add(ItemsRegistry.POLVORONE_STAGE1.get(), "Polvorone Stage 1");
        translationBuilder.add(ItemsRegistry.POLVORONE_STAGE2.get(), "Polvorone Stage 2");

        translationBuilder.add(ItemsRegistry.POLVORONE_PINIPIG_STAGE0.get(), "Pinipig Polvorone Stage 0");
        translationBuilder.add(ItemsRegistry.POLVORONE_PINIPIG_STAGE1.get(), "Pinipig Polvorone Stage 1");
        translationBuilder.add(ItemsRegistry.POLVORONE_PINIPIG_STAGE2.get(), "Pinipig Polvorone Stage 2");

        translationBuilder.add(ItemsRegistry.POLVORONE_UBE_STAGE0.get(), "Ube Polvorone Stage 0");
        translationBuilder.add(ItemsRegistry.POLVORONE_UBE_STAGE1.get(), "Ube Polvorone Stage 1");
        translationBuilder.add(ItemsRegistry.POLVORONE_UBE_STAGE2.get(), "Ube Polvorone Stage 2");

        translationBuilder.add(ItemsRegistry.POLVORONE_CC_STAGE0.get(), "Cookies and Cream Polvorone Stage 0");
        translationBuilder.add(ItemsRegistry.POLVORONE_CC_STAGE1.get(), "Cookies and Cream Polvorone Stage 1");
        translationBuilder.add(ItemsRegistry.POLVORONE_CC_STAGE2.get(), "Cookies and Cream Polvorone Stage 2");

        translationBuilder.add(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "Lemongrass Stalk");
        translationBuilder.add(BlocksRegistry.LEMONGRASS_LEAF_CROP.get(), "Lemongrass Leaves");

        translationBuilder.add(BlocksRegistry.GLASS_CUP_HALO_HALO.get(), "Halo Halo");

        translationBuilder.add(MOD_ID + ".advancement.root", "Ube's Delight");
        translationBuilder.add(MOD_ID + ".advancement.root.desc", "Cuisine from the Phillipines");

        translationBuilder.add(MOD_ID + ".advancement.craft_rolling_pin", "Rolling Pin");
        translationBuilder.add(MOD_ID + ".advancement.craft_rolling_pin.desc", "Use sticks and a fence to make a new tool for the kitchen");

        translationBuilder.add(MOD_ID + ".advancement.craft_baking_mat", "Baking Mat");
        translationBuilder.add(MOD_ID + ".advancement.craft_baking_mat.desc", "Surround honeycomb with bamboo to craft a Baking Mat");

        translationBuilder.add(MOD_ID + ".advancement.use_baking_mat", "Ube's Baking");
        translationBuilder.add(MOD_ID + ".advancement.use_baking_mat.desc", "Add baking ingredients to the Baking Mat then use the Rolling Pin to craft baked goods in a new way!");

        translationBuilder.add(MOD_ID + ".advancement.place_drinkable_feast", "Punch Bowl");
        translationBuilder.add(MOD_ID + ".advancement.place_drinkable_feast.desc", "Drinks can be combined and placed. Grab a bottle and have a sip!");

        translationBuilder.add(MOD_ID + ".advancement.place_kalan", "Take the Kitchen Outside!");
        translationBuilder.add(MOD_ID + ".advancement.place_kalan.desc", "The Kalan is a traditional Filipino terracotta stove. Perfect for an outdoor kitchen!");

        translationBuilder.add(MOD_ID + ".advancement.ube_master", "Ube Enthusiast");
        translationBuilder.add(MOD_ID + ".advancement.ube_master.desc", "Eat every Ube specific dish");

        translationBuilder.add(MOD_ID + ".advancement.ud_master", "Ube's Delight Master");
        translationBuilder.add(MOD_ID + ".advancement.ud_master.desc", "Try all the new food and drink items from Ube's Delight");

        translationBuilder.add(MOD_ID + ".advancement.master_baker", "Master Baker");
        translationBuilder.add(MOD_ID + ".advancement.master_baker.desc", "Craft all varieties of Filipino bread!");

        translationBuilder.add(MOD_ID + ".advancement.plant_all_crops", "Master Farmer of the Tropics");
        translationBuilder.add(MOD_ID + ".advancement.plant_all_crops.desc", "Cultivate every new crop found in the Jungle!");

        translationBuilder.add(MOD_ID + ".advancement.get_ud_seed", "Crops of the Tropics");
        translationBuilder.add(MOD_ID + ".advancement.get_ud_seed.desc", "Adventure to find four new crops, only found in jungles and some village chests.");

        translationBuilder.add(MOD_ID + ".subtitles.block_baking_mat.add", "Item added");
        translationBuilder.add(MOD_ID + ".subtitles.block_baking_mat.remove", "Item Removed");
        translationBuilder.add(MOD_ID + ".subtitles.block_baking_mat.rolling_pin", "Rolling Pin rolls");

        translationBuilder.add(MOD_ID + ".subtitles.block_drinkable_feast.add", "Drink Added");
        translationBuilder.add(MOD_ID + ".subtitles.block_drinkable_feast.remove", "Drink Removed");

        translationBuilder.add(MOD_ID + ".subtitles.block_lumpia_feast.remove", "Lumpia Removed");

        translationBuilder.add(MOD_ID + ".modmenu.title", "Ube's Delight Config");
        translationBuilder.add(MOD_ID + ".modmenu.title.gamesettings", "Game settings");

        translationBuilder.add(MOD_ID + ".modmenu.option.enableudcropcrates", "Enable UD Crop Crates");
        translationBuilder.add(MOD_ID + ".modmenu.option.farmersbuyudcrops", "Farmers Buy UD Crops");
        translationBuilder.add(MOD_ID + ".modmenu.option.wanderingtradersellsuditems", "Wandering Trader Sells UD Items");

        translationBuilder.add(MOD_ID + ".modmenu.tooltip.enableudcropcrates", "Ube's Delight adds crates (3x3) for vanilla crops, similar to Farmer's Delight. Should they be craftable? Requires Reload.");
        translationBuilder.add(MOD_ID + ".modmenu.tooltip.farmersbuyudcrops", "Should Novice and Apprentice Farmers buy this mod's crops? (May reduce chances of other trades appearing)");
        translationBuilder.add(MOD_ID + ".modmenu.tooltip.wanderingtradersellsuditems", "Should the Wandering Trader sell some of this mod's items? (Crop Seeds Only)");

        translationBuilder.add(MOD_ID + ".modmenu.title.worldgeneration", "World generation");

        translationBuilder.add(MOD_ID + ".modmenu.category.wildubegen", "Wild Ube Generation");
        translationBuilder.add(MOD_ID + ".modmenu.category.wildgarlicgen", "Wild Garlic Generation");
        translationBuilder.add(MOD_ID + ".modmenu.category.wildgingergen", "Wild Ginger Generation");
        translationBuilder.add(MOD_ID + ".modmenu.category.wildlemongrassgen", "Wild Lemongrass Generation");

        translationBuilder.add(MOD_ID + ".modmenu.option.wildgen", "Generation");
        translationBuilder.add(MOD_ID + ".modmenu.option.generateUDChestLoot", "Generate UD Chest Loot");

        translationBuilder.add(MOD_ID + ".modmenu.tooltip.wildubegen", "Generate wild ube in jungles?");
        translationBuilder.add(MOD_ID + ".modmenu.tooltip.wildgarlicgen", "Generate wild garlic in jungles?");
        translationBuilder.add(MOD_ID + ".modmenu.tooltip.wildgingergen", "Generate wild ginger in jungles?");
        translationBuilder.add(MOD_ID + ".modmenu.tooltip.wildlemongrassgen", "Generate wild lemongrass in jungles?");
        translationBuilder.add(MOD_ID + ".modmenu.tooltip.generateUDChestLoot", "Should this mod add its seeds as extra chest loot across Minecraft?");

        translationBuilder.add(MOD_ID + ".modmenu.title.clientsettings", "Client Settings");

        translationBuilder.add(MOD_ID + ".modmenu.option.foodEffectTooltip", "Food Effect Tooltip");
        translationBuilder.add(MOD_ID + ".modmenu.tooltip.foodEffectTooltip", "Should meal and drink tooltips display which effects they provide?");

        translationBuilder.add(MOD_ID + ".modmenu.title.integration", "Integration");

        translationBuilder.add(MOD_ID + ".modmenu.option.enableGarlicCompat", "Garlic Extra Compatibility");
        translationBuilder.add(MOD_ID + ".modmenu.option.enableGingerCompat", "Ginger Extra Compatibility");

        translationBuilder.add(MOD_ID + ".modmenu.tooltip.enableGarlicCompat", "This allows all c:crops/garlic to be chopped into Chopped Garlic?");
        translationBuilder.add(MOD_ID + ".modmenu.tooltip.enableGingerCompat", "This allows all c:crops/ginger to be chopped into Chopped Ginger?");

        translationBuilder.add(MOD_ID + ".rei.baking_mat", "Baking Mat");
        translationBuilder.add(MOD_ID + ".rei.chance", "%1$s%% chance");

        translationBuilder.add(MOD_ID + ".rei.info.rolling_pin", "Explain Rolling Pin");
    }
}
