package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.block.entity.fabric.BakingMatBlockEntityImpl;
import com.chefmooon.ubesdelight.common.block.entity.fabric.UniversalLeafFeastBlockEntityImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import com.chefmooon.ubesdelight.common.utility.fabric.RegistrationUtilsImpl;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class UbesDelightBlockEntityTypesImpl {
    public static final Supplier<BlockEntityType<BakingMatBlockEntityImpl>> BAKING_MAT_BAMBOO = register(UbesDelightBlockEntityTypes.BAKING_MAT_BAMBOO.getPath(),
            () -> FabricBlockEntityTypeBuilder.create(BakingMatBlockEntityImpl::new, UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get()).build());
    public static final Supplier<BlockEntityType<UniversalLeafFeastBlockEntityImpl>> UNIVERSAL_LEAF_FEAST = register(UbesDelightBlockEntityTypes.UNIVERSAL_LEAF_FEAST.getPath(),
            () -> FabricBlockEntityTypeBuilder.create(UniversalLeafFeastBlockEntityImpl::new, UbesDelightBlocksImpl.UNIVERSAL_LEAF_FEAST.get()).build());

    public static <T extends BlockEntityType<?>> Supplier<T> register(String name, Supplier<T> supplier) {
        return RegistrationUtilsImpl.register(name, supplier, BuiltInRegistries.BLOCK_ENTITY_TYPE);
    }

    public static void register() {
    }
}
