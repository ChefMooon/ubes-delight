package com.chefmooon.ubesdelight.common.block.entity;

import net.minecraft.world.phys.Vec2;

public class BakingMatBlockEntity {

    public static final int MAX_INGREDIENTS = 9;
    public static final int MAX_PROCESSING_STAGES = 5;
    public static final int MAX_RESULTS = 4;

    public static Vec2 getItemOffset(int index) {
        final float xOffset = .25f;
        final float yOffset = .25f;
        final Vec2[] offsets = {
                new Vec2(.0f, .0f), new Vec2(xOffset, .0f), new Vec2(-xOffset, .0f),
                new Vec2(.0f, yOffset), new Vec2(.0f, -yOffset), new Vec2(xOffset, yOffset),
                new Vec2(-xOffset, yOffset), new Vec2(xOffset, -yOffset), new Vec2(-xOffset, -yOffset)
        };

        return offsets[index];
    }
}
