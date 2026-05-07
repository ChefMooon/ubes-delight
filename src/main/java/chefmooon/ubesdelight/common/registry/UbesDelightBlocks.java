package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.block.*;
import chefmooon.ubesdelight.common.block.leaf_feast.*;
import chefmooon.ubesdelight.common.block.leaf_feast.base.BaseLeafFeastBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.UniversalLeafFeastBlock;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.registries.Registries;
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
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import vectorwing.farmersdelight.common.registry.ModItems;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class UbesDelightBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, UbesDelight.MOD_ID);

    public static final Supplier<Block> KALAN = BLOCKS.register("kalan", KalanBlock::new);
    public static final Supplier<Block> BAKING_MAT_BAMBOO = BLOCKS.register("baking_mat_bamboo", () -> new BakingMatBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(1.0f).sound(SoundType.BAMBOO)));

    public static final Supplier<Block> UBE_CRATE = BLOCKS.register("ube_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GARLIC_CRATE = BLOCKS.register("garlic_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GINGER_CRATE = BLOCKS.register("ginger_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> LEMONGRASS_CRATE = BLOCKS.register("lemongrass_crate",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final Supplier<Block> WILD_UBE = BLOCKS.register("wild_ube",
            () -> new WildCropBlock(MobEffects.NIGHT_VISION, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> WILD_GARLIC = BLOCKS.register("wild_garlic",
            () -> new WildCropBlock(MobEffects.ABSORPTION, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> WILD_GINGER = BLOCKS.register("wild_ginger",
            () -> new WildCropBlock(MobEffects.LUCK, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> WILD_LEMONGRASS = BLOCKS.register("wild_lemongrass", TallWildCropBlock::new);

    public static final Supplier<Block> POTTED_UBE = BLOCKS.register("potted_ube",
            () -> new FlowerPotBlock(WILD_UBE.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));
    public static final Supplier<Block> POTTED_GARLIC = BLOCKS.register("potted_garlic",
            () -> new FlowerPotBlock(WILD_GARLIC.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));
    public static final Supplier<Block> POTTED_GINGER = BLOCKS.register("potted_ginger",
            () -> new FlowerPotBlock(WILD_GINGER.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION)));

    public static final Supplier<Block> UBE_CROP = BLOCKS.register("ube_crop", UbeCropBlock::new);
    public static final Supplier<Block> GARLIC_CROP = BLOCKS.register("garlic_crop", GarlicCropBlock::new);
    public static final Supplier<Block> GINGER_CROP = BLOCKS.register("ginger_crop", GingerCropBlock::new);
    public static final Supplier<Block> LEMONGRASS_STALK_CROP = BLOCKS.register("lemongrass_stalk_crop", LemongrassStalkCropBlock::new);
    public static final Supplier<Block> LEMONGRASS_LEAF_CROP = BLOCKS.register("lemongrass_leaf_crop", LemongrassLeafCropBlock::new);

    public static final Supplier<Block> GLASS_CUP_HALO_HALO = BLOCKS.register("glass_cup_halo_halo",
            () -> new GlassCupBlock(UbesDelightItems.HALO_HALO, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(value -> 4)));
    public static final Supplier<Block> GLASS_CUP_MILK_TEA_UBE = BLOCKS.register("glass_cup_milk_tea_ube",
            () -> new GlassCupBlock(UbesDelightItems.MILK_TEA_UBE, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));

    public static final Supplier<Block> UBE_CAKE = BLOCKS.register("ube_cake", () -> new UbesDelightCakeBlock(UbesDelightItems.UBE_CAKE_SLICE::get));
    public static final Supplier<Block> LECHE_FLAN_FEAST = BLOCKS.register("leche_flan_feast", () -> new LecheFlanFeastBlock(UbesDelightItems.LECHE_FLAN::get));
    public static final Supplier<Block> HALO_HALO_FEAST = BLOCKS.register("halo_halo_feast", () -> new HaloHaloFeastBlock(UbesDelightItems.HALO_HALO::get));
    public static final Supplier<Block> MILK_TEA_UBE_FEAST = BLOCKS.register("milk_tea_ube_feast", () -> new DrinkableFeastBlock(UbesDelightItems.MILK_TEA_UBE::get));

    public static final Supplier<Block> LEAF_FEAST = BLOCKS.register("leaf_feast",
            () -> new BaseLeafFeastBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> UNIVERSAL_LEAF_FEAST = BLOCKS.register("universal_leaf_feast",
            () -> new UniversalLeafFeastBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LUMPIA_FEAST = BLOCKS.register("lumpia_feast",
            () -> new LumpiaLeafFeastBlock(UbesDelightItems.LUMPIA, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA = BLOCKS.register("leaf_feast_ensaymada",
            () -> new EnsaymadaLeafFeastBlock(UbesDelightItems.ENSAYMADA, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA_UBE = BLOCKS.register("leaf_feast_ensaymada_ube",
            () -> new EnsaymadaLeafFeastBlock(UbesDelightItems.ENSAYMADA_UBE, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> LEAF_FEAST_PANDESAL = BLOCKS.register("leaf_feast_pandesal",
            () -> new PandesalLeafFeastBlock(UbesDelightItems.PANDESAL, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LEAF_FEAST_PANDESAL_UBE = BLOCKS.register("leaf_feast_pandesal_ube",
            () -> new PandesalLeafFeastBlock(UbesDelightItems.PANDESAL_UBE, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> LEAF_FEAST_HOPIA_MUNGGO = BLOCKS.register("leaf_feast_hopia_munggo",
            () -> new HopiaLeafFeastBlock(UbesDelightItems.HOPIA_MUNGGO, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LEAF_FEAST_HOPIA_UBE = BLOCKS.register("leaf_feast_hopia_ube",
            () -> new HopiaLeafFeastBlock(UbesDelightItems.HOPIA_UBE, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));

    public static final Supplier<Block> LEAF_FEAST_COOKED_RICE = BLOCKS.register("leaf_feast_cooked_rice",
            () -> new RiceLeafFeastBlock(ModItems.COOKED_RICE, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LEAF_FEAST_FRIED_RICE = BLOCKS.register("leaf_feast_fried_rice",
            () -> new RiceLeafFeastBlock(ModItems.FRIED_RICE, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));
    public static final Supplier<Block> LEAF_FEAST_SINANGAG = BLOCKS.register("leaf_feast_sinangag",
            () -> new RiceLeafFeastBlock(UbesDelightItems.SINANGAG, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

//    public static final ResourceLocation KALAN = block("kalan");
//    public static final ResourceLocation BAKING_MAT_BAMBOO = block("baking_mat_bamboo");
//
//    public static final ResourceLocation UBE_CRATE = block("ube_crate");
//    public static final ResourceLocation GARLIC_CRATE = block("garlic_crate");
//    public static final ResourceLocation GINGER_CRATE = block("ginger_crate");
//    public static final ResourceLocation LEMONGRASS_CRATE = block("lemongrass_crate");
//
//    public static final ResourceLocation WILD_UBE = block("wild_ube");
//    public static final ResourceLocation WILD_GARLIC = block("wild_garlic");
//    public static final ResourceLocation WILD_GINGER = block("wild_ginger");
//    public static final ResourceLocation WILD_LEMONGRASS = block("wild_lemongrass");
//    public static final ResourceLocation POTTED_UBE = block("potted_ube");
//    public static final ResourceLocation POTTED_GARLIC = block("potted_garlic");
//    public static final ResourceLocation POTTED_GINGER = block("potted_ginger");
//
//    public static final ResourceLocation UBE_CROP = block("ube_crop");
//    public static final ResourceLocation GARLIC_CROP = block("garlic_crop");
//    public static final ResourceLocation GINGER_CROP = block("ginger_crop");
//    public static final ResourceLocation LEMONGRASS_CROP = block("lemongrass_crop"); //TODO: datafixer this
//    public static final ResourceLocation LEMONGRASS_STALK_CROP = block("lemongrass_stalk_crop");
//    public static final ResourceLocation LEMONGRASS_LEAF_CROP = block("lemongrass_leaf_crop");
//
//    public static final ResourceLocation GLASS_CUP_HALO_HALO = block("glass_cup_halo_halo");
//    public static final ResourceLocation GLASS_CUP_MILK_TEA_UBE = block("glass_cup_milk_tea_ube");
//
//    public static final ResourceLocation UBE_CAKE = block("ube_cake");
//    public static final ResourceLocation LECHE_FLAN_FEAST = block("leche_flan_feast");
//    public static final ResourceLocation HALO_HALO_FEAST = block("halo_halo_feast");
//    public static final ResourceLocation MILK_TEA_UBE_FEAST = block("milk_tea_ube_feast");
//    public static final ResourceLocation LUMPIA_FEAST = block("lumpia_feast");
//
//    public static final ResourceLocation LEAF_FEAST = block("leaf_feast");
//    public static final ResourceLocation UNIVERSAL_LEAF_FEAST = block("universal_leaf_feast");
//
//    public static final ResourceLocation LEAF_FEAST_ENSAYMADA = block("leaf_feast_ensaymada");
//    public static final ResourceLocation LEAF_FEAST_ENSAYMADA_HALF = block("leaf_feast_ensaymada_half");
//
//    public static final ResourceLocation LEAF_FEAST_ENSAYMADA_UBE = block("leaf_feast_ensaymada_ube");
//    public static final ResourceLocation LEAF_FEAST_ENSAYMADA_UBE_HALF = block("leaf_feast_ensaymada_ube_half");
//
//    public static final ResourceLocation LEAF_FEAST_PANDESAL = block("leaf_feast_pandesal");
//    public static final ResourceLocation LEAF_FEAST_PANDESAL_HALF = block("leaf_feast_pandesal_half");
//
//    public static final ResourceLocation LEAF_FEAST_PANDESAL_UBE = block("leaf_feast_pandesal_ube");
//    public static final ResourceLocation LEAF_FEAST_PANDESAL_UBE_HALF = block("leaf_feast_pandesal_ube_half");
//
//    public static final ResourceLocation LEAF_FEAST_HOPIA_MUNGGO = block("leaf_feast_hopia_munggo");
//    public static final ResourceLocation LEAF_FEAST_HOPIA_MUNGGO_HALF = block("leaf_feast_hopia_munggo_half");
//
//    public static final ResourceLocation LEAF_FEAST_HOPIA_UBE = block("leaf_feast_hopia_ube");
//    public static final ResourceLocation LEAF_FEAST_HOPIA_UBE_HALF = block("leaf_feast_hopia_ube_half");
//    public static final ResourceLocation LEAF_FEAST_COOKED_RICE = block("leaf_feast_cooked_rice");
//    public static final ResourceLocation LEAF_FEAST_COOKED_RICE_HALF = block("leaf_feast_cooked_rice_half");
//    public static final ResourceLocation LEAF_FEAST_FRIED_RICE = block("leaf_feast_fried_rice");
//    public static final ResourceLocation LEAF_FEAST_FRIED_RICE_HALF = block("leaf_feast_fried_rice_half");
//    public static final ResourceLocation LEAF_FEAST_SINANGAG = block("leaf_feast_sinangag");
//    public static final ResourceLocation LEAF_FEAST_SINANGAG_HALF = block("leaf_feast_sinangag_half");

    public static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    private static ResourceLocation block(String string) {
        return TextUtils.res(string);
    }

}
