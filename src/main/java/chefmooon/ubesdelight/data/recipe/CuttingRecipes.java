package chefmooon.ubesdelight.data.recipe;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class CuttingRecipes {

    public static void register(HolderGetter<Item> holderGetter, HolderLookup.Provider provider, RecipeOutput exporter) {

        basicCuttingRecipeBuilder(holderGetter, UbesDelightItems.GARLIC.get(), UbesDelightItems.GARLIC_CHOP.get(), 2, 1.0F, exporter);
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItems.GINGER.get(), UbesDelightItems.GINGER_CHOP.get(), 2, 1.0F, exporter);
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItems.WILD_GARLIC.get(), UbesDelightItems.GARLIC.get(), 1, 1.0F, exporter);
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItems.WILD_GINGER.get(), UbesDelightItems.GINGER.get(), 1, 1.0F, exporter);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(UbesDelightItems.WILD_UBE.get()), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), UbesDelightItems.UBE.get())
                .addResult(Items.PURPLE_DYE)
                .addResultWithChance(Items.PURPLE_DYE, 0.5F)
//                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIFE), RecipeUtil.has(holderGetter, CommonTags.C_TOOLS_KNIFE))
                .build(exporter, suffix(RecipeProvider.getConversionRecipeName(UbesDelightItems.UBE.get(), UbesDelightItems.WILD_UBE.get())));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(UbesDelightItems.WILD_LEMONGRASS.get()), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), UbesDelightItems.LEMONGRASS.get())
                .addResult(Items.LIME_DYE)
                .addResultWithChance(Items.LIME_DYE, 0.5F)
//                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIFE), RecipeUtil.has(holderGetter, CommonTags.C_TOOLS_KNIFE))
                .build(exporter, suffix(RecipeProvider.getConversionRecipeName(UbesDelightItems.LEMONGRASS.get(), UbesDelightItems.WILD_LEMONGRASS.get())));
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItems.HALO_HALO_FEAST.get(), UbesDelightItems.HALO_HALO.get(), 4, 1.0F, exporter);
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItems.LECHE_FLAN_FEAST.get(), UbesDelightItems.LECHE_FLAN.get(), 5, 1.0F, exporter);
        basicCuttingRecipeBuilder(holderGetter, UbesDelightItems.UBE_CAKE.get(), UbesDelightItems.UBE_CAKE_SLICE.get(), 7, 1.0F, exporter);

    }

    private static void basicCuttingRecipeBuilder(HolderGetter<Item> holderGetter, Item input, Item output, int outputCount, float chance, RecipeOutput exporter) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(input), Ingredient.of(holderGetter.getOrThrow(CommonTags.C_TOOLS_KNIFE)), output, outputCount, (int) chance)
                .build(exporter, suffix(RecipeProvider.getConversionRecipeName(output, input)));
    }

    private static Identifier suffix(String string) {
        return TextUtils.res("cutting/" + string);
    }
}
