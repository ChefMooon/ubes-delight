package chefmooon.ubesdelight.common.block.entity.dispenser;

import chefmooon.ubesdelight.common.block.BakingMatBlock;
import chefmooon.ubesdelight.common.block.entity.BakingMatBlockEntity;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

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

    public static boolean tryRollingPinBakingMat(ServerLevel level, ItemStack item, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof BakingMatBlockEntity bakingMatBlockEntity) {
            if (!bakingMatBlockEntity.isEmpty() || state.getValue(BakingMatBlock.PROCESSING)) {
                if (bakingMatBlockEntity.processItemUsingTool(item, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void register() {
        DispenserBlock.registerBehavior(UbesDelightItems.ROLLING_PIN_WOOD.get(), new BakingMatDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItems.ROLLING_PIN_IRON.get(), new BakingMatDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItems.ROLLING_PIN_GOLD.get(), new BakingMatDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItems.ROLLING_PIN_DIAMOND.get(), new BakingMatDispenseBehavior());
        DispenserBlock.registerBehavior(UbesDelightItems.ROLLING_PIN_NETHERITE.get(), new BakingMatDispenseBehavior());
    }
}
