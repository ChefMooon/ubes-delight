package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.utility.TextUtils;
import chefmooon.ubesdelight.common.world.UDWildCropGeneration;
import chefmooon.ubesdelight.common.world.modifier.AddFeaturesByFilterModifier;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Optional;
import java.util.function.Supplier;

public class UbesDelightBiomeModifiers {
    public static DeferredRegister<MapCodec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, UbesDelight.MOD_ID);

    public static Supplier<MapCodec<AddFeaturesByFilterModifier>> ADD_FEATURES_BY_FILTER = BIOME_MODIFIER_SERIALIZERS.register("add_features_by_filter", () ->
            RecordCodecBuilder.mapCodec(builder -> builder.group(
                    Biome.LIST_CODEC.fieldOf("allowed_biomes").forGetter(AddFeaturesByFilterModifier::allowedBiomes),
                    Biome.LIST_CODEC.optionalFieldOf("denied_biomes").orElse(Optional.empty()).forGetter(AddFeaturesByFilterModifier::deniedBiomes),
                    PlacedFeature.LIST_CODEC.fieldOf("features").forGetter(AddFeaturesByFilterModifier::features),
                    GenerationStep.Decoration.CODEC.fieldOf("step").forGetter(AddFeaturesByFilterModifier::step)
            ).apply(builder, AddFeaturesByFilterModifier::new)));

    public static ResourceKey<BiomeModifier> PATCH_WILD_UBE = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, TextUtils.res("patch_wild_ube"));
    public static ResourceKey<BiomeModifier> PATCH_WILD_GARLIC = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, TextUtils.res("patch_wild_garlic"));
    public static ResourceKey<BiomeModifier> PATCH_WILD_GINGER = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, TextUtils.res("patch_wild_ginger"));
    public static ResourceKey<BiomeModifier> PATCH_WILD_LEMONGRASS = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, TextUtils.res("patch_wild_lemongrass"));

    public static void bootstrapBiomeModifiers(BootstrapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomeGetter = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatureGetter = context.lookup(Registries.PLACED_FEATURE);

        context.register(PATCH_WILD_UBE, new AddFeaturesByFilterModifier(
                biomeGetter.getOrThrow(Tags.Biomes.IS_JUNGLE),
                Optional.of(biomeGetter.getOrThrow(Tags.Biomes.IS_UNDERGROUND)),
                HolderSet.direct(placedFeatureGetter.getOrThrow(UDWildCropGeneration.PATCH_WILD_UBE)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(PATCH_WILD_GARLIC, new AddFeaturesByFilterModifier(
                biomeGetter.getOrThrow(Tags.Biomes.IS_JUNGLE),
                Optional.of(biomeGetter.getOrThrow(Tags.Biomes.IS_UNDERGROUND)),
                HolderSet.direct(placedFeatureGetter.getOrThrow(UDWildCropGeneration.PATCH_WILD_GARLIC)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(PATCH_WILD_GINGER, new AddFeaturesByFilterModifier(
                biomeGetter.getOrThrow(Tags.Biomes.IS_JUNGLE),
                Optional.of(biomeGetter.getOrThrow(Tags.Biomes.IS_UNDERGROUND)),
                HolderSet.direct(placedFeatureGetter.getOrThrow(UDWildCropGeneration.PATCH_WILD_GINGER)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(PATCH_WILD_LEMONGRASS, new AddFeaturesByFilterModifier(
                biomeGetter.getOrThrow(Tags.Biomes.IS_JUNGLE),
                Optional.of(biomeGetter.getOrThrow(Tags.Biomes.IS_UNDERGROUND)),
                HolderSet.direct(placedFeatureGetter.getOrThrow(UDWildCropGeneration.PATCH_WILD_LEMONGRASS)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
    }

    public static void register(IEventBus eventBus) {
        BIOME_MODIFIER_SERIALIZERS.register(eventBus);
    }

    private static ResourceLocation biomeModifier(String string) {
        return TextUtils.res(string);
    }
}
