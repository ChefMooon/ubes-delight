package com.chefmooon.ubesdelight.data.fabric.recipe;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.utility.fabric.RecipeUtil;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;

public class SmeltingRecipes {

    public static void register(HolderGetter<Item> holderGetter, HolderLookup.Provider provider, RecipeOutput exporter) {
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, Items.SUGAR, RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItemsImpl.SUGAR_BROWN.get(), 0.5F, 200, exporter);

        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItemsImpl.PANDESAL_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItemsImpl.PANDESAL.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItemsImpl.PANDESAL_UBE_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItemsImpl.PANDESAL_UBE.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItemsImpl.ENSAYMADA_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItemsImpl.ENSAYMADA.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItemsImpl.ENSAYMADA_UBE_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItemsImpl.ENSAYMADA_UBE.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItemsImpl.HOPIA_MUNGGO_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItemsImpl.HOPIA_MUNGGO.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItemsImpl.HOPIA_UBE_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItemsImpl.HOPIA_UBE.get(), 0.5F, 200, exporter);

        RecipeUtil.offerSmeltCampSmokeFromTag(holderGetter, ConventionalItemTags.MILK_DRINKS, RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItemsImpl.MILK_POWDER.get(), 0.2F, 200, exporter);
    }
}
