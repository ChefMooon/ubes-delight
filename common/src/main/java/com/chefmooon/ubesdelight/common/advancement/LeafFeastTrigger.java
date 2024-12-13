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

public class LeafFeastTrigger extends SimpleCriterionTrigger<LeafFeastTrigger.TriggerInstance> {

    @Override
    public Codec<TriggerInstance> codec() {
        return LeafFeastTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, LeafFeastTrigger.TriggerInstance::test);
    }

    public static record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<LeafFeastTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(
                        EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(LeafFeastTrigger.TriggerInstance::player))
                        .apply(builder, LeafFeastTrigger.TriggerInstance::new)

        );

        public static Criterion<LeafFeastTrigger.TriggerInstance> simple() {
            return UbesDelightAdvancements.USE_LEAF_FEAST.get().createCriterion(
                    new LeafFeastTrigger.TriggerInstance(Optional.empty())
            );
        }

        public boolean test() {
            return true;
        }
    }
}
