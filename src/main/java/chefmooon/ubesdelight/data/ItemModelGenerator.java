package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.utility.UbesDelightModels;
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

        generateRollingPinItem(UbesDelightItems.ROLLING_PIN_WOOD.get());
        generateRollingPinItem(UbesDelightItems.ROLLING_PIN_IRON.get());
        generateRollingPinItem(UbesDelightItems.ROLLING_PIN_GOLD.get());
        generateRollingPinItem(UbesDelightItems.ROLLING_PIN_DIAMOND.get());
        generateRollingPinItem(UbesDelightItems.ROLLING_PIN_NETHERITE.get());

        generateFlatItem(UbesDelightItems.POISONOUS_UBE.get());
        generateFlatItem(UbesDelightItems.UBE.get());
        generateFlatItem(UbesDelightItems.GARLIC.get());
        generateFlatItem(UbesDelightItems.GINGER.get());
        generateFlatItem(UbesDelightItems.LEMONGRASS.get());
        generateFlatItem(UbesDelightItems.LEMONGRASS_SEEDS.get());

        generateFlatItem(UbesDelightItems.SINANGAG.get());
        generateFlatItem(UbesDelightItems.KINILAW.get());
        generateFlatItem(UbesDelightItems.LUMPIA.get());
        generateFlatItem(UbesDelightItems.TOCINO.get());
        generateFlatItem(UbesDelightItems.CHICKEN_INASAL.get());

        generateFlatItem(UbesDelightItems.CHICKEN_INASAL_RICE.get());
        generateFlatItem(UbesDelightItems.TOSILOG.get());
        generateFlatItem(UbesDelightItems.BANGSILOG.get());
        generateFlatItem(UbesDelightItems.SISIG.get());
        generateFlatItem(UbesDelightItems.BULALO.get());
        generateFlatItem(UbesDelightItems.ARROZ_CALDO.get());
        generateFlatItem(UbesDelightItems.MECHADO.get());

        generateFlatItem(UbesDelightItems.CONDENSED_MILK_BOTTLE.get());
        generateFlatItem(UbesDelightItems.FISH_SAUCE_BOTTLE.get());
        generateFlatItem(UbesDelightItems.MILK_POWDER.get());
        generateFlatItem(UbesDelightItems.SUGAR_BROWN.get());
        generateFlatItem(UbesDelightItems.LUMPIA_WRAPPER.get());

        generateFlatItem(UbesDelightItems.MILK_TEA_UBE.get());
        generateFlatItem(UbesDelightItems.HALO_HALO.get());

        generateFlatItem(UbesDelightItems.GARLIC_CHOP.get());
        generateFlatItem(UbesDelightItems.GINGER_CHOP.get());

        generateFlatItem(UbesDelightItems.COOKIE_UBE.get());
        generateFlatItem(UbesDelightItems.COOKIE_GINGER.get());

        generateFlatItem(UbesDelightItems.POLVORONE.get());
        generateFlatItem(UbesDelightItems.POLVORONE_PINIPIG.get());
        generateFlatItem(UbesDelightItems.POLVORONE_UBE.get());
        generateFlatItem(UbesDelightItems.POLVORONE_CC.get());
        generateFlatItem(UbesDelightItems.RAW_POLVORONE.get());
        generateFlatItem(UbesDelightItems.RAW_POLVORONE_PINIPIG.get());
        generateFlatItem(UbesDelightItems.RAW_POLVORONE_UBE.get());
        generateFlatItem(UbesDelightItems.RAW_POLVORONE_CC.get());

        generateFlatItem(UbesDelightItems.HALO_HALO_FEAST.get());
        generateFlatItem(UbesDelightItems.MILK_TEA_UBE_FEAST.get());

        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LUMPIA_FEAST.get());

        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_ENSAYMADA.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_ENSAYMADA_HALF.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE_HALF.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_PANDESAL.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_PANDESAL_HALF.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE_HALF.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO_HALF.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_HOPIA_UBE.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_HOPIA_UBE_HALF.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_COOKED_RICE.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_COOKED_RICE_HALF.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_FRIED_RICE.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_FRIED_RICE_HALF.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_SINANGAG.get());
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_SINANGAG_HALF.get());

        generateFlatItem(UbesDelightItems.LECHE_FLAN_FEAST.get());
        generateFlatItem(UbesDelightItems.LECHE_FLAN.get());
        generateFlatItem(UbesDelightItems.UBE_CAKE.get());
        generateFlatItem(UbesDelightItems.UBE_CAKE_SLICE.get());

        generateFlatItem(UbesDelightItems.PANDESAL.get());
        generateFlatItem(UbesDelightItems.PANDESAL_UBE.get());
        generateFlatItem(UbesDelightItems.ENSAYMADA.get());
        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE.get());
        generateFlatItem(UbesDelightItems.HOPIA_MUNGGO.get());
        generateFlatItem(UbesDelightItems.HOPIA_UBE.get());

        generateFlatItem(UbesDelightItems.PANDESAL_STAGE0.get());
        generateFlatItem(UbesDelightItems.PANDESAL_STAGE1.get());
        generateFlatItem(UbesDelightItems.PANDESAL_STAGE2.get());
        generateFlatItem(UbesDelightItems.PANDESAL_RAW.get());

        generateFlatItem(UbesDelightItems.PANDESAL_UBE_STAGE0.get());
        generateFlatItem(UbesDelightItems.PANDESAL_UBE_STAGE1.get());
        generateFlatItem(UbesDelightItems.PANDESAL_UBE_STAGE2.get());
        generateFlatItem(UbesDelightItems.PANDESAL_UBE_RAW.get());

        generateFlatItem(UbesDelightItems.ENSAYMADA_STAGE0.get());
        generateFlatItem(UbesDelightItems.ENSAYMADA_STAGE1.get());
        generateFlatItem(UbesDelightItems.ENSAYMADA_STAGE2.get());
        generateFlatItem(UbesDelightItems.ENSAYMADA_STAGE3.get());
        generateFlatItem(UbesDelightItems.ENSAYMADA_RAW.get());

        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE_STAGE0.get());
        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE_STAGE1.get());
        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE_STAGE2.get());
        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE_STAGE3.get());
        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE_RAW.get());

        generateFlatItem(UbesDelightItems.HOPIA_MUNGGO_STAGE0.get());
        generateFlatItem(UbesDelightItems.HOPIA_MUNGGO_STAGE1.get());
        generateFlatItem(UbesDelightItems.HOPIA_MUNGGO_STAGE2.get());
        generateFlatItem(UbesDelightItems.HOPIA_MUNGGO_RAW.get());

        generateFlatItem(UbesDelightItems.HOPIA_UBE_STAGE0.get());
        generateFlatItem(UbesDelightItems.HOPIA_UBE_STAGE1.get());
        generateFlatItem(UbesDelightItems.HOPIA_UBE_STAGE2.get());
        generateFlatItem(UbesDelightItems.HOPIA_UBE_RAW.get());

        generateFlatItem(UbesDelightItems.POLVORONE_STAGE0.get());
        generateFlatItem(UbesDelightItems.POLVORONE_STAGE1.get());
        generateFlatItem(UbesDelightItems.POLVORONE_STAGE2.get());
        generateFlatItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE0.get());
        generateFlatItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE1.get());
        generateFlatItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE2.get());
        generateFlatItem(UbesDelightItems.POLVORONE_UBE_STAGE0.get());
        generateFlatItem(UbesDelightItems.POLVORONE_UBE_STAGE1.get());
        generateFlatItem(UbesDelightItems.POLVORONE_UBE_STAGE2.get());
        generateFlatItem(UbesDelightItems.POLVORONE_CC_STAGE0.get());
        generateFlatItem(UbesDelightItems.POLVORONE_CC_STAGE1.get());
        generateFlatItem(UbesDelightItems.POLVORONE_CC_STAGE2.get());
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
