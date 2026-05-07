package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.registry.UbesDelightDamageTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class UDDamageTypeTags extends TagsProvider<DamageType> {
    protected UDDamageTypeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, Registries.DAMAGE_TYPE, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(DamageTypeTags.IS_FIRE).add(UbesDelightDamageTypes.KALAN_BURN);
        tag(DamageTypeTags.NO_KNOCKBACK).add(UbesDelightDamageTypes.KALAN_BURN);
        tag(DamageTypeTags.BURN_FROM_STEPPING).add(UbesDelightDamageTypes.KALAN_BURN);
        tag(DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES).add(UbesDelightDamageTypes.KALAN_BURN);
    }
}
