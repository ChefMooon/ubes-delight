package chefmooon.ubesdelight.client.renderer;

import chefmooon.ubesdelight.common.block.BakingMatBlock;
import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import vectorwing.farmersdelight.refabricated.inventory.ItemStackHandler;

public class BakingMatBlockEntityRender implements BlockEntityRenderer<BakingMatBlockEntity> {
    public BakingMatBlockEntityRender(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(BakingMatBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {

        Direction direction = blockEntity.getBlockState().getValue(BakingMatBlock.FACING).getOpposite();
        boolean proccessing = blockEntity.getBlockState().getValue(BakingMatBlock.PROCESSING);
        ItemStackHandler inventory = blockEntity.getInventory();
        int posLong = (int) blockEntity.getBlockPos().asLong();

        if (!blockEntity.isEmpty()) {
            if (!proccessing) {
                for (int i = 0; i < inventory.getSlotCount(); i++) {
                    ItemStack itemStack = inventory.getStackInSlot(i);
                    if (!itemStack.isEmpty()) {
                        renderNotProcessing(poseStack, direction, blockEntity.getItemOffset(i));

                        if (blockEntity.getLevel() != null)
                            Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, ItemDisplayContext.FIXED, LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos()), packedOverlay, poseStack, buffer, blockEntity.getLevel(), posLong + i);
                        poseStack.popPose();
                    }
                }
            } else {
                ItemStack itemStack = inventory.getStackInSlot(0);
                if (!itemStack.isEmpty()) {
                    renderProcessing(poseStack, direction, blockEntity.getItemOffset(0));

                    if (blockEntity.getLevel() != null)
                        Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, ItemDisplayContext.FIXED, LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos()), packedOverlay, poseStack, buffer, blockEntity.getLevel(), posLong);
                    poseStack.popPose();
                }
            }
        }
    }

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
