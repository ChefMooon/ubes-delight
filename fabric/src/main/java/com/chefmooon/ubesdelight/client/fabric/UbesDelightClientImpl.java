package com.chefmooon.ubesdelight.client.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.client.UbesDelightClient;
import com.chefmooon.ubesdelight.client.event.fabric.ClientSetupEventsImpl;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.resources.ResourceLocation;

public class UbesDelightClientImpl implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        UbesDelightClient.init();

        ClientSetupEventsImpl.onRegisterRenderers();
        ClientSetupEventsImpl.onRegisterBlockRenderLayerMap();

        onBuiltinPackRegistration();
    }

    public static void onBuiltinPackRegistration() {
        if (isModLoaded("presencefootsteps")) {
            FabricLoader.getInstance().getModContainer(UbesDelight.MOD_ID).ifPresent(udpresencefootsteps ->
                    ResourceManagerHelper.registerBuiltinResourcePack(ResourceLocation.parse("udpresencefootsteps"), udpresencefootsteps, ResourcePackActivationType.DEFAULT_ENABLED));
        }

        if (isModLoaded("eatinganimationid")) {
            FabricLoader.getInstance().getModContainer(UbesDelight.MOD_ID).ifPresent(udsupporteatinganimation ->
                    ResourceManagerHelper.registerBuiltinResourcePack(ResourceLocation.parse("udsupporteatinganimation"), udsupporteatinganimation, ResourcePackActivationType.DEFAULT_ENABLED));
        }
    }

    public static boolean isModLoaded(String modId) {
        for (ModContainer modContainer : FabricLoader.getInstance().getAllMods()) {
            if (modContainer.getMetadata().getId().equals(modId)) {
                return true;
            }
        }
        return false;
    }
}
