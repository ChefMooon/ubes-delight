package com.chefmooon.ubesdelight.common.neoforge;


import com.chefmooon.ubesdelight.common.FoodValues;
import com.chefmooon.ubesdelight.common.utility.MobEffectInfo;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FoodValuesImpl {

    public static FoodProperties foodProperty(int nutrition, float saturation, boolean isFast, boolean alwaysEat, @Nullable List<MobEffectInfo> effects) {
        FoodProperties.Builder builder = new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation);

        if (effects != null) {
            for (MobEffectInfo effectInfo : effects) {
                builder.effect(() -> new MobEffectInstance(FoodValues.nonNullEffect(effectInfo.effect()), effectInfo.duration()), effectInfo.probability());
            }
        }

        if (isFast) {
            builder.fast();
        }

        if (alwaysEat) {
            builder.alwaysEdible();
        }

        return builder.build();
    }
}
