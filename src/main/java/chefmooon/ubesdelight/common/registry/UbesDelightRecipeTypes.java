package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, UbesDelight.MOD_ID);

    public static final Supplier<RecipeType<BakingMatRecipe>> BAKING_MAT = RECIPE_TYPES.register("baking_mat", () -> UbesDelightRecipeTypes.registerRecipeType("baking_mat"));

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
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
