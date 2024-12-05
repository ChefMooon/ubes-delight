package com.chefmoon.ubesdelight.mixin;

import com.chefmoon.ubesdelight.item.RollingPinItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public abstract class EnchantmentEnhancementMixin {

    @Inject(method = "isAcceptableItem", at = @At("RETURN"), cancellable = true)
    private void getPossibleEntriesEnhanced(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        boolean canBeEnchanted = false;

        if (stack.getItem() instanceof RollingPinItem) {
            for (Enchantment enchantment : RollingPinItem.ALLOWED_ENCHANTMENTS) {
                if ((Object)this == enchantment) {
                    canBeEnchanted = true;
                    break;
                }
            }
            cir.setReturnValue(canBeEnchanted);
        }
    }
}
