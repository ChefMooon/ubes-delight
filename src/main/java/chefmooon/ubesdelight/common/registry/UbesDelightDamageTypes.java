package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;

public class UbesDelightDamageTypes {
    public static final ResourceKey<DamageType> KALAN_BURN = ResourceKey.create(Registries.DAMAGE_TYPE, TextUtils.res("kalan_burn"));

    public static DamageSource getSimpleDamageSource(Level level, ResourceKey<DamageType> type) {
        return new DamageSource(level.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(type));
    }

    public static void bootstrapDamageTypes(BootstrapContext<DamageType> context) {
        context.register(KALAN_BURN, new DamageType(
                "ubesdelight.kalan_burn",
                DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER,
                0.1f,
                DamageEffects.BURNING
        ));
    }
}
