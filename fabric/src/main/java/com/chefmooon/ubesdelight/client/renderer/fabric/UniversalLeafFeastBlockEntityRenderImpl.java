package com.chefmooon.ubesdelight.client.renderer.fabric;

import com.chefmooon.ubesdelight.client.renderer.UniversalLeafFeastBlockEntityRender;
import com.chefmooon.ubesdelight.common.block.entity.fabric.UniversalLeafFeastBlockEntityImpl;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.UniversalLeafFeastBlock;
import com.mojang.blaze3d.vertex.PoseStack;
import io.github.fabricators_of_create.porting_lib.transfer.item.ItemStackHandlerContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

// TODO: portinglib found here
public class UniversalLeafFeastBlockEntityRenderImpl extends UniversalLeafFeastBlockEntityRender implements BlockEntityRenderer<UniversalLeafFeastBlockEntityImpl> {
    public UniversalLeafFeastBlockEntityRenderImpl(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(UniversalLeafFeastBlockEntityImpl blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BlockState state = blockEntity.getBlockState();
        Direction direction = state.getValue(UniversalLeafFeastBlock.FACING);
        ItemStackHandlerContainer inventory = blockEntity.getInventory();
        int posLong = (int) blockEntity.getBlockPos().asLong();

        if (!blockEntity.isEmpty()) {
            for (int i = 0; i < inventory.getSlotCount(); i++) {
                ItemStack itemStack = inventory.getStackInSlot(i);
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
