package com.chefmooon.ubesdelight.common;

import com.chefmooon.ubesdelight.common.utility.MobEffectInfo;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.List;

public class FoodValues {

    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    private static final Holder<MobEffect> COMFORT = ModEffects.COMFORT;
    private static final Holder<MobEffect> NOURISHMENT = ModEffects.NOURISHMENT;


    public static final FoodProperties UBE = foodProperty(2, 0.4F);
    public static final FoodProperties GARLIC = foodProperty(2, 0.4F);
    public static final FoodProperties GINGER = foodProperty(2, 0.4F);
    public static final FoodProperties LEMONGRASS = foodProperty(2, 0.4F);

    public static final FoodProperties SINANGAG = foodProperty(7, 0.45F,
            List.of(new MobEffectInfo(ModEffects.COMFORT, BRIEF_DURATION, 1.0F)));
    public static final FoodProperties KINILAW = foodProperty(6, 0.6F,
            List.of(new MobEffectInfo(ModEffects.COMFORT, SHORT_DURATION, 1.0F)));
    public static final FoodProperties LUMPIA = foodProperty(7, 0.7F,
            false, false, null);
    public static final FoodProperties TOCINO = foodProperty(8, 0.7F,
            true, false, null);
    public static final FoodProperties CHICKEN_INASAL = foodProperty(8, 0.7F,
            true, false, null);

    public static final FoodProperties CHICKEN_INASAL_RICE = foodProperty(13, 0.75F,
            false, false, List.of(new MobEffectInfo(ModEffects.NOURISHMENT, LONG_DURATION, 1.0F)));
    public static final FoodProperties TOSILOG = foodProperty(13, 0.75F,
            false, false, List.of(new MobEffectInfo(ModEffects.NOURISHMENT, LONG_DURATION, 1.0F)));
    public static final FoodProperties BANGSILOG = foodProperty(13, 0.75F,
            false, false, List.of(new MobEffectInfo(ModEffects.NOURISHMENT, LONG_DURATION, 1.0F)));
    public static final FoodProperties SISIG = foodProperty(13, 0.7F,
            false, false, List.of(new MobEffectInfo(ModEffects.NOURISHMENT, LONG_DURATION, 1.0F)));
    public static final FoodProperties BULALO = foodProperty(14, 0.75F,
            false, false, List.of(new MobEffectInfo(ModEffects.COMFORT, LONG_DURATION, 1.0F)));
    public static final FoodProperties ARROZ_CALDO = foodProperty(14, 0.75F,
            false, false, List.of(new MobEffectInfo(ModEffects.COMFORT, LONG_DURATION, 1.0F)));
    public static final FoodProperties MECHADO = foodProperty(14, 0.75F,
            false, false, List.of(new MobEffectInfo(ModEffects.COMFORT, LONG_DURATION, 1.0F)));

    public static final FoodProperties CONDENSED_MILK_BOTTLE = foodProperty(0, 0.0F,
            false, true, List.of(new MobEffectInfo(MobEffects.MOVEMENT_SPEED, SHORT_DURATION, 1.0F)));
    public static final FoodProperties FISH_SAUCE_BOTTLE = foodProperty(0, 0.0F,
            false, false, List.of(new MobEffectInfo(MobEffects.DOLPHINS_GRACE, SHORT_DURATION, 1.0F)));

    public static final FoodProperties MILK_TEA_UBE = foodProperty(0, 0.0F,
            false, false, List.of(new MobEffectInfo(MobEffects.NIGHT_VISION, SHORT_DURATION, 1.0F)));
    public static final FoodProperties HALO_HALO = foodProperty(0, 0.0F,
            false, false, List.of(new MobEffectInfo(ModEffects.NOURISHMENT, MEDIUM_DURATION, 1.0F)));

    public static final FoodProperties GARLIC_CHOP = foodProperty(1, 0.4F);
    public static final FoodProperties GINGER_CHOP = foodProperty(1, 0.4F);

    public static final FoodProperties LECHE_FLAN = foodProperty(3, 0.4F);
    public static final FoodProperties COOKIES = foodProperty(2, 0.1F, true, false, null);
    public static final FoodProperties POLVORONE = foodProperty(2, 0.2F, true, false, null);

    public static final FoodProperties UBE_CAKE_SLICE = foodProperty(2, 0.1F,
            true, false, List.of(new MobEffectInfo(MobEffects.NIGHT_VISION, BRIEF_DURATION, 1.0F)));

    public static final FoodProperties PANDESAL = foodProperty(8, 0.8F);
    public static final FoodProperties PANDESAL_UBE = foodProperty(9, 0.8F,
            List.of(new MobEffectInfo(MobEffects.NIGHT_VISION, MEDIUM_DURATION, 1.0F)));
    public static final FoodProperties PANDESAL_RAW = foodProperty(2, 0.3F,
            List.of(new MobEffectInfo(MobEffects.HUNGER, BRIEF_DURATION, 0.3F)));
    public static final FoodProperties ENSAYMADA = foodProperty(9, 0.9F);
    public static final FoodProperties ENSAYMADA_UBE = foodProperty(10, 0.9F,
            List.of(new MobEffectInfo(MobEffects.NIGHT_VISION, MEDIUM_DURATION, 1.0F)));
    public static final FoodProperties ENSAYMADA_RAW = foodProperty(2, 0.3F,
            List.of(new MobEffectInfo(MobEffects.HUNGER, BRIEF_DURATION, 0.3F)));
    public static final FoodProperties HOPIA_MUNGGO = foodProperty(7, 0.7F);
    public static final FoodProperties HOPIA_UBE = foodProperty(7, 0.7F,
            List.of(new MobEffectInfo(MobEffects.NIGHT_VISION, MEDIUM_DURATION, 1.0F)));
    public static final FoodProperties HOPIA_RAW = foodProperty(2, 0.3F,
            List.of(new MobEffectInfo(MobEffects.HUNGER, BRIEF_DURATION, 0.3F)));

    public static FoodProperties foodProperty(int nutrition, float saturation) {
        return foodProperty(nutrition, saturation, false, false, null);
    }
    public static FoodProperties foodProperty(int nutrition, float saturation, List<MobEffectInfo> effects) {
        return foodProperty(nutrition, saturation, false, false, effects);
    }
    @ExpectPlatform
    public static FoodProperties foodProperty(int nutrition, float saturation, boolean isFast, boolean alwaysEat, @Nullable List<MobEffectInfo> effects) {
        throw new AssertionError();
    }

    // In Dev only? stops null pointer before effects are fully registered, I think.
    // The below methods[getComfort()/getNourishment()] may fix this
    // TODO: needs more testing, possible bug.
    public static Holder<MobEffect> nonNullEffect(Holder<MobEffect> effect) {
        return effect != null ? effect : MobEffects.HEAL;
    }
}
