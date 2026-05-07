package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.advancement.BakingMatTrigger;
import chefmooon.ubesdelight.common.advancement.LeafFeastConsumeTrigger;
import chefmooon.ubesdelight.common.advancement.LeafFeastInsertTrigger;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightAdvancements {
    public static final DeferredRegister<CriterionTrigger<?>> TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, UbesDelight.MOD_ID);

    public static final Supplier<BakingMatTrigger> USE_BAKING_MAT = TRIGGERS.register("use_baking_mat", BakingMatTrigger::new);
    public static final Supplier<LeafFeastInsertTrigger> USE_LEAF_FEAST_INSERT = TRIGGERS.register("use_leaf_feast_insert", LeafFeastInsertTrigger::new);
    public static final Supplier<LeafFeastConsumeTrigger> USE_LEAF_FEAST_CONSUME = TRIGGERS.register("use_leaf_feast_consume",LeafFeastConsumeTrigger::new);

    public static void register(IEventBus eventBus) {
        TRIGGERS.register(eventBus);
    }

}
