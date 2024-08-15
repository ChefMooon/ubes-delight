package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.registry.UbesDelightShapes;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class LeafFeastBreadBlock extends LeafFeastSimpleUniversalBlock {
    private static final VoxelShape BREAD_SHAPE = UbesDelightShapes.BREAD_SHAPE;
    private static final VoxelShape BREAD_SHAPE_END = UbesDelightShapes.BREAD_SHAPE_END;
    private static final VoxelShape BREAD_SHAPE_TIP = UbesDelightShapes.BREAD_SHAPE_TIP;
    public LeafFeastBreadBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties, new VoxelShape[]{BREAD_SHAPE, BREAD_SHAPE_END, BREAD_SHAPE_TIP});
    }
}
