package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.data.utility.UbesDelightModels;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ItemModelGenerator {
    private static ItemModelGenerators GENERATOR;
    public static void generateItemModels(ItemModelGenerators itemModelGenerator) {
        GENERATOR = itemModelGenerator;

        generateRollingPinItem(UbesDelightItems.ROLLING_PIN_WOOD);
        generateRollingPinItem(UbesDelightItems.ROLLING_PIN_IRON);
        generateRollingPinItem(UbesDelightItems.ROLLING_PIN_GOLD);
        generateRollingPinItem(UbesDelightItems.ROLLING_PIN_DIAMOND);
        generateRollingPinItem(UbesDelightItems.ROLLING_PIN_NETHERITE);

        generateFlatItem(UbesDelightItems.POISONOUS_UBE);
        generateFlatItem(UbesDelightItems.UBE);
        generateFlatItem(UbesDelightItems.GARLIC);
        generateFlatItem(UbesDelightItems.GINGER);
        generateFlatItem(UbesDelightItems.LEMONGRASS);
        generateFlatItem(UbesDelightItems.LEMONGRASS_SEEDS);

        generateFlatItem(UbesDelightItems.SINANGAG);
        generateFlatItem(UbesDelightItems.KINILAW);
        generateFlatItem(UbesDelightItems.LUMPIA);
        generateFlatItem(UbesDelightItems.TOCINO);
        generateFlatItem(UbesDelightItems.CHICKEN_INASAL);

        generateFlatItem(UbesDelightItems.CHICKEN_INASAL_RICE);
        generateFlatItem(UbesDelightItems.TOSILOG);
        generateFlatItem(UbesDelightItems.BANGSILOG);
        generateFlatItem(UbesDelightItems.SISIG);
        generateFlatItem(UbesDelightItems.BULALO);
        generateFlatItem(UbesDelightItems.ARROZ_CALDO);
        generateFlatItem(UbesDelightItems.MECHADO);

        generateFlatItem(UbesDelightItems.CONDENSED_MILK_BOTTLE);
        generateFlatItem(UbesDelightItems.FISH_SAUCE_BOTTLE);
        generateFlatItem(UbesDelightItems.MILK_POWDER);
        generateFlatItem(UbesDelightItems.SUGAR_BROWN);
        generateFlatItem(UbesDelightItems.LUMPIA_WRAPPER);

        generateFlatItem(UbesDelightItems.MILK_TEA_UBE);
        generateFlatItem(UbesDelightItems.HALO_HALO);

        generateFlatItem(UbesDelightItems.GARLIC_CHOP);
        generateFlatItem(UbesDelightItems.GINGER_CHOP);

        generateFlatItem(UbesDelightItems.COOKIE_UBE);
        generateFlatItem(UbesDelightItems.COOKIE_GINGER);

        generateFlatItem(UbesDelightItems.POLVORONE);
        generateFlatItem(UbesDelightItems.POLVORONE_PINIPIG);
        generateFlatItem(UbesDelightItems.POLVORONE_UBE);
        generateFlatItem(UbesDelightItems.POLVORONE_CC);
        generateFlatItem(UbesDelightItems.RAW_POLVORONE);
        generateFlatItem(UbesDelightItems.RAW_POLVORONE_PINIPIG);
        generateFlatItem(UbesDelightItems.RAW_POLVORONE_UBE);
        generateFlatItem(UbesDelightItems.RAW_POLVORONE_CC);

        generateFlatItem(UbesDelightItems.HALO_HALO_FEAST);
        generateFlatItem(UbesDelightItems.MILK_TEA_UBE_FEAST);

        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST);
        generateFlatHandheldItemFlipped(UbesDelightItems.LUMPIA_FEAST);

        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_ENSAYMADA);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_ENSAYMADA_HALF);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE_HALF);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_PANDESAL);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_PANDESAL_HALF);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE_HALF);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO_HALF);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_HOPIA_UBE);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_HOPIA_UBE_HALF);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_COOKED_RICE);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_COOKED_RICE_HALF);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_FRIED_RICE);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_FRIED_RICE_HALF);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_SINANGAG);
        generateFlatHandheldItemFlipped(UbesDelightItems.LEAF_FEAST_SINANGAG_HALF);

        generateFlatItem(UbesDelightItems.LECHE_FLAN_FEAST);
        generateFlatItem(UbesDelightItems.LECHE_FLAN);
        generateFlatItem(UbesDelightItems.UBE_CAKE);
        generateFlatItem(UbesDelightItems.UBE_CAKE_SLICE);

        generateFlatItem(UbesDelightItems.PANDESAL);
        generateFlatItem(UbesDelightItems.PANDESAL_UBE);
        generateFlatItem(UbesDelightItems.ENSAYMADA);
        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE);
        generateFlatItem(UbesDelightItems.HOPIA_MUNGGO);
        generateFlatItem(UbesDelightItems.HOPIA_UBE);

        generateFlatItem(UbesDelightItems.PANDESAL_STAGE0);
        generateFlatItem(UbesDelightItems.PANDESAL_STAGE1);
        generateFlatItem(UbesDelightItems.PANDESAL_STAGE2);
        generateFlatItem(UbesDelightItems.PANDESAL_RAW);

        generateFlatItem(UbesDelightItems.PANDESAL_UBE_STAGE0);
        generateFlatItem(UbesDelightItems.PANDESAL_UBE_STAGE1);
        generateFlatItem(UbesDelightItems.PANDESAL_UBE_STAGE2);
        generateFlatItem(UbesDelightItems.PANDESAL_UBE_RAW);

        generateFlatItem(UbesDelightItems.ENSAYMADA_STAGE0);
        generateFlatItem(UbesDelightItems.ENSAYMADA_STAGE1);
        generateFlatItem(UbesDelightItems.ENSAYMADA_STAGE2);
        generateFlatItem(UbesDelightItems.ENSAYMADA_STAGE3);
        generateFlatItem(UbesDelightItems.ENSAYMADA_RAW);

        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE_STAGE0);
        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE_STAGE1);
        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE_STAGE2);
        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE_STAGE3);
        generateFlatItem(UbesDelightItems.ENSAYMADA_UBE_RAW);

        generateFlatItem(UbesDelightItems.HOPIA_MUNGGO_STAGE0);
        generateFlatItem(UbesDelightItems.HOPIA_MUNGGO_STAGE1);
        generateFlatItem(UbesDelightItems.HOPIA_MUNGGO_STAGE2);
        generateFlatItem(UbesDelightItems.HOPIA_MUNGGO_RAW);

        generateFlatItem(UbesDelightItems.HOPIA_UBE_STAGE0);
        generateFlatItem(UbesDelightItems.HOPIA_UBE_STAGE1);
        generateFlatItem(UbesDelightItems.HOPIA_UBE_STAGE2);
        generateFlatItem(UbesDelightItems.HOPIA_UBE_RAW);

        generateFlatItem(UbesDelightItems.POLVORONE_STAGE0);
        generateFlatItem(UbesDelightItems.POLVORONE_STAGE1);
        generateFlatItem(UbesDelightItems.POLVORONE_STAGE2);
        generateFlatItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE0);
        generateFlatItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE1);
        generateFlatItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE2);
        generateFlatItem(UbesDelightItems.POLVORONE_UBE_STAGE0);
        generateFlatItem(UbesDelightItems.POLVORONE_UBE_STAGE1);
        generateFlatItem(UbesDelightItems.POLVORONE_UBE_STAGE2);
        generateFlatItem(UbesDelightItems.POLVORONE_CC_STAGE0);
        generateFlatItem(UbesDelightItems.POLVORONE_CC_STAGE1);
        generateFlatItem(UbesDelightItems.POLVORONE_CC_STAGE2);
    }

    private static void generateFlatItem(Supplier<Item> item) {
        GENERATOR.generateFlatItem(item.get(), ModelTemplates.FLAT_ITEM);
    }

    private static void generateFlatHandheldItemFlipped(Supplier<Item> item) {
        GENERATOR.generateFlatItem(item.get(), UbesDelightModels.FLAT_HANDHELD_ITEM_FLIPPED);
    }

    private static void generateRollingPinItem(Supplier<Item> item) {
        Identifier resourceLocation = UbesDelightModels.TEMPLATE_ROLLING_PIN_3D.create(ModelLocationUtils.getModelLocation(item.get()),
                new TextureMapping().put(TextureSlot.CONTENT, new Material(ModelLocationUtils.getModelLocation(item.get(), "_3d"))),
                GENERATOR.modelOutput);
        ItemModel.Unbaked model = ItemModelUtils.plainModel(resourceLocation);
        GENERATOR.itemModelOutput.accept(item.get(), model);
    }
}
