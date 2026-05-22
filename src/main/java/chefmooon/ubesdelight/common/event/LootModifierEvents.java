package chefmooon.ubesdelight.common.event;

import chefmooon.ubesdelight.common.Configuration;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;

public class LootModifierEvents {

    public static final ResourceKey<LootTable> UD_VILLAGE_PLAINS_HOUSE = key("chests/ud_village_plains_house");

    public static void init() {
        LootTableEvents.MODIFY.register(LootModifierEvents::modifyLootTable);
    }

    private static void modifyLootTable(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        if (Configuration.generateUDChestLoot()) {
            if (key == BuiltInLootTables.VILLAGE_PLAINS_HOUSE) {
                tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(UD_VILLAGE_PLAINS_HOUSE)));
            }
        }
    }

    private static ResourceKey<LootTable> key(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, TextUtils.res(path));
    }
}
