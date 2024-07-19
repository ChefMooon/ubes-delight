package com.chefmooon.ubesdelight.common.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

public class HaloHaloFeastBlock extends DrinkableFeastBlock {
    public HaloHaloFeastBlock(Supplier<Item> servingItem) {
        super(servingItem, BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0f).sound(SoundType.GLASS).lightLevel(value -> 10));
    }
}
