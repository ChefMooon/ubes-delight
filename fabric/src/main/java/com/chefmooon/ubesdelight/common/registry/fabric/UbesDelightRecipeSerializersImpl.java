package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightRecipeSerializers;
import com.chefmooon.ubesdelight.common.utility.fabric.RegistrationUtilsImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class UbesDelightRecipeSerializersImpl {
    public static final Supplier<RecipeSerializer<BakingMatRecipeImpl>> BAKING_MAT = register(UbesDelightRecipeSerializers.BAKING_MAT.getPath(), BakingMatRecipeImpl.Serializer::new);

    public static <T extends RecipeSerializer<?>> Supplier<T> register(String name, Supplier<T> supplier) {
        return RegistrationUtilsImpl.register(name, supplier, BuiltInRegistries.RECIPE_SERIALIZER);
    }

    public static void register() {
    }
}
