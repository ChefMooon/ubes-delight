package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
import com.chefmooon.ubesdelight.common.utility.fabric.RegistrationUtilsImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class UbesDelightRecipeTypesImpl {
    public static final Supplier<RecipeType<BakingMatRecipeImpl>> BAKING_MAT = registerRec(UbesDelightRecipeTypes.BAKING_MAT.getPath(),
            () -> UbesDelightRecipeTypes.registerRecipeType(UbesDelightRecipeTypes.BAKING_MAT.getPath()));

    public static <T extends RecipeType<?>> Supplier<T> registerRec(String name, Supplier<T> supplier) {
        return RegistrationUtilsImpl.register(name, supplier, BuiltInRegistries.RECIPE_TYPE);
    }

    public static void register() {
    }
}
