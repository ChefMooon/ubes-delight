package com.chefmooon.ubesdelight.common.advancement;

import com.chefmooon.ubesdelight.common.registry.UbesDelightAdvancements;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.ContextAwarePredicate;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class LeafFeastInsertTrigger extends SimpleCriterionTrigger<LeafFeastInsertTrigger.TriggerInstance> {

    @Override
    public Codec<TriggerInstance> codec() {
        return LeafFeastInsertTrigger.TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, LeafFeastInsertTrigger.TriggerInstance::test);
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<LeafFeastInsertTrigger.TriggerInstance> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(
                        EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(LeafFeastInsertTrigger.TriggerInstance::player))
                        .apply(builder, LeafFeastInsertTrigger.TriggerInstance::new)
        );

        public static Criterion<LeafFeastInsertTrigger.TriggerInstance> simple() {
            return UbesDelightAdvancements.USE_LEAF_FEAST_INSERT.get().createCriterion(
                    new LeafFeastInsertTrigger.TriggerInstance(Optional.empty())
            );
        }

        public boolean test() {
            return true;
        }
    }
}
