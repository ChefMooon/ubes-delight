package com.chefmoon.ubesdelight;

import com.chefmoon.ubesdelight.block.entity.client.BakingMatBlockEntityRender;
import com.chefmoon.ubesdelight.registry.BlockEntityTypesRegistry;
import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;

@Environment(value= EnvType.CLIENT)
public class UbesDelightModClient  implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlocksRegistry.registerRenderLayer();

        if (isModLoaded("eatinganimationid")) {
            FabricLoader.getInstance().getModContainer(UbesDelightMod.MOD_ID).ifPresent(udsupporteatinganimation ->
                    ResourceManagerHelper.registerBuiltinResourcePack(new Identifier("udsupporteatinganimation"), udsupporteatinganimation, ResourcePackActivationType.DEFAULT_ENABLED));
        }

        BlockEntityRendererFactories.register(BlockEntityTypesRegistry.BAKING_MAT_BAMBOO.get(), BakingMatBlockEntityRender::new);
        // Minecraft 1.19.2 BlockEntity Stuff
        //ModMessages.registerS2CPackets();
        //BlockEntityRendererRegistryImpl.register(BlockEntityTypesRegistry.BAKING_MAT_BAMBOO.get(), BakingMatBlockEntityRender::new);
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
