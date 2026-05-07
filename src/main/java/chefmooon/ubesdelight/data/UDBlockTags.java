package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class UDBlockTags extends BlockTagsProvider {
    public UDBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UbesDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        registerModTags();
        registerCommonBlockTags();
        registerMinecraftBlockTags();
        registerCompatibilityTags();
    }
    
    private void registerModTags() {

    }

    private void registerCommonBlockTags() {
        tag(CommonTags.C_MINEABLE_KNIFE)
                .add(UbesDelightBlocks.UBE_CAKE.get())
                .add(UbesDelightBlocks.LECHE_FLAN_FEAST.get())
                .add(UbesDelightBlocks.HALO_HALO_FEAST.get())
                .add(UbesDelightBlocks.MILK_TEA_UBE_FEAST.get())
                .add(UbesDelightBlocks.LUMPIA_FEAST.get());

        tag(CommonTags.C_MINEABLE_ROLLING_PIN);

        tag(CommonTags.C_STORAGE_BLOCKS)
                .addTag(CommonTags.C_STORAGE_BLOCKS_UBE)
                .addTag(CommonTags.C_STORAGE_BLOCKS_GARLIC)
                .addTag(CommonTags.C_STORAGE_BLOCKS_GINGER)
                .addTag(CommonTags.C_STORAGE_BLOCKS_LEMONGRASS);

        tag(CommonTags.C_STORAGE_BLOCKS_UBE).add(UbesDelightBlocks.UBE_CRATE.get());
        tag(CommonTags.C_STORAGE_BLOCKS_GARLIC).add(UbesDelightBlocks.GARLIC_CRATE.get());
        tag(CommonTags.C_STORAGE_BLOCKS_GINGER).add(UbesDelightBlocks.GINGER_CRATE.get());
        tag(CommonTags.C_STORAGE_BLOCKS_LEMONGRASS).add(UbesDelightBlocks.LEMONGRASS_CRATE.get());
    }

    private void registerMinecraftBlockTags() {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(UbesDelightBlocks.BAKING_MAT_BAMBOO.get())

                .add(UbesDelightBlocks.UBE_CRATE.get())
                .add(UbesDelightBlocks.GARLIC_CRATE.get())
                .add(UbesDelightBlocks.GINGER_CRATE.get())
                .add(UbesDelightBlocks.LEMONGRASS_CRATE.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(UbesDelightBlocks.KALAN.get());

        tag(BlockTags.SMALL_FLOWERS)
                .add(UbesDelightBlocks.WILD_UBE.get())
                .add(UbesDelightBlocks.WILD_GARLIC.get())
                .add(UbesDelightBlocks.WILD_GINGER.get());

        tag(BlockTags.TALL_FLOWERS)
                .add(UbesDelightBlocks.WILD_LEMONGRASS.get());

        tag(BlockTags.CROPS)
                .add(UbesDelightBlocks.UBE_CROP.get())
                .add(UbesDelightBlocks.GARLIC_CROP.get())
                .add(UbesDelightBlocks.GINGER_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get());

        tag(BlockTags.MAINTAINS_FARMLAND)
                .add(UbesDelightBlocks.UBE_CROP.get())
                .add(UbesDelightBlocks.GINGER_CROP.get())
                .add(UbesDelightBlocks.GARLIC_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get());
    }

    private void registerCompatibilityTags() {
        // Create Block Tags
        tag(CompatibilityTags.CREATE_PASSIVE_BOILER_HEATERS)
                .add(UbesDelightBlocks.KALAN.get());

        tag(CompatibilityTags.CREATE_BRITTLE)
                .add(UbesDelightBlocks.BAKING_MAT_BAMBOO.get());

        // Farmer's Delight Block Tags
        tag(CompatibilityTags.FARMERS_DELIGHT_HEAT_SOURCES)
                .add(UbesDelightBlocks.KALAN.get());

        tag(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS)
                .add(UbesDelightBlocks.WILD_UBE.get())
                .add(UbesDelightBlocks.WILD_GARLIC.get())
                .add(UbesDelightBlocks.WILD_GINGER.get())
                .add(UbesDelightBlocks.WILD_LEMONGRASS.get());

        // Serene Seasons
        tag(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS_BLOCK)
                .add(UbesDelightBlocks.GARLIC_CROP.get())
                .add(UbesDelightBlocks.GINGER_CROP.get());
        tag(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS_BLOCK)
                .add(UbesDelightBlocks.UBE_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get());
        tag(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK)
                .add(UbesDelightBlocks.UBE_CROP.get())
                .add(UbesDelightBlocks.GARLIC_CROP.get())
                .add(UbesDelightBlocks.GINGER_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get())
                .add(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get());
    }
}
