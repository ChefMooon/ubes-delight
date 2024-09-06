package com.chefmooon.ubesdelight.client.event.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.client.renderer.neoforge.BakingMatBlockEntityRenderImpl;
import com.chefmooon.ubesdelight.common.registry.neoforge.UbesDelightBlockEntityTypesImpl;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = UbesDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEventsImpl {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(UbesDelightBlockEntityTypesImpl.BAKING_MAT_BAMBOO.get(), BakingMatBlockEntityRenderImpl::new);
    }
}
