package com.chefmooon.ubesdelight.common.registry.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.crafting.forge.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UbesDelightRecipeTypesImpl {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, UbesDelight.MOD_ID);

    public static final RegistryObject<RecipeType<BakingMatRecipeImpl>> BAKING_MAT = RECIPE_TYPES.register(UbesDelightRecipeTypes.BAKING_MAT.getPath(), () -> UbesDelightRecipeTypes.registerRecipeType(UbesDelightRecipeTypes.BAKING_MAT.getPath()));

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
}
