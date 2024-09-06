package com.chefmooon.ubesdelight.client.event.fabric;

import com.chefmooon.ubesdelight.client.renderer.fabric.BakingMatBlockEntityRenderImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlockEntityTypesImpl;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class ClientSetupEventsImpl {

    public static void onRegisterRenderers() {
        BlockEntityRenderers.register(UbesDelightBlockEntityTypesImpl.BAKING_MAT_BAMBOO.get(), BakingMatBlockEntityRenderImpl::new);
    }
}
