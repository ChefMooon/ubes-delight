package chefmooon.ubesdelight.common.block;

import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class LemongrassLeafCropBlock extends CropBlock {
    public static final IntegerProperty lEMONGRASS_AGE = BlockStateProperties.AGE_3;
    public static final int MAX_AGE = 3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(1.d, .0d, 1.d, 15.d, 4.d, 15.d),
            Block.box(1.d, .0d, 1.d, 15.d, 8.d, 15.d),
            Block.box(1.d, .0d, 1.d, 15.d, 10.d, 15.d),
            Block.box(1.d, .0d, 1.d, 15.d, 14.d, 15.d)
    };
    public LemongrassLeafCropBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !isMaxAge(state);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.hasChunksAt(pos.offset(-1, -1, -1), pos.offset(1, 1, 1))) return;
        if (level.getRawBrightness(pos, 0) >= 6) {
            int age = this.getAge(state);
            if (age <= this.getMaxAge()) {
                float growthSpeed = getGrowthSpeed(level.getBlockState(pos.below()).getBlock(), level, pos.below());
                if (random.nextInt((int) (25.0F / growthSpeed) + 1) == 0) { // check the chance
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

    // TODO: test lemongrass growth, then remove
//    protected static float getGrowthSpeed(Block block, BlockGetter level, BlockPos pos) {
//        float growthSpeed = 1.0F;
//        BlockPos blockPos = pos.below();
//        for(int x = -1; x <= 1; ++x) {
//            for(int y = -1; y <= 1; ++y) {
//                float farmlandBonus = 0.0F;
//                BlockState blockStateBelow = level.getBlockState(blockPos.offset(x, 0, y));
//                if (blockStateBelow.is(Blocks.FARMLAND)) {
//                    farmlandBonus = 1.0F;
//                    if (blockStateBelow.hasProperty(FarmBlock.MOISTURE) && blockStateBelow.getValue(FarmBlock.MOISTURE) > 0) {
//                        farmlandBonus = 3.0F;
//                    }
//                }
//
//                if (x != 0 || y != 0) {
//                    farmlandBonus /= 4.0F;
//                }
//
//                growthSpeed += farmlandBonus;
//            }
//        }
//        BlockPos blockPosNorth = pos.north();
//        BlockPos blockPosSouth = pos.south();
//        BlockPos blockPosWest = pos.west();
//        BlockPos blockPosEast = pos.east();
//        boolean eastWest = level.getBlockState(blockPosWest).is(block) || level.getBlockState(blockPosEast).is(block);
//        boolean northSouth = level.getBlockState(blockPosNorth).is(block) || level.getBlockState(blockPosSouth).is(block);
//        if (eastWest && northSouth) {
//            growthSpeed /= 2.0F;
//        } else {
//            boolean diagonal = level.getBlockState(blockPosWest.north()).is(block) || level.getBlockState(blockPosEast.north()).is(block) || level.getBlockState(blockPosEast.south()).is(block) || level.getBlockState(blockPosWest.south()).is(block);
//            if (diagonal) {
//                growthSpeed /= 2.0F;
//            }
//        }
//        return growthSpeed;
//    }

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

    public BlockState withAge(int age) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return UbesDelightItems.LEMONGRASS.get();
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
        return state.is(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState blockStateBelow = level.getBlockState(pos.below());
        if (blockStateBelow.getBlock() instanceof LemongrassStalkCropBlock lemongrassStalkCropBlock) {
            return lemongrassStalkCropBlock.isMaxAge(blockStateBelow) && (level.getRawBrightness(pos, 0) >= 6 || level.canSeeSky(pos));
        }
        return super.canSurvive(state, level, pos);
    }
}
