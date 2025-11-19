package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.tag.CompatibilityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        registerModTags();
        registerCommonBlockTags();
        registerMinecraftBlockTags();
        registerCompatibilityTags();
        registerConventionalBlockTags();
    }
    private void registerModTags() {

    }

    private void registerCommonBlockTags() {
        valueLookupBuilder(CommonTags.C_MINEABLE_KNIFE)
                .add(UbesDelightBlocksImpl.UBE_CAKE.get())
                .add(UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get())
                .add(UbesDelightBlocksImpl.HALO_HALO_FEAST.get())
                .add(UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST.get())
                .add(UbesDelightBlocksImpl.LUMPIA_FEAST.get());

        valueLookupBuilder(CommonTags.C_MINEABLE_ROLLING_PIN);

        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_UBE).add(UbesDelightBlocksImpl.UBE_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_GARLIC).add(UbesDelightBlocksImpl.GARLIC_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_GINGER).add(UbesDelightBlocksImpl.GINGER_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_LEMONGRASS).add(UbesDelightBlocksImpl.LEMONGRASS_CRATE.get());
    }

    private void registerMinecraftBlockTags() {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get())

                .add(UbesDelightBlocksImpl.UBE_CRATE.get())
                .add(UbesDelightBlocksImpl.GARLIC_CRATE.get())
                .add(UbesDelightBlocksImpl.GINGER_CRATE.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_CRATE.get());

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(UbesDelightBlocksImpl.KALAN.get());

        valueLookupBuilder(BlockTags.SMALL_FLOWERS)
                .add(UbesDelightBlocksImpl.WILD_UBE.get())
                .add(UbesDelightBlocksImpl.WILD_GARLIC.get())
                .add(UbesDelightBlocksImpl.WILD_GINGER.get());

        valueLookupBuilder(BlockTags.CROPS)
                .add(UbesDelightBlocksImpl.UBE_CROP.get())
                .add(UbesDelightBlocksImpl.GARLIC_CROP.get())
                .add(UbesDelightBlocksImpl.GINGER_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP.get());

        valueLookupBuilder(BlockTags.MAINTAINS_FARMLAND)
                .add(UbesDelightBlocksImpl.UBE_CROP.get())
                .add(UbesDelightBlocksImpl.GINGER_CROP.get())
                .add(UbesDelightBlocksImpl.GARLIC_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get());
    }

    private void registerCompatibilityTags() {
        // Create Block Tags
        valueLookupBuilder(CompatibilityTags.CREATE_PASSIVE_BOILER_HEATERS)
                .add(UbesDelightBlocksImpl.KALAN.get());

        valueLookupBuilder(CompatibilityTags.CREATE_BRITTLE)
                .add(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get());

        // Farmer's Delight Block Tags
        valueLookupBuilder(CompatibilityTags.FARMERS_DELIGHT_HEAT_SOURCES)
                .add(UbesDelightBlocksImpl.KALAN.get());

        valueLookupBuilder(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS)
                .add(UbesDelightBlocksImpl.WILD_UBE.get())
                .add(UbesDelightBlocksImpl.WILD_GARLIC.get())
                .add(UbesDelightBlocksImpl.WILD_GINGER.get())
                .add(UbesDelightBlocksImpl.WILD_LEMONGRASS.get());

        // Serene Seasons
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS_BLOCK)
                .add(UbesDelightBlocksImpl.GARLIC_CROP.get())
                .add(UbesDelightBlocksImpl.GINGER_CROP.get());
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS_BLOCK)
                .add(UbesDelightBlocksImpl.UBE_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get());
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK)
                .add(UbesDelightBlocksImpl.UBE_CROP.get())
                .add(UbesDelightBlocksImpl.GARLIC_CROP.get())
                .add(UbesDelightBlocksImpl.GINGER_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get());
    }

    @SuppressWarnings("unchecked")
    private void registerConventionalBlockTags() {
        valueLookupBuilder(ConventionalBlockTags.STORAGE_BLOCKS)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_UBE)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_GARLIC)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_GINGER)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_LEMONGRASS);

        valueLookupBuilder(ConventionalBlockTags.TALL_FLOWERS)
                .add(UbesDelightBlocksImpl.WILD_LEMONGRASS.get());
    }
}
