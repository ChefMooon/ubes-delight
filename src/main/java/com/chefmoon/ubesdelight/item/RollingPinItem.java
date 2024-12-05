package com.chefmoon.ubesdelight.item;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.MathHelper;

import java.util.Set;

public class RollingPinItem extends ToolItem {
    private static double knockbackStrength = 1.2;

    public static final Set<Enchantment> ALLOWED_ENCHANTMENTS = Set.of(Enchantments.UNBREAKING, Enchantments.MENDING,Enchantments.FORTUNE);

    public RollingPinItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.takeKnockback(knockbackStrength, MathHelper.sin(attacker.headYaw * 0.017453292F), -MathHelper.cos(attacker.headYaw * 0.017453292F));
        stack.damage(1, attacker, user -> user.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));

        return true;
    }

    @Override
    public int getEnchantability() {
        return super.getEnchantability();
    }
}
