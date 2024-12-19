package com.chefmooon.ubesdelight.common.registry.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.block.entity.forge.BakingMatBlockEntityImpl;
import com.chefmooon.ubesdelight.common.block.entity.forge.UniversalLeafFeastBlockEntityImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlockEntityTypes;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class UbesDelightBlockEntityTypesImpl {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, UbesDelight.MOD_ID);

    public static final RegistryObject<BlockEntityType<BakingMatBlockEntityImpl>> BAKING_MAT_BAMBOO = BLOCK_ENTITIES.register(UbesDelightBlockEntityTypes.BAKING_MAT_BAMBOO.getPath(),
            () -> BlockEntityType.Builder.of(BakingMatBlockEntityImpl::new, UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get()).build(null));

    public static final Supplier<BlockEntityType<UniversalLeafFeastBlockEntityImpl>> UNIVERSAL_LEAF_FEAST = BLOCK_ENTITIES.register(UbesDelightBlockEntityTypes.UNIVERSAL_LEAF_FEAST.getPath(),
            () -> BlockEntityType.Builder.of(UniversalLeafFeastBlockEntityImpl::new, UbesDelightBlocksImpl.UNIVERSAL_LEAF_FEAST.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
