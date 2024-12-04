package com.chefmooon.ubesdelight.common.block.leaf_feast;

import com.chefmooon.ubesdelight.common.block.leaf_feast.base.LargeLeafFeastBlock;
import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.UbesDelightShapes;
import net.minecraft.world.item.Item;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;
import java.util.function.Supplier;

public class LumpiaLeafFeastBlock extends LargeLeafFeastBlock {
    public LumpiaLeafFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties, buildShapes());
    }

    public static HashMap<LeafFeastTypes, HashMap<Integer, VoxelShape>> buildShapes() {
        HashMap<LeafFeastTypes, HashMap<Integer, VoxelShape>> result = new HashMap<>();

        HashMap<Integer, VoxelShape> baseServingShapes = new HashMap<>();
        baseServingShapes.put(1, UbesDelightShapes.LUMPIA_SERVING_1_OF_3);
        baseServingShapes.put(2, UbesDelightShapes.LUMPIA_SERVING_2_OF_3);
        baseServingShapes.put(3, UbesDelightShapes.LUMPIA_SERVING_3_OF_3);

//        HashMap<Integer, VoxelShape> tipServingShapes = new HashMap<>();
//        tipServingShapes.put(1, UbesDelightShapes.PANDESAL_TIP_SERVING_1);
//        tipServingShapes.put(2, UbesDelightShapes.PANDESAL_TIP_SERVING_2);
//        tipServingShapes.put(3, UbesDelightShapes.PANDESAL_TIP_SERVING_3);
//
//        HashMap<Integer, VoxelShape> endServingShapes = new HashMap<>();
//        endServingShapes.put(1, UbesDelightShapes.PANDESAL_END_SERVING_1);
//        endServingShapes.put(2, UbesDelightShapes.PANDESAL_END_SERVING_2);
//        endServingShapes.put(3, UbesDelightShapes.PANDESAL_END_SERVING_3);

//        result.put(LeafFeastTypes.BASE, baseServingShapes);
        result.put(LeafFeastTypes.MIDDLE, baseServingShapes);

        return result;
    }
}
