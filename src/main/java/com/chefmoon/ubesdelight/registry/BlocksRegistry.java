package com.chefmoon.ubesdelight.registry;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.block.*;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public enum BlocksRegistry {

    KALAN("kalan", KalanBlock::new),
    BAKING_MAT_BAMBOO("baking_mat_bamboo", BakingMatBlock::new, true),

    UBE_CRATE("ube_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    GARLIC_CRATE("garlic_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    GINGER_CRATE("ginger_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),
    LEMONGRASS_CRATE("lemongrass_crate", () -> new Block(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(3.f).sounds(BlockSoundGroup.WOOD))),

    WILD_UBE("wild_ube", WildCropBlock::new, true, flammable(100,60)),
    WILD_GARLIC("wild_garlic", WildCropBlock::new, true, flammable(100,60)),
    WILD_GINGER("wild_ginger", WildCropBlock::new, true, flammable(100,60)),
    WILD_LEMONGRASS("wild_lemongrass", TallWildCropBlock::new, true, flammable(100,60)),
    POTTED_UBE("potted_ube", () -> new FlowerPotBlock(BlocksRegistry.WILD_UBE.get(), FabricBlockSettings.copy(Blocks.POTTED_DANDELION)), true, flammable(100,60)),
    POTTED_GARLIC("potted_garlic", () -> new FlowerPotBlock(BlocksRegistry.WILD_GARLIC.get(), FabricBlockSettings.copy(Blocks.POTTED_DANDELION)), true, flammable(100,60)),
    POTTED_GINGER("potted_ginger", () -> new FlowerPotBlock(BlocksRegistry.WILD_GINGER.get(), FabricBlockSettings.copy(Blocks.POTTED_DANDELION)), true, flammable(100,60)),

    UBE_CROP("ube_crop", UbeCropBlock::new, true),
    GARLIC_CROP("garlic_crop", GarlicCropBlock::new, true),
    GINGER_CROP("ginger_crop", GingerCropBlock::new, true),
    LEMONGRASS_CROP("lemongrass_crop", LemongrassCropBlock::new, true), //TODO: remove in V0.1.5
    LEMONGRASS_STALK_CROP("lemongrass_stalk_crop", LemongrassStalkCropBlock::new, true),
    LEMONGRASS_LEAF_CROP("lemongrass_leaf_crop", LemongrassLeafCropBlock::new, true),

    GLASS_CUP_HALO_HALO("glass_cup_halo_halo", GlassCupBlock::new, true),

    UBE_CAKE("ube_cake", () -> new UbesDelightCakeBlock(ItemsRegistry.UBE_CAKE_SLICE.get()), true),
    LECHE_FLAN_FEAST("leche_flan_feast", () -> new LecheFlanFeast(ItemsRegistry.LECHE_FLAN.get()), true),
    HALO_HALO_FEAST("halo_halo_feast", () -> new HaloHaloFeast(ItemsRegistry.HALO_HALO.get()), true),
    MILK_TEA_UBE_FEAST("milk_tea_ube_feast", () -> new DrinkableFeastBlock(ItemsRegistry.MILK_TEA_UBE.get()), true),
    LUMPIA_FEAST("lumpia_feast", () -> new LumpiaFeast(ItemsRegistry.LUMPIA.get()), true);

    private static FlammableBlockRegistry.Entry flammable(int burnChance, @SuppressWarnings("SameParameterValue") int spreadChance) {
        return new FlammableBlockRegistry.Entry(burnChance, spreadChance);
    }

    private static boolean isValidFlammableEntry(FlammableBlockRegistry.Entry flammableRate) {
        return flammableRate != null && flammableRate.getBurnChance() > 0 && flammableRate.getSpreadChance() > 0;
    }

    private final String pathName;
    private final Supplier<Block> blockSupplier;
    private final FlammableBlockRegistry.Entry flammableRate;
    private final boolean isCutout;
    private Block block;

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier) {
        this(pathName, blockSupplier, false, new FlammableBlockRegistry.Entry(0, 0));
    }

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier, boolean isCutout) {
        this(pathName, blockSupplier, isCutout, new FlammableBlockRegistry.Entry(0, 0));
    }

    BlocksRegistry(String pathName, Supplier<Block> blockSupplier, boolean isCutout, FlammableBlockRegistry.Entry flammableRate) {
        this.pathName = pathName;
        this.blockSupplier = blockSupplier;
        this.flammableRate = flammableRate;
        this.isCutout = isCutout;
    }
    public static void registerAll() {
        for (BlocksRegistry value : values()) {
            Block block = value.get();
            Registry.register(Registries.BLOCK, new Identifier(UbesDelightMod.MOD_ID, value.pathName), block);
            if (isValidFlammableEntry(value.flammableRate)) {
                FlammableBlockRegistry.getDefaultInstance().add(block, value.flammableRate);
            }
        }
    }

    @Environment(EnvType.CLIENT)
    public static void registerRenderLayer() {
        for (BlocksRegistry value : values()) {
            if (value.isCutout) {
                BlockRenderLayerMap.INSTANCE.putBlock(value.get(), RenderLayer.getCutout());
            }
        }
    }

    public Block get() {
        if (block == null) {
            block = blockSupplier.get();
        }

        return block;
    }

    public String getId() {
        return Registries.BLOCK.getId(get()).toString();
    }

    public String getPathName() {
        return pathName;
    }
}
