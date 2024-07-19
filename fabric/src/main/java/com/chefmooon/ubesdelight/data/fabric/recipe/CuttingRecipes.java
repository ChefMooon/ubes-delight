package com.chefmooon.ubesdelight.data.fabric.recipe;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.data.fabric.builder.CuttingBoardRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class CuttingRecipes {

    public static void register(Consumer<FinishedRecipe> exporter) {

        // run once then move
        //basicCuttingRecipeBuilder(UbesDelightItemsImpl.WILD_GARLIC, UbesDelightItemsImpl.GARLIC, 1, 1.0F, exporter);
        //basicCuttingRecipeBuilder(UbesDelightItemsImpl.WILD_GINGER, UbesDelightItemsImpl.GINGER, 1, 1.0F, exporter);
        //CuttingBoardRecipeBuilder.create(UbesDelightItemsImpl.WILD_UBE, Ingredient.of(CommonTags.C_TOOLS_KNIVES), UbesDelightItemsImpl.UBE, 1, 1.0F)
        //        .output(Items.PURPLE_DYE)
        //        .output(Items.PURPLE_DYE, 0.5F)
        //        .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIVES), RecipeUtil.getTriggerfromTag(CommonTags.C_TOOLS_KNIVES))
        //        .save(exporter, suffix(RecipeProvider.getConversionRecipeName(UbesDelightItemsImpl.UBE, UbesDelightItemsImpl.WILD_UBE)));
        //CuttingBoardRecipeBuilder.create(UbesDelightItemsImpl.WILD_LEMONGRASS, Ingredient.of(CommonTags.C_TOOLS_KNIVES), UbesDelightItemsImpl.LEMONGRASS, 1, 1.0F)
        //        .output(Items.LIME_DYE)
        //        .output(Items.LIME_DYE, 0.5F)
        //        .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIVES), RecipeUtil.getTriggerfromTag(CommonTags.C_TOOLS_KNIVES))
        //        .save(exporter, suffix(RecipeProvider.getConversionRecipeName(UbesDelightItemsImpl.LEMONGRASS, UbesDelightItemsImpl.WILD_LEMONGRASS)));
        //basicCuttingRecipeBuilder(UbesDelightItemsImpl.HALO_HALO_FEAST, UbesDelightItemsImpl.HALO_HALO, 4, 1.0F, exporter);
        //basicCuttingRecipeBuilder(UbesDelightItemsImpl.LECHE_FLAN_FEAST, UbesDelightItemsImpl.LECHE_FLAN, 5, 1.0F, exporter);
        //basicCuttingRecipeBuilder(UbesDelightItemsImpl.UBE_CAKE, UbesDelightItemsImpl.UBE_CAKE_SLICE, 7, 1.0F, exporter);

    }

    private static void basicCuttingRecipeBuilder(Item input, Item output, int outputCount, float chance, Consumer<FinishedRecipe> exporter) {
        CuttingBoardRecipeBuilder.create(input, Ingredient.of(CommonTags.C_TOOLS_KNIVES), output, outputCount, chance)
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(output, input)));
    }

    private static ResourceLocation suffix(String string) {
        return new ResourceLocation(UbesDelight.MOD_ID,  string + "_from_cutting");
    }
}
