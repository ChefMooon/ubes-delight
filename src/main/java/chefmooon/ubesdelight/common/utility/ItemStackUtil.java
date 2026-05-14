package chefmooon.ubesdelight.common.utility;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ItemStackUtil {
    public static ItemStack getContainer(ItemStack itemStack) {
        ItemStack container = itemStack.getRecipeRemainder();
        if (!container.isEmpty()) {
            return container;
        }
        return new ItemStack(Items.AIR);
    }
}
