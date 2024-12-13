package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.advancement.BakingMatTrigger;
import com.chefmooon.ubesdelight.common.advancement.LeafFeastConsumeTrigger;
import com.chefmooon.ubesdelight.common.advancement.LeafFeastInsertTrigger;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.advancements.CriterionTrigger;

import java.util.function.Supplier;

public class UbesDelightAdvancements {
    public static final Supplier<BakingMatTrigger> USE_BAKING_MAT = registerTrigger("use_baking_mat", BakingMatTrigger::new);
    public static final Supplier<LeafFeastInsertTrigger> USE_LEAF_FEAST_INSERT = registerTrigger("use_leaf_feast_insert", LeafFeastInsertTrigger::new);
    public static final Supplier<LeafFeastConsumeTrigger> USE_LEAF_FEAST_CONSUME = registerTrigger("use_leaf_feast_consume",LeafFeastConsumeTrigger::new);

    @ExpectPlatform
    public static <T extends CriterionTrigger<?>> Supplier<T> registerTrigger(String name, Supplier<T> triggerSupplier) {
        throw new AssertionError();
    }

    public static void init() {

    }

}
