package com.chefmooon.ubesdelight.common.registry.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBiomeFeatures;
import com.chefmooon.ubesdelight.common.world.configuration.WildTertiaryCropConfiguration;
import com.chefmooon.ubesdelight.common.world.feature.WildTertiaryCropFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightBiomeFeaturesImpl {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, UbesDelight.MOD_ID);
    public static final Supplier<Feature<WildTertiaryCropConfiguration>> WILD_TERTIARY_CROP = FEATURES.register(UbesDelightBiomeFeatures.WILD_TERTIARY_CROP.getPath(), () -> new WildTertiaryCropFeature(WildTertiaryCropConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
