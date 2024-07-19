package com.chefmooon.ubesdelight.integration.rei.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeTypesImpl;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.integration.rei.baking_mat.fabric.BakingMatRecipeCategory;
import com.chefmooon.ubesdelight.integration.rei.baking_mat.fabric.BakingMatRecipeDisplay;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ClientREIPluginImpl implements REIClientPlugin {
    public static final CategoryIdentifier<BakingMatRecipeDisplay> BAKING_MAT = CategoryIdentifier.of(UbesDelight.MOD_ID, "baking_mat");
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new BakingMatRecipeCategory());
        registry.addWorkstations(BAKING_MAT, EntryStacks.of(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(BakingMatRecipeImpl.class, UbesDelightRecipeTypesImpl.BAKING_MAT.get(), BakingMatRecipeDisplay::new);

        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(UbesDelightItemsImpl.ROLLING_PIN_WOOD), Component.translatable("item.ubesdelight.rolling_pin_wood")).lines(TextUtils.getTranslatable("rei.info.rolling_pin")));

        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(UbesDelightItemsImpl.WILD_UBE, UbesDelightItemsImpl.UBE)), Component.translatable("item.ubesdelight.ube")).lines(TextUtils.getTranslatable("rei.info.ube")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(UbesDelightItemsImpl.WILD_GARLIC, UbesDelightItemsImpl.GARLIC)), Component.translatable("item.ubesdelight.garlic")).lines(TextUtils.getTranslatable("rei.info.garlic")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(UbesDelightItemsImpl.WILD_GINGER, UbesDelightItemsImpl.GINGER)), Component.translatable("item.ubesdelight.ginger")).lines(TextUtils.getTranslatable("rei.info.ginger")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(UbesDelightItemsImpl.WILD_LEMONGRASS, UbesDelightItemsImpl.LEMONGRASS)), Component.translatable("item.ubesdelight.lemongrass")).lines(TextUtils.getTranslatable("rei.info.lemongrass")));
    }
}
