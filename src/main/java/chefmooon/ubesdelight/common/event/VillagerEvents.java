package chefmooon.ubesdelight.common.event;

import chefmooon.ubesdelight.common.Configuration;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class VillagerEvents {
    public static void init() {
        ServerLifecycleEvents.SERVER_STARTING.register(client -> addTrades());
    }

    public static void addTrades() {
        if (Configuration.farmersBuyUDCrops()) {
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, (trades) -> {
                trades.add(emeraldForItemsTrade(UbesDelightItems.UBE.get(),26, 16, 2));
                trades.add(emeraldForItemsTrade(UbesDelightItems.GARLIC.get(),26, 16, 2));
                trades.add(emeraldForItemsTrade(UbesDelightItems.GINGER.get(),26, 16, 2));
                trades.add(emeraldForItemsTrade(UbesDelightItems.LEMONGRASS.get(),20, 16, 5));// 2xp? same as wheat? others same as potato
            });
        }

        if (Configuration.wanderingTraderSellsUDItems()) {
            TradeOfferHelper.registerWanderingTraderOffers(1, (trades) -> {
                trades.add(itemForEmeraldTrade(UbesDelightItems.UBE.get(),1, 12));
                trades.add(itemForEmeraldTrade(UbesDelightItems.GARLIC.get(),1, 12));
                trades.add(itemForEmeraldTrade(UbesDelightItems.GINGER.get(),1, 12));
                trades.add(itemForEmeraldTrade(UbesDelightItems.LEMONGRASS_SEEDS.get(),1, 12));
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
