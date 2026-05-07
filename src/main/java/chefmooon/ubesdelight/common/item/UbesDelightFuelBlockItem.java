package chefmooon.ubesdelight.common.item;

import chefmooon.ubesdelight.common.item.UbesDelightBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.Properties;

public class UbesDelightFuelBlockItem extends UbesDelightBlockItem {
    private final int burnTime;
    public UbesDelightFuelBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip, int burnTime) {
        super(block, properties, hasFoodEffectTooltip, hasCustomTooltip);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack stack, @Nullable RecipeType<?> recipeType) {
        return this.burnTime;
    }
}
