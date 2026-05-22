package chefmooon.ubesdelight.common.item;

import chefmooon.ubesdelight.common.item.UbesDelightBlockItem;
import net.fabricmc.fabric.api.registry.FuelValueEvents;
import net.minecraft.world.level.block.Block;

import java.util.Properties;

public class UbesDelightFuelBlockItem extends UbesDelightBlockItem {
    private final int burnTime;
    public UbesDelightFuelBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, int burnTime) {
        super(block, properties, hasFoodEffectTooltip, hasCustomTooltip);
        this.burnTime = burnTime;
        if (burnTime > 0) FuelValueEvents.BUILD.register(((builder, context) -> builder.add(this, this.burnTime)));
    }
}
