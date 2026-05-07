package chefmooon.ubesdelight.client.renderer;

import chefmooon.ubesdelight.common.block.entity.UniversalLeafFeastBlockEntity;
import chefmooon.ubesdelight.common.block.leaf_feast.base.UniversalLeafFeastBlock;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
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
import net.minecraft.world.phys.Vec2;

public class UniversalLeafFeastBlockEntityRender implements BlockEntityRenderer<UniversalLeafFeastBlockEntity> {
    public UniversalLeafFeastBlockEntityRender(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(UniversalLeafFeastBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
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
