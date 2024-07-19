package com.chefmooon.ubesdelight.common.advancement;

import com.chefmooon.ubesdelight.UbesDelight;
import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class BakingMatTrigger extends SimpleCriterionTrigger<BakingMatTrigger.TriggerInstance> {
    private static final ResourceLocation ID = new ResourceLocation(UbesDelight.MOD_ID, "use_baking_mat");
    @Override
    protected BakingMatTrigger.TriggerInstance createInstance(JsonObject json, ContextAwarePredicate predicate, DeserializationContext deserializationContext) {
        return new TriggerInstance(predicate);
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, TriggerInstance::test);
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance
    {
        public TriggerInstance(ContextAwarePredicate player) {
            super(BakingMatTrigger.ID, player);
        }

        public static TriggerInstance simple() {
            return new TriggerInstance(ContextAwarePredicate.ANY);
        }

        public boolean test() {
            return true;
        }
    }
}
