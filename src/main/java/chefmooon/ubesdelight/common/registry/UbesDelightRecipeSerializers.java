package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class UbesDelightRecipeSerializers {

    public static final Supplier<RecipeSerializer<?>> BAKING_MAT = register("baking_mat", BakingMatRecipe.Serializer::new);

    public static Supplier<RecipeSerializer<?>> register(String name, Supplier<RecipeSerializer<?>> recipeSerializerSupplier) {
        RecipeSerializer<?> recipeSerializer = recipeSerializerSupplier.get();
        Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, TextUtils.res(name), recipeSerializer);
        return () -> recipeSerializer;
    }

    public static void register() {
    }
}
