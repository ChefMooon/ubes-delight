package com.chefmooon.ubesdelight.common.world.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public record WildTertiaryCropConfiguration(
        int tries, int xzSpread, int ySpread,
        Holder<PlacedFeature> primaryFeature,
        Holder<PlacedFeature> secondaryFeature,
        Holder<PlacedFeature> tertiaryFeature,
        @Nullable Holder<PlacedFeature> floorFeature) implements FeatureConfiguration {

    public static final Codec<WildTertiaryCropConfiguration> CODEC = RecordCodecBuilder.create((config) -> config.group(
            ExtraCodecs.POSITIVE_INT.fieldOf("tries").orElse(64).forGetter(WildTertiaryCropConfiguration::tries),
            ExtraCodecs.NON_NEGATIVE_INT.fieldOf("xz_spread").orElse(4).forGetter(WildTertiaryCropConfiguration::xzSpread),
            ExtraCodecs.NON_NEGATIVE_INT.fieldOf("y_spread").orElse(3).forGetter(WildTertiaryCropConfiguration::ySpread),
            PlacedFeature.CODEC.fieldOf("primary_feature").forGetter(WildTertiaryCropConfiguration::primaryFeature),
            PlacedFeature.CODEC.fieldOf("secondary_feature").forGetter(WildTertiaryCropConfiguration::secondaryFeature),
            PlacedFeature.CODEC.fieldOf("tertiary_feature").forGetter(WildTertiaryCropConfiguration::tertiaryFeature),
            PlacedFeature.CODEC.optionalFieldOf("floor_feature").forGetter(floorConfig -> Optional.ofNullable(floorConfig.floorFeature))
    ).apply(config, (tries, xzSpread, yspread, primary, secondary, tertiary, floor) -> floor.map(placedFeatureHolder -> new WildTertiaryCropConfiguration(tries, xzSpread, yspread, primary, secondary, tertiary, placedFeatureHolder)).orElseGet(() -> new WildTertiaryCropConfiguration(tries, xzSpread, yspread, primary, secondary, tertiary, null))));

    public WildTertiaryCropConfiguration(int tries, int xzSpread, int ySpread, Holder<PlacedFeature> primaryFeature, Holder<PlacedFeature> secondaryFeature, Holder<PlacedFeature> tertiaryFeature, @Nullable Holder<PlacedFeature> floorFeature) {
        this.tries = tries;
        this.xzSpread = xzSpread;
        this.ySpread = ySpread;
        this.primaryFeature = primaryFeature;
        this.secondaryFeature = secondaryFeature;
        this.tertiaryFeature = tertiaryFeature;
        this.floorFeature = floorFeature;
    }

    public int tries() {
        return this.tries;
    }

    public int xzSpread() {
        return this.xzSpread;
    }

    public int ySpread() {
        return this.ySpread;
    }

    public Holder<PlacedFeature> primaryFeature() {
        return this.primaryFeature;
    }

    public Holder<PlacedFeature> secondaryFeature() {
        return this.secondaryFeature;
    }

    public Holder<PlacedFeature> tertiaryFeature() {
        return this.tertiaryFeature;
    }

    public Holder<PlacedFeature> floorFeature() {
        return this.floorFeature;
    }
}
