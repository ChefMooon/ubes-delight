package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import com.chefmoon.ubesdelight.tag.CommonTags;
import com.chefmoon.ubesdelight.tag.CompatibilityTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {

    public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        this.registerMinecraftItemTags();
        this.registerCompatibiltyItemTags();
        this.registerCommonItemTags();
    }

    private void registerMinecraftItemTags() {
        // Minecraft Item Tags
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(ItemsRegistry.WILD_UBE.get())
                .add(ItemsRegistry.WILD_GARLIC.get())
                .add(ItemsRegistry.WILD_GINGER.get());

        getOrCreateTagBuilder(ItemTags.TALL_FLOWERS)
                .add(ItemsRegistry.WILD_LEMONGRASS.get());
    }
    private void registerCompatibiltyItemTags() {
        // Create Item Tags
        getOrCreateTagBuilder(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
                .add(ItemsRegistry.MILK_TEA_UBE.get())
                .add(ItemsRegistry.HALO_HALO.get())
                .add(ItemsRegistry.FISH_SAUCE_BOTTLE.get())
                .add(ItemsRegistry.CONDENSED_MILK_BOTTLE.get())
                .add(ItemsRegistry.UBE_CAKE.get())
                .add(ItemsRegistry.LECHE_FLAN_FEAST.get())
                .add(ItemsRegistry.HALO_HALO_FEAST.get())
                .add(ItemsRegistry.MILK_TEA_UBE_FEAST.get())
                .add(ItemsRegistry.BULALO.get())
                .add(ItemsRegistry.ARROZ_CALDO.get())
                .add(ItemsRegistry.MECHADO.get());

        // Farmers Delight Item Tags
        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS)
                .add(ItemsRegistry.UBE.get());

        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS_ITEM)
                .add(ItemsRegistry.WILD_UBE.get())
                .add(ItemsRegistry.WILD_GARLIC.get())
                .add(ItemsRegistry.WILD_GINGER.get())
                .add(ItemsRegistry.WILD_LEMONGRASS.get());

        // Supplementaries Item Tags
        getOrCreateTagBuilder(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(ItemsRegistry.COOKIE_UBE.get())
                .add(ItemsRegistry.COOKIE_GINGER.get())
                .add(ItemsRegistry.POLVORONE.get())
                .add(ItemsRegistry.POLVORONE_PINIPIG.get())
                .add(ItemsRegistry.POLVORONE_UBE.get())
                .add(ItemsRegistry.POLVORONE_CC.get());

        // Dehydration Item Tags
        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(ItemsRegistry.CONDENSED_MILK_BOTTLE.get())
                .add(ItemsRegistry.FISH_SAUCE_BOTTLE.get())
                .add(ItemsRegistry.MILK_TEA_UBE.get())
                .add(ItemsRegistry.HALO_HALO.get());

        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(ItemsRegistry.BULALO.get())
                .add(ItemsRegistry.ARROZ_CALDO.get())
                .add(ItemsRegistry.MECHADO.get());

        // Origins Item Tags
        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_IGNORE_DIET)
                .add(ItemsRegistry.CONDENSED_MILK_BOTTLE.get())
                .add(ItemsRegistry.FISH_SAUCE_BOTTLE.get());

        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_MEAT)
                .add(ItemsRegistry.LUMPIA.get())
                .add(ItemsRegistry.TOCINO.get())
                .add(ItemsRegistry.CHICKEN_INASAL.get())
                .add(ItemsRegistry.CHICKEN_INASAL_RICE.get())
                .add(ItemsRegistry.TOSILOG.get())
                .add(ItemsRegistry.BANGSILOG.get())
                .add(ItemsRegistry.SISIG.get())
                .add(ItemsRegistry.BULALO.get())
                .add(ItemsRegistry.ARROZ_CALDO.get())
                .add(ItemsRegistry.MECHADO.get());
    }

    private void registerCommonItemTags() {
        getOrCreateTagBuilder(CommonTags.C_CROPS)
                .forceAddTag(CommonTags.C_CROPS_UBE)
                .forceAddTag(CommonTags.C_CROPS_GARLIC)
                .forceAddTag(CommonTags.C_CROPS_GINGER)
                .forceAddTag(CommonTags.C_CROPS_LEMONGRASS);
        getOrCreateTagBuilder(CommonTags.C_CROPS_GARLIC)
                .add(ItemsRegistry.GARLIC.get())
                .add(ItemsRegistry.GARLIC_CHOP.get());
        getOrCreateTagBuilder(CommonTags.C_CROPS_GINGER)
                .add(ItemsRegistry.GINGER.get())
                .add(ItemsRegistry.GINGER_CHOP.get());
        getOrCreateTagBuilder(CommonTags.C_CROPS_LEMONGRASS)
                .add(ItemsRegistry.LEMONGRASS.get());
        getOrCreateTagBuilder(CommonTags.C_CROPS_UBE)
                .add(ItemsRegistry.UBE.get());

        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES)
                .forceAddTag(CommonTags.C_FOODS_VEGETABLES_GARLIC)
                .forceAddTag(CommonTags.C_FOODS_VEGETABLES_GINGER)
                .forceAddTag(CommonTags.C_FOODS_VEGETABLES_LEMONGRASS)
                .forceAddTag(CommonTags.C_FOODS_VEGETABLES_UBE);
        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES_GARLIC)
                .add(ItemsRegistry.GARLIC.get())
                .add(ItemsRegistry.GARLIC_CHOP.get());
        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES_GINGER)
                .add(ItemsRegistry.GINGER.get())
                .add(ItemsRegistry.GINGER_CHOP.get());
        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES_LEMONGRASS)
                .add(ItemsRegistry.LEMONGRASS.get());
        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES_UBE)
                .add(ItemsRegistry.UBE.get());

        getOrCreateTagBuilder(CommonTags.C_FOOD_WRAPPERS)
                .forceAddTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER);
        getOrCreateTagBuilder(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)
                .add(ItemsRegistry.LUMPIA_WRAPPER.get());

        getOrCreateTagBuilder(CommonTags.C_FOODS)
                .add(ItemsRegistry.POISONOUS_UBE.get())
                .add(ItemsRegistry.UBE.get())
                .add(ItemsRegistry.GARLIC.get())
                .add(ItemsRegistry.GARLIC_CHOP.get())
                .add(ItemsRegistry.GINGER.get())
                .add(ItemsRegistry.GINGER_CHOP.get())
                .add(ItemsRegistry.CONDENSED_MILK_BOTTLE.get())
                .add(ItemsRegistry.FISH_SAUCE_BOTTLE.get())
                .add(ItemsRegistry.MILK_TEA_UBE.get())
                .add(ItemsRegistry.HALO_HALO.get())
                .add(ItemsRegistry.SINANGAG.get())
                .add(ItemsRegistry.KINILAW.get())
                .add(ItemsRegistry.LUMPIA.get())
                .add(ItemsRegistry.TOCINO.get())
                .add(ItemsRegistry.CHICKEN_INASAL.get())
                .add(ItemsRegistry.CHICKEN_INASAL_RICE.get())
                .add(ItemsRegistry.TOSILOG.get())
                .add(ItemsRegistry.BANGSILOG.get())
                .add(ItemsRegistry.SISIG.get())
                .add(ItemsRegistry.BULALO.get())
                .add(ItemsRegistry.ARROZ_CALDO.get())
                .add(ItemsRegistry.MECHADO.get())
                .add(ItemsRegistry.COOKIE_UBE.get())
                .add(ItemsRegistry.COOKIE_GINGER.get())
                .add(ItemsRegistry.LECHE_FLAN.get())
                .add(ItemsRegistry.UBE_CAKE_SLICE.get())
                .add(ItemsRegistry.POLVORONE.get())
                .add(ItemsRegistry.POLVORONE_PINIPIG.get())
                .add(ItemsRegistry.POLVORONE_UBE.get())
                .add(ItemsRegistry.POLVORONE_CC.get())
                .add(ItemsRegistry.PANDESAL.get())
                .add(ItemsRegistry.PANDESAL_UBE.get())
                .add(ItemsRegistry.ENSAYMADA.get())
                .add(ItemsRegistry.ENSAYMADA_UBE.get())
                .add(ItemsRegistry.HOPIA_MUNGGO.get())
                .add(ItemsRegistry.HOPIA_UBE.get())
        ;

        getOrCreateTagBuilder(CommonTags.C_MILKS)
                .forceAddTag(CommonTags.C_MILKS_MILK_BOTTLES);
        getOrCreateTagBuilder(CommonTags.C_MILKS_MILK_BOTTLES)
                .add(ItemsRegistry.CONDENSED_MILK_BOTTLE.get());

        getOrCreateTagBuilder(CommonTags.C_SALAD_INGREDIENTS)
                .forceAddTag(CommonTags.C_SALAD_INGREDIENTS_LEMONGRASS);
        getOrCreateTagBuilder(CommonTags.C_SALAD_INGREDIENTS_LEMONGRASS)
                .add(ItemsRegistry.LEMONGRASS.get());

        getOrCreateTagBuilder(CommonTags.C_SEEDS)
                .forceAddTag(CommonTags.C_SEEDS_LEMONGRASS);
        getOrCreateTagBuilder(CommonTags.C_SEEDS_LEMONGRASS)
                .add(ItemsRegistry.LEMONGRASS_SEEDS.get());

        getOrCreateTagBuilder(CommonTags.C_TEA_INGREDIENTS)
                .forceAddTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK);
        getOrCreateTagBuilder(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .add(Items.SUGAR)
                .add(ItemsRegistry.SUGAR_BROWN.get());

        getOrCreateTagBuilder(CommonTags.C_TOOLS_ROLLING_PINS)
                .add(ItemsRegistry.ROLLING_PIN_WOOD.get());

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
                .add(ItemsRegistry.CONDENSED_MILK_BOTTLE.get());

        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLES)
                .addOptionalTag(CommonTags.C_VEGETABLES);
        getOrCreateTagBuilder(CommonTags.C_VEGETABLES)
                .addOptionalTag(CommonTags.C_VEGETABLES_GARLIC)
                .addOptionalTag(CommonTags.C_VEGETABLES_GINGER)
                .addOptionalTag(CommonTags.C_VEGETABLES_LEMONGRASS)
                .addOptionalTag(CommonTags.C_VEGETABLES_UBE);
        getOrCreateTagBuilder(CommonTags.C_VEGETABLES_GARLIC)
                .add(ItemsRegistry.GARLIC.get())
                .add(ItemsRegistry.GARLIC_CHOP.get());
        getOrCreateTagBuilder(CommonTags.C_VEGETABLES_GINGER)
                .add(ItemsRegistry.GINGER.get())
                .add(ItemsRegistry.GINGER_CHOP.get());
        getOrCreateTagBuilder(CommonTags.C_VEGETABLES_LEMONGRASS)
                .add(ItemsRegistry.LEMONGRASS.get());
        getOrCreateTagBuilder(CommonTags.C_VEGETABLES_UBE)
                .add(ItemsRegistry.UBE.get());
    }
}
