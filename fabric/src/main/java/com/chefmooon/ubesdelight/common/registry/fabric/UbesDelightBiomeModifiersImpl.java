package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBiomeModifiers;
import com.chefmooon.ubesdelight.common.tag.UbesDelightTags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class UbesDelightBiomeModifiersImpl {
    public static final ResourceKey<PlacedFeature> WILD_UBE = modFeature(UbesDelightBiomeModifiers.PATCH_WILD_UBE);
    public static final ResourceKey<PlacedFeature> WILD_GARLIC = modFeature(UbesDelightBiomeModifiers.PATCH_WILD_GARLIC);
    public static final ResourceKey<PlacedFeature> WILD_GINGER = modFeature(UbesDelightBiomeModifiers.PATCH_WILD_GINGER);
    public static final ResourceKey<PlacedFeature> WILD_LEMONGRASS = modFeature(UbesDelightBiomeModifiers.PATCH_WILD_LEMONGRASS);

    @NotNull
    private static ResourceKey<PlacedFeature> modFeature(ResourceLocation location) {
        return ResourceKey.create(Registries.PLACED_FEATURE, location);
    }

    public static void init() {
        if (Configuration.generateWildUbe()) {
            BiomeModifications.addFeature(new UDBiomeSelector(UbesDelightTags.WILD_UBE_WHITELIST, UbesDelightTags.WILD_UBE_BLACKLIST),
                    GenerationStep.Decoration.VEGETAL_DECORATION, WILD_UBE);
        }

        if (Configuration.generateWildGarlic()) {
            BiomeModifications.addFeature(new UDBiomeSelector(UbesDelightTags.WILD_GARLIC_WHITELIST, UbesDelightTags.WILD_GARLIC_BLACKLIST),
                    GenerationStep.Decoration.VEGETAL_DECORATION, WILD_GARLIC);
        }

        if (Configuration.generateWildGinger()) {
            BiomeModifications.addFeature(new UDBiomeSelector(UbesDelightTags.WILD_GINGER_WHITELIST, UbesDelightTags.WILD_GINGER_BLACKLIST),
                    GenerationStep.Decoration.VEGETAL_DECORATION, WILD_GINGER);
        }

        if (Configuration.generateWildLemongrass()) {
            BiomeModifications.addFeature(new UDBiomeSelector(UbesDelightTags.WILD_LEMONGRASS_WHITELIST, UbesDelightTags.WILD_LEMONGRASS_BLACKLIST),
                    GenerationStep.Decoration.VEGETAL_DECORATION, WILD_LEMONGRASS);
        }
    }

    public record UDBiomeSelector(TagKey<Biome> allowed, TagKey<Biome> denied) implements Predicate<BiomeSelectionContext> {
        @Override
        public boolean test(BiomeSelectionContext context) {
            Holder<Biome> biome = context.getBiomeRegistryEntry();
            return biome.is(allowed) && !biome.is(denied);
        }
    }
}
