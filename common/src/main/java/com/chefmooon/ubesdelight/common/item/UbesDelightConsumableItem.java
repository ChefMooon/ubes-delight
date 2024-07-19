package com.chefmooon.ubesdelight.common.item;

import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.item.ConsumableItem;

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
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.isFoodEffectTooltip()) {
            TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
        }
    }
}
