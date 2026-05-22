package chefmooon.ubesdelight.integration.jei;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.utility.TextUtils;
import chefmooon.ubesdelight.integration.jei.category.BakingMatRecipeCategory;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

import java.util.List;

@JeiPlugin
@MethodsReturnNonnullByDefault
public class JEIPlugin implements IModPlugin {
    public static final Identifier ID = TextUtils.res("jei_plugin");
    @Override
    public Identifier getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new BakingMatRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        UDRecipes recipes = new UDRecipes();
        registration.addRecipes(UDRecipeTypesImpl.BAKING_MAT, recipes.getBakingMatRecipes());

        registration.addIngredientInfo(List.of(new ItemStack(UbesDelightItems.ROLLING_PIN_WOOD.get()),
                        new ItemStack(UbesDelightItems.ROLLING_PIN_IRON.get()),
                        new ItemStack(UbesDelightItems.ROLLING_PIN_GOLD.get()),
                        new ItemStack(UbesDelightItems.ROLLING_PIN_DIAMOND.get()),
                        new ItemStack(UbesDelightItems.ROLLING_PIN_NETHERITE.get())),
                VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.rolling_pin"));

        registration.addIngredientInfo(List.of(new ItemStack(UbesDelightItems.WILD_UBE.get()), new ItemStack(UbesDelightItems.UBE.get())), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.ube"));
        registration.addIngredientInfo(List.of(new ItemStack(UbesDelightItems.WILD_GARLIC.get()), new ItemStack(UbesDelightItems.GARLIC.get())), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.garlic"));
        registration.addIngredientInfo(List.of(new ItemStack(UbesDelightItems.WILD_GINGER.get()), new ItemStack(UbesDelightItems.GINGER.get())), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.ginger"));
        registration.addIngredientInfo(List.of(new ItemStack(UbesDelightItems.WILD_LEMONGRASS.get()), new ItemStack(UbesDelightItems.LEMONGRASS.get())), VanillaTypes.ITEM_STACK, TextUtils.getTranslatable("rei.info.lemongrass"));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addCraftingStation(UDRecipeTypesImpl.BAKING_MAT, new ItemStack(UbesDelightItems.BAKING_MAT_BAMBOO.get()));
    }

//    public static void syncRecipes() {
//        RecipeSynchronization.synchronizeRecipeSerializer(UbesDelightRecipeSerializers.BAKING_MAT.get());
//    }
}
