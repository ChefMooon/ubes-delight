package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.block.*;
import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.util.ModModels;
import com.chefmoon.ubesdelight.util.ModTextureKey;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        registerCrateBlock(BlocksRegistry.UBE_CRATE, BlocksRegistry.UBE_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.GARLIC_CRATE, BlocksRegistry.GARLIC_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.GINGER_CRATE, BlocksRegistry.GINGER_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.LEMONGRASS_CRATE, BlocksRegistry.LEMONGRASS_CRATE.getPathName(), blockStateModelGenerator);

        registerFlowerPotPlant(BlocksRegistry.WILD_UBE, BlocksRegistry.POTTED_UBE, blockStateModelGenerator);
        registerFlowerPotPlant(BlocksRegistry.WILD_GARLIC, BlocksRegistry.POTTED_GARLIC, blockStateModelGenerator);
        registerFlowerPotPlant(BlocksRegistry.WILD_GINGER, BlocksRegistry.POTTED_GINGER, blockStateModelGenerator);
        blockStateModelGenerator.registerDoubleBlock(BlocksRegistry.WILD_LEMONGRASS.get(), BlockStateModelGenerator.TintType.NOT_TINTED);

        TextureMap textureMapUbeCropStage0 = TextureMap.of(ModTextureKey.ODD_CROP, TextureMap.getSubId(BlocksRegistry.UBE_CROP.get(), "_stage0"));
        Identifier UBE_STAGE0 = ModModels.TEMPLATE_ODD_CROP.upload(ModelIds.getBlockSubModelId(BlocksRegistry.UBE_CROP.get(), "_stage0"), textureMapUbeCropStage0, blockStateModelGenerator.modelCollector);
        TextureMap textureMapUbeCropStage1 = TextureMap.of(ModTextureKey.ODD_CROP, TextureMap.getSubId(BlocksRegistry.UBE_CROP.get(), "_stage1"));
        Identifier UBE_STAGE1 = ModModels.TEMPLATE_ODD_CROP.upload(ModelIds.getBlockSubModelId(BlocksRegistry.UBE_CROP.get(), "_stage1"), textureMapUbeCropStage1, blockStateModelGenerator.modelCollector);
        TextureMap textureMapUbeCropStage2 = TextureMap.of(ModTextureKey.ODD_CROP, TextureMap.getSubId(BlocksRegistry.UBE_CROP.get(), "_stage2"));
        Identifier UBE_STAGE2 = ModModels.TEMPLATE_ODD_CROP.upload(ModelIds.getBlockSubModelId(BlocksRegistry.UBE_CROP.get(), "_stage2"), textureMapUbeCropStage2, blockStateModelGenerator.modelCollector);
        TextureMap textureMapUbeCropStage3 = TextureMap.of(ModTextureKey.ODD_CROP, TextureMap.getSubId(BlocksRegistry.UBE_CROP.get(), "_stage3"));
        Identifier UBE_STAGE3 = ModModels.TEMPLATE_ODD_CROP.upload(ModelIds.getBlockSubModelId(BlocksRegistry.UBE_CROP.get(), "_stage3"), textureMapUbeCropStage3, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(BlocksRegistry.UBE_CROP.get())
                .coordinate(BlockStateVariantMap.create(UbeCropBlock.AGE)
                        .register((Integer)0, BlockStateVariant.create().put(VariantSettings.MODEL, UBE_STAGE0))
                        .register((Integer)1, BlockStateVariant.create().put(VariantSettings.MODEL, UBE_STAGE0))
                        .register((Integer)2, BlockStateVariant.create().put(VariantSettings.MODEL, UBE_STAGE1))
                        .register((Integer)3, BlockStateVariant.create().put(VariantSettings.MODEL, UBE_STAGE1))
                        .register((Integer)4, BlockStateVariant.create().put(VariantSettings.MODEL, UBE_STAGE2))
                        .register((Integer)5, BlockStateVariant.create().put(VariantSettings.MODEL, UBE_STAGE2))
                        .register((Integer)6, BlockStateVariant.create().put(VariantSettings.MODEL, UBE_STAGE2))
                        .register((Integer)7, BlockStateVariant.create().put(VariantSettings.MODEL, UBE_STAGE3))
                ));

        TextureMap textureMapLemongrassStage0 = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(BlocksRegistry.LEMONGRASS_CROP.get(), "_stage0"));
        Identifier LEMONGRASS_STAGE0 = Models.CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.LEMONGRASS_CROP.get(), "_stage0"), textureMapLemongrassStage0, blockStateModelGenerator.modelCollector);
        TextureMap textureMapLemongrassStage1 = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(BlocksRegistry.LEMONGRASS_CROP.get(), "_stage1"));
        Identifier LEMONGRASS_STAGE1 = Models.CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.LEMONGRASS_CROP.get(), "_stage1"), textureMapLemongrassStage1, blockStateModelGenerator.modelCollector);
        TextureMap textureMapLemongrassStage2 = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(BlocksRegistry.LEMONGRASS_CROP.get(), "_stage2"));
        Identifier LEMONGRASS_STAGE2 = Models.CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.LEMONGRASS_CROP.get(), "_stage2"), textureMapLemongrassStage2, blockStateModelGenerator.modelCollector);
        TextureMap textureMapLemongrassStage3 = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(BlocksRegistry.LEMONGRASS_CROP.get(), "_stage3"));
        Identifier LEMONGRASS_STAGE3 = Models.CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.LEMONGRASS_CROP.get(), "_stage3"), textureMapLemongrassStage3, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(BlocksRegistry.LEMONGRASS_LEAF_CROP.get())
                .coordinate(BlockStateVariantMap.create(LemongrassLeafCropBlock.AGE)
                        .register((Integer)0, BlockStateVariant.create().put(VariantSettings.MODEL, LEMONGRASS_STAGE0))
                        .register((Integer)1, BlockStateVariant.create().put(VariantSettings.MODEL, LEMONGRASS_STAGE1))
                        .register((Integer)2, BlockStateVariant.create().put(VariantSettings.MODEL, LEMONGRASS_STAGE2))
                        .register((Integer)3, BlockStateVariant.create().put(VariantSettings.MODEL, LEMONGRASS_STAGE3))
                ));

        TextureMap textureMapLemongrassStalkStage0 = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage0"));
        Models.CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage0"), textureMapLemongrassStalkStage0, blockStateModelGenerator.modelCollector);
        TextureMap textureMapLemongrassStalkStage1 = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage1"));
        Models.CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage1"), textureMapLemongrassStalkStage1, blockStateModelGenerator.modelCollector);
        TextureMap textureMapLemongrassStalkStage2 = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage2"));
        Models.CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage2"), textureMapLemongrassStalkStage2, blockStateModelGenerator.modelCollector);
        TextureMap textureMapLemongrassStalkStage3 = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage3"));
        Models.CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage3"), textureMapLemongrassStalkStage3, blockStateModelGenerator.modelCollector);
        TextureMap textureMapLemongrassStalkStage4 = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage4"));
        Models.CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage4"), textureMapLemongrassStalkStage4, blockStateModelGenerator.modelCollector);
        TextureMap textureMapLemongrassStalkStage5 = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage5"));
        Models.CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_stage5"), textureMapLemongrassStalkStage5, blockStateModelGenerator.modelCollector);
        TextureMap textureMapLemongrassStalkSupporting = TextureMap.of(TextureKey.CROSS, TextureMap.getSubId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_supporting"));
        Models.CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.LEMONGRASS_STALK_CROP.get(), "_supporting"), textureMapLemongrassStalkSupporting, blockStateModelGenerator.modelCollector);

        TextureMap textureMapGarlicCropStage0 = TextureMap.of(ModTextureKey.CROSS_V1, TextureMap.getSubId(BlocksRegistry.GARLIC_CROP.get(), "_stage0_v1"))
                .put(ModTextureKey.CROSS_V2, TextureMap.getSubId(BlocksRegistry.GARLIC_CROP.get(), "_stage0_v2"));
        TextureMap textureMapGarlicCropStage1 = TextureMap.of(ModTextureKey.CROSS_V1, TextureMap.getSubId(BlocksRegistry.GARLIC_CROP.get(), "_stage1_v1"))
                .put(ModTextureKey.CROSS_V2, TextureMap.getSubId(BlocksRegistry.GARLIC_CROP.get(), "_stage1_v2"));
        TextureMap textureMapGarlicCropStage2 = TextureMap.of(ModTextureKey.CROSS_V1, TextureMap.getSubId(BlocksRegistry.GARLIC_CROP.get(), "_stage2_v1"))
                .put(ModTextureKey.CROSS_V2, TextureMap.getSubId(BlocksRegistry.GARLIC_CROP.get(), "_stage2_v2"));
        TextureMap textureMapGarlicCropStage3 = TextureMap.of(ModTextureKey.CROSS_V1, TextureMap.getSubId(BlocksRegistry.GARLIC_CROP.get(), "_stage3_v1"))
                .put(ModTextureKey.CROSS_V2, TextureMap.getSubId(BlocksRegistry.GARLIC_CROP.get(), "_stage3_v2"));
        Identifier GARLIC_STAGE0 = ModModels.TEMPLATE_COMPLEX_CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.GARLIC_CROP.get(), "_stage0"), textureMapGarlicCropStage0, blockStateModelGenerator.modelCollector);
        Identifier GARLIC_STAGE1 = ModModels.TEMPLATE_COMPLEX_CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.GARLIC_CROP.get(), "_stage1"), textureMapGarlicCropStage1, blockStateModelGenerator.modelCollector);
        Identifier GARLIC_STAGE2 = ModModels.TEMPLATE_COMPLEX_CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.GARLIC_CROP.get(), "_stage2"), textureMapGarlicCropStage2, blockStateModelGenerator.modelCollector);
        Identifier GARLIC_STAGE3 = ModModels.TEMPLATE_COMPLEX_CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.GARLIC_CROP.get(), "_stage3"), textureMapGarlicCropStage3, blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(BlocksRegistry.GARLIC_CROP.get())
                .coordinate(BlockStateVariantMap.create(GarlicCropBlock.AGE)
                        .register((Integer)0, BlockStateVariant.create().put(VariantSettings.MODEL, GARLIC_STAGE0))
                        .register((Integer)1, BlockStateVariant.create().put(VariantSettings.MODEL, GARLIC_STAGE0))
                        .register((Integer)2, BlockStateVariant.create().put(VariantSettings.MODEL, GARLIC_STAGE1))
                        .register((Integer)3, BlockStateVariant.create().put(VariantSettings.MODEL, GARLIC_STAGE1))
                        .register((Integer)4, BlockStateVariant.create().put(VariantSettings.MODEL, GARLIC_STAGE2))
                        .register((Integer)5, BlockStateVariant.create().put(VariantSettings.MODEL, GARLIC_STAGE2))
                        .register((Integer)6, BlockStateVariant.create().put(VariantSettings.MODEL, GARLIC_STAGE2))
                        .register((Integer)7, BlockStateVariant.create().put(VariantSettings.MODEL, GARLIC_STAGE3))
                ));

        TextureMap textureMapGingerCropStage0 = TextureMap.of(ModTextureKey.CROSS_V1, TextureMap.getSubId(BlocksRegistry.GINGER_CROP.get(), "_stage0_v1"))
                .put(ModTextureKey.CROSS_V2, TextureMap.getSubId(BlocksRegistry.GINGER_CROP.get(), "_stage0_v2"));
        TextureMap textureMapGingerCropStage1 = TextureMap.of(ModTextureKey.CROSS_V1, TextureMap.getSubId(BlocksRegistry.GINGER_CROP.get(), "_stage1_v1"))
                .put(ModTextureKey.CROSS_V2, TextureMap.getSubId(BlocksRegistry.GINGER_CROP.get(), "_stage1_v2"));
        TextureMap textureMapGingerCropStage2 = TextureMap.of(ModTextureKey.CROSS_V1, TextureMap.getSubId(BlocksRegistry.GINGER_CROP.get(), "_stage2_v1"))
                .put(ModTextureKey.CROSS_V2, TextureMap.getSubId(BlocksRegistry.GINGER_CROP.get(), "_stage2_v2"));
        TextureMap textureMapGingerCropStage3 = TextureMap.of(ModTextureKey.CROSS_V1, TextureMap.getSubId(BlocksRegistry.GINGER_CROP.get(), "_stage3_v1"))
                .put(ModTextureKey.CROSS_V2, TextureMap.getSubId(BlocksRegistry.GINGER_CROP.get(), "_stage3_v2"));
        Identifier GINGER_STAGE0 = ModModels.TEMPLATE_COMPLEX_CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.GINGER_CROP.get(), "_stage0"), textureMapGingerCropStage0, blockStateModelGenerator.modelCollector);
        Identifier GINGER_STAGE1 = ModModels.TEMPLATE_COMPLEX_CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.GINGER_CROP.get(), "_stage1"), textureMapGingerCropStage1, blockStateModelGenerator.modelCollector);
        Identifier GINGER_STAGE2 = ModModels.TEMPLATE_COMPLEX_CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.GINGER_CROP.get(), "_stage2"), textureMapGingerCropStage2, blockStateModelGenerator.modelCollector);
        Identifier GINGER_STAGE3 = ModModels.TEMPLATE_COMPLEX_CROSS.upload(ModelIds.getBlockSubModelId(BlocksRegistry.GINGER_CROP.get(), "_stage3"), textureMapGingerCropStage3, blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(BlocksRegistry.GINGER_CROP.get())
                .coordinate(BlockStateVariantMap.create(GarlicCropBlock.AGE)
                        .register((Integer)0, BlockStateVariant.create().put(VariantSettings.MODEL, GINGER_STAGE0))
                        .register((Integer)1, BlockStateVariant.create().put(VariantSettings.MODEL, GINGER_STAGE0))
                        .register((Integer)2, BlockStateVariant.create().put(VariantSettings.MODEL, GINGER_STAGE1))
                        .register((Integer)3, BlockStateVariant.create().put(VariantSettings.MODEL, GINGER_STAGE1))
                        .register((Integer)4, BlockStateVariant.create().put(VariantSettings.MODEL, GINGER_STAGE2))
                        .register((Integer)5, BlockStateVariant.create().put(VariantSettings.MODEL, GINGER_STAGE2))
                        .register((Integer)6, BlockStateVariant.create().put(VariantSettings.MODEL, GINGER_STAGE2))
                        .register((Integer)7, BlockStateVariant.create().put(VariantSettings.MODEL, GINGER_STAGE3))
                ));

        TextureMap textureMapKalan = TextureMap.of(TextureKey.SIDE, TextureMap.getSubId(BlocksRegistry.KALAN.get(), "_side"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(BlocksRegistry.KALAN.get(), "_bottom"))
                .put(TextureKey.TOP, TextureMap.getSubId(BlocksRegistry.KALAN.get(), "_top"));
        TextureMap textureMapKalanOn = TextureMap.of(TextureKey.SIDE, TextureMap.getSubId(BlocksRegistry.KALAN.get(), "_side_on"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(BlocksRegistry.KALAN.get(), "_bottom"))
                .put(TextureKey.TOP, TextureMap.getSubId(BlocksRegistry.KALAN.get(), "_top_on"));
        Identifier kalan = Models.CUBE_BOTTOM_TOP.upload(ModelIds.getBlockModelId(BlocksRegistry.KALAN.get()), textureMapKalan, blockStateModelGenerator.modelCollector);
        Identifier kalan_on = Models.CUBE_BOTTOM_TOP.upload(ModelIds.getBlockSubModelId(BlocksRegistry.KALAN.get(), "_on"), textureMapKalanOn, blockStateModelGenerator.modelCollector);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(BlocksRegistry.KALAN.get(),
                        BlockStateVariant.create().put(VariantSettings.MODEL, kalan))
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.LIT, kalan_on, kalan))
                .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));

        registerBasicRotationBlockState(BlocksRegistry.GLASS_CUP_HALO_HALO, blockStateModelGenerator);
        registerBasicRotationBlockState(BlocksRegistry.BAKING_MAT_BAMBOO, blockStateModelGenerator);

        registerBasicCake(BlocksRegistry.UBE_CAKE, blockStateModelGenerator);
        registerSmallCake(BlocksRegistry.LECHE_FLAN_FEAST, blockStateModelGenerator);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(BlocksRegistry.LUMPIA_FEAST.get())
                .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
                .coordinate(BlockStateVariantMap.create(LumpiaFeast.SERVINGS)
                        .register((Integer)0, BlockStateVariant.create().put(VariantSettings.MODEL, new Identifier(UbesDelightMod.MOD_ID, "block/banana_leaf_plate")))
                        .register((Integer)1, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(BlocksRegistry.LUMPIA_FEAST.get(), "_stage2")))
                        .register((Integer)2, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(BlocksRegistry.LUMPIA_FEAST.get(), "_stage1")))
                        .register((Integer)3, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(BlocksRegistry.LUMPIA_FEAST.get(), "_stage0")))
                ));

        registerDrinkFeast(BlocksRegistry.MILK_TEA_UBE_FEAST, blockStateModelGenerator);
        registerDrinkFeast(BlocksRegistry.HALO_HALO_FEAST, blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ItemsRegistry.POISONOUS_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.GARLIC.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.GINGER.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LEMONGRASS.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LEMONGRASS_SEEDS.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.SINANGAG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.KINILAW.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LUMPIA.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.TOCINO.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.CHICKEN_INASAL.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.CHICKEN_INASAL_RICE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.TOSILOG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.BANGSILOG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.SISIG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.BULALO.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ARROZ_CALDO.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.MECHADO.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.CONDENSED_MILK_BOTTLE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.FISH_SAUCE_BOTTLE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.MILK_POWDER.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.SUGAR_BROWN.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LUMPIA_WRAPPER.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.MILK_TEA_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HALO_HALO.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.GARLIC_CHOP.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.GINGER_CHOP.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.COOKIE_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.COOKIE_GINGER.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.POLVORONE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_PINIPIG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_CC.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.RAW_POLVORONE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.RAW_POLVORONE_PINIPIG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.RAW_POLVORONE_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.RAW_POLVORONE_CC.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.HALO_HALO_FEAST.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.MILK_TEA_UBE_FEAST.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LUMPIA_FEAST.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.LECHE_FLAN_FEAST.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LECHE_FLAN.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.UBE_CAKE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.UBE_CAKE_SLICE.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.PANDESAL.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_MUNGGO.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_UBE.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.PANDESAL_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.PANDESAL_UBE_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_UBE_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_UBE_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_UBE_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_STAGE3.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE_STAGE3.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.HOPIA_MUNGGO_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_MUNGGO_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_MUNGGO_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_MUNGGO_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.HOPIA_UBE_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_UBE_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_UBE_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_UBE_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.POLVORONE_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_PINIPIG_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_PINIPIG_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_PINIPIG_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_UBE_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_UBE_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_UBE_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_CC_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_CC_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_CC_STAGE2.get(), Models.GENERATED);

        //itemModelGenerator.register(ItemsRegistry.ROLLING_PIN.get(), Models.GENERATED);

    }

    private static void registerCrateBlock(BlocksRegistry block, String name, BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(block.get(),
                (new TextureMap())
                        .put(TextureKey.SIDE, new Identifier(UbesDelightMod.MOD_ID, "block/" + name + "_side"))
                        .put(TextureKey.TOP, new Identifier(UbesDelightMod.MOD_ID, "block/" + name + "_top"))
                        .put(TextureKey.BOTTOM, new Identifier(UbesDelightMod.MOD_ID, "block/crate_bottom")),
                Models.CUBE_BOTTOM_TOP);
    }

    private static void registerFlowerPotPlant(BlocksRegistry plantBlock, BlocksRegistry pottedPlantBlock, BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerFlowerPotPlant(plantBlock.get(), pottedPlantBlock.get(), BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    private static void registerBasicRotationBlockState(BlocksRegistry block, BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = new Identifier(UbesDelightMod.MOD_ID, "block/" + block.getPathName());
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block.get(),
                        BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
                .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
    }

    private static void registerDrinkFeast(BlocksRegistry block, BlockStateModelGenerator blockStateModelGenerator) {
        Identifier punchBowl = new Identifier(UbesDelightMod.MOD_ID, "block/punch_bowl");
        TextureMap textureMap = TextureMap.of(TextureKey.PARTICLE, punchBowl)
                .put(ModTextureKey.DRINK_FEAST_INSIDE, TextureMap.getId(block.get()))
                .put(ModTextureKey.PUNCH_BOWL, punchBowl);
        ModModels.TEMPLATE_DRINK_FEAST_LEFTOVER.upload(ModelIds.getBlockSubModelId(block.get(), "_leftover"), textureMap, blockStateModelGenerator.modelCollector);

        List<Model> stages = List.of(ModModels.TEMPLATE_DRINK_FEAST_STAGE0, ModModels.TEMPLATE_DRINK_FEAST_STAGE1, ModModels.TEMPLATE_DRINK_FEAST_STAGE2, ModModels.TEMPLATE_DRINK_FEAST_STAGE3);
        for (int i = 0; i < stages.size(); i++) {
            TextureMap textureMapStage = TextureMap.of(TextureKey.PARTICLE, punchBowl)
                    .put(ModTextureKey.DRINK_FEAST_INSIDE, TextureMap.getId(block.get()))
                    .put(ModTextureKey.PUNCH_BOWL, punchBowl);
            stages.get(i).upload(ModelIds.getBlockSubModelId(block.get(), "_stage" + (i)), textureMapStage, blockStateModelGenerator.modelCollector);
        }

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block.get())
                .coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates())
                .coordinate(BlockStateVariantMap.create(DrinkableFeastBlock.SERVINGS)
                        .register((Integer)0, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_leftover")))
                        .register((Integer)1, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_stage3")))
                        .register((Integer)2, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_stage2")))
                        .register((Integer)3, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_stage1")))
                        .register((Integer)4, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_stage0")))
                ));
    }

    private static void registerBasicCake(BlocksRegistry block, BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textureMapCake = TextureMap.of(TextureKey.PARTICLE, TextureMap.getSubId(block.get(), "_side"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(block.get(), "_bottom"))
                .put(TextureKey.TOP, TextureMap.getSubId(block.get(), "_top"))
                .put(TextureKey.SIDE, TextureMap.getSubId(block.get(), "_side"));
        ModModels.TEMPLATE_CAKE.upload(ModelIds.getBlockModelId(block.get()), textureMapCake, blockStateModelGenerator.modelCollector);

        List<Model> cakeSliceModels = List.of(ModModels.TEMPLATE_CAKE_SLICE1, ModModels.TEMPLATE_CAKE_SLICE2, ModModels.TEMPLATE_CAKE_SLICE3, ModModels.TEMPLATE_CAKE_SLICE4, ModModels.TEMPLATE_CAKE_SLICE5, ModModels.TEMPLATE_CAKE_SLICE6);

        for (int i = 0; i < cakeSliceModels.size(); i++) {
            TextureMap textureMap = TextureMap.of(TextureKey.PARTICLE, TextureMap.getSubId(block.get(), "_side"))
                    .put(TextureKey.BOTTOM, TextureMap.getSubId(block.get(), "_bottom"))
                    .put(TextureKey.TOP, TextureMap.getSubId(block.get(), "_top"))
                    .put(TextureKey.SIDE, TextureMap.getSubId(block.get(), "_side"))
                    .put(TextureKey.INSIDE, TextureMap.getSubId(block.get(), "_inner"));
            cakeSliceModels.get(i).upload(ModelIds.getBlockSubModelId(block.get(), "_slice" + (i+1)), textureMap, blockStateModelGenerator.modelCollector);
        }

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block.get())
                .coordinate(BlockStateVariantMap.create(UbesDelightCakeBlock.BITES)
                        .register((Integer)0, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(block.get())))
                        .register((Integer)1, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_slice1")))
                        .register((Integer)2, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_slice2")))
                        .register((Integer)3, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_slice3")))
                        .register((Integer)4, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_slice4")))
                        .register((Integer)5, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_slice5")))
                        .register((Integer)6, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_slice6")))
                ));
    }

    private static void registerSmallCake(BlocksRegistry block, BlockStateModelGenerator blockStateModelGenerator){
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block.get())
                .coordinate(BlockStateVariantMap.create(LecheFlanFeast.BITES).register((Integer)0,
                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(block.get()))).register((Integer)1,
                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_bite1"))).register((Integer)2,
                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_bite2"))).register((Integer)3,
                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_bite3"))).register((Integer)4,
                        BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockSubModelId(block.get(), "_bite4")))));
    }
}
