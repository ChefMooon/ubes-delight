package com.chefmooon.ubesdelight.common.event.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.registry.neoforge.UbesDelightItemsImpl;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@EventBusSubscriber(modid = UbesDelight.MOD_ID)
@ParametersAreNonnullByDefault
public class VillagerEventsImpl {

    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (!Configuration.farmersBuyUDCrops()) return;

        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        VillagerProfession profession = event.getType();
        ResourceLocation professionKey = BuiltInRegistries.VILLAGER_PROFESSION.getKey(profession);
        if (professionKey == null) return;
        if (professionKey.getPath().equals("farmer")) {
            trades.get(1).add(emeraldForItemsTrade(UbesDelightItemsImpl.UBE.get(),26, 16, 2));
            trades.get(1).add(emeraldForItemsTrade(UbesDelightItemsImpl.GARLIC.get(),26, 16, 2));
            trades.get(1).add(emeraldForItemsTrade(UbesDelightItemsImpl.GINGER.get(),26, 16, 2));
            trades.get(1).add(emeraldForItemsTrade(UbesDelightItemsImpl.LEMONGRASS.get(),20, 16, 5));// 2xp? same as wheat? others same as potato
        }
    }

    @SubscribeEvent
    public static void onWandererTrades(WandererTradesEvent event) {
        if (!Configuration.wanderingTraderSellsUDItems()) return;

        List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
        trades.add(itemForEmeraldTrade(UbesDelightItemsImpl.UBE.get(),1, 12));
        trades.add(itemForEmeraldTrade(UbesDelightItemsImpl.GARLIC.get(),1, 12));
        trades.add(itemForEmeraldTrade(UbesDelightItemsImpl.GINGER.get(),1, 12));
        trades.add(itemForEmeraldTrade(UbesDelightItemsImpl.LEMONGRASS_SEEDS.get(),1, 12));
    }

    public static BasicItemListing emeraldForItemsTrade(ItemLike item, int itemCount, int maxTrades, int xp) {
        return new BasicItemListing(new ItemStack(item, itemCount), new ItemStack(Items.EMERALD), maxTrades, xp, 0.05F);
    }

    public static BasicItemListing itemForEmeraldTrade(ItemLike item, int maxTrades, int xp) {
        return new BasicItemListing(1, new ItemStack(item), maxTrades, xp, 0.05F);
    }
}
