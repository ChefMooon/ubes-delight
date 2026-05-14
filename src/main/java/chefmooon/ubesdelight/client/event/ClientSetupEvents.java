package chefmooon.ubesdelight.client.event;

import chefmooon.ubesdelight.client.renderer.BakingMatBlockEntityRender;
import chefmooon.ubesdelight.client.renderer.UniversalLeafFeastBlockEntityRender;
import chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class ClientSetupEvents {

    public static void onRegisterRenderers() {
        BlockEntityRenderers.register(UbesDelightBlockEntityTypes.BAKING_MAT_BAMBOO.get(), BakingMatBlockEntityRender::new);
        BlockEntityRenderers.register(UbesDelightBlockEntityTypes.UNIVERSAL_LEAF_FEAST.get(), UniversalLeafFeastBlockEntityRender::new);
    }

    public static void onRegisterBlockRenderLayerMap() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                UbesDelightBlocks.BAKING_MAT_BAMBOO.get(),
                UbesDelightBlocks.WILD_UBE.get(),
                UbesDelightBlocks.WILD_GARLIC.get(),
                UbesDelightBlocks.WILD_GINGER.get(),
                UbesDelightBlocks.WILD_LEMONGRASS.get(),
                UbesDelightBlocks.POTTED_UBE.get(),
                UbesDelightBlocks.POTTED_GARLIC.get(),
                UbesDelightBlocks.POTTED_GINGER.get(),
                UbesDelightBlocks.UBE_CROP.get(),
                UbesDelightBlocks.GARLIC_CROP.get(),
                UbesDelightBlocks.GINGER_CROP.get(),
                UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(),
                UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(),
                UbesDelightBlocks.UBE_CAKE.get(),
                UbesDelightBlocks.LECHE_FLAN_FEAST.get(),
                UbesDelightBlocks.LUMPIA_FEAST.get(),
                UbesDelightBlocks.GLASS_CUP_HALO_HALO.get(),
                UbesDelightBlocks.GLASS_CUP_MILK_TEA_UBE.get(),
                UbesDelightBlocks.MILK_TEA_UBE_FEAST.get(),
                UbesDelightBlocks.HALO_HALO_FEAST.get(),
                UbesDelightBlocks.LEAF_FEAST.get(),
                UbesDelightBlocks.UNIVERSAL_LEAF_FEAST.get(),
                UbesDelightBlocks.LEAF_FEAST_ENSAYMADA.get(),
                UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE.get(),
                UbesDelightBlocks.LEAF_FEAST_PANDESAL.get(),
                UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE.get(),
                UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO.get(),
                UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE.get(),
                UbesDelightBlocks.LEAF_FEAST_COOKED_RICE.get(),
                UbesDelightBlocks.LEAF_FEAST_FRIED_RICE.get(),
                UbesDelightBlocks.LEAF_FEAST_SINANGAG.get()
        );
    }
}
