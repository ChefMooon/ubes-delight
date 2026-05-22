package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class UbesDelightSounds {

    public static final Supplier<SoundEvent> BLOCK_BAKING_MAT_ADD = registerSound("block_baking_mat_add");
    public static final Supplier<SoundEvent> BLOCK_BAKING_MAT_REMOVE = registerSound("block_baking_mat_remove");
    public static final Supplier<SoundEvent> BLOCK_BAKING_MAT_ROLLING_PIN = registerSound("block_baking_mat_rolling_pin");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_ADD = registerSound("block_drinkable_feast_add");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_REMOVE = registerSound("block_drinkable_feast_remove");
    public static final Supplier<SoundEvent> BLOCK_LUMPIA_FEAST_REMOVE = registerSound("block_lumpia_feast_remove");

    public static final Supplier<SoundEvent> BLOCK_LEAF_FEAST_ADD = registerSound("block.leaf_feast.add");
    public static final Supplier<SoundEvent> BLOCK_LEAF_FEAST_REMOVE = registerSound("block.leaf_feast.remove");

    private static Supplier<SoundEvent> registerSound(String string) {
        return registerSound(TextUtils.res(string), () -> SoundEvent.createVariableRangeEvent(TextUtils.res(string)));
    }

    public static <T extends SoundEvent> Supplier<T> registerSound(Identifier id, Supplier<T> soundSupplier) {
        T soundEvent = soundSupplier.get();
        Registry.register(BuiltInRegistries.SOUND_EVENT, id, soundEvent);
        return () -> soundEvent;
    }

    public static void register() {

    }
}
