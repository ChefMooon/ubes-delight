package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.world.placement.BiomeIsOverworldPlacementModifier;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightPlacementModifiers {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(BuiltInRegistries.PLACEMENT_MODIFIER_TYPE.key(), UbesDelight.MOD_ID);

    public static final Supplier<PlacementModifierType<BiomeIsOverworldPlacementModifier>> BIOME_IS_OVERWORLD = PLACEMENT_MODIFIERS.register("biome_is_overworld", () -> typeConvert(BiomeIsOverworldPlacementModifier.CODEC));

    private static <P extends PlacementModifier> PlacementModifierType<P> typeConvert(MapCodec<P> codec) {
        return () -> codec;
    }

    public static void register(IEventBus eventBus) {
        PLACEMENT_MODIFIERS.register(eventBus);
    }
}
