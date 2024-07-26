package com.chefmooon.ubesdelight.common.registry.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.block.*;
import com.chefmooon.ubesdelight.common.block.forge.BakingMatBlockImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Supplier;

public class UbesDelightBlocksImpl {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, UbesDelight.MOD_ID);

    public static final RegistryObject<Block> KALAN = registerBlock(UbesDelightBlocks.KALAN, KalanBlock::new);
    public static final RegistryObject<Block> BAKING_MAT_BAMBOO = registerBlock(UbesDelightBlocks.BAKING_MAT_BAMBOO, BakingMatBlockImpl::new);

    public static final RegistryObject<Block> UBE_CRATE = registerBlock(UbesDelightBlocks.UBE_CRATE,
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GARLIC_CRATE = registerBlock(UbesDelightBlocks.GARLIC_CRATE,
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GINGER_CRATE = registerBlock(UbesDelightBlocks.GINGER_CRATE,
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEMONGRASS_CRATE = registerBlock(UbesDelightBlocks.LEMONGRASS_CRATE,
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WILD_UBE = BLOCKS.register(UbesDelightBlocks.WILD_UBE.getPath(),
            () -> new WildCropBlock(MobEffects.NIGHT_VISION, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_GARLIC = registerBlock(UbesDelightBlocks.WILD_GARLIC,
            () -> new WildCropBlock(MobEffects.ABSORPTION, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_GINGER = registerBlock(UbesDelightBlocks.WILD_GINGER,
            () -> new WildCropBlock(MobEffects.LUCK, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_LEMONGRASS = registerBlock(UbesDelightBlocks.WILD_LEMONGRASS, TallWildCropBlock::new);

    public static final RegistryObject<Block> POTTED_UBE = registerBlock(UbesDelightBlocks.POTTED_UBE,
            () -> new FlowerPotBlock(WILD_UBE.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> POTTED_GARLIC = registerBlock(UbesDelightBlocks.POTTED_GARLIC,
            () -> new FlowerPotBlock(WILD_GARLIC.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> POTTED_GINGER = registerBlock(UbesDelightBlocks.POTTED_GINGER,
            () -> new FlowerPotBlock(WILD_GINGER.get(), BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));

    public static final RegistryObject<Block> UBE_CROP = registerBlock(UbesDelightBlocks.UBE_CROP, UbeCropBlock::new);
    public static final RegistryObject<Block> GARLIC_CROP = registerBlock(UbesDelightBlocks.GARLIC_CROP, GarlicCropBlock::new);
    public static final RegistryObject<Block> GINGER_CROP = registerBlock(UbesDelightBlocks.GINGER_CROP, GingerCropBlock::new);
    public static final RegistryObject<Block> LEMONGRASS_CROP = registerBlock(UbesDelightBlocks.LEMONGRASS_CROP, LemongrassCropBlock::new);
    public static final RegistryObject<Block> LEMONGRASS_STALK_CROP = registerBlock(UbesDelightBlocks.LEMONGRASS_STALK_CROP, LemongrassStalkCropBlock::new);
    public static final RegistryObject<Block> LEMONGRASS_LEAF_CROP = registerBlock(UbesDelightBlocks.LEMONGRASS_LEAF_CROP, LemongrassLeafCropBlock::new);

    public static final RegistryObject<Block> GLASS_CUP_HALO_HALO = registerBlock(UbesDelightBlocks.GLASS_CUP_HALO_HALO, GlassCupBlock::new);

    public static final RegistryObject<Block> UBE_CAKE = registerBlock(UbesDelightBlocks.UBE_CAKE, () -> new UbesDelightCakeBlock(UbesDelightItemsImpl.UBE_CAKE_SLICE::get));
    public static final RegistryObject<Block> LECHE_FLAN_FEAST = registerBlock(UbesDelightBlocks.LECHE_FLAN_FEAST, () -> new LecheFlanFeastBlock(UbesDelightItemsImpl.LECHE_FLAN::get));
    public static final RegistryObject<Block> HALO_HALO_FEAST = registerBlock(UbesDelightBlocks.HALO_HALO_FEAST, () -> new HaloHaloFeastBlock(UbesDelightItemsImpl.HALO_HALO::get));
    public static final RegistryObject<Block> MILK_TEA_UBE_FEAST = registerBlock(UbesDelightBlocks.MILK_TEA_UBE_FEAST, () -> new DrinkableFeastBlock(UbesDelightItemsImpl.MILK_TEA_UBE::get));
    public static final RegistryObject<Block> LUMPIA_FEAST = registerBlock(UbesDelightBlocks.LUMPIA_FEAST, () -> new LumpiaFeastBlock(UbesDelightItemsImpl.LUMPIA::get));

    public static RegistryObject<Block> registerBlock(final ResourceLocation location, final Supplier<Block> block) {
        return BLOCKS.register(location.getPath(), block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
