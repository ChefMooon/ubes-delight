package com.chefmooon.ubesdelight.integration.rei.fabric;

import com.chefmooon.ubesdelight.common.crafting.fabric.BakingMatRecipeImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightRecipeTypesImpl;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.integration.rei.display.fabric.BakingMatRecipeDisplay;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
import net.minecraft.network.chat.Component;

import java.util.List;

public class CommonREIPluginImpl implements REICommonPlugin {
    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(TextUtils.res("default/baking_mat"), BakingMatRecipeDisplay.SERIALIZER);
    }

    @Override
    public void registerDisplays(ServerDisplayRegistry registry) {
        registry.beginRecipeFiller(BakingMatRecipeImpl.class)
                        .filterType(UbesDelightRecipeTypesImpl.BAKING_MAT.get())
                                .fill(BakingMatRecipeDisplay::new);

        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
                UbesDelightItemsImpl.ROLLING_PIN_WOOD.get(),
                UbesDelightItemsImpl.ROLLING_PIN_GOLD.get(),
                UbesDelightItemsImpl.ROLLING_PIN_DIAMOND.get(),
                UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get()
        )), Component.translatable("item.ubesdelight.rolling_pin_wood")).lines(TextUtils.getTranslatable("rei.info.rolling_pin")));

        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
                UbesDelightItemsImpl.WILD_UBE.get(),
                UbesDelightItemsImpl.UBE.get()
        )), Component.translatable("item.ubesdelight.ube")).lines(TextUtils.getTranslatable("rei.info.ube")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
                UbesDelightItemsImpl.WILD_GARLIC.get(),
                UbesDelightItemsImpl.GARLIC.get()
        )), Component.translatable("item.ubesdelight.garlic")).lines(TextUtils.getTranslatable("rei.info.garlic")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
                UbesDelightItemsImpl.WILD_GINGER.get(),
                UbesDelightItemsImpl.GINGER.get()
        )), Component.translatable("item.ubesdelight.ginger")).lines(TextUtils.getTranslatable("rei.info.ginger")));
        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
                UbesDelightItemsImpl.WILD_LEMONGRASS.get(),
                UbesDelightItemsImpl.LEMONGRASS.get()
        )), Component.translatable("item.ubesdelight.lemongrass")).lines(TextUtils.getTranslatable("rei.info.lemongrass")));
    }
}
