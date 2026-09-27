package chefmooon.ubesdelight.common;

import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import chefmooon.ubesdelight.common.block.entity.dispenser.BakingMatDispenseBehavior;
import chefmooon.ubesdelight.common.block.entity.dispenser.BaseLeafFeastDispenseBehavior;
import chefmooon.ubesdelight.common.block.entity.dispenser.DrinkableFeastDispenseBehavior;
import chefmooon.ubesdelight.common.crafting.condition.UDCrateEnabledCondition;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Compostable;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;

public class CommonSetup {
    public static void init() {
        registerDispenserBehaviors();
        registerItemSetAdditions();
        registerCompostables();

        BakingMatBlockEntity.init();

        ResourceConditions.register(UDCrateEnabledCondition.TYPE);
    }

    public static void registerDispenserBehaviors() {
        DrinkableFeastDispenseBehavior.register();
        BakingMatDispenseBehavior.register();
        BaseLeafFeastDispenseBehavior.register();
    }

    public static void registerCompostables() {
        compostable(UbesDelightItems.LEMONGRASS_SEEDS.get(), 30);

        compostable(UbesDelightItems.GARLIC_CHOP.get(), 30);
        compostable(UbesDelightItems.GINGER_CHOP.get(), 30);
        compostable(UbesDelightItems.LUMPIA_WRAPPER.get(), 30);

        compostable(UbesDelightItems.WILD_UBE.get(), 65);
        compostable(UbesDelightItems.WILD_GARLIC.get(), 65);
        compostable(UbesDelightItems.WILD_GINGER.get(), 65);
        compostable(UbesDelightItems.WILD_LEMONGRASS.get(), 65);

        compostable(UbesDelightItems.UBE.get(), 65);
        compostable(UbesDelightItems.GARLIC.get(), 65);
        compostable(UbesDelightItems.GINGER.get(), 65);
        compostable(UbesDelightItems.LEMONGRASS.get(), 65);

        compostable(UbesDelightItems.PANDESAL.get(), 65);
        compostable(UbesDelightItems.PANDESAL_UBE.get(), 65);
        compostable(UbesDelightItems.ENSAYMADA.get(), 65);
        compostable(UbesDelightItems.ENSAYMADA_UBE.get(), 65);
        compostable(UbesDelightItems.HOPIA_MUNGGO.get(), 65);
        compostable(UbesDelightItems.HOPIA_UBE.get(), 65);

        compostable(UbesDelightItems.COOKIE_UBE.get(), 85);
        compostable(UbesDelightItems.COOKIE_GINGER.get(), 85);
        compostable(UbesDelightItems.POLVORONE.get(), 85);
        compostable(UbesDelightItems.POLVORONE_PINIPIG.get(), 85);
        compostable(UbesDelightItems.POLVORONE_UBE.get(), 85);
        compostable(UbesDelightItems.POLVORONE_CC.get(), 85);
        compostable(UbesDelightItems.LECHE_FLAN.get(), 85);
        compostable(UbesDelightItems.UBE_CAKE_SLICE.get(), 85);

        compostable(UbesDelightItems.UBE_CAKE.get(), 100);
        compostable(UbesDelightItems.LECHE_FLAN_FEAST.get(), 100);
    }

    private static void compostable(Item item, int compostingChance) {
        ResourceKey<ContextIntProvider> compostingResourceKey = switch (compostingChance) {
            case 100 -> ContextIntProviders.COMPOSTABLE_ALWAYS_ADD_ONE;
            case 85 -> ContextIntProviders.COMPOSTABLE_MEDIUM_HIGH;
            case 65 -> ContextIntProviders.COMPOSTABLE_MEDIUM;
            case 50 -> ContextIntProviders.COMPOSTABLE_LOW_MEDIUM;
            case 30 -> ContextIntProviders.COMPOSTABLE_LOW;
            default -> throw new IllegalStateException("Unexpected composting chance: " + compostingChance);
        };
        DefaultItemComponentEvents.MODIFY.register(modifyContext -> {
            modifyContext.modify(item, builder -> {
                builder.set(DataComponents.COMPOSTABLE,
                        new Compostable(compostingResourceKey));
            });
        });
    }

    public static void registerItemSetAdditions() {
//        HashMap<Item, Integer> foodPoints = new HashMap<>(Villager.FOOD_POINTS);
//        foodPoints.put(UbesDelightItems.UBE.get(), 1);
//        foodPoints.put(UbesDelightItems.GARLIC.get(), 1);
//        foodPoints.put(UbesDelightItems.GINGER.get(), 1);
//        foodPoints.put(UbesDelightItems.LEMONGRASS.get(), 1);
//        Villager.FOOD_POINTS = foodPoints;
    }
}
