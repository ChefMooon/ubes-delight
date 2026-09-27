package chefmooon.ubesdelight.common.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.CookingFuel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.floats.ResolvableFloat;
import net.minecraft.world.level.storage.loot.providers.number.ints.ResolvableInt;

public class UbesDelightFuelBlockItem extends UbesDelightBlockItem {
    private final int burnTime;
    public UbesDelightFuelBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, int burnTime) {
        super(block, properties.component(DataComponents.COOKING_FUEL, new CookingFuel(new ResolvableInt.Constant(burnTime), ResolvableFloat.fromKey(ContextFloatProviders.COOKING_DEFAULT_SPEED_MULTIPLIER))), hasFoodEffectTooltip, hasCustomTooltip);
        this.burnTime = burnTime;
    }
}
