package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.block.DrinkableFeastBlock;
import chefmooon.ubesdelight.common.block.GlassCupBlock;
import chefmooon.ubesdelight.common.block.LecheFlanFeastBlock;
import chefmooon.ubesdelight.common.block.UbesDelightCakeBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.LargeLeafFeastBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.concurrent.CompletableFuture;

public class LootTableGenerator extends FabricBlockLootTableProvider {

    protected LootTableGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate() {

        dropSelf(UbesDelightBlocks.KALAN.get());
        dropSelf(UbesDelightBlocks.BAKING_MAT_BAMBOO.get());

        dropSelf(UbesDelightBlocks.UBE_CRATE.get());
        dropSelf(UbesDelightBlocks.GARLIC_CRATE.get());
        dropSelf(UbesDelightBlocks.GINGER_CRATE.get());
        dropSelf(UbesDelightBlocks.LEMONGRASS_CRATE.get());

        dropSelf(UbesDelightBlocks.LEAF_FEAST.get());
        dropOther(UbesDelightBlocks.UNIVERSAL_LEAF_FEAST.get(), UbesDelightItems.LEAF_FEAST.get());

        dropPottedContents(UbesDelightBlocks.POTTED_UBE.get());
        dropPottedContents(UbesDelightBlocks.POTTED_GARLIC.get());
        dropPottedContents(UbesDelightBlocks.POTTED_GINGER.get());

        createGlassCupDrops(UbesDelightBlocks.GLASS_CUP_HALO_HALO.get(), UbesDelightItems.HALO_HALO.get());
        createGlassCupDrops(UbesDelightBlocks.GLASS_CUP_MILK_TEA_UBE.get(), UbesDelightItems.MILK_TEA_UBE.get());

        dropLargeLeafFeastContents(UbesDelightBlocks.LUMPIA_FEAST.get(), UbesDelightItems.LUMPIA.get());

        dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA.get(), UbesDelightItems.ENSAYMADA.get());
        dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE.get(), UbesDelightItems.ENSAYMADA_UBE.get());
        dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_PANDESAL.get(), UbesDelightItems.PANDESAL.get());
        dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE.get(), UbesDelightItems.PANDESAL_UBE.get());
        dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO.get(), UbesDelightItems.HOPIA_MUNGGO.get());
        dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE.get(), UbesDelightItems.HOPIA_UBE.get());
        dropContainerLeaftContents(UbesDelightBlocks.LEAF_FEAST_COOKED_RICE.get());
        dropContainerLeaftContents(UbesDelightBlocks.LEAF_FEAST_FRIED_RICE.get());
        dropContainerLeaftContents(UbesDelightBlocks.LEAF_FEAST_SINANGAG.get());

        add(UbesDelightBlocks.UBE_CAKE.get(), block -> createKnifeSliceFeastDrops(block, UbesDelightCakeBlock.BITES, UbesDelightCakeBlock.MAX_BITES, UbesDelightItems.UBE_CAKE_SLICE.get()));
        add(UbesDelightBlocks.LECHE_FLAN_FEAST.get(), block -> createKnifeSliceFeastDrops(block, LecheFlanFeastBlock.BITES, LecheFlanFeastBlock.MAX_BITES, UbesDelightItems.LECHE_FLAN.get()));

        add(UbesDelightBlocks.MILK_TEA_UBE_FEAST.get(), block -> createDrinkableFeastDrops(block, UbesDelightItems.MILK_TEA_UBE.get()));
        add(UbesDelightBlocks.HALO_HALO_FEAST.get(), block -> createDrinkableFeastDrops(block, UbesDelightItems.HALO_HALO.get()));

        // todo - V0.2.0 - these stopped working,
//        createCropDrops(UbesDelightBlocks.UBE_CROP, UbesDelightItems.UBE, UbesDelightItems.UBE,
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.UBE_CROP)
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbeCropBlock.AGE, 7)));
//
//        createCropDrops(UbesDelightBlocks.GARLIC_CROP, UbesDelightItems.GARLIC, UbesDelightItems.GARLIC,
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.GARLIC_CROP)
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GarlicCropBlock.AGE, 7)));
//
//        createCropDrops(UbesDelightBlocks.GINGER_CROP, UbesDelightItems.GINGER, UbesDelightItems.GINGER,
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.GINGER_CROP)
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GingerCropBlock.AGE, 7)));
//
//        createCropDrops(UbesDelightBlocks.LEMONGRASS_STALK_CROP, UbesDelightItems.LEMONGRASS, UbesDelightItems.LEMONGRASS_SEEDS,
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LEMONGRASS_STALK_CROP)
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LemongrassStalkCropBlock.LEMONGRASS_AGE, 5)));
//        createCropDrops(UbesDelightBlocks.LEMONGRASS_LEAF_CROP, UbesDelightItems.LEMONGRASS, UbesDelightItems.LEMONGRASS_SEEDS,
//                LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LEMONGRASS_LEAF_CROP)
//                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LemongrassLeafCropBlock.AGE, 3)));
    }

    private void createGlassCupDrops(Block block, Item item) {
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

    private void dropSimpleLeafFeastContents(Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LEAF_FEAST.get())))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 6))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 5))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 4))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 2))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 1))))
        ));
    }

    private void dropLargeLeafFeastContents(Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LEAF_FEAST.get())))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LargeLeafFeastBlock.SERVINGS, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LargeLeafFeastBlock.SERVINGS, 2))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LargeLeafFeastBlock.SERVINGS, 1))))
        ));
    }

    private void dropContainerLeaftContents(Block block) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LEAF_FEAST.get())))
        ));
    }

    private LootTable.Builder createKnifeSliceFeastDrops(Block block, IntegerProperty bitesProperty, int maxBites, Item servingItem) {
        LootTable.Builder builder = LootTable.lootTable();
        LootItemCondition.Builder knifeCondition = MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIFE));

        for (int bites = maxBites - 1; bites >= 0; bites--) {
            float servingsRemaining = maxBites - bites;
            builder.withPool(LootPool.lootPool()
                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                    .hasProperty(bitesProperty, bites)))
                    .when(knifeCondition)
                    .add(LootItem.lootTableItem(servingItem)
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(servingsRemaining)))));
        }

        return this.applyExplosionDecay(block, builder);
    }

    private LootTable.Builder createDrinkableFeastDrops(Block block, Item servingItem) {
        LootTable.Builder builder = LootTable.lootTable();
        LootItemCondition.Builder knifeCondition = MatchTool.toolMatches(ItemPredicate.Builder.item().of(CommonTags.C_TOOLS_KNIFE));

        for (int servings = DrinkableFeastBlock.MAX_SERVINGS; servings >= 1; servings--) {
            builder.withPool(LootPool.lootPool()
                    .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                            .setProperties(StatePropertiesPredicate.Builder.properties()
                                    .hasProperty(DrinkableFeastBlock.SERVINGS, servings)))
                    .when(knifeCondition)
                    .add(LootItem.lootTableItem(servingItem)
                            .apply(SetItemCountFunction.setCount(ConstantValue.exactly(servings)))));
        }

        return this.applyExplosionDecay(block, builder);
    }
}
