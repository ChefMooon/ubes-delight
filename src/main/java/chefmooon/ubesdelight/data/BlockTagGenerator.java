package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.references.UDBlockIds;
import chefmooon.ubesdelight.common.references.UDBlockItemIds;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemId;
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
                .add(key(UDBlockItemIds.UBE_CAKE))
                .add(key(UDBlockItemIds.LECHE_FLAN_FEAST))
                .add(key(UDBlockItemIds.HALO_HALO_FEAST))
                .add(key(UDBlockItemIds.MILK_TEA_UBE_FEAST))
                .add(key(UDBlockItemIds.LUMPIA_FEAST));

        tag(CommonTags.C_MINEABLE_ROLLING_PIN);

        tag(CommonTags.C_STORAGE_BLOCKS_UBE).add(key(UDBlockItemIds.UBE_CRATE));
        tag(CommonTags.C_STORAGE_BLOCKS_GARLIC).add(key(UDBlockItemIds.GARLIC_CRATE));
        tag(CommonTags.C_STORAGE_BLOCKS_GINGER).add(key(UDBlockItemIds.GINGER_CRATE));
        tag(CommonTags.C_STORAGE_BLOCKS_LEMONGRASS).add(key(UDBlockItemIds.LEMONGRASS_CRATE));
    }

    private void registerMinecraftBlockTags() {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(key(UDBlockItemIds.BAKING_MAT_BAMBOO))

                .add(key(UDBlockItemIds.UBE_CRATE))
                .add(key(UDBlockItemIds.GARLIC_CRATE))
                .add(key(UDBlockItemIds.GINGER_CRATE))
                .add(key(UDBlockItemIds.LEMONGRASS_CRATE));

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(key(UDBlockItemIds.KALAN));

        tag(BlockTags.SMALL_FLOWERS)
                .add(key(UDBlockItemIds.WILD_UBE))
                .add(key(UDBlockItemIds.WILD_GARLIC))
                .add(key(UDBlockItemIds.WILD_GINGER));

        tag(BlockTags.CROPS)
                .add(key(UDBlockItemIds.UBE_CROP))
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(UDBlockIds.LEMONGRASS_LEAF_CROP);

        tag(BlockTags.MAINTAINS_FARMLAND)
                .add(key(UDBlockItemIds.UBE_CROP))
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(key(UDBlockItemIds.LEMONGRASS_STALK_CROP));
    }

    private void registerCompatibilityTags() {
        // Create Block Tags
        tag(CompatibilityTags.CREATE_PASSIVE_BOILER_HEATERS)
                .add(key(UDBlockItemIds.KALAN));

        tag(CompatibilityTags.CREATE_BRITTLE)
                .add(key(UDBlockItemIds.BAKING_MAT_BAMBOO));

        // Farmer's Delight Block Tags
        tag(CompatibilityTags.FARMERS_DELIGHT_HEAT_SOURCES)
                .add(key(UDBlockItemIds.KALAN));

        tag(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS)
                .add(key(UDBlockItemIds.WILD_UBE))
                .add(key(UDBlockItemIds.WILD_GARLIC))
                .add(key(UDBlockItemIds.WILD_GINGER))
                .add(key(UDBlockItemIds.WILD_LEMONGRASS));

        // Serene Seasons
        tag(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS_BLOCK)
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(key(UDBlockItemIds.GINGER_CROP));
        tag(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS_BLOCK)
                .add(key(UDBlockItemIds.UBE_CROP))
                .add(UDBlockIds.LEMONGRASS_LEAF_CROP)
                .add(key(UDBlockItemIds.LEMONGRASS_STALK_CROP));
        tag(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK)
                .add(key(UDBlockItemIds.UBE_CROP))
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(UDBlockIds.LEMONGRASS_LEAF_CROP)
                .add(key(UDBlockItemIds.LEMONGRASS_STALK_CROP));
    }

    @SuppressWarnings("unchecked")
    private void registerConventionalBlockTags() {
        tag(ConventionalBlockTags.STORAGE_BLOCKS)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_UBE)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_GARLIC)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_GINGER)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_LEMONGRASS);

        tag(ConventionalBlockTags.TALL_FLOWERS)
                .add(key(UDBlockItemIds.WILD_LEMONGRASS));
    }

    private static ResourceKey<Block> key(BlockItemId blockItemId) {
        return blockItemId.block();
    }
}
