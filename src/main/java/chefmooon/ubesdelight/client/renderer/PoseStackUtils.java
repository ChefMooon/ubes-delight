package chefmooon.ubesdelight.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import org.joml.Quaternionf;

public final class PoseStackUtils {
    private PoseStackUtils() {
    }

    public static void mulPose(PoseStack poseStack, Axis axis, float degrees) {
        Quaternionf rotation = axis.rotationDegrees(degrees);
        poseStack.last().pose().rotate(rotation);
        poseStack.last().normal().rotate(rotation);
    }
}
