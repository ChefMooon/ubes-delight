package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import chefmooon.ubesdelight.common.block.entity.UniversalLeafFeastBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, UbesDelight.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BakingMatBlockEntity>> BAKING_MAT_BAMBOO = BLOCK_ENTITIES.register("baking_mat_bamboo",
            () -> BlockEntityType.Builder.of(BakingMatBlockEntity::new, UbesDelightBlocks.BAKING_MAT_BAMBOO.get()).build(null));

    public static final Supplier<BlockEntityType<UniversalLeafFeastBlockEntity>> UNIVERSAL_LEAF_FEAST = BLOCK_ENTITIES.register("universal_leaf_feast",
            () -> BlockEntityType.Builder.of(UniversalLeafFeastBlockEntity::new, UbesDelightBlocks.UNIVERSAL_LEAF_FEAST.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
