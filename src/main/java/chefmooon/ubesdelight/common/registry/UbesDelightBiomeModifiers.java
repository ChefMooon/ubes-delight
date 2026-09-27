package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.Configuration;
import chefmooon.ubesdelight.common.tag.UbesDelightTags;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.registry.ModBiomeModifiers;

public class UbesDelightBiomeModifiers {

    public static final ResourceKey<Feature> WILD_UBE_CONFIGURED_KEY = configuredFeature("wild_ube");
    public static final ResourceKey<Feature> WILD_GARLIC_CONFIGURED_KEY = configuredFeature("wild_garlic");
    public static final ResourceKey<Feature> WILD_GINGER_CONFIGURED_KEY = configuredFeature("wild_ginger");
    public static final ResourceKey<Feature> WILD_LEMONGRASS_CONFIGURED_KEY = configuredFeature("wild_lemongrass");

    public static final ResourceKey<PlacedFeature> WILD_UBE = modFeature("patch_wild_ube");

    public static final ResourceKey<PlacedFeature> WILD_GARLIC = modFeature("patch_wild_garlic");

    public static final ResourceKey<PlacedFeature> WILD_GINGER = modFeature("patch_wild_ginger");
    public static final ResourceKey<PlacedFeature> WILD_LEMONGRASS = modFeature("patch_wild_lemongrass");

    private static ResourceKey<@NotNull Feature> configuredFeature(String location) {
        return ResourceKey.create(Registries.FEATURE, TextUtils.res(location));
    }

    private static ResourceKey<@NotNull PlacedFeature> modFeature(String location) {
        return ResourceKey.create(Registries.PLACED_FEATURE, TextUtils.res(location));
    }

    public static void init() {
        if (Configuration.generateWildUbe()) {
            addFeature(UbesDelightTags.WILD_UBE_WHITELIST, UbesDelightTags.WILD_UBE_BLACKLIST, WILD_UBE);
        }

        if (Configuration.generateWildGarlic()) {
            addFeature(UbesDelightTags.WILD_GARLIC_WHITELIST, UbesDelightTags.WILD_GARLIC_BLACKLIST, WILD_GARLIC);
        }

        if (Configuration.generateWildGinger()) {
            addFeature(UbesDelightTags.WILD_GINGER_WHITELIST, UbesDelightTags.WILD_GINGER_BLACKLIST, WILD_GINGER);
        }

        if (Configuration.generateWildLemongrass()) {
            addFeature(UbesDelightTags.WILD_LEMONGRASS_WHITELIST, UbesDelightTags.WILD_LEMONGRASS_BLACKLIST, WILD_LEMONGRASS);
        }
    }

    private static void addFeature( TagKey<Biome> whitelist, TagKey<Biome> blacklist, ResourceKey<PlacedFeature> feature) {
        BiomeModifications.addFeature(new ModBiomeModifiers.FDBiomeSelector(-4f, 4f,
                        whitelist, blacklist), GenerationStep.Decoration.VEGETAL_DECORATION, feature);
    }
}
