package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.block.*;
import com.chefmooon.ubesdelight.common.block.fabric.BakingMatBlockImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class UbesDelightBlocksImpl {

    public static final Block KALAN = registerBlock(UbesDelightBlocks.KALAN, new KalanBlock());
    public static final Block BAKING_MAT_BAMBOO = registerBlock(UbesDelightBlocks.BAKING_MAT_BAMBOO, new BakingMatBlockImpl());

    public static final Block UBE_CRATE = registerBlock(UbesDelightBlocks.UBE_CRATE,
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block GARLIC_CRATE = registerBlock(UbesDelightBlocks.GARLIC_CRATE,
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block GINGER_CRATE = registerBlock(UbesDelightBlocks.GINGER_CRATE,
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Block LEMONGRASS_CRATE = registerBlock(UbesDelightBlocks.LEMONGRASS_CRATE,
            new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final Block WILD_UBE = registerBlock(UbesDelightBlocks.WILD_UBE,
            new WildCropBlock(MobEffects.NIGHT_VISION, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Block WILD_GARLIC = registerBlock(UbesDelightBlocks.WILD_GARLIC,
            new WildCropBlock(MobEffects.ABSORPTION, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Block WILD_GINGER = registerBlock(UbesDelightBlocks.WILD_GINGER,
            new WildCropBlock(MobEffects.LUCK, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Block WILD_LEMONGRASS = registerBlock(UbesDelightBlocks.WILD_LEMONGRASS, new TallWildCropBlock());

    public static final Block POTTED_UBE = registerBlock(UbesDelightBlocks.POTTED_UBE,
            new FlowerPotBlock(WILD_UBE, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));
    public static final Block POTTED_GARLIC = registerBlock(UbesDelightBlocks.POTTED_GARLIC,
            new FlowerPotBlock(WILD_GARLIC, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));
    public static final Block POTTED_GINGER = registerBlock(UbesDelightBlocks.POTTED_GINGER,
            new FlowerPotBlock(WILD_GINGER, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));

    public static final Block UBE_CROP = registerBlock(UbesDelightBlocks.UBE_CROP, new UbeCropBlock());
    public static final Block GARLIC_CROP = registerBlock(UbesDelightBlocks.GARLIC_CROP, new GarlicCropBlock());
    public static final Block GINGER_CROP = registerBlock(UbesDelightBlocks.GINGER_CROP, new GingerCropBlock());
    public static final Block LEMONGRASS_STALK_CROP = registerBlock(UbesDelightBlocks.LEMONGRASS_STALK_CROP, new LemongrassStalkCropBlock());
    public static final Block LEMONGRASS_LEAF_CROP = registerBlock(UbesDelightBlocks.LEMONGRASS_LEAF_CROP, new LemongrassLeafCropBlock());

    public static final Block GLASS_CUP_HALO_HALO = registerBlock(UbesDelightBlocks.GLASS_CUP_HALO_HALO, new GlassCupBlock());

    public static final Block UBE_CAKE = registerBlock(UbesDelightBlocks.UBE_CAKE, new UbesDelightCakeBlock(() -> UbesDelightItemsImpl.UBE_CAKE_SLICE));
    public static final Block LECHE_FLAN_FEAST = registerBlock(UbesDelightBlocks.LECHE_FLAN_FEAST, new LecheFlanFeastBlock(() -> UbesDelightItemsImpl.LECHE_FLAN));
    public static final Block HALO_HALO_FEAST = registerBlock(UbesDelightBlocks.HALO_HALO_FEAST, new HaloHaloFeastBlock(() -> UbesDelightItemsImpl.HALO_HALO));
    public static final Block MILK_TEA_UBE_FEAST = registerBlock(UbesDelightBlocks.MILK_TEA_UBE_FEAST, new DrinkableFeastBlock(() -> UbesDelightItemsImpl.MILK_TEA_UBE));
    public static final Block LUMPIA_FEAST = registerBlock(UbesDelightBlocks.LUMPIA_FEAST, new LumpiaFeastBlock(() -> UbesDelightItemsImpl.LUMPIA));

    public static Block registerBlock(final ResourceLocation location, final Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, location, block);
    }

    public static void register() {

    }
}
