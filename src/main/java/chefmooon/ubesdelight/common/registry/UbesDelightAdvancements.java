package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.advancement.BakingMatTrigger;
import chefmooon.ubesdelight.common.advancement.LeafFeastConsumeTrigger;
import chefmooon.ubesdelight.common.advancement.LeafFeastInsertTrigger;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.function.Supplier;

public class UbesDelightAdvancements {

    public static final Supplier<BakingMatTrigger> USE_BAKING_MAT = registerTrigger("use_baking_mat", BakingMatTrigger::new);
    public static final Supplier<LeafFeastInsertTrigger> USE_LEAF_FEAST_INSERT = registerTrigger("use_leaf_feast_insert", LeafFeastInsertTrigger::new);
    public static final Supplier<LeafFeastConsumeTrigger> USE_LEAF_FEAST_CONSUME = registerTrigger("use_leaf_feast_consume",LeafFeastConsumeTrigger::new);

    public static <T extends CriterionTrigger<?>> Supplier<T> registerTrigger(String name, Supplier<T> triggerSupplier) {
        var trigger = triggerSupplier.get();
        Registry.register(BuiltInRegistries.TRIGGER_TYPES, TextUtils.res(name), trigger);
        return () -> trigger;
    }

    public static void register() {

    }

}
