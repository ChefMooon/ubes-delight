package com.chefmooon.ubesdelight.common.item;

import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.chefmooon.ubesdelight.common.utility.TextUtils.addFoodEffectTooltip;

public class UbesDelightBlockItem extends BlockItem {
    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;
    private final int burnTime;
    public UbesDelightBlockItem(Block block, Properties properties) {
        this(block, properties, false, false, 0);
    }

    public UbesDelightBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip) {
        this(block, properties, hasFoodEffectTooltip, false, 0);
    }

    public UbesDelightBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        this(block, properties, hasFoodEffectTooltip, hasCustomTooltip, 0);
    }

    public UbesDelightBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, int burnTime) {
        super(block, properties);
        this.hasCustomTooltip = hasCustomTooltip;
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.burnTime = burnTime;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.isFoodEffectTooltip()) { // todo - add new config BlockItem tooltips? V0.2.0
            if (hasCustomTooltip) {
                tooltip.add(TextUtils.getTranslatable("tooltip." + this).withStyle(ChatFormatting.DARK_GRAY));
            }

            if (hasFoodEffectTooltip) {
                addFoodEffectTooltip(stack, tooltip, 1.0F);
            }
        }
    }


}

