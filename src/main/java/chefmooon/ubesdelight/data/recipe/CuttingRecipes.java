package chefmooon.ubesdelight.data.recipe;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.utility.RecipeUtil;
import chefmooon.ubesdelight.common.utility.TextUtils;
import chefmooon.ubesdelight.data.UDRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class CuttingRecipes extends UDRecipes {

    public CuttingRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static void register(RecipeOutput exporter) {

        basicCuttingRecipeBuilder(UbesDelightItems.GARLIC.get(), UbesDelightItems.GARLIC_CHOP.get(), 2, 1.0F, exporter);
        basicCuttingRecipeBuilder(UbesDelightItems.GINGER.get(), UbesDelightItems.GINGER_CHOP.get(), 2, 1.0F, exporter);
        basicCuttingRecipeBuilder(UbesDelightItems.WILD_GARLIC.get(), UbesDelightItems.GARLIC.get(), 1, 1.0F, exporter);
        basicCuttingRecipeBuilder(UbesDelightItems.WILD_GINGER.get(), UbesDelightItems.GINGER.get(), 1, 1.0F, exporter);
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(UbesDelightItems.WILD_UBE.get()), Ingredient.of(CommonTags.C_TOOLS_KNIFE), UbesDelightItems.UBE.get(), 1, 1.0F)
                .addResult(Items.PURPLE_DYE)
                .addResultWithChance(Items.PURPLE_DYE, 0.5F)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIFE), RecipeUtil.getTriggerfromTag(CommonTags.C_TOOLS_KNIFE))
                .save(exporter, TextUtils.res(RecipeProvider.getConversionRecipeName(UbesDelightItems.UBE.get(), UbesDelightItems.WILD_UBE.get())));
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(UbesDelightItems.WILD_LEMONGRASS.get()), Ingredient.of(CommonTags.C_TOOLS_KNIFE), UbesDelightItems.LEMONGRASS.get(), 1, 1.0F)
                .addResult(Items.LIME_DYE)
                .addResultWithChance(Items.LIME_DYE, 0.5F)
                .unlockedBy(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIFE), RecipeUtil.getTriggerfromTag(CommonTags.C_TOOLS_KNIFE))
                .save(exporter, TextUtils.res(RecipeProvider.getConversionRecipeName(UbesDelightItems.LEMONGRASS.get(), UbesDelightItems.WILD_LEMONGRASS.get())));
        basicCuttingRecipeBuilder(UbesDelightItems.HALO_HALO_FEAST.get(), UbesDelightItems.HALO_HALO.get(), 4, 1.0F, exporter);
        basicCuttingRecipeBuilder(UbesDelightItems.LECHE_FLAN_FEAST.get(), UbesDelightItems.LECHE_FLAN.get(), 5, 1.0F, exporter);
        basicCuttingRecipeBuilder(UbesDelightItems.UBE_CAKE.get(), UbesDelightItems.UBE_CAKE_SLICE.get(), 7, 1.0F, exporter);

    }

    private static void basicCuttingRecipeBuilder(Item input, Item output, int outputCount, float chance, RecipeOutput exporter) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(input), Ingredient.of(CommonTags.C_TOOLS_KNIFE), output, outputCount, chance)
                .save(exporter, suffix(RecipeProvider.getConversionRecipeName(output, input)));
    }

    private static ResourceLocation suffix(String string) {
        return TextUtils.res(string);
    }
}
