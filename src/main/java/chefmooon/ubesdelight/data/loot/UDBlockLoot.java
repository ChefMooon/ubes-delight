package chefmooon.ubesdelight.data.loot;

import chefmooon.ubesdelight.common.block.DrinkableFeastBlock;
import chefmooon.ubesdelight.common.block.GlassCupBlock;
import chefmooon.ubesdelight.common.block.LemongrassLeafCropBlock;
import chefmooon.ubesdelight.common.block.LemongrassStalkCropBlock;
import chefmooon.ubesdelight.common.block.LecheFlanFeastBlock;
import chefmooon.ubesdelight.common.block.UbesDelightCakeBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.LargeLeafFeastBlock;
import chefmooon.ubesdelight.common.block.leaf_feast.base.SimpleLeafFeastBlock;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.EntryGroup;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.loot.CanItemPerformAbility;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;

public class UDBlockLoot extends BlockLootSubProvider {
    public UDBlockLoot(HolderLookup.Provider holder) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), holder);
    }

    @Override
    protected void generate() {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        dropSelf(UbesDelightBlocks.KALAN.get());
        dropSelf(UbesDelightBlocks.BAKING_MAT_BAMBOO.get());

        dropSelf(UbesDelightBlocks.UBE_CRATE.get());
        dropSelf(UbesDelightBlocks.GARLIC_CRATE.get());
        dropSelf(UbesDelightBlocks.GINGER_CRATE.get());
        dropSelf(UbesDelightBlocks.LEMONGRASS_CRATE.get());

        dropSelf(UbesDelightBlocks.LEAF_FEAST.get());
        dropOther(UbesDelightBlocks.UNIVERSAL_LEAF_FEAST.get(), UbesDelightBlocks.LEAF_FEAST.get());

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
        dropContainerLeafContents(UbesDelightBlocks.LEAF_FEAST_COOKED_RICE.get());
        dropContainerLeafContents(UbesDelightBlocks.LEAF_FEAST_FRIED_RICE.get());
        dropContainerLeafContents(UbesDelightBlocks.LEAF_FEAST_SINANGAG.get());

        add(UbesDelightBlocks.WILD_UBE.get(), block -> wildCrop(block, UbesDelightItems.UBE.get(), UbesDelightItems.UBE.get(), registryLookup));
        add(UbesDelightBlocks.WILD_GARLIC.get(), block -> wildCrop(block, UbesDelightItems.GARLIC.get(), UbesDelightItems.GARLIC.get(), registryLookup));
        add(UbesDelightBlocks.WILD_GINGER.get(), block -> wildCrop(block, UbesDelightItems.GINGER.get(), UbesDelightItems.GINGER.get(), registryLookup));
        add(UbesDelightBlocks.WILD_LEMONGRASS.get(), this::createWildLemongrassDrops);

        add(UbesDelightBlocks.UBE_CROP.get(), block -> createSeedlessCropDrops(block, UbesDelightItems.UBE.get(), registryLookup));
        add(UbesDelightBlocks.GARLIC_CROP.get(), block -> createSeedlessCropDrops(block, UbesDelightItems.GARLIC.get(), registryLookup));
        add(UbesDelightBlocks.GINGER_CROP.get(), block -> createSeedlessCropDrops(block, UbesDelightItems.GINGER.get(), registryLookup));
        add(UbesDelightBlocks.LEMONGRASS_LEAF_CROP.get(), block -> createLemongrassLeafCropDrops(block, registryLookup));
        add(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), block -> createLemongrassStalkCropDrops(block, registryLookup));

        add(UbesDelightBlocks.UBE_CAKE.get(), block -> createKnifeSliceFeastDrops(block, UbesDelightCakeBlock.BITES, UbesDelightCakeBlock.MAX_BITES, UbesDelightItems.UBE_CAKE_SLICE.get()));
        add(UbesDelightBlocks.LECHE_FLAN_FEAST.get(), block -> createKnifeSliceFeastDrops(block, LecheFlanFeastBlock.BITES, LecheFlanFeastBlock.MAX_BITES, UbesDelightItems.LECHE_FLAN.get()));

        add(UbesDelightBlocks.MILK_TEA_UBE_FEAST.get(), block -> createDrinkableFeastDrops(block, UbesDelightItems.MILK_TEA_UBE.get()));
        add(UbesDelightBlocks.HALO_HALO_FEAST.get(), block -> createDrinkableFeastDrops(block, UbesDelightItems.HALO_HALO.get()));

    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return UbesDelightBlocks.BLOCKS.getEntries().stream().map(DeferredHolder::value).collect(Collectors.toList());
    }

    private void createGlassCupDrops(Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(GlassCupBlock.SERVINGS, 3))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(GlassCupBlock.SERVINGS, 2))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(GlassCupBlock.SERVINGS, 1))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(GlassCupBlock.SERVINGS, 0))))
        ));
    }

    private void dropSimpleLeafFeastContents(Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LEAF_FEAST.get())))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SimpleLeafFeastBlock.SERVINGS, 6))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SimpleLeafFeastBlock.SERVINGS, 5))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SimpleLeafFeastBlock.SERVINGS, 4))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SimpleLeafFeastBlock.SERVINGS, 3))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SimpleLeafFeastBlock.SERVINGS, 2))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(SimpleLeafFeastBlock.SERVINGS, 1))))
        ));
    }

    private void dropLargeLeafFeastContents(Block block, Item item) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LEAF_FEAST.get())))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(LargeLeafFeastBlock.SERVINGS, 3))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(LargeLeafFeastBlock.SERVINGS, 2))))
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(LargeLeafFeastBlock.SERVINGS, 1))))
        ));
    }

    private void dropContainerLeafContents(Block block) {
        this.add(block, this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(UbesDelightItems.LEAF_FEAST.get())))
        ));
    }

    private LootTable.Builder wildCrop(Block block, Item crop, Item seeds, HolderLookup.RegistryLookup<Enchantment> registryLookup) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(block)
                                        .when(CanItemPerformAbility.canItemPerformAbility(ItemAbilities.SHEARS_HARVEST)),
                                LootItem.lootTableItem(crop)
                                        .apply(ApplyExplosionDecay.explosionDecay())
                                        .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2)))));
    }

    private LootTable.Builder createSeedlessCropDrops(Block block, Item cropItem, HolderLookup.RegistryLookup<Enchantment> registryLookup) {
        LootItemCondition.Builder maxAgeCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, CropBlock.MAX_AGE));
        return this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(LootItem.lootTableItem(cropItem)))
                .withPool(LootPool.lootPool()
                        .when(maxAgeCondition)
                        .add(LootItem.lootTableItem(cropItem)
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3)))));
    }

    private LootTable.Builder createWildLemongrassDrops(Block block) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(UbesDelightItems.WILD_LEMONGRASS.get())
                                        .when(CanItemPerformAbility.canItemPerformAbility(ItemAbilities.SHEARS_DIG)),
                                LootItem.lootTableItem(UbesDelightItems.WILD_LEMONGRASS.get())
                                        .when(this.hasSilkTouch()),
                                EntryGroup.list(
                                        LootItem.lootTableItem(UbesDelightItems.LEMONGRASS_SEEDS.get())
                                                .when(ExplosionCondition.survivesExplosion()),
                                        LootItem.lootTableItem(UbesDelightItems.LEMONGRASS.get())
                                                .when(ExplosionCondition.survivesExplosion())
                                                .when(LootItemRandomChanceCondition.randomChance(0.125F)))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)))
                        .when(LocationCheck.checkLocation(LocationPredicate.Builder.location()
                                .setBlock(BlockPredicate.Builder.block().of(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))), new BlockPos(0, 1, 0))))
                .withPool(LootPool.lootPool()
                        .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(UbesDelightItems.WILD_LEMONGRASS.get())
                                        .when(CanItemPerformAbility.canItemPerformAbility(ItemAbilities.SHEARS_DIG)),
                                LootItem.lootTableItem(UbesDelightItems.WILD_LEMONGRASS.get())
                                        .when(this.hasSilkTouch()),
                                EntryGroup.list(
                                        LootItem.lootTableItem(UbesDelightItems.LEMONGRASS_SEEDS.get())
                                                .when(ExplosionCondition.survivesExplosion()),
                                        LootItem.lootTableItem(UbesDelightItems.LEMONGRASS.get())
                                                .when(ExplosionCondition.survivesExplosion())
                                                .when(LootItemRandomChanceCondition.randomChance(0.125F)))))
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                        .hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER)))
                        .when(LocationCheck.checkLocation(LocationPredicate.Builder.location()
                                .setBlock(BlockPredicate.Builder.block().of(block)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))), new BlockPos(0, -1, 0))));
    }

    private LootTable.Builder createLemongrassLeafCropDrops(Block block, HolderLookup.RegistryLookup<Enchantment> registryLookup) {
        LootItemCondition.Builder maxAgeCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                .setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(LemongrassLeafCropBlock.lEMONGRASS_AGE, LemongrassLeafCropBlock.MAX_AGE));

        return this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .when(maxAgeCondition)
                        .add(LootItem.lootTableItem(UbesDelightItems.LEMONGRASS.get())
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 2)))));
    }

    private LootTable.Builder createLemongrassStalkCropDrops(Block block, HolderLookup.RegistryLookup<Enchantment> registryLookup) {
        LootItemCondition.Builder maxAgeCondition = LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                .setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(LemongrassStalkCropBlock.LEMONGRASS_AGE, LemongrassStalkCropBlock.MAX_AGE));

        return this.applyExplosionDecay(block, LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .add(AlternativesEntry.alternatives(
                                LootItem.lootTableItem(UbesDelightItems.LEMONGRASS.get()).when(maxAgeCondition),
                                LootItem.lootTableItem(UbesDelightItems.LEMONGRASS_SEEDS.get()))))
                .withPool(LootPool.lootPool()
                        .when(maxAgeCondition)
                        .add(LootItem.lootTableItem(UbesDelightItems.LEMONGRASS_SEEDS.get())
                                .apply(ApplyBonusCount.addBonusBinomialDistributionCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 2)))));
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
