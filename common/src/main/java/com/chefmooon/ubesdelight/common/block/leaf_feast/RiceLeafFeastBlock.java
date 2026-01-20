package com.chefmooon.ubesdelight.common.block.leaf_feast;

import com.chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.UbesDelightItems;
import com.chefmooon.ubesdelight.common.registry.UbesDelightShapes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class RiceLeafFeastBlock extends SimpleLeafFeastBlock {
    public RiceLeafFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties, buildShapes());
    }

    public static ConcurrentHashMap<LeafFeastTypes, ConcurrentHashMap<Integer, VoxelShape>> buildShapes() {
        ConcurrentHashMap<LeafFeastTypes, ConcurrentHashMap<Integer, VoxelShape>> result = new ConcurrentHashMap<>();

        ConcurrentHashMap<Integer, VoxelShape> baseServingShapes = new ConcurrentHashMap<>();
       baseServingShapes.put(1, UbesDelightShapes.RICE_BASE_SERVING_1);
       baseServingShapes.put(2, UbesDelightShapes.RICE_BASE_SERVING_2);
       baseServingShapes.put(3, UbesDelightShapes.RICE_BASE_SERVING_3);
       baseServingShapes.put(4, UbesDelightShapes.RICE_BASE_SERVING_4);
       baseServingShapes.put(5, UbesDelightShapes.RICE_BASE_SERVING_5);
       baseServingShapes.put(6, UbesDelightShapes.RICE_BASE_SERVING_6);

        ConcurrentHashMap<Integer, VoxelShape> middleServingShapes = new ConcurrentHashMap<>();
        middleServingShapes.put(1, UbesDelightShapes.RICE_BASE_SERVING_1);
        middleServingShapes.put(2, UbesDelightShapes.RICE_BASE_SERVING_2);
        middleServingShapes.put(3, UbesDelightShapes.RICE_BASE_SERVING_3);
        middleServingShapes.put(4, UbesDelightShapes.RICE_BASE_SERVING_4);
        middleServingShapes.put(5, UbesDelightShapes.RICE_BASE_SERVING_5);
        middleServingShapes.put(6, UbesDelightShapes.RICE_MIDDLE_SERVING_6);

        ConcurrentHashMap<Integer, VoxelShape> tipServingShapes = new ConcurrentHashMap<>();
        tipServingShapes.put(1, UbesDelightShapes.RICE_TIP_SERVING_1);
        tipServingShapes.put(2, UbesDelightShapes.RICE_TIP_SERVING_2);
        tipServingShapes.put(3, UbesDelightShapes.RICE_TIP_SERVING_3);

        ConcurrentHashMap<Integer, VoxelShape> endServingShapes = new ConcurrentHashMap<>();
        endServingShapes.put(1, UbesDelightShapes.RICE_END_SERVING_1);
        endServingShapes.put(2, UbesDelightShapes.RICE_END_SERVING_2);
        endServingShapes.put(3, UbesDelightShapes.RICE_END_SERVING_3);

        result.put(LeafFeastTypes.BASE, baseServingShapes);
        result.put(LeafFeastTypes.MIDDLE, middleServingShapes);
        result.put(LeafFeastTypes.TIP, tipServingShapes);
        result.put(LeafFeastTypes.END, endServingShapes);

        return result;
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        if (state.getValue(SERVINGS) == 3) {
            if (servingItem.get() == BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("farmersdelight", "cooked_rice")).get().value()) {
                return new ItemStack(BuiltInRegistries.ITEM.get(UbesDelightItems.LEAF_FEAST_COOKED_RICE_HALF).get());
            } else if (servingItem.get() == BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("farmersdelight", "fried_rice")).get().value()) {
                return new ItemStack(BuiltInRegistries.ITEM.get(UbesDelightItems.LEAF_FEAST_FRIED_RICE_HALF).get());
            } else if (servingItem.get() == BuiltInRegistries.ITEM.get(UbesDelightItems.SINANGAG).get().value()) {
                return new ItemStack(BuiltInRegistries.ITEM.get(UbesDelightItems.LEAF_FEAST_SINANGAG_HALF).get());
            }
        } else {
            if (servingItem.get() == BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("farmersdelight", "cooked_rice")).get().value()) {
                return new ItemStack(BuiltInRegistries.ITEM.get(UbesDelightItems.LEAF_FEAST_COOKED_RICE).get());
            } else if (servingItem.get() == BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("farmersdelight", "fried_rice")).get().value()) {
                return new ItemStack(BuiltInRegistries.ITEM.get(UbesDelightItems.LEAF_FEAST_FRIED_RICE).get());
            } else if (servingItem.get() == BuiltInRegistries.ITEM.get(UbesDelightItems.SINANGAG).get().value()) {
                return new ItemStack(BuiltInRegistries.ITEM.get(UbesDelightItems.LEAF_FEAST_SINANGAG).get());
            }
        }
        return new ItemStack(this);
    }
}
