package com.chefmooon.ubesdelight.common.block.entity.dispenser.forge;

import com.chefmooon.ubesdelight.common.block.entity.dispenser.BaseLeafFeastDispenseBehavior;
import com.chefmooon.ubesdelight.common.registry.forge.UbesDelightItemsImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.DispenserBlock;

public class BaseLeafFeastDispenseBehaviorImpl {
    public static void register() {
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.ENSAYMADA.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.ENSAYMADA_UBE.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.PANDESAL.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.PANDESAL_UBE.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.HOPIA_MUNGGO.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.HOPIA_UBE.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.LUMPIA.get(), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(BuiltInRegistries.ITEM.get(new ResourceLocation("farmersdelight", "cooked_rice")), new BaseLeafFeastDispenseBehavior()); // TODO - sometimes this is air? only in dev?
        DispenserBlock.registerBehavior(BuiltInRegistries.ITEM.get(new ResourceLocation("farmersdelight", "fried_rice")), new BaseLeafFeastDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.SINANGAG.get(), new BaseLeafFeastDispenseBehavior());
    }
}
