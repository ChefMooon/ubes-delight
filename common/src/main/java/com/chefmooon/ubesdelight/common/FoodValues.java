package com.chefmooon.ubesdelight.common;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FoodValues {

    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    private static final Holder<MobEffect> COMFORT = ModEffects.COMFORT;
    private static final Holder<MobEffect> NOURISHMENT = ModEffects.NOURISHMENT;

    public static ApplyStatusEffectsConsumeEffect comfort(int duration) {
        return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(COMFORT, duration, 0), 1.0F);
    }

    public static ApplyStatusEffectsConsumeEffect nourishment(int duration) {
        return new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(NOURISHMENT, duration, 0), 1.0F);
    }


    public static final FoodProperties UBE = foodProperty(2, 0.4F);
    public static final FoodProperties GARLIC = foodProperty(2, 0.4F);
    public static final FoodProperties GINGER = foodProperty(2, 0.4F);
    public static final FoodProperties LEMONGRASS = foodProperty(2, 0.4F);

    public static final FoodProperties SINANGAG = foodProperty(7, 0.45F);
    public static final FoodProperties KINILAW = foodProperty(6, 0.6F);
    public static final FoodProperties LUMPIA = foodProperty(7, 0.7F);
    public static final FoodProperties TOCINO = foodProperty(8, 0.7F);
    public static final FoodProperties CHICKEN_INASAL = foodProperty(8, 0.7F);

    public static final FoodProperties CHICKEN_INASAL_RICE = foodProperty(13, 0.75F);
    public static final FoodProperties TOSILOG = foodProperty(13, 0.75F);
    public static final FoodProperties BANGSILOG = foodProperty(13, 0.75F);
    public static final FoodProperties SISIG = foodProperty(13, 0.7F);
    public static final FoodProperties BULALO = foodProperty(14, 0.75F);
    public static final FoodProperties ARROZ_CALDO = foodProperty(14, 0.75F);
    public static final FoodProperties MECHADO = foodProperty(14, 0.75F);

    public static final FoodProperties CONDENSED_MILK_BOTTLE = foodProperty(0, 0.0F, true);
    public static final FoodProperties FISH_SAUCE_BOTTLE = foodProperty(0, 0.0F, true);

    public static final FoodProperties MILK_TEA_UBE = foodProperty(0, 0.0F);
    public static final FoodProperties HALO_HALO = foodProperty(0, 0.0F);

    public static final FoodProperties GARLIC_CHOP = foodProperty(1, 0.4F);
    public static final FoodProperties GINGER_CHOP = foodProperty(1, 0.4F);

    public static final FoodProperties LECHE_FLAN = foodProperty(3, 0.4F);
    public static final FoodProperties COOKIES = foodProperty(2, 0.1F);
    public static final FoodProperties POLVORONE = foodProperty(2, 0.2F);

    public static final FoodProperties UBE_CAKE_SLICE = foodProperty(2, 0.1F);

    public static final FoodProperties PANDESAL = foodProperty(8, 0.8F);
    public static final FoodProperties PANDESAL_UBE = foodProperty(9, 0.8F);
    public static final FoodProperties PANDESAL_RAW = foodProperty(2, 0.3F);
    public static final FoodProperties ENSAYMADA = foodProperty(9, 0.9F);
    public static final FoodProperties ENSAYMADA_UBE = foodProperty(10, 0.9F);
    public static final FoodProperties ENSAYMADA_RAW = foodProperty(2, 0.3F);
    public static final FoodProperties HOPIA_MUNGGO = foodProperty(7, 0.7F);
    public static final FoodProperties HOPIA_UBE = foodProperty(7, 0.7F);
    public static final FoodProperties HOPIA_RAW = foodProperty(2, 0.3F);

    public static FoodProperties foodProperty(int nutrition, float saturation) {
        return foodProperty(nutrition, saturation, false);
    }
    @ExpectPlatform
    public static FoodProperties foodProperty(int nutrition, float saturation, boolean alwaysEat) {
        throw new AssertionError();
    }

    public static class ConsumableValues {

        public static final Consumable FAST_FOOD = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .build();

        public static final Consumable RAW_DOUGH = Consumables.defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HUNGER, BRIEF_DURATION, 0), 0.3F))
                .build();

        public static final Consumable SINANGAG = Consumables.defaultFood()
                .onConsume(comfort(BRIEF_DURATION))
                .build();

        public static final Consumable KINILAW = Consumables.defaultFood()
                .onConsume(comfort(SHORT_DURATION))
                .build();

        public static final Consumable CHICKEN_INASAL_RICE = Consumables.defaultFood()
                .onConsume(nourishment(LONG_DURATION))
                .build();

        public static final Consumable TOSILOG = Consumables.defaultFood()
                .onConsume(nourishment(LONG_DURATION))
                .build();

        public static final Consumable BANGSILOG = Consumables.defaultFood()
                .onConsume(nourishment(LONG_DURATION))
                .build();

        public static final Consumable SISIG = Consumables.defaultFood()
                .onConsume(nourishment(LONG_DURATION))
                .build();

        public static final Consumable BULALO = Consumables.defaultFood()
                .onConsume(comfort(LONG_DURATION))
                .build();

        public static final Consumable ARROZ_CALDO = Consumables.defaultFood()
                .onConsume(comfort(LONG_DURATION))
                .build();

        public static final Consumable MECHADO = Consumables.defaultFood()
                .onConsume(comfort(LONG_DURATION))
                .build();

        public static final Consumable CONDENSED_MILK_BOTTLE = Consumables.defaultDrink()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, SHORT_DURATION, 0), 1.0F))
                .build();

        public static final Consumable FISH_SAUCE_BOTTLE = Consumables.defaultDrink()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, SHORT_DURATION, 0), 1.0F))
                .build();

        public static final Consumable MILK_TEA_UBE = Consumables.defaultDrink()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, SHORT_DURATION, 0), 1.0F))
                .build();

        public static final Consumable HALO_HALO = Consumables.defaultDrink()
                .onConsume(nourishment(MEDIUM_DURATION))
                .build();

        public static final Consumable UBE_CAKE_SLICE = Consumables.defaultFood()
                .consumeSeconds(0.8F)
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, BRIEF_DURATION, 0), 1.0F))
                .build();

        public static final Consumable PASTRY_UBE = Consumables.defaultFood()
                .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, MEDIUM_DURATION, 0), 1.0F))
                .build();
    }
}
