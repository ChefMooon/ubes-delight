package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.registry.UbesDelightRecipeBookCategories;
import com.chefmooon.ubesdelight.common.utility.fabric.RegistrationUtilsImpl;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeBookCategory;

import java.util.function.Supplier;

public class UbesDelightRecipeBookCategoriesImpl {

    public static final Supplier<RecipeBookCategory> BAKING_MAT = register(UbesDelightRecipeBookCategories.BAKING_MAT.getPath(), RecipeBookCategory::new);

    public static <T extends RecipeBookCategory> Supplier<T> register(String name, Supplier<T> supplier) {
        return RegistrationUtilsImpl.register(name, supplier, BuiltInRegistries.RECIPE_BOOK_CATEGORY);
    }

    public static void register() {
    }
}
