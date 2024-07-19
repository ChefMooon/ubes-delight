package com.chefmooon.ubesdelight.common.item.fabric;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

@Deprecated(forRemoval = true)
public class UbesDelightDrinkableItemImpl extends UbesDelightConsumableItemImpl {
    public UbesDelightDrinkableItemImpl(Properties properties) {
        super(properties);
    }

    public UbesDelightDrinkableItemImpl(Properties properties, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
    }

    public UbesDelightDrinkableItemImpl(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasFoodEffectTooltip, hasCustomTooltip);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
}
