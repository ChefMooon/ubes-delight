package chefmooon.ubesdelight.common.block.state.properties;

import chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.google.common.collect.Lists;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LeafFeastTypeProperty extends EnumProperty<LeafFeastTypes> {
    protected LeafFeastTypeProperty(String name, Collection<LeafFeastTypes> values) {
        super(name, LeafFeastTypes.class, values);
    }

    public static LeafFeastTypeProperty create(String name, Predicate<LeafFeastTypes> filter) {
        return create(name, (Collection<LeafFeastTypes>) Arrays.stream(LeafFeastTypes.values()).filter(filter).collect(Collectors.toList()));
    }

    public static LeafFeastTypeProperty create(String name, LeafFeastTypes... values) {
        return create(name, Lists.<LeafFeastTypes>newArrayList(values));
    }

    public static LeafFeastTypeProperty create(String name, Collection<LeafFeastTypes> values) {
        return new LeafFeastTypeProperty(name, values);
    }
}
