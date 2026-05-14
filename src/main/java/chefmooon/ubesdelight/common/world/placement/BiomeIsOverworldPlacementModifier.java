package chefmooon.ubesdelight.common.world.placement;

import chefmooon.ubesdelight.common.registry.UbesDelightPlacementModifiers;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class BiomeIsOverworldPlacementModifier extends PlacementFilter {
    private static final BiomeIsOverworldPlacementModifier INSTANCE = new BiomeIsOverworldPlacementModifier();
    public static final MapCodec<BiomeIsOverworldPlacementModifier> CODEC = MapCodec.unit(INSTANCE);
    @Override
    protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
        return context.getLevel().getBiome(pos).is(BiomeTags.IS_OVERWORLD);
    }

    @Override
    public PlacementModifierType<?> type() {
        return UbesDelightPlacementModifiers.BIOME_IS_OVERWORLD;
    }
}
