package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class UbesDelightChestLootTables {

    public static final ResourceKey<LootTable> VILLAGE_PLAINS_HOUSE = register("chests/ud_village_plains_house");

    private static ResourceKey<LootTable> register(String id) {
        return ResourceKey.create(Registries.LOOT_TABLE, TextUtils.res(id));
    }
}
