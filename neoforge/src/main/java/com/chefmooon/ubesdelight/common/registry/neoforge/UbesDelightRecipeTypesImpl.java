package com.chefmooon.ubesdelight.common.registry.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.crafting.neoforge.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightRecipeTypesImpl {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, UbesDelight.MOD_ID);

    public static final Supplier<RecipeType<BakingMatRecipeImpl>> BAKING_MAT = RECIPE_TYPES.register(UbesDelightRecipeTypes.BAKING_MAT.getPath(), () -> UbesDelightRecipeTypes.registerRecipeType(UbesDelightRecipeTypes.BAKING_MAT.getPath()));

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
}
