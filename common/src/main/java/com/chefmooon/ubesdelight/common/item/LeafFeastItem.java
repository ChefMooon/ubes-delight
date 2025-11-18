package com.chefmooon.ubesdelight.common.item;

import com.chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import com.chefmooon.ubesdelight.common.registry.UbesDelightDataComponentTypes;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
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
        if (state.getBlock() instanceof SimpleLeafFeastBlock && context.getItemInHand().has(BuiltInRegistries.DATA_COMPONENT_TYPE.get(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS).get().value())) {
            int servings = context.getItemInHand().get((DataComponentType<Integer>) BuiltInRegistries.DATA_COMPONENT_TYPE.get(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS).get().value());
            BlockState newState = state.setValue(SimpleLeafFeastBlock.SERVINGS, servings);
            return super.placeBlock(context, newState);
        }
        return false;
    }
}
