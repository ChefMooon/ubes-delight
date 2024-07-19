package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.UbesDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class UbesDelightDamageTypes {
    public static final ResourceKey<DamageType> KALAN_BURN = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(UbesDelight.MOD_ID, "kalan_burn"));

    public static DamageSource getSimpleDamageSource(Level level, ResourceKey<DamageType> type) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type));
    }
}
