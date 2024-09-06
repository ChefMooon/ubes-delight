package com.chefmooon.ubesdelight.data.fabric.recipe;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.utility.fabric.RecipeUtil;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;

public class SmeltingRecipes {

    public static void register(RecipeOutput exporter) {
        RecipeUtil.offerSmeltCampSmokeRecipe(Items.SUGAR, RecipeCategory.FOOD, UbesDelightItemsImpl.SUGAR_BROWN, 0.5F, 200, exporter);

        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.PANDESAL_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.PANDESAL, 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.PANDESAL_UBE_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.PANDESAL_UBE, 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.ENSAYMADA_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.ENSAYMADA, 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.ENSAYMADA_UBE_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.ENSAYMADA_UBE, 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.HOPIA_MUNGGO_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.HOPIA_MUNGGO, 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItemsImpl.HOPIA_UBE_RAW, RecipeCategory.FOOD, UbesDelightItemsImpl.HOPIA_UBE, 0.5F, 200, exporter);

        RecipeUtil.offerSmeltCampSmokeFromTag(CommonTags.C_FOODS_MILK_BOTTLE, UbesDelightItemsImpl.MILK_POWDER, 0.2F, 200, exporter);
    }
}
