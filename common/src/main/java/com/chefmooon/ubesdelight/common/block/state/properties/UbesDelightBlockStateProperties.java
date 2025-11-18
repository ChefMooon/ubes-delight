package com.chefmooon.ubesdelight.common.block.state.properties;

import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Arrays;

public class UbesDelightBlockStateProperties {
    public static final Property<LeafFeastTypes> LEAF_FEAST_TYPE = EnumProperty.create("leaf_feast_type", LeafFeastTypes.class);
}
