package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.utility.VoxelShapeUtil;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.HashMap;
import java.util.Map;

public class UbesDelightShapes {

    public static final VoxelShape CUP_NORTH_SERVINGS_1 = Shapes.or(
            Block.box(.0d, 7.d, .0d, 7.d, 8.d, 7.d),
            Block.box(1.d, .0d, 1.d, 6.d, 7.d, 6.d)
    );

    public static final VoxelShape CUP_NORTH_SERVINGS_2 = Shapes.or(
            CUP_NORTH_SERVINGS_1,
            Block.box(9.d, 7.d, .0d, 16.d, 8.d, 7.d),
            Block.box(10.d, .0d, 1.d, 15.d, 7.d, 6.d)
    );

    public static final VoxelShape CUP_NORTH_SERVINGS_3 = Shapes.or(
            CUP_NORTH_SERVINGS_2,
            Block.box(9.d, 7.d, 9.d, 16.d, 8.d, 16.d),
            Block.box(10.d, .0d, 10.d, 15.d, 7.d, 15.d)
    );

    public static final VoxelShape CUP_NORTH_SERVINGS_4 = Shapes.or(
            CUP_NORTH_SERVINGS_3,
            Block.box(.0d, 7.d, 9.d, 7.d, 8.d, 16.d),
            Block.box(1.d, .0d, 10.d, 6.d, 7.d, 15.d)
    );

