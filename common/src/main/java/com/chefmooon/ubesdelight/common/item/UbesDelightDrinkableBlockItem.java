package com.chefmooon.ubesdelight.common.item;

import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.block.GlassCupBlock;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
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
        if (stack.get(DataComponents.FOOD) != null) {
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
            BlockPlaceContext blockPlaceContext = this.updatePlacementContext(context);
            if (blockPlaceContext == null) {
                return InteractionResult.FAIL;
            } else {
                BlockState blockState = this.getPlacementState(blockPlaceContext);
                if (blockState == null) {
                    return InteractionResult.FAIL;
                } else {
                    BlockPos blockPos = blockPlaceContext.getClickedPos();
                    Level level = blockPlaceContext.getLevel();
                    ItemStack itemStack = blockPlaceContext.getItemInHand();
                    BlockState blockState2 = level.getBlockState(blockPos);
                    if (blockState2.getBlock() instanceof GlassCupBlock glassCupBlock && itemStack.is(glassCupBlock.servingItem.get())) {
                        glassCupBlock.addServingFromHand(level, blockPos, blockState2, player, player.getUsedItemHand());
                    } else {
                        return super.place(context);
                    }
                }
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (Configuration.isFoodEffectTooltip()) { // todo - add new config BlockItem tooltips? V0.2.0
            if (hasCustomTooltip) {
//                tooltip.add(TextUtils.getTranslatable("tooltip." + this).withStyle(ChatFormatting.DARK_GRAY));
                tooltip.add(TextUtils.getTranslatable("tooltip.glass_cup").withStyle(ChatFormatting.DARK_GRAY));
            }

            if (hasFoodEffectTooltip) {
                vectorwing.farmersdelight.common.utility.TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0F, context.tickRate());
            }
        }
    }
}
