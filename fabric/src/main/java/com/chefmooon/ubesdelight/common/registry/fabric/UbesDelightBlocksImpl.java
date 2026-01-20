package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.block.*;
import com.chefmooon.ubesdelight.common.block.fabric.BakingMatBlockImpl;
import com.chefmooon.ubesdelight.common.block.leaf_feast.*;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.BaseLeafFeastBlock;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.fabric.UniversalLeafFeastBlockImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Function;
import java.util.function.Supplier;

public class UbesDelightBlocksImpl {

    public static final Supplier<Block> KALAN = registerBlock(UbesDelightBlocks.KALAN,
        KalanBlock::new, Block.Properties.ofFullCopy(Blocks.BRICKS).lightLevel(UbesDelightBlocks.litBlockEmission(13)));
    public static final Supplier<Block> BAKING_MAT_BAMBOO = registerBlock(UbesDelightBlocks.BAKING_MAT_BAMBOO,
        BakingMatBlockImpl::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(1.0f).sound(SoundType.BAMBOO));

    public static final Supplier<Block> UBE_CRATE = registerBlock(UbesDelightBlocks.UBE_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> GARLIC_CRATE = registerBlock(UbesDelightBlocks.GARLIC_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> GINGER_CRATE = registerBlock(UbesDelightBlocks.GINGER_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> LEMONGRASS_CRATE = registerBlock(UbesDelightBlocks.LEMONGRASS_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));

    public static final Supplier<Block> WILD_UBE = registerBlock(UbesDelightBlocks.WILD_UBE,
            (properties) -> new WildCropBlock(MobEffects.NIGHT_VISION, 6, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));
    public static final Supplier<Block> WILD_GARLIC = registerBlock(UbesDelightBlocks.WILD_GARLIC,
            (properties) -> new WildCropBlock(MobEffects.ABSORPTION, 6, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));
    public static final Supplier<Block> WILD_GINGER = registerBlock(UbesDelightBlocks.WILD_GINGER,
            (properties) -> new WildCropBlock(MobEffects.LUCK, 6, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));
    public static final Supplier<Block> WILD_LEMONGRASS = registerBlock(UbesDelightBlocks.WILD_LEMONGRASS,
            TallWildCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));

    public static final Supplier<Block> POTTED_UBE = registerBlock(UbesDelightBlocks.POTTED_UBE,
            (properties) -> new FlowerPotBlock(WILD_UBE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION));
    public static final Supplier<Block> POTTED_GARLIC = registerBlock(UbesDelightBlocks.POTTED_GARLIC,
            (properties) -> new FlowerPotBlock(WILD_GARLIC.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION));
    public static final Supplier<Block> POTTED_GINGER = registerBlock(UbesDelightBlocks.POTTED_GINGER,
            (properties) -> new FlowerPotBlock(WILD_GINGER.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION));

    public static final Supplier<Block> UBE_CROP = registerBlock(UbesDelightBlocks.UBE_CROP,
            UbeCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final Supplier<Block> GARLIC_CROP = registerBlock(UbesDelightBlocks.GARLIC_CROP,
            GarlicCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final Supplier<Block> GINGER_CROP = registerBlock(UbesDelightBlocks.GINGER_CROP,
            GingerCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final Supplier<Block> LEMONGRASS_STALK_CROP = registerBlock(UbesDelightBlocks.LEMONGRASS_STALK_CROP,
            LemongrassStalkCropBlock::new, BlockBehaviour.Properties.of()
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .strength(0.2F)
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEMONGRASS_LEAF_CROP = registerBlock(UbesDelightBlocks.LEMONGRASS_LEAF_CROP,
            LemongrassLeafCropBlock::new, BlockBehaviour.Properties.of()
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> GLASS_CUP_HALO_HALO = registerBlock(UbesDelightBlocks.GLASS_CUP_HALO_HALO,
            (properties) -> new GlassCupBlock(() -> UbesDelightItemsImpl.HALO_HALO.get(), properties),  BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(value -> 4));
    public static final Supplier<Block> GLASS_CUP_MILK_TEA_UBE = registerBlock(UbesDelightBlocks.GLASS_CUP_MILK_TEA_UBE,
            (properties) -> new GlassCupBlock(() -> UbesDelightItemsImpl.MILK_TEA_UBE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));

    public static final Supplier<Block> UBE_CAKE = registerBlock(UbesDelightBlocks.UBE_CAKE,
            (properties) -> new UbesDelightCakeBlock(() -> UbesDelightItemsImpl.UBE_CAKE_SLICE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> LECHE_FLAN_FEAST = registerBlock(UbesDelightBlocks.LECHE_FLAN_FEAST,
            (properties) -> new LecheFlanFeastBlock(() -> UbesDelightItemsImpl.LECHE_FLAN.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> HALO_HALO_FEAST = registerBlock(UbesDelightBlocks.HALO_HALO_FEAST,
            (properties) -> new HaloHaloFeastBlock(() -> UbesDelightItemsImpl.HALO_HALO.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0f).sound(SoundType.GLASS).lightLevel(value -> 10));
    public static final Supplier<Block> MILK_TEA_UBE_FEAST = registerBlock(UbesDelightBlocks.MILK_TEA_UBE_FEAST,
            (properties) -> new DrinkableFeastBlock(() -> UbesDelightItemsImpl.MILK_TEA_UBE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0f).sound(SoundType.GLASS));

    public static final Supplier<Block> LEAF_FEAST = registerBlock(UbesDelightBlocks.LEAF_FEAST,
            BaseLeafFeastBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> UNIVERSAL_LEAF_FEAST = registerBlock(UbesDelightBlocks.UNIVERSAL_LEAF_FEAST,
            UniversalLeafFeastBlockImpl::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LUMPIA_FEAST = registerBlock(UbesDelightBlocks.LUMPIA_FEAST,
            (properties) -> new LumpiaLeafFeastBlock(() -> UbesDelightItemsImpl.LUMPIA.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA = registerBlock(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA,
            (properties) -> new EnsaymadaLeafFeastBlock(() -> UbesDelightItemsImpl.ENSAYMADA.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA_UBE = registerBlock(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE,
            (properties) -> new EnsaymadaLeafFeastBlock(() -> UbesDelightItemsImpl.ENSAYMADA_UBE.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_PANDESAL = registerBlock(UbesDelightBlocks.LEAF_FEAST_PANDESAL,
            (properties) -> new PandesalLeafFeastBlock(() -> UbesDelightItemsImpl.PANDESAL.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_PANDESAL_UBE = registerBlock(UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE,
            (properties) -> new PandesalLeafFeastBlock(() -> UbesDelightItemsImpl.PANDESAL_UBE.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_HOPIA_MUNGGO = registerBlock(UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO,
            (properties) -> new HopiaLeafFeastBlock(() -> UbesDelightItemsImpl.HOPIA_MUNGGO.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_HOPIA_UBE = registerBlock(UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE,
            (properties) -> new HopiaLeafFeastBlock(() -> UbesDelightItemsImpl.HOPIA_UBE.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_COOKED_RICE = registerBlock(UbesDelightBlocks.LEAF_FEAST_COOKED_RICE,
            (properties) -> new RiceLeafFeastBlock(() -> BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("farmersdelight", "cooked_rice")).get().value(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_FRIED_RICE = registerBlock(UbesDelightBlocks.LEAF_FEAST_FRIED_RICE,
            (properties) -> new RiceLeafFeastBlock(() -> BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("farmersdelight", "fried_rice")).get().value(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_SINANGAG = registerBlock(UbesDelightBlocks.LEAF_FEAST_SINANGAG,
            (properties) -> new RiceLeafFeastBlock(() -> UbesDelightItemsImpl.SINANGAG.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static Supplier<Block> registerBlock(final Identifier location, final Function<BlockBehaviour.Properties, Block> function, final BlockBehaviour.Properties properties) {
        properties.setId(ResourceKey.create(Registries.BLOCK, location));
        return regBlock(location, () -> function.apply(properties));
    }

    private static <B extends Block> Supplier<B> regBlock(final Identifier location, Supplier<B> supplier) {
        B object = supplier.get();
        Registry.register(BuiltInRegistries.BLOCK, location, object);
        return () -> object;
    }

    public static void register() {

    }
}
