package com.chefmooon.ubesdelight.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.Objects;

public class UbesDelightDrinkableBlockItem extends UbesDelightBlockItem {
    public UbesDelightDrinkableBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(block, properties, hasFoodEffectTooltip, hasCustomTooltip);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide) {
            this.affectConsumer(stack, level, consumer);
        }

        ItemStack containerStack = new ItemStack(Objects.requireNonNull(stack.getItem().getCraftingRemainingItem()));
        Player player;
        if (stack.isEdible()) {
            super.finishUsingItem(stack, level, consumer);
        } else {
            player = consumer instanceof Player ? (Player)consumer : null;
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, stack);
            }

            if (player != null) {
                player.awardStat(Stats.ITEM_USED.get(this));
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
            }
        }

        if (stack.isEmpty()) {
            return containerStack;
        } else {
            if (consumer instanceof Player) {
                player = (Player)consumer;
                if (!((Player)consumer).getAbilities().instabuild && !player.getInventory().add(containerStack)) {
                    player.drop(containerStack, false);
                }
            }

            return stack;
        }
    }

    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
    }

    @Override
    public InteractionResult place(BlockPlaceContext context) {
        Player player = context.getPlayer();
        if (player != null && player.isShiftKeyDown()) {
            return super.place(context);
        }
        return InteractionResult.FAIL;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }
}
