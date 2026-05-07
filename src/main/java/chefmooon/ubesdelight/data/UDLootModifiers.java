package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.registry.UbesDelightChestLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class UDLootModifiers extends GlobalLootModifierProvider {
    public UDLootModifiers(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modid) {
        super(output, registries, modid);
    }

    @Override
    protected void start() {
        this.add("add_loot_village_plains_house", this.addNewLootPool(BuiltInLootTables.VILLAGE_PLAINS_HOUSE, UbesDelightChestLootTables.VILLAGE_PLAINS_HOUSE));
    }

    private AddTableLootModifier addNewLootPool(ResourceKey<LootTable> lootToAddTo, ResourceKey<LootTable> newPool) {
        return new AddTableLootModifier(new LootItemCondition[]{LootTableIdCondition.builder(lootToAddTo.location()).build()}, newPool);
    }
}
