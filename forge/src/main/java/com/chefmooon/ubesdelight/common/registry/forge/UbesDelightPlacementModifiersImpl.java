package com.chefmooon.ubesdelight.common.registry.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.UbesDelightPlacementModifiers;
import com.chefmooon.ubesdelight.common.world.placement.forge.BiomeIsOverworldPlacementModifierImpl;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UbesDelightPlacementModifiersImpl {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE.key(), UbesDelight.MOD_ID);

    public static final RegistryObject<PlacementModifierType<BiomeIsOverworldPlacementModifierImpl>> BIOME_IS_OVERWORLD = PLACEMENT_MODIFIERS.register(UbesDelightPlacementModifiers.BIOME_IS_OVERWORLD.getPath(), () -> typeConvert(BiomeIsOverworldPlacementModifierImpl.CODEC));

    private static <P extends PlacementModifier> PlacementModifierType<P> typeConvert(Codec<P> codec) {
        return () -> codec;
    }

    public static void register(IEventBus eventBus) {
        PLACEMENT_MODIFIERS.register(eventBus);
    }
}
