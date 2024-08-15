package com.chefmooon.ubesdelight.common.block;

import com.chefmooon.ubesdelight.common.utility.LeafFeastUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;
import java.util.function.Supplier;

import static com.chefmooon.ubesdelight.common.utility.VoxelShapeUtil.getRotatedShapes;

public class LeafFeastSimpleUniversalBlock extends LeafFeastSimpleBlock {
//    public static final int MAX_SERVINGS = 3;
//    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 1, MAX_SERVINGS);
//    public Supplier<Item> servingItem;
    private final VoxelShape[] FEAST_SHAPE;
    private final VoxelShape[] FEAST_SHAPE_TIP;
    private final VoxelShape[] FEAST_SHAPE_END;
    private final List<VoxelShape[]> FEAST_VARIANTS;
    public LeafFeastSimpleUniversalBlock(Supplier<Item> servingItem, Properties properties, VoxelShape voxelShape) {
        this(servingItem, properties,  new VoxelShape[]{voxelShape, voxelShape, voxelShape, voxelShape});
    }

    public LeafFeastSimpleUniversalBlock(Supplier<Item> servingItem, Properties properties, VoxelShape[] voxelShapes) {
        super(servingItem,properties);
        this.FEAST_SHAPE = getRotatedShapes(voxelShapes[0]);
        this.FEAST_SHAPE_TIP = getRotatedShapes(voxelShapes[2]);
        this.FEAST_SHAPE_END = getRotatedShapes(voxelShapes[1]);
        this.FEAST_VARIANTS = List.of(FEAST_SHAPE, FEAST_SHAPE_END, FEAST_SHAPE, FEAST_SHAPE_TIP);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.or(super.getShape(state, level, pos, context), FEAST_VARIANTS.get(LeafFeastUtil.getStateByInt(state))[state.getValue(FACING).get2DDataValue()]);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }
}
