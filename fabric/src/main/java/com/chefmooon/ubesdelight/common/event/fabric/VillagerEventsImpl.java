package com.chefmooon.ubesdelight.common.event.fabric;

import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.VillagerTrades;
import net.minecraft.world.level.ItemLike;

public class VillagerEventsImpl {
    public static void init() {
        ServerLifecycleEvents.SERVER_STARTING.register(client -> addTrades());
    }

    // TODO: fix villager trades
    public static void addTrades() {
//        if (Configuration.farmersBuyUDCrops()) {
//            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, (trades) -> {
//                trades.add(emeraldForItemsTrade(UbesDelightItemsImpl.UBE.get(),26, 16, 2));
//                trades.add(emeraldForItemsTrade(UbesDelightItemsImpl.GARLIC.get(),26, 16, 2));
//                trades.add(emeraldForItemsTrade(UbesDelightItemsImpl.GINGER.get(),26, 16, 2));
//                trades.add(emeraldForItemsTrade(UbesDelightItemsImpl.LEMONGRASS.get(),20, 16, 5));// 2xp? same as wheat? others same as potato
//            });
//        }
//
//        if (Configuration.wanderingTraderSellsUDItems()) {
//            TradeOfferHelper.registerWanderingTraderOffers((trades) -> {
//                trades.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.BUY_ITEMS_POOL,
//                        itemForEmeraldTrade(UbesDelightItemsImpl.UBE.get(),1, 12));
//                trades.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.BUY_ITEMS_POOL,
//                        itemForEmeraldTrade(UbesDelightItemsImpl.GARLIC.get(),1, 12));
//                trades.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.BUY_ITEMS_POOL,
//                        itemForEmeraldTrade(UbesDelightItemsImpl.GINGER.get(),1, 12));
//                trades.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.BUY_ITEMS_POOL,
//                        itemForEmeraldTrade(UbesDelightItemsImpl.LEMONGRASS_SEEDS.get(),1, 12));
//            });
//        }
    }
//
//    public static VillagerTrades.ItemListing emeraldForItemsTrade(ItemLike item, int cost, int maxTrades, int xp) {
//        return new VillagerTrades.EmeraldForItems(item, cost, maxTrades, xp);
//    }
//
//    public static VillagerTrades.ItemListing itemForEmeraldTrade(ItemLike item, int maxTrades, int xp) {
//        return new VillagerTrades.ItemsForEmeralds(new ItemStack(item), 1, 1, maxTrades, xp, 0.05F);
//    }
}
