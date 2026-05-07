package chefmooon.ubesdelight.common;

import chefmooon.ubesdelight.common.block.entity.dispenser.BakingMatDispenseBehavior;
import chefmooon.ubesdelight.common.block.entity.dispenser.DrinkableFeastDispenseBehavior;
import chefmooon.ubesdelight.common.block.entity.dispenser.BaseLeafFeastDispenseBehavior;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.HashMap;
import java.util.Set;

public class CommonSetup {
    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerDispenserBehaviors();
            registerItemSetAdditions();
        });
    }

    public static void registerDispenserBehaviors() {
        DrinkableFeastDispenseBehavior.register();
        BakingMatDispenseBehavior.register();
        BaseLeafFeastDispenseBehavior.register();
    }

    public static void registerItemSetAdditions() {
        Set<Item> newWantedItems = Sets.newHashSet(
                UbesDelightItems.UBE.get(),
                UbesDelightItems.GARLIC.get(),
                UbesDelightItems.GINGER.get(),
                UbesDelightItems.LEMONGRASS.get(),
                UbesDelightItems.LEMONGRASS_SEEDS.get()
        );
        newWantedItems.addAll(Villager.WANTED_ITEMS);
        Villager.WANTED_ITEMS = ImmutableSet.copyOf(newWantedItems);

        HashMap<Item, Integer> newFoodPoints = new HashMap<>();
        newFoodPoints.put(UbesDelightItems.UBE.get(), 1);
        newFoodPoints.put(UbesDelightItems.GARLIC.get(), 1);
        newFoodPoints.put(UbesDelightItems.GINGER.get(), 1);
        newFoodPoints.put(UbesDelightItems.LEMONGRASS.get(), 1);
        newFoodPoints.putAll(Villager.FOOD_POINTS);
        Villager.FOOD_POINTS = ImmutableMap.copyOf(newFoodPoints);
    }
}
