package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.advancement.BakingMatTrigger;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;

import java.util.function.Supplier;

public class UbesDelightAdvancementsImpl {
    public static final DeferredRegister<CriterionTrigger<?>> TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, UbesDelight.MOD_ID);
    public static final Supplier<BakingMatTrigger> USE_BAKING_MAT = TRIGGERS.register("use_baking_mat", BakingMatTrigger::new);

    public static void register() {
        TRIGGERS.register();
    }

    public static Supplier<BakingMatTrigger> getBakingMatTrigger() {
        return USE_BAKING_MAT;
    }
}
