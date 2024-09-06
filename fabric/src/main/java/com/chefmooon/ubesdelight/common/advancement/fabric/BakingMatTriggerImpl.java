package com.chefmooon.ubesdelight.common.advancement.fabric;

import com.chefmooon.ubesdelight.common.advancement.BakingMatTrigger;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightAdvancementsImpl;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;

import java.util.Optional;

public class BakingMatTriggerImpl extends BakingMatTrigger {
    public static record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance
    {
        public static final Codec<BakingMatTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(
                                EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(BakingMatTrigger.TriggerInstance::player))
                        .apply(builder, BakingMatTrigger.TriggerInstance::new)
        );
        public static Criterion<BakingMatTrigger.TriggerInstance> simple() {
            return UbesDelightAdvancementsImpl.USE_BAKING_MAT.get().createCriterion(
                    new BakingMatTrigger.TriggerInstance(Optional.empty())
            );
        }

        public boolean test() {
            return true;
        }
    }
}
