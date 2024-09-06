package com.chefmooon.ubesdelight.common.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class UbesDelightDrinkableItem extends UbesDelightConsumableItem {

    public UbesDelightDrinkableItem(Properties properties) {
        super(properties);
    }

    public UbesDelightDrinkableItem(Properties properties, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

}
