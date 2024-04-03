package com.chefmoon.ubesdelight.block.entity.client;

import com.chefmoon.ubesdelight.block.BakingMatBlock;
import com.chefmoon.ubesdelight.block.entity.BakingMatBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class BakingMatBlockEntityRender implements BlockEntityRenderer<BakingMatBlockEntity> {
    public BakingMatBlockEntityRender(BlockEntityRendererFactory.Context context) {

    }
    @Override
    public void render(BakingMatBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        Direction direction = entity.getCachedState().get(BakingMatBlock.FACING).getOpposite();
        Boolean processing = entity.getCachedState().get(BakingMatBlock.PROCESSING);
        World world = MinecraftClient.getInstance().world;
        DefaultedList<ItemStack> inventory = entity.getItems();

        if (!entity.isEmpty()) {
            if (!processing) {
                for (int i = 0; i < inventory.size(); i++) {
                    ItemStack itemStack = inventory.get(i);
                    if (!itemStack.isEmpty()) {
                        matrices.push();
                        matrices.translate(.5f, .08f, .5f);

                        float angle = -direction.asRotation();
                        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(angle));
                        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.f));

                        Vec2f itemOffset = entity.getItemOffset(i);
                        matrices.translate(itemOffset.x, itemOffset.y, .0d);
                        matrices.scale(0.25f, 0.25f, 0.25f);

                        if (entity.getWorld() != null) {
                            itemRenderer.renderItem(itemStack, ModelTransformationMode.FIXED, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, world, 1);
                        }
                        matrices.pop();
                    }
                }
            } else {
                if (!inventory.get(0).isEmpty()) {
                    ItemStack itemStack = inventory.get(0);
                    if (!itemStack.isEmpty()) {
                        matrices.push();
                        matrices.translate(.5f, .08f, .5f);

                        float angle = -direction.asRotation();
                        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(angle));
                        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.f));

                        Vec2f itemOffset = entity.getItemOffset(0);
                        matrices.translate(itemOffset.x, itemOffset.y, .0d);
                        matrices.scale(0.6f, 0.6f, 0.6f);

                        if (entity.getWorld() != null) {
                            itemRenderer.renderItem(itemStack, ModelTransformationMode.FIXED, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, world, 1);
                        }
                        matrices.pop();
                    }
                }
            }

        }
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
