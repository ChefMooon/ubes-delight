package com.chefmooon.ubesdelight.common.crafting.condition.neoforge;

import com.chefmooon.ubesdelight.common.Configuration;
import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.conditions.ICondition;
import org.jetbrains.annotations.NotNull;

public class UDCrateEnabledCondition implements ICondition {
    public static final MapCodec<UDCrateEnabledCondition> CODEC = MapCodec.unit(new UDCrateEnabledCondition());

    public UDCrateEnabledCondition() {
    }

    @Override
    public boolean test(@NotNull IContext context) {
        return Configuration.isEnableUDCropCrates();
    }

    @Override
    public @NotNull MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}
