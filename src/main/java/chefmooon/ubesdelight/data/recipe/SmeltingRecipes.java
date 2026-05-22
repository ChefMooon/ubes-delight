package chefmooon.ubesdelight.data.recipe;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.utility.RecipeUtil;
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
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, Items.SUGAR, RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItems.SUGAR_BROWN.get(), 0.5F, 200, exporter);

        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItems.PANDESAL_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItems.PANDESAL.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItems.PANDESAL_UBE_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItems.PANDESAL_UBE.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItems.ENSAYMADA_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItems.ENSAYMADA.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItems.ENSAYMADA_UBE_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItems.ENSAYMADA_UBE.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItems.HOPIA_MUNGGO_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItems.HOPIA_MUNGGO.get(), 0.5F, 200, exporter);
        RecipeUtil.offerSmeltCampSmokeRecipe(holderGetter, UbesDelightItems.HOPIA_UBE_RAW.get(), RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItems.HOPIA_UBE.get(), 0.5F, 200, exporter);

        RecipeUtil.offerSmeltCampSmokeFromTag(holderGetter, ConventionalItemTags.MILK_DRINKS, RecipeCategory.FOOD, CookingBookCategory.FOOD, UbesDelightItems.MILK_POWDER.get(), 0.2F, 200, exporter);
    }
}
