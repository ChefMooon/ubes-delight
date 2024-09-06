package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class LootTableGenerator extends FabricBlockLootTableProvider {

    protected LootTableGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate() {

        dropSelf(UbesDelightBlocksImpl.KALAN);
        dropSelf(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO);

        dropSelf(UbesDelightBlocksImpl.UBE_CRATE);
        dropSelf(UbesDelightBlocksImpl.GARLIC_CRATE);
        dropSelf(UbesDelightBlocksImpl.GINGER_CRATE);
        dropSelf(UbesDelightBlocksImpl.LEMONGRASS_CRATE);

        // todo - V0.2.0 - these stopped working,
//        createCropDrops(UbesDelightBlocksImpl.UBE_CROP, UbesDelightItemsImpl.UBE, UbesDelightItemsImpl.UBE,
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.UBE_CROP)
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbeCropBlock.AGE, 7)));
//
//        createCropDrops(UbesDelightBlocksImpl.GARLIC_CROP, UbesDelightItemsImpl.GARLIC, UbesDelightItemsImpl.GARLIC,
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.GARLIC_CROP)
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GarlicCropBlock.AGE, 7)));
//
//        createCropDrops(UbesDelightBlocksImpl.GINGER_CROP, UbesDelightItemsImpl.GINGER, UbesDelightItemsImpl.GINGER,
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.GINGER_CROP)
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GingerCropBlock.AGE, 7)));
//
//        createCropDrops(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP, UbesDelightItemsImpl.LEMONGRASS, UbesDelightItemsImpl.LEMONGRASS_SEEDS,
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP)
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LemongrassStalkCropBlock.LEMONGRASS_AGE, 5)));
//        createCropDrops(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP, UbesDelightItemsImpl.LEMONGRASS, UbesDelightItemsImpl.LEMONGRASS_SEEDS,
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP)
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LemongrassLeafCropBlock.AGE, 3)));
    }
}
