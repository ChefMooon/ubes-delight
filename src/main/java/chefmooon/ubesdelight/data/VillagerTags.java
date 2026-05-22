package chefmooon.ubesdelight.data;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.VillagerTradeTags;
import net.minecraft.world.item.trading.VillagerTrade;

import java.util.concurrent.CompletableFuture;

public class VillagerTags extends FabricTagsProvider<VillagerTrade> {
    public VillagerTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.VILLAGER_TRADE, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.builder(VillagerTradeTags.FARMER_LEVEL_1)
                .addOptional(VillagerTrades.FARMER_1_UBE_EMERALD)
                .addOptional(VillagerTrades.FARMER_1_GARLIC_EMERALD)
                .addOptional(VillagerTrades.FARMER_1_GINGER_EMERALD)
                .addOptional(VillagerTrades.FARMER_1_LEMONGRASS_EMERALD);
        this.builder(VillagerTradeTags.WANDERING_TRADER_COMMON)
                .addOptional(VillagerTrades.WANDERING_TRADER_UBE_EMERALD)
                .addOptional(VillagerTrades.WANDERING_TRADER_GARLIC_EMERALD)
                .addOptional(VillagerTrades.WANDERING_TRADER_GINGER_EMERALD)
                .addOptional(VillagerTrades.WANDERING_TRADER_LEMONGRASS_EMERALD);
    }
}
