package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import com.chefmoon.ubesdelight.tag.CompatibilityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        this.registerCommonBlockTags();
        this.registerMinecraftBlockTags();
        this.registerCompatibilityBlockTags();
    }

    private void registerCommonBlockTags() {
        getOrCreateTagBuilder(CommonTags.C_MINEABLE_KNIFE)
                .add(BlocksRegistry.GLASS_CUP_HALO_HALO.get())
                .add(BlocksRegistry.UBE_CAKE.get())
                .add(BlocksRegistry.LECHE_FLAN_FEAST.get())
                .add(BlocksRegistry.HALO_HALO_FEAST.get())
                .add(BlocksRegistry.MILK_TEA_UBE_FEAST.get())
                .add(BlocksRegistry.LUMPIA_FEAST.get());
    }

    private void registerMinecraftBlockTags() {
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(BlocksRegistry.BAKING_MAT_BAMBOO.get())

                .add(BlocksRegistry.UBE_CRATE.get())
                .add(BlocksRegistry.GARLIC_CRATE.get())
                .add(BlocksRegistry.GINGER_CRATE.get())
                .add(BlocksRegistry.LEMONGRASS_CRATE.get());

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(BlocksRegistry.KALAN.get());

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(BlocksRegistry.WILD_UBE.get())
                .add(BlocksRegistry.WILD_GARLIC.get())
                .add(BlocksRegistry.WILD_GINGER.get())
                .add(BlocksRegistry.WILD_LEMONGRASS.get());

        getOrCreateTagBuilder(BlockTags.CROPS)
                .add(BlocksRegistry.UBE_CROP.get())
                .add(BlocksRegistry.GARLIC_CROP.get())
                .add(BlocksRegistry.GINGER_CROP.get())
                .add(BlocksRegistry.LEMONGRASS_LEAF_CROP.get());

        getOrCreateTagBuilder(BlockTags.MAINTAINS_FARMLAND)
                .add(BlocksRegistry.UBE_CROP.get())
                .add(BlocksRegistry.GINGER_CROP.get())
                .add(BlocksRegistry.GARLIC_CROP.get())
                .add(BlocksRegistry.LEMONGRASS_STALK_CROP.get());
    }

    private void registerCompatibilityBlockTags() {
        // Create Block Tags
        getOrCreateTagBuilder(CompatibilityTags.CREATE_FAN_HEATERS)
                .add(BlocksRegistry.KALAN.get());

        // Farmer's Delight Block Tags
        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_HEAT_SOURCES)
                .add(BlocksRegistry.KALAN.get());

        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS)
                .add(BlocksRegistry.WILD_UBE.get())
                .add(BlocksRegistry.WILD_GARLIC.get())
                .add(BlocksRegistry.WILD_GINGER.get())
                .add(BlocksRegistry.WILD_LEMONGRASS.get());
    }
}
