package chefmooon.ubesdelight.client.renderer.state;

import chefmooon.ubesdelight.common.core.LeafFeastTypes;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;

public class UniversalLeafFeastRenderState extends BlockEntityRenderState {
    public ItemStackRenderState[] stacks;
    public LeafFeastTypes leafFeastType;
    public Direction direction;
}
