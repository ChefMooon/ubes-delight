package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import chefmooon.ubesdelight.common.utility.RegistrationUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.util.function.Supplier;

public class UbesDelightRecipeSerializers {
    public static final Supplier<RecipeSerializer<BakingMatRecipe>> BAKING_MAT = register("baking_mat", () -> new RecipeSerializer<>(BakingMatRecipe.Serializer.codec(), BakingMatRecipe.Serializer.streamCodec()));

    public static <T extends RecipeSerializer<?>> Supplier<T> register(String name, Supplier<T> supplier) {
        return RegistrationUtils.register(name, supplier, BuiltInRegistries.RECIPE_SERIALIZER);
    }

    public static void register() {
    }
}
