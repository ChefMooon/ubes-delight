package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.block.*;
import chefmooon.ubesdelight.common.block.leaf_feast.base.LeafFeastBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import chefmooon.ubesdelight.common.core.LeafFeastTypes;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.utility.TextUtils;
import chefmooon.ubesdelight.data.utility.UbesDelightModels;
import chefmooon.ubesdelight.data.utility.UbesDelightTextureSlots;
import com.mojang.math.Quadrant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.List;

public class BlockModelGenerator {
    private static BlockModelGenerators GENERATOR;
    public static void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        GENERATOR = blockStateModelGenerator;

        registerCrateBlock(UbesDelightBlocks.UBE_CRATE.get(), blockStateModelGenerator);
        registerCrateBlock(UbesDelightBlocks.GARLIC_CRATE.get(), blockStateModelGenerator);
        registerCrateBlock(UbesDelightBlocks.GINGER_CRATE.get(), blockStateModelGenerator);
        registerCrateBlock(UbesDelightBlocks.LEMONGRASS_CRATE.get(), blockStateModelGenerator);

        registerFlowerPotPlant(UbesDelightBlocks.WILD_UBE.get(), UbesDelightBlocks.POTTED_UBE.get(), blockStateModelGenerator);
        registerFlowerPotPlant(UbesDelightBlocks.WILD_GARLIC.get(), UbesDelightBlocks.POTTED_GARLIC.get(), blockStateModelGenerator);
        registerFlowerPotPlant(UbesDelightBlocks.WILD_GINGER.get(), UbesDelightBlocks.POTTED_GINGER.get(), blockStateModelGenerator);
        registerDoublePlant(UbesDelightBlocks.WILD_LEMONGRASS.get(), blockStateModelGenerator);

