package chefmooon.ubesdelight.common.utility;

import net.minecraft.world.item.ItemStack;

public class ItemStackUtil {

    public static ItemStack getContainer(ItemStack itemStack) {
        return itemStack.getCraftingRemainingItem();
    }
}
