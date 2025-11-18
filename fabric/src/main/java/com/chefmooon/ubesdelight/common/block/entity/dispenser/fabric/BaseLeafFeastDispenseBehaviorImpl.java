package com.chefmooon.ubesdelight.common.block.entity.dispenser.fabric;

import com.chefmooon.ubesdelight.common.block.entity.dispenser.BaseLeafFeastDispenseBehavior;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import net.minecraft.world.level.block.DispenserBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

public class BaseLeafFeastDispenseBehaviorImpl {
    public static void register() {
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.ENSAYMADA.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.ENSAYMADA_UBE.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.PANDESAL.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.PANDESAL_UBE.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.HOPIA_MUNGGO.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.HOPIA_UBE.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.LUMPIA.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(ModItems.COOKED_RICE.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(ModItems.FRIED_RICE.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.SINANGAG.get(), new BaseLeafFeastDispenseBehavior());
    }
}
