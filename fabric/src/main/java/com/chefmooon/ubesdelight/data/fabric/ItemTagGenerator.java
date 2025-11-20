package com.chefmooon.ubesdelight.data.fabric;

import com.chefmooon.ubesdelight.common.registry.fabric.UbesDelightItemsImpl;
import com.chefmooon.ubesdelight.common.tag.CommonTags;
import com.chefmooon.ubesdelight.common.tag.CompatibilityTags;
import com.chefmooon.ubesdelight.common.tag.UbesDelightTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
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
        registerModItemTags();
        registerMinecraftItemTags();
        registerCompatibiltyItemTags();
        registerCommonItemTags();
        registerConventionalItemTags();
    }

    private void registerModItemTags() {
        valueLookupBuilder(UbesDelightTags.TOOLS_ROLLING_PIN)
                .add(UbesDelightItemsImpl.ROLLING_PIN_WOOD.get())
                .add(UbesDelightItemsImpl.ROLLING_PIN_IRON.get())
                .add(UbesDelightItemsImpl.ROLLING_PIN_GOLD.get())
                .add(UbesDelightItemsImpl.ROLLING_PIN_DIAMOND.get())
                .add(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get())
        ;
    }

    private void registerMinecraftItemTags() {
        // Minecraft Item Tags
        valueLookupBuilder(ItemTags.SMALL_FLOWERS)
                .add(UbesDelightItemsImpl.WILD_UBE.get())
                .add(UbesDelightItemsImpl.WILD_GARLIC.get())
                .add(UbesDelightItemsImpl.WILD_GINGER.get());

        valueLookupBuilder(ConventionalItemTags.TALL_FLOWERS)
                .add(UbesDelightItemsImpl.WILD_LEMONGRASS.get());

        valueLookupBuilder(ItemTags.PARROT_FOOD)
                .add(UbesDelightItemsImpl.LEMONGRASS_SEEDS.get());

        valueLookupBuilder(ItemTags.CHICKEN_FOOD)
                .add(UbesDelightItemsImpl.LEMONGRASS_SEEDS.get());

        valueLookupBuilder(ItemTags.PIG_FOOD)
                .add(UbesDelightItemsImpl.UBE.get())
                .add(UbesDelightItemsImpl.GARLIC.get())
                .add(UbesDelightItemsImpl.GINGER.get())
                .add(UbesDelightItemsImpl.LEMONGRASS.get());

        valueLookupBuilder(ItemTags.RABBIT_FOOD)
                .add(UbesDelightItemsImpl.GINGER.get())
                .add(UbesDelightItemsImpl.LEMONGRASS.get());

        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        valueLookupBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        valueLookupBuilder(ItemTags.BREAKS_DECORATED_POTS).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
    }
    private void registerCompatibiltyItemTags() {
        // Create Item Tags
        valueLookupBuilder(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
                .add(UbesDelightItemsImpl.MILK_TEA_UBE.get())
                .add(UbesDelightItemsImpl.HALO_HALO.get())
                .add(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE.get())
                .add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItemsImpl.UBE_CAKE.get())
                .add(UbesDelightItemsImpl.LECHE_FLAN_FEAST.get())
                .add(UbesDelightItemsImpl.HALO_HALO_FEAST.get())
                .add(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST.get())
                .add(UbesDelightItemsImpl.BULALO.get())
                .add(UbesDelightItemsImpl.ARROZ_CALDO.get())
                .add(UbesDelightItemsImpl.MECHADO.get());

        // Farmers Delight Item Tags
        valueLookupBuilder(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS)
                .add(UbesDelightItemsImpl.UBE.get());

        valueLookupBuilder(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS_ITEM)
                .add(UbesDelightItemsImpl.WILD_UBE.get())
                .add(UbesDelightItemsImpl.WILD_GARLIC.get())
                .add(UbesDelightItemsImpl.WILD_GINGER.get())
                .add(UbesDelightItemsImpl.WILD_LEMONGRASS.get());

        // Supplementaries Item Tags
        valueLookupBuilder(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(UbesDelightItemsImpl.COOKIE_UBE.get())
                .add(UbesDelightItemsImpl.COOKIE_GINGER.get())
                .add(UbesDelightItemsImpl.POLVORONE.get())
                .add(UbesDelightItemsImpl.POLVORONE_PINIPIG.get())
                .add(UbesDelightItemsImpl.POLVORONE_UBE.get())
                .add(UbesDelightItemsImpl.POLVORONE_CC.get());

        // Dehydration Item Tags
        valueLookupBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE.get())
                .add(UbesDelightItemsImpl.MILK_TEA_UBE.get())
                .add(UbesDelightItemsImpl.HALO_HALO.get());

        valueLookupBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(UbesDelightItemsImpl.BULALO.get())
                .add(UbesDelightItemsImpl.ARROZ_CALDO.get())
                .add(UbesDelightItemsImpl.MECHADO.get());

        // Origins Item Tags
        valueLookupBuilder(CompatibilityTags.ORIGINS_IGNORE_DIET)
                .add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE.get());

        valueLookupBuilder(CompatibilityTags.ORIGINS_MEAT)
                .add(UbesDelightItemsImpl.LUMPIA.get())
                .add(UbesDelightItemsImpl.TOCINO.get())
                .add(UbesDelightItemsImpl.CHICKEN_INASAL.get())
                .add(UbesDelightItemsImpl.CHICKEN_INASAL_RICE.get())
                .add(UbesDelightItemsImpl.TOSILOG.get())
                .add(UbesDelightItemsImpl.BANGSILOG.get())
                .add(UbesDelightItemsImpl.SISIG.get())
                .add(UbesDelightItemsImpl.BULALO.get())
                .add(UbesDelightItemsImpl.ARROZ_CALDO.get())
                .add(UbesDelightItemsImpl.MECHADO.get());

        // Serene Seasons
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS)
                .add(UbesDelightItemsImpl.GARLIC.get())
                .add(UbesDelightItemsImpl.GINGER.get());
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS)
                .add(UbesDelightItemsImpl.UBE.get())
                .add(UbesDelightItemsImpl.LEMONGRASS_SEEDS.get());
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS)
                .add(UbesDelightItemsImpl.UBE.get())
                .add(UbesDelightItemsImpl.GARLIC.get())
                .add(UbesDelightItemsImpl.GINGER.get())
                .add(UbesDelightItemsImpl.LEMONGRASS_SEEDS.get());
    }

    @SuppressWarnings("unchecked")
    private void registerCommonItemTags() {
        valueLookupBuilder(CommonTags.C_FOOD_WRAPPERS)
                .forceAddTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER);
        valueLookupBuilder(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)
                .add(UbesDelightItemsImpl.LUMPIA_WRAPPER.get());

        valueLookupBuilder(CommonTags.C_TOOLS_ROLLING_PIN)
                .add(UbesDelightItemsImpl.ROLLING_PIN_WOOD.get())
                .add(UbesDelightItemsImpl.ROLLING_PIN_IRON.get())
                .add(UbesDelightItemsImpl.ROLLING_PIN_GOLD.get())
                .add(UbesDelightItemsImpl.ROLLING_PIN_DIAMOND.get())
                .add(UbesDelightItemsImpl.ROLLING_PIN_NETHERITE.get());

        valueLookupBuilder(CommonTags.C_TEA_INGREDIENTS)
                .forceAddTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK);
        valueLookupBuilder(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .add(Items.SUGAR)
                .add(UbesDelightItemsImpl.SUGAR_BROWN.get());

        valueLookupBuilder(CommonTags.C_CROPS_GARLIC)
                .add(UbesDelightItemsImpl.GARLIC.get())
                .add(UbesDelightItemsImpl.GARLIC_CHOP.get());
        valueLookupBuilder(CommonTags.C_CROPS_GINGER)
                .add(UbesDelightItemsImpl.GINGER.get())
                .add(UbesDelightItemsImpl.GINGER_CHOP.get());
        valueLookupBuilder(CommonTags.C_CROPS_LEMONGRASS)
                .add(UbesDelightItemsImpl.LEMONGRASS.get());
        valueLookupBuilder(CommonTags.C_CROPS_UBE)
                .add(UbesDelightItemsImpl.UBE.get());

        valueLookupBuilder(CommonTags.C_FOODS_GARLIC)
                .add(UbesDelightItemsImpl.GARLIC.get())
                .add(UbesDelightItemsImpl.GARLIC_CHOP.get());
        valueLookupBuilder(CommonTags.C_FOODS_GINGER)
                .add(UbesDelightItemsImpl.GINGER.get())
                .add(UbesDelightItemsImpl.GINGER_CHOP.get());
        valueLookupBuilder(CommonTags.C_FOODS_LEMONGRASS)
                .add(UbesDelightItemsImpl.LEMONGRASS.get());
        valueLookupBuilder(CommonTags.C_FOODS_UBE)
                .add(UbesDelightItemsImpl.UBE.get());

        valueLookupBuilder(CommonTags.C_FOODS_LEAFY_GREEN)
                .forceAddTag(CommonTags.C_FOODS_LEMONGRASS);

        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE).add(UbesDelightItemsImpl.UBE_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC).add(UbesDelightItemsImpl.GARLIC_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER).add(UbesDelightItemsImpl.GINGER_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS).add(UbesDelightItemsImpl.LEMONGRASS_CRATE.get());

        // Create Dough Compat
        // todo - when create 1.21 releases check compatibility
