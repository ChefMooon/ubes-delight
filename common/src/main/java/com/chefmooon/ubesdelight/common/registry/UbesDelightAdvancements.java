package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.advancement.BakingMatTrigger;
import com.chefmooon.ubesdelight.common.advancement.LeafFeastConsumeTrigger;
import com.chefmooon.ubesdelight.common.advancement.LeafFeastInsertTrigger;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.CriterionTrigger;

import java.util.function.Supplier;

public class UbesDelightAdvancements {

    public static BakingMatTrigger BAKING_MAT = new BakingMatTrigger();
    public static LeafFeastInsertTrigger USE_LEAF_FEAST_INSERT = new LeafFeastInsertTrigger();
    public static LeafFeastConsumeTrigger USE_LEAF_FEAST_CONSUME = new LeafFeastConsumeTrigger();

//    public static final Supplier<LeafFeastInsertTrigger> USE_LEAF_FEAST_INSERT = registerTrigger("use_leaf_feast_insert", LeafFeastInsertTrigger::new);
//    public static final Supplier<LeafFeastConsumeTrigger> USE_LEAF_FEAST_CONSUME = registerTrigger("use_leaf_feast_consume",LeafFeastConsumeTrigger::new);


    public static void register() {
        CriteriaTriggers.register(BAKING_MAT);
        CriteriaTriggers.register(USE_LEAF_FEAST_INSERT);
        CriteriaTriggers.register(USE_LEAF_FEAST_CONSUME);
    }
}
