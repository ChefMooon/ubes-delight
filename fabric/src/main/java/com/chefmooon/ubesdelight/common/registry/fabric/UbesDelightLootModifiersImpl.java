package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.loot.modifier.fabric.AddLootTableModifierImpl;
import com.mojang.serialization.MapCodec;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.PortingLibLoot;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightLootModifiersImpl {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(PortingLibLoot.GLOBAL_LOOT_MODIFIER_SERIALIZERS, UbesDelight.MOD_ID);

    public static final Supplier<MapCodec<AddLootTableModifierImpl>> ADD_LOOT_TABLE = LOOT_MODIFIERS.register("add_loot_table", AddLootTableModifierImpl.CODEC);

    public static void register() {
        LOOT_MODIFIERS.register();
    }
}
