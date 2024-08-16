package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.tag.CompatibilityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
    }
    private void registerModTags() {

    }

    private void registerCommonBlockTags() {
        getOrCreateTagBuilder(CommonTags.C_MINEABLE_KNIFE)
                .add(UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO)
                .add(UbesDelightBlocksImpl.UBE_CAKE)
                .add(UbesDelightBlocksImpl.LECHE_FLAN_FEAST)
                .add(UbesDelightBlocksImpl.HALO_HALO_FEAST)
                .add(UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST)
                .add(UbesDelightBlocksImpl.LUMPIA_FEAST);
    }

    private void registerMinecraftBlockTags() {
        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO)

                .add(UbesDelightBlocksImpl.UBE_CRATE)
                .add(UbesDelightBlocksImpl.GARLIC_CRATE)
                .add(UbesDelightBlocksImpl.GINGER_CRATE)
                .add(UbesDelightBlocksImpl.LEMONGRASS_CRATE);

        getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(UbesDelightBlocksImpl.KALAN);

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(UbesDelightBlocksImpl.WILD_UBE)
                .add(UbesDelightBlocksImpl.WILD_GARLIC)
                .add(UbesDelightBlocksImpl.WILD_GINGER);

        getOrCreateTagBuilder(BlockTags.TALL_FLOWERS)
                .add(UbesDelightBlocksImpl.WILD_LEMONGRASS);

        getOrCreateTagBuilder(BlockTags.CROPS)
                .add(UbesDelightBlocksImpl.UBE_CROP)
                .add(UbesDelightBlocksImpl.GARLIC_CROP)
                .add(UbesDelightBlocksImpl.GINGER_CROP)
                .add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP);

        getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND)
                .add(UbesDelightBlocksImpl.UBE_CROP)
                .add(UbesDelightBlocksImpl.GINGER_CROP)
                .add(UbesDelightBlocksImpl.GARLIC_CROP)
                .add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP);
    }

    private void registerCompatibilityTags() {
        // Create Block Tags
        getOrCreateTagBuilder(CompatibilityTags.CREATE_PASSIVE_BOILER_HEATERS)
                .add(UbesDelightBlocksImpl.KALAN);

        getOrCreateTagBuilder(CompatibilityTags.CREATE_BRITTLE)
                .add(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO);

        // Farmer's Delight Block Tags
        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_HEAT_SOURCES)
                .add(UbesDelightBlocksImpl.KALAN);

        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS)
                .add(UbesDelightBlocksImpl.WILD_UBE)
                .add(UbesDelightBlocksImpl.WILD_GARLIC)
                .add(UbesDelightBlocksImpl.WILD_GINGER)
                .add(UbesDelightBlocksImpl.WILD_LEMONGRASS);

        // Serene Seasons
        getOrCreateTagBuilder(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS_BLOCK)
                .add(UbesDelightBlocksImpl.GARLIC_CROP)
                .add(UbesDelightBlocksImpl.GINGER_CROP);
        getOrCreateTagBuilder(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS_BLOCK)
                .add(UbesDelightBlocksImpl.UBE_CROP)
                .add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP)
                .add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP);
        getOrCreateTagBuilder(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK)
                .add(UbesDelightBlocksImpl.UBE_CROP)
                .add(UbesDelightBlocksImpl.GARLIC_CROP)
                .add(UbesDelightBlocksImpl.GINGER_CROP)
                .add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP)
                .add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP);
    }
}
