package com.chefmooon.ubesdelight.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec2;

public class UniversalLeafFeastBlockEntityRender {

    public void renderSingleItem(PoseStack poseStack, Direction direction, Vec2 itemOffset) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 0.08D, 0.5D);

        float f = -direction.toYRot();
        poseStack.mulPose(Axis.YP.rotationDegrees(f));

        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));

        poseStack.translate(itemOffset.x, itemOffset.y, 0.0D);

        poseStack.scale(0.3F, 0.3F, 0.3F);
    }
}
