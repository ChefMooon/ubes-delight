package com.chefmooon.ubesdelight.common.block.entity.dispenser;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;

@MethodsReturnNonnullByDefault
public class BakingMatDispenseBehavior extends OptionalDispenseItemBehavior {
    public BakingMatDispenseBehavior() {
    }

    protected ItemStack execute(BlockSource source, ItemStack stack) {
        ServerLevel serverLevel = source.level();
        if (!serverLevel.isClientSide()) {
            BlockPos blockPos = source.pos().relative((Direction)source.state().getValue(DispenserBlock.FACING));
            this.setSuccess(tryRollingPinBakingMat(serverLevel, stack, blockPos));
            if (this.isSuccess()) {
                playSound(source);
            }
        }
        return stack;
    }

    @ExpectPlatform
    public static boolean tryRollingPinBakingMat(ServerLevel level, ItemStack item, BlockPos pos) {
        throw new AssertionError();
    }
}
