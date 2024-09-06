package com.chefmooon.ubesdelight.common.item.neoforge;

import com.chefmooon.ubesdelight.common.item.RollingPinItem;
import net.minecraft.world.item.Tier;

public class RollingPinItemImpl extends RollingPinItem {
    public RollingPinItemImpl(Tier tier, Properties properties) {
        super(tier, properties);
    }

//    @Override
//    public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.world.item.enchantment.Enchantment enchantment) {
//        if (ALLOWED_ENCHANTMENTS.contains(enchantment)) {
//            return true;
//        }
//        if (DENIED_ENCHANTMENTS.contains(enchantment)) {
//            return false;
//        }
//        return enchantment.category.canEnchant(stack.getItem());
//    }
}
