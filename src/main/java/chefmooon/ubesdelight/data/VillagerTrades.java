package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.utility.TextUtils;
import com.mojang.serialization.Lifecycle;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class VillagerTrades extends FabricDynamicRegistryProvider {
    public VillagerTrades(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final ResourceKey<VillagerTrade> FARMER_1_UBE_EMERALD = resourceKey("farmer/1/ube_emerald");
    public static final ResourceKey<VillagerTrade> FARMER_1_GARLIC_EMERALD = resourceKey("farmer/1/garlic_emerald");
    public static final ResourceKey<VillagerTrade> FARMER_1_GINGER_EMERALD = resourceKey("farmer/1/ginger_emerald");
    public static final ResourceKey<VillagerTrade> FARMER_1_LEMONGRASS_EMERALD = resourceKey("farmer/1/lemongrass_emerald");

    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_UBE_EMERALD = resourceKey("wandering_trader/ube_emerald");
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_GARLIC_EMERALD = resourceKey("wandering_trader/garlic_emerald");
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_GINGER_EMERALD = resourceKey("wandering_trader/ginger_emerald");
    public static final ResourceKey<VillagerTrade> WANDERING_TRADER_LEMONGRASS_EMERALD = resourceKey("wandering_trader/lemongrass_emerald");

    public static void init(final BootstrapContext<VillagerTrade> context) {
        onVillagerTrades(context);
        onWanderingTraderTrades(context);
    }

    public static void onVillagerTrades(final BootstrapContext<VillagerTrade> context) {
        context.register(FARMER_1_UBE_EMERALD, emeraldsForItemsTrade(UbesDelightItems.UBE.get(), 3, 16, 2));
        context.register(FARMER_1_GARLIC_EMERALD, emeraldsForItemsTrade(UbesDelightItems.GARLIC.get(), 3, 16, 2));
        context.register(FARMER_1_GINGER_EMERALD, emeraldsForItemsTrade(UbesDelightItems.GINGER.get(), 3, 16, 2));
        context.register(FARMER_1_LEMONGRASS_EMERALD, emeraldsForItemsTrade(UbesDelightItems.LEMONGRASS.get(), 3, 16, 2));
    }

    public static void onWanderingTraderTrades(final BootstrapContext<VillagerTrade> context) {
        context.register(WANDERING_TRADER_UBE_EMERALD, itemForEmeraldTrade(UbesDelightItems.UBE.get(), 8, 5));
        context.register(WANDERING_TRADER_GARLIC_EMERALD, itemForEmeraldTrade(UbesDelightItems.GARLIC.get(), 8, 5));
        context.register(WANDERING_TRADER_GINGER_EMERALD, itemForEmeraldTrade(UbesDelightItems.GINGER.get(), 8, 5));
        context.register(WANDERING_TRADER_LEMONGRASS_EMERALD, itemForEmeraldTrade(UbesDelightItems.LEMONGRASS.get(), 8, 5));
    }

    public static VillagerTrade emeraldsForItemsTrade(ItemLike item, int count, int maxTrades, int xp) {
        return new VillagerTrade(new TradeCost(item.asItem(), count), new ItemStackTemplate(Items.EMERALD), maxTrades, xp, 0.05f, Optional.empty(), List.of());
    }

    public static VillagerTrade itemForEmeraldTrade(ItemLike item, int maxTrades, int xp) {
        return new VillagerTrade(new TradeCost(item, 1), new ItemStackTemplate(Items.EMERALD, 1), maxTrades, xp, 0.05f, Optional.empty(), List.of());
    }

    public static ResourceKey<VillagerTrade> resourceKey(final String path) {
        return ResourceKey.create(Registries.VILLAGER_TRADE, TextUtils.res(path));
    }

    @Override
    protected void configure(HolderLookup.Provider provider, Entries entries) {
        init(new BootstrapContext<>() {
            @Override
            public Holder.Reference<VillagerTrade> register(ResourceKey<VillagerTrade> resourceKey, VillagerTrade object, Lifecycle lifecycle) {
                return (Holder.Reference<VillagerTrade>) entries.add(resourceKey, object);
            }

            @Override
            public <S> HolderGetter<S> lookup(ResourceKey<? extends Registry<? extends S>> resourceKey) {
                return provider.lookupOrThrow(resourceKey);
            }
        });
    }

    @Override
    public String getName() {
        return "UD Villager Trades";
    }
}
