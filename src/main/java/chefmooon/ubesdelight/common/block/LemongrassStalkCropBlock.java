package chefmooon.ubesdelight.common.block;

import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class LemongrassStalkCropBlock extends CropBlock {
    public static final IntegerProperty LEMONGRASS_AGE = BlockStateProperties.AGE_5;
    public static final BooleanProperty SUPPORTING = BooleanProperty.create("supporting");
    public static final int MAX_AGE = 5;
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
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(SUPPORTING) || !isMaxAge(state);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.hasChunksAt(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) return;
        if (level.getRawBrightness(pos, 0) >= 6) {
            int age = this.getAge(state);
            if (age <= this.getMaxAge()) {
                float growthSpeed = getGrowthSpeed(state.getBlock(), level, pos);
                if (random.nextInt((int) (25.0F / growthSpeed) + 1) == 0) {
                    if (age == this.getMaxAge()) {
                        LemongrassLeafCropBlock lemongrassUpper = (LemongrassLeafCropBlock) UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get();
                        if (lemongrassUpper.defaultBlockState().canSurvive(level, pos.above()) && level.isEmptyBlock(pos.above())) {
                            level.setBlockAndUpdate(pos.above(), lemongrassUpper.defaultBlockState());
                        }
                    } else {
                        level.setBlockAndUpdate(pos, this.withAge(age + 1));
                    }
                }
            }
        }
    }

    protected static float getGrowthSpeed(Block block, BlockGetter level, BlockPos pos) {
        float growthSpeed = 1.0F;
        BlockPos blockPos = pos.below();
        for(int x = -1; x <= 1; ++x) {
            for(int y = -1; y <= 1; ++y) {
                float farmlandBonus = 0.0F;
                BlockState blockStateBelow = level.getBlockState(blockPos.offset(x, 0, y));
                if (blockStateBelow.is(Blocks.FARMLAND)) {
                    farmlandBonus = 1.0F;
                    if (blockStateBelow.hasProperty(FarmBlock.MOISTURE) && blockStateBelow.getValue(FarmBlock.MOISTURE) > 0) {
                        farmlandBonus = 3.0F;
                    }
                }

                if (x != 0 || y != 0) {
                    farmlandBonus /= 4.0F;
                }

                growthSpeed += farmlandBonus;
            }
        }
        BlockPos blockPosNorth = pos.north();
        BlockPos blockPosSouth = pos.south();
        BlockPos blockPosWest = pos.west();
        BlockPos blockPosEast = pos.east();
        boolean eastWest = level.getBlockState(blockPosWest).is(block) || level.getBlockState(blockPosEast).is(block);
        boolean northSouth = level.getBlockState(blockPosNorth).is(block) || level.getBlockState(blockPosSouth).is(block);
        if (eastWest && northSouth) {
            growthSpeed /= 2.0F;
        } else {
            boolean diagonal = level.getBlockState(blockPosWest.north()).is(block) || level.getBlockState(blockPosEast.north()).is(block) || level.getBlockState(blockPosEast.south()).is(block) || level.getBlockState(blockPosWest.south()).is(block);
            if (diagonal) {
                growthSpeed /= 2.0F;
            }
        }
        return growthSpeed;
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

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return UbesDelightItems.LEMONGRASS_SEEDS.get();
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
        return topState.getBlock() == UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get();
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
        return Mth.nextInt(level.random, 1, 5);
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int ageGrowth = Math.min(this.getAge(state) + this.getBonemealAgeIncrease(level), 6);
        if (ageGrowth <= this.getMaxAge()) {
            level.setBlockAndUpdate(pos, state.setValue(LEMONGRASS_AGE, ageGrowth));
        } else {
            BlockState top = level.getBlockState(pos.above());
            if (top.getBlock() == UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get()) {
                BonemealableBlock growable = (BonemealableBlock) level.getBlockState(pos.above()).getBlock();
                if (growable.isValidBonemealTarget(level, pos.above(), top)) {
                    growable.performBonemeal(level, level.random, pos.above(), top);
                }
            } else {
                LemongrassLeafCropBlock lemongrassLeafCropBlock = (LemongrassLeafCropBlock) UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get();
                int remainingGrowth = ageGrowth - this.getMaxAge() - 1;
                if (lemongrassLeafCropBlock.defaultBlockState().canSurvive(level, pos.above()) && level.isEmptyBlock(pos.above())) {
                    level.setBlockAndUpdate(pos, state.setValue(LEMONGRASS_AGE, this.getMaxAge()));
                    level.setBlock(pos.above(), lemongrassLeafCropBlock.defaultBlockState().setValue(LemongrassLeafCropBlock.lEMONGRASS_AGE, remainingGrowth), 2);
                }
            }
        }
    }
}
