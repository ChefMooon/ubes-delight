package com.chefmooon.ubesdelight.client.event.fabric;

import com.chefmooon.ubesdelight.client.renderer.fabric.BakingMatBlockEntityRenderImpl;
import com.chefmooon.ubesdelight.client.renderer.fabric.UniversalLeafFeastBlockEntityRenderImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlockEntityTypesImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class ClientSetupEventsImpl {

    public static void onRegisterRenderers() {
        BlockEntityRenderers.register(UbesDelightBlockEntityTypesImpl.BAKING_MAT_BAMBOO.get(), BakingMatBlockEntityRenderImpl::new);
        BlockEntityRenderers.register(UbesDelightBlockEntityTypesImpl.UNIVERSAL_LEAF_FEAST.get(), UniversalLeafFeastBlockEntityRenderImpl::new);
    }

    public static void onRegisterBlockRenderLayerMap() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get(),
                UbesDelightBlocksImpl.WILD_UBE.get(),
                UbesDelightBlocksImpl.WILD_GARLIC.get(),
                UbesDelightBlocksImpl.WILD_GINGER.get(),
                UbesDelightBlocksImpl.WILD_LEMONGRASS.get(),
                UbesDelightBlocksImpl.POTTED_UBE.get(),
                UbesDelightBlocksImpl.POTTED_GARLIC.get(),
                UbesDelightBlocksImpl.POTTED_GINGER.get(),
                UbesDelightBlocksImpl.UBE_CROP.get(),
                UbesDelightBlocksImpl.GARLIC_CROP.get(),
                UbesDelightBlocksImpl.GINGER_CROP.get(),
                UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP.get(),
                UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get(),
                UbesDelightBlocksImpl.UBE_CAKE.get(),
                UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get(),
                UbesDelightBlocksImpl.LUMPIA_FEAST.get(),
                UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO.get(),
                UbesDelightBlocksImpl.GLASS_CUP_MILK_TEA_UBE.get(),
                UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST.get(),
                UbesDelightBlocksImpl.HALO_HALO_FEAST.get(),
                UbesDelightBlocksImpl.LEAF_FEAST.get(),
                UbesDelightBlocksImpl.UNIVERSAL_LEAF_FEAST.get(),
                UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA.get(),
                UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA_UBE.get(),
                UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL.get(),
                UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL_UBE.get(),
                UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_MUNGGO.get(),
                UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_UBE.get(),
                UbesDelightBlocksImpl.LEAF_FEAST_COOKED_RICE.get(),
                UbesDelightBlocksImpl.LEAF_FEAST_FRIED_RICE.get(),
                UbesDelightBlocksImpl.LEAF_FEAST_SINANGAG.get()
        );
    }
}
