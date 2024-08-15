package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.utility.VoxelShapeUtil;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class UbesDelightShapes {
    public static final VoxelShape LEAF_BASE_SHAPE = Block.box(1,0,1,15,1,15);
    public static final VoxelShape NORTH_CONNECT_SHAPE = Block.box(1,0, 0,15,1,1);
    public static final VoxelShape LEAF_NORTH_TIP_SHAPE = Shapes.or(
            Block.box(1,0,1,5,1,15),
            Block.box(5,0,2,8,1,14),
            Block.box(8,0,3,11,1,13),
            Block.box(11,0,4,13,1,12),
            Block.box(13,0,5,14,1,11),
            Block.box(14,0,6,15,1,10)
    );

    public static final VoxelShape LEAF_NORTH_END_SHAPE = Shapes.or(
            Block.box(12,0,1,15,1,15),
            Block.box(8,0,2,12,1,14),
            Block.box(6,0,3,8,1,13),
            Block.box(5,0,4,6,1,12),
            Block.box(4,0,5,5,1,11),
            Block.box(3,0,6,4,1,10),
            Block.box(2,0,7,3,1,9),
            Block.box(1,0,7,2,1,8)
    );

    public static final VoxelShape BREAD_SHAPE = Shapes.or(
            Shapes.or(Block.box(2,1,2,6,4,6), Block.box(3,4,3,5,5,5)),
            Shapes.or(Block.box(6,1,10,10,4,14), Block.box(7,4,11,9,5,13)),
            Shapes.or(Block.box(10,1,2,14,4,6), Block.box(11,4,3,13,5,5)));
    public static final VoxelShape BREAD_SHAPE_END = Shapes.or(
            Shapes.or(Block.box(1,1,9,5,4,13), Block.box(2,4,10,4,5,12)),
            Shapes.or(Block.box(3,1,3,7,4,7), Block.box(4,4,4,6,5,6)),
            Shapes.or(Block.box(6,1,8,10,4,12), Block.box(7,4,9,9,5,11))
    );
    public static final VoxelShape BREAD_SHAPE_TIP = Shapes.or(
            Shapes.or(Block.box(6,1,8,10,4,12), Block.box(7,4,9,9,5,11)),
            Shapes.or(Block.box(9,1,3,13,4,7), Block.box(10,4,4,12,5,6)),
            Shapes.or(Block.box(11,1,9,15,4,13), Block.box(12,4,10,14,5,12))
    );

    public static final VoxelShape RICE_SHAPE = Shapes.or(
            Block.box(7,4,7,9,5,9),
            Block.box(6,3,6,10,4,10),
            Block.box(5,1,5,11,3,11)
    );
}
