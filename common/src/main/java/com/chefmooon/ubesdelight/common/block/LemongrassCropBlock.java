package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import com.chefmooon.ubesdelight.common.registry.UbesDelightItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LemongrassCropBlock extends CropBlock {
    // todo - Remove in V0.1.5 / DATAFIXER
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(.0d, .0d, .0d, 16.d, 2.d, 16.d),
            Block.box(.0d, .0d, .0d, 16.d, 3.d, 16.d),
            Block.box(.0d, .0d, .0d, 16.d, 4.d, 16.d),
            Block.box(.0d, .0d, .0d, 16.d, 5.d, 16.d),
            Block.box(.0d, .0d, .0d, 16.d, 6.d, 16.d),
            Block.box(.0d, .0d, .0d, 16.d, 7.d, 16.d),
            Block.box(.0d, .0d, .0d, 16.d, 8.d, 16.d),
            Block.box(.0d, .0d, .0d, 16.d, 9.d, 16.d)
    };
    public LemongrassCropBlock() {
        super(Block.Properties.copy(Blocks.WHEAT));
    }

    @Override
    public BlockState getPlant(BlockGetter level, BlockPos pos) {
        return BuiltInRegistries.BLOCK.get(UbesDelightBlocks.LEMONGRASS_CROP).defaultBlockState();
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return BuiltInRegistries.ITEM.get(UbesDelightItems.LEMONGRASS_SEEDS);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }
}