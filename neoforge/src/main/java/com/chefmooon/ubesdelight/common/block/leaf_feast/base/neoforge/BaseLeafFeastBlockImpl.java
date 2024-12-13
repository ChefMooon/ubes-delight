package com.chefmooon.ubesdelight.common.block.leaf_feast.base.neoforge;

import com.chefmooon.ubesdelight.common.block.entity.neoforge.UniversalLeafFeastBlockEntityImpl;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.LeafFeastBlock;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BaseLeafFeastBlockImpl implements LeafFeastBlock{

    public static ItemInteractionResult transformToUniversal(ItemStack itemStack, BlockState state, Level level, BlockPos pos, Player player) {
        BaseLeafFeastBlockImpl baseLeafFeastBlock = new BaseLeafFeastBlockImpl();
        if (level.setBlock(pos, baseLeafFeastBlock.getTransformState(BuiltInRegistryUtil.getBlock(UbesDelightBlocks.UNIVERSAL_LEAF_FEAST), state), 3)) {
            if (level.getBlockEntity(pos) instanceof UniversalLeafFeastBlockEntityImpl universalLeafFeastBlockEntity) {
                universalLeafFeastBlockEntity.addItem(player, player.getAbilities().instabuild ? itemStack.copy() : itemStack);
            }
            baseLeafFeastBlock.playAddSound(level, pos);
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public static ItemStack getContainer(Level level, ItemStack itemStack) {
        return itemStack.getCraftingRemainingItem();
    }

}
