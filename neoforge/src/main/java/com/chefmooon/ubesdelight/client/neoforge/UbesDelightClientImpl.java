package com.chefmooon.ubesdelight.client.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.client.UbesDelightClient;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.repository.KnownPack;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.AddPackFindersEvent;
import net.neoforged.neoforge.resource.EmptyPackResources;
import net.neoforged.neoforgespi.language.IModFileInfo;
import net.neoforged.neoforgespi.locating.IModFile;

import java.util.Optional;

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
            consumer.accept(Pack.readMetaAndCreate(
                    new PackLocationInfo(
                            path, // Pack ID
                            name, // Pack name
                            PackSource.DEFAULT,
                            Optional.of(new KnownPack(UbesDelight.MOD_ID, modFile.findResource("resourcepacks/" + folder).toString(), "15"))),
                    new EmptyPackResources.EmptyResourcesSupplier(new PackMetadataSection(Component.literal(UbesDelight.MOD_ID + "/" + folder),
                            SharedConstants.getCurrentVersion().getPackVersion(PackType.CLIENT_RESOURCES))),
                    PackType.CLIENT_RESOURCES,
//                    (p) -> new PathPackResources(path, Optional.empty()), modFile.findResource("resourcepacks/" + folder)), // Your custom resource pack provider
//                    new Pack(Component.literal(UbesDelight.MOD_ID + "/" + folder), 15, FeatureFlagSet.of()), // Pack description and compatibility version
                    new PackSelectionConfig(
                            false,
                            Pack.Position.TOP,
                            false
                    )
            ));
        });
    }

    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

}
