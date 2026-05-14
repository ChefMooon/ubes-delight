package chefmooon.ubesdelight.common.registry;


import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

import java.util.function.Supplier;

import static vectorwing.farmersdelight.refabricated.RegUtils.regRecipe;

public class UbesDelightRecipeTypes {

    public static final Supplier<RecipeType<BakingMatRecipe>> BAKING_MAT = regRecipe("baking_mat", () -> registerRecipeType("baking_mat"));

    public static <T extends Recipe<?>> RecipeType<T> registerRecipeType(final String identifier) {
        return new RecipeType<>() {
            public String toString() {
                return UbesDelight.MOD_ID + ":" + identifier;
            }
        };
    }

    public static void register() {
    }
}
