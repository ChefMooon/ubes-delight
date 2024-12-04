package com.chefmooon.ubesdelight.client.renderer.neoforge;

import com.chefmooon.ubesdelight.client.renderer.UniversalLeafFeastBlockEntityRender;
import com.chefmooon.ubesdelight.common.block.entity.neoforge.UniversalLeafFeastBlockEntityImpl;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.UniversalLeafFeastBlock;
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
import net.minecraft.world.level.block.state.BlockState;

public class UniversalLeafFeastBlockEntityRenderImpl extends UniversalLeafFeastBlockEntityRender implements BlockEntityRenderer<UniversalLeafFeastBlockEntityImpl> {
    public UniversalLeafFeastBlockEntityRenderImpl(BlockEntityRendererProvider.Context context) {
    }
    @Override
    public void render(UniversalLeafFeastBlockEntityImpl blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BlockState state = blockEntity.getBlockState();
        Direction direction = state.getValue(UniversalLeafFeastBlock.FACING);
        NonNullList<ItemStack> inventory = blockEntity.getItems();
        int posLong = (int) blockEntity.getBlockPos().asLong();

        if (!blockEntity.isEmpty()) {
            for (int i = 0; i < inventory.size(); i++) {
                ItemStack itemStack = inventory.get(i);
                if (!itemStack.isEmpty()) {
                    renderSingleItem(poseStack, direction, blockEntity.getItemOffset(i, state.getValue(UniversalLeafFeastBlock.LEAF_FEAST_TYPE)));

                    if (blockEntity.getLevel() != null)
                        Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, ItemDisplayContext.FIXED, LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos()), packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), posLong + i);
                    poseStack.popPose();
                }
            }
        }
    }
}
