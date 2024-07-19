package com.chefmooon.ubesdelight.client.event.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.client.renderer.forge.BakingMatBlockEntityRenderImpl;
import com.chefmooon.ubesdelight.common.registry.forge.UbesDelightBlockEntityTypesImpl;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UbesDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEventsImpl {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(UbesDelightBlockEntityTypesImpl.BAKING_MAT_BAMBOO.get(), BakingMatBlockEntityRenderImpl::new);
    }
}
