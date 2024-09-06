package com.chefmooon.ubesdelight.common.utility;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;

public record MobEffectInfo(Holder<MobEffect> effect, int duration, Float probability) {
}
