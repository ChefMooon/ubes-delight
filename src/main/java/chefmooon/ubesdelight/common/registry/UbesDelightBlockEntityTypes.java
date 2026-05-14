package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import chefmooon.ubesdelight.common.block.entity.UniversalLeafFeastBlockEntity;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class UbesDelightBlockEntityTypes {

    public static final Supplier<BlockEntityType<BakingMatBlockEntity>> BAKING_MAT_BAMBOO = register("universal_leaf_feast",
            () -> BlockEntityType.Builder.of(BakingMatBlockEntity::new, UbesDelightBlocks.BAKING_MAT_BAMBOO.get()).build());
    public static final Supplier<BlockEntityType<UniversalLeafFeastBlockEntity>> UNIVERSAL_LEAF_FEAST = register("baking_mat_bamboo",
            () -> BlockEntityType.Builder.of(UniversalLeafFeastBlockEntity::new, UbesDelightBlocks.UNIVERSAL_LEAF_FEAST.get()).build());

    public static <T extends BlockEntityType<?>> Supplier<T> register(String name, Supplier<T> blockEntityTypeSupplier) {
        T blockEntityType = blockEntityTypeSupplier.get();
        Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, TextUtils.res(name), blockEntityType);
        return () -> blockEntityType;
    }

    public static void register() {
    }
}
