package chefmooon.ubesdelight.common.advancement;

import chefmooon.ubesdelight.common.registry.UbesDelightAdvancements;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.ContextAwarePredicate;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;

import java.util.Optional;

public class LeafFeastConsumeTrigger extends SimpleCriterionTrigger<LeafFeastConsumeTrigger.TriggerInstance> {

    @Override
    public Codec<TriggerInstance> codec() {
        return TriggerInstance.CODEC;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, TriggerInstance::test);
    }

    public record TriggerInstance(Optional<ContextAwarePredicate> player) implements SimpleCriterionTrigger.SimpleInstance {
        public static final Codec<TriggerInstance> CODEC = RecordCodecBuilder.create(
                builder -> builder.group(
                                EntityPredicate.ADVANCEMENT_CODEC.optionalFieldOf("player").forGetter(TriggerInstance::player))
                        .apply(builder, TriggerInstance::new)
        );

        public static Criterion<TriggerInstance> simple() {
            return UbesDelightAdvancements.USE_LEAF_FEAST_CONSUME.get().createCriterion(
                    new TriggerInstance(Optional.empty())
            );
        }

        public boolean test() {
            return true;
        }
    }
}
