package com.chefmooon.ubesdelight.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.client.forge.UbesDelightClientImpl;
import com.chefmooon.ubesdelight.common.forge.CommonSetupImpl;
import com.chefmooon.ubesdelight.common.registry.forge.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.MavenVersionStringHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.forgespi.language.IModInfo;

import java.util.List;

@Mod(UbesDelight.MOD_ID)
public class UbesDelightImpl {

    public UbesDelightImpl() {
        UbesDelight.init();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

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

        UbesDelightBiomeModifiersImpl.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static String findVersion() {
        String versionString = "UNKNOWN";

        List<IModInfo> infoList = ModList.get().getModFileById(UbesDelight.MOD_ID).getMods();
        if (infoList.size() > 1) {
            UbesDelight.LOGGER.error("Multiple mods for MOD_ID: " + UbesDelight.MOD_ID);
        }
        for (IModInfo info : infoList) {
            if (info.getModId().equals(UbesDelight.MOD_ID)) {
                versionString = MavenVersionStringHelper.artifactVersionToString(info.getVersion());
                break;
            }
        }
        return versionString;
    }
}
