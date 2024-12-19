package com.chefmooon.ubesdelight.common.advancement;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.UbesDelightAdvancements;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class LeafFeastConsumeTrigger extends SimpleCriterionTrigger<LeafFeastConsumeTrigger.TriggerInstance> {

    private static final ResourceLocation ID = new ResourceLocation(UbesDelight.MOD_ID, "use_leaf_feast_consume");
    @Override
    protected LeafFeastConsumeTrigger.TriggerInstance createInstance(JsonObject json, ContextAwarePredicate predicate, DeserializationContext deserializationContext) {
        return new LeafFeastConsumeTrigger.TriggerInstance(predicate);
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, LeafFeastConsumeTrigger.TriggerInstance::test);
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance
    {
        public TriggerInstance(ContextAwarePredicate player) {
            super(LeafFeastConsumeTrigger.ID, player);
        }

        public static LeafFeastConsumeTrigger.TriggerInstance simple() {
            return new LeafFeastConsumeTrigger.TriggerInstance(ContextAwarePredicate.ANY);
        }

        public boolean test() {
            return true;
        }
    }

//    @Override
//    public Codec<TriggerInstance> codec() {
//        return TriggerInstance.CODEC;
//    }
//
//    public void trigger(ServerPlayer player) {
//        this.trigger(player, TriggerInstance::test);
//    }
//
//    public record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance {
//        public static final Codec<TriggerInstance> CODEC = RecordCodecBuilder.create(
//                builder -> builder.group(
//                                EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player))
//                        .apply(builder, TriggerInstance::new)
//        );
//
//        public static Criterion<TriggerInstance> simple() {
//            return UbesDelightAdvancements.USE_LEAF_FEAST_CONSUME.get().createCriterion(
//                    new TriggerInstance(Optional.empty())
//            );
//        }
//
//        public boolean test() {
//            return true;
//        }
//    }
}
