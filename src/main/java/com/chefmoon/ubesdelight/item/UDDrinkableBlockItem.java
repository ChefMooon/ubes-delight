package com.chefmoon.ubesdelight.item;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UDDrinkableBlockItem extends BlockItem {
    private static final MutableText NO_EFFECTS = Text.translatable("effect.none").formatted(Formatting.GRAY);
    private final boolean hasFoodEffectTooltip;
    private final boolean hasCustomTooltip;
    public UDDrinkableBlockItem(Block block, Settings settings) {
        super(block,  settings);
        this.hasFoodEffectTooltip = false;
        this.hasCustomTooltip = false;
    }

    public UDDrinkableBlockItem(Block block, Settings settings, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(block, settings);
        this.hasFoodEffectTooltip = hasFoodEffectTooltip;
        this.hasCustomTooltip = hasCustomTooltip;
    }

    @Override
    @Environment(value= EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (UbesDelightMod.CONFIG.isFoodEffectTooltip()) {
            if (hasCustomTooltip) {
                tooltip.add(UbesDelightMod.tooltip("tooltip." + this).formatted(Formatting.GRAY));
            }
            if (hasFoodEffectTooltip) {
                addFoodEffectTooltip(stack, tooltip, 1.f);
            }
        }
    }

    @Override
    public ActionResult place(ItemPlacementContext context) {
        World world = context.getWorld();
        PlayerEntity playerEntity = context.getPlayer();
        if (playerEntity.isInSneakingPose()) {
            return super.place(context);
        }
        return ActionResult.FAIL;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 32;
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack container = stack.getRecipeRemainder();
        PlayerEntity player;
        super.finishUsing(stack, world, user);
        if (!world.isClient()) {
            this.affectConsumer(stack, world, user);
        }
        if (stack.isEmpty()) {
            return container;
        } else {
            if (user instanceof PlayerEntity) {
                player = (PlayerEntity) user;
                if (!player.getAbilities().creativeMode && !player.getInventory().insertStack(container)) {
                    player.dropItem(container, false);
                }
            }
            return stack;
        }
    }

    public void affectConsumer(ItemStack stack, World world, LivingEntity user) {
    }

    @Environment(EnvType.CLIENT)
    public static void addFoodEffectTooltip(ItemStack itemIn, List<Text> lores, float durationFactor) {
        FoodComponent foodStats = itemIn.getItem().getFoodComponent();
        if (foodStats != null) {
            List<com.mojang.datafixers.util.Pair<StatusEffectInstance, Float>> effectList = foodStats.getStatusEffects();
            List<com.mojang.datafixers.util.Pair<EntityAttribute, EntityAttributeModifier>> attributeList = Lists.newArrayList();
            Iterator var6;
            Pair pair;
            MutableText iformattabletextcomponent;
            StatusEffect effect;
            if (effectList.isEmpty()) {
                lores.add(NO_EFFECTS);
            } else {
                for(var6 = effectList.iterator(); var6.hasNext(); lores.add(iformattabletextcomponent.formatted(effect.getCategory().getFormatting()))) {
                    pair = (Pair)var6.next();
                    StatusEffectInstance instance = (StatusEffectInstance)pair.getFirst();
                    iformattabletextcomponent = Text.translatable(instance.getTranslationKey());
                    effect = instance.getEffectType();
                    Map<EntityAttribute, EntityAttributeModifier> attributeMap = effect.getAttributeModifiers();
                    if (!attributeMap.isEmpty()) {
                        Iterator var12 = attributeMap.entrySet().iterator();

                        while(var12.hasNext()) {
                            Map.Entry<EntityAttribute, EntityAttributeModifier> entry = (Map.Entry)var12.next();
                            EntityAttributeModifier rawModifier = (EntityAttributeModifier)entry.getValue();
                            EntityAttributeModifier modifier = new EntityAttributeModifier(rawModifier.getName(), effect.adjustModifierAmount(instance.getAmplifier(), rawModifier), rawModifier.getOperation());
                            attributeList.add(new Pair((EntityAttribute)entry.getKey(), modifier));
                        }
                    }

                    if (instance.getAmplifier() > 0) {
                        iformattabletextcomponent = Text.translatable("potion.withAmplifier", new Object[]{iformattabletextcomponent, Text.translatable("potion.potency." + instance.getAmplifier())});
                    }

                    if (instance.getDuration() > 20) {
                        iformattabletextcomponent = Text.translatable("potion.withDuration", new Object[]{iformattabletextcomponent, StatusEffectUtil.getDurationText(instance, durationFactor)});
                    }
                }
            }

            if (!attributeList.isEmpty()) {
                lores.add(Text.empty());
                lores.add(Text.translatable("potion.whenDrank").formatted(Formatting.DARK_PURPLE));
                var6 = attributeList.iterator();

                while(var6.hasNext()) {
                    pair = (Pair)var6.next();
                    EntityAttributeModifier modifier = (EntityAttributeModifier)pair.getSecond();
                    double amount = modifier.getValue();
                    double formattedAmount;
                    if (modifier.getOperation() != EntityAttributeModifier.Operation.MULTIPLY_BASE && modifier.getOperation() != EntityAttributeModifier.Operation.MULTIPLY_TOTAL) {
                        formattedAmount = modifier.getValue();
                    } else {
                        formattedAmount = modifier.getValue() * 100.0;
                    }

                    if (amount > 0.0) {
                        lores.add(Text.translatable("attribute.modifier.plus." + modifier.getOperation().getId(), new Object[]{ItemStack.MODIFIER_FORMAT.format(formattedAmount), Text.translatable(((EntityAttribute)pair.getFirst()).getTranslationKey())}).formatted(Formatting.BLUE));
                    } else if (amount < 0.0) {
                        formattedAmount *= -1.0;
                        lores.add(Text.translatable("attribute.modifier.take." + modifier.getOperation().getId(), new Object[]{ItemStack.MODIFIER_FORMAT.format(formattedAmount), Text.translatable(((EntityAttribute)pair.getFirst()).getTranslationKey())}).formatted(Formatting.RED));
                    }
                }
            }

        }
    }
}
