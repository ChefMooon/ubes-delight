package com.chefmooon.ubesdelight.integration.rei.forge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.crafting.forge.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.forge.UbesDelightBlocksImpl;
import com.chefmooon.ubesdelight.common.registry.forge.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.registry.forge.UbesDelightRecipeTypesImpl;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.integration.rei.baking_mat.forge.BakingMatRecipeCategory;
import com.chefmooon.ubesdelight.integration.rei.baking_mat.forge.BakingMatRecipeDisplay;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
import net.minecraft.network.chat.Component;

import java.util.List;

@REIPluginClient
public class ClientREIPluginImpl implements REIClientPlugin {
    public static final CategoryIdentifier<BakingMatRecipeDisplay> BAKING_MAT = CategoryIdentifier.of(UbesDelight.MOD_ID, "baking_mat");
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new BakingMatRecipeCategory());
        registry.addWorkstations(BAKING_MAT, EntryStacks.of(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get()));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(BakingMatRecipeImpl.class, UbesDelightRecipeTypesImpl.BAKING_MAT.get(), BakingMatRecipeDisplay::new);

        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.of(UbesDelightItemsImpl.ROLLING_PIN_WOOD.get()), Component.translatable("item.ubesdelight.rolling_pin_wood")).lines(TextUtils.getTranslatable("rei.info.rolling_pin")));

        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(UbesDelightItemsImpl.WILD_UBE.get(), UbesDelightItemsImpl.UBE.get())), Component.translatable("item.ubesdelight.ube")).lines(TextUtils.getTranslatable("rei.info.ube")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(UbesDelightItemsImpl.WILD_GARLIC.get(), UbesDelightItemsImpl.GARLIC.get())), Component.translatable("item.ubesdelight.garlic")).lines(TextUtils.getTranslatable("rei.info.garlic")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(UbesDelightItemsImpl.WILD_GINGER.get(), UbesDelightItemsImpl.GINGER.get())), Component.translatable("item.ubesdelight.ginger")).lines(TextUtils.getTranslatable("rei.info.ginger")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(UbesDelightItemsImpl.WILD_LEMONGRASS.get(), UbesDelightItemsImpl.LEMONGRASS.get())), Component.translatable("item.ubesdelight.lemongrass")).lines(TextUtils.getTranslatable("rei.info.lemongrass")));
    }

}
