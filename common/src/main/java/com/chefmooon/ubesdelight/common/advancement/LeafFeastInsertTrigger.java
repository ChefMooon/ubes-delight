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

public class LeafFeastInsertTrigger extends SimpleCriterionTrigger<LeafFeastInsertTrigger.TriggerInstance> {
    private static final ResourceLocation ID = new ResourceLocation(UbesDelight.MOD_ID, "use_leaf_feast_insert");
    @Override
    protected LeafFeastInsertTrigger.TriggerInstance createInstance(JsonObject json, ContextAwarePredicate predicate, DeserializationContext deserializationContext) {
        return new LeafFeastInsertTrigger.TriggerInstance(predicate);
    }

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, LeafFeastInsertTrigger.TriggerInstance::test);
    }

    public static class TriggerInstance extends AbstractCriterionTriggerInstance
    {
        public TriggerInstance(ContextAwarePredicate player) {
            super(LeafFeastInsertTrigger.ID, player);
        }

        public static LeafFeastInsertTrigger.TriggerInstance simple() {
            return new LeafFeastInsertTrigger.TriggerInstance(ContextAwarePredicate.ANY);
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
//                        EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player))
//                        .apply(builder, TriggerInstance::new)
//        );
//
//        public static Criterion<TriggerInstance> simple() {
//            return UbesDelightAdvancements.USE_LEAF_FEAST_INSERT.get().createCriterion(
//                    new TriggerInstance(Optional.empty())
//            );
//        }
//
//        public boolean test() {
//            return true;
//        }
//    }
}