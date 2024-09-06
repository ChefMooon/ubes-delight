package com.chefmooon.ubesdelight.common.world.placement.neoforge;

import com.chefmooon.ubesdelight.common.registry.neoforge.UbesDelightPlacementModifiersImpl;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class BiomeIsOverworldPlacementModifierImpl extends PlacementFilter {
    private static final BiomeIsOverworldPlacementModifierImpl INSTANCE = new BiomeIsOverworldPlacementModifierImpl();
    public static final MapCodec<BiomeIsOverworldPlacementModifierImpl> CODEC = MapCodec.unit(INSTANCE);
    private BiomeIsOverworldPlacementModifierImpl() {
    }
    @Override
    protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
        return context.getLevel().getBiome(pos).is(BiomeTags.IS_OVERWORLD);
    }

    @Override
    public PlacementModifierType<?> type() {
        return UbesDelightPlacementModifiersImpl.BIOME_IS_OVERWORLD.get();
    }
}
