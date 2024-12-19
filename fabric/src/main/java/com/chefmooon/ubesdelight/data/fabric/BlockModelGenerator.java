package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.block.*;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.LeafFeastBlock;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.common.utility.fabric.UbesDelightModels;
import com.chefmooon.ubesdelight.common.utility.fabric.UbesDelightTextureSlots;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class BlockModelGenerator {
    private static BlockModelGenerators GENERATOR;
    public static void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        GENERATOR = blockStateModelGenerator;

        registerCrateBlock(UbesDelightBlocksImpl.UBE_CRATE, blockStateModelGenerator);
        registerCrateBlock(UbesDelightBlocksImpl.GARLIC_CRATE, blockStateModelGenerator);
        registerCrateBlock(UbesDelightBlocksImpl.GINGER_CRATE, blockStateModelGenerator);
        registerCrateBlock(UbesDelightBlocksImpl.LEMONGRASS_CRATE, blockStateModelGenerator);

        registerFlowerPotPlant(UbesDelightBlocksImpl.WILD_UBE, UbesDelightBlocksImpl.POTTED_UBE, blockStateModelGenerator);
        registerFlowerPotPlant(UbesDelightBlocksImpl.WILD_GARLIC, UbesDelightBlocksImpl.POTTED_GARLIC, blockStateModelGenerator);
        registerFlowerPotPlant(UbesDelightBlocksImpl.WILD_GINGER, UbesDelightBlocksImpl.POTTED_GINGER, blockStateModelGenerator);
        registerDoublePlant(UbesDelightBlocksImpl.WILD_LEMONGRASS, blockStateModelGenerator);

        ResourceLocation UBE_STAGE0_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.UBE_CROP, "_stage0");
        ResourceLocation UBE_STAGE0 = UbesDelightModels.TEMPLATE_ODD_CROP.create(UBE_STAGE0_LOCATION,
                TextureMapping.singleSlot(UbesDelightTextureSlots.ODD_CROP, UBE_STAGE0_LOCATION),
                blockStateModelGenerator.modelOutput);
        ResourceLocation UBE_STAGE1_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.UBE_CROP, "_stage1");
        ResourceLocation UBE_STAGE1 = UbesDelightModels.TEMPLATE_ODD_CROP.create(UBE_STAGE1_LOCATION,
                TextureMapping.singleSlot(UbesDelightTextureSlots.ODD_CROP, UBE_STAGE1_LOCATION),
                blockStateModelGenerator.modelOutput);
        ResourceLocation UBE_STAGE2_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.UBE_CROP, "_stage2");
        ResourceLocation UBE_STAGE2 = UbesDelightModels.TEMPLATE_ODD_CROP.create(UBE_STAGE2_LOCATION,
                TextureMapping.singleSlot(UbesDelightTextureSlots.ODD_CROP, UBE_STAGE2_LOCATION),
                blockStateModelGenerator.modelOutput);
        ResourceLocation UBE_STAGE3_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.UBE_CROP, "_stage3");
        ResourceLocation UBE_STAGE3 = UbesDelightModels.TEMPLATE_ODD_CROP.create(UBE_STAGE3_LOCATION,
                TextureMapping.singleSlot(UbesDelightTextureSlots.ODD_CROP, UBE_STAGE3_LOCATION),
                blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(UbesDelightBlocksImpl.UBE_CROP)
                .with(PropertyDispatch.property(UbeCropBlock.AGE)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, UBE_STAGE0))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, UBE_STAGE0))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, UBE_STAGE1))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, UBE_STAGE1))
                        .select(4, Variant.variant().with(VariantProperties.MODEL, UBE_STAGE2))
                        .select(5, Variant.variant().with(VariantProperties.MODEL, UBE_STAGE2))
                        .select(6, Variant.variant().with(VariantProperties.MODEL, UBE_STAGE2))
                        .select(7, Variant.variant().with(VariantProperties.MODEL, UBE_STAGE3))
                ));

        ResourceLocation GARLIC_STAGE0 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage0"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage0_v1"))
                        .put(UbesDelightTextureSlots.CROSS_V2, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage0_v2")),
                blockStateModelGenerator.modelOutput);
        ResourceLocation GARLIC_STAGE1 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage1"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage1_v1"))
                        .put(UbesDelightTextureSlots.CROSS_V2, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage1_v2")),
                blockStateModelGenerator.modelOutput);
        ResourceLocation GARLIC_STAGE2 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage2"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage2_v1"))
                        .put(UbesDelightTextureSlots.CROSS_V2, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage2_v2")),
                blockStateModelGenerator.modelOutput);
        ResourceLocation GARLIC_STAGE3 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage3"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage3_v1"))
                        .put(UbesDelightTextureSlots.CROSS_V2, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GARLIC_CROP, "_stage3_v2")),
                blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(UbesDelightBlocksImpl.GARLIC_CROP)
                .with(PropertyDispatch.property(GarlicCropBlock.AGE)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, GARLIC_STAGE0))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, GARLIC_STAGE0))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, GARLIC_STAGE1))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, GARLIC_STAGE1))
                        .select(4, Variant.variant().with(VariantProperties.MODEL, GARLIC_STAGE2))
                        .select(5, Variant.variant().with(VariantProperties.MODEL, GARLIC_STAGE2))
                        .select(6, Variant.variant().with(VariantProperties.MODEL, GARLIC_STAGE2))
                        .select(7, Variant.variant().with(VariantProperties.MODEL, GARLIC_STAGE3))
                ));

        ResourceLocation GINGER_STAGE0 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage0"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage0_v1"))
                        .put(UbesDelightTextureSlots.CROSS_V2, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage0_v2")),
                blockStateModelGenerator.modelOutput);
        ResourceLocation GINGER_STAGE1 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage1"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage1_v1"))
                        .put(UbesDelightTextureSlots.CROSS_V2, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage1_v2")),
                blockStateModelGenerator.modelOutput);
        ResourceLocation GINGER_STAGE2 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage2"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage2_v1"))
                        .put(UbesDelightTextureSlots.CROSS_V2, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage2_v2")),
                blockStateModelGenerator.modelOutput);
        ResourceLocation GINGER_STAGE3 = UbesDelightModels.TEMPLATE_COMPLEX_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage3"),
                TextureMapping.singleSlot(UbesDelightTextureSlots.CROSS_V1, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage3_v1"))
                        .put(UbesDelightTextureSlots.CROSS_V2, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.GINGER_CROP, "_stage3_v2")),
                blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(UbesDelightBlocksImpl.GINGER_CROP)
                .with(PropertyDispatch.property(GingerCropBlock.AGE)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, GINGER_STAGE0))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, GINGER_STAGE0))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, GINGER_STAGE1))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, GINGER_STAGE1))
                        .select(4, Variant.variant().with(VariantProperties.MODEL, GINGER_STAGE2))
                        .select(5, Variant.variant().with(VariantProperties.MODEL, GINGER_STAGE2))
                        .select(6, Variant.variant().with(VariantProperties.MODEL, GINGER_STAGE2))
                        .select(7, Variant.variant().with(VariantProperties.MODEL, GINGER_STAGE3))
                ));

        ResourceLocation LEMONGRASS_STAGE0 = UbesDelightModels.TEMPLATE_CROP_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_CROP, "_stage0"),
                TextureMapping.singleSlot(TextureSlot.CROSS, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_CROP, "_stage0")), blockStateModelGenerator.modelOutput);
        ResourceLocation LEMONGRASS_STAGE1 = UbesDelightModels.TEMPLATE_CROP_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_CROP, "_stage1"),
                TextureMapping.singleSlot(TextureSlot.CROSS, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_CROP, "_stage1")), blockStateModelGenerator.modelOutput);
        ResourceLocation LEMONGRASS_STAGE2 = UbesDelightModels.TEMPLATE_CROP_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_CROP, "_stage2"),
                TextureMapping.singleSlot(TextureSlot.CROSS, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_CROP, "_stage2")), blockStateModelGenerator.modelOutput);
        ResourceLocation LEMONGRASS_STAGE3 = UbesDelightModels.TEMPLATE_CROP_CROSS.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_CROP, "_stage3"),
                TextureMapping.singleSlot(TextureSlot.CROSS, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_CROP, "_stage3")), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP)
                .with(PropertyDispatch.property(LemongrassLeafCropBlock.lEMONGRASS_AGE)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, LEMONGRASS_STAGE0))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, LEMONGRASS_STAGE1))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, LEMONGRASS_STAGE2))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, LEMONGRASS_STAGE3))
                ));

        ResourceLocation LEMONGRASS_STALK_STAGE0_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP, "_stage0");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE0_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, LEMONGRASS_STALK_STAGE0_LOCATION), blockStateModelGenerator.modelOutput);
        ResourceLocation LEMONGRASS_STALK_STAGE1_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP, "_stage1");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE1_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, LEMONGRASS_STALK_STAGE1_LOCATION), blockStateModelGenerator.modelOutput);
        ResourceLocation LEMONGRASS_STALK_STAGE2_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP, "_stage2");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE2_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, LEMONGRASS_STALK_STAGE2_LOCATION), blockStateModelGenerator.modelOutput);
        ResourceLocation LEMONGRASS_STALK_STAGE3_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP, "_stage3");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE3_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, LEMONGRASS_STALK_STAGE3_LOCATION), blockStateModelGenerator.modelOutput);
        ResourceLocation LEMONGRASS_STALK_STAGE4_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP, "_stage4");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE4_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, LEMONGRASS_STALK_STAGE4_LOCATION), blockStateModelGenerator.modelOutput);
        ResourceLocation LEMONGRASS_STALK_STAGE5_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP, "_stage5");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_STAGE5_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, LEMONGRASS_STALK_STAGE5_LOCATION), blockStateModelGenerator.modelOutput);
        ResourceLocation LEMONGRASS_STALK_SUPPORTING_LOCATION = ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP, "_supporting");
        UbesDelightModels.TEMPLATE_CROP_CROSS.create(LEMONGRASS_STALK_SUPPORTING_LOCATION, TextureMapping.singleSlot(TextureSlot.CROSS, LEMONGRASS_STALK_SUPPORTING_LOCATION), blockStateModelGenerator.modelOutput);

        TextureMapping textureMapKalan = TextureMapping.singleSlot(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.KALAN, "_side"))
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(UbesDelightBlocksImpl.KALAN, "_bottom"))
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(UbesDelightBlocksImpl.KALAN, "_top"));
        TextureMapping textureMapKalanOn = TextureMapping.singleSlot(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.KALAN, "_side_on"))
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(UbesDelightBlocksImpl.KALAN, "_bottom"))
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(UbesDelightBlocksImpl.KALAN, "_top_on"));
        ResourceLocation kalan = ModelTemplates.CUBE_BOTTOM_TOP.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.KALAN), textureMapKalan, blockStateModelGenerator.modelOutput);
        ResourceLocation kalan_on = ModelTemplates.CUBE_BOTTOM_TOP.create(ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.KALAN, "_on"), textureMapKalanOn, blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(UbesDelightBlocksImpl.KALAN)
                .with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(BlockModelGenerators.createBooleanModelDispatch(KalanBlock.LIT, kalan_on, kalan))
        );

        registerBasicRotationBlockState(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO, blockStateModelGenerator);

        registerBasicCake(UbesDelightBlocksImpl.UBE_CAKE, blockStateModelGenerator);
        registerSmallCake(UbesDelightBlocksImpl.LECHE_FLAN_FEAST, blockStateModelGenerator);

