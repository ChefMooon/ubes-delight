package com.chefmooon.ubesdelight.client.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.client.UbesDelightClient;
import com.chefmooon.ubesdelight.client.event.fabric.ClientSetupEventsImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class UbesDelightClientImpl implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        UbesDelightClient.init();

        ClientSetupEventsImpl.onRegisterRenderers();

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                UbesDelightBlocksImpl.BAKING_MAT_BAMBOO,
                UbesDelightBlocksImpl.WILD_UBE,
                UbesDelightBlocksImpl.WILD_GARLIC,
                UbesDelightBlocksImpl.WILD_GINGER,
                UbesDelightBlocksImpl.WILD_LEMONGRASS,
                UbesDelightBlocksImpl.POTTED_UBE,
                UbesDelightBlocksImpl.POTTED_GARLIC,
                UbesDelightBlocksImpl.POTTED_GINGER,
                UbesDelightBlocksImpl.UBE_CROP,
                UbesDelightBlocksImpl.GARLIC_CROP,
                UbesDelightBlocksImpl.GINGER_CROP,
                UbesDelightBlocksImpl.LEMONGRASS_CROP,
                UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP,
                UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP,
                UbesDelightBlocksImpl.UBE_CAKE,
                UbesDelightBlocksImpl.LECHE_FLAN_FEAST,
                UbesDelightBlocksImpl.LUMPIA_FEAST,
                UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO,
                UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST,
                UbesDelightBlocksImpl.HALO_HALO_FEAST);

        onBuiltinPackRegistration();
    }

    public static void onBuiltinPackRegistration() {
        if (isModLoaded("eatinganimationid")) {
            FabricLoader.getInstance().getModContainer(UbesDelight.MOD_ID).ifPresent(udsupporteatinganimation ->
                    ResourceManagerHelper.registerBuiltinResourcePack(new ResourceLocation("udsupporteatinganimation"), udsupporteatinganimation, ResourcePackActivationType.DEFAULT_ENABLED));
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
