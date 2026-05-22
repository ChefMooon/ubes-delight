package chefmooon.ubesdelight.common.block.leaf_feast;

import chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import chefmooon.ubesdelight.common.core.LeafFeastTypes;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.registry.UbesDelightShapes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class HopiaLeafFeastBlock extends SimpleLeafFeastBlock {
    public HopiaLeafFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties, buildShapes());
    }

    public static ConcurrentHashMap<LeafFeastTypes, ConcurrentHashMap<Integer, VoxelShape>> buildShapes() {
        ConcurrentHashMap<LeafFeastTypes, ConcurrentHashMap<Integer, VoxelShape>> result = new ConcurrentHashMap<>();

        ConcurrentHashMap<Integer, VoxelShape> middleServingShapes = new ConcurrentHashMap<>();
        middleServingShapes.put(1, UbesDelightShapes.HOPIA_BASE_SERVING_1);
        middleServingShapes.put(2, UbesDelightShapes.HOPIA_BASE_SERVING_2);
        middleServingShapes.put(3, UbesDelightShapes.HOPIA_BASE_SERVING_3);
        middleServingShapes.put(4, UbesDelightShapes.HOPIA_BASE_SERVING_4);
        middleServingShapes.put(5, UbesDelightShapes.HOPIA_BASE_SERVING_5);
        middleServingShapes.put(6, UbesDelightShapes.HOPIA_BASE_SERVING_6);

        ConcurrentHashMap<Integer, VoxelShape> tipServingShapes = new ConcurrentHashMap<>();
        tipServingShapes.put(1, UbesDelightShapes.HOPIA_TIP_SERVING_1);
        tipServingShapes.put(2, UbesDelightShapes.HOPIA_TIP_SERVING_2);
        tipServingShapes.put(3, UbesDelightShapes.HOPIA_TIP_SERVING_3);

        ConcurrentHashMap<Integer, VoxelShape> endServingShapes = new ConcurrentHashMap<>();
        endServingShapes.put(1, UbesDelightShapes.HOPIA_END_SERVING_1);
        endServingShapes.put(2, UbesDelightShapes.HOPIA_END_SERVING_2);
        endServingShapes.put(3, UbesDelightShapes.HOPIA_END_SERVING_3);

        result.put(LeafFeastTypes.MIDDLE, middleServingShapes);
        result.put(LeafFeastTypes.TIP, tipServingShapes);
        result.put(LeafFeastTypes.END, endServingShapes);

        return result;
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state, boolean includeData) {
        if (state.getValue(SERVINGS) == 3) {
            if (servingItem.get() == UbesDelightItems.HOPIA_MUNGGO.get()) {
                return new ItemStack(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO_HALF.get());
            } else if (servingItem.get() == UbesDelightItems.HOPIA_UBE.get()) {
                return new ItemStack(UbesDelightItems.LEAF_FEAST_HOPIA_UBE_HALF.get());
            }
        } else {
            if (servingItem.get() == UbesDelightItems.HOPIA_MUNGGO.get()) {
                return new ItemStack(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO.get());
            } else if (servingItem.get() == UbesDelightItems.HOPIA_UBE.get()) {
                return new ItemStack(UbesDelightItems.LEAF_FEAST_HOPIA_UBE.get());
            }
        }
        return new ItemStack(this);
    }
}
