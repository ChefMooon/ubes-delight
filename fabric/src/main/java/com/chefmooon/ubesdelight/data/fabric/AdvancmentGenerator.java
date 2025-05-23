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
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AdvancmentGenerator extends FabricAdvancementProvider {
    protected AdvancmentGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(new DisplayInfo(
                        new ItemStack(UbesDelightItemsImpl.UBE),
                        TextUtils.getTranslatable("advancement.root"),
                        TextUtils.getTranslatable("advancement.root.desc"),
                        Optional.of(ResourceLocation.withDefaultNamespace("textures/block/bamboo_block.png")),
                        AdvancementType.TASK,
                        false, false, false
                ))
                .addCriterion(RecipeProvider.getHasName(Items.WHEAT_SEEDS), InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .build(getAdvancementName("root"));
        consumer.accept(root);

        AdvancementHolder getUDSeed = getAdvancement(root, UbesDelightItemsImpl.WILD_UBE, "get_ud_seed", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.UBE), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.GINGER), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.GINGER))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.GARLIC), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.GARLIC))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEMONGRASS_SEEDS), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEMONGRASS_SEEDS))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("get_ud_seed"));
        consumer.accept(getUDSeed);

        AdvancementHolder plantAllCrops = getAdvancement(getUDSeed, UbesDelightItemsImpl.LEMONGRASS, "plant_all_crops", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.UBE), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.UBE_CROP))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.GINGER), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.GINGER_CROP))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.GARLIC), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.GARLIC_CROP))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEMONGRASS_SEEDS), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP))
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(getAdvancementName("plant_all_crops"));
        consumer.accept(plantAllCrops);

        AdvancementHolder craftRollingPin = getAdvancement(root, UbesDelightItemsImpl.ROLLING_PIN_WOOD, "craft_rolling_pin", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_WOOD), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_WOOD))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_IRON), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_IRON))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_GOLD), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_GOLD))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_DIAMOND), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_DIAMOND))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("craft_rolling_pin"));
        consumer.accept(craftRollingPin);

        AdvancementHolder craftBakingMat = getAdvancement(craftRollingPin, UbesDelightItemsImpl.BAKING_MAT_BAMBOO, "craft_baking_mat", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.BAKING_MAT_BAMBOO), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.BAKING_MAT_BAMBOO))
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(getAdvancementName("craft_baking_mat"));
        consumer.accept(craftBakingMat);

        AdvancementHolder useBakingMat = getAdvancement(craftBakingMat, UbesDelightItemsImpl.ENSAYMADA_UBE_RAW, "use_baking_mat", AdvancementType.TASK, true, false, false)
                .addCriterion("use_baking_mat", BakingMatTrigger.TriggerInstance.simple())
                .build(getAdvancementName("use_baking_mat"));
        consumer.accept(useBakingMat);

        AdvancementHolder masterBaker = getAdvancement(useBakingMat, UbesDelightItemsImpl.ENSAYMADA_UBE, "master_baker", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.PANDESAL), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.PANDESAL))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.PANDESAL_UBE), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.PANDESAL_UBE))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.ENSAYMADA), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ENSAYMADA))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.ENSAYMADA_UBE), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ENSAYMADA_UBE))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.HOPIA_MUNGGO), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.HOPIA_MUNGGO))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.HOPIA_UBE), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.HOPIA_UBE))
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(getAdvancementName("master_baker"));
        consumer.accept(masterBaker);

        AdvancementHolder netheriteRollingPin = getAdvancement(craftBakingMat, UbesDelightItemsImpl.ROLLING_PIN_NETHERITE, "netherite_rolling_pin", AdvancementType.CHALLENGE, true, true, true)
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE))
                .rewards(AdvancementRewards.Builder.experience(200))
                .build(getAdvancementName("netherite_rolling_pin"));
        consumer.accept(netheriteRollingPin);

        AdvancementHolder placeKalan = getAdvancement(root, UbesDelightItemsImpl.KALAN, "place_kalan", AdvancementType.TASK, true, true, false)
                .addCriterion("place_kalan", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.KALAN))
                .build(getAdvancementName("place_kalan"));
        consumer.accept(placeKalan);

        AdvancementHolder ubeMaster = getAdvancement(placeKalan, UbesDelightItemsImpl.UBE_CAKE_SLICE, "ube_master", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.COOKIE_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.COOKIE_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.UBE_CAKE_SLICE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.UBE_CAKE_SLICE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.POLVORONE_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.POLVORONE_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ENSAYMADA_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.ENSAYMADA_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.PANDESAL_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.PANDESAL_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.HOPIA_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.HOPIA_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.MILK_TEA_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.MILK_TEA_UBE))
                .rewards(AdvancementRewards.Builder.experience(50))
                .build(getAdvancementName("ube_master"));
        consumer.accept(ubeMaster);

        AdvancementHolder placeDrinkableFeast = getAdvancement(placeKalan, UbesDelightItemsImpl.HALO_HALO_FEAST, "place_drinkable_feast", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.HALO_HALO_FEAST), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.HALO_HALO_FEAST))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("place_drinkable_feast"));
        consumer.accept(placeDrinkableFeast);

        AdvancementHolder leafFeast = getAdvancement(root, Items.OAK_LEAVES, "leaf_feast", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getHasName(UbesDelightItemsImpl.LEAF_FEAST), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST))
                .build(getAdvancementName("leaf_feast"));
        consumer.accept(leafFeast);

        AdvancementHolder placeLeafFeast = getAdvancement(leafFeast, UbesDelightItemsImpl.LEAF_FEAST, "place_leaf_feast", AdvancementType.TASK, true, true, false)
                .addCriterion("place_" + RecipeProvider.getHasName(UbesDelightItemsImpl.LEAF_FEAST) + "_tip",
                        ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LEAF_FEAST)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LeafFeastBlock.LEAF_FEAST_TYPE, LeafFeastTypes.TIP))))
                .addCriterion("place_" + RecipeProvider.getHasName(UbesDelightItemsImpl.LEAF_FEAST) + "_end",
                        ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LEAF_FEAST)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LeafFeastBlock.LEAF_FEAST_TYPE, LeafFeastTypes.END))))
                .addCriterion("place_" + RecipeProvider.getHasName(UbesDelightItemsImpl.LEAF_FEAST) + "_middle",
                        ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocksImpl.LEAF_FEAST)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LeafFeastBlock.LEAF_FEAST_TYPE, LeafFeastTypes.MIDDLE))))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("place_leaf_feast"));
        consumer.accept(placeLeafFeast);

        AdvancementHolder useLeafFeast = getAdvancement(placeLeafFeast, UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_HALF, "use_leaf_feast", AdvancementType.TASK, true, false, false)
                .addCriterion("use_leaf_feast_insert", LeafFeastInsertTrigger.TriggerInstance.simple())
                .build(getAdvancementName("use_leaf_feast"));
        consumer.accept(useLeafFeast);

        AdvancementHolder boodleFight = getAdvancement(useLeafFeast, UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA, "boodle_fight", AdvancementType.TASK, true, false, false)
                .addCriterion("use_leaf_feast_consume", LeafFeastConsumeTrigger.TriggerInstance.simple())
                .build(getAdvancementName("boodle_fight"));
        consumer.accept(boodleFight);

        AdvancementHolder leafFeastMaster = getAdvancement(leafFeast, UbesDelightItemsImpl.LUMPIA_FEAST, "leaf_feast_master", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LUMPIA_FEAST), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LUMPIA_FEAST))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_HALF), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_HALF))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE_HALF), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE_HALF))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_HALF), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_HALF))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE_HALF), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE_HALF))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO_HALF), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO_HALF))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE_HALF), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE_HALF))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE_HALF), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE_HALF))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE_HALF), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE_HALF))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_SINANGAG), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_SINANGAG))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LEAF_FEAST_SINANGAG_HALF), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItemsImpl.LEAF_FEAST_SINANGAG_HALF))
                .rewards(AdvancementRewards.Builder.experience(50))
                .build(getAdvancementName("leaf_feast_master"));
        consumer.accept(leafFeastMaster);

        AdvancementHolder udMaster = getAdvancement(placeDrinkableFeast, UbesDelightItemsImpl.UBE_CAKE, "ud_master", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.MILK_TEA_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.MILK_TEA_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.HALO_HALO), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.HALO_HALO))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.SINANGAG), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.SINANGAG))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.KINILAW), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.KINILAW))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LUMPIA), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.LUMPIA))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.TOCINO), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.TOCINO))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.CHICKEN_INASAL), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.CHICKEN_INASAL))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.CHICKEN_INASAL_RICE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.CHICKEN_INASAL_RICE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.TOSILOG), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.TOSILOG))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.BANGSILOG), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.BANGSILOG))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.SISIG), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.SISIG))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.BULALO), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.BULALO))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ARROZ_CALDO), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.ARROZ_CALDO))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.MECHADO), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.MECHADO))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.COOKIE_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.COOKIE_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.COOKIE_GINGER), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.COOKIE_GINGER))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.LECHE_FLAN), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.LECHE_FLAN))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.UBE_CAKE_SLICE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.UBE_CAKE_SLICE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.POLVORONE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.POLVORONE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.POLVORONE_PINIPIG), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.POLVORONE_PINIPIG))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.POLVORONE_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.POLVORONE_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.POLVORONE_CC), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.POLVORONE_CC))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.PANDESAL), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.PANDESAL))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.PANDESAL_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.PANDESAL_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ENSAYMADA), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.ENSAYMADA))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.ENSAYMADA_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.ENSAYMADA_UBE))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.HOPIA_MUNGGO), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.HOPIA_MUNGGO))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItemsImpl.HOPIA_UBE), ConsumeItemTrigger.TriggerInstance.usedItem(UbesDelightItemsImpl.HOPIA_UBE))
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
