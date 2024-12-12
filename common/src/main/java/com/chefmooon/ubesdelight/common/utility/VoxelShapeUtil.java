package com.chefmooon.ubesdelight.common.utility;

import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VoxelShapeUtil {

    public static ConcurrentHashMap<LeafFeastTypes, ConcurrentHashMap<Integer, VoxelShape[]>> getRotatedShapes(ConcurrentHashMap<LeafFeastTypes, ConcurrentHashMap<Integer, VoxelShape>> voxelShapes) {
        ConcurrentHashMap<LeafFeastTypes, ConcurrentHashMap<Integer, VoxelShape[]>> result = new ConcurrentHashMap<>();
        voxelShapes.forEach(((leafFeastTypes, integerVoxelShapeMap) -> {
            ConcurrentHashMap<Integer, VoxelShape[]> innerMap = result.computeIfAbsent(leafFeastTypes, k -> new ConcurrentHashMap<>());
            integerVoxelShapeMap.forEach((integer, voxelShape) -> {
                innerMap.put(integer, getRotatedShapes(voxelShape));
            });
        }));
        return result;
    }

    public static VoxelShape[] getRotatedShapes(VoxelShape shape) {
        // Assumes initial direciton is NORTH, returns in order of Direction.get2DDataValue() make one that handles an input direction?
        return new VoxelShape[]{
                rotateVoxelShape(shape, Direction.SOUTH),
                rotateVoxelShape(shape, Direction.WEST),
                shape,
                rotateVoxelShape(shape, Direction.EAST)};
    }

    public static VoxelShape rotateVoxelShape(VoxelShape shape, Direction direction) {
        // Assumes initial direciton is NORTH
        return rotateShape(shape, Direction.NORTH, direction);
    }

    public static VoxelShape[] rotateVoxelShapes(VoxelShape[] shapes, Direction direction) {
        // Assumes initial direciton is NORTH
        return rotateVoxelShapes(shapes, Direction.NORTH, direction);
    }

    public static VoxelShape[] rotateVoxelShapes(VoxelShape[] shapes, Direction from, Direction to) {
        VoxelShape[] rotatedShapes = new VoxelShape[shapes.length];
        for (int i = 0; i < shapes.length; i++) {
            rotatedShapes[i] = rotateShape(shapes[i], from, to);
        }
        return rotatedShapes;
    }

    private static VoxelShape rotateShape(VoxelShape shape, Direction from, Direction to) {
        if (from == to) {
            return shape; // No rotation needed
        }

        boolean[] isSquare = {true};
        shape.forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> {
            if (minX != minZ || maxX != maxZ) {
                isSquare[0] = false;
            }
        });
        if (isSquare[0]) {
            return shape;
        }

        int rotationDegrees = ((to.get2DDataValue() - from.get2DDataValue() + 4) % 4) * 90;
        return rotateShape(shape, rotationDegrees);
    }

    private static VoxelShape rotateShape(VoxelShape shape, int degrees) {
        VoxelShape[] buffer = {Shapes.empty()};
        shape.forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> {
            VoxelShape rotated = switch (degrees) {
                case 90 -> Shapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX);
                case 180 -> Shapes.box(1 - maxX, minY, 1 - maxZ, 1 - minX, maxY, 1 - minZ);
                case 270 -> Shapes.box(minZ, minY, 1 - maxX, maxZ, maxY, 1 - minX);
                default -> shape;
            };
            buffer[0] = Shapes.joinUnoptimized(buffer[0], rotated, BooleanOp.OR);
        });
        return buffer[0];
    }
}
