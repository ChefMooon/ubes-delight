package com.chefmoon.ubesdelight.registry;

import com.chefmoon.ubesdelight.UbesDelightMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public enum SoundsRegistry {

    BLOCK_BAKING_MAT_ADD("block_baking_mat_add"),
    BLOCK_BAKING_MAT_REMOVE("block_baking_mat_remove"),
    BLOCK_BAKING_MAT_ROLLING_PIN("block_baking_mat_rolling_pin"),
    BLOCK_DRINKABLE_FEAST_ADD("block_drinkable_feast_add"),
    BLOCK_DRINKABLE_FEAST_REMOVE("block_drinkable_feast_remove"),
    BLOCK_LUMPIA_FEAST_REMOVE("block_lumpia_feast_remove");
    private final String pathName;
    private final SoundEvent soundEvent;

    SoundsRegistry(String pathName) {
        this.pathName = pathName;
        this.soundEvent = SoundEvent.of(new Identifier(UbesDelightMod.MOD_ID, this.pathName));
    }

    public static void registerAll() {
        for (SoundsRegistry value : values()) {
            Registry.register(Registries.SOUND_EVENT, new Identifier(UbesDelightMod.MOD_ID, value.pathName), value.soundEvent);
        }
    }

    public SoundEvent get() {
        return soundEvent;
    }
}
