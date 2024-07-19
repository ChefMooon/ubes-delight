package com.chefmooon.ubesdelight.common.registry.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.crafting.forge.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightRecipeSerializers;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UbesDelightRecipeSerializersImpl {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, UbesDelight.MOD_ID);

    public static final RegistryObject<RecipeSerializer<?>> BAKING_MAT = RECIPE_SERIALIZERS.register(UbesDelightRecipeSerializers.BAKING_MAT.getPath(), BakingMatRecipeImpl.Serializer::new);

    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZERS.register(eventBus);
    }
}
