package com.chefmooon.ubesdelight.common.crafting.condition.fabric;

import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.RegistryOps;
import org.jetbrains.annotations.Nullable;

public class UDCrateEnabledCondition implements ResourceCondition {
    public static final MapCodec<UDCrateEnabledCondition> CODEC = MapCodec.unit(new UDCrateEnabledCondition());
    public static final ResourceConditionType<UDCrateEnabledCondition> TYPE = ResourceConditionType.create(TextUtils.res("ud_crates_enabled"), CODEC);

    @Override
    public boolean test(RegistryOps.@Nullable RegistryInfoLookup registryInfoLookup) {
        return Configuration.isEnableUDCropCrates();
    }

    @Override
    public ResourceConditionType<?> getType() {
        return TYPE;
    }
}
