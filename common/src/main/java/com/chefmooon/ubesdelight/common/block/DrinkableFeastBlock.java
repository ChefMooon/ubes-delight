package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.registry.UbesDelightSounds;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class DrinkableFeastBlock extends Block {
    public static final int MAX_SERVINGS = 4;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, MAX_SERVINGS);
    protected static final VoxelShape SHAPE = Block.box(1.d, .0d, 1.d, 15.d, 8.d, 15.d);
    public Supplier<Item> servingItem;
    private final ParticleOptions particleData;

    public DrinkableFeastBlock(Supplier<Item> servingItem) {
        this(servingItem, BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0f).sound(SoundType.GLASS));
    }

    public DrinkableFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(properties);
        this.servingItem = servingItem;
        this.particleData = null;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SERVINGS, MAX_SERVINGS));
    }

    public DrinkableFeastBlock(Supplier<Item> servingItem, ParticleOptions particleData) {
        super(BlockBehaviour.Properties.copy(Blocks.GLASS));
        this.servingItem = servingItem;
        this.particleData = particleData;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SERVINGS, MAX_SERVINGS));
    }

    public IntegerProperty getServingsProperty() {
        return SERVINGS;
    }

    public int getMaxServings() {
        return MAX_SERVINGS;
    }

    public ItemStack getServingItem(BlockState state) {
        return new ItemStack(this.servingItem.get());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, SERVINGS);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack serving = getServingItem(state);
        ItemStack heldItem = player.getItemInHand(hand);

        if (level.isClientSide()) {
            if (heldItem.is(serving.getItem())) {
                if (addDrink(level, pos, state, player, hand).consumesAction()) {
                    return InteractionResult.SUCCESS;
                }
            } else {
                if (dispenseDrink(level, pos, state, player, hand).consumesAction()) {
                    return InteractionResult.SUCCESS;
                }
            }
        }

        if (heldItem.is(serving.getItem())) {
            return addDrink(level, pos, state, player, hand);
        } else {
            return dispenseDrink(level, pos, state, player, hand);
        }
    }

    protected InteractionResult dispenseDrink(Level world, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getServingsProperty());

        if (servings == 0) {
            return InteractionResult.FAIL;
        }

        if (servings > 0 ) {
            ItemStack serving = getServingItem(state);
            ItemStack heldItem = player.getItemInHand(hand);
            if (heldItem.is(Items.GLASS_BOTTLE)) {
                world.setBlock(pos, state.setValue(getServingsProperty(), servings - 1), 3);
                world.playSound(null, pos, UbesDelightSounds.BLOCK_DRINKABLE_FEAST_REMOVE.get(), SoundSource.PLAYERS, 0.8F, 0.8F);
                if (!player.isCreative()) {
                    heldItem.shrink(1);
                    if (!player.getInventory().add(serving)) {
                        player.drop(serving, false);
                    }
                }
            } else {
                player.displayClientMessage(TextUtils.getTranslatable("container.punch_bowl"), true);

            }
        }

        return InteractionResult.SUCCESS;
    }

    protected InteractionResult addDrink(Level world, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getServingsProperty());

        if (servings < MAX_SERVINGS) {
            ItemStack heldItem = player.getItemInHand(hand);
            ItemStack container = new ItemStack(Items.GLASS_BOTTLE);
            world.setBlock(pos, state.setValue(getServingsProperty(), servings + 1), 3);
            // TODO: make an add sound
            world.playSound(null, pos, UbesDelightSounds.BLOCK_DRINKABLE_FEAST_ADD.get(), SoundSource.PLAYERS, 0.8F, 0.8F);
            if (!player.isCreative()) {
                heldItem.shrink(1);
                if (!player.getInventory().add(container)) {
                    player.drop(container, false);
                }
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }

    // todo - decide if punchbowls have particles?
    //@Override
    //public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
    //    //BlockEntity tileEntity = level.getBlockEntity(pos); // Needed?
    //    if (particleData != null && state.getValue(getServingsProperty()) > 0) {
    //        double d = (double)pos.getX() + 0.5D;
    //        double e = (double)pos.getY() + (state.getValue(getServingsProperty()) / 6.0);
    //        double f = (double)pos.getZ() + 0.5D;
    //        for(int i = 0; i < 1; ++i) {
    //            if (random.nextBoolean()) {
    //                level.addParticle(particleData, d + (random.nextDouble() - 0.5) / 2.0, e + ((1.0 - random.nextDouble()) / 20.0), f + (random.nextDouble() - 0.5) / 2.0, 0.0, 0.0, 0.0);
    //                if (new java.util.Random().nextInt(10) == 0) {
    //                    level.playSound(null, pos, UbesDelightSounds.BLOCK_DRINKABLE_FEAST_BUBBLE.get(), SoundSource.BLOCKS, 0.2F, 0.8F);
    //                }
    //            }
    //        }
    //    }
    //}

    @Override
    public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
        return getOutputSignal((Integer)state.getValue(SERVINGS));
    }

    public static int getOutputSignal(int servings) {
        return servings * 2;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
