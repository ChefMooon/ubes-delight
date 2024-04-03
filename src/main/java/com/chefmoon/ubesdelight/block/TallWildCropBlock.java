package com.chefmoon.ubesdelight.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class TallWildCropBlock extends TallPlantBlock implements Fertilizable {

    public TallWildCropBlock() {
        super(FabricBlockSettings.copyOf(Blocks.TALL_GRASS).sounds(BlockSoundGroup.CROP).offset(OffsetType.XZ));
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return (double) random.nextFloat() < .8f;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int wildCropLimit = WildCropBlock.WILD_CROP_LIMIT;

        if (state.get(HALF) == DoubleBlockHalf.UPPER) {
            state = state.with(HALF, DoubleBlockHalf.LOWER);
            pos = pos.down();
        }

        for (BlockPos blockpos : BlockPos.iterate(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
            if (world.getBlockState(blockpos).isOf(this) && (world.getBlockState(blockpos).get(HALF) == DoubleBlockHalf.LOWER)) {
                --wildCropLimit;
                if (wildCropLimit <= 0) {
                    return;
                }
            }
        }

        BlockPos neighborsBlockPos = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);

        for (int k = 0; k < 4; ++k) {
            if (world.isAir(neighborsBlockPos) && state.canPlaceAt(world, neighborsBlockPos)) {
                pos = neighborsBlockPos;
            }

            neighborsBlockPos = pos.add(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
        }

        if (world.isAir(neighborsBlockPos) && world.isAir(neighborsBlockPos.up()) && state.canPlaceAt(world, neighborsBlockPos)) {
            placeAt(world, state, neighborsBlockPos, 1 << 1);
        }
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return WildCropBlock.PLANT_ON_LIST.contains(floor.getBlock());
    }

    @Override
    public boolean canReplace(BlockState state, ItemPlacementContext context) {
        return false;
    }
}
