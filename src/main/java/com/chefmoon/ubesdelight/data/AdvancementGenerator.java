package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.UbesDelightMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class AdvancementGenerator extends FabricAdvancementProvider {

    protected AdvancementGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        new Advancements().accept(consumer);
    }

    private class Advancements implements Consumer<Consumer<Advancement>> {
        private Identifier MOD_ID = new Identifier(UbesDelightMod.MOD_ID);


        @Override
        public void accept(Consumer<Advancement> consumer) {
            // Unsure if advancements generate to correct location
            // How to create empty criterion?
            // More research needed

            /*

            Advancement rootAdvancement = Advancement.Builder.create()
                    .display(
                            ItemsRegistry.UBE.get(), // The display icon
                            Text.translatable(MOD_ID + ".advancment.root"), // The title
                            Text.translatable(MOD_ID + ".advancment.root.desc"), // The description
                            new Identifier("minecraft:textures/block/bamboo_block.png"), // Background image used
                            AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                            true, // Show toast top right
                            true, // Announce to chat
                            false // Hidden in the advancement tab
                    )
                    // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
                    .criterion("got_dirt", InventoryChangedCriterion.Conditions.items(Items.WHEAT_SEEDS))
                    .build(consumer,  MOD_ID + "/main/root");

            Advancement placeKalan = Advancement.Builder.create()
                    .display(
                            ItemsRegistry.KALAN.get(), // The display icon
                            Text.translatable(MOD_ID + ".advancment.place_kalan"), // The title
                            Text.translatable(MOD_ID + ".advancment.place_kalan.desc"), // The description
                            null, // Background image used
                            AdvancementFrame.GOAL, // Options: TASK, CHALLENGE, GOAL
                            true, // Show toast top right
                            true, // Announce to chat
                            false // Hidden in the advancement tab
                    )
                    .parent(rootAdvancement)
                    .criterion(RecipeProvider.hasItem(ItemsRegistry.KALAN.get()), CriterionConditions)// Block Placed Conditions?
                    .build(consumer,  MOD_ID + "/main/place_kalan");

            Advancement craftRollingPin = Advancement.Builder.create()
                    .display(
                            ItemsRegistry.ROLLING_PIN_WOOD.get(), // The display icon
                            Text.translatable(MOD_ID + ".advancment.place_kalan"), // The title
                            Text.translatable(MOD_ID + ".advancment.place_kalan.desc"), // The description
                            null, // Background image used
                            AdvancementFrame.GOAL, // Options: TASK, CHALLENGE, GOAL
                            true, // Show toast top right
                            true, // Announce to chat
                            false // Hidden in the advancement tab
                    )
                    .parent(rootAdvancement)
                    .criterion(RecipeProvider.hasItem(ItemsRegistry.ROLLING_PIN_WOOD.get()), InventoryChangedCriterion.Conditions.items(ItemsRegistry.ROLLING_PIN_WOOD.get()))
                    .build(consumer,  MOD_ID + "/main/craft_rolling_pin");

            Advancement lemongrassAdvancement = Advancement.Builder.create().parent(craft_knife)
                    .display(
                            ItemsRegistry.LEMONGRASS.get(),
                            Text.literal("Lemongrass"),
                            Text.literal("Lemongrass test, WORK?"),
                            null,
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .criterion("got_lemongrass", InventoryChangedCriterion.Conditions.items(ItemsRegistry.LEMONGRASS.get()))
                    .build(advancementConsumer, UbesDelightMod.MOD_ID + "lemongrass");

             */
        }
    }
}
