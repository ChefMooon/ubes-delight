package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightRecipeSerializers;
import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class UbesDelightRecipeSerializersImpl {
    public static final LazyRegistrar<RecipeSerializer<?>> RECIPE_SERIALIZERS = LazyRegistrar.create(BuiltInRegistries.RECIPE_SERIALIZER, UbesDelight.MOD_ID);

    public static final Supplier<RecipeSerializer<?>> BAKING_MAT  = RECIPE_SERIALIZERS.register(UbesDelightRecipeSerializers.BAKING_MAT.getPath(), BakingMatRecipeImpl.Serializer::new);
}
