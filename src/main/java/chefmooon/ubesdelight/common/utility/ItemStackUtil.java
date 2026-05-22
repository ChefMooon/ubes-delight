package chefmooon.ubesdelight.common.utility;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;

public class ItemStackUtil {
    public static ItemStack getContainer(ItemStack itemStack) {
        ItemStackTemplate itemStackTemplate = itemStack.getCraftingRemainder();
        if (itemStackTemplate != null) {
            ItemStack container = itemStackTemplate.create();
            if (!container.isEmpty()) {
                return container;
            }
        }
        return new ItemStack(Items.AIR);
    }
}