//        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(UbesDelightBlocksImpl.LUMPIA_FEAST)
//                .with(BlockModelGenerators.createHorizontalFacingDispatch())
//                .with(PropertyDispatch.property(LumpiaFeastBlock.SERVINGS)
//                        .select(0, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/banana_leaf_plate")))
//                        .select(1, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LUMPIA_FEAST, "_stage2")))
//                        .select(2, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LUMPIA_FEAST, "_stage1")))
//                        .select(3, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LUMPIA_FEAST, "_stage0")))
//                ));
        registerLumpiaLeafFeast();

        registerDrinkFeast(UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST, blockStateModelGenerator);
        registerDrinkFeast(UbesDelightBlocksImpl.HALO_HALO_FEAST, blockStateModelGenerator);

        registerGlassCup(UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO, blockStateModelGenerator);
        registerGlassCup(UbesDelightBlocksImpl.GLASS_CUP_MILK_TEA_UBE, blockStateModelGenerator);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(UbesDelightBlocksImpl.LEAF_FEAST)
                .with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(PropertyDispatch.property(LeafFeastBlock.LEAF_FEAST_TYPE)
                        .select(LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/leaf_feast")))
                        .select(LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/leaf_feast_tip")))
                        .select(LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/leaf_feast_end")))
                        .select(LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/leaf_feast_middle"))))
        );

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(UbesDelightBlocksImpl.UNIVERSAL_LEAF_FEAST)
                .with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(PropertyDispatch.property(LeafFeastBlock.LEAF_FEAST_TYPE)
                        .select(LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/leaf_feast")))
                        .select(LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/leaf_feast_tip")))
                        .select(LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/leaf_feast_end")))
                        .select(LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/leaf_feast_middle")))));

        registerEnsaymadaLeafFeastVariant(UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA, blockStateModelGenerator);
        registerEnsaymadaLeafFeastVariant(UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA_UBE, blockStateModelGenerator);
        registerPandesalLeafFeastVariant(UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL, blockStateModelGenerator);
        registerPandesalLeafFeastVariant(UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL_UBE, blockStateModelGenerator);
        registerHopiaLeafFeastVariant(UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_MUNGGO, blockStateModelGenerator);
        registerHopiaLeafFeastVariant(UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_UBE, blockStateModelGenerator);

        registerRiceLeafFeastVariant(UbesDelightBlocksImpl.LEAF_FEAST_COOKED_RICE, blockStateModelGenerator);
        registerRiceLeafFeastVariant(UbesDelightBlocksImpl.LEAF_FEAST_FRIED_RICE, blockStateModelGenerator);
        registerRiceLeafFeastVariant(UbesDelightBlocksImpl.LEAF_FEAST_SINANGAG, blockStateModelGenerator);
    }

    private static void registerCrateBlock(Block block, BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialBlock(block,
                (new TextureMapping())
                        .put(TextureSlot.SIDE, new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_side"))
                        .put(TextureSlot.TOP, new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_top"))
                        .put(TextureSlot.BOTTOM, UbesDelight.res("block/crate_bottom")),
                ModelTemplates.CUBE_BOTTOM_TOP);
    }

    private static void registerBasicRotationBlockState(Block block, BlockModelGenerators blockStateModelGenerator) {
        ResourceLocation resourceLocation = ModelLocationUtils.getModelLocation(block);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block,
                        Variant.variant().with(VariantProperties.MODEL, resourceLocation))
                .with(BlockModelGenerators.createHorizontalFacingDispatch()));
    }

    private static void registerDrinkFeast(Block block, BlockModelGenerators blockStateModelGenerator) {
        ResourceLocation punchBowl = UbesDelight.res("block/punch_bowl");
        TextureMapping textureMapping = TextureMapping.particle(punchBowl)
                .put(UbesDelightTextureSlots.DRINK_FEAST_INSIDE, TextureMapping.getBlockTexture(block))
                .put(UbesDelightTextureSlots.PUNCH_BOWL, punchBowl);
        UbesDelightModels.TEMPLATE_DRINK_FEAST_LEFTOVER.create(new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_leftover"),
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
            stages.get(i).create(new ResourceLocation(ModelLocationUtils.getModelLocation(block) + "_stage" + i),
                    textureMappingstage, blockStateModelGenerator.modelOutput);
        }

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(PropertyDispatch.property(DrinkableFeastBlock.SERVINGS)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_leftover")))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_stage3")))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_stage2")))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_stage1")))
                        .select(4, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_stage0")))
                ));
    }

    private static void registerBasicCake(Block block, BlockModelGenerators blockStateModelGenerator){
        TextureMapping CAKE_MAP = TextureMapping.particle(ModelLocationUtils.getModelLocation(block, "_side"))
                .put(TextureSlot.BOTTOM, ModelLocationUtils.getModelLocation(block, "_bottom"))
                .put(TextureSlot.TOP, ModelLocationUtils.getModelLocation(block, "_top"))
                .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(block, "_side"));
        UbesDelightModels.TEMPLATE_CAKE.create(block, CAKE_MAP, blockStateModelGenerator.modelOutput);

        List<ModelTemplate> CAKE_SLICE_MODELS = List.of(UbesDelightModels.TEMPLATE_CAKE_SLICE1, UbesDelightModels.TEMPLATE_CAKE_SLICE2, UbesDelightModels.TEMPLATE_CAKE_SLICE3,
                UbesDelightModels.TEMPLATE_CAKE_SLICE4, UbesDelightModels.TEMPLATE_CAKE_SLICE5, UbesDelightModels.TEMPLATE_CAKE_SLICE6);

        for (int i = 0; i < CAKE_SLICE_MODELS.size(); i++) {
            TextureMapping CAKE_SLICE_MAP = TextureMapping.particle(ModelLocationUtils.getModelLocation(block, "_side"))
                    .put(TextureSlot.BOTTOM, ModelLocationUtils.getModelLocation(block, "_bottom"))
                    .put(TextureSlot.TOP, ModelLocationUtils.getModelLocation(block, "_top"))
                    .put(TextureSlot.SIDE, ModelLocationUtils.getModelLocation(block, "_side"))
                    .put(TextureSlot.INSIDE, ModelLocationUtils.getModelLocation(block, "_inner"));
            CAKE_SLICE_MODELS.get(i).create(ModelLocationUtils.getModelLocation(block, "_slice" + (i+1)), CAKE_SLICE_MAP, blockStateModelGenerator.modelOutput);
        }

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(PropertyDispatch.property(UbesDelightCakeBlock.BITES)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block)))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_slice1")))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_slice2")))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_slice3")))
                        .select(4, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_slice4")))
                        .select(5, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_slice5")))
                        .select(6, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_slice6")))
                ));
    }

    private static void registerSmallCake(Block block, BlockModelGenerators blockStateModelGenerator){
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(PropertyDispatch.property(LecheFlanFeastBlock.BITES)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block)))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_bite1")))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_bite2")))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_bite3")))
                        .select(4, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block, "_bite4")))
                ));
    }

    private static void registerFlowerPotPlant(Block plant, Block pottedPlant, BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createSimpleFlatItemModel(plant);
        ResourceLocation resourceLocation = UbesDelightModels.TEMPLATE_CROP_CROSS.create(plant, TextureMapping.cross(plant), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(plant, resourceLocation));
        ResourceLocation resourceLocation2 = UbesDelightModels.TEMPLATE_POTTED_FLOWER.create(pottedPlant, TextureMapping.plant(plant), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pottedPlant, resourceLocation2));
    }

    private static void registerDoublePlant(Block plant, BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createSimpleFlatItemModel(plant, "_top");
        ResourceLocation resourceLocation = UbesDelightModels.TEMPLATE_CROP_CROSS.createWithSuffix(plant, "_top", TextureMapping.cross(ModelLocationUtils.getModelLocation(plant, "_top")), blockStateModelGenerator.modelOutput);
        ResourceLocation resourceLocation2 = UbesDelightModels.TEMPLATE_CROP_CROSS.createWithSuffix(plant, "_bottom", TextureMapping.cross(ModelLocationUtils.getModelLocation(plant, "_bottom")), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.createDoubleBlock(plant, resourceLocation, resourceLocation2);
    }

    private static void registerGlassCup(Block block, BlockModelGenerators blockModelGenerators) {
        ResourceLocation blockLocation = ModelLocationUtils.getModelLocation(block);
        ResourceLocation cupLocation = TextUtils.res("block/glass_cup");
        TextureMapping textureMapping = TextureMapping.singleSlot(UbesDelightTextureSlots.CUP, cupLocation)
                .put(UbesDelightTextureSlots.INSIDE, blockLocation);
        ResourceLocation TEMPLATE_GLASS_CUP_1_LOCATION = blockLocation.withSuffix("_servings1");
        UbesDelightModels.TEMPLATE_GLASS_CUP_1.create(TEMPLATE_GLASS_CUP_1_LOCATION, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation TEMPLATE_GLASS_CUP_2_LOCATION = blockLocation.withSuffix("_servings2");
        UbesDelightModels.TEMPLATE_GLASS_CUP_2.create(TEMPLATE_GLASS_CUP_2_LOCATION, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation TEMPLATE_GLASS_CUP_3_LOCATION = blockLocation.withSuffix("_servings3");
        UbesDelightModels.TEMPLATE_GLASS_CUP_3.create(TEMPLATE_GLASS_CUP_3_LOCATION, textureMapping, blockModelGenerators.modelOutput);
        ResourceLocation TEMPLATE_GLASS_CUP_4_LOCATION = blockLocation.withSuffix("_servings4");
        UbesDelightModels.TEMPLATE_GLASS_CUP_4.create(TEMPLATE_GLASS_CUP_4_LOCATION, textureMapping, blockModelGenerators.modelOutput);

        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(PropertyDispatch.property(GlassCupBlock.SERVINGS)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, TEMPLATE_GLASS_CUP_1_LOCATION))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, TEMPLATE_GLASS_CUP_2_LOCATION))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, TEMPLATE_GLASS_CUP_3_LOCATION))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, TEMPLATE_GLASS_CUP_4_LOCATION))

                ));
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

        Block block = UbesDelightBlocksImpl.LUMPIA_FEAST;
        ResourceLocation location = TextUtils.res("block/leaf_feast/" + ModelLocationUtils.getModelLocation(block).getPath().replace("block/", "leaf_feast_"));
        ResourceLocation baseLocation = location.withSuffix("_base");
        ResourceLocation middleLocation = location.withSuffix("_middle");

        ResourceLocation contentTextureLocation = TextUtils.res(ModelLocationUtils.getModelLocation(block).getPath().replace("leaf_feast_", ""));
        ResourceLocation contentTextureLocationAlt = TextUtils.res(ModelLocationUtils.getModelLocation(block).getPath().replace("leaf_feast_", "")).withSuffix("_alt");

        TextureMapping baseTextureMap = new TextureMapping()
                .put(TextureSlot.TOP, TextUtils.res("block/leaf_feast_top"))
                .put(TextureSlot.BOTTOM, TextUtils.res("block/leaf_feast_bottom"))
                .put(TextureSlot.CONTENT, contentTextureLocation)
                .put(UbesDelightTextureSlots.CONTENT_ALT, contentTextureLocationAlt);

        for (int i = 0; i < 3;i++) {
            modelTemplateBase[i].create(baseLocation.withSuffix("_" + (i + 1)), baseTextureMap, GENERATOR.modelOutput);
            modelTemplateMiddle[i].create(middleLocation.withSuffix("_" + (i + 1)), baseTextureMap, GENERATOR.modelOutput);
        }

        GENERATOR.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(PropertyDispatch.properties(SimpleLeafFeastBlock.SERVINGS, SimpleLeafFeastBlock.LEAF_FEAST_TYPE)
                        .select(1, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_1")))
                        .select(2, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_2")))
                        .select(3, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_3")))
                )
        );
    }

    private static void registerBreadLeafFeastVariant(Block block, ModelTemplate[] modelTemplateBase, ModelTemplate[] modelTemplateTip, ModelTemplate[] modelTemplateEnd, ModelTemplate[] modelTemplateMiddle, BlockModelGenerators blockStateModelGenerator) {
        ResourceLocation location = TextUtils.res("block/leaf_feast/" + ModelLocationUtils.getModelLocation(block).getPath().replace("block/", ""));
        ResourceLocation baseLocation = location.withSuffix("_base");
        ResourceLocation middleLocation = location.withSuffix("_middle");
        ResourceLocation tipLocation = location.withSuffix("_tip");
        ResourceLocation endLocation = location.withSuffix("_end");

        ResourceLocation contentTextureLocation = TextUtils.res(ModelLocationUtils.getModelLocation(block).getPath().replace("leaf_feast_", "").replace("_half", ""));

        TextureMapping baseTextureMap = new TextureMapping()
                .put(TextureSlot.TOP, TextUtils.res("block/leaf_feast_top"))
                .put(TextureSlot.BOTTOM, TextUtils.res("block/leaf_feast_bottom"))
                .put(TextureSlot.CONTENT, contentTextureLocation);

        TextureMapping tipTextureMap = new TextureMapping()
                .put(TextureSlot.TOP, TextUtils.res("block/leaf_feast_tip_top"))
                .put(TextureSlot.BOTTOM, TextUtils.res("block/leaf_feast_tip_bottom"))
                .put(TextureSlot.CONTENT, contentTextureLocation);

        TextureMapping endTextureMap =  new TextureMapping()
                .put(TextureSlot.TOP, TextUtils.res("block/leaf_feast_end_top"))
                .put(TextureSlot.BOTTOM, TextUtils.res("block/leaf_feast_end_bottom"))
                .put(TextureSlot.CONTENT, contentTextureLocation);

        for (int i = 0; i < 6;i++) {
            modelTemplateBase[i].create(baseLocation.withSuffix("_" + (i + 1)), baseTextureMap, GENERATOR.modelOutput);
            modelTemplateMiddle[i].create(middleLocation.withSuffix("_" + (i + 1)), baseTextureMap, GENERATOR.modelOutput);
        }
        for (int j = 0; j < 3;j++) {
            modelTemplateTip[j].create(tipLocation.withSuffix("_" + (j + 1)), tipTextureMap, GENERATOR.modelOutput);
            modelTemplateEnd[j].create(endLocation.withSuffix("_" + (j + 1)), endTextureMap, GENERATOR.modelOutput);
        }

        GENERATOR.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block)
                .with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(PropertyDispatch.properties(SimpleLeafFeastBlock.SERVINGS, SimpleLeafFeastBlock.LEAF_FEAST_TYPE)
                        .select(1, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, tipLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, endLocation.withSuffix("_1")))
                        .select(1, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_1")))
                        .select(2, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, tipLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, endLocation.withSuffix("_2")))
                        .select(2, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_2")))
                        .select(3, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, tipLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, endLocation.withSuffix("_3")))
                        .select(3, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_4")))
                        .select(4, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, tipLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, endLocation.withSuffix("_3")))
                        .select(4, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_4")))
                        .select(5, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_5")))
                        .select(5, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, tipLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, endLocation.withSuffix("_3")))
                        .select(5, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_5")))
                        .select(6, LeafFeastTypes.BASE, Variant.variant().with(VariantProperties.MODEL, baseLocation.withSuffix("_6")))
                        .select(6, LeafFeastTypes.TIP, Variant.variant().with(VariantProperties.MODEL, tipLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.END, Variant.variant().with(VariantProperties.MODEL, endLocation.withSuffix("_3")))
                        .select(6, LeafFeastTypes.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleLocation.withSuffix("_6")))
                )
        );
    }
}
