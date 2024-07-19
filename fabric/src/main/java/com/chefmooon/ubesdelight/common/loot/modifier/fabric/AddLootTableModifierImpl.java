package com.chefmooon.ubesdelight.common.loot.modifier.fabric;

import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class AddLootTableModifierImpl {
    private static final ResourceLocation VILLAGE_PLAINS_HOUSE = BuiltInLootTables.VILLAGE_PLAINS_HOUSE;

    public static void registerLootTable() {
        if (Configuration.generateUDChestLoot()) {
            LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
                if (VILLAGE_PLAINS_HOUSE.equals(id)) {
                    LootPool.Builder ubePoolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .conditionally(LootItemRandomChanceCondition.randomChance(0.5F).build())
                            .add(LootItem.lootTableItem(UbesDelightItemsImpl.UBE))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)).build());
                    tableBuilder.pool(ubePoolBuilder.build());

                    LootPool.Builder garlicPoolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .conditionally(LootItemRandomChanceCondition.randomChance(0.5F).build())
                            .add(LootItem.lootTableItem(UbesDelightItemsImpl.GARLIC))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)).build());
                    tableBuilder.pool(garlicPoolBuilder.build());

                    LootPool.Builder gingerPoolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .conditionally(LootItemRandomChanceCondition.randomChance(0.5F).build())
                            .add(LootItem.lootTableItem(UbesDelightItemsImpl.GINGER))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)).build());
                    tableBuilder.pool(gingerPoolBuilder.build());

                    LootPool.Builder lemongrassPoolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0F))
                            .conditionally(LootItemRandomChanceCondition.randomChance(0.5F).build())
                            .add(LootItem.lootTableItem(UbesDelightItemsImpl.LEMONGRASS_SEEDS))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 3.0f)).build());
                    tableBuilder.pool(lemongrassPoolBuilder.build());
                }
            });
        }
    }
}
