package com.chefmooon.ubesdelight.client.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.client.UbesDelightClient;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.resource.PathPackResources;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class UbesDelightClientImpl {
    public static void init(final FMLClientSetupEvent event) {
        UbesDelightClient.init();
    }

    public static void onBuiltinPackRegistration(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            if (isModLoaded("presencefootsteps")) {
                registerBuiltinResourcePack(event, Component.literal(UbesDelight.MOD_ID + "/udpresencefootsteps"), "udpresencefootsteps");
            }

            // For future use when Forge Eating Animation Compat works
            //if (isModLoaded("eatinganimation")) {
            //    registerBuiltinResourcePack(event, Component.literal(UbesDelight.MOD_ID + "/ubsupporteatinganimation"), "udsupporteatinganimation");
            //}
        }
    }

    private static void registerBuiltinResourcePack(AddPackFindersEvent event, MutableComponent name, String folder) {
        IModFileInfo modFileInfo = ModList.get().getModFileById(UbesDelight.MOD_ID);
        if (modFileInfo == null) {
            return;
        }
        String path = TextUtils.res(folder).toString();
        IModFile modFile = modFileInfo.getFile();
        event.addRepositorySource((consumer) -> {
            consumer.accept(Pack.create(
                    path, // Pack ID
                    name, // Pack name
                    false,
                    (p) -> new PathPackResources(path, true, modFile.findResource("resourcepacks/" + folder)), // Your custom resource pack provider
                    new Pack.Info(Component.literal(UbesDelight.MOD_ID + "/" + folder), 15, FeatureFlagSet.of()), // Pack description and compatibility version
                    PackType.CLIENT_RESOURCES,
                    Pack.Position.TOP,
                    false,
                    PackSource.BUILT_IN
            ));
        });
    }

    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

}
