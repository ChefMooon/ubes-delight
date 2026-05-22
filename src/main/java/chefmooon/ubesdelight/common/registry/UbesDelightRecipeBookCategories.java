package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.utility.RegistrationUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeBookCategory;

import java.util.function.Supplier;

public class UbesDelightRecipeBookCategories {
    public static final Supplier<RecipeBookCategory> BAKING_MAT = register("baking_mat", RecipeBookCategory::new);

    public static <T extends RecipeBookCategory> Supplier<T> register(String name, Supplier<T> supplier) {
        return RegistrationUtils.register(name, supplier, BuiltInRegistries.RECIPE_BOOK_CATEGORY);
    }

    public static void register() {
    }
}
