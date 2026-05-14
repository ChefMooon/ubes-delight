package chefmooon.ubesdelight.data.recipe;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.utility.RecipeUtil;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;

public class SmeltingRecipes {

    public static void register(RecipeOutput exporter) {
        RecipeUtil.offerSmeltCampSmokeRecipe(Items.SUGAR, RecipeCategory.FOOD, UbesDelightItems.SUGAR_BROWN.get(), 0.5F, 200, exporter);

        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItems.PANDESAL_RAW.get(), RecipeCategory.FOOD, UbesDelightItems.PANDESAL.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItems.PANDESAL_UBE_RAW.get(), RecipeCategory.FOOD, UbesDelightItems.PANDESAL_UBE.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItems.ENSAYMADA_RAW.get(), RecipeCategory.FOOD, UbesDelightItems.ENSAYMADA.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItems.ENSAYMADA_UBE_RAW.get(), RecipeCategory.FOOD, UbesDelightItems.ENSAYMADA_UBE.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItems.HOPIA_MUNGGO_RAW.get(), RecipeCategory.FOOD, UbesDelightItems.HOPIA_MUNGGO.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(UbesDelightItems.HOPIA_UBE_RAW.get(), RecipeCategory.FOOD, UbesDelightItems.HOPIA_UBE.get(), 0.5F, 200, exporter);

        RecipeUtil.offerSmeltCampSmokeFromTag(ConventionalItemTags.MILK_DRINKS, UbesDelightItems.MILK_POWDER.get(), 0.2F, 200, exporter);
    }
}
