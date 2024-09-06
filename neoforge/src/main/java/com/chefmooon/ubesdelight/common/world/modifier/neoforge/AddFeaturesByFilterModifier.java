package com.chefmooon.ubesdelight.common.world.modifier.neoforge;

import com.chefmooon.ubesdelight.common.registry.neoforge.UbesDelightBiomeModifiersImpl;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeGenerationSettingsBuilder;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.ModifiableBiomeInfo;

import java.util.Optional;

public record AddFeaturesByFilterModifier(
        HolderSet<Biome> allowedBiomes,
        Optional<HolderSet<Biome>> deniedBiomes,
        HolderSet<PlacedFeature> features,
        GenerationStep.Decoration step
) implements BiomeModifier {

        @Override
        public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
                if (phase == Phase.ADD && this.allowedBiomes.contains(biome)) {
                        if (deniedBiomes.isPresent() && this.deniedBiomes.get().contains(biome)) {
                                return;
                        }
                        BiomeGenerationSettingsBuilder generationSettings = builder.getGenerationSettings();
                        this.features.forEach(holder -> generationSettings.addFeature(this.step, holder));
                }
        }

        @Override
        public MapCodec<? extends BiomeModifier> codec() {
                return UbesDelightBiomeModifiersImpl.ADD_FEATURES_BY_FILTER.get();
        }
}
