package com.chefmooon.ubesdelight.common.mixin.fabric;

import com.chefmooon.ubesdelight.common.item.RollingPinItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(EnchantmentHelper.class)
public abstract class EnchantmentHelperEnhancementMixin {

    @Inject(method = "getAvailableEnchantmentResults(ILnet/minecraft/world/item/ItemStack;Z)Ljava/util/List;", at = @At("RETURN"))
    private static void getAvailableEnchantmentResultsEnhanced(int level, ItemStack stack, boolean allowTreasure, CallbackInfoReturnable<List<EnchantmentInstance>> returnable) {
        List<EnchantmentInstance> possibleEnchantmentList = returnable.getReturnValue();

        if (stack.getItem() instanceof RollingPinItem) {
            RollingPinItem.ALLOWED_ENCHANTMENTS.stream()
                    .filter(enchantment -> !containsEnchantment(possibleEnchantmentList, enchantment))
                    .forEach(enchantment -> addEntry(possibleEnchantmentList, level, enchantment));
            possibleEnchantmentList.removeIf(enchantmentLevelEntry ->
                    !RollingPinItem.ALLOWED_ENCHANTMENTS.contains(enchantmentLevelEntry.enchantment));
        }
    }

    @Unique
    private static void addEntry(List<EnchantmentInstance> list, int level, Enchantment enchantment) {
        for(int i = enchantment.getMaxLevel(); i > enchantment.getMinLevel() - 1; --i) {
            if (level >= enchantment.getMinCost(i) && level <= enchantment.getMaxCost(i)) {
                list.add(new EnchantmentInstance(enchantment, i));
                break;
            }
        }
    }

    @Unique
    private static boolean containsEnchantment(List<EnchantmentInstance> entries, Enchantment enchantment) {
        return entries.stream().anyMatch(enchantmentLevelEntry -> enchantmentLevelEntry.enchantment == enchantment);
    }
}
