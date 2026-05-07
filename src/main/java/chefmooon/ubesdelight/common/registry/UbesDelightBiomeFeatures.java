package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.world.configuration.WildTertiaryCropConfiguration;
import chefmooon.ubesdelight.common.world.feature.WildTertiaryCropFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightBiomeFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, UbesDelight.MOD_ID);
    public static final Supplier<Feature<WildTertiaryCropConfiguration>> WILD_TERTIARY_CROP = FEATURES.register("wild_tertiary_crop", () -> new WildTertiaryCropFeature(WildTertiaryCropConfiguration.CODEC));

    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}
