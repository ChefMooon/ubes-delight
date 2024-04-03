package com.chefmoon.ubesdelight.advancement;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.LootContextPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class BakingMatTrigger extends AbstractCriterion<BakingMatTrigger.Instance> {
    private static final Identifier ID = new Identifier(UbesDelightMod.MOD_ID, "use_baking_mat");
    @Override
    protected BakingMatTrigger.Instance conditionsFromJson(JsonObject obj, LootContextPredicate playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
        return new BakingMatTrigger.Instance(playerPredicate);
    }

    @Override
    public Identifier getId() {
        return ID;
    }

    public void trigger(ServerPlayerEntity player) {
        trigger(player, Instance::test);
    }

    public static class Instance extends AbstractCriterionConditions {

        public Instance(LootContextPredicate playerPredicate) {
            super(ID, playerPredicate);
        }

        public boolean test() {
            return true;
        }

    }
}
