package com.chefmooon.ubesdelight.data.fabric.recipe;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class CuttingRecipes {

    public static void register(HolderGetter<Item> holderGetter, HolderLookup.Provider provider, RecipeOutput exporter) {

        basicCuttingRecipeBuilder(holderGetter, UbesDelightItemsImpl.GARLIC.get(), UbesDelightItemsImpl.GARLIC_CHOP.get(), 2, 1.0F, exporter);
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItemsImpl.GINGER.get(), UbesDelightItemsImpl.GINGER_CHOP.get(), 2, 1.0F, exporter);
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItemsImpl.WILD_GARLIC.get(), UbesDelightItemsImpl.GARLIC.get(), 1, 1.0F, exporter);
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItemsImpl.WILD_GINGER.get(), UbesDelightItemsImpl.GINGER.get(), 1, 1.0F, exporter);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(UbesDelightItemsImpl.WILD_UBE.get()), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), UbesDelightItemsImpl.UBE.get())
                .addResult(Items.PURPLE_DYE)
                .addResultWithChance(Items.PURPLE_DYE, 0.5F)
//                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIFE), RecipeUtil.has(holderGetter, CommonTags.C_TOOLS_KNIFE))
                .build(exporter, suffix(RecipeProvider.getConversionRecipeName(UbesDelightItemsImpl.UBE.get(), UbesDelightItemsImpl.WILD_UBE.get())));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(UbesDelightItemsImpl.WILD_LEMONGRASS.get()), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), UbesDelightItemsImpl.LEMONGRASS.get())
                .addResult(Items.LIME_DYE)
                .addResultWithChance(Items.LIME_DYE, 0.5F)
//                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIFE), RecipeUtil.has(holderGetter, CommonTags.C_TOOLS_KNIFE))
                .build(exporter, suffix(RecipeProvider.getConversionRecipeName(UbesDelightItemsImpl.LEMONGRASS.get(), UbesDelightItemsImpl.WILD_LEMONGRASS.get())));
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItemsImpl.HALO_HALO_FEAST.get(), UbesDelightItemsImpl.HALO_HALO.get(), 4, 1.0F, exporter);
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItemsImpl.LECHE_FLAN_FEAST.get(), UbesDelightItemsImpl.LECHE_FLAN.get(), 5, 1.0F, exporter);
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItemsImpl.UBE_CAKE.get(), UbesDelightItemsImpl.UBE_CAKE_SLICE.get(), 7, 1.0F, exporter);

    }

    private static void basicCuttingRecipeBuilder(HolderGetter<Item> holderGetter, Item input, Item output, int outputCount, float chance, RecipeOutput exporter) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(input), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), output, outputCount, (int) chance)
                .build(exporter, suffix(RecipeProvider.getConversionRecipeName(output, input)));
    }

    private static ResourceLocation suffix(String string) {
        return TextUtils.res(string);
    }
}
