package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, UbesDelight.MOD_ID);

    public static final Supplier<SoundEvent> BLOCK_BAKING_MAT_ADD = registerSound("block_baking_mat_add");
    public static final Supplier<SoundEvent> BLOCK_BAKING_MAT_REMOVE = registerSound("block_baking_mat_remove");
    public static final Supplier<SoundEvent> BLOCK_BAKING_MAT_ROLLING_PIN = registerSound("block_baking_mat_rolling_pin");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_ADD = registerSound("block_drinkable_feast_add");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_REMOVE = registerSound("block_drinkable_feast_remove");
    public static final Supplier<SoundEvent> BLOCK_LUMPIA_FEAST_REMOVE = registerSound("block_lumpia_feast_remove");

    public static final Supplier<SoundEvent> BLOCK_LEAF_FEAST_ADD = registerSound("block.leaf_feast.add");
    public static final Supplier<SoundEvent> BLOCK_LEAF_FEAST_REMOVE = registerSound("block.leaf_feast.remove");

    public static final Supplier<SoundEvent> registerSound(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(TextUtils.res(name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
