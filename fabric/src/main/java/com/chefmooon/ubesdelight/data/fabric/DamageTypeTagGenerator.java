package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.common.registry.UbesDelightDamageTypes;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;

import java.util.concurrent.CompletableFuture;

public class DamageTypeTagGenerator extends TagsProvider<DamageType> {
    public DamageTypeTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.DAMAGE_TYPE, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        // todo - this does not work, but it does not need to
        tag(DamageTypeTags.IS_FIRE).add(UbesDelightDamageTypes.KALAN_BURN);
        tag(DamageTypeTags.NO_KNOCKBACK).add(UbesDelightDamageTypes.KALAN_BURN);
        tag(DamageTypeTags.BURN_FROM_STEPPING).add(UbesDelightDamageTypes.KALAN_BURN);
        tag(DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES).add(UbesDelightDamageTypes.KALAN_BURN);
    }
}
