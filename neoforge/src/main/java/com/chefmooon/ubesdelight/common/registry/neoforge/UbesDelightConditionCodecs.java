package com.chefmooon.ubesdelight.common.registry.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.crafting.condition.neoforge.UDCrateEnabledCondition;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class UbesDelightConditionCodecs {
    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_CODECS = DeferredRegister.create(NeoForgeRegistries.CONDITION_SERIALIZERS, UbesDelight.MOD_ID);
    public static final Supplier<MapCodec<? extends ICondition>> UD_CRATES_ENABLED = CONDITION_CODECS.register("ud_crates_enabled", () -> UDCrateEnabledCondition.CODEC);

    public static void register(IEventBus eventBus) {
        CONDITION_CODECS.register(eventBus);
    }
}
