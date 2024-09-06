package com.chefmooon.ubesdelight.common.registry.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.crafting.neoforge.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightRecipeSerializers;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightRecipeSerializersImpl {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, UbesDelight.MOD_ID);

    public static final Supplier<RecipeSerializer<?>> BAKING_MAT = RECIPE_SERIALIZERS.register(UbesDelightRecipeSerializers.BAKING_MAT.getPath(), BakingMatRecipeImpl.Serializer::new);

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZERS.register(eventBus);
    }
}
