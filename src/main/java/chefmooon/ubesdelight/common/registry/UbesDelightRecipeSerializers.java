package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, UbesDelight.MOD_ID);

    public static final Supplier<RecipeSerializer<?>> BAKING_MAT = RECIPE_SERIALIZERS.register("baking_mat", BakingMatRecipe.Serializer::new);

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZERS.register(eventBus);
    }
}