//        valueLookupBuilder(CommonTags.C_FOODS_DOUGH)
//                .addOptionalTag(CommonTags.C_DOUGH);
    }

    @SuppressWarnings("unchecked")
    private void registerConventionalItemTags() {
        valueLookupBuilder(ConventionalItemTags.TOOLS).forceAddTag(CommonTags.C_TOOLS_ROLLING_PIN);

        valueLookupBuilder(ConventionalItemTags.VEGETABLE_FOODS)
                .add(UbesDelightItemsImpl.UBE.get())
                .add(UbesDelightItemsImpl.GARLIC.get())
                .add(UbesDelightItemsImpl.GINGER.get())
                .add(UbesDelightItemsImpl.LEMONGRASS.get());

        valueLookupBuilder(ConventionalItemTags.COOKIE_FOODS)
                .add(UbesDelightItemsImpl.COOKIE_UBE.get())
                .add(UbesDelightItemsImpl.COOKIE_GINGER.get())
                .add(UbesDelightItemsImpl.POLVORONE.get())
                .add(UbesDelightItemsImpl.POLVORONE_PINIPIG.get())
                .add(UbesDelightItemsImpl.POLVORONE_UBE.get())
                .add(UbesDelightItemsImpl.POLVORONE_CC.get());

        valueLookupBuilder(ConventionalItemTags.EDIBLE_WHEN_PLACED_FOODS)
                .add(UbesDelightItemsImpl.UBE_CAKE.get())
                .add(UbesDelightItemsImpl.LECHE_FLAN_FEAST.get())
                .add(UbesDelightItemsImpl.HALO_HALO_FEAST.get())
                .add(UbesDelightItemsImpl.MILK_TEA_UBE_FEAST.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_HALF.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_ENSAYMADA_UBE_HALF.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_HALF.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_PANDESAL_UBE_HALF.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_MUNGGO_HALF.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_HOPIA_UBE_HALF.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_COOKED_RICE_HALF.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_FRIED_RICE_HALF.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_SINANGAG.get())
                .add(UbesDelightItemsImpl.LEAF_FEAST_SINANGAG_HALF.get())
        ;

        valueLookupBuilder(ConventionalItemTags.FOODS)
                .add(UbesDelightItemsImpl.POISONOUS_UBE.get())
                .add(UbesDelightItemsImpl.UBE.get())
                .add(UbesDelightItemsImpl.GARLIC.get())
                .add(UbesDelightItemsImpl.GARLIC_CHOP.get())
                .add(UbesDelightItemsImpl.GINGER.get())
                .add(UbesDelightItemsImpl.GINGER_CHOP.get())
                .add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItemsImpl.FISH_SAUCE_BOTTLE.get())
                .add(UbesDelightItemsImpl.MILK_TEA_UBE.get())
                .add(UbesDelightItemsImpl.HALO_HALO.get())
                .add(UbesDelightItemsImpl.SINANGAG.get())
                .add(UbesDelightItemsImpl.KINILAW.get())
                .add(UbesDelightItemsImpl.LUMPIA.get())
                .add(UbesDelightItemsImpl.TOCINO.get())
                .add(UbesDelightItemsImpl.CHICKEN_INASAL.get())
                .add(UbesDelightItemsImpl.CHICKEN_INASAL_RICE.get())
                .add(UbesDelightItemsImpl.TOSILOG.get())
                .add(UbesDelightItemsImpl.BANGSILOG.get())
                .add(UbesDelightItemsImpl.SISIG.get())
                .add(UbesDelightItemsImpl.BULALO.get())
                .add(UbesDelightItemsImpl.ARROZ_CALDO.get())
                .add(UbesDelightItemsImpl.MECHADO.get())
                .add(UbesDelightItemsImpl.COOKIE_UBE.get())
                .add(UbesDelightItemsImpl.COOKIE_GINGER.get())
                .add(UbesDelightItemsImpl.LECHE_FLAN.get())
                .add(UbesDelightItemsImpl.UBE_CAKE_SLICE.get())
                .add(UbesDelightItemsImpl.POLVORONE.get())
                .add(UbesDelightItemsImpl.POLVORONE_PINIPIG.get())
                .add(UbesDelightItemsImpl.POLVORONE_UBE.get())
                .add(UbesDelightItemsImpl.POLVORONE_CC.get())
                .add(UbesDelightItemsImpl.PANDESAL.get())
                .add(UbesDelightItemsImpl.PANDESAL_UBE.get())
                .add(UbesDelightItemsImpl.ENSAYMADA.get())
                .add(UbesDelightItemsImpl.ENSAYMADA_UBE.get())
                .add(UbesDelightItemsImpl.HOPIA_MUNGGO.get())
                .add(UbesDelightItemsImpl.HOPIA_UBE.get())
        ;

        valueLookupBuilder(ConventionalItemTags.SEEDS)
                .add(UbesDelightItemsImpl.LEMONGRASS_SEEDS.get());

        valueLookupBuilder(ConventionalItemTags.SOUP_FOODS)
                .add(UbesDelightItemsImpl.BULALO.get())
                .add(UbesDelightItemsImpl.ARROZ_CALDO.get())
                .add(UbesDelightItemsImpl.MECHADO.get());

        valueLookupBuilder(ConventionalItemTags.CROPS)
                .forceAddTag(CommonTags.C_CROPS_UBE)
                .forceAddTag(CommonTags.C_CROPS_UBE)
                .forceAddTag(CommonTags.C_CROPS_GARLIC)
                .forceAddTag(CommonTags.C_CROPS_GINGER)
                .forceAddTag(CommonTags.C_CROPS_LEMONGRASS);

        valueLookupBuilder(ConventionalItemTags.MILK_DRINKS)
                .add(UbesDelightItemsImpl.CONDENSED_MILK_BOTTLE.get());

        valueLookupBuilder(ConventionalItemTags.STORAGE_BLOCKS)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS);
    }
}
