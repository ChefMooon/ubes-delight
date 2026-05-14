package chefmooon.ubesdelight.common;

import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import chefmooon.ubesdelight.common.block.entity.dispenser.BakingMatDispenseBehavior;
import chefmooon.ubesdelight.common.block.entity.dispenser.BaseLeafFeastDispenseBehavior;
import chefmooon.ubesdelight.common.block.entity.dispenser.DrinkableFeastDispenseBehavior;
import chefmooon.ubesdelight.common.crafting.condition.UDCrateEnabledCondition;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;

import java.util.HashMap;
import java.util.Set;

public class CommonSetup {
    public static void init() {
        registerDispenserBehaviors();
        registerItemSetAdditions();

        CommonSetup.registerCompostables();

        BakingMatBlockEntity.init();

        ResourceConditions.register(UDCrateEnabledCondition.TYPE);
    }

    public static void registerDispenserBehaviors() {
        DrinkableFeastDispenseBehavior.register();
        BakingMatDispenseBehavior.register();
        BaseLeafFeastDispenseBehavior.register();
    }

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.LEMONGRASS_SEEDS.get(), 0.3f);

        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.GARLIC_CHOP.get(), 0.4f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.GINGER_CHOP.get(), 0.4f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.LUMPIA_WRAPPER.get(), 0.4f);

        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.WILD_UBE.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.WILD_GARLIC.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.WILD_GINGER.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.WILD_LEMONGRASS.get(), 0.65f);

        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.UBE.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.GARLIC.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.GINGER.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.LEMONGRASS.get(), 0.65f);

        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.PANDESAL.get(), 0.7f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.PANDESAL_UBE.get(), 0.7f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.ENSAYMADA.get(), 0.7f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.ENSAYMADA_UBE.get(), 0.7f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.HOPIA_MUNGGO.get(), 0.7f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.HOPIA_UBE.get(), 0.7f);

        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.COOKIE_UBE.get(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.COOKIE_GINGER.get(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.POLVORONE.get(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.POLVORONE_PINIPIG.get(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.POLVORONE_UBE.get(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.POLVORONE_CC.get(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.LECHE_FLAN.get(), 0.85f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.UBE_CAKE_SLICE.get(), 0.85f);

        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.UBE_CAKE.get(), 1.0f);
        ComposterBlock.COMPOSTABLES.put(UbesDelightItems.LECHE_FLAN_FEAST.get(), 1.0f);
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
