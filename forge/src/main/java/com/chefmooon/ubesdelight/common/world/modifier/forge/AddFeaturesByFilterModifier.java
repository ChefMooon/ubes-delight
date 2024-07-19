package com.chefmooon.ubesdelight.common.world.modifier.forge;

import com.chefmooon.ubesdelight.common.registry.forge.UbesDelightBiomeModifiersImpl;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;

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
        public Codec<? extends BiomeModifier> codec() {
                return UbesDelightBiomeModifiersImpl.ADD_FEATURES_BY_FILTER.get();
        }
}
