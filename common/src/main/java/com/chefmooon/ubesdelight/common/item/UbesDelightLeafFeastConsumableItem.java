package com.chefmooon.ubesdelight.common.item;

import com.chefmooon.ubesdelight.common.block.leaf_feast.base.BaseLeafFeastBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class UbesDelightLeafFeastConsumableItem extends UbesDelightConsumableItem {
    public UbesDelightLeafFeastConsumableItem(Properties properties) {
        super(properties);
    }

    public UbesDelightLeafFeastConsumableItem(Properties properties, boolean hasFoodEffectTooltip) {
        super(properties, hasFoodEffectTooltip);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = context.getLevel().getBlockState(blockPos);
        Player player = context.getPlayer();
        if (blockState.getBlock() instanceof BaseLeafFeastBlock baseLeafFeastBlock) {
            if (baseLeafFeastBlock.useItemOn(player.getUseItem(), blockState, context.getLevel(), blockPos, player, player.getUsedItemHand(), new BlockHitResult(context.getClickLocation(), context.getClickedFace(), context.getClickedPos(), context.isInside())).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.PASS;
    }
}
