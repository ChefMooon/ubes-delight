package com.chefmooon.ubesdelight.integration.jei.forge;

import com.chefmooon.ubesdelight.common.registry.forge.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.integration.jei.JEIPlugin;
import com.chefmooon.ubesdelight.integration.jei.category.forge.BakingMatRecipeCategoryImpl;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@JeiPlugin
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@SuppressWarnings("unused")
public class JEIPluginImpl implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return JEIPlugin.ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new BakingMatRecipeCategoryImpl(registry.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        UDRecipesImpl recipes = new UDRecipesImpl();
        registration.addRecipes(UDRecipeTypesImpl.BAKING_MAT, recipes.getBakingMatRecipes());

        registration.addIngredientInfo(new ItemStack(UbesDelightItemsImpl.ROLLING_PIN_WOOD.get()), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.rolling_pin"));

        registration.addIngredientInfo(List.of(new ItemStack(UbesDelightItemsImpl.WILD_UBE.get()), new ItemStack(UbesDelightItemsImpl.UBE.get())), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.ube"));
        registration.addIngredientInfo(List.of(new ItemStack(UbesDelightItemsImpl.WILD_GARLIC.get()), new ItemStack(UbesDelightItemsImpl.GARLIC.get())), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.garlic"));
        registration.addIngredientInfo(List.of(new ItemStack(UbesDelightItemsImpl.WILD_GINGER.get()), new ItemStack(UbesDelightItemsImpl.GINGER.get())), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.ginger"));
        registration.addIngredientInfo(List.of(new ItemStack(UbesDelightItemsImpl.WILD_LEMONGRASS.get()), new ItemStack(UbesDelightItemsImpl.LEMONGRASS.get())), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.lemongrass"));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(UbesDelightItemsImpl.BAKING_MAT_BAMBOO.get()), UDRecipeTypesImpl.BAKING_MAT);
    }
}
