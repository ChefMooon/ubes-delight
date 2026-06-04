package chefmooon.ubesdelight.common.crafting.condition;

import chefmooon.ubesdelight.common.Configuration;
import chefmooon.ubesdelight.common.utility.TextUtils;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditionType;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.Nullable;

public class UDCrateEnabledCondition implements ResourceCondition {
    public static final MapCodec<UDCrateEnabledCondition> CODEC = MapCodec.unit(new UDCrateEnabledCondition());
    public static final ResourceConditionType<UDCrateEnabledCondition> TYPE = ResourceConditionType.create(TextUtils.res("ud_crates_enabled"), CODEC);

    @Override
    public boolean test(HolderLookup.@Nullable Provider registryLookup) {
        return Configuration.isEnableUDCropCrates();
    }

    @Override
    public ResourceConditionType<?> getType() {
        return TYPE;
    }
}
