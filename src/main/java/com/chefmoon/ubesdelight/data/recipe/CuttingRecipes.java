package com.chefmoon.ubesdelight.data.recipe;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.data.builder.CuttingBoardRecipeJsonBuilder;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import com.chefmoon.ubesdelight.util.RecipeUtil;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class CuttingRecipes {

    public static void register(Consumer<RecipeJsonProvider> exporter) {

        CuttingBoardRecipeJsonBuilder.create(ItemsRegistry.WILD_GARLIC.get(), Ingredient.fromTag(CommonTags.C_TOOLS_KNIVES), ItemsRegistry.GARLIC.get(), 1,1.0F)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIVES), RecipeProvider.conditionsFromTag(CommonTags.C_TOOLS_KNIVES))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.GARLIC.get(), ItemsRegistry.WILD_GARLIC.get())));

        CuttingBoardRecipeJsonBuilder.create(ItemsRegistry.WILD_GINGER.get(), Ingredient.fromTag(CommonTags.C_TOOLS_KNIVES), ItemsRegistry.GINGER.get(), 1,1.0F)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIVES), RecipeProvider.conditionsFromTag(CommonTags.C_TOOLS_KNIVES))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.GINGER.get(), ItemsRegistry.WILD_GINGER.get())));

        CuttingBoardRecipeJsonBuilder.create(ItemsRegistry.WILD_UBE.get(), Ingredient.fromTag(CommonTags.C_TOOLS_KNIVES), ItemsRegistry.UBE.get(), 1, 1.0F)
                .output(Items.PURPLE_DYE)
                .output(Items.PURPLE_DYE, 0.5F)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIVES), RecipeProvider.conditionsFromTag(CommonTags.C_TOOLS_KNIVES))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.UBE.get(), ItemsRegistry.WILD_UBE.get())));

        CuttingBoardRecipeJsonBuilder.create(ItemsRegistry.WILD_LEMONGRASS.get(), Ingredient.fromTag(CommonTags.C_TOOLS_KNIVES), ItemsRegistry.LEMONGRASS.get(), 1, 1.0F)
                .output(Items.LIME_DYE)
                .output(Items.LIME_DYE, 0.5F)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIVES), RecipeProvider.conditionsFromTag(CommonTags.C_TOOLS_KNIVES))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.LEMONGRASS.get(), ItemsRegistry.WILD_LEMONGRASS.get())));

        CuttingBoardRecipeJsonBuilder.create(ItemsRegistry.HALO_HALO_FEAST.get(), Ingredient.fromTag(CommonTags.C_TOOLS_KNIVES), ItemsRegistry.HALO_HALO.get(), 4,1.0F)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIVES), RecipeProvider.conditionsFromTag(CommonTags.C_TOOLS_KNIVES))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.HALO_HALO.get(), ItemsRegistry.HALO_HALO_FEAST.get())));

        CuttingBoardRecipeJsonBuilder.create(ItemsRegistry.LECHE_FLAN_FEAST.get(), Ingredient.fromTag(CommonTags.C_TOOLS_KNIVES), ItemsRegistry.LECHE_FLAN.get(), 5,1.0F)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIVES), RecipeProvider.conditionsFromTag(CommonTags.C_TOOLS_KNIVES))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.LECHE_FLAN.get(), ItemsRegistry.LECHE_FLAN_FEAST.get())));

        CuttingBoardRecipeJsonBuilder.create(ItemsRegistry.UBE_CAKE.get(), Ingredient.fromTag(CommonTags.C_TOOLS_KNIVES), ItemsRegistry.UBE_CAKE_SLICE.get(), 7,1.0F)
                .criterion(RecipeUtil.hasItemTag(CommonTags.C_TOOLS_KNIVES), RecipeProvider.conditionsFromTag(CommonTags.C_TOOLS_KNIVES))
                .offerTo(exporter, suffix(RecipeProvider.convertBetween(ItemsRegistry.UBE_CAKE_SLICE.get(), ItemsRegistry.UBE_CAKE.get())));
    }

    private static Identifier suffix(String string) {
        return new Identifier(UbesDelightMod.MOD_ID,  string + "_from_cutting");
    }
}
