package com.chefmooon.ubesdelight.fabric;


import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.block.entity.fabric.BakingMatBlockEntityImpl;
import com.chefmooon.ubesdelight.common.event.fabric.VillagerEventsImpl;
import com.chefmooon.ubesdelight.common.fabric.CommonSetupImpl;
import com.chefmooon.ubesdelight.common.loot.modifier.fabric.AddLootTableModifierImpl;
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
        UbesDelightPlacementModifiersImpl.register();
        UbesDelightRecipeTypesImpl.RECIPE_TYPES.register();
        UbesDelightRecipeSerializersImpl.RECIPE_SERIALIZERS.register();

        VillagerEventsImpl.init();

        CommonSetupImpl.init();
        AddLootTableModifierImpl.registerLootTable();

        UbesDelightBiomeModifiersImpl.init();

        BakingMatBlockEntityImpl.init();
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
