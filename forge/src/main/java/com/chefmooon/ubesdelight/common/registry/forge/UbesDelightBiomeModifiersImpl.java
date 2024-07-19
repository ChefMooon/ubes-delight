package com.chefmooon.ubesdelight.common.registry.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBiomeModifiers;
import com.chefmooon.ubesdelight.common.world.modifier.forge.AddFeaturesByFilterModifier;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Optional;

public class UbesDelightBiomeModifiersImpl {
    public static DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, UbesDelight.MOD_ID);

    public static RegistryObject<Codec<AddFeaturesByFilterModifier>> ADD_FEATURES_BY_FILTER = BIOME_MODIFIER_SERIALIZERS.register("add_features_by_filter", () ->
            RecordCodecBuilder.create(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("allowed_biomes").forGetter(AddFeaturesByFilterModifier::allowedBiomes),
                    Biome.LIST_CODEC.optionalFieldOf("denied_biomes").orElse(Optional.empty()).forGetter(AddFeaturesByFilterModifier::deniedBiomes),
                    PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(AddFeaturesByFilterModifier::features),
                    GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(AddFeaturesByFilterModifier::step)
            ).apply(builder, AddFeaturesByFilterModifier::new)));

    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_UBE = modConfiguredFeature(UbesDelightBiomeModifiers.PATCH_WILD_UBE);
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_GARLIC = modConfiguredFeature(UbesDelightBiomeModifiers.PATCH_WILD_GARLIC);
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_GINGER = modConfiguredFeature(UbesDelightBiomeModifiers.PATCH_WILD_GINGER);
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_LEMONGRASS = modConfiguredFeature(UbesDelightBiomeModifiers.PATCH_WILD_LEMONGRASS);

    public static ResourceKey<PlacedFeature> PATCH_PATCH_WILD_UBE = modPlacedFeature(UbesDelightBiomeModifiers.PATCH_WILD_UBE);
    public static ResourceKey<PlacedFeature> PATCH_PATCH_WILD_GARLIC = modPlacedFeature(UbesDelightBiomeModifiers.PATCH_WILD_GARLIC);
    public static ResourceKey<PlacedFeature> PATCH_PATCH_WILD_GINGER = modPlacedFeature(UbesDelightBiomeModifiers.PATCH_WILD_GINGER);
    public static ResourceKey<PlacedFeature> PATCH_PATCH_WILD_LEMONGRASS = modPlacedFeature(UbesDelightBiomeModifiers.PATCH_WILD_LEMONGRASS);

    private static ResourceKey<ConfiguredFeature<?, ?>> modConfiguredFeature(ResourceLocation location) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, location);
    }
    private static ResourceKey<PlacedFeature> modPlacedFeature(ResourceLocation location) {
        return ResourceKey.create(Registries.PLACED_FEATURE, location);
    }

    public static void register(IEventBus eventBus) {
        BIOME_MODIFIER_SERIALIZERS.register(eventBus);
    }

    public static void init() {

    }
}
