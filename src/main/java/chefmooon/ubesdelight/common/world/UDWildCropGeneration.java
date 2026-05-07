package chefmooon.ubesdelight.common.world;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.registry.UbesDelightBiomeFeatures;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.utility.TextUtils;
import chefmooon.ubesdelight.common.world.configuration.WildTertiaryCropConfiguration;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.placement.*;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.world.filter.BiomeTagFilter;

import java.util.List;

public class UDWildCropGeneration {

    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_WILD_UBE = registerConfiguredFeatureKey("patch_wild_ube");
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_WILD_GARLIC = registerConfiguredFeatureKey("patch_wild_garlic");
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_WILD_GINGER = registerConfiguredFeatureKey("patch_wild_ginger");
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_WILD_LEMONGRASS = registerConfiguredFeatureKey("patch_wild_lemongrass");

    public static ResourceKey<PlacedFeature> PATCH_WILD_UBE = registerPlacedFeatureKey("patch_wild_ube");
    public static ResourceKey<PlacedFeature> PATCH_WILD_GARLIC = registerPlacedFeatureKey("patch_wild_garlic");
    public static ResourceKey<PlacedFeature> PATCH_WILD_GINGER = registerPlacedFeatureKey("patch_wild_ginger");
    public static ResourceKey<PlacedFeature> PATCH_WILD_LEMONGRASS = registerPlacedFeatureKey("patch_wild_lemongrass");

    public static void bootstrapConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        context.register(FEATURE_WILD_UBE, defaultWildCropConfiguredFeature(
                UbesDelightBlocks.WILD_UBE.get(),
                Blocks.CORNFLOWER,
                Blocks.TALL_GRASS,
                BlockTags.DIRT)
        );

        context.register(FEATURE_WILD_GARLIC, defaultWildCropConfiguredFeature(
                UbesDelightBlocks.WILD_GARLIC.get(),
                Blocks.PINK_TULIP,
                Blocks.TALL_GRASS,
                BlockTags.DIRT)
        );

        context.register(FEATURE_WILD_GINGER, defaultWildCropConfiguredFeature(
                UbesDelightBlocks.WILD_GINGER.get(),
                Blocks.LILY_OF_THE_VALLEY,
                Blocks.TALL_GRASS,
                BlockTags.DIRT)
        );

        context.register(FEATURE_WILD_LEMONGRASS, defaultWildCropConfiguredFeature(
                UbesDelightBlocks.WILD_LEMONGRASS.get(),
                Blocks.AZURE_BLUET,
                Blocks.TALL_GRASS,
                BlockTags.DIRT)
        );
    }

    public static void bootstrapPlacedFeatures(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureHolderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        context.register(PATCH_WILD_UBE, createPlacedFeature(configuredFeatureHolderGetter, FEATURE_WILD_UBE, 50));
        context.register(PATCH_WILD_GARLIC, createPlacedFeature(configuredFeatureHolderGetter, FEATURE_WILD_GARLIC, 80));
        context.register(PATCH_WILD_GINGER, createPlacedFeature(configuredFeatureHolderGetter, FEATURE_WILD_GINGER, 80));
        context.register(PATCH_WILD_LEMONGRASS, createPlacedFeature(configuredFeatureHolderGetter, FEATURE_WILD_LEMONGRASS, 80));
    }

    private static ConfiguredFeature<?, ?> defaultWildCropConfiguredFeature(Block primaryFeature, Block secondaryFeature, Block tertiaryFeature, TagKey<Block> blocksToTarget) {
        return defaultWildCropConfiguredFeature(
                plantPlacedFeature(primaryFeature, blocksToTarget),
                plantPlacedFeature(secondaryFeature, blocksToTarget),
                plantPlacedFeature(tertiaryFeature, blocksToTarget));
    }

    private static ConfiguredFeature<?, ?> defaultWildCropConfiguredFeature(Holder<PlacedFeature> primaryFeature, Holder<PlacedFeature> secondaryFeature, Holder<PlacedFeature> tertiaryFeature) {
        return new ConfiguredFeature<>(
                UbesDelightBiomeFeatures.WILD_TERTIARY_CROP.get(),
                new WildTertiaryCropConfiguration(64, 6, 3, primaryFeature, secondaryFeature, tertiaryFeature, null)
        );
    }

    private static Holder<PlacedFeature> plantPlacedFeature(Block block, TagKey<Block> blocksToPlaceOn) {
        return Holder.direct(new PlacedFeature(
                Holder.direct(new ConfiguredFeature<>(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(SimpleStateProvider.simple(block))
                )),
                placeOnTopOfModifier(blocksToPlaceOn)
        ));
    }

    private static List<PlacementModifier> placeOnTopOfModifier(TagKey<Block> blocksToPlaceOn) {
        return List.of(BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                BlockPredicate.matchesBlocks(Blocks.AIR),
                BlockPredicate.matchesTag(new Vec3i(0, -1, 0), blocksToPlaceOn)
        )));
    }

    private static List<PlacementModifier> replaceBlockModifier(TagKey<Block> blocksToReplace) {
        return List.of(BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                BlockPredicate.replaceable(new Vec3i(0, 1, 0)),
                BlockPredicate.matchesTag(blocksToReplace)
        )));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredFeatureKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, TextUtils.res(name));
    }

    private static ResourceKey<PlacedFeature> registerPlacedFeatureKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, TextUtils.res(name));
    }

    private static PlacedFeature createPlacedFeature(HolderGetter<ConfiguredFeature<?, ?>> featureGetter, ResourceKey<ConfiguredFeature<?, ?>> feature, int rarity) {
        return new PlacedFeature(featureGetter.getOrThrow(feature), List.of(
                RarityFilter.onAverageOnceEvery(rarity),
                InSquarePlacement.spread(),
                HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING),
                BiomeFilter.biome(),
                BiomeTagFilter.biomeIsInTag(BiomeTags.IS_OVERWORLD)
        ));
    }
}