        Identifier UBE_STAGE0_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocks.UBE_CROP.get(), "_stage0");
        Identifier UBE_STAGE0 = UbesDelightModels.TEMPLATE_ODD_CROP.create(UBE_STAGE0_LOCATION,
                TextureMapping.singleSlot(UbesDelightTextureSlots.ODD_CROP, new Material(UBE_STAGE0_LOCATION)),
                blockStateModelGenerator.modelOutput);
        Identifier UBE_STAGE1_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocks.UBE_CROP.get(), "_stage1");
        Identifier UBE_STAGE1 = UbesDelightModels.TEMPLATE_ODD_CROP.create(UBE_STAGE1_LOCATION,
                TextureMapping.singleSlot(UbesDelightTextureSlots.ODD_CROP, new Material(UBE_STAGE1_LOCATION)),
                blockStateModelGenerator.modelOutput);
        Identifier UBE_STAGE2_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocks.UBE_CROP.get(), "_stage2");
        Identifier UBE_STAGE2 = UbesDelightModels.TEMPLATE_ODD_CROP.create(UBE_STAGE2_LOCATION,
                TextureMapping.singleSlot(UbesDelightTextureSlots.ODD_CROP, new Material(UBE_STAGE2_LOCATION)),
                blockStateModelGenerator.modelOutput);
        Identifier UBE_STAGE3_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocks.UBE_CROP.get(), "_stage3");
        Identifier UBE_STAGE3 = UbesDelightModels.TEMPLATE_ODD_CROP.create(UBE_STAGE3_LOCATION,
                TextureMapping.singleSlot(UbesDelightTextureSlots.ODD_CROP, new Material(UBE_STAGE3_LOCATION)),
                blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(UbesDelightBlocks.UBE_CROP.get())
                .with(PropertyDispatch.initial(UbeCropBlock.AGE)
                        .select(0, BlockModelGenerators.plainVariant(UBE_STAGE0))
                        .select(1, BlockModelGenerators.plainVariant(UBE_STAGE0))
                        .select(2, BlockModelGenerators.plainVariant(UBE_STAGE1))
                        .select(3, BlockModelGenerators.plainVariant(UBE_STAGE1))
                        .select(4, BlockModelGenerators.plainVariant(UBE_STAGE2))
                        .select(5, BlockModelGenerators.plainVariant(UBE_STAGE2))
                        .select(6, BlockModelGenerators.plainVariant(UBE_STAGE2))
                        .select(7, BlockModelGenerators.plainVariant(UBE_STAGE3))
                ));

        Identifier GARLIC_STAGE0 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage0"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage0_v1")))
                        .put(UbesDelightTextureSlots.CROSS_V2, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage0_v2"))),
                blockStateModelGenerator.modelOutput);
        Identifier GARLIC_STAGE1 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage1"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage1_v1")))
                        .put(UbesDelightTextureSlots.CROSS_V2, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage1_v2"))),
                blockStateModelGenerator.modelOutput);
        Identifier GARLIC_STAGE2 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage2"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage2_v1")))
                        .put(UbesDelightTextureSlots.CROSS_V2, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage2_v2"))),
                blockStateModelGenerator.modelOutput);
        Identifier GARLIC_STAGE3 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage3"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage3_v1")))
                        .put(UbesDelightTextureSlots.CROSS_V2, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GARLIC_CROP.get(), "_stage3_v2"))),
                blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(UbesDelightBlocks.GARLIC_CROP.get())
                .with(PropertyDispatch.initial(GarlicCropBlock.AGE)
                        .select(0, BlockModelGenerators.plainVariant(GARLIC_STAGE0))
                        .select(1, BlockModelGenerators.plainVariant(GARLIC_STAGE0))
                        .select(2, BlockModelGenerators.plainVariant(GARLIC_STAGE1))
                        .select(3, BlockModelGenerators.plainVariant(GARLIC_STAGE1))
                        .select(4, BlockModelGenerators.plainVariant(GARLIC_STAGE2))
                        .select(5, BlockModelGenerators.plainVariant(GARLIC_STAGE2))
                        .select(6, BlockModelGenerators.plainVariant(GARLIC_STAGE2))
                        .select(7, BlockModelGenerators.plainVariant(GARLIC_STAGE3))
                ));

        Identifier GINGER_STAGE0 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage0"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage0_v1")))
                        .put(UbesDelightTextureSlots.CROSS_V2, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage0_v2"))),
                blockStateModelGenerator.modelOutput);
        Identifier GINGER_STAGE1 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage1"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage1_v1")))
                        .put(UbesDelightTextureSlots.CROSS_V2, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage1_v2"))),
                blockStateModelGenerator.modelOutput);
        Identifier GINGER_STAGE2 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage2"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage2_v1")))
                        .put(UbesDelightTextureSlots.CROSS_V2, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage2_v2"))),
                blockStateModelGenerator.modelOutput);
        Identifier GINGER_STAGE3 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage3"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage3_v1")))
                        .put(UbesDelightTextureSlots.CROSS_V2, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.GINGER_CROP.get(), "_stage3_v2"))),
                blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(UbesDelightBlocks.GINGER_CROP.get())
                .with(PropertyDispatch.initial(GingerCropBlock.AGE)
                        .select(0, BlockModelGenerators.plainVariant(GINGER_STAGE0))
                        .select(1, BlockModelGenerators.plainVariant(GINGER_STAGE0))
                        .select(2, BlockModelGenerators.plainVariant(GINGER_STAGE1))
                        .select(3, BlockModelGenerators.plainVariant(GINGER_STAGE1))
                        .select(4, BlockModelGenerators.plainVariant(GINGER_STAGE2))
                        .select(5, BlockModelGenerators.plainVariant(GINGER_STAGE2))
                        .select(6, BlockModelGenerators.plainVariant(GINGER_STAGE2))
                        .select(7, BlockModelGenerators.plainVariant(GINGER_STAGE3))
                ));

        Identifier LEMONGRASS_STAGE0 = UbesDelightModels.TEMPLATE_CROP_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), "_stage0"),
                TextureMapping.singleSlot(TextureSlot.CROSS, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), "_stage0"))), blockStateModelGenerator.modelOutput);
        Identifier LEMONGRASS_STAGE1 = UbesDelightModels.TEMPLATE_CROP_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), "_stage1"),
                TextureMapping.singleSlot(TextureSlot.CROSS, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), "_stage1"))), blockStateModelGenerator.modelOutput);
        Identifier LEMONGRASS_STAGE2 = UbesDelightModels.TEMPLATE_CROP_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), "_stage2"),
                TextureMapping.singleSlot(TextureSlot.CROSS, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), "_stage2"))), blockStateModelGenerator.modelOutput);
        Identifier LEMONGRASS_STAGE3 = UbesDelightModels.TEMPLATE_CROP_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), "_stage3"),
                TextureMapping.singleSlot(TextureSlot.CROSS, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), "_stage3"))), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get())
                .with(PropertyDispatch.initial(LemongrassLeafCropBlock.lEMONGRASS_AGE)
                        .select(0, BlockModelGenerators.plainVariant(LEMONGRASS_STAGE0))
                        .select(1, BlockModelGenerators.plainVariant(LEMONGRASS_STAGE1))
                        .select(2, BlockModelGenerators.plainVariant(LEMONGRASS_STAGE2))
                        .select(3, BlockModelGenerators.plainVariant(LEMONGRASS_STAGE3))
                ));

        Identifier LEMONGRASS_STALK_STAGE0_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), "_stage0");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE0_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, new Material(LEMONGRASS_STALK_STAGE0_LOCATION)), blockStateModelGenerator.modelOutput);
        Identifier LEMONGRASS_STALK_STAGE1_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), "_stage1");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE1_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, new Material(LEMONGRASS_STALK_STAGE1_LOCATION)), blockStateModelGenerator.modelOutput);
        Identifier LEMONGRASS_STALK_STAGE2_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), "_stage2");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE2_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, new Material(LEMONGRASS_STALK_STAGE2_LOCATION)), blockStateModelGenerator.modelOutput);
        Identifier LEMONGRASS_STALK_STAGE3_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), "_stage3");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE3_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, new Material(LEMONGRASS_STALK_STAGE3_LOCATION)), blockStateModelGenerator.modelOutput);
        Identifier LEMONGRASS_STALK_STAGE4_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), "_stage4");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE4_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, new Material(LEMONGRASS_STALK_STAGE4_LOCATION)), blockStateModelGenerator.modelOutput);
        Identifier LEMONGRASS_STALK_STAGE5_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), "_stage5");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE5_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, new Material(LEMONGRASS_STALK_STAGE5_LOCATION)), blockStateModelGenerator.modelOutput);
        Identifier LEMONGRASS_STALK_SUPPORTING_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), "_supporting");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_SUPPORTING_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, new Material(LEMONGRASS_STALK_SUPPORTING_LOCATION)), blockStateModelGenerator.modelOutput);

        TextureMapping textureMapKalan = TextureMapping.singleSlot(TextureSlot.SIDE, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.KALAN.get(), "_side")))
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(UbesDelightBlocks.KALAN.get(), "_bottom"))
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(UbesDelightBlocks.KALAN.get(), "_top"));
        TextureMapping textureMapKalanOn = TextureMapping.singleSlot(TextureSlot.SIDE, new Material(ModelLocationUtils.getModelLocation(UbesDelightBlocks.KALAN.get(), "_side_on")))
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(UbesDelightBlocks.KALAN.get(), "_bottom"))
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(UbesDelightBlocks.KALAN.get(), "_top_on"));
        Identifier kalan = ModelTemplates.CUBE_BOTTOM_TOP.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.KALAN.get()), textureMapKalan, blockStateModelGenerator.modelOutput);
        Identifier kalan_on = ModelTemplates.CUBE_BOTTOM_TOP.create(ModelLocationUtils.getModelLocation(UbesDelightBlocks.KALAN.get(), "_on"), textureMapKalanOn, blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(UbesDelightBlocks.KALAN.get())
                .with(BlockModelGenerators.createBooleanModelDispatch(KalanBlock.LIT, BlockModelGenerators.plainVariant(kalan_on), BlockModelGenerators.plainVariant(kalan)))
                .with(createHorizontalFacingDispatch())
        );

        registerBasicRotationBlockState(UbesDelightBlocks.BAKING_MAT_BAMBOO.get(), blockStateModelGenerator);

        registerBasicCake(UbesDelightBlocks.UBE_CAKE.get(), blockStateModelGenerator);
        registerSmallCake(UbesDelightBlocks.LECHE_FLAN_FEAST.get(), blockStateModelGenerator);

