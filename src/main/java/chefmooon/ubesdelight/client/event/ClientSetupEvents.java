package chefmooon.ubesdelight.client.event;

import chefmooon.ubesdelight.client.renderer.BakingMatBlockEntityRender;
import chefmooon.ubesdelight.client.renderer.UniversalLeafFeastBlockEntityRender;
import chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class ClientSetupEvents {
    public static void onRegisterRenderers() {
        BlockEntityRenderers.register(UbesDelightBlockEntityTypes.BAKING_MAT_BAMBOO.get(), BakingMatBlockEntityRender::new);
        BlockEntityRenderers.register(UbesDelightBlockEntityTypes.UNIVERSAL_LEAF_FEAST.get(), UniversalLeafFeastBlockEntityRender::new);
    }
}
