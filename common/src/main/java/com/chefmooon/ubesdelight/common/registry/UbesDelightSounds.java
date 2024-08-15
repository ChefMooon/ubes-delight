package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class UbesDelightSounds {

    public static final Supplier<SoundEvent> BLOCK_BAKING_MAT_ADD = registerSound("block_baking_mat_add");
    public static final Supplier<SoundEvent> BLOCK_BAKING_MAT_REMOVE = registerSound("block_baking_mat_remove");
    public static final Supplier<SoundEvent> BLOCK_BAKING_MAT_ROLLING_PIN = registerSound("block_baking_mat_rolling_pin");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_ADD = registerSound("block_drinkable_feast_add");
    public static final Supplier<SoundEvent> BLOCK_DRINKABLE_FEAST_REMOVE = registerSound("block_drinkable_feast_remove");
    public static final Supplier<SoundEvent> BLOCK_LUMPIA_FEAST_REMOVE = registerSound("block_lumpia_feast_remove");
    public static final Supplier<SoundEvent> BLOCK_LEAF_FEAST_ADD = registerSound("block_leaf_feast_add");
    public static final Supplier<SoundEvent> BLOCK_LEAF_FEAST_REMOVE = registerSound("block_leaf_feast_remove");

    private static Supplier<SoundEvent> registerSound(String string) {
        return registerSound(TextUtils.res(string), () -> SoundEvent.createVariableRangeEvent(TextUtils.res(string)));
    }

    @ExpectPlatform
    public static <T extends SoundEvent> Supplier<T> registerSound(ResourceLocation id, Supplier<T> supplier) {
        throw new AssertionError();
    }

    public static void init() {

    }
}
