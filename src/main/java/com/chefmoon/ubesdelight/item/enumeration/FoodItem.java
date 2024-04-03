package com.chefmoon.ubesdelight.item.enumeration;

import com.chefmoon.ubesdelight.item.UDConsumableItem;
import com.nhoryzon.mc.farmersdelight.registry.EffectsRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

import java.util.function.Supplier;

public enum FoodItem {

    //Whole vegetables
    UBE(2, .4f),
    GARLIC(2, .4f),
    GINGER(2, .4f),
    LEMONGRASS(2, .4f),

    //Finger Foods
    SINANGAG(7, .45f, () -> new StatusEffectInstance(EffectsRegistry.COMFORT.get(), UDConsumableItem.BRIEF_DURATION, 0), 1.f),
    KINILAW(6, .6f, () -> new StatusEffectInstance(EffectsRegistry.COMFORT.get(), UDConsumableItem.SHORT_DURATION, 0), 1.f, true, false, false),
    LUMPIA(7, .7f, null,0.f, true, false, false),
    TOCINO(8, .7f, null,.0f, true, true, false),
    CHICKEN_INASAL(8, .7f, null,.0f, true, true, false),

    //Meals
    CHICKEN_INASAL_RICE(13, .75f, () -> new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(), UDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),
    TOSILOG(13, .75f, () -> new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(), UDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),
    BANGSILOG(13, .75f, () -> new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(), UDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),
    SISIG(13, .7f, () -> new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(), UDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),
    BULALO(14, .75f, () -> new StatusEffectInstance(EffectsRegistry.COMFORT.get(), UDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),
    ARROZ_CALDO(14, .75f, () -> new StatusEffectInstance(EffectsRegistry.COMFORT.get(), UDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),
    MECHADO(14, .75f, () -> new StatusEffectInstance(EffectsRegistry.COMFORT.get(), UDConsumableItem.LONG_DURATION, 0),1.f, true, false, false),


    //Drinkables
    CONDENSED_MILK_BOTTLE(0, 0, () -> new StatusEffectInstance(StatusEffects.SPEED, UDConsumableItem.SHORT_DURATION, 0), 1.f, false, false, true),
    FISH_SAUCE_BOTTLE(0, 0, () -> new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, UDConsumableItem.SHORT_DURATION, 0), 1.f, false, false, true),

    //Milk Teas
    MILK_TEA_UBE(0, 0, () -> new StatusEffectInstance(StatusEffects.NIGHT_VISION, UDConsumableItem.SHORT_DURATION, 0), 1.f, false, false, true),
    HALO_HALO(0, 0, () -> new StatusEffectInstance(EffectsRegistry.NOURISHMENT.get(), UDConsumableItem.MEDIUM_DURATION, 0), 1.f, false, false, true),

    //Non-whole vegetables
    GARLIC_CHOP(1, .4f),
    GINGER_CHOP(1, .4f),

    //Sweets
    LECHE_FLAN(3, .4f),
    COOKIES(2, .1f, null,.0f, false, true, false),
    POLVORONE(2, .2f, null,.0f, false, true, false),

    //Slices
    UBE_CAKE_SLICE(2, .1f, () -> new StatusEffectInstance(StatusEffects.NIGHT_VISION, UDConsumableItem.BRIEF_DURATION, 0), 1.f, false, true, false),

    //Bread
    PANDESAL(8, .8f),
    PANDESAL_UBE(9, .8f, () -> new StatusEffectInstance(StatusEffects.NIGHT_VISION, UDConsumableItem.MEDIUM_DURATION, 0), 1.f),
    PANDESAL_RAW(2, .3f, () -> new StatusEffectInstance(StatusEffects.HUNGER, UDConsumableItem.BRIEF_DURATION, 0), .3f),
    ENSAYMADA(9, .9f),
    ENSAYMADA_UBE(10, .9f, () -> new StatusEffectInstance(StatusEffects.NIGHT_VISION, UDConsumableItem.MEDIUM_DURATION, 0), 1.f),
    ENSAYMADA_RAW(2, .3f, () -> new StatusEffectInstance(StatusEffects.HUNGER, UDConsumableItem.BRIEF_DURATION, 0), .3f),
    HOPIA_MUNGGO(7, .7f),
    HOPIA_UBE(7, .7f, () -> new StatusEffectInstance(StatusEffects.NIGHT_VISION, UDConsumableItem.MEDIUM_DURATION, 0), 1.f),
    HOPIA_RAW(2, .3f, () -> new StatusEffectInstance(StatusEffects.HUNGER, UDConsumableItem.BRIEF_DURATION, 0), .3f);

    private final Supplier<FoodComponent> food;
    FoodItem(int hunger, float saturation) {
        this(hunger, saturation, null, .0f, false, false, false);
    }

    FoodItem(int hunger, float saturation, boolean isMeat) {
        this(hunger, saturation, null, .0f, isMeat, false, false);
    }

    FoodItem(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance) {
        this(hunger, saturation, effect, effectChance, false, false, false);
    }

    FoodItem(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance, boolean isMeat) {
        this(hunger, saturation, effect, effectChance, isMeat, false, false);
    }
    FoodItem(int hunger, float saturation, Supplier<StatusEffectInstance> effect, float effectChance, boolean isMeat, boolean isFastToEat, boolean alwaysEdible) {
        food = () -> {
            FoodComponent.Builder builder = new FoodComponent.Builder();
            builder.hunger(hunger).saturationModifier(saturation);
            if (effect != null) {
                builder.statusEffect(effect.get(), effectChance);
            }
            if (isMeat) {
                builder.meat();
            }
            if (isFastToEat) {
                builder.snack();
            }
            if (alwaysEdible) {
                builder.alwaysEdible();
            }
            return builder.build();
        };
    }

    public FoodComponent get() {
        return food.get();
    }
}
