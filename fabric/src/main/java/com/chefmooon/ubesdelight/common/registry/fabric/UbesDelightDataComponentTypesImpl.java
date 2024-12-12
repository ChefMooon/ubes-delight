package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.registry.UbesDelightDataComponentTypes;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;

import java.util.function.UnaryOperator;

public class UbesDelightDataComponentTypesImpl {

    public static final DataComponentType<Integer> SIMPLE_LEAF_FEAST_SERVINGS = register(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS.getPath(),
            (builder) -> builder.persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT));

    private static <T> DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> builder) {
        return (DataComponentType) Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, TextUtils.res(name), ((DataComponentType.Builder)builder.apply(DataComponentType.builder())).build());
    }

    public static void register() {

    }
}
