package chefmooon.ubesdelight.common.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class HaloHaloFeastBlock extends DrinkableFeastBlock {
    public HaloHaloFeastBlock(Supplier<Item> servingItem, BlockBehaviour.Properties properties) {
        super(servingItem, properties);
    }
}
