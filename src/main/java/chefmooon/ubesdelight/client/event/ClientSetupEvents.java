package chefmooon.ubesdelight.client.event;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.client.renderer.BakingMatBlockEntityRender;
import chefmooon.ubesdelight.client.renderer.UniversalLeafFeastBlockEntityRender;
import chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = UbesDelight.MOD_ID, value = Dist.CLIENT)
public class ClientSetupEvents {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(UbesDelightBlockEntityTypes.BAKING_MAT_BAMBOO.get(), BakingMatBlockEntityRender::new);
        event.registerBlockEntityRenderer(UbesDelightBlockEntityTypes.UNIVERSAL_LEAF_FEAST.get(), UniversalLeafFeastBlockEntityRender::new);
    }
}
