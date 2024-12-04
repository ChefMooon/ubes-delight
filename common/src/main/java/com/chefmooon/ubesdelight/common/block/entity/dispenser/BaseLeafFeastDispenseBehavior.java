package com.chefmooon.ubesdelight.common.block.entity.dispenser;

import com.chefmooon.ubesdelight.common.block.leaf_feast.base.BaseLeafFeastBlock;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.LargeLeafFeastBlock;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.OptionalDispenseItemBehavior;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;

@MethodsReturnNonnullByDefault
public class BaseLeafFeastDispenseBehavior extends OptionalDispenseItemBehavior {

    public BaseLeafFeastDispenseBehavior() {
    }

    protected ItemStack execute(BlockSource source, ItemStack stack) {
        ServerLevel serverLevel = source.level();
        if (!serverLevel.isClientSide()) {
            Direction direction = source.state().getValue(DispenserBlock.FACING);
            Position position = DispenserBlock.getDispensePosition(source);
            BlockPos blockPos = source.pos().relative(direction);
            this.setSuccess(tryAddServing(serverLevel, stack, blockPos));
            ItemStack itemStack = stack.split(1);
            if (this.isSuccess()) {
                playSound(source);
            } else {
                spawnItem(source.level(), itemStack, 6, direction, position);
            }
        }
        return stack;
    }

    public static boolean tryAddServing(ServerLevel level, ItemStack item, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        if (state.getBlock() instanceof SimpleLeafFeastBlock simpleLeafFeastBlock) {
            if (item.is(simpleLeafFeastBlock.servingItem.get())) {
                int servings = state.getValue(SimpleLeafFeastBlock.SERVINGS);
                LeafFeastTypes leafFeastType = state.getValue(BaseLeafFeastBlock.LEAF_FEAST_TYPE);
                if (leafFeastType == LeafFeastTypes.TIP || leafFeastType == LeafFeastTypes.END) {
                    if (servings < SimpleLeafFeastBlock.MAX_SERVINGS / 2) {
                        return simpleLeafFeastBlock.addItemFromDispenser(item, level, pos, state);
                    }
                } else {
                    if (servings < SimpleLeafFeastBlock.MAX_SERVINGS) {
                        return simpleLeafFeastBlock.addItemFromDispenser(item, level, pos, state);
                    }
                }
            }
        } else if (state.getBlock() instanceof LargeLeafFeastBlock largeLeafFeastBlock) {
            return largeLeafFeastBlock.addItemFromDispenser(item, level, pos, state);
        } else if (state.getBlock() instanceof BaseLeafFeastBlock baseLeafFeastBlock) {
            return baseLeafFeastBlock.addItemFromDispenser(item, level, pos, state);
        }

        return false;
    }

    @ExpectPlatform
    public static void register() {
        throw new AssertionError();
    }
}
