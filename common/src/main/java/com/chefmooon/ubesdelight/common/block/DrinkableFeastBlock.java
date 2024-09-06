package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.registry.UbesDelightSounds;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
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
        this(servingItem, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0f).sound(SoundType.GLASS));
    }

    public DrinkableFeastBlock(Supplier<Item> servingItem, Properties properties) {
        super(properties);
        this.servingItem = servingItem;
        this.particleData = null;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SERVINGS, MAX_SERVINGS));
    }

    public DrinkableFeastBlock(Supplier<Item> servingItem, ParticleOptions particleData) {
        super(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
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
    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack serving = getServingItem(state);
        ItemStack heldItem = player.getItemInHand(hand);

        if (heldItem.is(serving.getItem())) {
            return addDrink(level, pos, state, player, hand);
        } else {
            return dispenseDrink(level, pos, state, player, hand);
        }
    }

    protected ItemInteractionResult dispenseDrink(Level world, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getServingsProperty());

        if (servings == 0) {
            return ItemInteractionResult.FAIL;
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

        return ItemInteractionResult.SUCCESS;
    }

    protected ItemInteractionResult addDrink(Level world, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
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
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.FAIL;
    }

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
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}
