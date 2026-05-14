package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.block.*;
import chefmooon.ubesdelight.common.block.leaf_feast.*;
import chefmooon.ubesdelight.common.block.leaf_feast.base.BaseLeafFeastBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.UniversalLeafFeastBlock;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
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

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class UbesDelightBlocks {

    public static final Supplier<Block> KALAN = registerBlock("kalan", KalanBlock::new);
    public static final Supplier<Block> BAKING_MAT_BAMBOO = registerBlock("baking_mat_bamboo", BakingMatBlock::new);

    public static final Supplier<Block> UBE_CRATE = registerBlock("ube_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GARLIC_CRATE = registerBlock("garlic_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GINGER_CRATE = registerBlock("ginger_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> LEMONGRASS_CRATE = registerBlock("lemongrass_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final Supplier<Block> WILD_UBE = registerBlock("wild_ube",
            () -> new WildCropBlock(MobEffects.NIGHT_VISION, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> WILD_GARLIC = registerBlock("wild_garlic",
            () -> new WildCropBlock(MobEffects.ABSORPTION, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> WILD_GINGER = registerBlock("wild_ginger",
            () -> new WildCropBlock(MobEffects.LUCK, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> WILD_LEMONGRASS = registerBlock("wild_lemongrass", TallWildCropBlock::new);

    public static final Supplier<Block> POTTED_UBE = registerBlock("potted_ube",
            () -> new FlowerPotBlock(WILD_UBE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));
    public static final Supplier<Block> POTTED_GARLIC = registerBlock("potted_garlic",
            () -> new FlowerPotBlock(WILD_GARLIC.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));
    public static final Supplier<Block> POTTED_GINGER = registerBlock("potted_ginger",
            () -> new FlowerPotBlock(WILD_GINGER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));

    public static final Supplier<Block> UBE_CROP = registerBlock("ube_crop", UbeCropBlock::new);
    public static final Supplier<Block> GARLIC_CROP = registerBlock("garlic_crop", GarlicCropBlock::new);
    public static final Supplier<Block> GINGER_CROP = registerBlock("ginger_crop", GingerCropBlock::new);
    public static final Supplier<Block> LEMONGRASS_STALK_CROP = registerBlock("lemongrass_stalk_crop", LemongrassStalkCropBlock::new);
    public static final Supplier<Block> LEMONGRASS_LEAF_CROP = registerBlock("lemongrass_leaf_crop", LemongrassLeafCropBlock::new);

    public static final Supplier<Block> GLASS_CUP_HALO_HALO = registerBlock("glass_cup_halo_halo",
            () -> new GlassCupBlock(() -> UbesDelightItems.HALO_HALO.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(value -> 4)));
    public static final Supplier<Block> GLASS_CUP_MILK_TEA_UBE = registerBlock("glass_cup_milk_tea_ube",
            () -> new GlassCupBlock(() -> UbesDelightItems.MILK_TEA_UBE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));

    public static final Supplier<Block> UBE_CAKE = registerBlock("ube_cake", () -> new UbesDelightCakeBlock(() -> UbesDelightItems.UBE_CAKE_SLICE.get()));
    public static final Supplier<Block> LECHE_FLAN_FEAST = registerBlock("leche_flan_feast", () -> new LecheFlanFeastBlock(() -> UbesDelightItems.LECHE_FLAN.get()));
    public static final Supplier<Block> HALO_HALO_FEAST = registerBlock("halo_halo_feast", () -> new HaloHaloFeastBlock(() -> UbesDelightItems.HALO_HALO.get()));
    public static final Supplier<Block> MILK_TEA_UBE_FEAST = registerBlock("milk_tea_ube_feast", () -> new DrinkableFeastBlock(() -> UbesDelightItems.MILK_TEA_UBE.get()));

    public static final Supplier<Block> LEAF_FEAST = registerBlock("leaf_feast",
            () -> new BaseLeafFeastBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> UNIVERSAL_LEAF_FEAST = registerBlock("universal_leaf_feast",
            () -> new UniversalLeafFeastBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LUMPIA_FEAST = registerBlock("lumpia_feast",
            () -> new LumpiaLeafFeastBlock(() -> UbesDelightItems.LUMPIA.get(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA = registerBlock("leaf_feast_ensaymada",
            () -> new EnsaymadaLeafFeastBlock(() -> UbesDelightItems.ENSAYMADA.get(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA_UBE = registerBlock("leaf_feast_ensaymada_ube",
            () -> new EnsaymadaLeafFeastBlock(() -> UbesDelightItems.ENSAYMADA_UBE.get(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> LEAF_FEAST_PANDESAL = registerBlock("leaf_feast_pandesal",
            () -> new PandesalLeafFeastBlock(() -> UbesDelightItems.PANDESAL.get(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LEAF_FEAST_PANDESAL_UBE = registerBlock("leaf_feast_pandesal_ube",
            () -> new PandesalLeafFeastBlock(() -> UbesDelightItems.PANDESAL_UBE.get(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> LEAF_FEAST_HOPIA_MUNGGO = registerBlock("leaf_feast_hopia_munggo",
            () -> new HopiaLeafFeastBlock(() -> UbesDelightItems.HOPIA_MUNGGO.get(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LEAF_FEAST_HOPIA_UBE = registerBlock("leaf_feast_hopia_ube",
            () -> new HopiaLeafFeastBlock(() -> UbesDelightItems.HOPIA_UBE.get(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> LEAF_FEAST_COOKED_RICE = registerBlock("leaf_feast_cooked_rice",
            () -> new RiceLeafFeastBlock(() -> BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("farmersdelight", "cooked_rice")), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LEAF_FEAST_FRIED_RICE = registerBlock("leaf_feast_fried_rice",
            () -> new RiceLeafFeastBlock(() -> BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("farmersdelight", "fried_rice")), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LEAF_FEAST_SINANGAG = registerBlock("leaf_feast_sinangag",
            () -> new RiceLeafFeastBlock(() -> UbesDelightItems.SINANGAG.get(), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));

    public static Supplier<Block> registerBlock(final String location, final Supplier<Block> blockSupplier) {
        Block block = blockSupplier.get();
        Registry.register(BuiltInRegistries.BLOCK, TextUtils.res(location), block);
        return () -> block;
    }

    public static void register() {
    }

    public static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    private static ResourceLocation block(String string) {
        return TextUtils.res(string);
    }

}
