package com.chefmooon.ubesdelight.client.renderer.neoforge;

import com.chefmooon.ubesdelight.client.renderer.BakingMatBlockEntityRender;
import com.chefmooon.ubesdelight.common.block.entity.neoforge.BakingMatBlockEntityImpl;
import com.chefmooon.ubesdelight.common.block.neoforge.BakingMatBlockImpl;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class BakingMatBlockEntityRenderImpl extends BakingMatBlockEntityRender implements BlockEntityRenderer<BakingMatBlockEntityImpl> {
    public BakingMatBlockEntityRenderImpl(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(BakingMatBlockEntityImpl blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {

        Direction direction = blockEntity.getBlockState().getValue(BakingMatBlockImpl.FACING).getOpposite();
        boolean proccessing = blockEntity.getBlockState().getValue(BakingMatBlockImpl.PROCESSING);
        NonNullList<ItemStack> inventory = blockEntity.getItems();
        int posLong = (int) blockEntity.getBlockPos().asLong();

        if (!blockEntity.isEmpty()) {
            if (!proccessing) {
                for (int i = 0; i < inventory.size(); i++) {
                    ItemStack itemStack = inventory.get(i);
                    if (!itemStack.isEmpty()) {
                        renderNotProcessing(poseStack, direction, blockEntity.getItemOffset(i));

                        if (blockEntity.getLevel() != null)
                            Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, ItemDisplayContext.FIXED, LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos()), packedOverlay, poseStack, buffer, blockEntity.getLevel(), posLong + i);
                        poseStack.popPose();
                    }
                }
            } else {
                ItemStack itemStack = inventory.get(0);
                if (!itemStack.isEmpty()) {
                    renderProcessing(poseStack, direction, blockEntity.getItemOffset(0));

                    if (blockEntity.getLevel() != null)
                        Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, ItemDisplayContext.FIXED, LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos()), packedOverlay, poseStack, buffer, blockEntity.getLevel(), posLong);
                    poseStack.popPose();
                }
            }
        }
    }
}
