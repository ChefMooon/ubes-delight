package com.chefmooon.ubesdelight.common.item.fabric;

import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@Deprecated(forRemoval = true)
public class UbesDelightConsumableItemNameBlockItemImpl extends ItemNameBlockItem {
    private final boolean hasFoodEffectTooltip;
    public UbesDelightConsumableItemNameBlockItemImpl(Block block, Properties properties) {
        super(block, properties);
        this.hasFoodEffectTooltip = false;
    }

    public UbesDelightConsumableItemNameBlockItemImpl(Block block, Properties properties, boolean hasFoodEffectTooltip) {
        super(block, properties);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltip, isAdvanced);
        if (Configuration.isFoodEffectTooltip()) {
            if (this.hasFoodEffectTooltip) {
                TextUtils.addFoodEffectTooltip(stack, tooltip, 1.0F);
            }
        }
    }
}
