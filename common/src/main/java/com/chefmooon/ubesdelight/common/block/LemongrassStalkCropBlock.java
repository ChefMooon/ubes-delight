package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import com.chefmooon.ubesdelight.common.registry.UbesDelightItems;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.registry.ModBlocks;

import static com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil.getBlock;
import static com.chefmooon.ubesdelight.common.utility.BuiltInRegistryUtil.getItemLike;

public class LemongrassStalkCropBlock extends CropBlock {
    public static final IntegerProperty LEMONGRASS_AGE = BlockStateProperties.AGE_5;
    public static final BooleanProperty SUPPORTING = BooleanProperty.create("supporting");
    public static final int MAX_AGE = 5;
    public static final int GROWTH_CHANCE = 10;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(4.d, .0d, 4.d, 12.d, 4.d, 12.d),
            Block.box(3.d, .0d, 3.d, 13.d, 6.d, 13.d),
            Block.box(3.d, .0d, 3.d, 13.d, 8.d, 13.d),
            Block.box(2.d, .0d, 2.d, 14.d, 10.d, 14.d),
            Block.box(2.d, .0d, 2.d, 14.d, 12.d, 14.d),
            Block.box(1.d, .0d, 1.d, 15.d, 16.d, 15.d),
            Block.box(1.d, .0d, 1.d, 15.d, 16.d, 15.d)
    };
    public LemongrassStalkCropBlock() {
        super(Block.Properties.ofFullCopy(Blocks.WHEAT).strength(0.2F));
        this.registerDefaultState(this.stateDefinition.any().setValue(LEMONGRASS_AGE, 0).setValue(SUPPORTING, false));
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.tick(state, level, pos, random);
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getRawBrightness(pos.above(), 0) >= 6) {
            int age = this.getAge(state);
            if (age <= this.getMaxAge()) {
                if (random.nextInt((int) (25.0F / GROWTH_CHANCE) + 1) == 0) {
                    if (age == this.getMaxAge()) {
                        LemongrassLeafCropBlock lemongrassUpper = (LemongrassLeafCropBlock) getBlock(UbesDelightBlocks.LEMONGRASS_LEAF_CROP);
                        if (lemongrassUpper.defaultBlockState().canSurvive(level, pos.above()) && level.isEmptyBlock(pos.above())) {
                            level.setBlockAndUpdate(pos.above(), lemongrassUpper.defaultBlockState());
                        }
                    } else {
                        level.setBlock(pos, this.withAge(age + 1), 2);
                    }
                }
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(this.getAgeProperty())];
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(Blocks.FARMLAND) || state.is(CommonTags.C_FARMLAND) || state.is(ModBlocks.RICH_SOIL.get());
    }

    protected IntegerProperty getAgeProperty() {
        return LEMONGRASS_AGE;
    }

    public int getAge(BlockState state) {
        return state.getValue(this.getAgeProperty());
    }

    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return getItemLike(UbesDelightItems.LEMONGRASS);
    }

    public BlockState withAge(int age) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LEMONGRASS_AGE, SUPPORTING);
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        BlockState state = super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
        if (!state.isAir()) {
            if (facing == Direction.UP) {
                return state.setValue(SUPPORTING, isSupportingLemongrass(facingState));
            }
        }
        return state;
    }

    public boolean isSupportingLemongrass(BlockState topState) {
        return topState.getBlock() == getBlock(UbesDelightBlocks.LEMONGRASS_LEAF_CROP);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        BlockState upperState = level.getBlockState(pos.above());
        if (upperState.getBlock() instanceof LemongrassLeafCropBlock) {
            return !((LemongrassLeafCropBlock) upperState.getBlock()).isMaxAge(upperState);
        }
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    protected int getBonemealAgeIncrease(Level level) {
        return Mth.nextInt(level.random, 1, 2);
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int ageGrowth = Math.min(this.getAge(state) + this.getBonemealAgeIncrease(level), 6);
        if (ageGrowth <= this.getMaxAge()) {
            level.setBlockAndUpdate(pos, state.setValue(LEMONGRASS_AGE, ageGrowth));
        } else {
            BlockState top = level.getBlockState(pos.above());
            if (top.getBlock() == getBlock(UbesDelightBlocks.LEMONGRASS_LEAF_CROP)) {
                BonemealableBlock growable = (BonemealableBlock) level.getBlockState(pos.above()).getBlock();
                if (growable.isValidBonemealTarget(level, pos.above(), top)) {
                    growable.performBonemeal(level, level.random, pos.above(), top);
                }
            } else {
                LemongrassLeafCropBlock lemongrassLeafCropBlock = (LemongrassLeafCropBlock) getBlock(UbesDelightBlocks.LEMONGRASS_LEAF_CROP);
                int remainingGrowth = ageGrowth - this.getMaxAge() - 1;
                if (lemongrassLeafCropBlock.defaultBlockState().canSurvive(level, pos.above()) && level.isEmptyBlock(pos.above())) {
                    level.setBlockAndUpdate(pos, state.setValue(LEMONGRASS_AGE, this.getMaxAge()));
                    level.setBlock(pos.above(), lemongrassLeafCropBlock.defaultBlockState().setValue(LemongrassLeafCropBlock.lEMONGRASS_AGE, remainingGrowth), 2);
                }
            }
        }
    }
}
