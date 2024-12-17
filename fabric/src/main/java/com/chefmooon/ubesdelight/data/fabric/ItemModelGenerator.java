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

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POISONOUS_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.GARLIC, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.GINGER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LEMONGRASS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LEMONGRASS_SEEDS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.SINANGAG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.KINILAW, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LUMPIA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.TOCINO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.CHICKEN_INASAL, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.CHICKEN_INASAL_RICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.TOSILOG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.BANGSILOG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.SISIG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.BULALO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ARROZ_CALDO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.MECHADO, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.MILK_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.SUGAR_BROWN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LUMPIA_WRAPPER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.MILK_TEA_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HALO_HALO, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.GARLIC_CHOP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.GINGER_CHOP, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.COOKIE_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.COOKIE_GINGER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE_CC, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HALO_HALO_FEAST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LUMPIA_FEAST, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LECHE_FLAN_FEAST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LECHE_FLAN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.UBE_CAKE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.UBE_CAKE_SLICE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE3, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE3, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC_STAGE2, ModelTemplates.FLAT_ITEM);
    }

    private static void generateRollingPinItem(Item item) {
        UbesDelightModels.TEMPLATE_ROLLING_PIN_3D.create(ModelLocationUtils.getModelLocation(item),
                new TextureMapping().put(TextureSlot.CONTENT, ModelLocationUtils.getModelLocation(item, "_3d")),
                GENERATOR.output);
    }
}