package chefmooon.ubesdelight.data.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

public class UDChestLoot implements LootTableSubProvider {
    protected final HolderLookup.Provider registries;

    public UDChestLoot(HolderLookup.Provider registries) {
        this.registries = registries;
    }
    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {

    }
}
