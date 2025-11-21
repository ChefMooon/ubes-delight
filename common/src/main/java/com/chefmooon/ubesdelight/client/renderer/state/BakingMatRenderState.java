package com.chefmooon.ubesdelight.client.renderer.state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;

public class BakingMatRenderState extends BlockEntityRenderState {
    public ItemStackRenderState[] stacks;
    public Boolean processing;
    public Direction direction;
}
