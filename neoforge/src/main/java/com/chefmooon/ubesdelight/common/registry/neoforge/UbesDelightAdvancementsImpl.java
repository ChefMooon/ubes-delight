package com.chefmooon.ubesdelight.common.registry.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.advancement.BakingMatTrigger;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightAdvancementsImpl {
    public static final DeferredRegister<CriterionTrigger<?>> TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, UbesDelight.MOD_ID);
    public static final Supplier<BakingMatTrigger> USE_BAKING_MAT = TRIGGERS.register("use_baking_mat", BakingMatTrigger::new);

    public static void register(IEventBus eventBus) {
        TRIGGERS.register(eventBus);
    }

    public static Supplier<BakingMatTrigger> getBakingMatTrigger() {
        return USE_BAKING_MAT;
    }
}
