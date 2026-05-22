package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.advancement.BakingMatTrigger;
import chefmooon.ubesdelight.common.advancement.LeafFeastConsumeTrigger;
import chefmooon.ubesdelight.common.advancement.LeafFeastInsertTrigger;
import chefmooon.ubesdelight.common.block.leaf_feast.base.LeafFeastBlock;
import chefmooon.ubesdelight.common.core.LeafFeastTypes;
import chefmooon.ubesdelight.common.registry.UbesDelightBlocks;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.*;
import net.minecraft.advancements.criterion.ConsumeItemTrigger;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemUsedOnLocationTrigger;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class AdvancementGenerator extends FabricAdvancementProvider {
    protected AdvancementGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(new ItemStackTemplate(UbesDelightItems.UBE.get()),
                        TextUtils.getTranslatable("advancement.root"),
                        TextUtils.getTranslatable("advancement.root.desc"),
                        Identifier.withDefaultNamespace("block/bamboo_block"),
                        AdvancementType.TASK, false, false, false)
                .addCriterion(RecipeProvider.getHasName(Items.WHEAT_SEEDS), InventoryChangeTrigger.TriggerInstance.hasItems(new ItemLike[]{}))
                .build(getAdvancementName("root"));
        consumer.accept(root);

        AdvancementHolder getUDSeed = getAdvancement(root, UbesDelightItems.WILD_UBE.get(), "get_ud_seed", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.GINGER.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.GINGER.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.GARLIC.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.GARLIC.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEMONGRASS_SEEDS.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEMONGRASS_SEEDS.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("get_ud_seed"));
        consumer.accept(getUDSeed);

        AdvancementHolder plantAllCrops = getAdvancement(getUDSeed, UbesDelightItems.LEMONGRASS.get(), "plant_all_crops", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.UBE.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocks.UBE_CROP.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.GINGER.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocks.GINGER_CROP.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.GARLIC.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocks.GARLIC_CROP.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEMONGRASS_SEEDS.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get()))
                .requirements(AdvancementRequirements.Strategy.AND)
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(getAdvancementName("plant_all_crops"));
        consumer.accept(plantAllCrops);

        AdvancementHolder craftRollingPin = getAdvancement(root, UbesDelightItems.ROLLING_PIN_WOOD.get(), "craft_rolling_pin", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_WOOD.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.ROLLING_PIN_WOOD.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_IRON.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.ROLLING_PIN_IRON.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_GOLD.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.ROLLING_PIN_GOLD.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_DIAMOND.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.ROLLING_PIN_DIAMOND.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.ROLLING_PIN_NETHERITE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.ROLLING_PIN_NETHERITE.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("craft_rolling_pin"));
        consumer.accept(craftRollingPin);

        AdvancementHolder craftBakingMat = getAdvancement(craftRollingPin, UbesDelightItems.BAKING_MAT_BAMBOO.get(), "craft_baking_mat", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.BAKING_MAT_BAMBOO.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.BAKING_MAT_BAMBOO.get()))
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(getAdvancementName("craft_baking_mat"));
        consumer.accept(craftBakingMat);

        AdvancementHolder useBakingMat = getAdvancement(craftBakingMat, UbesDelightItems.ENSAYMADA_UBE_RAW.get(), "use_baking_mat", AdvancementType.TASK, true, false, false)
                .addCriterion("use_baking_mat", BakingMatTrigger.TriggerInstance.simple())
                .build(getAdvancementName("use_baking_mat"));
        consumer.accept(useBakingMat);

        AdvancementHolder masterBaker = getAdvancement(useBakingMat, UbesDelightItems.ENSAYMADA_UBE.get(), "master_baker", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getHasName(UbesDelightItems.PANDESAL.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.PANDESAL.get()))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItems.PANDESAL_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.PANDESAL_UBE.get()))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItems.ENSAYMADA.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.ENSAYMADA.get()))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItems.ENSAYMADA_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.ENSAYMADA_UBE.get()))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItems.HOPIA_MUNGGO.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.HOPIA_MUNGGO.get()))
                .addCriterion(RecipeProvider.getHasName(UbesDelightItems.HOPIA_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.HOPIA_UBE.get()))
                .rewards(AdvancementRewards.Builder.experience(100))
                .build(getAdvancementName("master_baker"));
        consumer.accept(masterBaker);

        AdvancementHolder netheriteRollingPin = getAdvancement(craftBakingMat, UbesDelightItems.ROLLING_PIN_NETHERITE.get(), "netherite_rolling_pin", AdvancementType.CHALLENGE, true, true, true)
                .addCriterion(RecipeProvider.getHasName(UbesDelightItems.ROLLING_PIN_NETHERITE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.ROLLING_PIN_NETHERITE.get()))
                .rewards(AdvancementRewards.Builder.experience(200))
                .build(getAdvancementName("netherite_rolling_pin"));
        consumer.accept(netheriteRollingPin);

        AdvancementHolder placeKalan = getAdvancement(root, UbesDelightItems.KALAN.get(), "place_kalan", AdvancementType.TASK, true, true, false)
                .addCriterion("place_kalan", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocks.KALAN.get()))
                .build(getAdvancementName("place_kalan"));
        consumer.accept(placeKalan);

        AdvancementHolder ubeMaster = getAdvancement(placeKalan, UbesDelightItems.UBE_CAKE_SLICE.get(), "ube_master", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.COOKIE_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.COOKIE_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.UBE_CAKE_SLICE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.UBE_CAKE_SLICE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.POLVORONE_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.POLVORONE_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.ENSAYMADA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.ENSAYMADA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.PANDESAL_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.PANDESAL_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.HOPIA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.HOPIA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.MILK_TEA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.MILK_TEA_UBE.get()))
                .rewards(AdvancementRewards.Builder.experience(50))
                .build(getAdvancementName("ube_master"));
        consumer.accept(ubeMaster);

        AdvancementHolder placeDrinkableFeast = getAdvancement(placeKalan, UbesDelightItems.HALO_HALO_FEAST.get(), "place_drinkable_feast", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.HALO_HALO_FEAST.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocks.HALO_HALO_FEAST.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.MILK_TEA_UBE_FEAST.get()), ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(UbesDelightBlocks.MILK_TEA_UBE_FEAST.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("place_drinkable_feast"));
        consumer.accept(placeDrinkableFeast);

        AdvancementHolder leafFeast = getAdvancement(root, Items.OAK_LEAVES, "leaf_feast", AdvancementType.TASK, true, true, false)
                .addCriterion(RecipeProvider.getHasName(UbesDelightItems.LEAF_FEAST.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST.get()))
                .build(getAdvancementName("leaf_feast"));
        consumer.accept(leafFeast);

        AdvancementHolder placeLeafFeast = getAdvancement(leafFeast, UbesDelightItems.LEAF_FEAST.get(), "place_leaf_feast", AdvancementType.TASK, true, true, false)
                .addCriterion("place_" + RecipeProvider.getHasName(UbesDelightItems.LEAF_FEAST.get()) + "_tip",
                        ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LEAF_FEAST.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LeafFeastBlock.LEAF_FEAST_TYPE, LeafFeastTypes.TIP))))
                .addCriterion("place_" + RecipeProvider.getHasName(UbesDelightItems.LEAF_FEAST.get()) + "_end",
                        ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LEAF_FEAST.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LeafFeastBlock.LEAF_FEAST_TYPE, LeafFeastTypes.END))))
                .addCriterion("place_" + RecipeProvider.getHasName(UbesDelightItems.LEAF_FEAST.get()) + "_middle",
                        ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(LootItemBlockStatePropertyCondition.hasBlockStateProperties(UbesDelightBlocks.LEAF_FEAST.get())
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LeafFeastBlock.LEAF_FEAST_TYPE, LeafFeastTypes.MIDDLE))))
                .requirements(AdvancementRequirements.Strategy.OR)
                .build(getAdvancementName("place_leaf_feast"));
        consumer.accept(placeLeafFeast);

        AdvancementHolder useLeafFeast = getAdvancement(placeLeafFeast, UbesDelightItems.LEAF_FEAST_ENSAYMADA_HALF.get(), "use_leaf_feast", AdvancementType.TASK, true, false, false)
                .addCriterion("use_leaf_feast_insert", LeafFeastInsertTrigger.TriggerInstance.simple())
                .build(getAdvancementName("use_leaf_feast"));
        consumer.accept(useLeafFeast);

        AdvancementHolder boodleFight = getAdvancement(useLeafFeast, UbesDelightItems.LEAF_FEAST_ENSAYMADA.get(), "boodle_fight", AdvancementType.TASK, true, false, false)
                .addCriterion("use_leaf_feast_consume", LeafFeastConsumeTrigger.TriggerInstance.simple())
                .build(getAdvancementName("boodle_fight"));
        consumer.accept(boodleFight);

        AdvancementHolder leafFeastMaster = getAdvancement(leafFeast, UbesDelightItems.LUMPIA_FEAST.get(), "leaf_feast_master", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LUMPIA_FEAST.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LUMPIA_FEAST.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_ENSAYMADA.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_ENSAYMADA.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_ENSAYMADA_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_ENSAYMADA_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_PANDESAL.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_PANDESAL.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_PANDESAL_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_PANDESAL_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_HOPIA_UBE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_HOPIA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_HOPIA_UBE_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_HOPIA_UBE_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_COOKED_RICE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_COOKED_RICE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_COOKED_RICE_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_COOKED_RICE_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_FRIED_RICE.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_FRIED_RICE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_FRIED_RICE_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_FRIED_RICE_HALF.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_SINANGAG.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_SINANGAG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LEAF_FEAST_SINANGAG_HALF.get()), InventoryChangeTrigger.TriggerInstance.hasItems(UbesDelightItems.LEAF_FEAST_SINANGAG_HALF.get()))
                .rewards(AdvancementRewards.Builder.experience(50))
                .build(getAdvancementName("leaf_feast_master"));
        consumer.accept(leafFeastMaster);

        AdvancementHolder udMaster = getAdvancement(placeDrinkableFeast, UbesDelightItems.UBE_CAKE.get(), "ud_master", AdvancementType.CHALLENGE, true, true, false)
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.MILK_TEA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.MILK_TEA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.HALO_HALO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.HALO_HALO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.SINANGAG.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.SINANGAG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.KINILAW.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.KINILAW.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LUMPIA.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.LUMPIA.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.TOCINO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.TOCINO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.CHICKEN_INASAL.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.CHICKEN_INASAL.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.CHICKEN_INASAL_RICE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.CHICKEN_INASAL_RICE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.TOSILOG.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.TOSILOG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.BANGSILOG.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.BANGSILOG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.SISIG.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.SISIG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.BULALO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.BULALO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.ARROZ_CALDO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.ARROZ_CALDO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.MECHADO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.MECHADO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.COOKIE_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.COOKIE_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.COOKIE_GINGER.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.COOKIE_GINGER.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.LECHE_FLAN.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.LECHE_FLAN.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.UBE_CAKE_SLICE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.UBE_CAKE_SLICE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.POLVORONE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.POLVORONE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.POLVORONE_PINIPIG.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.POLVORONE_PINIPIG.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.POLVORONE_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.POLVORONE_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.POLVORONE_CC.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.POLVORONE_CC.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.PANDESAL.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.PANDESAL.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.PANDESAL_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.PANDESAL_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.ENSAYMADA.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.ENSAYMADA.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.ENSAYMADA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.ENSAYMADA_UBE.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.HOPIA_MUNGGO.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.HOPIA_MUNGGO.get()))
                .addCriterion(RecipeProvider.getItemName(UbesDelightItems.HOPIA_UBE.get()), ConsumeItemTrigger.TriggerInstance.usedItem(provider.lookupOrThrow(Registries.ITEM), UbesDelightItems.HOPIA_UBE.get()))
                .rewards(AdvancementRewards.Builder.experience(200))
                .build(getAdvancementName("ud_master"));
        consumer.accept(udMaster);
    }

    private static Advancement.Builder getAdvancement(AdvancementHolder parent, ItemLike icon, String name, AdvancementType type, boolean showToast, boolean announceChat, boolean hidden) {
        return Advancement.Builder.advancement()
                .parent(parent)
                .display(new ItemStackTemplate(icon.asItem()),
                        TextUtils.getTranslatable("advancement." + name),
                        TextUtils.getTranslatable("advancement." + name + ".desc"),
                        null, type, showToast, announceChat, hidden);
    }

    private static Identifier getAdvancementName(String string) {
        return TextUtils.res("main/" + string);
    }
}
