package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.block.*;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.common.utility.fabric.UbesDelightModels;
import com.chefmooon.ubesdelight.common.utility.fabric.UbesDelightTextureSlots;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

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

        registerBasicRotationBlockState(UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO, blockStateModelGenerator);
        registerBasicRotationBlockState(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO, blockStateModelGenerator);

        registerBasicCake(UbesDelightBlocksImpl.UBE_CAKE, blockStateModelGenerator);
        registerSmallCake(UbesDelightBlocksImpl.LECHE_FLAN_FEAST, blockStateModelGenerator);

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(UbesDelightBlocksImpl.LUMPIA_FEAST)
                .with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(PropertyDispatch.property(LumpiaFeastBlock.SERVINGS)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/banana_leaf_plate")))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LUMPIA_FEAST, "_stage2")))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LUMPIA_FEAST, "_stage1")))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(UbesDelightBlocksImpl.LUMPIA_FEAST, "_stage0")))
                ));


        blockStateModelGenerator.createSimpleFlatItemModel(UbesDelightBlocksImpl.BANANA_LEAF);
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(UbesDelightBlocksImpl.BANANA_LEAF)
                .with(BlockModelGenerators.createHorizontalFacingDispatch())
                .with(PropertyDispatch.property(AbstractBananaLeafBlock.NORTH)
                        .select(true, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/banana_leaf_plate")))
                        .select(false, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/banana_leaf_plate")))
                )
                .with(PropertyDispatch.property(AbstractBananaLeafBlock.EAST)
                        .select(true, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/banana_leaf_plate")))
                        .select(false, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/banana_leaf_plate")))
                )
                .with(PropertyDispatch.property(AbstractBananaLeafBlock.SOUTH)
                        .select(true, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/banana_leaf_plate")))
                        .select(false, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/banana_leaf_plate")))
                )
                .with(PropertyDispatch.property(AbstractBananaLeafBlock.WEST)
                        .select(true, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/banana_leaf_plate")))
                        .select(false, Variant.variant().with(VariantProperties.MODEL, TextUtils.res("block/banana_leaf_plate")))
                )
        );

        registerDrinkFeast(UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST, blockStateModelGenerator);
        registerDrinkFeast(UbesDelightBlocksImpl.HALO_HALO_FEAST, blockStateModelGenerator);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POISONOUS_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.GARLIC, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.GINGER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LEMONGRASS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LEMONGRASS_SEEDS, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.SINANGAG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.KINILAW, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LUMPIA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.TOCINO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.CHICKEN_INASAL, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.CHICKEN_INASAL_RICE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.TOSILOG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.BANGSILOG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.SISIG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.BULALO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ARROZ_CALDO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.MECHADO, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.MILK_POWDER, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.SUGAR_BROWN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LUMPIA_WRAPPER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.MILK_TEA_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HALO_HALO, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.GARLIC_CHOP, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.GINGER_CHOP, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.COOKIE_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.COOKIE_GINGER, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE_PINIPIG, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.RAW_POLVORONE_CC, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HALO_HALO_FEAST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LUMPIA_FEAST, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LECHE_FLAN_FEAST, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.LECHE_FLAN, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.UBE_CAKE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.UBE_CAKE_SLICE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.PANDESAL_UBE_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_STAGE3, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_STAGE3, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.ENSAYMADA_UBE_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_MUNGGO_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.HOPIA_UBE_RAW, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_PINIPIG_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_UBE_STAGE2, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC_STAGE0, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC_STAGE1, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(UbesDelightItemsImpl.POLVORONE_CC_STAGE2, ModelTemplates.FLAT_ITEM);

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
        ResourceLocation resourceLocation2 = ModelTemplates.FLOWER_POT_CROSS.create(pottedPlant, TextureMapping.plant(plant), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(pottedPlant, resourceLocation2));
    }

    private static void registerDoublePlant(Block plant, BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createSimpleFlatItemModel(plant, "_top");
        ResourceLocation resourceLocation = UbesDelightModels.TEMPLATE_CROP_CROSS.createWithSuffix(plant, "_top", TextureMapping.cross(ModelLocationUtils.getModelLocation(plant, "_top")), blockStateModelGenerator.modelOutput);
        ResourceLocation resourceLocation2 = UbesDelightModels.TEMPLATE_CROP_CROSS.createWithSuffix(plant, "_bottom", TextureMapping.cross(ModelLocationUtils.getModelLocation(plant, "_bottom")), blockStateModelGenerator.modelOutput);
        blockStateModelGenerator.createDoubleBlock(plant, resourceLocation, resourceLocation2);
    }
}
