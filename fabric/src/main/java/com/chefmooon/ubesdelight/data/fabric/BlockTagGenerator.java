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
        getOrCreateTagBuilder(CommonTags.C_MINEABLE_KNIFE)
                .add(UbesDelightBlocksImpl.UBE_CAKE.get())
                .add(UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get())
                .add(UbesDelightBlocksImpl.HALO_HALO_FEAST.get())
                .add(UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST.get())
                .add(UbesDelightBlocksImpl.LUMPIA_FEAST.get());

        getOrCreateTagBuilder(CommonTags.C_MINEABLE_ROLLING_PIN);

        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_UBE).add(UbesDelightBlocksImpl.UBE_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_GARLIC).add(UbesDelightBlocksImpl.GARLIC_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_GINGER).add(UbesDelightBlocksImpl.GINGER_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_LEMONGRASS).add(UbesDelightBlocksImpl.LEMONGRASS_CRATE.get());
    }

    private void registerMinecraftBlockTags() {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get())

                .add(UbesDelightBlocksImpl.UBE_CRATE.get())
                .add(UbesDelightBlocksImpl.GARLIC_CRATE.get())
                .add(UbesDelightBlocksImpl.GINGER_CRATE.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_CRATE.get());

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(UbesDelightBlocksImpl.KALAN.get());

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(UbesDelightBlocksImpl.WILD_UBE.get())
                .add(UbesDelightBlocksImpl.WILD_GARLIC.get())
                .add(UbesDelightBlocksImpl.WILD_GINGER.get());

        getOrCreateTagBuilder(BlockTags.CROPS)
                .add(UbesDelightBlocksImpl.UBE_CROP.get())
                .add(UbesDelightBlocksImpl.GARLIC_CROP.get())
                .add(UbesDelightBlocksImpl.GINGER_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP.get());

        getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND)
                .add(UbesDelightBlocksImpl.UBE_CROP.get())
                .add(UbesDelightBlocksImpl.GINGER_CROP.get())
                .add(UbesDelightBlocksImpl.GARLIC_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get());
    }

    private void registerCompatibilityTags() {
        // Create Block Tags
        getOrCreateTagBuilder(CompatibilityTags.CREATE_PASSIVE_BOILER_HEATERS)
                .add(UbesDelightBlocksImpl.KALAN.get());

        getOrCreateTagBuilder(CompatibilityTags.CREATE_BRITTLE)
                .add(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get());

        // Farmer's Delight Block Tags
        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_HEAT_SOURCES)
                .add(UbesDelightBlocksImpl.KALAN.get());

        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS)
                .add(UbesDelightBlocksImpl.WILD_UBE.get())
                .add(UbesDelightBlocksImpl.WILD_GARLIC.get())
                .add(UbesDelightBlocksImpl.WILD_GINGER.get())
                .add(UbesDelightBlocksImpl.WILD_LEMONGRASS.get());

        // Serene Seasons
        getOrCreateTagBuilder(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS_BLOCK)
                .add(UbesDelightBlocksImpl.GARLIC_CROP.get())
                .add(UbesDelightBlocksImpl.GINGER_CROP.get());
        getOrCreateTagBuilder(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS_BLOCK)
                .add(UbesDelightBlocksImpl.UBE_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get());
        getOrCreateTagBuilder(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK)
                .add(UbesDelightBlocksImpl.UBE_CROP.get())
                .add(UbesDelightBlocksImpl.GARLIC_CROP.get())
                .add(UbesDelightBlocksImpl.GINGER_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP.get())
                .add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get());
    }

    private void registerConventionalBlockTags() {
        getOrCreateTagBuilder(ConventionalBlockTags.STORAGE_BLOCKS).addTags(
                CommonTags.C_STORAGE_BLOCKS_UBE,
                CommonTags.C_STORAGE_BLOCKS_GARLIC,
                CommonTags.C_STORAGE_BLOCKS_GINGER,
                CommonTags.C_STORAGE_BLOCKS_LEMONGRASS
        );

        getOrCreateTagBuilder(ConventionalBlockTags.TALL_FLOWERS)
                .add(UbesDelightBlocksImpl.WILD_LEMONGRASS.get());
    }
}
