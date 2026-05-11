//package com.chefmooon.ubesdelight.integration.rei.client.fabric;
//
//import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightBlocksImpl;
//import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
//import com.chefmooon.ubesdelight.common.utility.TextUtils;
//import com.chefmooon.ubesdelight.integration.rei.client.categories.fabric.BakingMatRecipeCategory;
//import com.chefmooon.ubesdelight.integration.rei.fabric.REICategoryIdentifiersImpl;
//import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
//import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
//import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
//import me.shedaniel.rei.api.common.util.EntryIngredients;
//import me.shedaniel.rei.api.common.util.EntryStacks;
//import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
//import net.minecraft.network.chat.Component;
//
//import java.util.List;
//
//public class ClientREIPluginImpl implements REIClientPlugin {
//    @Override
//    public void registerDisplays(DisplayRegistry registry) {
//        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
//                UbesDelightItemsImpl.ROLLING_PIN_WOOD.get(),
//                UbesDelightItemsImpl.ROLLING_PIN_GOLD.get(),
//                UbesDelightItemsImpl.ROLLING_PIN_DIAMOND.get(),
//                UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get()
//        )), Component.translatable("item.ubesdelight.rolling_pin")).lines(TextUtils.getTranslatable("rei.info.rolling_pin")));
//
//        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
//                UbesDelightItemsImpl.WILD_UBE.get(),
//                UbesDelightItemsImpl.UBE.get()
//        )), Component.translatable("item.ubesdelight.ube")).lines(TextUtils.getTranslatable("rei.info.ube")));
//        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
//                UbesDelightItemsImpl.WILD_GARLIC.get(),
//                UbesDelightItemsImpl.GARLIC.get()
//        )), Component.translatable("item.ubesdelight.garlic")).lines(TextUtils.getTranslatable("rei.info.garlic")));
//        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
//                UbesDelightItemsImpl.WILD_GINGER.get(),
//                UbesDelightItemsImpl.GINGER.get()
//        )), Component.translatable("item.ubesdelight.ginger")).lines(TextUtils.getTranslatable("rei.info.ginger")));
//        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
//                UbesDelightItemsImpl.WILD_LEMONGRASS.get(),
//                UbesDelightItemsImpl.LEMONGRASS.get()
//        )), Component.translatable("item.ubesdelight.lemongrass")).lines(TextUtils.getTranslatable("rei.info.lemongrass")));
//    }
//
//    @Override
//    public void registerCategories(CategoryRegistry registry) {
//        registry.add(new BakingMatRecipeCategory());
//        registry.addWorkstations(REICategoryIdentifiersImpl.BAKING_MAT, EntryStacks.of(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get()));
//    }
//}
