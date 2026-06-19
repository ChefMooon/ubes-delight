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
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

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
        tag(CommonTags.C_MINEABLE_KNIFE)
                .add(key(UbesDelightBlocks.UBE_CAKE.get()))
                .add(key(UbesDelightBlocks.LECHE_FLAN_FEAST.get()))
                .add(key(UbesDelightBlocks.HALO_HALO_FEAST.get()))
                .add(key(UbesDelightBlocks.MILK_TEA_UBE_FEAST.get()))
                .add(key(UbesDelightBlocks.LUMPIA_FEAST.get()));

        tag(CommonTags.C_MINEABLE_ROLLING_PIN);

        tag(CommonTags.C_STORAGE_BLOCKS_UBE).add(key(UbesDelightBlocks.UBE_CRATE.get()));
        tag(CommonTags.C_STORAGE_BLOCKS_GARLIC).add(key(UbesDelightBlocks.GARLIC_CRATE.get()));
        tag(CommonTags.C_STORAGE_BLOCKS_GINGER).add(key(UbesDelightBlocks.GINGER_CRATE.get()));
        tag(CommonTags.C_STORAGE_BLOCKS_LEMONGRASS).add(key(UbesDelightBlocks.LEMONGRASS_CRATE.get()));
    }

    private void registerMinecraftBlockTags() {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(key(UbesDelightBlocks.BAKING_MAT_BAMBOO.get()))

                .add(key(UbesDelightBlocks.UBE_CRATE.get()))
                .add(key(UbesDelightBlocks.GARLIC_CRATE.get()))
                .add(key(UbesDelightBlocks.GINGER_CRATE.get()))
                .add(key(UbesDelightBlocks.LEMONGRASS_CRATE.get()));

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(key(UbesDelightBlocks.KALAN.get()));

        tag(BlockTags.SMALL_FLOWERS)
                .add(key(UbesDelightBlocks.WILD_UBE.get()))
                .add(key(UbesDelightBlocks.WILD_GARLIC.get()))
                .add(key(UbesDelightBlocks.WILD_GINGER.get()));

        tag(BlockTags.CROPS)
                .add(key(UbesDelightBlocks.UBE_CROP.get()))
                .add(key(UbesDelightBlocks.GARLIC_CROP.get()))
                .add(key(UbesDelightBlocks.GINGER_CROP.get()))
                .add(key(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get()));

        tag(BlockTags.MAINTAINS_FARMLAND)
                .add(key(UbesDelightBlocks.UBE_CROP.get()))
                .add(key(UbesDelightBlocks.GINGER_CROP.get()))
                .add(key(UbesDelightBlocks.GARLIC_CROP.get()))
                .add(key(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get()));
    }

    private void registerCompatibilityTags() {
        // Create Block Tags
        tag(CompatibilityTags.CREATE_PASSIVE_BOILER_HEATERS)
                .add(key(UbesDelightBlocks.KALAN.get()));

        tag(CompatibilityTags.CREATE_BRITTLE)
                .add(key(UbesDelightBlocks.BAKING_MAT_BAMBOO.get()));

        // Farmer's Delight Block Tags
        tag(CompatibilityTags.FARMERS_DELIGHT_HEAT_SOURCES)
                .add(key(UbesDelightBlocks.KALAN.get()));

        tag(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS)
                .add(key(UbesDelightBlocks.WILD_UBE.get()))
                .add(key(UbesDelightBlocks.WILD_GARLIC.get()))
                .add(key(UbesDelightBlocks.WILD_GINGER.get()))
                .add(key(UbesDelightBlocks.WILD_LEMONGRASS.get()));

        // Serene Seasons
        tag(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS_BLOCK)
                .add(key(UbesDelightBlocks.GARLIC_CROP.get()))
                .add(key(UbesDelightBlocks.GINGER_CROP.get()));
        tag(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS_BLOCK)
                .add(key(UbesDelightBlocks.UBE_CROP.get()))
                .add(key(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get()))
                .add(key(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get()));
        tag(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK)
                .add(key(UbesDelightBlocks.UBE_CROP.get()))
                .add(key(UbesDelightBlocks.GARLIC_CROP.get()))
                .add(key(UbesDelightBlocks.GINGER_CROP.get()))
                .add(key(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get()))
                .add(key(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get()));
    }

    @SuppressWarnings("unchecked")
    private void registerConventionalBlockTags() {
        tag(ConventionalBlockTags.STORAGE_BLOCKS)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_UBE)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_GARLIC)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_GINGER)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_LEMONGRASS);

        tag(ConventionalBlockTags.TALL_FLOWERS)
                .add(key(UbesDelightBlocks.WILD_LEMONGRASS.get()));
    }

    private static ResourceKey<Block> key(Block block) {
        Identifier location = BuiltInRegistries.BLOCK.getKey(block);
        return ResourceKey.create(Registries.BLOCK, location);
    }
}
