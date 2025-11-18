package com.chefmooon.ubesdelight.common.block.entity.dispenser.fabric;

import com.chefmooon.ubesdelight.common.block.entity.dispenser.DrinkableFeastDispenseBehavior;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import net.minecraft.world.level.block.DispenserBlock;

public class DrinkableFeastDispenseBehaviorImpl {
    public static void register() {
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.HALO_HALO.get(), new DrinkableFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.MILK_TEA_UBE.get(), new DrinkableFeastDispenseBehavior());
    }
}
