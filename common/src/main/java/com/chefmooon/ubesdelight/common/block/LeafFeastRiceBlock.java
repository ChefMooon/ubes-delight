package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.registry.UbesDelightShapes;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class LeafFeastRiceBlock extends LeafFeastSimpleUniversalBlock {
    private static final VoxelShape RICE_SHAPE = UbesDelightShapes.RICE_SHAPE;

    public LeafFeastRiceBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties, RICE_SHAPE);
    }

}
