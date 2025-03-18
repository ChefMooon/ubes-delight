package com.chefmooon.ubesdelight.fabric;


import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.event.fabric.LootModifierEvents;
import com.chefmooon.ubesdelight.common.event.fabric.VillagerEventsImpl;
import com.chefmooon.ubesdelight.common.fabric.CommonSetupImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class UbesDelightImpl implements ModInitializer {

    @Override
    public void onInitialize() {
        UbesDelight.init();

        UbesDelightSoundsImpl.register();
        UbesDelightBlocksImpl.register();
        UbesDelightBlockEntityTypesImpl.register();
        UbesDelightItemsImpl.register();
        UbesDelightBiomeFeaturesImpl.register();
        UbesDelightCreativeTabs.register();
        UbesDelightDataComponentTypesImpl.register();
        UbesDelightPlacementModifiersImpl.register();
        UbesDelightRecipeTypesImpl.register();
        UbesDelightRecipeSerializersImpl.register();
        UbesDelightAdvancementsImpl.register();

        VillagerEventsImpl.init();

        CommonSetupImpl.init();
        //AddLootTableModifierImpl.registerLootTable();

        // 3.0.0
        LootModifierEvents.init();

        UbesDelightBiomeModifiersImpl.init();
    }

    public static String findVersion() {
        return FabricLoader.getInstance()
                .getModContainer(UbesDelight.MOD_ID)
                .orElseThrow()
                .getMetadata()
                .getVersion()
                .getFriendlyString();
    }

}