//        Old Lumpia Feast
//        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(UbesDelightBlocks.LUMPIA_FEAST)
//                .with(createHorizontalFacingDispatch())
//                .with(PropertyDispatch.property(LumpiaFeastBlock.SERVINGS)
//                        .select(0, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/banana_leaf_plate")))
//                        .select(1, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(UbesDelightBlocks.LUMPIA_FEAST, "_stage2")))
//                        .select(2, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(UbesDelightBlocks.LUMPIA_FEAST, "_stage1")))
//                        .select(3, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(UbesDelightBlocks.LUMPIA_FEAST, "_stage0")))
//                ));
        registerLumpiaLeafFeast();

        registerDrinkFeast(UbesDelightBlocks.MILK_TEA_UBE_FEAST.get(), blockStateModelGenerator);
        registerDrinkFeast(UbesDelightBlocks.HALO_HALO_FEAST.get(), blockStateModelGenerator);

        registerGlassCup(UbesDelightBlocks.GLASS_CUP_HALO_HALO.get(), blockStateModelGenerator);
        registerGlassCup(UbesDelightBlocks.GLASS_CUP_MILK_TEA_UBE.get(), blockStateModelGenerator);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(UbesDelightBlocks.LEAF_FEAST.get())
                .with(PropertyDispatch.initial(LeafFeastBlock.LEAF_FEAST_TYPE)
                        .select(LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(TextUtils.res("block/leaf_feast")))
                        .select(LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(TextUtils.res("block/leaf_feast_tip")))
                        .select(LeafFeastTypes.END, BlockModelGenerators.plainVariant(TextUtils.res("block/leaf_feast_end")))
                        .select(LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(TextUtils.res("block/leaf_feast_middle"))))
                .with(createHorizontalFacingDispatch())
        );

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(UbesDelightBlocks.UNIVERSAL_LEAF_FEAST.get())
                .with(PropertyDispatch.initial(LeafFeastBlock.LEAF_FEAST_TYPE)
                        .select(LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(TextUtils.res("block/leaf_feast")))
                        .select(LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(TextUtils.res("block/leaf_feast_tip")))
                        .select(LeafFeastTypes.END, BlockModelGenerators.plainVariant(TextUtils.res("block/leaf_feast_end")))
                        .select(LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(TextUtils.res("block/leaf_feast_middle"))))
                .with(createHorizontalFacingDispatch())
        );

        registerEnsaymadaLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA.get(), blockStateModelGenerator);
        registerEnsaymadaLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE.get(), blockStateModelGenerator);
        registerPandesalLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_PANDESAL.get(), blockStateModelGenerator);
        registerPandesalLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE.get(), blockStateModelGenerator);
        registerHopiaLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO.get(), blockStateModelGenerator);
        registerHopiaLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE.get(), blockStateModelGenerator);

        registerRiceLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_COOKED_RICE.get(), blockStateModelGenerator);
        registerRiceLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_FRIED_RICE.get(), blockStateModelGenerator);
        registerRiceLeafFeastVariant(UbesDelightBlocks.LEAF_FEAST_SINANGAG.get(), blockStateModelGenerator);
    }

    private static void registerCrateBlock(Block block, BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialBlock(block, TexturedModel.createDefault((trivialBlock) -> {
            return (new TextureMapping())
                    .put(TextureSlot.SIDE, new Material(Identifier.parse(ModelLocationUtils.getModelLocation(trivialBlock) + "_side")))
                    .put(TextureSlot.TOP, new Material(Identifier.parse(ModelLocationUtils.getModelLocation(trivialBlock) + "_top")))
                    .put(TextureSlot.BOTTOM, new Material(Identifier.fromNamespaceAndPath("farmersdelight", "block/crate_bottom")));
                }, ModelTemplates.CUBE_BOTTOM_TOP)
        );
//        blockStateModelGenerator.createTrivialBlock(block,
//                (new TextureMapping())
//                        .put(TextureSlot.SIDE, Identifier.parse(ModelLocationUtils.getModelLocation(block) + "_side"))
//                        .put(TextureSlot.TOP, Identifier.parse(ModelLocationUtils.getModelLocation(block) + "_top"))
//                        .put(TextureSlot.BOTTOM, Identifier.fromNamespaceAndPath("farmersdelight", "block/crate_bottom")),
//                ModelTemplates.CUBE_BOTTOM_TOP);
    }

    private static void registerBasicRotationBlockState(Block block, BlockModelGenerators blockStateModelGenerator) {
        Identifier resourceLocation = ModelLocationUtils.getModelLocation(block);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block,
                        BlockModelGenerators.plainVariant(resourceLocation))
                .with(createHorizontalFacingDispatch()));
    }

    private static void registerDrinkFeast(Block block, BlockModelGenerators blockStateModelGenerator) {
        Material punchBowl = new Material(TextUtils.res("block/punch_bowl"));
        TextureMapping textureMapping = TextureMapping.particle(punchBowl)
                .put(UbesDelightTextureSlots.DRINK_FEAST_INSIDE, TextureMapping.getBlockTexture(block))
                .put(UbesDelightTextureSlots.PUNCH_BOWL, punchBowl);
        UbesDelightModels.TEMPLATE_DRINK_FEAST_LEFTOVER.create(Identifier.parse(ModelLocationUtils.getModelLocation(block) + "_leftover"),
                textureMapping, blockStateModelGenerator.modelOutput);

        List<ModelTemplate> stages = List.of(
                UbesDelightModels.TEMPLATE_DRINK_FEAST_STAGE0,
                UbesDelightModels.TEMPLATE_DRINK_FEAST_STAGE1,
                UbesDelightModels.TEMPLATE_DRINK_FEAST_STAGE2,
                UbesDelightModels.TEMPLATE_DRINK_FEAST_STAGE3);
        for (int i = 0; i < stages.size(); i++) {
            TextureMapping textureMappingstage = TextureMapping.particle(punchBowl)
                    .put(UbesDelightTextureSlots.DRINK_FEAST_INSIDE, TextureMapping.getBlockTexture(block))
                    .put(UbesDelightTextureSlots.PUNCH_BOWL, punchBowl);
            stages.get(i).create(Identifier.parse(ModelLocationUtils.getModelLocation(block) + "_stage" + i),
                    textureMappingstage, blockStateModelGenerator.modelOutput);
        }

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(DrinkableFeastBlock.SERVINGS)
                        .select(0, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_leftover")))
                        .select(1, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_stage3")))
                        .select(2, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_stage2")))
                        .select(3, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_stage1")))
                        .select(4, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_stage0"))))
                .with(createHorizontalFacingDispatch())
        );
    }

    private static void registerBasicCake(Block block, BlockModelGenerators blockStateModelGenerator){
        TextureMapping CAKE_MAP = TextureMapping.particle(new Material(ModelLocationUtils.getModelLocation(block, "_side")))
                .put(TextureSlot.BOTTOM, new Material(ModelLocationUtils.getModelLocation(block, "_bottom")))
                .put(TextureSlot.TOP, new Material(ModelLocationUtils.getModelLocation(block, "_top")))
                .put(TextureSlot.SIDE, new Material(ModelLocationUtils.getModelLocation(block, "_side")));
        UbesDelightModels.TEMPLATE_CAKE.create(block, CAKE_MAP, blockStateModelGenerator.modelOutput);

        List<ModelTemplate> CAKE_SLICE_MODELS = List.of(UbesDelightModels.TEMPLATE_CAKE_SLICE1, UbesDelightModels.TEMPLATE_CAKE_SLICE2, UbesDelightModels.TEMPLATE_CAKE_SLICE3,
                UbesDelightModels.TEMPLATE_CAKE_SLICE4, UbesDelightModels.TEMPLATE_CAKE_SLICE5, UbesDelightModels.TEMPLATE_CAKE_SLICE6);

        for (int i = 0; i < CAKE_SLICE_MODELS.size(); i++) {
            TextureMapping CAKE_SLICE_MAP = TextureMapping.particle(new Material(ModelLocationUtils.getModelLocation(block, "_side")))
                    .put(TextureSlot.BOTTOM, new Material(ModelLocationUtils.getModelLocation(block, "_bottom")))
                    .put(TextureSlot.TOP, new Material(ModelLocationUtils.getModelLocation(block, "_top")))
                    .put(TextureSlot.SIDE, new Material(ModelLocationUtils.getModelLocation(block, "_side")))
                    .put(TextureSlot.INSIDE, new Material(ModelLocationUtils.getModelLocation(block, "_inner")));
            CAKE_SLICE_MODELS.get(i).create(ModelLocationUtils.getModelLocation(block, "_slice" + (i+1)), CAKE_SLICE_MAP, blockStateModelGenerator.modelOutput);
        }

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(UbesDelightCakeBlock.BITES)
                        .select(0, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block)))
                        .select(1, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice1")))
                        .select(2, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice2")))
                        .select(3, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice3")))
                        .select(4, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice4")))
                        .select(5, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice5")))
                        .select(6, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_slice6")))
                ));
    }

    private static void registerSmallCake(Block block, BlockModelGenerators blockStateModelGenerator){
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(LecheFlanFeastBlock.BITES)
                        .select(0, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block)))
                        .select(1, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_bite1")))
                        .select(2, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_bite2")))
                        .select(3, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_bite3")))
                        .select(4, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block, "_bite4")))
                ));
    }

    private static void registerFlowerPotPlant(Block plant, Block pottedPlant, BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleFlatItemModel(plant);
        Identifier resourceLocation = UbesDelightModels.TEMPLATE_CROP_CROSS.create(plant, TextureMapping.cross(plant), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(plant, BlockModelGenerators.plainVariant(resourceLocation)));
        Identifier resourceLocation2 = UbesDelightModels.TEMPLATE_POTTED_FLOWER.create(pottedPlant, TextureMapping.plant(plant), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pottedPlant, BlockModelGenerators.plainVariant(resourceLocation2)));
    }

    private static void registerDoublePlant(Block plant, BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleFlatItemModel(plant, "_top");
        Identifier resourceLocation = UbesDelightModels.TEMPLATE_CROP_CROSS.createWithSuffix(plant, "_top", TextureMapping.cross(new Material(ModelLocationUtils.getModelLocation(plant, "_top"))), blockStateModelGenerator.modelOutput);
        Identifier resourceLocation2 = UbesDelightModels.TEMPLATE_CROP_CROSS.createWithSuffix(plant, "_bottom", TextureMapping.cross(new Material(ModelLocationUtils.getModelLocation(plant, "_bottom"))), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.createDoubleBlock(plant, BlockModelGenerators.plainVariant(resourceLocation), BlockModelGenerators.plainVariant(resourceLocation2));
    }

    private static void registerGlassCup(Block block, BlockModelGenerators blockModelGenerators) {
        Identifier blockLocation = ModelLocationUtils.getModelLocation(block);
        Material cupLocation = new Material(TextUtils.res("block/glass_cup"));
        TextureMapping textureMapping = TextureMapping.singleSlot(UbesDelightTextureSlots.CUP, cupLocation)
                .put(UbesDelightTextureSlots.INSIDE, new Material(blockLocation));
        Identifier TEMPLATE_GLASS_CUP_1_LOCATION = blockLocation.withSuffix("_servings1");
        UbesDelightModels.TEMPLATE_GLASS_CUP_1.create(TEMPLATE_GLASS_CUP_1_LOCATION, textureMapping, blockModelGenerators.modelOutput);
        Identifier TEMPLATE_GLASS_CUP_2_LOCATION = blockLocation.withSuffix("_servings2");
        UbesDelightModels.TEMPLATE_GLASS_CUP_2.create(TEMPLATE_GLASS_CUP_2_LOCATION, textureMapping, blockModelGenerators.modelOutput);
        Identifier TEMPLATE_GLASS_CUP_3_LOCATION = blockLocation.withSuffix("_servings3");
        UbesDelightModels.TEMPLATE_GLASS_CUP_3.create(TEMPLATE_GLASS_CUP_3_LOCATION, textureMapping, blockModelGenerators.modelOutput);
        Identifier TEMPLATE_GLASS_CUP_4_LOCATION = blockLocation.withSuffix("_servings4");
        UbesDelightModels.TEMPLATE_GLASS_CUP_4.create(TEMPLATE_GLASS_CUP_4_LOCATION, textureMapping, blockModelGenerators.modelOutput);

        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(GlassCupBlock.SERVINGS)
                        .select(0, BlockModelGenerators.plainVariant(TEMPLATE_GLASS_CUP_1_LOCATION))
                        .select(1, BlockModelGenerators.plainVariant(TEMPLATE_GLASS_CUP_2_LOCATION))
                        .select(2, BlockModelGenerators.plainVariant(TEMPLATE_GLASS_CUP_3_LOCATION))
                        .select(3, BlockModelGenerators.plainVariant(TEMPLATE_GLASS_CUP_4_LOCATION)))
                .with(createHorizontalFacingDispatch())
        );
    }

    private static void registerEnsaymadaLeafFeastVariant(Block block, BlockModelGenerators blockStateModelGenerator) {
        registerBreadLeafFeastVariant(block,
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_3,
                        UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_4, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_5, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_6},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_TIP_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_TIP_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_TIP_3},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_END_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_END_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_END_3},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_3,
                        UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_4, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_5, UbesDelightModels.TEMPLATE_LEAF_FEAST_ENSAYMADA_MIDDLE_6},
                blockStateModelGenerator);
    }

    private static void registerPandesalLeafFeastVariant(Block block, BlockModelGenerators blockStateModelGenerator) {
        registerBreadLeafFeastVariant(block,
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_3,
                        UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_4, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_5, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_6},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_TIP_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_TIP_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_TIP_3},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_END_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_END_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_END_3},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_3,
                        UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_4, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_5, UbesDelightModels.TEMPLATE_LEAF_FEAST_PANDESAL_MIDDLE_6},
                blockStateModelGenerator);
    }

    private static void registerHopiaLeafFeastVariant(Block block, BlockModelGenerators blockStateModelGenerator) {
        registerBreadLeafFeastVariant(block,
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_3,
                        UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_4, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_5, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_6},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_TIP_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_TIP_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_TIP_3},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_END_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_END_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_END_3},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_3,
                        UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_4, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_5, UbesDelightModels.TEMPLATE_LEAF_FEAST_HOPIA_MIDDLE_6},
                blockStateModelGenerator);
    }

    private static void registerRiceLeafFeastVariant(Block block, BlockModelGenerators blockStateModelGenerator) {
        registerBreadLeafFeastVariant(block,
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_3,
                        UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_4, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_5, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_6},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_TIP_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_TIP_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_TIP_3},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_END_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_END_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_END_3},
                new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_MIDDLE_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_MIDDLE_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_MIDDLE_3,
                        UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_MIDDLE_4, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_MIDDLE_5, UbesDelightModels.TEMPLATE_LEAF_FEAST_RICE_MIDDLE_6},
                blockStateModelGenerator);
    }

    private static void registerLumpiaLeafFeast() {
        ModelTemplate[] modelTemplateBase = new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_LUMPIA_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_LUMPIA_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_LUMPIA_3};
        ModelTemplate[] modelTemplateMiddle = new ModelTemplate[]{UbesDelightModels.TEMPLATE_LEAF_FEAST_LUMPIA_MIDDLE_1, UbesDelightModels.TEMPLATE_LEAF_FEAST_LUMPIA_MIDDLE_2, UbesDelightModels.TEMPLATE_LEAF_FEAST_LUMPIA_MIDDLE_3};

        Block block = UbesDelightBlocks.LUMPIA_FEAST.get();
        Identifier location = TextUtils.res("block/leaf_feast/" + ModelLocationUtils.getModelLocation(block).getPath().replace("block/", "leaf_feast_"));
        Identifier baseLocation = location.withSuffix("_base");
        Identifier middleLocation = location.withSuffix("_middle");

        Material contentTextureLocation = new Material(TextUtils.res(ModelLocationUtils.getModelLocation(block).getPath().replace("leaf_feast_", "")));
        Material contentTextureLocationAlt = new Material(TextUtils.res(ModelLocationUtils.getModelLocation(block).getPath().replace("leaf_feast_", "")).withSuffix("_alt"));

        TextureMapping baseTextureMap = new TextureMapping()
                .put(TextureSlot.TOP, new Material(TextUtils.res("block/leaf_feast_top")))
                .put(TextureSlot.BOTTOM, new Material(TextUtils.res("block/leaf_feast_bottom")))
                .put(TextureSlot.CONTENT, contentTextureLocation)
                .put(UbesDelightTextureSlots.CONTENT_ALT, contentTextureLocationAlt);

        for (int i = 0; i < 3;i++) {
            modelTemplateBase[i].create(baseLocation.withSuffix("_" + (i + 1)), baseTextureMap, GENERATOR.modelOutput);
            modelTemplateMiddle[i].create(middleLocation.withSuffix("_" + (i + 1)), baseTextureMap, GENERATOR.modelOutput);
        }

        GENERATOR.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(SimpleLeafFeastBlock.SERVINGS, SimpleLeafFeastBlock.LEAF_FEAST_TYPE)
                        .select(1, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.END, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_1")))
                        .select(2, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.END, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_2")))
                        .select(3, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.END, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.END, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.END, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.END, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_3")))
                )
                .with(createHorizontalFacingDispatch())
        );
    }

    private static void registerBreadLeafFeastVariant(Block block, ModelTemplate[] modelTemplateBase, ModelTemplate[] modelTemplateTip, ModelTemplate[] modelTemplateEnd, ModelTemplate[] modelTemplateMiddle, BlockModelGenerators blockStateModelGenerator) {
        Identifier location = TextUtils.res("block/leaf_feast/" + ModelLocationUtils.getModelLocation(block).getPath().replace("block/", ""));
        Identifier baseLocation = location.withSuffix("_base");
        Identifier middleLocation = location.withSuffix("_middle");
        Identifier tipLocation = location.withSuffix("_tip");
        Identifier endLocation = location.withSuffix("_end");

        Material contentTextureLocation = new Material(TextUtils.res(ModelLocationUtils.getModelLocation(block).getPath().replace("leaf_feast_", "").replace("_half", "")));

        TextureMapping baseTextureMap = new TextureMapping()
                .put(TextureSlot.TOP, new Material(TextUtils.res("block/leaf_feast_top")))
                .put(TextureSlot.BOTTOM, new Material(TextUtils.res("block/leaf_feast_bottom")))
                .put(TextureSlot.CONTENT, contentTextureLocation);

        TextureMapping tipTextureMap = new TextureMapping()
                .put(TextureSlot.TOP, new Material(TextUtils.res("block/leaf_feast_tip_top")))
                .put(TextureSlot.BOTTOM, new Material(TextUtils.res("block/leaf_feast_tip_bottom")))
                .put(TextureSlot.CONTENT, contentTextureLocation);

        TextureMapping endTextureMap =  new TextureMapping()
                .put(TextureSlot.TOP, new Material(TextUtils.res("block/leaf_feast_end_top")))
                .put(TextureSlot.BOTTOM, new Material(TextUtils.res("block/leaf_feast_end_bottom")))
                .put(TextureSlot.CONTENT, contentTextureLocation);

        for (int i = 0; i < 6;i++) {
            modelTemplateBase[i].create(baseLocation.withSuffix("_" + (i + 1)), baseTextureMap, GENERATOR.modelOutput);
            modelTemplateMiddle[i].create(middleLocation.withSuffix("_" + (i + 1)), baseTextureMap, GENERATOR.modelOutput);
        }
        for (int j = 0; j < 3;j++) {
            modelTemplateTip[j].create(tipLocation.withSuffix("_" + (j + 1)), tipTextureMap, GENERATOR.modelOutput);
            modelTemplateEnd[j].create(endLocation.withSuffix("_" + (j + 1)), endTextureMap, GENERATOR.modelOutput);
        }

        GENERATOR.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(SimpleLeafFeastBlock.SERVINGS, SimpleLeafFeastBlock.LEAF_FEAST_TYPE)
                        .select(1, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(tipLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.END, BlockModelGenerators.plainVariant(endLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_1")))
                        .select(2, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(tipLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.END, BlockModelGenerators.plainVariant(endLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_2")))
                        .select(3, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(tipLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.END, BlockModelGenerators.plainVariant(endLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_4")))
                        .select(4, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(tipLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.END, BlockModelGenerators.plainVariant(endLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_4")))
                        .select(5, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_5")))
                        .select(5, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(tipLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.END, BlockModelGenerators.plainVariant(endLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_5")))
                        .select(6, LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(baseLocation.withSuffix("_6")))
                        .select(6, LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(tipLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.END, BlockModelGenerators.plainVariant(endLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(middleLocation.withSuffix("_6")))
                )
                .with(createHorizontalFacingDispatch())
        );
    }

    private static void registerLeafFeastVariant(Block block, ModelTemplate modelTemplateBase, ModelTemplate modelTemplateTip, ModelTemplate modelTemplateEnd, ModelTemplate modelTemplateMiddle, BlockModelGenerators blockStateModelGenerator) {
        Identifier templateLeafFeast = modelTemplateBase.create(block,
                new TextureMapping()
                        .put(TextureSlot.LAYER0, new Material(TextUtils.res("block/leaf_feast_top")))
                        .put(TextureSlot.LAYER1, new Material(TextUtils.res("block/leaf_feast_bottom")))
                        .put(TextureSlot.LAYER2, new Material(TextUtils.res(ModelLocationUtils.getModelLocation(block).getPath().replace("leaf_feast_", ""))))
                        .put(TextureSlot.PARTICLE, new Material(TextUtils.res("block/leaf_feast_top"))),
                blockStateModelGenerator.modelOutput);
        Identifier templateLeafFeastTip = modelTemplateTip.createWithSuffix(block, "_tip",
                new TextureMapping()
                        .put(TextureSlot.LAYER0, new Material(TextUtils.res("block/leaf_feast_tip_top")))
                        .put(TextureSlot.LAYER1, new Material(TextUtils.res("block/leaf_feast_tip_bottom")))
                        .put(TextureSlot.LAYER2, new Material(TextUtils.res(ModelLocationUtils.getModelLocation(block).getPath().replace("leaf_feast_", ""))))
                        .put(TextureSlot.PARTICLE, new Material(TextUtils.res("block/leaf_feast_tip_top"))),
                blockStateModelGenerator.modelOutput);
        Identifier templateLeafFeastEnd = modelTemplateEnd.createWithSuffix(block, "_end",
                new TextureMapping()
                        .put(TextureSlot.LAYER0, new Material(TextUtils.res("block/leaf_feast_end_top")))
                        .put(TextureSlot.LAYER1, new Material(TextUtils.res("block/leaf_feast_end_bottom")))
                        .put(TextureSlot.LAYER2, new Material(TextUtils.res(ModelLocationUtils.getModelLocation(block).getPath().replace("leaf_feast_", ""))))
                        .put(TextureSlot.PARTICLE, new Material(TextUtils.res("block/leaf_feast_end_top"))),
                blockStateModelGenerator.modelOutput);
        Identifier templateLeafFeastMiddle = modelTemplateMiddle.createWithSuffix(block, "_middle",
                new TextureMapping()
                        .put(TextureSlot.LAYER0, new Material(TextUtils.res("block/leaf_feast_top")))
                        .put(TextureSlot.LAYER1, new Material(TextUtils.res("block/leaf_feast_bottom")))
                        .put(TextureSlot.LAYER2, new Material(TextUtils.res(ModelLocationUtils.getModelLocation(block).getPath().replace("leaf_feast_", ""))))
                        .put(TextureSlot.PARTICLE, new Material(TextUtils.res("block/leaf_feast_top"))),
                blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.registerSimpleFlatItemModel(block);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(LeafFeastBlock.LEAF_FEAST_TYPE)
                        .select(LeafFeastTypes.BASE, BlockModelGenerators.plainVariant(templateLeafFeast))
                        .select(LeafFeastTypes.TIP, BlockModelGenerators.plainVariant(templateLeafFeastTip))
                        .select(LeafFeastTypes.END, BlockModelGenerators.plainVariant(templateLeafFeastEnd))
                        .select(LeafFeastTypes.MIDDLE, BlockModelGenerators.plainVariant(templateLeafFeastMiddle)))
                .with(createHorizontalFacingDispatch())
        );
    }

    private static PropertyDispatch<VariantMutator> createHorizontalFacingDispatch() {
        return PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.EAST, VariantMutator.Y_ROT.withValue(Quadrant.R90))
                .select(Direction.SOUTH, VariantMutator.Y_ROT.withValue(Quadrant.R180))
                .select(Direction.WEST, VariantMutator.Y_ROT.withValue(Quadrant.R270))
                .select(Direction.NORTH, (variant) -> variant);
    }
}
