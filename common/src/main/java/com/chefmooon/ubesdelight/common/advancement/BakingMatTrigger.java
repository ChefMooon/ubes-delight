package com.chefmooon.ubesdelight.common.advancement;

import com.chefmooon.ubesdelight.common.registry.UbesDelightAdvancements;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class BakingMatTrigger extends SimpleCriterionTrigger<BakingMatTrigger.TriggerInstance> {
    @Override
    public Codec<TriggerInstance> codec() {
        return BakingMatTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, TriggerInstance::test);
    }

    public static record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance
    {
        public static final Codec<BakingMatTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(
                        EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(BakingMatTrigger.TriggerInstance::player))
                        .apply(builder, BakingMatTrigger.TriggerInstance::new)
        );
        public static Criterion<TriggerInstance> simple() {
            return UbesDelightAdvancements.getBakingMatTrigger().get().createCriterion(
                    new BakingMatTrigger.TriggerInstance(Optional.empty())
            );
        }

        public boolean test() {
            return true;
        }
    }
}
