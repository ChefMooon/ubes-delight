package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.block.*;
import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.state.property.IntProperty;

public class LootTableGenerator extends FabricBlockLootTableProvider {

    public LootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(BlocksRegistry.GLASS_CUP_HALO_HALO.get(),
                LootTable.builder().pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag(CommonTags.C_TOOLS_KNIVES)))
                        .with(ItemEntry.builder(BlocksRegistry.GLASS_CUP_HALO_HALO.get()))));

        addDrop(BlocksRegistry.KALAN.get());

        addDrop(BlocksRegistry.BAKING_MAT_BAMBOO.get());

        addDrop(BlocksRegistry.UBE_CRATE.get());
        addDrop(BlocksRegistry.GARLIC_CRATE.get());
        addDrop(BlocksRegistry.GINGER_CRATE.get());
        addDrop(BlocksRegistry.LEMONGRASS_CRATE.get());

        addCustomCropDrop(BlocksRegistry.UBE_CROP.get(),
                ItemsRegistry.UBE.get(),
                ItemsRegistry.UBE.get(),
                0.5714286F, 2, UbeCropBlock.AGE, 7);
        addCustomCropDrop(BlocksRegistry.GARLIC_CROP.get(),
                ItemsRegistry.GARLIC.get(),
                ItemsRegistry.GARLIC.get(),
                0.5714286F, 2, GarlicCropBlock.AGE, 7);
        addCustomCropDrop(BlocksRegistry.GINGER_CROP.get(),
                ItemsRegistry.GINGER.get(),
                ItemsRegistry.GINGER.get(),
                0.5714286F, 2, GingerCropBlock.AGE, 7);
        addCustomCropDrop(BlocksRegistry.LEMONGRASS_STALK_CROP.get(),
                ItemsRegistry.LEMONGRASS.get(),
                ItemsRegistry.LEMONGRASS_SEEDS.get(),
                0.5714286F, 2, LemongrassLeafCropBlock.AGE, 5);
        addCustomDrop(BlocksRegistry.LEMONGRASS_LEAF_CROP.get(), LemongrassLeafCropBlock.AGE, 3, ItemsRegistry.LEMONGRASS, 0.5714286F, 2);

        //TODO: remove in V0.1.5
        addCustomCropDrop(BlocksRegistry.LEMONGRASS_CROP.get(),
                ItemsRegistry.LEMONGRASS.get(),
                ItemsRegistry.LEMONGRASS_SEEDS.get(),
                0.5714286F, 2, LemongrassCropBlock.AGE, 7);

        //TODO: add wild crops, drop with shears
    }

    private void addCustomCropDrop(Block crop, Item product, Item seeds, Float probability, Integer extra, IntProperty property, Integer propertyValue) {
        LootCondition.Builder lootCondition = BlockStatePropertyLootCondition.builder(crop).properties(StatePredicate.Builder.create().exactMatch(property, propertyValue));
        addDrop(crop, (LootTable.Builder)this.applyExplosionDecay(crop, LootTable.builder()
                .pool(LootPool.builder().with(ItemEntry.builder(product).conditionally(lootCondition).alternatively(ItemEntry.builder(seeds))))
                .pool(LootPool.builder().conditionally(lootCondition).with(ItemEntry.builder(seeds)
                        .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, probability, extra))))));
    }

    private void addCustomDrop(Block block, IntProperty property, Integer propertyValue, ItemsRegistry drop, Float probability, Integer extra) {
        LootCondition.Builder lootCondition = BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(property, propertyValue));
        addDrop(block, (LootTable.Builder)this.applyExplosionDecay(block, LootTable.builder()
                .pool(LootPool.builder().conditionally(lootCondition).with(ItemEntry.builder(drop.get())
                        .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, probability, extra))))));
    }

    private void addWildCropDrop(Block block, ItemsRegistry drop, Float probability, Integer extra) {
        //addDrop(block, );
    }
}
