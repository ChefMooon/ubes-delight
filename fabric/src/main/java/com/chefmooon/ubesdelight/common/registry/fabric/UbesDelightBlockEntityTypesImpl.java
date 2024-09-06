package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.block.entity.fabric.BakingMatBlockEntityImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class UbesDelightBlockEntityTypesImpl {
    public static final DeferredRegister<BlockEntityType<?>> TILES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, UbesDelight.MOD_ID);

    public static final Supplier<BlockEntityType<BakingMatBlockEntityImpl>> BAKING_MAT_BAMBOO = TILES.register(UbesDelightBlockEntityTypes.BAKING_MAT_BAMBOO.getPath(),
            () -> BlockEntityType.Builder.of(BakingMatBlockEntityImpl::new, UbesDelightBlocksImpl.BAKING_MAT_BAMBOO).build());

    public static void register() {
        TILES.register();
    }
}
