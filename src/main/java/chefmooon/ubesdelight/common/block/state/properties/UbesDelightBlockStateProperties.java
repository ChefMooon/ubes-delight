package chefmooon.ubesdelight.common.block.state.properties;

import chefmooon.ubesdelight.common.core.LeafFeastTypes;

import java.util.Arrays;

public class UbesDelightBlockStateProperties {
    public static final LeafFeastTypeProperty LEAF_FEAST_TYPE = LeafFeastTypeProperty.create("leaf_feast_type", Arrays.asList(LeafFeastTypes.values()));
}
