package com.chefmooon.ubesdelight.common.registry.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.block.entity.neoforge.BakingMatBlockEntityImpl;
import com.chefmooon.ubesdelight.common.block.entity.neoforge.UniversalLeafFeastBlockEntityImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightBlockEntityTypesImpl {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, UbesDelight.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BakingMatBlockEntityImpl>> BAKING_MAT_BAMBOO = BLOCK_ENTITIES.register(UbesDelightBlockEntityTypes.BAKING_MAT_BAMBOO.getPath(),
            () -> BlockEntityType.Builder.of(BakingMatBlockEntityImpl::new, UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get()).build(null));

    public static final Supplier<BlockEntityType<UniversalLeafFeastBlockEntityImpl>> UNIVERSAL_LEAF_FEAST = BLOCK_ENTITIES.register(UbesDelightBlockEntityTypes.UNIVERSAL_LEAF_FEAST.getPath(),
            () -> BlockEntityType.Builder.of(UniversalLeafFeastBlockEntityImpl::new, UbesDelightBlocksImpl.UNIVERSAL_LEAF_FEAST.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
