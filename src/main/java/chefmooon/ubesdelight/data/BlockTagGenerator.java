package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import chefmooon.ubesdelight.common.tag.UbesDelightTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagsProvider.BlockTagsProvider {
    public BlockTagGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
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
                .add(UbesDelightBlocks.UBE_CAKE.get())
                .add(UbesDelightBlocks.LECHE_FLAN_FEAST.get())
                .add(UbesDelightBlocks.HALO_HALO_FEAST.get())
                .add(UbesDelightBlocks.MILK_TEA_UBE_FEAST.get())
                .add(UbesDelightBlocks.LUMPIA_FEAST.get());

        valueLookupBuilder(CommonTags.C_MINEABLE_ROLLING_PIN);

        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_UBE).add(UbesDelightBlocks.UBE_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_GARLIC).add(UbesDelightBlocks.GARLIC_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_GINGER).add(UbesDelightBlocks.GINGER_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_LEMONGRASS).add(UbesDelightBlocks.LEMONGRASS_CRATE.get());
    }

    private void registerMinecraftBlockTags() {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(UbesDelightBlocks.BAKING_MAT_BAMBOO.get())

                .add(UbesDelightBlocks.UBE_CRATE.get())
                .add(UbesDelightBlocks.GARLIC_CRATE.get())
                .add(UbesDelightBlocks.GINGER_CRATE.get())
                .add(UbesDelightBlocks.LEMONGRASS_CRATE.get());

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(UbesDelightBlocks.KALAN.get());

        valueLookupBuilder(BlockTags.SMALL_FLOWERS)
                .add(UbesDelightBlocks.WILD_UBE.get())
                .add(UbesDelightBlocks.WILD_GARLIC.get())
                .add(UbesDelightBlocks.WILD_GINGER.get());

        valueLookupBuilder(BlockTags.CROPS)
                .add(UbesDelightBlocks.UBE_CROP.get())
                .add(UbesDelightBlocks.GARLIC_CROP.get())
                .add(UbesDelightBlocks.GINGER_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get());

        valueLookupBuilder(BlockTags.MAINTAINS_FARMLAND)
                .add(UbesDelightBlocks.UBE_CROP.get())
                .add(UbesDelightBlocks.GINGER_CROP.get())
                .add(UbesDelightBlocks.GARLIC_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get());
    }

    private void registerCompatibilityTags() {
        // Create Block Tags
        valueLookupBuilder(CompatibilityTags.CREATE_PASSIVE_BOILER_HEATERS)
                .add(UbesDelightBlocks.KALAN.get());

        valueLookupBuilder(CompatibilityTags.CREATE_BRITTLE)
                .add(UbesDelightBlocks.BAKING_MAT_BAMBOO.get());

        // Farmer's Delight Block Tags
        valueLookupBuilder(CompatibilityTags.FARMERS_DELIGHT_HEAT_SOURCES)
                .add(UbesDelightBlocks.KALAN.get());

        valueLookupBuilder(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS)
                .add(UbesDelightBlocks.WILD_UBE.get())
                .add(UbesDelightBlocks.WILD_GARLIC.get())
                .add(UbesDelightBlocks.WILD_GINGER.get())
                .add(UbesDelightBlocks.WILD_LEMONGRASS.get());

        // Serene Seasons
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS_BLOCK)
                .add(UbesDelightBlocks.GARLIC_CROP.get())
                .add(UbesDelightBlocks.GINGER_CROP.get());
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS_BLOCK)
                .add(UbesDelightBlocks.UBE_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get());
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK)
                .add(UbesDelightBlocks.UBE_CROP.get())
                .add(UbesDelightBlocks.GARLIC_CROP.get())
                .add(UbesDelightBlocks.GINGER_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get());
    }

    @SuppressWarnings("unchecked")
    private void registerConventionalBlockTags() {
        valueLookupBuilder(ConventionalBlockTags.STORAGE_BLOCKS)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_UBE)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_GARLIC)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_GINGER)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_LEMONGRASS);

        valueLookupBuilder(ConventionalBlockTags.TALL_FLOWERS)
                .add(UbesDelightBlocks.WILD_LEMONGRASS.get());
    }
}
