package chefmooon.ubesdelight.client.renderer;

import chefmooon.ubesdelight.client.renderer.state.BakingMatRenderState;
import chefmooon.ubesdelight.common.block.BakingMatBlock;
import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.refabricated.inventory.ItemStackHandler;

public class BakingMatBlockEntityRender implements BlockEntityRenderer<BakingMatBlockEntity, BakingMatRenderState> {
    private final ItemModelResolver itemModelResolver;
    public BakingMatBlockEntityRender(BlockEntityRendererProvider.Context context) {
        itemModelResolver = context.itemModelResolver();
    }

    @Override
    public void extractRenderState(BakingMatBlockEntity blockEntity, BakingMatRenderState renderState, float partialTick, Vec3 cameraPosition, @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, renderState, partialTick, cameraPosition, breakProgress);
        renderState.direction = blockEntity.getBlockState().getValue(BakingMatBlock.FACING).getOpposite();
        renderState.processing = blockEntity.getBlockState().getValue(BakingMatBlock.PROCESSING);
        int posLong = (int) blockEntity.getBlockPos().asLong();

        ItemStackHandler inventory = blockEntity.getInventory();
        renderState.stacks = new ItemStackRenderState[inventory.getSlotCount()];
        for (int i = 0; i < inventory.getSlotCount(); i++) {
            ItemStack itemStack = inventory.getStackInSlot(i);
            if (!itemStack.isEmpty()) {
                renderState.stacks[i] = new ItemStackRenderState();
                this.itemModelResolver.updateForTopItem(renderState.stacks[i], itemStack, ItemDisplayContext.FIXED, blockEntity.getLevel(), null, posLong + i);
            }
        }
    }

    @Override
    public BakingMatRenderState createRenderState() {
        return new BakingMatRenderState();
    }

    @Override
    public void submit(BakingMatRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
        Direction direction = renderState.direction;
        boolean processing = renderState.processing;

        if (!processing) {
            for (int i = 0; i < renderState.stacks.length; i++) {
                ItemStackRenderState itemStackRenderState = renderState.stacks[i];
                if (itemStackRenderState != null) {
                    renderNotProcessing(poseStack, direction, BakingMatBlockEntity.getItemOffset(i));

                    renderState.stacks[i].submit(poseStack, nodeCollector, renderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
                    poseStack.popPose();
                }
            }
        } else {
            ItemStackRenderState itemStackRenderState = renderState.stacks[0];
            if (itemStackRenderState != null) {
                renderProcessing(poseStack, direction, BakingMatBlockEntity.getItemOffset(0));

                renderState.stacks[0].submit(poseStack, nodeCollector, renderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
                poseStack.popPose();
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
