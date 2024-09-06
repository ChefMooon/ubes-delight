package com.chefmooon.ubesdelight.common.item;

import com.chefmooon.ubesdelight.common.Configuration;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.List;

public class UbesDelightConsumableItem extends ConsumableItem {
    public UbesDelightConsumableItem(Properties properties) {
        super(properties);
    }

    public UbesDelightConsumableItem(Properties properties, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
    }

    public UbesDelightConsumableItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(properties, hasFoodEffectTooltip, hasCustomTooltip);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.isFoodEffectTooltip()) {
            TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
        }
    }
}
