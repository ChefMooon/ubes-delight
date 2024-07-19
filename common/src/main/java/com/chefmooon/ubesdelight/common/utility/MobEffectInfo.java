package com.chefmooon.ubesdelight.common.utility;

import net.minecraft.world.effect.MobEffect;

public record MobEffectInfo(MobEffect effect, int duration, Float probability) {
}
