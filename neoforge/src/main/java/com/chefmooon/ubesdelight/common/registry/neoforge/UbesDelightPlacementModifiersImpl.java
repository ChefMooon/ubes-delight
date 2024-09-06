package com.chefmooon.ubesdelight.common.registry.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.registry.UbesDelightPlacementModifiers;
import com.chefmooon.ubesdelight.common.world.placement.neoforge.BiomeIsOverworldPlacementModifierImpl;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightPlacementModifiersImpl {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE.key(), UbesDelight.MOD_ID);

    public static final Supplier<PlacementModifierType<BiomeIsOverworldPlacementModifierImpl>> BIOME_IS_OVERWORLD = PLACEMENT_MODIFIERS.register(UbesDelightPlacementModifiers.BIOME_IS_OVERWORLD.getPath(), () -> typeConvert(BiomeIsOverworldPlacementModifierImpl.CODEC));

    private static <P extends PlacementModifier> PlacementModifierType<P> typeConvert(MapCodec<P> codec) {
        return () -> codec;
    }

    public static void register(IEventBus eventBus) {
        PLACEMENT_MODIFIERS.register(eventBus);
    }
}
