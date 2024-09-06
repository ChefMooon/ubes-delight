package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import com.chefmooon.ubesdelight.common.registry.UbesDelightItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import static com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil.getBlock;
import static com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil.getItem;

public class LemongrassLeafCropBlock extends CropBlock {
    public static final IntegerProperty lEMONGRASS_AGE = BlockStateProperties.AGE_3;
    public static final int MAX_AGE = 3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(1.d, .0d, 1.d, 15.d, 4.d, 15.d),
            Block.box(1.d, .0d, 1.d, 15.d, 8.d, 15.d),
            Block.box(1.d, .0d, 1.d, 15.d, 10.d, 15.d),
            Block.box(1.d, .0d, 1.d, 15.d, 14.d, 15.d)
    };
    public LemongrassLeafCropBlock() {
        super(Block.Properties.ofFullCopy(Blocks.WHEAT));
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return lEMONGRASS_AGE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return getItem(UbesDelightItems.LEMONGRASS_SEEDS);
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(lEMONGRASS_AGE);
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return super.getBonemealAgeIncrease(level) / 2;
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(getBlock(UbesDelightBlocks.LEMONGRASS_STALK_CROP));
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return (level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos)) && this.mayPlaceOn(level.getBlockState(pos.below()), level, pos);
    }
}
