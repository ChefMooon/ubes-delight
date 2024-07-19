package com.chefmooon.ubesdelight.common;

import com.chefmooon.ubesdelight.common.registry.UbesDelightItems;
import com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil;
import net.minecraft.world.level.block.ComposterBlock;

public class CommonSetup {
    public static void init() {
        registerCompostables();
    }

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.LEMONGRASS_SEEDS), 0.3f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.GARLIC_CHOP), 0.4f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.GINGER_CHOP), 0.4f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.LUMPIA_WRAPPER), 0.4f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.WILD_UBE), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.WILD_GARLIC), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.WILD_GINGER), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.WILD_LEMONGRASS), 0.65f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.UBE), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.GARLIC), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.GINGER), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.LEMONGRASS), 0.65f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.PANDESAL), 0.7f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.PANDESAL_UBE), 0.7f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.ENSAYMADA), 0.7f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.ENSAYMADA_UBE), 0.7f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.HOPIA_MUNGGO), 0.7f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.HOPIA_UBE), 0.7f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.COOKIE_UBE), 0.85f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.COOKIE_GINGER), 0.85f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.LECHE_FLAN), 0.85f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.UBE_CAKE_SLICE), 0.85f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.UBE_CAKE), 1.0f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.LECHE_FLAN_FEAST), 1.0f);
    }
}
