package chefmooon.ubesdelight.common.item;

import chefmooon.ubesdelight.common.Configuration;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class UbesDelightBlockItem extends BlockItem {
    protected final boolean hasFoodEffectTooltip;
    protected final boolean hasCustomTooltip;
    public UbesDelightBlockItem(Block block, Properties properties) {
        this(block, properties, false, false);
    }

    public UbesDelightBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip) {
        this(block, properties, hasFoodEffectTooltip, false);
    }

    public UbesDelightBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(block, properties);
        this.hasCustomTooltip = hasCustomTooltip;
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.isFoodEffectTooltip()) { // todo - add new config BlockItem tooltips? V0.2.0
            if (hasCustomTooltip) {
                tooltip.add(TextUtils.getTranslatable("tooltip." + this).withStyle(ChatFormatting.DARK_GRAY));
            }

            if (hasFoodEffectTooltip) {
                vectorwing.farmersdelight.common.utility.TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
            }
        }
    }
}

