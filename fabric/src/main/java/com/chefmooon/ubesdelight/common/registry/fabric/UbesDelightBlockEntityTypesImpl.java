package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.block.entity.fabric.BakingMatBlockEntityImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class UbesDelightBlockEntityTypesImpl {
    public static final BlockEntityType<BakingMatBlockEntityImpl> BAKING_MAT_BAMBOO = registerBlockEntityType(UbesDelightBlockEntityTypes.BAKING_MAT_BAMBOO, BakingMatBlockEntityImpl::new, UbesDelightBlocksImpl.BAKING_MAT_BAMBOO);

    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntityType(ResourceLocation location, FabricBlockEntityTypeBuilder.Factory<T> blockEntitySupplier, Block ... blocks) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, location, FabricBlockEntityTypeBuilder.create(blockEntitySupplier, blocks).build(null));
    }

    public static void register() {

    }
}
