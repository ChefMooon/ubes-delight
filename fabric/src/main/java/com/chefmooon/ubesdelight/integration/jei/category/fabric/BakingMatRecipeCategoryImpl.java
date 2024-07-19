package com.chefmooon.ubesdelight.integration.jei.category.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.crafting.ingredient.ChanceResult;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.integration.jei.fabric.UDRecipeTypesImpl;
import com.mojang.datafixers.util.Pair;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.ChatFormatting;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

@MethodsReturnNonnullByDefault
public class BakingMatRecipeCategoryImpl implements IRecipeCategory<BakingMatRecipeImpl> {
    //private final IDrawable slotSmall;
    private final IDrawable slotLarge;
    private final IDrawable slotChance;
    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;

    public BakingMatRecipeCategoryImpl(IGuiHelper helper) {
        title = TextUtils.getTranslatable("rei.baking_mat");
        ResourceLocation backgroundImage = new ResourceLocation(UbesDelight.MOD_ID, "textures/gui/emi/baking_mat.png");
        slotLarge = helper.createDrawable(backgroundImage, 0, 80, 18, 18);
        slotChance = helper.createDrawable(backgroundImage, 18, 80, 18, 18);
        background = helper.createDrawable(backgroundImage, 7, 9, 149, 56);
        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(UbesDelightItemsImpl.BAKING_MAT_BAMBOO));
    }

    @Override
    public RecipeType<BakingMatRecipeImpl> getRecipeType() {
        return UDRecipeTypesImpl.BAKING_MAT;
    }

    @Override
    public Component getTitle() {
        return this.title;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public int getWidth() {
        return 151;
    }

    @Override
    public int getHeight() {
        return 56;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BakingMatRecipeImpl recipe, IFocusGroup focuses) {
        List<Ingredient> getIngredients = recipe.getIngredients();
        List<Ingredient> getProcessStages = recipe.getProcessStages();
        List<ItemStack> recipeOutputs = recipe.getMandatoryResults();
        List<ChanceResult> recipeChanceOutputs = recipe.getVariableResult();

        // Tool
        builder.addSlot(RecipeIngredientRole.CATALYST, 57, 1)
                .addIngredients(recipe.getTool());

        // Input
        for (int i = 0; i < getIngredients.size(); i++) {
            Pair<Integer, Integer> slotLoc = getInputItemOffset(19, 20, i);
            builder.addSlot(RecipeIngredientRole.INPUT, slotLoc.getFirst(), slotLoc.getSecond())
                    .addIngredients(getIngredients.get(i));
        }

        // Process Stages
        if (getProcessStages.size() > 0) {
            for (int j = 0; j < getProcessStages.size(); j++) {
                builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 57 + j * 19, 39)
                        .addIngredients(getProcessStages.get(j));
            }
        }

        // Mandatory Outputs
        for (int k = 0; k < recipeOutputs.size(); k++) {
            builder.addSlot(RecipeIngredientRole.OUTPUT, 78 + k * 19, 20)
                    .addItemStack(recipeOutputs.get(k));
        }

        // Chance Outputs
        for (int l = 0; l < recipeChanceOutputs.size(); l++) {
            int index = l;
            builder.addSlot(RecipeIngredientRole.OUTPUT, 78 + l * 19, 1)
                    .addItemStack(recipeChanceOutputs.get(l).stack())
                    .addTooltipCallback((slotView, tooltip) -> {
                        ChanceResult output = recipeChanceOutputs.get(index);
                        float chance = output.chance();
                        if (chance != 1)
                            tooltip.add(1, TextUtils.getTranslatable("rei.chance", chance < 0.01 ? "<1" : (int) (chance * 100))
                                    .withStyle(ChatFormatting.GOLD));
                    });
        }
    }

    @Override
    public void draw(BakingMatRecipeImpl recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        NonNullList<Ingredient> recipeInputs = recipe.getIngredients();
        NonNullList<Ingredient> recipeProcessStages = recipe.getProcessStages();
        List<ChanceResult> recipeChanceOutputs = recipe.getVariableResult();
        List<ItemStack> recipeOutputs = recipe.getMandatoryResults();

        // Input
        for (int i = 0; i < recipeInputs.size(); i++) {
            Pair<Integer, Integer> slotLoc = getInputItemOffset(18, 19, i);
            slotLarge.draw(guiGraphics, slotLoc.getFirst(), slotLoc.getSecond());
        }

        // Process Stages
        if (recipeProcessStages.size() > 0) {
            for (int j = 0; j < recipeProcessStages.size(); j++) {
                slotLarge.draw(guiGraphics, 56 + j * 19, 38);
            }
        }

        // Mandatory Outputs
        for (int k = 0; k < recipeOutputs.size(); k++) {
            slotLarge.draw(guiGraphics, 77 + k * 19, 19);
        }

        // Chance Outputs
        for (int l = 0; l < recipeChanceOutputs.size(); l++) {
            slotChance.draw(guiGraphics, 77 + l * 19, 0);
        }
    }

    public static Pair<Integer, Integer> getInputItemOffset(int x, int y, int index) {
        final int xOffset = 19;
        final int yOffset = 19;
        List<Pair<Integer, Integer>> listOfPairs = new ArrayList<>(List.of(
                Pair.of(x, y), Pair.of(x + xOffset, y), Pair.of(x - xOffset, y),
                Pair.of(x, y - yOffset), Pair.of(x, y + yOffset), Pair.of(x + xOffset, y - yOffset),
                Pair.of(x - xOffset, y - yOffset), Pair.of(x + xOffset, y + yOffset), Pair.of(x - xOffset, y + yOffset)));

        return listOfPairs.get(index);
    }
}
