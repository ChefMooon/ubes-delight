package chefmooon.ubesdelight.data.loot;

import chefmooon.ubesdelight.common.block.*;
import chefmooon.ubesdelight.common.block.leaf_feast.base.LargeLeafFeastBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.advancements.predicates.BlockPredicate;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.advancements.predicates.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.EntryGroup;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import vectorwing.farmersdelight.refabricated.CanItemPerformAbility;
import vectorwing.farmersdelight.refabricated.ItemAbility;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class UDBlockLootTableGenerator extends FabricBlockLootSubProvider {

        private final CompletableFuture<HolderLookup.Provider> lookup;
    private HolderLookup.Provider registries;

    public UDBlockLootTableGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
        this.lookup = registryLookup;
    }

    @Override
    public void generate() {
        try {
            this.registries = lookup.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        HolderLookup.RegistryLookup<Block> blockLookup = this.registries.lookupOrThrow(Registries.BLOCK);
        HolderGetter<Item> itemGetter = this.registries.lookupOrThrow(Registries.ITEM);
        HolderLookup.RegistryLookup<Enchantment> enchantmentLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

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
                    hasBlockStateProperties(UbesDelightBlocks.UBE_CROP.get(), StatePropertiesPredicate.Builder.properties().hasProperty(UbeCropBlock.AGE, 7)))
        );

        this.add(UbesDelightBlocks.GARLIC_CROP.get(),
                this.createCropDrops(UbesDelightBlocks.GARLIC_CROP.get(), UbesDelightItems.GARLIC.get(), UbesDelightItems.GARLIC.get(),
                        hasBlockStateProperties(UbesDelightBlocks.GARLIC_CROP.get(), StatePropertiesPredicate.Builder.properties().hasProperty(GarlicCropBlock.AGE, 7)))
        );

        this.add(UbesDelightBlocks.GINGER_CROP.get(),
                this.createCropDrops(UbesDelightBlocks.GINGER_CROP.get(), UbesDelightItems.GINGER.get(), UbesDelightItems.GINGER.get(),
                        hasBlockStateProperties(UbesDelightBlocks.GINGER_CROP.get(), StatePropertiesPredicate.Builder.properties().hasProperty(GingerCropBlock.AGE, 7)))
        );

        this.add(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(),
                this.createCropDrops(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), UbesDelightItems.LEMONGRASS.get(), UbesDelightItems.LEMONGRASS_SEEDS.get(),
                        hasBlockStateProperties(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), StatePropertiesPredicate.Builder.properties().hasProperty(LemongrassStalkCropBlock.LEMONGRASS_AGE, 5)))
        );
        this.add(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(),
                this.createCropDrops(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), UbesDelightItems.LEMONGRASS.get(), UbesDelightItems.LEMONGRASS_SEEDS.get(),
                        hasBlockStateProperties(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), StatePropertiesPredicate.Builder.properties().hasProperty(LemongrassLeafCropBlock.AGE, 3)))
        );

        add(UbesDelightBlocks.WILD_UBE.get(), block -> wildCrop(block, UbesDelightItems.UBE.get(), UbesDelightItems.UBE.get(), enchantmentLookup));
        add(UbesDelightBlocks.WILD_GARLIC.get(), block -> wildCrop(block, UbesDelightItems.GARLIC.get(), UbesDelightItems.GARLIC.get(), enchantmentLookup));
        add(UbesDelightBlocks.WILD_GINGER.get(), block -> wildCrop(block, UbesDelightItems.GINGER.get(), UbesDelightItems.GINGER.get(), enchantmentLookup));
        add(UbesDelightBlocks.WILD_LEMONGRASS.get(), block -> LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(UbesDelightItems.WILD_LEMONGRASS.get())
                                        .when(CanItemPerformAbility.canItemPerformAbility(ItemAbility.SHEARS_HARVEST)),
                                EntryGroup.list(
                                        LootItem.lootTableItem(UbesDelightItems.LEMONGRASS_SEEDS.get())
                                                .when(ExplosionCondition.survivesExplosion()),
                                        LootItem.lootTableItem(UbesDelightItems.LEMONGRASS.get())
                                                .when(ExplosionCondition.survivesExplosion())
                                                .when(LootItemRandomChanceCondition.randomChance(0.125F)))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties()
                                .hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)))
                        .when(LocationCheck.checkLocation(LocationPredicate.Builder.location()
                                .setBlock(BlockPredicate.Builder.block().of(blockLookup, block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))), new BlockPos(0, 1, 0))))
                .withPool(LootPool.lootPool()
                        .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(UbesDelightBlocks.WILD_LEMONGRASS.get())
                                        .when(CanItemPerformAbility.canItemPerformAbility(ItemAbility.SHEARS_HARVEST)),
                                EntryGroup.list(
                                        LootItem.lootTableItem(UbesDelightItems.LEMONGRASS_SEEDS.get())
                                                .when(ExplosionCondition.survivesExplosion()),
                                        LootItem.lootTableItem(UbesDelightItems.LEMONGRASS.get())
                                                .when(ExplosionCondition.survivesExplosion())
                                                .when(LootItemRandomChanceCondition.randomChance(0.125F)))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties()
                                .hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER)))
                        .when(LocationCheck.checkLocation(LocationPredicate.Builder.location()
                                .setBlock(BlockPredicate.Builder.block().of(blockLookup, block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))), new BlockPos(0, -1, 0)))));

        this.createDrinkableFeastDrops(itemGetter, UbesDelightBlocks.HALO_HALO_FEAST.get(), UbesDelightItems.HALO_HALO.get());
        this.createDrinkableFeastDrops(itemGetter, UbesDelightBlocks.MILK_TEA_UBE_FEAST.get(), UbesDelightItems.MILK_TEA_UBE.get());

        this.add(UbesDelightBlocks.UBE_CAKE.get(),
                this.applyExplosionDecay(UbesDelightBlocks.UBE_CAKE.get(), LootTable.lootTable())
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(7))))
                                .when(hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get(), StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 0))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(6))))
                                .when(hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get() , StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 1))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(5))))
                                .when(hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get(), StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 2))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(4))))
                                .when(hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get(), StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 3))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(3))))
                                .when(hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get(), StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 4))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(2))))
                                .when(hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get(), StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 5))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.UBE_CAKE_SLICE.get()).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                                .when(hasBlockStateProperties(UbesDelightBlocks.UBE_CAKE.get(), StatePropertiesPredicate.Builder.properties().hasProperty(UbesDelightCakeBlock.BITES, 6))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
        );

        this.add(UbesDelightBlocks.LECHE_FLAN_FEAST.get(),
                this.applyExplosionDecay(UbesDelightBlocks.LECHE_FLAN_FEAST.get(), LootTable.lootTable())
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(5)))
                                .when(hasBlockStateProperties(UbesDelightBlocks.LECHE_FLAN_FEAST.get(), StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 0))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(4)))
                                .when(hasBlockStateProperties(UbesDelightBlocks.LECHE_FLAN_FEAST.get(), StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 1))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(3)))
                                .when(hasBlockStateProperties(UbesDelightBlocks.LECHE_FLAN_FEAST.get(), StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 2))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(2)))
                                .when(hasBlockStateProperties(UbesDelightBlocks.LECHE_FLAN_FEAST.get(), StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 3))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                        .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LECHE_FLAN.get())).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1)))
                                .when(hasBlockStateProperties(UbesDelightBlocks.LECHE_FLAN_FEAST.get(), StatePropertiesPredicate.Builder.properties().hasProperty(LecheFlanFeastBlock.BITES, 4))
                                        .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
        );
    }

    private void createGlassCupDrops(Supplier<Block> blockSupplier, Supplier<Item> itemSupplier) {
        Block block = blockSupplier.get();
        Item item = itemSupplier.get();
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(4))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(3))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 2))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(2))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 1))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(GlassCupBlock.SERVINGS, 0))))
        ));
    }

    private void dropSimpleLeafFeastContents(Supplier<Block> blockSupplier, Supplier<Item> itemSupplier) {
        Block block = blockSupplier.get();
        Item item = itemSupplier.get();
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LEAF_FEAST.get())))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(6))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 6))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(5))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 5))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(4))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 4))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(3))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(2))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 2))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(SimpleLeafFeastBlock.SERVINGS, 1))))
        ));
    }

    private void dropLargeLeafFeastContents(Supplier<Block> blockSupplier, Supplier<Item> itemSupplier) {
        Block block = blockSupplier.get();
        Item item = itemSupplier.get();
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LEAF_FEAST.get())))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(3))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(LargeLeafFeastBlock.SERVINGS, 3))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(2))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(LargeLeafFeastBlock.SERVINGS, 2))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(LargeLeafFeastBlock.SERVINGS, 1))))
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
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(4))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 4))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(3))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 3))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(2))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 2))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(1))))
                        .when(hasBlockStateProperties(block, StatePropertiesPredicate.Builder.properties().hasProperty(DrinkableFeastBlock.SERVINGS, 1))
                                .and(MatchTool.toolMatches(ItemPredicate.Builder.item().of(itemGetter, CommonTags.C_TOOLS_KNIFE)))))
        ));
    }

    protected LootTable.Builder wildCrop(Block block, Item crop, Item seeds, HolderLookup.RegistryLookup<Enchantment> registryLookup) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(LootItem.lootTableItem(crop))
                        .when(LootItemRandomChanceCondition.randomChance(0.2F))
                        .when(CanItemPerformAbility.canItemPerformAbility(ItemAbility.SHEARS_HARVEST).invert()))
                .withPool(LootPool.lootPool()
                        .setRolls(ContextIntProviders.exactly(1))
                        .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(block)
                                        .when(CanItemPerformAbility.canItemPerformAbility(ItemAbility.SHEARS_HARVEST)),
                                LootItem.lootTableItem(seeds)
                                        .apply(ApplyExplosionDecay.explosionDecay())
                                        .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2)))));
    }

    private LootItemCondition.Builder hasBlockStateProperties(Block block, StatePropertiesPredicate.Builder builder) {
        return MatchBlock.blockMatches(registries.lookupOrThrow(Registries.BLOCK), block, builder);
    }
}
