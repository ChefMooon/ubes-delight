package com.chefmoon.ubesdelight.advancement;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.google.gson.JsonObject;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class BakingMatTrigger extends AbstractCriterion<BakingMatTrigger.Instance> {
    private static final Identifier ID = new Identifier(UbesDelightMod.MOD_ID, "use_baking_mat");
    @Override
    protected Instance conditionsFromJson(JsonObject obj, EntityPredicate.Extended playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
        return new Instance(playerPredicate);
    }

    @Override
    public Identifier getId() {
        return ID;
    }

    public void trigger(ServerPlayerEntity player) {
        trigger(player, Instance::test);
    }

    public static class Instance extends AbstractCriterionConditions {

        public Instance(EntityPredicate.Extended playerPredicate) {
            super(ID, playerPredicate);
        }

        public boolean test() {
            return true;
        }

    }
}
