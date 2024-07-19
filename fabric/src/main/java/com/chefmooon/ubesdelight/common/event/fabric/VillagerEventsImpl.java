package com.chefmooon.ubesdelight.common.event.fabric;

import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class VillagerEventsImpl {
    public static void init() {
        ServerLifecycleEvents.SERVER_STARTING.register(client -> addTrades());
    }

    public static void addTrades() {
        if (Configuration.farmersBuyUDCrops()) {
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, (trades) -> {
                trades.add(emeraldForItemsTrade(UbesDelightItemsImpl.UBE,26, 16, 2));
                trades.add(emeraldForItemsTrade(UbesDelightItemsImpl.GARLIC,26, 16, 2));
                trades.add(emeraldForItemsTrade(UbesDelightItemsImpl.GINGER,26, 16, 2));
                trades.add(emeraldForItemsTrade(UbesDelightItemsImpl.LEMONGRASS_SEEDS,20, 16, 5));// 2xp? same as wheat? others same as potato
            });
        }

        if (Configuration.wanderingTraderSellsUDItems()) {
            TradeOfferHelper.registerWanderingTraderOffers(1, (trades) -> {
                trades.add(itemForEmeraldTrade(UbesDelightItemsImpl.UBE,12, 1));
                trades.add(itemForEmeraldTrade(UbesDelightItemsImpl.GARLIC,12, 1));
                trades.add(itemForEmeraldTrade(UbesDelightItemsImpl.GINGER,12, 1));
                trades.add(itemForEmeraldTrade(UbesDelightItemsImpl.LEMONGRASS,12, 1));
            });
        }
    }

    public static VillagerTrades.ItemListing emeraldForItemsTrade(ItemLike item, int cost, int maxTrades, int xp) {
        return new VillagerTrades.EmeraldForItems(item, cost, maxTrades, xp);
    }

    public static VillagerTrades.ItemListing itemForEmeraldTrade(ItemLike item, int maxTrades, int xp) {
        return new VillagerTrades.ItemsForEmeralds(new ItemStack(item), 1, 1, maxTrades, xp, 0.05F);
    }
}
