package com.chefmooon.ubesdelight.common.block.leaf_feast.base;

import com.chefmooon.ubesdelight.common.block.state.properties.LeafFeastTypeProperty;
import com.chefmooon.ubesdelight.common.block.state.properties.UbesDelightBlockStateProperties;
import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.UbesDelightAdvancements;
import com.chefmooon.ubesdelight.common.registry.UbesDelightShapes;
import com.chefmooon.ubesdelight.common.registry.UbesDelightSounds;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public interface LeafFeastBlock {
    BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    LeafFeastTypeProperty LEAF_FEAST_TYPE = UbesDelightBlockStateProperties.LEAF_FEAST_TYPE;
    int MAX_SERVINGS = 6;
    IntegerProperty SERVINGS = IntegerProperty.create("servings", 1, MAX_SERVINGS);
    VoxelShape LEAF_BASE_SHAPE = UbesDelightShapes.LEAF_BASE_SHAPE;
    VoxelShape NORTH_CONNECT_SHAPE = UbesDelightShapes.NORTH_CONNECT_SHAPE;
    VoxelShape LEAF_NORTH_TIP_SHAPE = UbesDelightShapes.LEAF_NORTH_TIP_SHAPE;
    VoxelShape LEAF_NORTH_END_SHAPE = UbesDelightShapes.LEAF_NORTH_END_SHAPE;

    default boolean placementConnectsTo(Direction direction, BlockState blockState) {
        if (validBlock(blockState)) {
            return direction == blockState.getValue(LeafFeastBlock.FACING);
        }
        return false;
    }

    default boolean connectsTo(BlockState originState, BlockState state) {
        if (validBlock(state) && validBlock(originState)) {
            return state.getValue(FACING) == originState.getValue(FACING);
        }
        return false;
    }

    default boolean validBlock(BlockState state) {
        return state.getBlock() instanceof LeafFeastBlock;
    }

    default VoxelShape getConnectShape(LeafFeastTypes leafFeastType, Pair<Direction, Direction> connectDirections, VoxelShape[] connectShapes) {
        VoxelShape shape = Shapes.empty();
        if (leafFeastType.isRightConnect()) shape = Shapes.or(shape, connectShapes[connectDirections.getFirst().get2DDataValue()]);
        if (leafFeastType.isLeftConnect()) shape = Shapes.or(shape, connectShapes[connectDirections.getSecond().get2DDataValue()]);
        return shape;
    }

    default VoxelShape getBaseShape(LeafFeastTypes leafFeastType, Direction facing, VoxelShape[] tipShapes, VoxelShape[] endShapes, VoxelShape baseShape) {
        VoxelShape shape = Shapes.empty();
        if (leafFeastType.isRightConnect() && !leafFeastType.isLeftConnect()) {
            shape = Shapes.or(shape, tipShapes[facing.get2DDataValue()]);
        } else if (leafFeastType.isLeftConnect() && !leafFeastType.isRightConnect()) {
            shape = Shapes.or(shape, endShapes[facing.get2DDataValue()]);
        } else {
            shape = Shapes.or(shape, baseShape);
        }
        return shape;
    }

    default Pair<Direction, Direction> getConnectDirections(Direction facing) {
        return Pair.of(facing.getClockWise(), facing.getClockWise().getOpposite());
    }

    default BlockState getTransformState(Block block, BlockState state) {
        return block.defaultBlockState()
                .setValue(FACING, state.getValue(FACING))
                .setValue(LEAF_FEAST_TYPE, state.getValue(LEAF_FEAST_TYPE))
                .setValue(WATERLOGGED, state.getValue(WATERLOGGED));
    }

    default LeafFeastTypes getLeafFeastType(boolean leftConnect, boolean rightConnect) {
        if (rightConnect && leftConnect) {
            return LeafFeastTypes.MIDDLE; // Middle
        } else if (rightConnect) {
            return LeafFeastTypes.TIP; // Tip
        } else if (leftConnect) {
            return LeafFeastTypes.END; // End
        }
        return LeafFeastTypes.BASE; // Base State
    }

    default void playAddSound(Level level, BlockPos pos) {
        level.playSound(null, pos, UbesDelightSounds.BLOCK_LEAF_FEAST_ADD.get(), SoundSource.PLAYERS, 0.6F, 0.75F);
    }

    default void playRemoveSound(Level level, BlockPos pos) {
        level.playSound(null, pos, UbesDelightSounds.BLOCK_LEAF_FEAST_REMOVE.get(), SoundSource.PLAYERS, 0.6F, 0.8F);
    }

    static void triggerConsumeAdvancement(Player player) {
        if (player instanceof ServerPlayer) {
            UbesDelightAdvancements.USE_LEAF_FEAST_CONSUME.get().trigger((ServerPlayer) player);
        }
    }

    static void triggerInsertAdvancement(Player player) {
        if (player instanceof ServerPlayer) {
            UbesDelightAdvancements.USE_LEAF_FEAST_INSERT.get().trigger((ServerPlayer) player);
        }
    }

}
