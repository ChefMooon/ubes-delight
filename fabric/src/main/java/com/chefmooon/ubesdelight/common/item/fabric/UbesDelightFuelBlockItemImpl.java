package com.chefmooon.ubesdelight.common.item.fabric;

import com.chefmooon.ubesdelight.common.item.UbesDelightBlockItem;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.world.level.block.Block;

public class UbesDelightFuelBlockItemImpl extends UbesDelightBlockItem {
    private final int burnTime;
    public UbesDelightFuelBlockItemImpl(Block block, Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, int burnTime) {
        super(block, properties, hasFoodEffectTooltip, hasCustomTooltip);
        this.burnTime = burnTime;
        if (burnTime > 0) FuelRegistry.INSTANCE.add(this, this.burnTime);
    }
}