    public static final VoxelShape[] CUP_SHAPES_SERVINGS_1 = new VoxelShape[] {
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_1, Direction.SOUTH),
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_1, Direction.WEST),
            CUP_NORTH_SERVINGS_1,
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_1, Direction.EAST)
    };

    public static final VoxelShape[] CUP_SHAPES_SERVINGS_2 = new VoxelShape[] {
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_2, Direction.SOUTH),
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_2, Direction.WEST),
            CUP_NORTH_SERVINGS_2,
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_2, Direction.EAST)
    };

    public static final VoxelShape[] CUP_SHAPES_SERVINGS_3 = new VoxelShape[] {
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_3, Direction.SOUTH),
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_3, Direction.WEST),
            CUP_NORTH_SERVINGS_3,
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_3, Direction.EAST)
    };

    public static final VoxelShape[] CUP_SHAPES_SERVINGS_4 = new VoxelShape[] {
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_4, Direction.SOUTH),
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_4, Direction.WEST),
            CUP_NORTH_SERVINGS_4,
            VoxelShapeUtil.rotateVoxelShape(CUP_NORTH_SERVINGS_4, Direction.EAST)
    };


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


    public static final VoxelShape RICE_SHAPE = Shapes.or(
            Block.box(7,4,7,9,5,9),
            Block.box(6,3,6,10,4,10),
            Block.box(5,1,5,11,3,11)
    );

    public static final VoxelShape ENSAYMADA_BASE_SERVING_1 = Shapes.or(
            Block.box(1, 1, 2, 5, 4, 6),
            Block.box(2, 4, 3, 4, 5, 5)
    );
    public static final VoxelShape ENSAYMADA_BASE_SERVING_2 = Shapes.or(
            ENSAYMADA_BASE_SERVING_1,
            Shapes.or(
                    Block.box(6, 1, 10, 10, 4, 14),
                    Block.box(7, 4, 11, 9, 5, 13))
    );
    public static final VoxelShape ENSAYMADA_BASE_SERVING_3 = Shapes.or(
            ENSAYMADA_BASE_SERVING_2,
            Shapes.or(
                    Block.box(11, 1, 2, 15, 4, 6),
                    Block.box(12, 4, 3, 14, 5, 5))
    );
    public static final VoxelShape ENSAYMADA_BASE_SERVING_4 = Shapes.or(
            ENSAYMADA_BASE_SERVING_3,
            Shapes.or(
                    Block.box(1, 1, 10, 5, 4, 14),
                    Block.box(2, 4, 11, 4, 5, 13))
    );
    public static final VoxelShape ENSAYMADA_BASE_SERVING_5 = Shapes.or(
            ENSAYMADA_BASE_SERVING_4,
            Shapes.or(
                    Block.box(6, 1, 2, 10, 4, 6),
                    Block.box(7, 4, 3, 9, 5, 5))
    );
    public static final VoxelShape ENSAYMADA_BASE_SERVING_6 = Shapes.or(
            ENSAYMADA_BASE_SERVING_5,
            Shapes.or(
                    Block.box(11, 1, 10, 15, 4, 14),
                    Block.box(12, 4, 11, 14, 5, 13))
    );

    public static final VoxelShape ENSAYMADA_END_SERVING_1 = Shapes.or(
            Block.box(1, 1, 9, 5, 4, 13),
            Block.box(2, 4, 10, 4, 5, 12)
    );
    public static final VoxelShape ENSAYMADA_END_SERVING_2 = Shapes.or(
            ENSAYMADA_END_SERVING_1,
            Shapes.or(
                    Block.box(2, 1, 3, 6, 4, 7),
                    Block.box(3, 4, 4, 5, 5, 6))
    );
    public static final VoxelShape ENSAYMADA_END_SERVING_3 = Shapes.or(
            ENSAYMADA_END_SERVING_2,
            Shapes.or(
                    Block.box(7, 1, 6, 11, 4, 10),
                    Block.box(8, 4, 7, 10, 5, 9))
    );

    public static final VoxelShape ENSAYMADA_TIP_SERVING_1 = Shapes.or(
            Block.box(11, 1, 3, 15, 4, 7),
            Block.box(12, 4, 4, 14, 5, 6)
    );
    public static final VoxelShape ENSAYMADA_TIP_SERVING_2 = Shapes.or(
            ENSAYMADA_TIP_SERVING_1,
            Shapes.or(
                    Block.box(10, 1, 9, 14, 4, 13),
                    Block.box(11, 4, 10, 13, 5, 12))
    );
    public static final VoxelShape ENSAYMADA_TIP_SERVING_3 = Shapes.or(
            ENSAYMADA_TIP_SERVING_2,
            Shapes.or(
                    Block.box(5, 1, 6, 9, 4, 10),
                    Block.box(6, 4, 7, 8, 5, 9))
    );


    public static final VoxelShape PANDESAL_BASE_SERVING_1 = Block.box(1, 1, 2, 5, 5, 6);
    public static final VoxelShape PANDESAL_BASE_SERVING_2 = Shapes.or(
            PANDESAL_BASE_SERVING_1,
            Block.box(6, 1, 10, 10, 5, 14)
    );
    public static final VoxelShape PANDESAL_BASE_SERVING_3 = Shapes.or(
            PANDESAL_BASE_SERVING_2,
            Block.box(11, 1, 2, 15, 5, 6)
    );
    public static final VoxelShape PANDESAL_BASE_SERVING_4 = Shapes.or(
            PANDESAL_BASE_SERVING_3,
            Block.box(1, 1, 10, 5, 5, 14)
    );
    public static final VoxelShape PANDESAL_BASE_SERVING_5 = Shapes.or(
            PANDESAL_BASE_SERVING_4,
            Block.box(6, 1, 2, 10, 5, 6)
    );
    public static final VoxelShape PANDESAL_BASE_SERVING_6 = Shapes.or(
            PANDESAL_BASE_SERVING_5,
            Block.box(11, 1, 10, 15, 5, 14)
    );

    public static final VoxelShape PANDESAL_END_SERVING_1 = Block.box(1, 1, 9, 5, 5, 13);
    public static final VoxelShape PANDESAL_END_SERVING_2 = Shapes.or(
            PANDESAL_END_SERVING_1,
            Block.box(2, 1, 3, 6, 5, 7)
    );
    public static final VoxelShape PANDESAL_END_SERVING_3 = Shapes.or(
            PANDESAL_END_SERVING_2,
            Block.box(7, 1, 6, 11, 5, 10)
    );

    public static final VoxelShape PANDESAL_TIP_SERVING_1 = Block.box(11, 1, 3, 15, 5, 7);
    public static final VoxelShape PANDESAL_TIP_SERVING_2 = Shapes.or(
            PANDESAL_TIP_SERVING_1,
            Block.box(10, 1, 9, 14, 5, 13)
    );
    public static final VoxelShape PANDESAL_TIP_SERVING_3 = Shapes.or(
            PANDESAL_TIP_SERVING_2,
            Block.box(5, 1, 6, 9, 5, 10)
    );

    public static final VoxelShape HOPIA_BASE_SERVING_1 = Block.box(1, 1, 2, 5, 4, 6);
    public static final VoxelShape HOPIA_BASE_SERVING_2 = Shapes.or(
            HOPIA_BASE_SERVING_1,
            Block.box(6, 1, 10, 10, 4, 14)
    );
    public static final VoxelShape HOPIA_BASE_SERVING_3 = Shapes.or(
            HOPIA_BASE_SERVING_2,
            Block.box(11, 1, 2, 15, 4, 6)
    );
    public static final VoxelShape HOPIA_BASE_SERVING_4 = Shapes.or(
            HOPIA_BASE_SERVING_3,
            Block.box(1, 1, 10, 5, 4, 14)
    );
    public static final VoxelShape HOPIA_BASE_SERVING_5 = Shapes.or(
            HOPIA_BASE_SERVING_4,
            Block.box(6, 1, 2, 10, 4, 6)
    );
    public static final VoxelShape HOPIA_BASE_SERVING_6 = Shapes.or(
            HOPIA_BASE_SERVING_5,
            Block.box(11, 1, 10, 15, 4, 14)
    );

    public static final VoxelShape HOPIA_END_SERVING_1 = Block.box(1, 1, 9, 5, 4, 13);
    public static final VoxelShape HOPIA_END_SERVING_2 = Shapes.or(
            HOPIA_END_SERVING_1,
            Block.box(2, 1, 3, 6, 4, 7)
    );
    public static final VoxelShape HOPIA_END_SERVING_3 = Shapes.or(
            HOPIA_END_SERVING_2,
            Block.box(7, 1, 6, 11, 4, 10)
    );

    public static final VoxelShape HOPIA_TIP_SERVING_1 = Block.box(11, 1, 3, 15, 4, 7);
    public static final VoxelShape HOPIA_TIP_SERVING_2 = Shapes.or(
            HOPIA_TIP_SERVING_1,
            Block.box(10, 1, 9, 14, 4, 13)
    );
    public static final VoxelShape HOPIA_TIP_SERVING_3 = Shapes.or(
            HOPIA_TIP_SERVING_2,
            Block.box(5, 1, 6, 9, 4, 10)
    );

    public static final VoxelShape[] LUMPIA_SERVINGS = new VoxelShape[] {
            Block.box(2,1,2,14,5,6),
            Block.box(2,1,6,14,5,10),
            Block.box(2,1,10,14,5,14),
            Block.box(2,5,2,14,9,6),
            Block.box(2,5,6,14,9,10),
            Block.box(2,5,10,14,9,14),
    };
    public static final VoxelShape LUMPIA_SERVING_1_OF_3 = Shapes.join(LUMPIA_SERVINGS[0], LUMPIA_SERVINGS[1], BooleanOp.OR);
    public static final VoxelShape LUMPIA_SERVING_2_OF_3 = Shapes.or(LUMPIA_SERVING_1_OF_3, LUMPIA_SERVINGS[2], LUMPIA_SERVINGS[3]);
    public static final VoxelShape LUMPIA_SERVING_3_OF_3 = Shapes.or(LUMPIA_SERVING_2_OF_3, LUMPIA_SERVINGS[4], LUMPIA_SERVINGS[5]);

}
