package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import chefmooon.ubesdelight.common.block.entity.UniversalLeafFeastBlockEntity;
import chefmooon.ubesdelight.common.utility.RegistrationUtils;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class UbesDelightBlockEntityTypes {
    public static final Supplier<BlockEntityType<BakingMatBlockEntity>> BAKING_MAT_BAMBOO = register("baking_mat_bamboo",
            () -> FabricBlockEntityTypeBuilder.create(BakingMatBlockEntity::new, UbesDelightBlocks.BAKING_MAT_BAMBOO.get()).build());
    public static final Supplier<BlockEntityType<UniversalLeafFeastBlockEntity>> UNIVERSAL_LEAF_FEAST = register("universal_leaf_feast",
            () -> FabricBlockEntityTypeBuilder.create(UniversalLeafFeastBlockEntity::new, UbesDelightBlocks.UNIVERSAL_LEAF_FEAST.get()).build());

    public static <T extends BlockEntityType<?>> Supplier<T> register(String name, Supplier<T> supplier) {
        return RegistrationUtils.register(name, supplier, BuiltInRegistries.BLOCK_ENTITY_TYPE);
    }

    public static void register() {
    }
}
