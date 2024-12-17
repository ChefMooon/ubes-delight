package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.common.block.*;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class LootTableGenerator extends FabricBlockLootTableProvider {

    protected LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {

        dropSelf(UbesDelightBlocksImpl.KALAN);
        dropSelf(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO);

        dropSelf(UbesDelightBlocksImpl.UBE_CRATE);
        dropSelf(UbesDelightBlocksImpl.GARLIC_CRATE);
        dropSelf(UbesDelightBlocksImpl.GINGER_CRATE);
        dropSelf(UbesDelightBlocksImpl.LEMONGRASS_CRATE);

        dropPottedContents(UbesDelightBlocksImpl.POTTED_UBE);
        dropPottedContents(UbesDelightBlocksImpl.POTTED_GARLIC);
        dropPottedContents(UbesDelightBlocksImpl.POTTED_GINGER);

        createGlassCupDrops(UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO, UbesDelightItemsImpl.HALO_HALO);
        createGlassCupDrops(UbesDelightBlocksImpl.GLASS_CUP_MILK_TEA_UBE, UbesDelightItemsImpl.MILK_TEA_UBE);

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

    private void createGlassCupDrops(Block block, Item item) {
        // todo - decide if this should require silk touch? or knife?
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 2))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 1))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 0))))
        ));
    }
}