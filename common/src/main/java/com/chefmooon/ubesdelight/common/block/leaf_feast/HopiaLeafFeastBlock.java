package com.chefmooon.ubesdelight.common.block.leaf_feast;

import com.chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.UbesDelightShapes;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;
import java.util.function.Supplier;

public class HopiaLeafFeastBlock extends SimpleLeafFeastBlock {
    public HopiaLeafFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties, buildShapes());
    }

    public static HashMap<LeafFeastTypes, HashMap<Integer, VoxelShape>> buildShapes() {
        HashMap<LeafFeastTypes, HashMap<Integer, VoxelShape>> result = new HashMap<>();

        HashMap<Integer, VoxelShape> baseServingShapes = new HashMap<>();
        baseServingShapes.put(1, UbesDelightShapes.HOPIA_BASE_SERVING_1);
        baseServingShapes.put(2, UbesDelightShapes.HOPIA_BASE_SERVING_2);
        baseServingShapes.put(3, UbesDelightShapes.HOPIA_BASE_SERVING_3);
        baseServingShapes.put(4, UbesDelightShapes.HOPIA_BASE_SERVING_4);
        baseServingShapes.put(5, UbesDelightShapes.HOPIA_BASE_SERVING_5);
        baseServingShapes.put(6, UbesDelightShapes.HOPIA_BASE_SERVING_6);

        HashMap<Integer, VoxelShape> tipServingShapes = new HashMap<>();
        tipServingShapes.put(1, UbesDelightShapes.HOPIA_TIP_SERVING_1);
        tipServingShapes.put(2, UbesDelightShapes.HOPIA_TIP_SERVING_2);
        tipServingShapes.put(3, UbesDelightShapes.HOPIA_TIP_SERVING_3);

        HashMap<Integer, VoxelShape> endServingShapes = new HashMap<>();
        endServingShapes.put(1, UbesDelightShapes.HOPIA_END_SERVING_1);
        endServingShapes.put(2, UbesDelightShapes.HOPIA_END_SERVING_2);
        endServingShapes.put(3, UbesDelightShapes.HOPIA_END_SERVING_3);

        result.put(LeafFeastTypes.BASE, baseServingShapes);
        result.put(LeafFeastTypes.MIDDLE, baseServingShapes);
        result.put(LeafFeastTypes.TIP, tipServingShapes);
        result.put(LeafFeastTypes.END, endServingShapes);

        return result;
    }
}
