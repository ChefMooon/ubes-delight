package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import chefmooon.ubesdelight.common.utility.RegistrationUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

public class UbesDelightRecipeTypes {
    public static final Supplier<RecipeType<BakingMatRecipe>> BAKING_MAT = registerRec("baking_mat",
            () -> UbesDelightRecipeTypes.registerRecipeType("baking_mat"));

    public static <T extends RecipeType<?>> Supplier<T> registerRec(String name, Supplier<T> supplier) {
        return RegistrationUtils.register(name, supplier, BuiltInRegistries.RECIPE_TYPE);
    }

    public static void register() {
    }
    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<>()
        {
            public String toString() {
                return UbesDelight.MOD_ID + ":" + identifier;
            }
        };
    }
}
