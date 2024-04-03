package com.chefmoon.ubesdelight.data.recipe;

import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import com.chefmoon.ubesdelight.util.RecipeUtil;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.function.Consumer;

public class SmeltingRecipes {

    public static void register(Consumer<RecipeJsonProvider> exporter) {
        RecipeUtil.offerSmeltCampSmokeRecipe(Items.SUGAR, RecipeCategory.FOOD, ItemsRegistry.SUGAR_BROWN.get(), .5f, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeFromTag(CommonTags.C_MILK_MILK_BOTTLE, ItemsRegistry.MILK_POWDER.get(), .2f, 200, exporter);

        RecipeUtil.offerSmeltCampSmokeRecipe(ItemsRegistry.PANDESAL_RAW.get(), RecipeCategory.FOOD, ItemsRegistry.PANDESAL.get(), .5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(ItemsRegistry.PANDESAL_UBE_RAW.get(), RecipeCategory.FOOD, ItemsRegistry.PANDESAL_UBE.get(), .5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(ItemsRegistry.ENSAYMADA_RAW.get(), RecipeCategory.FOOD, ItemsRegistry.ENSAYMADA.get(), .5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(ItemsRegistry.ENSAYMADA_UBE_RAW.get(), RecipeCategory.FOOD, ItemsRegistry.ENSAYMADA_UBE.get(), .5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(ItemsRegistry.HOPIA_MUNGGO_RAW.get(), RecipeCategory.FOOD, ItemsRegistry.HOPIA_MUNGGO.get(), .5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(ItemsRegistry.HOPIA_UBE_RAW.get(), RecipeCategory.FOOD, ItemsRegistry.HOPIA_UBE.get(), .5F, 200, exporter);
    }
}
