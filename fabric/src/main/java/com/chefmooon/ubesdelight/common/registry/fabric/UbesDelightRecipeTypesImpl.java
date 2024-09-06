package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class UbesDelightRecipeTypesImpl {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, UbesDelight.MOD_ID);

    public static final Supplier<RecipeType<BakingMatRecipeImpl>> BAKING_MAT = RECIPE_TYPES.register(UbesDelightRecipeTypes.BAKING_MAT.getPath(), () -> UbesDelightRecipeTypes.registerRecipeType(UbesDelightRecipeTypes.BAKING_MAT.getPath()));

    public static void register() {
        RECIPE_TYPES.register();
    }
}
