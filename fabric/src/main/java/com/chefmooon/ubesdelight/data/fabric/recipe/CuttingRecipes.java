package com.chefmooon.ubesdelight.data.fabric.recipe;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.common.utility.fabric.RecipeUtil;
import com.chefmooon.ubesdelight.data.fabric.builder.CuttingBoardRecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public class CuttingRecipes {

    public static void register(RecipeOutput exporter) {

        basicCuttingRecipeBuilder(UbesDelightItemsImpl.GARLIC, UbesDelightItemsImpl.GARLIC_CHOP, 2, 1.0F, exporter);
        basicCuttingRecipeBuilder(UbesDelightItemsImpl.GINGER, UbesDelightItemsImpl.GINGER_CHOP, 2, 1.0F, exporter);
        basicCuttingRecipeBuilder(UbesDelightItemsImpl.WILD_GARLIC, UbesDelightItemsImpl.GARLIC, 1, 1.0F, exporter);
        basicCuttingRecipeBuilder(UbesDelightItemsImpl.WILD_GINGER, UbesDelightItemsImpl.GINGER, 1, 1.0F, exporter);
        CuttingBoardRecipeBuilder.create(UbesDelightItemsImpl.WILD_UBE, Ingredient.of(CommonTags.C_TOOLS_KNIFE), UbesDelightItemsImpl.UBE, 1, 1.0F)
                .output(Items.PURPLE_DYE)
                .output(Items.PURPLE_DYE, 0.5F)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIFE), RecipeUtil.getTriggerfromTag(CommonTags.C_TOOLS_KNIFE))
                .save(exporter, TextUtils.res(RecipeProvider.getConversionRecipeName(UbesDelightItemsImpl.UBE, UbesDelightItemsImpl.WILD_UBE)));
        CuttingBoardRecipeBuilder.create(UbesDelightItemsImpl.WILD_LEMONGRASS, Ingredient.of(CommonTags.C_TOOLS_KNIFE), UbesDelightItemsImpl.LEMONGRASS, 1, 1.0F)
                .output(Items.LIME_DYE)
                .output(Items.LIME_DYE, 0.5F)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIFE), RecipeUtil.getTriggerfromTag(CommonTags.C_TOOLS_KNIFE))
                .save(exporter, TextUtils.res(RecipeProvider.getConversionRecipeName(UbesDelightItemsImpl.LEMONGRASS, UbesDelightItemsImpl.WILD_LEMONGRASS)));
        basicCuttingRecipeBuilder(UbesDelightItemsImpl.HALO_HALO_FEAST, UbesDelightItemsImpl.HALO_HALO, 4, 1.0F, exporter);
        basicCuttingRecipeBuilder(UbesDelightItemsImpl.LECHE_FLAN_FEAST, UbesDelightItemsImpl.LECHE_FLAN, 5, 1.0F, exporter);
        basicCuttingRecipeBuilder(UbesDelightItemsImpl.UBE_CAKE, UbesDelightItemsImpl.UBE_CAKE_SLICE, 7, 1.0F, exporter);

    }

    private static void basicCuttingRecipeBuilder(Item input, Item output, int outputCount, float chance, RecipeOutput exporter) {
        CuttingBoardRecipeBuilder.create(input, Ingredient.of(CommonTags.C_TOOLS_KNIFE), output, outputCount, chance)
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(output, input)));
    }

    private static ResourceLocation suffix(String string) {
        return TextUtils.res(string);
    }
}
