package com.chefmooon.ubesdelight.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.core.Direction;
import net.minecraft.world.phys.Vec2;

public class BakingMatBlockEntityRender {

    public void renderNotProcessing(PoseStack poseStack, Direction direction, Vec2 itemOffset) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 0.08D, 0.5D);

        float f = -direction.toYRot();
        poseStack.mulPose(Axis.YP.rotationDegrees(f));

        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));

        poseStack.translate(itemOffset.x, itemOffset.y, 0.0D);

        poseStack.scale(0.25F, 0.25F, 0.25F);
    }

    public void renderProcessing(PoseStack poseStack, Direction direction, Vec2 itemOffset) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 0.08D, 0.5D);

        float f = -direction.toYRot();
        poseStack.mulPose(Axis.YP.rotationDegrees(f));

        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));

        poseStack.translate(itemOffset.x, itemOffset.y, 0.0D);

        poseStack.scale(0.6F, 0.6F, 0.6F);
    }
}
