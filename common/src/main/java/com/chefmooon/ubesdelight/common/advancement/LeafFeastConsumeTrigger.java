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

public class LeafFeastConsumeTrigger extends SimpleCriterionTrigger<LeafFeastConsumeTrigger.TriggerInstance> {

    @Override
    public Codec<LeafFeastConsumeTrigger.TriggerInstance> codec() {
        return LeafFeastConsumeTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, LeafFeastConsumeTrigger.TriggerInstance::test);
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<LeafFeastConsumeTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(
                                EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(LeafFeastConsumeTrigger.TriggerInstance::player))
                        .apply(builder, LeafFeastConsumeTrigger.TriggerInstance::new)
        );

        public static Criterion<LeafFeastConsumeTrigger.TriggerInstance> simple() {
            return UbesDelightAdvancements.USE_LEAF_FEAST_CONSUME.get().createCriterion(
                    new LeafFeastConsumeTrigger.TriggerInstance(Optional.empty())
            );
        }

        public boolean test() {
            return true;
        }
    }
}
