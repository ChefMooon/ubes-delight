package com.chefmooon.ubesdelight.common.crafting.condition.fabric;

import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.mojang.serialization.MapCodec;
import io.github.fabricators_of_create.porting_lib.conditions.ICondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.Nullable;

public class UDCrateEnabledCondition implements ICondition {
    public static final MapCodec<UDCrateEnabledCondition> CODEC = MapCodec.unit(new UDCrateEnabledCondition());
    public static final ResourceConditionType<UDCrateEnabledCondition> TYPE = ResourceConditionType.create(TextUtils.res("ud_crates_enabled"), CODEC);

    @Override
    public boolean test(HolderLookup.@Nullable Provider registryLookup, IContext context) {
        return Configuration.isEnableUDCropCrates();
    }

    @Override
    public ResourceConditionType<?> getType() {
        return TYPE;
    }
}
