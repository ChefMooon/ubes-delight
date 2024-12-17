package com.chefmooon.ubesdelight.common.block.entity.dispenser.fabric;

import com.chefmooon.ubesdelight.common.block.entity.dispenser.BaseLeafFeastDispenseBehavior;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.DispenserBlock;

public class BaseLeafFeastDispenseBehaviorImpl {
    public static void register() {
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.ENSAYMADA, new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.ENSAYMADA_UBE, new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.PANDESAL, new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.PANDESAL_UBE, new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.HOPIA_MUNGGO, new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.HOPIA_UBE, new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.LUMPIA, new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("farmersdelight", "cooked_rice")), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("farmersdelight", "fried_rice")), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.SINANGAG, new BaseLeafFeastDispenseBehavior());
    }
}
