package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.block.*;
import chefmooon.ubesdelight.common.block.leaf_feast.base.LargeLeafFeastBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
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

        this.dropSelf(UbesDelightBlocks.KALAN.get());
        this.dropSelf(UbesDelightBlocks.BAKING_MAT_BAMBOO.get());

        this.dropSelf(UbesDelightBlocks.UBE_CRATE.get());
        this.dropSelf(UbesDelightBlocks.GARLIC_CRATE.get());
        this.dropSelf(UbesDelightBlocks.GINGER_CRATE.get());
        this.dropSelf(UbesDelightBlocks.LEMONGRASS_CRATE.get());

        this.dropSelf(UbesDelightBlocks.LEAF_FEAST.get());
        this.dropOther(UbesDelightBlocks.UNIVERSAL_LEAF_FEAST.get(), UbesDelightItems.LEAF_FEAST.get());

        this.dropPottedContents(UbesDelightBlocks.POTTED_UBE.get());
        this.dropPottedContents(UbesDelightBlocks.POTTED_GARLIC.get());
        this.dropPottedContents(UbesDelightBlocks.POTTED_GINGER.get());

        this.createGlassCupDrops(UbesDelightBlocks.GLASS_CUP_HALO_HALO, UbesDelightItems.HALO_HALO);
        this.createGlassCupDrops(UbesDelightBlocks.GLASS_CUP_MILK_TEA_UBE, UbesDelightItems.MILK_TEA_UBE);

        this.dropLargeLeafFeastContents(UbesDelightBlocks.LUMPIA_FEAST, UbesDelightItems.LUMPIA);

        this.dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA, UbesDelightItems.ENSAYMADA);
        this.dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE, UbesDelightItems.ENSAYMADA_UBE);
        this.dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_PANDESAL, UbesDelightItems.PANDESAL);
        this.dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE, UbesDelightItems.PANDESAL_UBE);
        this.dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO, UbesDelightItems.HOPIA_MUNGGO);
        this.dropSimpleLeafFeastContents(UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE, UbesDelightItems.HOPIA_UBE);
        this.dropContainerLeafContents(UbesDelightBlocks.LEAF_FEAST_COOKED_RICE);
        this.dropContainerLeafContents(UbesDelightBlocks.LEAF_FEAST_FRIED_RICE);
        this.dropContainerLeafContents(UbesDelightBlocks.LEAF_FEAST_SINANGAG);

        this.add(UbesDelightBlocks.UBE_CROP.get(),
                this.createCropDrops(UbesDelightBlocks.UBE_CROP.get(), UbesDelightItems.UBE.get(), UbesDelightItems.UBE.get(),
                    LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.UBE_CROP.get())
                            .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbeCropBlock.AGE, 7)))
        );

        this.add(UbesDelightBlocks.GARLIC_CROP.get(),
                this.createCropDrops(UbesDelightBlocks.GARLIC_CROP.get(), UbesDelightItems.GARLIC.get(), UbesDelightItems.GARLIC.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.GARLIC_CROP.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GarlicCropBlock.AGE, 7)))
        );

        this.add(UbesDelightBlocks.GINGER_CROP.get(),
                this.createCropDrops(UbesDelightBlocks.GINGER_CROP.get(), UbesDelightItems.GINGER.get(), UbesDelightItems.GINGER.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.GINGER_CROP.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GingerCropBlock.AGE, 7)))
        );

        this.add(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(),
                this.createCropDrops(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), UbesDelightItems.LEMONGRASS.get(), UbesDelightItems.LEMONGRASS_SEEDS.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LemongrassStalkCropBlock.LEMONGRASS_AGE, 5)))
        );
        this.add(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(),
                this.createCropDrops(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), UbesDelightItems.LEMONGRASS.get(), UbesDelightItems.LEMONGRASS_SEEDS.get(),
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LemongrassLeafCropBlock.AGE, 3)))
        );

        this.createDrinkableFeastDrops(itemGetter, UbesDelightBlocks.HALO_HALO_FEAST.get(), UbesDelightItems.HALO_HALO.get());
        this.createDrinkableFeastDrops(itemGetter, UbesDelightBlocks.MILK_TEA_UBE_FEAST.get(), UbesDelightItems.MILK_TEA_UBE.get());

        this.add(UbesDelightBlocks.UBE_CAKE.get(),
                this.applyExplosionDecay(UbesDelightBlocks.UBE_CAKE.get(), LootTable.lootTable())
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 0))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 1))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 2))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 3))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 4))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 5))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f))))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 6))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
        );

        this.add(UbesDelightBlocks.LECHE_FLAN_FEAST.get(),
                this.applyExplosionDecay(UbesDelightBlocks.LECHE_FLAN_FEAST.get(), LootTable.lootTable())
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0f)))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LECHE_FLAN_FEAST.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 0))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f)))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LECHE_FLAN_FEAST.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 1))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0f)))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LECHE_FLAN_FEAST.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 2))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f)))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LECHE_FLAN_FEAST.get())
                                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 3))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f)))
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LECHE_FLAN_FEAST.get())
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

    private void dropLargeLeafFeastContents(Supplier<Block> blockSupplier, Supplier<Item> itemSupplier) {
        Block block = blockSupplier.get();
        Item item = itemSupplier.get();
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

    private void dropContainerLeafContents(Supplier<Block> blockSupplier) {
        Block block = blockSupplier.get();
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LEAF_FEAST.get())))
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
