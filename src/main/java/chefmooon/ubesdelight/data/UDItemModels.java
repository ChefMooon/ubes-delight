package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UDItemModels extends ItemModelProvider {

    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";

    public UDItemModels(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Set<Item> items = BuiltInRegistries.ITEM.stream().filter(i -> UbesDelight.MOD_ID.equals(BuiltInRegistries.ITEM.getKey(i).getNamespace()))
                .collect(Collectors.toSet());

        generateFlatItem(UbesDelightItems.WILD_UBE.get());
        generateFlatItem(UbesDelightItems.WILD_GARLIC.get());
        generateFlatItem(UbesDelightItems.WILD_GINGER.get());
        generateFlatItem(UbesDelightItems.WILD_LEMONGRASS.get(), TextUtils.res("block/" + BuiltInRegistries.ITEM.getKey(UbesDelightItems.WILD_LEMONGRASS.get()).getPath() + "_top").toString());
        items.remove(UbesDelightItems.WILD_LEMONGRASS.get());

        blockModel(UbesDelightItems.UBE_CRATE.get());
        blockModel(UbesDelightItems.GARLIC_CRATE.get());
        blockModel(UbesDelightItems.GINGER_CRATE.get());
        blockModel(UbesDelightItems.LEMONGRASS_CRATE.get());

        blockModel(UbesDelightItems.KALAN.get());
        blockModel(UbesDelightItems.BAKING_MAT_BAMBOO.get());

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

    private void generateFlatItem(Item item) {
        withExistingParent(BuiltInRegistries.ITEM.getKey(item).getPath(), GENERATED)
                .texture("layer0", "item/" + BuiltInRegistries.ITEM.getKey(item).getPath());
    }

    private void generateFlatItem(Item item, String textureName) {
        withExistingParent(BuiltInRegistries.ITEM.getKey(item).getPath(), GENERATED)
                .texture("layer0", textureName);
    }

    private void generateFlatHandheldItemFlipped(Item item) {
        withExistingParent(BuiltInRegistries.ITEM.getKey(item).getPath(), TextUtils.res("item/flat_handheld_item_flipped"))
                .texture("layer0", "item/" + BuiltInRegistries.ITEM.getKey(item).getPath());
    }

    private void generateRollingPinItem(Item item) {
        withExistingParent(BuiltInRegistries.ITEM.getKey(item).getPath(), TextUtils.res("item/template_rolling_pin_3d"))
                .texture("content", "item/" + BuiltInRegistries.ITEM.getKey(item).getPath() + "_3d");
    }

    private void blockModel(Item item) {
        blockModel(item, "");
    }

    private void blockModel(Item item, String suffix) {
        withExistingParent(getItemName(item), resourceBlock(getItemName(item) + suffix));
    }

    private String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return TextUtils.res("block/" + path);
    }

    public ResourceLocation resourceItem(String path) {
        return TextUtils.res("item/" + path);
    }
}
