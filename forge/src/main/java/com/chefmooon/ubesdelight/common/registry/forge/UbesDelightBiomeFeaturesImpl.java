package com.chefmooon.ubesdelight.common.registry.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBiomeFeatures;
import com.chefmooon.ubesdelight.common.world.configuration.WildTertiaryCropConfiguration;
import com.chefmooon.ubesdelight.common.world.feature.WildTertiaryCropFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UbesDelightBiomeFeaturesImpl {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, UbesDelight.MOD_ID);
    public static final RegistryObject<Feature<WildTertiaryCropConfiguration>> WILD_TERTIARY_CROP = FEATURES.register(UbesDelightBiomeFeatures.WILD_TERTIARY_CROP.getPath(), () -> new WildTertiaryCropFeature(WildTertiaryCropConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
