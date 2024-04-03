package com.chefmoon.ubesdelight.block;

import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class LemongrassStalkCropBlock extends PlantBlock implements Fertilizable {

    public static final IntProperty AGE = Properties.AGE_5;
    public static final BooleanProperty SUPPORTING = BooleanProperty.of("supporting");
    public static final int MAX_AGE = 5;
    public static final int GROWTH_CHANCE = 10;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
            Block.createCuboidShape(4.d, .0d, 4.d, 12.d, 4.d, 12.d),
            Block.createCuboidShape(3.d, .0d, 3.d, 13.d, 6.d, 13.d),
            Block.createCuboidShape(3.d, .0d, 3.d, 13.d, 8.d, 13.d),
            Block.createCuboidShape(2.d, .0d, 2.d, 14.d, 10.d, 14.d),
            Block.createCuboidShape(2.d, .0d, 2.d, 14.d, 12.d, 14.d),
            Block.createCuboidShape(1.d, .0d, 1.d, 15.d, 16.d, 15.d),
            Block.createCuboidShape(1.d, .0d, 1.d, 15.d, 16.d, 15.d)
    };
    public LemongrassStalkCropBlock() {
        super(FabricBlockSettings.copyOf(Blocks.WHEAT).strength(0.2F));
        setDefaultState(getStateManager().getDefaultState().with(AGE, 0).with(SUPPORTING, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(AGE, SUPPORTING);
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        BlockState superState = super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        if (!superState.isAir()) {
            if (direction == Direction.UP) {
                return superState.with(SUPPORTING, isSupportingLemongrass(neighborState));
            }
        }
        return superState;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        BlockState upperState = world.getBlockState(pos.up());
        if (upperState.getBlock() instanceof LemongrassLeafCropBlock lemongrassLeafCropBlock) {
            return !lemongrassLeafCropBlock.isMature(upperState);
        }
        return true;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_AGE[state.get(getAgeProperty())];
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return super.canPlantOnTop(floor, world, pos) || floor.isIn(CommonTags.C_FARMLAND);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ItemsRegistry.LEMONGRASS.get());
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int ageGrowth = Math.min(getAge(state) + getGrowthAmount(world), 6);
        if (ageGrowth <= MAX_AGE) {
            world.setBlockState(pos, state.with(AGE, ageGrowth));
        } else {
            BlockState top = world.getBlockState(pos.up());
            if (top.isOf(BlocksRegistry.LEMONGRASS_LEAF_CROP.get())) {
                Fertilizable growable = (Fertilizable) world.getBlockState(pos.up()).getBlock();
                if (growable.isFertilizable(world, pos.up(), top, false)) {
                    growable.grow(world, world.getRandom(), pos.up(), top);
                }
            } else {
                LemongrassLeafCropBlock lemongrassLeafCropBlock = (LemongrassLeafCropBlock) BlocksRegistry.LEMONGRASS_LEAF_CROP.get();
                int remainingGrowth = ageGrowth - MAX_AGE - 1;
                if (world.isAir(pos.up())) {
                    world.setBlockState(pos, state.with(AGE, MAX_AGE));
                    world.setBlockState(pos.up(), lemongrassLeafCropBlock.getDefaultState().with(LemongrassLeafCropBlock.AGE, remainingGrowth), 1 << 1);
                }
            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);
        if (!world.isRegionLoaded(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            return;
        }
        if (world.getLightLevel(pos.up(), 0) >= 6 && getAge(state) <= MAX_AGE && random.nextInt(3) == 0) {
            randomGrowTick(state, world, pos, random);
        }
    }

    private void randomGrowTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        int age = getAge(state);
        if (age <= MAX_AGE && rand.nextInt((int) (25.0F / GROWTH_CHANCE) + 1) == 0) {
            if (age == MAX_AGE) {
                LemongrassLeafCropBlock lemongrassLeafCropBlock = (LemongrassLeafCropBlock) BlocksRegistry.LEMONGRASS_LEAF_CROP.get();
                if (lemongrassLeafCropBlock.getDefaultState().canPlaceAt(world, pos.up()) && world.isAir(pos.up())) {
                    world.setBlockState(pos.up(), lemongrassLeafCropBlock.getDefaultState());
                }
            } else {
                world.setBlockState(pos, withAge(age + 1), 2);
            }
        }
    }

    protected int getGrowthAmount(World world) {
        return MathHelper.nextInt(world.random, 0, 2);
    }
    public boolean isSupportingLemongrass(BlockState state) {
        return state.isOf(BlocksRegistry.LEMONGRASS_LEAF_CROP.get());
    }
    protected IntProperty getAgeProperty() {
        return AGE;
    }
    public int getMaxAge() {
        return MAX_AGE;
    }

    public int getAge(BlockState state) {
        return (Integer)state.get(this.getAgeProperty());
    }
    public BlockState withAge(int age) {
        return (BlockState)this.getDefaultState().with(this.getAgeProperty(), age);
    }
}
