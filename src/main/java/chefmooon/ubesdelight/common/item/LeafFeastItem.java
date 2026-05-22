package chefmooon.ubesdelight.common.item;

import chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import chefmooon.ubesdelight.common.registry.UbesDelightDataComponentTypes;
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
        if (state.getBlock() instanceof SimpleLeafFeastBlock && context.getItemInHand().has(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS)) {
            int servings = context.getItemInHand().getOrDefault(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 1);
            BlockState newState = state.setValue(SimpleLeafFeastBlock.SERVINGS, servings);
            return super.placeBlock(context, newState);
        }
        return false;
    }
}
