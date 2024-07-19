package com.chefmooon.ubesdelight.common.world.placement.forge;

import com.chefmooon.ubesdelight.common.registry.forge.UbesDelightPlacementModifiersImpl;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

public class BiomeIsOverworldPlacementModifierImpl extends PlacementFilter {
    private static final BiomeIsOverworldPlacementModifierImpl INSTANCE = new BiomeIsOverworldPlacementModifierImpl();
    public static final Codec<BiomeIsOverworldPlacementModifierImpl> CODEC = Codec.unit(INSTANCE);
    @Override
    protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
        return context.getLevel().getBiome(pos).is(BiomeTags.IS_OVERWORLD);
    }

    @Override
    public PlacementModifierType<?> type() {
        return UbesDelightPlacementModifiersImpl.BIOME_IS_OVERWORLD.get();
    }
}
