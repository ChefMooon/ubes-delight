package chefmooon.ubesdelight.data.loot;

import chefmooon.ubesdelight.common.registry.UDChestLootTables;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class UDChestLootTableGenerator extends SimpleFabricLootTableSubProvider {
    protected final HolderLookup.Provider registries;
    public UDChestLootTableGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture, LootContextParamSets.CHEST);
        this.registries = registryLookupFuture.join();
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(UDChestLootTables.UD_VILLAGE_PLAINS_HOUSE, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.between(1, 3))
                        .add(LootItem.lootTableItem(UbesDelightItems.UBE.get())
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
                        .add(LootItem.lootTableItem(UbesDelightItems.GARLIC.get())
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
                        .add(LootItem.lootTableItem(UbesDelightItems.GINGER.get())
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
                        .add(LootItem.lootTableItem(UbesDelightItems.LEMONGRASS_SEEDS.get())
                                .apply(SetItemCountFunction.setCount(ContextIntProviders.between(1, 3))))
                ));
    }

    @Override
    public String getName() {
        return "Ube's Delight Chest Loot";
    }

    @Override
    public void run() {
    }
}
