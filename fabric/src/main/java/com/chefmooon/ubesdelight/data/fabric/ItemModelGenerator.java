package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.utility.fabric.UbesDelightModels;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.world.item.Item;

public class ItemModelGenerator {
    private static ItemModelGenerators GENERATOR;
    public static void generateItemModels(ItemModelGenerators itemModelGenerator) {
        GENERATOR = itemModelGenerator;

        generateRollingPinItem(UbesDelightItemsImpl.ROLLING_PIN_WOOD);
        generateRollingPinItem(UbesDelightItemsImpl.ROLLING_PIN_IRON);
        generateRollingPinItem(UbesDelightItemsImpl.ROLLING_PIN_GOLD);
        generateRollingPinItem(UbesDelightItemsImpl.ROLLING_PIN_DIAMOND);
        generateRollingPinItem(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE);

        generateFlatItem(UbesDelightItemsImpl.POISONOUS_UBE);
        generateFlatItem(UbesDelightItemsImpl.UBE);
        generateFlatItem(UbesDelightItemsImpl.GARLIC);
        generateFlatItem(UbesDelightItemsImpl.GINGER);
        generateFlatItem(UbesDelightItemsImpl.LEMONGRASS);
        generateFlatItem(UbesDelightItemsImpl.LEMONGRASS_SEEDS);

        generateFlatItem(UbesDelightItemsImpl.SINANGAG);
        generateFlatItem(UbesDelightItemsImpl.KINILAW);
        generateFlatItem(UbesDelightItemsImpl.LUMPIA);
        generateFlatItem(UbesDelightItemsImpl.TOCINO);
        generateFlatItem(UbesDelightItemsImpl.CHICKEN_INASAL);

        generateFlatItem(UbesDelightItemsImpl.CHICKEN_INASAL_RICE);
        generateFlatItem(UbesDelightItemsImpl.TOSILOG);
        generateFlatItem(UbesDelightItemsImpl.BANGSILOG);
        generateFlatItem(UbesDelightItemsImpl.SISIG);
        generateFlatItem(UbesDelightItemsImpl.BULALO);
        generateFlatItem(UbesDelightItemsImpl.ARROZ_CALDO);
        generateFlatItem(UbesDelightItemsImpl.MECHADO);

        generateFlatItem(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE);
        generateFlatItem(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE);
        generateFlatItem(UbesDelightItemsImpl.MILK_POWDER);
        generateFlatItem(UbesDelightItemsImpl.SUGAR_BROWN);
        generateFlatItem(UbesDelightItemsImpl.LUMPIA_WRAPPER);

        generateFlatItem(UbesDelightItemsImpl.MILK_TEA_UBE);
        generateFlatItem(UbesDelightItemsImpl.HALO_HALO);

        generateFlatItem(UbesDelightItemsImpl.GARLIC_CHOP);
        generateFlatItem(UbesDelightItemsImpl.GINGER_CHOP);

        generateFlatItem(UbesDelightItemsImpl.COOKIE_UBE);
        generateFlatItem(UbesDelightItemsImpl.COOKIE_GINGER);

        generateFlatItem(UbesDelightItemsImpl.POLVORONE);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC);
        generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE);
        generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG);
        generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE_UBE);
        generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE_CC);

        generateFlatItem(UbesDelightItemsImpl.HALO_HALO_FEAST);
        generateFlatItem(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST);
        generateFlatHandheldItemFlipped(UbesDelightItemsImpl.LUMPIA_FEAST);

        generateFlatHandheldItemFlipped(UbesDelightItemsImpl.LEAF_FEAST);
        generateFlatHandheldItemFlipped(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA);
        generateFlatHandheldItemFlipped(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE);
        generateFlatHandheldItemFlipped(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL);
        generateFlatHandheldItemFlipped(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE);
        generateFlatHandheldItemFlipped(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO);
        generateFlatHandheldItemFlipped(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE);

        generateFlatItem(UbesDelightItemsImpl.LECHE_FLAN_FEAST);
        generateFlatItem(UbesDelightItemsImpl.LECHE_FLAN);
        generateFlatItem(UbesDelightItemsImpl.UBE_CAKE);
        generateFlatItem(UbesDelightItemsImpl.UBE_CAKE_SLICE);

        generateFlatItem(UbesDelightItemsImpl.PANDESAL);
        generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE);
        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA);
        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE);
        generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO);
        generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE);

        generateFlatItem(UbesDelightItemsImpl.PANDESAL_STAGE0);
        generateFlatItem(UbesDelightItemsImpl.PANDESAL_STAGE1);
        generateFlatItem(UbesDelightItemsImpl.PANDESAL_STAGE2);
        generateFlatItem(UbesDelightItemsImpl.PANDESAL_RAW);

        generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_STAGE0);
        generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_STAGE1);
        generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_STAGE2);
        generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_RAW);

        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE0);
        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE1);
        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE2);
        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE3);
        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_RAW);

        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE0);
        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE1);
        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE2);
        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE3);
        generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_RAW);

        generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE0);
        generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE1);
        generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE2);
        generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_RAW);

        generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_STAGE0);
        generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_STAGE1);
        generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_STAGE2);
        generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_RAW);

        generateFlatItem(UbesDelightItemsImpl.POLVORONE_STAGE0);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_STAGE1);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_STAGE2);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE0);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE1);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE2);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE_STAGE0);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE_STAGE1);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE_STAGE2);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC_STAGE0);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC_STAGE1);
        generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC_STAGE2);
    }

    private static void generateFlatItem(Item item) {
        GENERATOR.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
    }

    private static void generateFlatHandheldItemFlipped(Item item) {
        GENERATOR.generateFlatItem(item, UbesDelightModels.FLAT_HANDHELD_ITEM_FLIPPED);
    }

    private static void generateRollingPinItem(Item item) {
        UbesDelightModels.TEMPLATE_ROLLING_PIN_3D.create(ModelLocationUtils.getModelLocation(item),
                new TextureMapping().put(TextureSlot.CONTENT, ModelLocationUtils.getModelLocation(item, "_3d")),
                GENERATOR.output);
    }
}
