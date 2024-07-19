package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.tag.CompatibilityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        registerMinecraftItemTags();
        registerCompatibiltyItemTags();
        registerCommonItemTags();
        //registerFabricCommonItemTags(); // run once then move to fabric
    }

    private void registerMinecraftItemTags() {
        // Minecraft Item Tags
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(UbesDelightItemsImpl.WILD_UBE)
                .add(UbesDelightItemsImpl.WILD_GARLIC)
                .add(UbesDelightItemsImpl.WILD_GINGER);

        getOrCreateTagBuilder(ItemTags.TALL_FLOWERS)
                .add(UbesDelightItemsImpl.WILD_LEMONGRASS);
    }
    private void registerCompatibiltyItemTags() {
        // Create Item Tags
        getOrCreateTagBuilder(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
                .add(UbesDelightItemsImpl.MILK_TEA_UBE)
                .add(UbesDelightItemsImpl.HALO_HALO)
                .add(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE)
                .add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE)
                .add(UbesDelightItemsImpl.UBE_CAKE)
                .add(UbesDelightItemsImpl.LECHE_FLAN_FEAST)
                .add(UbesDelightItemsImpl.HALO_HALO_FEAST)
                .add(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST)
                .add(UbesDelightItemsImpl.BULALO)
                .add(UbesDelightItemsImpl.ARROZ_CALDO)
                .add(UbesDelightItemsImpl.MECHADO);

        // Farmers Delight Item Tags
        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS)
                .add(UbesDelightItemsImpl.UBE);

        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS_ITEM)
                .add(UbesDelightItemsImpl.WILD_UBE)
                .add(UbesDelightItemsImpl.WILD_GARLIC)
                .add(UbesDelightItemsImpl.WILD_GINGER)
                .add(UbesDelightItemsImpl.WILD_LEMONGRASS);

        // Supplementaries Item Tags
        getOrCreateTagBuilder(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(UbesDelightItemsImpl.COOKIE_UBE)
                .add(UbesDelightItemsImpl.COOKIE_GINGER)
                .add(UbesDelightItemsImpl.POLVORONE)
                .add(UbesDelightItemsImpl.POLVORONE_PINIPIG)
                .add(UbesDelightItemsImpl.POLVORONE_UBE)
                .add(UbesDelightItemsImpl.POLVORONE_CC);

        // Dehydration Item Tags
        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE)
                .add(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE)
                .add(UbesDelightItemsImpl.MILK_TEA_UBE)
                .add(UbesDelightItemsImpl.HALO_HALO);

        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(UbesDelightItemsImpl.BULALO)
                .add(UbesDelightItemsImpl.ARROZ_CALDO)
                .add(UbesDelightItemsImpl.MECHADO);

        // Origins Item Tags
        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_IGNORE_DIET)
                .add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE)
                .add(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE);

        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_MEAT)
                .add(UbesDelightItemsImpl.LUMPIA)
                .add(UbesDelightItemsImpl.TOCINO)
                .add(UbesDelightItemsImpl.CHICKEN_INASAL)
                .add(UbesDelightItemsImpl.CHICKEN_INASAL_RICE)
                .add(UbesDelightItemsImpl.TOSILOG)
                .add(UbesDelightItemsImpl.BANGSILOG)
                .add(UbesDelightItemsImpl.SISIG)
                .add(UbesDelightItemsImpl.BULALO)
                .add(UbesDelightItemsImpl.ARROZ_CALDO)
                .add(UbesDelightItemsImpl.MECHADO);
    }

    private void registerCommonItemTags() {
        getOrCreateTagBuilder(CommonTags.C_FOOD_WRAPPERS)
                .forceAddTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER);
        getOrCreateTagBuilder(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)
                .add(UbesDelightItemsImpl.LUMPIA_WRAPPER);

        getOrCreateTagBuilder(CommonTags.C_TOOLS_ROLLING_PINS)
                .add(UbesDelightItemsImpl.ROLLING_PIN_WOOD);

        getOrCreateTagBuilder(CommonTags.C_TEA_INGREDIENTS)
                .forceAddTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK);
        getOrCreateTagBuilder(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .add(Items.SUGAR)
                .add(UbesDelightItemsImpl.SUGAR_BROWN);
    }

    private void registerFabricCommonItemTags() {
        getOrCreateTagBuilder(CommonTags.C_CROPS)
                .forceAddTag(CommonTags.C_CROPS_UBE)
                .forceAddTag(CommonTags.C_CROPS_GARLIC)
                .forceAddTag(CommonTags.C_CROPS_GINGER)
                .forceAddTag(CommonTags.C_CROPS_LEMONGRASS);
        getOrCreateTagBuilder(CommonTags.C_CROPS_GARLIC)
                .add(UbesDelightItemsImpl.GARLIC)
                .add(UbesDelightItemsImpl.GARLIC_CHOP);
        getOrCreateTagBuilder(CommonTags.C_CROPS_GINGER)
                .add(UbesDelightItemsImpl.GINGER)
                .add(UbesDelightItemsImpl.GINGER_CHOP);
        getOrCreateTagBuilder(CommonTags.C_CROPS_LEMONGRASS)
                .add(UbesDelightItemsImpl.LEMONGRASS);
        getOrCreateTagBuilder(CommonTags.C_CROPS_UBE)
                .add(UbesDelightItemsImpl.UBE);

        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES)
                .forceAddTag(CommonTags.C_FOODS_VEGETABLES_GARLIC)
                .forceAddTag(CommonTags.C_FOODS_VEGETABLES_GINGER)
                .forceAddTag(CommonTags.C_FOODS_VEGETABLES_LEMONGRASS)
                .forceAddTag(CommonTags.C_FOODS_VEGETABLES_UBE);
        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES_GARLIC)
                .add(UbesDelightItemsImpl.GARLIC)
                .add(UbesDelightItemsImpl.GARLIC_CHOP);
        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES_GINGER)
                .add(UbesDelightItemsImpl.GINGER)
                .add(UbesDelightItemsImpl.GINGER_CHOP);
        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES_LEMONGRASS)
                .add(UbesDelightItemsImpl.LEMONGRASS);
        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES_UBE)
                .add(UbesDelightItemsImpl.UBE);

        getOrCreateTagBuilder(CommonTags.C_FOODS)
                .add(UbesDelightItemsImpl.POISONOUS_UBE)
                .add(UbesDelightItemsImpl.UBE)
                .add(UbesDelightItemsImpl.GARLIC)
                .add(UbesDelightItemsImpl.GARLIC_CHOP)
                .add(UbesDelightItemsImpl.GINGER)
                .add(UbesDelightItemsImpl.GINGER_CHOP)
                .add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE)
                .add(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE)
                .add(UbesDelightItemsImpl.MILK_TEA_UBE)
                .add(UbesDelightItemsImpl.HALO_HALO)
                .add(UbesDelightItemsImpl.SINANGAG)
                .add(UbesDelightItemsImpl.KINILAW)
                .add(UbesDelightItemsImpl.LUMPIA)
                .add(UbesDelightItemsImpl.TOCINO)
                .add(UbesDelightItemsImpl.CHICKEN_INASAL)
                .add(UbesDelightItemsImpl.CHICKEN_INASAL_RICE)
                .add(UbesDelightItemsImpl.TOSILOG)
                .add(UbesDelightItemsImpl.BANGSILOG)
                .add(UbesDelightItemsImpl.SISIG)
                .add(UbesDelightItemsImpl.BULALO)
                .add(UbesDelightItemsImpl.ARROZ_CALDO)
                .add(UbesDelightItemsImpl.MECHADO)
                .add(UbesDelightItemsImpl.COOKIE_UBE)
                .add(UbesDelightItemsImpl.COOKIE_GINGER)
                .add(UbesDelightItemsImpl.LECHE_FLAN)
                .add(UbesDelightItemsImpl.UBE_CAKE_SLICE)
                .add(UbesDelightItemsImpl.POLVORONE)
                .add(UbesDelightItemsImpl.POLVORONE_PINIPIG)
                .add(UbesDelightItemsImpl.POLVORONE_UBE)
                .add(UbesDelightItemsImpl.POLVORONE_CC)
                .add(UbesDelightItemsImpl.PANDESAL)
                .add(UbesDelightItemsImpl.PANDESAL_UBE)
                .add(UbesDelightItemsImpl.ENSAYMADA)
                .add(UbesDelightItemsImpl.ENSAYMADA_UBE)
                .add(UbesDelightItemsImpl.HOPIA_MUNGGO)
                .add(UbesDelightItemsImpl.HOPIA_UBE)
        ;

        getOrCreateTagBuilder(CommonTags.C_MILKS)
                .forceAddTag(CommonTags.C_MILKS_MILK_BOTTLES);
        getOrCreateTagBuilder(CommonTags.C_MILKS_MILK_BOTTLES)
                .add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE);

        getOrCreateTagBuilder(CommonTags.C_SALAD_INGREDIENTS)
                .forceAddTag(CommonTags.C_SALAD_INGREDIENTS_LEMONGRASS);
        getOrCreateTagBuilder(CommonTags.C_SALAD_INGREDIENTS_LEMONGRASS)
                .add(UbesDelightItemsImpl.LEMONGRASS);

        getOrCreateTagBuilder(CommonTags.C_SEEDS)
                .forceAddTag(CommonTags.C_SEEDS_LEMONGRASS);
        getOrCreateTagBuilder(CommonTags.C_SEEDS_LEMONGRASS)
                .add(UbesDelightItemsImpl.LEMONGRASS_SEEDS);

        // Create Dough Compat
        getOrCreateTagBuilder(CommonTags.C_FOODS_DOUGHS)
                .addOptionalTag(CommonTags.C_DOUGH);

        // Extra compat (To Be Removed)
        getOrCreateTagBuilder(CommonTags.C_MILKS)
                .addOptionalTag(CommonTags.C_MILK);
        getOrCreateTagBuilder(CommonTags.C_MILKS_MILK_BOTTLES)
                .addOptionalTag(CommonTags.C_MILK_MILK_BOTTLE);

        getOrCreateTagBuilder(CommonTags.C_FOODS_RAW_MEATS_RAW_BEEF)
                .addOptionalTag(CommonTags.C_RAW_BEEF);
        getOrCreateTagBuilder(CommonTags.C_FOODS_RAW_MEATS_RAW_PORK)
                .addOptionalTag(CommonTags.C_RAW_PORK);
        getOrCreateTagBuilder(CommonTags.C_FOODS_RAW_MEATS_RAW_CHICKEN)
                .addOptionalTag(CommonTags.C_RAW_CHICKEN);
        getOrCreateTagBuilder(CommonTags.C_FOODS_RAW_FISHES)
                .addOptionalTag(CommonTags.C_RAW_FISHES);
        getOrCreateTagBuilder(CommonTags.C_GRAINS)
                .addOptionalTag(CommonTags.C_GRAIN);
        getOrCreateTagBuilder(CommonTags.C_FOODS_COOKED_MEATS_COOKED_EGGS)
                .addOptionalTag(CommonTags.C_COOKED_EGGS);

        getOrCreateTagBuilder(CommonTags.C_MILK_MILK_BOTTLE)
                .add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE);

        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES)
                .addOptionalTag(CommonTags.C_VEGETABLES);
        getOrCreateTagBuilder(CommonTags.C_VEGETABLES)
                .addOptionalTag(CommonTags.C_VEGETABLES_GARLIC)
                .addOptionalTag(CommonTags.C_VEGETABLES_GINGER)
                .addOptionalTag(CommonTags.C_VEGETABLES_LEMONGRASS)
                .addOptionalTag(CommonTags.C_VEGETABLES_UBE);
        getOrCreateTagBuilder(CommonTags.C_VEGETABLES_GARLIC)
                .add(UbesDelightItemsImpl.GARLIC)
                .add(UbesDelightItemsImpl.GARLIC_CHOP);
        getOrCreateTagBuilder(CommonTags.C_VEGETABLES_GINGER)
                .add(UbesDelightItemsImpl.GINGER)
                .add(UbesDelightItemsImpl.GINGER_CHOP);
        getOrCreateTagBuilder(CommonTags.C_VEGETABLES_LEMONGRASS)
                .add(UbesDelightItemsImpl.LEMONGRASS);
        getOrCreateTagBuilder(CommonTags.C_VEGETABLES_UBE)
                .add(UbesDelightItemsImpl.UBE);
    }
}
