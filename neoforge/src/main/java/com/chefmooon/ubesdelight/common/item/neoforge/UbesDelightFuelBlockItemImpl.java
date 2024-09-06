package com.chefmooon.ubesdelight.common.item.neoforge;

import com.chefmooon.ubesdelight.common.item.UbesDelightBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

public class UbesDelightFuelBlockItemImpl extends UbesDelightBlockItem {
    private final int burnTime;
    public UbesDelightFuelBlockItemImpl(Block block, Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, int burnTime) {
        super(block, properties, hasFoodEffectTooltip, hasCustomTooltip);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }
}
