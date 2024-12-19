package com.chefmooon.ubesdelight.common.block.entity;

import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import net.minecraft.world.phys.Vec2;

public class UniversalLeafFeastBlockEntity {
    public static final int MAX_ITEMS = 6;

    public static Vec2 getItemOffset(int index, LeafFeastTypes leafFeastType) {
        if (leafFeastType == LeafFeastTypes.BASE || leafFeastType == LeafFeastTypes.MIDDLE) {
            final float xOffset = .3f;
            final float yOffset = .25f;
            final Vec2[] offsets = {
                    new Vec2(xOffset, yOffset),   // Top-right
                    new Vec2(0.0f, -yOffset),  // Bottom-center
                    new Vec2(-xOffset, yOffset),  // Top-left
                    new Vec2(xOffset, -yOffset),  // Bottom-right
                    new Vec2(0.0f, yOffset),   // Top-center
                    new Vec2(-xOffset, -yOffset)  // Bottom-left
            };
            return offsets[index];
        } else if (leafFeastType == LeafFeastTypes.TIP && index < 3) {
            Vec2[] offsets = {
                    new Vec2(-0.33f, 0.2f),
                    new Vec2(-0.27f, -0.2f),
                    new Vec2(0.05f, 0.0f)
            };
            return offsets[index];
        } else if (leafFeastType == LeafFeastTypes.END && index < 3) {
            Vec2[] offsets = {
                    new Vec2(0.33f, -0.2f),
                    new Vec2(0.27f, 0.2f),
                    new Vec2(-0.05f, 0.0f)
            };
            return offsets[index];
        }
        return  new Vec2(0.0f, 0.0f);
    }
}
