package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;


import java.util.List;
import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(Items.SUGAR), ItemsRegistry.SUGAR_BROWN.get(), .5f,100,UbesDelightMod.ITEM_GROUP.toString());

        offerSmelting(exporter, List.of(ItemsRegistry.RAW_POLVORONE.get()), ItemsRegistry.POLVORONE.get(), .3F, 25, UbesDelightMod.ITEM_GROUP.getName());
        offerSmelting(exporter, List.of(ItemsRegistry.RAW_POLVORONE_PINIPIG.get()), ItemsRegistry.POLVORONE_PINIPIG.get(), .3F, 25, UbesDelightMod.ITEM_GROUP.getName());
        offerSmelting(exporter, List.of(ItemsRegistry.RAW_POLVORONE_UBE.get()), ItemsRegistry.POLVORONE_UBE.get(), .3F, 25, UbesDelightMod.ITEM_GROUP.getName());
        offerSmelting(exporter, List.of(ItemsRegistry.RAW_POLVORONE_CC.get()), ItemsRegistry.POLVORONE_CC.get(), .3F, 25, UbesDelightMod.ITEM_GROUP.getName());

        offerShapelessRecipe(exporter, ItemsRegistry.LEMONGRASS_SEEDS.get(), ItemsRegistry.LEMONGRASS.get(), null, 1);

        //Crate to Vegetable
        offerShapelessRecipe(exporter, ItemsRegistry.UBE.get(), ItemsRegistry.UBE_CRATE.get(), null, 9);
        offerShapelessRecipe(exporter, ItemsRegistry.GARLIC.get(), ItemsRegistry.GARLIC_CRATE.get(), null, 9);
        offerShapelessRecipe(exporter, ItemsRegistry.GINGER.get(), ItemsRegistry.GINGER_CRATE.get(), null, 9);
        offerShapelessRecipe(exporter, ItemsRegistry.LEMONGRASS.get(), ItemsRegistry.LEMONGRASS_CRATE.get(), null, 9);

        //Vegetable to Crate
        /* Moved to Manual, Must research how to add a custom condition type *//*
        ShapelessRecipeJsonBuilder.create(ItemsRegistry.UBE_CRATE.get(), 1)
                .input(ItemsRegistry.UBE.get(), 9)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.UBE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.UBE.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.UBE_CRATE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.UBE_CRATE.get()))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.UBE_CRATE.get())));
        ShapelessRecipeJsonBuilder.create(ItemsRegistry.GARLIC_CRATE.get(), 1)
                .input(ItemsRegistry.GARLIC.get(), 9)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GARLIC.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GARLIC.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GARLIC_CRATE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GARLIC_CRATE.get()))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.GARLIC_CRATE.get())));
        ShapelessRecipeJsonBuilder.create(ItemsRegistry.GINGER_CRATE.get(), 1)
                .input(ItemsRegistry.GINGER.get(), 9)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GINGER.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GINGER.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GINGER_CRATE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GINGER_CRATE.get()))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.GINGER_CRATE.get())));
        ShapelessRecipeJsonBuilder.create(ItemsRegistry.LEMONGRASS_CRATE.get(), 1)
                .input(ItemsRegistry.LEMONGRASS.get(), 9)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.LEMONGRASS.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.LEMONGRASS.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.LEMONGRASS_CRATE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.LEMONGRASS_CRATE.get()))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.LEMONGRASS_CRATE.get())));
        */
        //Partial to full Vegetables
        ShapelessRecipeJsonBuilder.create(ItemsRegistry.GARLIC.get(), 1)
                .input(ItemsRegistry.GARLIC_CLOVES.get(), 2)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GARLIC.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GARLIC.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.GARLIC_CLOVES.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.GARLIC_CLOVES.get()))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.GARLIC.get()))
                        + "_from_"
                        + RecipeProvider.getRecipeName(ItemsRegistry.GARLIC_CLOVES.get()));

        //Cake Slices to Cake
        ShapelessRecipeJsonBuilder.create(ItemsRegistry.UBE_CAKE.get(), 1)
                .input(ItemsRegistry.UBE_CAKE_SLICE.get(), 7)
                .criterion(RecipeProvider.hasItem(ItemsRegistry.UBE_CAKE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.UBE_CAKE.get()))
                .criterion(RecipeProvider.hasItem(ItemsRegistry.UBE_CAKE_SLICE.get()),
                        RecipeProvider.conditionsFromItem(ItemsRegistry.UBE_CAKE_SLICE.get()))
                .offerTo(exporter, new Identifier(RecipeProvider.getRecipeName(ItemsRegistry.UBE_CAKE.get()))
                        + "_from_"
                        + RecipeProvider.getRecipeName(ItemsRegistry.UBE_CAKE_SLICE.get()));
    }
}
