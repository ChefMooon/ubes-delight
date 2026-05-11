package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.common.block.*;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.LargeLeafFeastBlock;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class LootTableGenerator extends FabricBlockLootSubProvider {

    protected LootTableGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generate() {
        HolderGetter<Item> itemGetter = this.registries.lookupOrThrow(Registries.ITEM);

        this.dropSelf(UbesDelightBlocksImpl.KALAN.get());
        this.dropSelf(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get());

        this.dropSelf(UbesDelightBlocksImpl.UBE_CRATE.get());
        this.dropSelf(UbesDelightBlocksImpl.GARLIC_CRATE.get());
        this.dropSelf(UbesDelightBlocksImpl.GINGER_CRATE.get());
        this.dropSelf(UbesDelightBlocksImpl.LEMONGRASS_CRATE.get());

        this.dropSelf(UbesDelightBlocksImpl.LEAF_FEAST.get());
        this.dropOther(UbesDelightBlocksImpl.UNIVERSAL_LEAF_FEAST.get(), UbesDelightItemsImpl.LEAF_FEAST.get());

        this.dropPottedContents(UbesDelightBlocksImpl.POTTED_UBE.get());
        this.dropPottedContents(UbesDelightBlocksImpl.POTTED_GARLIC.get());
        this.dropPottedContents(UbesDelightBlocksImpl.POTTED_GINGER.get());

        this.createGlassCupDrops(UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO, UbesDelightItemsImpl.HALO_HALO);
        this.createGlassCupDrops(UbesDelightBlocksImpl.GLASS_CUP_MILK_TEA_UBE, UbesDelightItemsImpl.MILK_TEA_UBE);

        this.dropLargeLeafFeastContents(UbesDelightBlocksImpl.LUMPIA_FEAST, UbesDelightItemsImpl.LUMPIA);

        this.dropSimpleLeafFeastContents(UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA, UbesDelightItemsImpl.ENSAYMADA);
        this.dropSimpleLeafFeastContents(UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA_UBE, UbesDelightItemsImpl.ENSAYMADA_UBE);
        this.dropSimpleLeafFeastContents(UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL, UbesDelightItemsImpl.PANDESAL);
        this.dropSimpleLeafFeastContents(UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL_UBE, UbesDelightItemsImpl.PANDESAL_UBE);
        this.dropSimpleLeafFeastContents(UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_MUNGGO, UbesDelightItemsImpl.HOPIA_MUNGGO);
        this.dropSimpleLeafFeastContents(UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_UBE, UbesDelightItemsImpl.HOPIA_UBE);
        this.dropContainerLeafContents(UbesDelightBlocksImpl.LEAF_FEAST_COOKED_RICE);
        this.dropContainerLeafContents(UbesDelightBlocksImpl.LEAF_FEAST_FRIED_RICE);
        this.dropContainerLeafContents(UbesDelightBlocksImpl.LEAF_FEAST_SINANGAG);

        this.add(UbesDelightBlocksImpl.UBE_CROP.get(),
                this.createCropDrops(UbesDelightBlocksImpl.UBE_CROP.get(), UbesDelightItemsImpl.UBE.get(), UbesDelightItemsImpl.UBE.get(),
                    LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.UBE_CROP.get())
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbeCropBlock.AGE, 7)))
        );

        this.add(UbesDelightBlocksImpl.GARLIC_CROP.get(),
                this.createCropDrops(UbesDelightBlocksImpl.GARLIC_CROP.get(), UbesDelightItemsImpl.GARLIC.get(), UbesDelightItemsImpl.GARLIC.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.GARLIC_CROP.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GarlicCropBlock.AGE, 7)))
        );

        this.add(UbesDelightBlocksImpl.GINGER_CROP.get(),
                this.createCropDrops(UbesDelightBlocksImpl.GINGER_CROP.get(), UbesDelightItemsImpl.GINGER.get(), UbesDelightItemsImpl.GINGER.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.GINGER_CROP.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GingerCropBlock.AGE, 7)))
        );

        this.add(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get(),
                this.createCropDrops(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get(), UbesDelightItemsImpl.LEMONGRASS.get(), UbesDelightItemsImpl.LEMONGRASS_SEEDS.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LemongrassStalkCropBlock.LEMONGRASS_AGE, 5)))
        );
        this.add(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP.get(),
                this.createCropDrops(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP.get(), UbesDelightItemsImpl.LEMONGRASS.get(), UbesDelightItemsImpl.LEMONGRASS_SEEDS.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LEMONGRASS_LEAF_CROP.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LemongrassLeafCropBlock.AGE, 3)))
        );

        this.createDrinkableFeastDrops(itemGetter, UbesDelightBlocksImpl.HALO_HALO_FEAST.get(), UbesDelightItemsImpl.HALO_HALO.get());
        this.createDrinkableFeastDrops(itemGetter, UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST.get(), UbesDelightItemsImpl.MILK_TEA_UBE.get());

        this.add(UbesDelightBlocksImpl.UBE_CAKE.get(),
                this.applyExplosionDecay(UbesDelightBlocksImpl.UBE_CAKE.get(), LootTable.lootTable())
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 0))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 1))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 2))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 3))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 4))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 5))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 6))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
        );

        this.add(UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get(),
                this.applyExplosionDecay(UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get(), LootTable.lootTable())
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0f)))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 0))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f)))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 1))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f)))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 2))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f)))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 3))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 4))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
        );
    }

    private void createGlassCupDrops(Supplier<Block> blockSupplier, Supplier<Item> itemSupplier) {
        Block block = blockSupplier.get();
        Item item = itemSupplier.get();
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

    private void dropSimpleLeafFeastContents(Supplier<Block> blockSupplier, Supplier<Item> itemSupplier) {
        Block block = blockSupplier.get();
        Item item = itemSupplier.get();
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.LEAF_FEAST.get())))
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

    private void dropLargeLeafFeastContents(Supplier<Block> blockSupplier, Supplier<Item> itemSupplier) {
        Block block = blockSupplier.get();
        Item item = itemSupplier.get();
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.LEAF_FEAST.get())))
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

    private void dropContainerLeafContents(Supplier<Block> blockSupplier) {
        Block block = blockSupplier.get();
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItemsImpl.LEAF_FEAST.get())))
        ));
    }

    private void createDrinkableFeastDrops(HolderGetter<Item> itemGetter, Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 4))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 3))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 2))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 1))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
        ));
    }
}
