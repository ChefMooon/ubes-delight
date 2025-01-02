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
        BlockEntityRenderers.register(UbesDelightBlockEntityTypesImpl.BAKING_MAT_BAMBOO, BakingMatBlockEntityRenderImpl::new);
        BlockEntityRenderers.register(UbesDelightBlockEntityTypesImpl.UNIVERSAL_LEAF_FEAST, UniversalLeafFeastBlockEntityRenderImpl::new);
    }

    public static void onRegisterBlockRenderLayerMap() {
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
                UbesDelightBlocksImpl.GLASS_CUP_MILK_TEA_UBE,
                UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST,
                UbesDelightBlocksImpl.HALO_HALO_FEAST,
                UbesDelightBlocksImpl.LEAF_FEAST,
                UbesDelightBlocksImpl.UNIVERSAL_LEAF_FEAST,
                UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA,
                UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA_UBE,
                UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL,
                UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL_UBE,
                UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_MUNGGO,
                UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_UBE,
                UbesDelightBlocksImpl.LEAF_FEAST_COOKED_RICE,
                UbesDelightBlocksImpl.LEAF_FEAST_FRIED_RICE,
                UbesDelightBlocksImpl.LEAF_FEAST_SINANGAG
        );
    }
}
