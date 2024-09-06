package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.advancement.BakingMatTrigger;
import dev.architectury.injectables.annotations.ExpectPlatform;

import java.util.function.Supplier;

public class UbesDelightAdvancements {
//    public static final DeferredRegister<CriterionTrigger<?>> TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, UbesDelight.MOD_ID);
//    public static final Supplier<BakingMatTrigger> USE_BAKING_MAT = TRIGGERS.register("use_baking_mat", BakingMatTrigger::new);
//
//    public static void register() {
//        TRIGGERS.register();
//    }

    @ExpectPlatform
    public static Supplier<BakingMatTrigger> getBakingMatTrigger() {
        throw new AssertionError();
    }
}
