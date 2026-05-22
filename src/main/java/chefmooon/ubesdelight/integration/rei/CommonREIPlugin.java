//package chefmooon.ubesdelight.integration.rei;
//
//import chefmooon.ubesdelight.common.crafting.BakingMatRecipe;
//import chefmooon.ubesdelight.common.registry.UbesDelightItems;
//import chefmooon.ubesdelight.common.registry.UbesDelightRecipeTypes;
//import chefmooon.ubesdelight.common.utility.TextUtils;
//import chefmooon.ubesdelight.integration.rei.display.BakingMatRecipeDisplay;
//import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
//import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
//import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
//import me.shedaniel.rei.api.common.util.EntryIngredients;
//import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
//import net.minecraft.network.chat.Component;
//
//import java.util.List;
//
//public class CommonREIPlugin implements REICommonPlugin {
//    @Override
//    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
//        registry.register(TextUtils.res("default/baking_mat"), BakingMatRecipeDisplay.SERIALIZER);
//    }
//
//    @Override
//    public void registerDisplays(ServerDisplayRegistry registry) {
//        registry.beginRecipeFiller(BakingMatRecipe.class)
//                        .filterType(UbesDelightRecipeTypes.BAKING_MAT.get())
//                                .fill(BakingMatRecipeDisplay::new);
//
//        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
//                UbesDelightItems.ROLLING_PIN_WOOD.get(),
//                UbesDelightItems.ROLLING_PIN_GOLD.get(),
//                UbesDelightItems.ROLLING_PIN_DIAMOND.get(),
//                UbesDelightItems.ROLLING_PIN_NETHERITE.get()
//        )), Component.translatable("item.ubesdelight.rolling_pin_wood")).lines(TextUtils.getTranslatable("rei.info.rolling_pin")));
//
//        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
//                UbesDelightItems.WILD_UBE.get(),
//                UbesDelightItems.UBE.get()
//        )), Component.translatable("item.ubesdelight.ube")).lines(TextUtils.getTranslatable("rei.info.ube")));
//        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
//                UbesDelightItems.WILD_GARLIC.get(),
//                UbesDelightItems.GARLIC.get()
//        )), Component.translatable("item.ubesdelight.garlic")).lines(TextUtils.getTranslatable("rei.info.garlic")));
//        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
//                UbesDelightItems.WILD_GINGER.get(),
//                UbesDelightItems.GINGER.get()
//        )), Component.translatable("item.ubesdelight.ginger")).lines(TextUtils.getTranslatable("rei.info.ginger")));
//        registry.add(DefaultInformationDisplay.createFromEntries(EntryIngredients.ofItems(List.of(
//                UbesDelightItems.WILD_LEMONGRASS.get(),
//                UbesDelightItems.LEMONGRASS.get()
//        )), Component.translatable("item.ubesdelight.lemongrass")).lines(TextUtils.getTranslatable("rei.info.lemongrass")));
//    }
//}
