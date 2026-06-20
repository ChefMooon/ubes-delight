package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.block.*;
import chefmooon.ubesdelight.common.block.leaf_feast.*;
import chefmooon.ubesdelight.common.block.leaf_feast.base.BaseLeafFeastBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.UniversalLeafFeastBlock;
import chefmooon.ubesdelight.common.references.UDBlockIds;
import chefmooon.ubesdelight.common.references.UDBlockItemIds;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
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

    public static final Supplier<Block> KALAN = registerBlock(UDBlockItemIds.KALAN,
            KalanBlock::new, Block.Properties.ofFullCopy(Blocks.BRICKS).lightLevel(UbesDelightBlocks.litBlockEmission(13)));
    public static final Supplier<Block> BAKING_MAT_BAMBOO = registerBlock(UDBlockItemIds.BAKING_MAT_BAMBOO,
            BakingMatBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WOOL.white()).strength(1.0f).sound(SoundType.BAMBOO));

    public static final Supplier<Block> UBE_CRATE = registerBlock(UDBlockItemIds.UBE_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> GARLIC_CRATE = registerBlock(UDBlockItemIds.GARLIC_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> GINGER_CRATE = registerBlock(UDBlockItemIds.GINGER_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> LEMONGRASS_CRATE = registerBlock(UDBlockItemIds.LEMONGRASS_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));

    public static final Supplier<Block> WILD_UBE = registerBlock(UDBlockItemIds.WILD_UBE,
            (properties) -> new WildCropBlock(MobEffects.NIGHT_VISION, 6, properties), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
    public static final Supplier<Block> WILD_GARLIC = registerBlock(UDBlockItemIds.WILD_GARLIC,
            (properties) -> new WildCropBlock(MobEffects.ABSORPTION, 6, properties), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
    public static final Supplier<Block> WILD_GINGER = registerBlock(UDBlockItemIds.WILD_GINGER,
            (properties) -> new WildCropBlock(MobEffects.LUCK, 6, properties), Block.Properties.ofFullCopy(Blocks.TALL_GRASS));
    public static final Supplier<Block> WILD_LEMONGRASS = registerBlock(UDBlockItemIds.WILD_LEMONGRASS,
            TallWildCropBlock::new, Block.Properties.ofFullCopy(Blocks.TALL_GRASS));

    public static final Supplier<Block> POTTED_UBE = registerBlock(UDBlockIds.POTTED_UBE,
            (properties) -> new FlowerPotBlock(WILD_UBE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION));
    public static final Supplier<Block> POTTED_GARLIC = registerBlock(UDBlockIds.POTTED_GARLIC,
            (properties) -> new FlowerPotBlock(WILD_GARLIC.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION));
    public static final Supplier<Block> POTTED_GINGER = registerBlock(UDBlockIds.POTTED_GINGER,
            (properties) -> new FlowerPotBlock(WILD_GINGER.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_DANDELION));

    public static final Supplier<Block> UBE_CROP = registerBlock(UDBlockItemIds.UBE_CROP,
            UbeCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final Supplier<Block> GARLIC_CROP = registerBlock(UDBlockItemIds.GARLIC_CROP,
            GarlicCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final Supplier<Block> GINGER_CROP = registerBlock(UDBlockItemIds.GINGER_CROP,
            GingerCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final Supplier<Block> LEMONGRASS_STALK_CROP = registerBlock(UDBlockItemIds.LEMONGRASS_STALK_CROP,
            LemongrassStalkCropBlock::new, BlockBehaviour.Properties.of()
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .strength(0.2F)
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEMONGRASS_LEAF_CROP = registerBlock(UDBlockIds.LEMONGRASS_LEAF_CROP,
            LemongrassLeafCropBlock::new, BlockBehaviour.Properties.of()
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP)
                    .pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> GLASS_CUP_HALO_HALO = registerBlock(UDBlockItemIds.GLASS_CUP_HALO_HALO,
            (properties) -> new GlassCupBlock(() -> UbesDelightItems.HALO_HALO.get(), properties),  BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(value -> 4));
    public static final Supplier<Block> GLASS_CUP_MILK_TEA_UBE = registerBlock(UDBlockItemIds.GLASS_CUP_MILK_TEA_UBE,
            (properties) -> new GlassCupBlock(() -> UbesDelightItems.MILK_TEA_UBE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));

    public static final Supplier<Block> UBE_CAKE = registerBlock(UDBlockItemIds.UBE_CAKE,
            (properties) -> new UbesDelightCakeBlock(() -> UbesDelightItems.UBE_CAKE_SLICE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> LECHE_FLAN_FEAST = registerBlock(UDBlockItemIds.LECHE_FLAN_FEAST,
            (properties) -> new LecheFlanFeastBlock(() -> UbesDelightItems.LECHE_FLAN.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> HALO_HALO_FEAST = registerBlock(UDBlockItemIds.HALO_HALO_FEAST,
            (properties) -> new HaloHaloFeastBlock(() -> UbesDelightItems.HALO_HALO.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0f).sound(SoundType.GLASS).lightLevel(value -> 10));
    public static final Supplier<Block> MILK_TEA_UBE_FEAST = registerBlock(UDBlockItemIds.MILK_TEA_UBE_FEAST,
            (properties) -> new DrinkableFeastBlock(() -> UbesDelightItems.MILK_TEA_UBE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0f).sound(SoundType.GLASS));

    public static final Supplier<Block> LEAF_FEAST = registerBlock(UDBlockItemIds.LEAF_FEAST,
            BaseLeafFeastBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> UNIVERSAL_LEAF_FEAST = registerBlock(UDBlockIds.UNIVERSAL_LEAF_FEAST,
            UniversalLeafFeastBlock::new, BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LUMPIA_FEAST = registerBlock(UDBlockItemIds.LUMPIA_FEAST,
            (properties) -> new LumpiaLeafFeastBlock(() -> UbesDelightItems.LUMPIA.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA = registerBlock(UDBlockItemIds.LEAF_FEAST_ENSAYMADA,
            (properties) -> new EnsaymadaLeafFeastBlock(() -> UbesDelightItems.ENSAYMADA.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_ENSAYMADA_UBE = registerBlock(UDBlockItemIds.LEAF_FEAST_ENSAYMADA_UBE,
            (properties) -> new EnsaymadaLeafFeastBlock(() -> UbesDelightItems.ENSAYMADA_UBE.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_PANDESAL = registerBlock(UDBlockItemIds.LEAF_FEAST_PANDESAL,
            (properties) -> new PandesalLeafFeastBlock(() -> UbesDelightItems.PANDESAL.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_PANDESAL_UBE = registerBlock(UDBlockItemIds.LEAF_FEAST_PANDESAL_UBE,
            (properties) -> new PandesalLeafFeastBlock(() -> UbesDelightItems.PANDESAL_UBE.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_HOPIA_MUNGGO = registerBlock(UDBlockItemIds.LEAF_FEAST_HOPIA_MUNGGO,
            (properties) -> new HopiaLeafFeastBlock(() -> UbesDelightItems.HOPIA_MUNGGO.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_HOPIA_UBE = registerBlock(UDBlockItemIds.LEAF_FEAST_HOPIA_UBE,
            (properties) -> new HopiaLeafFeastBlock(() -> UbesDelightItems.HOPIA_UBE.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    public static final Supplier<Block> LEAF_FEAST_COOKED_RICE = registerBlock(UDBlockItemIds.LEAF_FEAST_COOKED_RICE,
            (properties) -> new RiceLeafFeastBlock(() -> BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("farmersdelight", "cooked_rice")).get().value(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_FRIED_RICE = registerBlock(UDBlockItemIds.LEAF_FEAST_FRIED_RICE,
            (properties) -> new RiceLeafFeastBlock(() -> BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("farmersdelight", "fried_rice")).get().value(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));
    public static final Supplier<Block> LEAF_FEAST_SINANGAG = registerBlock(UDBlockItemIds.LEAF_FEAST_SINANGAG,
            (properties) -> new RiceLeafFeastBlock(() -> UbesDelightItems.SINANGAG.get(), properties), BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instrument(NoteBlockInstrument.GUITAR).strength(0.8F).sound(SoundType.AZALEA).pushReaction(PushReaction.DESTROY));

    private static Supplier<Block> registerBlock(final ResourceKey<Block> key, final Function<BlockBehaviour.Properties, Block> function, final BlockBehaviour.Properties properties) {
        return registerBlock(key.identifier(), function, properties);
    }

    private static Supplier<Block> registerBlock(final BlockItemId id, final Function<BlockBehaviour.Properties, Block> function, final BlockBehaviour.Properties properties) {
        return registerBlock(id.block(), function, properties);
    }

    public static Supplier<Block> registerBlock(final Identifier identifier, final Function<BlockBehaviour.Properties, Block> function, final BlockBehaviour.Properties properties) {
        properties.setId(ResourceKey.create(Registries.BLOCK, identifier));
        Block block = function.apply(properties);
        Registry.register(BuiltInRegistries.BLOCK, identifier, block);
        return () -> block;
    }

    public static void register() {
    }
}
