package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.block.*;
import chefmooon.ubesdelight.common.block.leaf_feast.*;
import chefmooon.ubesdelight.common.block.leaf_feast.base.BaseLeafFeastBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.UniversalLeafFeastBlock;
import chefmooon.ubesdelight.common.utility.TextUtils;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class UbesDelightBlocks {

    public static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    public static final Supplier<Block> KALAN = registerBlock("kalan",
            KalanBlock::new, Block.Properties.ofFullCopy(Blocks.BRICKS).lightLevel(UbesDelightBlocks.litBlockEmission(13)));
    public static final Supplier<Block> BAKING_MAT_BAMBOO = registerBlock("baking_mat_bamboo",
            BakingMatBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(1.0f).sound(SoundType.BAMBOO));

    public static final Supplier<Block> UBE_CRATE = registerBlock("ube_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> GARLIC_CRATE = registerBlock("garlic_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> GINGER_CRATE = registerBlock("ginger_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> LEMONGRASS_CRATE = registerBlock("lemongrass_crate",
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));

    public static final Supplier<Block> WILD_UBE = registerBlock("wild_ube",
            (properties) -> new WildCropBlock(MobEffects.NIGHT_VISION, 6, properties), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
    public static final Supplier<Block> WILD_GARLIC = registerBlock("wild_garlic",
            (properties) -> new WildCropBlock(MobEffects.ABSORPTION, 6, properties), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
    public static final Supplier<Block> WILD_GINGER = registerBlock("wild_ginger",
            (properties) -> new WildCropBlock(MobEffects.LUCK, 6, properties), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
    public static final Supplier<Block> WILD_LEMONGRASS = registerBlock("wild_lemongrass",
            TallWildCropBlock::new, Block.Properties.ofFullCopy(Blocks.TALL_GRASS));

    public static final Supplier<Block> POTTED_UBE = registerBlock("potted_ube",
            (properties) -> new FlowerPotBlock(WILD_UBE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION));
    public static final Supplier<Block> POTTED_GARLIC = registerBlock("potted_garlic",
            (properties) -> new FlowerPotBlock(WILD_GARLIC.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION));
    public static final Supplier<Block> POTTED_GINGER = registerBlock("potted_ginger",
            (properties) -> new FlowerPotBlock(WILD_GINGER.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION));

    public static final Supplier<Block> UBE_CROP = registerBlock("ube_crop",
            UbeCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final Supplier<Block> GARLIC_CROP = registerBlock("garlic_crop",
            GarlicCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final Supplier<Block> GINGER_CROP = registerBlock("ginger_crop",
            GingerCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final Supplier<Block> LEMONGRASS_STALK_CROP = registerBlock("lemongrass_stalk_crop",
            LemongrassStalkCropBlock::new, BlockBehaviour.Properties.of()
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .strength(0.2F)
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEMONGRASS_LEAF_CROP = registerBlock("lemongrass_leaf_crop",
            LemongrassLeafCropBlock::new, BlockBehaviour.Properties.of()
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> GLASS_CUP_HALO_HALO = registerBlock("glass_cup_halo_halo",
            (properties) -> new GlassCupBlock(() -> UbesDelightItems.HALO_HALO.get(), properties),  BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(value -> 4));
    public static final Supplier<Block> GLASS_CUP_MILK_TEA_UBE = registerBlock("glass_cup_milk_tea_ube",
            (properties) -> new GlassCupBlock(() -> UbesDelightItems.MILK_TEA_UBE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));

    public static final Supplier<Block> UBE_CAKE = registerBlock("ube_cake",
            (properties) -> new UbesDelightCakeBlock(() -> UbesDelightItems.UBE_CAKE_SLICE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> LECHE_FLAN_FEAST = registerBlock("leche_flan_feast",
            (properties) -> new LecheFlanFeastBlock(() -> UbesDelightItems.LECHE_FLAN.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> HALO_HALO_FEAST = registerBlock("halo_halo_feast",
            (properties) -> new HaloHaloFeastBlock(() -> UbesDelightItems.HALO_HALO.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0f).sound(SoundType.GLASS).lightLevel(value -> 10));
    public static final Supplier<Block> MILK_TEA_UBE_FEAST = registerBlock("milk_tea_ube_feast",
            (properties) -> new DrinkableFeastBlock(() -> UbesDelightItems.MILK_TEA_UBE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0f).sound(SoundType.GLASS));

    public static final Supplier<Block> LEAF_FEAST = registerBlock("leaf_feast",
            BaseLeafFeastBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> UNIVERSAL_LEAF_FEAST = registerBlock("universal_leaf_feast",
            UniversalLeafFeastBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LUMPIA_FEAST = registerBlock("lumpia_feast",
            (properties) -> new LumpiaLeafFeastBlock(() -> UbesDelightItems.LUMPIA.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA = registerBlock("leaf_feast_ensaymada",
            (properties) -> new EnsaymadaLeafFeastBlock(() -> UbesDelightItems.ENSAYMADA.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA_UBE = registerBlock("leaf_feast_ensaymada_ube",
            (properties) -> new EnsaymadaLeafFeastBlock(() -> UbesDelightItems.ENSAYMADA_UBE.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_PANDESAL = registerBlock("leaf_feast_pandesal",
            (properties) -> new PandesalLeafFeastBlock(() -> UbesDelightItems.PANDESAL.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_PANDESAL_UBE = registerBlock("leaf_feast_pandesal_ube",
            (properties) -> new PandesalLeafFeastBlock(() -> UbesDelightItems.PANDESAL_UBE.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_HOPIA_MUNGGO = registerBlock("leaf_feast_hopia_munggo",
            (properties) -> new HopiaLeafFeastBlock(() -> UbesDelightItems.HOPIA_MUNGGO.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_HOPIA_UBE = registerBlock("leaf_feast_hopia_ube",
            (properties) -> new HopiaLeafFeastBlock(() -> UbesDelightItems.HOPIA_UBE.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_COOKED_RICE = registerBlock("leaf_feast_cooked_rice",
            (properties) -> new RiceLeafFeastBlock(() -> BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("farmersdelight", "cooked_rice")).get().value(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_FRIED_RICE = registerBlock("leaf_feast_fried_rice",
            (properties) -> new RiceLeafFeastBlock(() -> BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("farmersdelight", "fried_rice")).get().value(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_SINANGAG = registerBlock("leaf_feast_sinangag",
            (properties) -> new RiceLeafFeastBlock(() -> UbesDelightItems.SINANGAG.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static Supplier<Block> registerBlock(final String location, final Function<BlockBehaviour.Properties, Block> function, final BlockBehaviour.Properties properties) {
        properties.setId(ResourceKey.create(Registries.BLOCK, TextUtils.res(location)));
        Block block = function.apply(properties);
        Registry.register(BuiltInRegistries.BLOCK, TextUtils.res(location), block);
        return () -> block;
    }

    public static void register() {
    }
}
