package com.chefmoon.ubesdelight.item;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UDConsumableItem extends Item {
    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;
    public UDConsumableItem(Settings settings) {
        super(settings);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }
    public UDConsumableItem(Settings settings, boolean hasFoodEffectTooltip) {
        super(settings);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = false;
    }

    public UDConsumableItem(Settings settings, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(settings);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack container = stack.getRecipeRemainder();

        super.finishUsing(stack, world, user);

        if (stack.isEmpty()) {
            return container;
        } else {
            if (user instanceof PlayerEntity player && !player.getAbilities().creativeMode && !player.getInventory().insertStack(container)) {
                player.dropItem(container, false);
            }
            return stack;
        }
    }

    @Override
    @Environment(value= EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (UbesDelightMod.CONFIG.isFoodEffectTooltip()) {
            if (hasCustomTooltip) {
                tooltip.add(UbesDelightMod.tooltip("tooltip." + this).formatted(Formatting.BLUE));
            }
            if (hasFoodEffectTooltip) {
                addFoodEffectTooltip(stack, tooltip, 1.f);
            }
        }
    }

    @Environment(value= EnvType.CLIENT)
    public static void addFoodEffectTooltip(ItemStack itemIn, List<Text> tooltip, float durationFactor) {
        FoodComponent foodStats = itemIn.getItem().getFoodComponent();
        if (foodStats == null) {
            return;
        }
        List<Pair<StatusEffectInstance, Float>> effectList = foodStats.getStatusEffects();
        if (!effectList.isEmpty()) {
            for (Pair<StatusEffectInstance, Float> effectPair : effectList) {
                StatusEffectInstance instance = effectPair.getFirst();
                MutableText iformattabletextcomponent = Text.translatable(instance.getTranslationKey());
                StatusEffect effect = instance.getEffectType();

                if (instance.getDuration() > 0) {
                    iformattabletextcomponent = Text.translatable("potion.withDuration", iformattabletextcomponent, StatusEffectUtil.getDurationText(instance, durationFactor));
                }

                tooltip.add(iformattabletextcomponent.formatted(effect.getCategory().getFormatting()));
            }
        }
    }
}
