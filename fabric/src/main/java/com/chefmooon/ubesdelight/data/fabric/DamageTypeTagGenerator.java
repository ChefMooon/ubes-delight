package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.common.registry.UbesDelightDamageTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;

import java.util.concurrent.CompletableFuture;

public class DamageTypeTagGenerator extends FabricTagsProvider<DamageType> {
    public DamageTypeTagGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.DAMAGE_TYPE, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        builder(DamageTypeTags.IS_FIRE).add(UbesDelightDamageTypes.KALAN_BURN);
        builder(DamageTypeTags.NO_KNOCKBACK).add(UbesDelightDamageTypes.KALAN_BURN);
        builder(DamageTypeTags.BURN_FROM_STEPPING).add(UbesDelightDamageTypes.KALAN_BURN);
        builder(DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES).add(UbesDelightDamageTypes.KALAN_BURN);
    }
}
