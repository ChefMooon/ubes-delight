package com.chefmooon.ubesdelight.data.fabric.recipe;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.utility.fabric.RecipeUtil;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class SmeltingRecipes {

    public static void register(Consumer<FinishedRecipe> exporter) {
        RecipeUtil.offerSmeltCampSmokeRecipe(Items.SUGAR, RecipeCategory.FOOD, UbesDelightItemsImpl.SUGAR_BROWN, 0.5F, 200, exporter);

        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.PANDESAL_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.PANDESAL, 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.PANDESAL_UBE_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.PANDESAL_UBE, 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.ENSAYMADA_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.ENSAYMADA, 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.ENSAYMADA_UBE_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.ENSAYMADA_UBE, 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.HOPIA_MUNGGO_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.HOPIA_MUNGGO, 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.HOPIA_UBE_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.HOPIA_UBE, 0.5F, 200, exporter);

        // Recipe with tag, run once then change for Fabric/Forge
        //RecipeUtil.offerSmeltCampSmokeFromTag(CommonTags.C_MILKS_MILK_BOTTLES, UbesDelightItemsImpl.MILK_POWDER, 0.2F, 200, exporter);
    }
}
