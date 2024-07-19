package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.registry.UbesDelightBiomeFeatures;
import com.chefmooon.ubesdelight.common.world.configuration.WildTertiaryCropConfiguration;
import com.chefmooon.ubesdelight.common.world.feature.WildTertiaryCropFeature;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class UbesDelightBiomeFeaturesImpl {
    public static final Feature<? extends FeatureConfiguration> WILD_TERTIARY_CROP = registerFeature(UbesDelightBiomeFeatures.WILD_TERTIARY_CROP, new WildTertiaryCropFeature(WildTertiaryCropConfiguration.CODEC));

    public static Feature<? extends FeatureConfiguration> registerFeature(ResourceLocation location, Feature<? extends FeatureConfiguration> feature) {
        return Registry.register(BuiltInRegistries.FEATURE, location, feature);
    }

    public static void register() {

    }
}
