package com.chefmooon.ubesdelight.common.item.forge;

import com.chefmooon.ubesdelight.common.item.RollingPinItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;

public class RollingPinItemImpl extends RollingPinItem {
    public RollingPinItemImpl(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
        super(attackDamageModifier, attackSpeedModifier, tier, properties);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, net.minecraft.world.item.enchantment.Enchantment enchantment) {
        if (ALLOWED_ENCHANTMENTS.contains(enchantment)) {
            return true;
        }
        if (DENIED_ENCHANTMENTS.contains(enchantment)) {
            return false;
        }
        return enchantment.category.canEnchant(stack.getItem());
    }
}
