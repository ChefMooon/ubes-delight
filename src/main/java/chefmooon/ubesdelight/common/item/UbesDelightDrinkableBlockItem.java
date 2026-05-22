package chefmooon.ubesdelight.common.item;

import chefmooon.ubesdelight.common.Configuration;
import chefmooon.ubesdelight.common.block.GlassCupBlock;
import chefmooon.ubesdelight.common.item.UbesDelightBlockItem;
import chefmooon.ubesdelight.common.utility.TextUtils;
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
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class UbesDelightDrinkableBlockItem extends UbesDelightBlockItem {
    public UbesDelightDrinkableBlockItem(Block block, Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        super(block, properties, hasFoodEffectTooltip, hasCustomTooltip);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
        if (!level.isClientSide()) {
            this.affectConsumer(stack, level, consumer);
        }

        ItemStackTemplate containerStack = stack.getCraftingRemainder();

        if (stack.get(DataComponents.FOOD) != null || stack.get(DataComponents.CONSUMABLE) != null) {
            super.finishUsingItem(stack, level, consumer);
        } else {
            Player player = consumer instanceof Player ? (Player)consumer : null;
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

        if (containerStack != null) {
            if (stack.isEmpty()) {
                return containerStack.create();
            } else {
                if (consumer instanceof Player player && !((Player) consumer).getAbilities().instabuild) {
                    if (!player.getInventory().add((containerStack.create()))) {
                        player.drop(containerStack.create(), false);
                    }
                }
            }
        }
        return stack;
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
    public ItemUseAnimation getUseAnimation(ItemStack stack) {
        return ItemUseAnimation.DRINK;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
        if (Configuration.isFoodEffectTooltip()) { // todo - add new config BlockItem tooltips? V0.2.0
            if (hasCustomTooltip) {
                tooltipAdder.accept(TextUtils.getTranslatable("tooltip.glass_cup").withStyle(ChatFormatting.DARK_GRAY));
            }

            if (hasFoodEffectTooltip) {
                vectorwing.farmersdelight.common.utility.TextUtils.addFoodEffectTooltip(stack, tooltipAdder, 1.0F, context.tickRate());
            }
        }
    }
}
