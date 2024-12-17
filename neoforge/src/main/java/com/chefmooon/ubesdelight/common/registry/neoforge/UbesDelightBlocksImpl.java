package com.chefmooon.ubesdelight.common.registry.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.block.*;
import com.chefmooon.ubesdelight.common.block.leaf_feast.*;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.BaseLeafFeastBlock;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.neoforge.UniversalLeafFeastBlockImpl;
import com.chefmooon.ubesdelight.common.block.neoforge.BakingMatBlockImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Supplier;

public class UbesDelightBlocksImpl {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, UbesDelight.MOD_ID);

    public static final Supplier<Block> KALAN = registerBlock(UbesDelightBlocks.KALAN, KalanBlock::new);
    public static final Supplier<Block> BAKING_MAT_BAMBOO = registerBlock(UbesDelightBlocks.BAKING_MAT_BAMBOO, BakingMatBlockImpl::new);

    public static final Supplier<Block> UBE_CRATE = registerBlock(UbesDelightBlocks.UBE_CRATE,
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GARLIC_CRATE = registerBlock(UbesDelightBlocks.GARLIC_CRATE,
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GINGER_CRATE = registerBlock(UbesDelightBlocks.GINGER_CRATE,
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> LEMONGRASS_CRATE = registerBlock(UbesDelightBlocks.LEMONGRASS_CRATE,
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final Supplier<Block> WILD_UBE = BLOCKS.register(UbesDelightBlocks.WILD_UBE.getPath(),
            () -> new WildCropBlock(MobEffects.NIGHT_VISION, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> WILD_GARLIC = registerBlock(UbesDelightBlocks.WILD_GARLIC,
            () -> new WildCropBlock(MobEffects.ABSORPTION, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> WILD_GINGER = registerBlock(UbesDelightBlocks.WILD_GINGER,
            () -> new WildCropBlock(MobEffects.LUCK, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> WILD_LEMONGRASS = registerBlock(UbesDelightBlocks.WILD_LEMONGRASS, TallWildCropBlock::new);

    public static final Supplier<Block> POTTED_UBE = registerBlock(UbesDelightBlocks.POTTED_UBE,
            () -> new FlowerPotBlock(WILD_UBE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));
    public static final Supplier<Block> POTTED_GARLIC = registerBlock(UbesDelightBlocks.POTTED_GARLIC,
            () -> new FlowerPotBlock(WILD_GARLIC.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));
    public static final Supplier<Block> POTTED_GINGER = registerBlock(UbesDelightBlocks.POTTED_GINGER,
            () -> new FlowerPotBlock(WILD_GINGER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));

    public static final Supplier<Block> UBE_CROP = registerBlock(UbesDelightBlocks.UBE_CROP, UbeCropBlock::new);
    public static final Supplier<Block> GARLIC_CROP = registerBlock(UbesDelightBlocks.GARLIC_CROP, GarlicCropBlock::new);
    public static final Supplier<Block> GINGER_CROP = registerBlock(UbesDelightBlocks.GINGER_CROP, GingerCropBlock::new);
    public static final Supplier<Block> LEMONGRASS_STALK_CROP = registerBlock(UbesDelightBlocks.LEMONGRASS_STALK_CROP, LemongrassStalkCropBlock::new);
    public static final Supplier<Block> LEMONGRASS_LEAF_CROP = registerBlock(UbesDelightBlocks.LEMONGRASS_LEAF_CROP, LemongrassLeafCropBlock::new);

    public static final Supplier<Block> GLASS_CUP_HALO_HALO = registerBlock(UbesDelightBlocks.GLASS_CUP_HALO_HALO,
            () -> new GlassCupBlock(UbesDelightItemsImpl.HALO_HALO, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(value -> 4)));
    public static final Supplier<Block> GLASS_CUP_MILK_TEA_UBE = registerBlock(UbesDelightBlocks.GLASS_CUP_MILK_TEA_UBE,
            () -> new GlassCupBlock(UbesDelightItemsImpl.MILK_TEA_UBE, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));

    public static final Supplier<Block> UBE_CAKE = registerBlock(UbesDelightBlocks.UBE_CAKE, () -> new UbesDelightCakeBlock(UbesDelightItemsImpl.UBE_CAKE_SLICE::get));
    public static final Supplier<Block> LECHE_FLAN_FEAST = registerBlock(UbesDelightBlocks.LECHE_FLAN_FEAST, () -> new LecheFlanFeastBlock(UbesDelightItemsImpl.LECHE_FLAN::get));
    public static final Supplier<Block> HALO_HALO_FEAST = registerBlock(UbesDelightBlocks.HALO_HALO_FEAST, () -> new HaloHaloFeastBlock(UbesDelightItemsImpl.HALO_HALO::get));
    public static final Supplier<Block> MILK_TEA_UBE_FEAST = registerBlock(UbesDelightBlocks.MILK_TEA_UBE_FEAST, () -> new DrinkableFeastBlock(UbesDelightItemsImpl.MILK_TEA_UBE::get));

    public static final Supplier<Block> LEAF_FEAST = registerBlock(UbesDelightBlocks.LEAF_FEAST,
            () -> new BaseLeafFeastBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));
    public static final Supplier<Block> UNIVERSAL_LEAF_FEAST = registerBlock(UbesDelightBlocks.UNIVERSAL_LEAF_FEAST,
            () -> new UniversalLeafFeastBlockImpl(BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));
    public static final Supplier<Block> LUMPIA_FEAST = registerBlock(UbesDelightBlocks.LUMPIA_FEAST,
            () -> new LumpiaLeafFeastBlock(UbesDelightItemsImpl.LUMPIA::get, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));

    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA = registerBlock(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA,
            () -> new EnsaymadaLeafFeastBlock(UbesDelightItemsImpl.ENSAYMADA, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));
    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA_UBE = registerBlock(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE,
            () -> new EnsaymadaLeafFeastBlock(UbesDelightItemsImpl.ENSAYMADA_UBE, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));

    public static final Supplier<Block> LEAF_FEAST_PANDESAL = registerBlock(UbesDelightBlocks.LEAF_FEAST_PANDESAL,
            () -> new PandesalLeafFeastBlock(UbesDelightItemsImpl.PANDESAL, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));
    public static final Supplier<Block> LEAF_FEAST_PANDESAL_UBE = registerBlock(UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE,
            () -> new PandesalLeafFeastBlock(UbesDelightItemsImpl.PANDESAL_UBE, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));

    public static final Supplier<Block> LEAF_FEAST_HOPIA_MUNGGO = registerBlock(UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO,
            () -> new HopiaLeafFeastBlock(UbesDelightItemsImpl.HOPIA_MUNGGO, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));
    public static final Supplier<Block> LEAF_FEAST_HOPIA_UBE = registerBlock(UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE,
            () -> new HopiaLeafFeastBlock(UbesDelightItemsImpl.HOPIA_UBE, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));

    public static final Supplier<Block> LEAF_FEAST_COOKED_RICE = registerBlock(UbesDelightBlocks.LEAF_FEAST_COOKED_RICE,
            () -> new RiceLeafFeastBlock(ModItems.COOKED_RICE, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));
//            () -> new RiceLeafFeastBlock((Supplier<Item>) BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("farmersdelight", "cooked_rice")), BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));
    public static final Supplier<Block> LEAF_FEAST_FRIED_RICE = registerBlock(UbesDelightBlocks.LEAF_FEAST_FRIED_RICE,
        () -> new RiceLeafFeastBlock(ModItems.FRIED_RICE, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));
    public static final Supplier<Block> LEAF_FEAST_SINANGAG = registerBlock(UbesDelightBlocks.LEAF_FEAST_SINANGAG,
            () -> new RiceLeafFeastBlock(UbesDelightItemsImpl.SINANGAG, BlockBehaviour.Properties.ofFullCopy(Blocks.AZALEA).sound(SoundType.AZALEA)));

    public static Supplier<Block> registerBlock(final ResourceLocation location, final Supplier<Block> block) {
        return BLOCKS.register(location.getPath(), block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
