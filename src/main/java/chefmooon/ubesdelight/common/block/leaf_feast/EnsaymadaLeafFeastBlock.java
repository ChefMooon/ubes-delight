package chefmooon.ubesdelight.common.block.leaf_feast;

import chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import chefmooon.ubesdelight.common.core.LeafFeastTypes;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.registry.UbesDelightShapes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

public class EnsaymadaLeafFeastBlock extends SimpleLeafFeastBlock {
    public EnsaymadaLeafFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(servingItem, properties, buildShapes());
    }

    public static ConcurrentHashMap<LeafFeastTypes, ConcurrentHashMap<Integer, VoxelShape>> buildShapes() {
        ConcurrentHashMap<LeafFeastTypes, ConcurrentHashMap<Integer, VoxelShape>> result = new ConcurrentHashMap<>();

        ConcurrentHashMap<Integer, VoxelShape> middleServingShapes = new ConcurrentHashMap<>();
        middleServingShapes.put(1, UbesDelightShapes.ENSAYMADA_BASE_SERVING_1);
        middleServingShapes.put(2, UbesDelightShapes.ENSAYMADA_BASE_SERVING_2);
        middleServingShapes.put(3, UbesDelightShapes.ENSAYMADA_BASE_SERVING_3);
        middleServingShapes.put(4, UbesDelightShapes.ENSAYMADA_BASE_SERVING_4);
        middleServingShapes.put(5, UbesDelightShapes.ENSAYMADA_BASE_SERVING_5);
        middleServingShapes.put(6, UbesDelightShapes.ENSAYMADA_BASE_SERVING_6);

        ConcurrentHashMap<Integer, VoxelShape> tipServingShapes = new ConcurrentHashMap<>();
        tipServingShapes.put(1, UbesDelightShapes.ENSAYMADA_TIP_SERVING_1);
        tipServingShapes.put(2, UbesDelightShapes.ENSAYMADA_TIP_SERVING_2);
        tipServingShapes.put(3, UbesDelightShapes.ENSAYMADA_TIP_SERVING_3);

        ConcurrentHashMap<Integer, VoxelShape> endServingShapes = new ConcurrentHashMap<>();
        endServingShapes.put(1, UbesDelightShapes.ENSAYMADA_END_SERVING_1);
        endServingShapes.put(2, UbesDelightShapes.ENSAYMADA_END_SERVING_2);
        endServingShapes.put(3, UbesDelightShapes.ENSAYMADA_END_SERVING_3);

        result.put(LeafFeastTypes.MIDDLE, middleServingShapes);
        result.put(LeafFeastTypes.TIP, tipServingShapes);
        result.put(LeafFeastTypes.END, endServingShapes);

        return result;
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        if (state.getValue(SERVINGS) == 3) {
            if (servingItem.get() == UbesDelightItems.ENSAYMADA) {
                return new ItemStack(UbesDelightItems.LEAF_FEAST_ENSAYMADA_HALF.get());
            } else if (servingItem.get() == UbesDelightItems.ENSAYMADA_UBE) {
                return new ItemStack(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE_HALF.get());
            }
        } else {
            if (servingItem.get() == UbesDelightItems.ENSAYMADA) {
                return new ItemStack(UbesDelightItems.LEAF_FEAST_ENSAYMADA.get());
            } else if (servingItem.get() == UbesDelightItems.ENSAYMADA_UBE) {
                return new ItemStack(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE.get());
            }
        }
        return new ItemStack(this);
    }
}
