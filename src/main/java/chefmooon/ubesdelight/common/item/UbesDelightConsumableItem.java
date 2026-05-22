package chefmooon.ubesdelight.common.item;

import chefmooon.ubesdelight.common.Configuration;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.function.Consumer;

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
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
        if (Configuration.isFoodEffectTooltip()) {
            TextUtils.addFoodEffectTooltip(stack, tooltipAdder, 1.0F, context.tickRate());
        }
    }
}
