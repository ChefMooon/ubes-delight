package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UbesDelightDataComponentTypes {
    public static final DeferredRegister.DataComponents DATA_COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, UbesDelight.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> SIMPLE_LEAF_FEAST_SERVINGS = DATA_COMPONENTS.registerComponentType(
            "simple_leaf_feast_servings", (builder) -> builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT));

    public static void register(IEventBus eventBus) {
        DATA_COMPONENTS.register(eventBus);
    }
}
