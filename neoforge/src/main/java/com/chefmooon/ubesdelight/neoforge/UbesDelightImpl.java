package com.chefmooon.ubesdelight.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.client.neoforge.UbesDelightClientImpl;
import com.chefmooon.ubesdelight.common.neoforge.CommonSetupImpl;
import com.chefmooon.ubesdelight.common.registry.neoforge.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod(UbesDelight.MOD_ID)
public class UbesDelightImpl {

    public UbesDelightImpl(IEventBus modEventBus, ModContainer modContainer) {
        UbesDelight.init();

        modEventBus.addListener(CommonSetupImpl::init);
        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(UbesDelightClientImpl::init);
            modEventBus.addListener(UbesDelightClientImpl::onBuiltinPackRegistration);
        }

        UbesDelightSoundsImpl.register(modEventBus);
        UbesDelightBlocksImpl.register(modEventBus);
        UbesDelightItemsImpl.register(modEventBus);
        UbesDelightBlockEntityTypesImpl.register(modEventBus);
        UbesDelightRecipeTypesImpl.register(modEventBus);
        UbesDelightRecipeSerializersImpl.register(modEventBus);
        UbesDelightBiomeFeaturesImpl.register(modEventBus);
        UbesDelightCreativeTabs.register(modEventBus);
        UbesDelightPlacementModifiersImpl.register(modEventBus);
        UbesDelightBiomeModifiersImpl.register(modEventBus);
        UbesDelightLootModifiersImpl.register(modEventBus);
        UbesDelightAdvancementsImpl.register(modEventBus);
        UbesDelightConditionCodecs.register(modEventBus);
    }

    public static String findVersion() {
        String versionString = "UNKNOWN";

//        List<IModInfo> infoList = ModList.get().getModFileById(UbesDelight.MOD_ID).getMods();
//        if (infoList.size() > 1) {
//            UbesDelight.LOGGER.error("Multiple mods for MOD_ID: " + UbesDelight.MOD_ID);
//        }
//        for (IModInfo info : infoList) {
//            if (info.getModId().equals(UbesDelight.MOD_ID)) {
//                versionString = MavenVersionStringHelper.artifactVersionToString(info.getVersion());
//                break;
//            }
//        }
        return versionString;
    }
}
