package com.chefmooon.ubesdelight.common.fabric;

import net.minecraft.world.food.FoodProperties;

public class FoodValuesImpl {

    public static FoodProperties foodProperty(int nutrition, float saturation, boolean alwaysEat) {
        FoodProperties.Builder builder = new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation);

        if (alwaysEat) {
            builder.alwaysEdible();
        }

        return builder.build();
    }
}
