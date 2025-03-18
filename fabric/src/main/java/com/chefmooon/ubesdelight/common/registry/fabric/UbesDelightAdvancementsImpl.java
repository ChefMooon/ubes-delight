package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.utility.fabric.RegistrationUtilsImpl;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;

public class UbesDelightAdvancementsImpl {
    public static <T extends CriterionTrigger<?>> Supplier<T> registerTrigger(String name, Supplier<T> triggerSupplier) {
        return RegistrationUtilsImpl.register(name, triggerSupplier, BuiltInRegistries.TRIGGER_TYPES);
    }

    public static void register() {
    }
}
