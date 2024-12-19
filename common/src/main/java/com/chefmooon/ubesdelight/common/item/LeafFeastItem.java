package com.chefmooon.ubesdelight.common.item;

import com.chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class LeafFeastItem extends BlockItem {
    public LeafFeastItem(Block block, Properties properties) {
        super(block, properties);
    }
    @Override
    protected boolean placeBlock(BlockPlaceContext context, BlockState state) {
        if (state.getBlock() instanceof SimpleLeafFeastBlock) {
            int servings = context.getItemInHand().getOrCreateTag().contains("servings")
                    ? context.getItemInHand().getOrCreateTag().getInt("servings")
                    : 3;
            BlockState newState = state.setValue(SimpleLeafFeastBlock.SERVINGS, servings);
            return super.placeBlock(context, newState);
        }
        return false;
    }

    @Override
    public String getDescriptionId() {
        return this.getOrCreateDescriptionId();
    }
}
