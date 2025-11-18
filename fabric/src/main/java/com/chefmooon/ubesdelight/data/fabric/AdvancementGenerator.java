package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.common.advancement.BakingMatTrigger;
import com.chefmooon.ubesdelight.common.advancement.LeafFeastConsumeTrigger;
import com.chefmooon.ubesdelight.common.advancement.LeafFeastInsertTrigger;
import com.chefmooon.ubesdelight.common.block.leaf_feast.base.LeafFeastBlock;
import com.chefmooon.ubesdelight.common.core.LeafFeastTypes;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemUsedOnLocationTrigger;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AdvancementGenerator extends FabricAdvancementProvider {
    protected AdvancementGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(new ItemStack(UbesDelightItemsImpl.UBE.get()),
                        TextUtils.getTranslatable("advancement.root"),
                        TextUtils.getTranslatable("advancement.root.desc"),
                        ResourceLocation.withDefaultNamespace("block/bamboo_block"),
                        AdvancementType.TASK, false, false, false)
                .addCriterion(RecipeProvider.getHasName(Items.WHEAT_SEEDS), InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .build(getAdvancementName("root"));
        consumer.accept(root);

        AdvancementHolder getUDSeed = getAdvancement(root, UbesDelightItemsImpl.WILD_UBE.get(), "get_ud_seed", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.GINGER.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.GINGER.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.GARLIC.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.GARLIC.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEMONGRASS_SEEDS.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEMONGRASS_SEEDS.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("get_ud_seed"));
        consumer.accept(getUDSeed);

        AdvancementHolder plantAllCrops = getAdvancement(getUDSeed, UbesDelightItemsImpl.LEMONGRASS.get(), "plant_all_crops", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.UBE.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.UBE_CROP.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.GINGER.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.GINGER_CROP.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.GARLIC.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.GARLIC_CROP.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEMONGRASS_SEEDS.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get()))
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(getAdvancementName("plant_all_crops"));
        consumer.accept(plantAllCrops);

        AdvancementHolder craftRollingPin = getAdvancement(root, UbesDelightItemsImpl.ROLLING_PIN_WOOD.get(), "craft_rolling_pin", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_WOOD.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_WOOD.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_IRON.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_IRON.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_GOLD.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_GOLD.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_DIAMOND.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_DIAMOND.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("craft_rolling_pin"));
        consumer.accept(craftRollingPin);

        AdvancementHolder craftBakingMat = getAdvancement(craftRollingPin, UbesDelightItemsImpl.BAKING_MAT_BAMBOO.get(), "craft_baking_mat", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.BAKING_MAT_BAMBOO.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.BAKING_MAT_BAMBOO.get()))
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(getAdvancementName("craft_baking_mat"));
        consumer.accept(craftBakingMat);

        AdvancementHolder useBakingMat = getAdvancement(craftBakingMat, UbesDelightItemsImpl.ENSAYMADA_UBE_RAW.get(), "use_baking_mat", AdvancementType.TASK, true, false, false)
                .addCriterion("use_baking_mat", BakingMatTrigger.TriggerInstance.simple())
                .build(getAdvancementName("use_baking_mat"));
        consumer.accept(useBakingMat);

        AdvancementHolder masterBaker = getAdvancement(useBakingMat, UbesDelightItemsImpl.ENSAYMADA_UBE.get(), "master_baker", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.PANDESAL.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.PANDESAL.get()))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.PANDESAL_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.PANDESAL_UBE.get()))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.ENSAYMADA.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ENSAYMADA.get()))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.ENSAYMADA_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ENSAYMADA_UBE.get()))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.HOPIA_MUNGGO.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.HOPIA_MUNGGO.get()))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.HOPIA_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.HOPIA_UBE.get()))
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(getAdvancementName("master_baker"));
        consumer.accept(masterBaker);

        AdvancementHolder netheriteRollingPin = getAdvancement(craftBakingMat, UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get(), "netherite_rolling_pin", AdvancementType.CHALLENGE, true, true, true)
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get()))
                .rewards(AdvancementRewards.Builder.experience(200))
                .build(getAdvancementName("netherite_rolling_pin"));
        consumer.accept(netheriteRollingPin);

        AdvancementHolder placeKalan = getAdvancement(root, UbesDelightItemsImpl.KALAN.get(), "place_kalan", AdvancementType.TASK, true, true, false)
                .addCriterion("place_kalan", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.KALAN.get()))
                .build(getAdvancementName("place_kalan"));
        consumer.accept(placeKalan);

        AdvancementHolder ubeMaster = getAdvancement(placeKalan, UbesDelightItemsImpl.UBE_CAKE_SLICE.get(), "ube_master", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.COOKIE_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.COOKIE_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.UBE_CAKE_SLICE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.UBE_CAKE_SLICE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.POLVORONE_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.POLVORONE_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ENSAYMADA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.ENSAYMADA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.PANDESAL_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.PANDESAL_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.HOPIA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.HOPIA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.MILK_TEA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.MILK_TEA_UBE.get()))
                .rewards(AdvancementRewards.Builder.experience(50))
                .build(getAdvancementName("ube_master"));
        consumer.accept(ubeMaster);

        AdvancementHolder placeDrinkableFeast = getAdvancement(placeKalan, UbesDelightItemsImpl.HALO_HALO_FEAST.get(), "place_drinkable_feast", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.HALO_HALO_FEAST.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.HALO_HALO_FEAST.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("place_drinkable_feast"));
        consumer.accept(placeDrinkableFeast);

        AdvancementHolder leafFeast = getAdvancement(root, Items.OAK_LEAVES, "leaf_feast", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.LEAF_FEAST.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST.get()))
                .build(getAdvancementName("leaf_feast"));
        consumer.accept(leafFeast);

        AdvancementHolder placeLeafFeast = getAdvancement(leafFeast, UbesDelightItemsImpl.LEAF_FEAST.get(), "place_leaf_feast", AdvancementType.TASK, true, true, false)
                .addCriterion("place_" + RecipeProvider.getHasName(UbesDelightItemsImpl.LEAF_FEAST.get()) + "_tip",
                        ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LEAF_FEAST.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LeafFeastBlock.LEAF_FEAST_TYPE, LeafFeastTypes.TIP))))
                .addCriterion("place_" + RecipeProvider.getHasName(UbesDelightItemsImpl.LEAF_FEAST.get()) + "_end",
                        ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LEAF_FEAST.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LeafFeastBlock.LEAF_FEAST_TYPE, LeafFeastTypes.END))))
                .addCriterion("place_" + RecipeProvider.getHasName(UbesDelightItemsImpl.LEAF_FEAST.get()) + "_middle",
                        ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LEAF_FEAST.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LeafFeastBlock.LEAF_FEAST_TYPE, LeafFeastTypes.MIDDLE))))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("place_leaf_feast"));
        consumer.accept(placeLeafFeast);

        AdvancementHolder useLeafFeast = getAdvancement(placeLeafFeast, UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_HALF.get(), "use_leaf_feast", AdvancementType.TASK, true, false, false)
                .addCriterion("use_leaf_feast_insert", LeafFeastInsertTrigger.TriggerInstance.simple())
                .build(getAdvancementName("use_leaf_feast"));
        consumer.accept(useLeafFeast);

        AdvancementHolder boodleFight = getAdvancement(useLeafFeast, UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA.get(), "boodle_fight", AdvancementType.TASK, true, false, false)
                .addCriterion("use_leaf_feast_consume", LeafFeastConsumeTrigger.TriggerInstance.simple())
                .build(getAdvancementName("boodle_fight"));
        consumer.accept(boodleFight);

        AdvancementHolder leafFeastMaster = getAdvancement(leafFeast, UbesDelightItemsImpl.LUMPIA_FEAST.get(), "leaf_feast_master", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LUMPIA_FEAST.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LUMPIA_FEAST.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_SINANGAG.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_SINANGAG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_SINANGAG_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_SINANGAG_HALF.get()))
                .rewards(AdvancementRewards.Builder.experience(50))
                .build(getAdvancementName("leaf_feast_master"));
        consumer.accept(leafFeastMaster);

        AdvancementHolder udMaster = getAdvancement(placeDrinkableFeast, UbesDelightItemsImpl.UBE_CAKE.get(), "ud_master", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.MILK_TEA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.MILK_TEA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.HALO_HALO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.HALO_HALO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.SINANGAG.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.SINANGAG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.KINILAW.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.KINILAW.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LUMPIA.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.LUMPIA.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.TOCINO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.TOCINO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.CHICKEN_INASAL.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.CHICKEN_INASAL.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.CHICKEN_INASAL_RICE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.CHICKEN_INASAL_RICE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.TOSILOG.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.TOSILOG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.BANGSILOG.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.BANGSILOG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.SISIG.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.SISIG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.BULALO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.BULALO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ARROZ_CALDO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.ARROZ_CALDO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.MECHADO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.MECHADO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.COOKIE_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.COOKIE_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.COOKIE_GINGER.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.COOKIE_GINGER.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LECHE_FLAN.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.LECHE_FLAN.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.UBE_CAKE_SLICE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.UBE_CAKE_SLICE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.POLVORONE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.POLVORONE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.POLVORONE_PINIPIG.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.POLVORONE_PINIPIG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.POLVORONE_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.POLVORONE_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.POLVORONE_CC.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.POLVORONE_CC.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.PANDESAL.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.PANDESAL.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.PANDESAL_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.PANDESAL_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ENSAYMADA.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.ENSAYMADA.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ENSAYMADA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.ENSAYMADA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.HOPIA_MUNGGO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.HOPIA_MUNGGO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.HOPIA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItemsImpl.HOPIA_UBE.get()))
                .rewards(AdvancementRewards.Builder.experience(200))
                .build(getAdvancementName("ud_master"));
        consumer.accept(udMaster);
    }

    private static Advancement.Builder getAdvancement(AdvancementHolder parent, ItemLike icon, String name, AdvancementType type, boolean showToast, boolean announceChat, boolean hidden) {
        return Advancement.Builder.advancement()
                .parent(parent)
                .display(new ItemStack(icon),
                        TextUtils.getTranslatable("advancement." + name),
                        TextUtils.getTranslatable("advancement." + name + ".desc"),
                        null, type, showToast, announceChat, hidden);
    }

    private static ResourceLocation getAdvancementName(String string) {
        return TextUtils.res("main/" + string);
    }
}
