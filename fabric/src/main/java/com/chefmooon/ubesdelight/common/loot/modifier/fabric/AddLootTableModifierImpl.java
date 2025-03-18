package com.chefmooon.ubesdelight.common.loot.modifier.fabric;

import com.chefmooon.ubesdelight.common.Configuration;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.mixin.accessor.LootContextAccessor;

import java.util.Optional;

import static net.minecraft.world.level.storage.loot.LootTable.createStackSplitter;

public class AddLootTableModifierImpl {
    private final ResourceKey<LootTable> lootTable;

    protected AddLootTableModifierImpl(LootItemCondition[] conditionsIn, ResourceKey<LootTable> lootTable) {
        this.lootTable = lootTable;
    }

    @NotNull
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (Configuration.generateUDChestLoot()) {
            LootContext extraContext = new LootContext.Builder(((LootContextAccessor)context).getParams()).create(Optional.empty());
            context.getResolver().get(Registries.LOOT_TABLE, this.lootTable).ifPresent((extraTable) -> {
                extraTable.value().getRandomItemsRaw(extraContext, createStackSplitter(context.getLevel(), generatedLoot::add));
            });
        }
        return generatedLoot;
    }
}
