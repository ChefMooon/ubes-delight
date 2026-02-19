package com.chefmooon.ubesdelight.common;

import com.chefmooon.ubesdelight.common.block.entity.dispenser.BakingMatDispenseBehavior;
import com.chefmooon.ubesdelight.common.block.entity.dispenser.DrinkableFeastDispenseBehavior;
import com.chefmooon.ubesdelight.common.block.entity.dispenser.BaseLeafFeastDispenseBehavior;
import com.chefmooon.ubesdelight.common.registry.UbesDelightItems;
import com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.ComposterBlock;

import java.util.HashMap;
import java.util.Set;

public class CommonSetup {
    public static void init() {
        registerDispenserBehaviors();
        registerItemSetAdditions();
    }

    public static void registerDispenserBehaviors() {
        DrinkableFeastDispenseBehavior.register();
        BakingMatDispenseBehavior.register();
        BaseLeafFeastDispenseBehavior.register();
    }

    public static void registerCompostables() {
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.LEMONGRASS_SEEDS), 0.3f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.GARLIC_CHOP), 0.4f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.GINGER_CHOP), 0.4f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.LUMPIA_WRAPPER), 0.4f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.WILD_UBE), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.WILD_GARLIC), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.WILD_GINGER), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.WILD_LEMONGRASS), 0.65f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.UBE), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.GARLIC), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.GINGER), 0.65f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.LEMONGRASS), 0.65f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.PANDESAL), 0.7f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.PANDESAL_UBE), 0.7f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.ENSAYMADA), 0.7f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.ENSAYMADA_UBE), 0.7f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.HOPIA_MUNGGO), 0.7f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.HOPIA_UBE), 0.7f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.COOKIE_UBE), 0.85f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.COOKIE_GINGER), 0.85f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.POLVORONE), 0.85f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.POLVORONE_PINIPIG), 0.85f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.POLVORONE_UBE), 0.85f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.POLVORONE_CC), 0.85f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.LECHE_FLAN), 0.85f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.UBE_CAKE_SLICE), 0.85f);

        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.UBE_CAKE), 1.0f);
        ComposterBlock.COMPOSTABLES.put(BuiltInRegistryUtil.getItem(UbesDelightItems.LECHE_FLAN_FEAST), 1.0f);
    }

    public static void registerItemSetAdditions() {
        HashMap<Item, Integer> newFoodPoints = new HashMap<>();
        newFoodPoints.put(BuiltInRegistryUtil.getItem(UbesDelightItems.UBE), 1);
        newFoodPoints.put(BuiltInRegistryUtil.getItem(UbesDelightItems.GARLIC), 1);
        newFoodPoints.put(BuiltInRegistryUtil.getItem(UbesDelightItems.GINGER), 1);
        newFoodPoints.put(BuiltInRegistryUtil.getItem(UbesDelightItems.LEMONGRASS), 1);
        newFoodPoints.putAll(Villager.FOOD_POINTS);
        Villager.FOOD_POINTS = ImmutableMap.copyOf(newFoodPoints);
    }
}
