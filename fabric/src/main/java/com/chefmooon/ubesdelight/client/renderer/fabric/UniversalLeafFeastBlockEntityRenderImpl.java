package com.chefmooon.ubesdelight.client.renderer.fabric;

import com.chefmooon.ubesdelight.client.renderer.UniversalLeafFeastBlockEntityRender;
import com.chefmooon.ubesdelight.client.renderer.state.UniversalLeafFeastRenderState;
import com.chefmooon.ubesdelight.common.block.entity.fabric.UniversalLeafFeastBlockEntityImpl;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.UniversalLeafFeastBlock;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.refabricated.inventory.ItemStackHandler;

public class UniversalLeafFeastBlockEntityRenderImpl extends UniversalLeafFeastBlockEntityRender implements BlockEntityRenderer<UniversalLeafFeastBlockEntityImpl, UniversalLeafFeastRenderState> {
    private final ItemModelResolver itemModelResolver;
    public UniversalLeafFeastBlockEntityRenderImpl(BlockEntityRendererProvider.Context context) {
        itemModelResolver = context.itemModelResolver();
    }

    @Override
    public void extractRenderState(UniversalLeafFeastBlockEntityImpl blockEntity, UniversalLeafFeastRenderState renderState, float partialTick, Vec3 cameraPosition, @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, renderState, partialTick, cameraPosition, breakProgress);
        renderState.direction = blockEntity.getBlockState().getValue(UniversalLeafFeastBlock.FACING);
        renderState.leafFeastType = blockEntity.getBlockState().getValue(UniversalLeafFeastBlock.LEAF_FEAST_TYPE);
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
    public UniversalLeafFeastRenderState createRenderState() {
        return new UniversalLeafFeastRenderState();
    }

    @Override
    public void submit(UniversalLeafFeastRenderState renderState, PoseStack poseStack, SubmitNodeCollector nodeCollector, CameraRenderState cameraRenderState) {
        Direction direction = renderState.direction;

        for (int i = 0; i< renderState.stacks.length; i++) {
            ItemStackRenderState itemStackRenderState = renderState.stacks[i];
            if (itemStackRenderState != null) {
                renderSingleItem(poseStack, direction, UniversalLeafFeastBlockEntityImpl.getItemOffset(i, renderState.leafFeastType));

                renderState.stacks[i].submit(poseStack, nodeCollector, renderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);

                poseStack.popPose();
            }
        }
    }
}
