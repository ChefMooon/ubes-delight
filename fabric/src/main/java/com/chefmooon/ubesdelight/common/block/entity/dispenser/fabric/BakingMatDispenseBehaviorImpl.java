package com.chefmooon.ubesdelight.common.block.entity.dispenser.fabric;

import com.chefmooon.ubesdelight.common.block.BakingMatBlock;
import com.chefmooon.ubesdelight.common.block.entity.dispenser.BakingMatDispenseBehavior;
import com.chefmooon.ubesdelight.common.block.entity.fabric.BakingMatBlockEntityImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BakingMatDispenseBehaviorImpl {

    public static boolean tryRollingPinBakingMat(ServerLevel level, ItemStack item, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof BakingMatBlockEntityImpl bakingMatBlockEntity) {
            if (!bakingMatBlockEntity.isEmpty() || state.getValue(BakingMatBlock.PROCESSING)) {
                if (bakingMatBlockEntity.processItemUsingTool(item, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void register() {
        DispenserBlock.registerBehavior(UbesDelightItemsImpl.ROLLING_PIN_WOOD, new BakingMatDispenseBehavior());
    }
}
