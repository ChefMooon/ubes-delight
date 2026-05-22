package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import chefmooon.ubesdelight.common.tag.UbesDelightTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ItemTagGenerator extends FabricTagsProvider.ItemTagsProvider {
    public ItemTagGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
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
                .add(UbesDelightItems.ROLLING_PIN_WOOD.get())
                .add(UbesDelightItems.ROLLING_PIN_IRON.get())
                .add(UbesDelightItems.ROLLING_PIN_GOLD.get())
                .add(UbesDelightItems.ROLLING_PIN_DIAMOND.get())
                .add(UbesDelightItems.ROLLING_PIN_NETHERITE.get())
        ;
    }

    private void registerMinecraftItemTags() {
        // Minecraft Item Tags
        valueLookupBuilder(ItemTags.SMALL_FLOWERS)
                .add(UbesDelightItems.WILD_UBE.get())
                .add(UbesDelightItems.WILD_GARLIC.get())
                .add(UbesDelightItems.WILD_GINGER.get());

        valueLookupBuilder(ConventionalItemTags.TALL_FLOWERS)
                .add(UbesDelightItems.WILD_LEMONGRASS.get());

        valueLookupBuilder(ItemTags.PARROT_FOOD)
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());

        valueLookupBuilder(ItemTags.CHICKEN_FOOD)
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());

        valueLookupBuilder(ItemTags.PIG_FOOD)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS.get());

        valueLookupBuilder(ItemTags.RABBIT_FOOD)
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS.get());

        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        valueLookupBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        valueLookupBuilder(ItemTags.BREAKS_DECORATED_POTS).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);

        valueLookupBuilder(ItemTags.VILLAGER_PICKS_UP)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS.get())
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());

        valueLookupBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());
    }
    private void registerCompatibiltyItemTags() {
        // Create Item Tags
        valueLookupBuilder(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
                .add(UbesDelightItems.MILK_TEA_UBE.get())
                .add(UbesDelightItems.HALO_HALO.get())
                .add(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .add(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItems.UBE_CAKE.get())
                .add(UbesDelightItems.LECHE_FLAN_FEAST.get())
                .add(UbesDelightItems.HALO_HALO_FEAST.get())
                .add(UbesDelightItems.MILK_TEA_UBE_FEAST.get())
                .add(UbesDelightItems.SINANGAG.get())
                .add(UbesDelightItems.KINILAW.get())
                .add(UbesDelightItems.CHICKEN_INASAL_RICE.get())
                .add(UbesDelightItems.TOSILOG.get())
                .add(UbesDelightItems.BANGSILOG.get())
                .add(UbesDelightItems.SISIG.get())
                .add(UbesDelightItems.BULALO.get())
                .add(UbesDelightItems.ARROZ_CALDO.get())
                .add(UbesDelightItems.MECHADO.get());

        // Farmers Delight Item Tags
        valueLookupBuilder(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS_ITEM)
                .add(UbesDelightItems.WILD_UBE.get())
                .add(UbesDelightItems.WILD_GARLIC.get())
                .add(UbesDelightItems.WILD_GINGER.get())
                .add(UbesDelightItems.WILD_LEMONGRASS.get());

        // Supplementaries Item Tags
        valueLookupBuilder(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(UbesDelightItems.COOKIE_UBE.get())
                .add(UbesDelightItems.COOKIE_GINGER.get())
                .add(UbesDelightItems.POLVORONE.get())
                .add(UbesDelightItems.POLVORONE_PINIPIG.get())
                .add(UbesDelightItems.POLVORONE_UBE.get())
                .add(UbesDelightItems.POLVORONE_CC.get());

        // Dehydration Item Tags
        valueLookupBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .add(UbesDelightItems.MILK_TEA_UBE.get())
                .add(UbesDelightItems.HALO_HALO.get());

        valueLookupBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(UbesDelightItems.BULALO.get())
                .add(UbesDelightItems.ARROZ_CALDO.get())
                .add(UbesDelightItems.MECHADO.get());

        // Origins Item Tags
        valueLookupBuilder(CompatibilityTags.ORIGINS_IGNORE_DIET)
                .add(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItems.FISH_SAUCE_BOTTLE.get());

        valueLookupBuilder(CompatibilityTags.ORIGINS_MEAT)
                .add(UbesDelightItems.LUMPIA.get())
                .add(UbesDelightItems.TOCINO.get())
                .add(UbesDelightItems.CHICKEN_INASAL.get())
                .add(UbesDelightItems.CHICKEN_INASAL_RICE.get())
                .add(UbesDelightItems.TOSILOG.get())
                .add(UbesDelightItems.BANGSILOG.get())
                .add(UbesDelightItems.SISIG.get())
                .add(UbesDelightItems.BULALO.get())
                .add(UbesDelightItems.ARROZ_CALDO.get())
                .add(UbesDelightItems.MECHADO.get());

        // Serene Seasons
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS)
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get());
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());
        valueLookupBuilder(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());
    }

    @SuppressWarnings("unchecked")
    private void registerCommonItemTags() {
        valueLookupBuilder(CommonTags.C_FOOD_WRAPPERS)
                .forceAddTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER);
        valueLookupBuilder(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)
                .add(UbesDelightItems.LUMPIA_WRAPPER.get());

        valueLookupBuilder(CommonTags.C_TOOLS_ROLLING_PIN)
                .add(UbesDelightItems.ROLLING_PIN_WOOD.get())
                .add(UbesDelightItems.ROLLING_PIN_IRON.get())
                .add(UbesDelightItems.ROLLING_PIN_GOLD.get())
                .add(UbesDelightItems.ROLLING_PIN_DIAMOND.get())
                .add(UbesDelightItems.ROLLING_PIN_NETHERITE.get());

        valueLookupBuilder(CommonTags.C_TEA_INGREDIENTS)
                .forceAddTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK);
        valueLookupBuilder(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .add(Items.SUGAR)
                .add(UbesDelightItems.SUGAR_BROWN.get());

        valueLookupBuilder(CommonTags.C_CROPS_GARLIC)
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GARLIC_CHOP.get());
        valueLookupBuilder(CommonTags.C_CROPS_GINGER)
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.GINGER_CHOP.get());
        valueLookupBuilder(CommonTags.C_CROPS_LEMONGRASS)
                .add(UbesDelightItems.LEMONGRASS.get());
        valueLookupBuilder(CommonTags.C_CROPS_UBE)
                .add(UbesDelightItems.UBE.get());

        valueLookupBuilder(CommonTags.C_FOODS_GARLIC)
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GARLIC_CHOP.get());
        valueLookupBuilder(CommonTags.C_FOODS_GINGER)
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.GINGER_CHOP.get());
        valueLookupBuilder(CommonTags.C_FOODS_LEMONGRASS)
                .add(UbesDelightItems.LEMONGRASS.get());
        valueLookupBuilder(CommonTags.C_FOODS_UBE)
                .add(UbesDelightItems.UBE.get());

        valueLookupBuilder(CommonTags.C_FOODS_LEAFY_GREEN)
                .forceAddTag(CommonTags.C_FOODS_LEMONGRASS);

        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE).add(UbesDelightItems.UBE_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC).add(UbesDelightItems.GARLIC_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER).add(UbesDelightItems.GINGER_CRATE.get());
        valueLookupBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS).add(UbesDelightItems.LEMONGRASS_CRATE.get());

        // Create Dough Compat
        // todo - when create 1.21 releases check compatibility
//        valueLookupBuilder(CommonTags.C_FOODS_DOUGH)
//                .addOptionalTag(CommonTags.C_DOUGH);
    }

    @SuppressWarnings("unchecked")
    private void registerConventionalItemTags() {
        valueLookupBuilder(ConventionalItemTags.TOOLS).forceAddTag(CommonTags.C_TOOLS_ROLLING_PIN);

        valueLookupBuilder(ConventionalItemTags.VEGETABLE_FOODS)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS.get());

        valueLookupBuilder(ConventionalItemTags.COOKIE_FOODS)
                .add(UbesDelightItems.COOKIE_UBE.get())
                .add(UbesDelightItems.COOKIE_GINGER.get())
                .add(UbesDelightItems.POLVORONE.get())
                .add(UbesDelightItems.POLVORONE_PINIPIG.get())
                .add(UbesDelightItems.POLVORONE_UBE.get())
                .add(UbesDelightItems.POLVORONE_CC.get());

        valueLookupBuilder(ConventionalItemTags.EDIBLE_WHEN_PLACED_FOODS)
                .add(UbesDelightItems.UBE_CAKE.get())
                .add(UbesDelightItems.LECHE_FLAN_FEAST.get())
                .add(UbesDelightItems.HALO_HALO_FEAST.get())
                .add(UbesDelightItems.MILK_TEA_UBE_FEAST.get())
                .add(UbesDelightItems.LEAF_FEAST_ENSAYMADA.get())
                .add(UbesDelightItems.LEAF_FEAST_ENSAYMADA_HALF.get())
                .add(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE.get())
                .add(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE_HALF.get())
                .add(UbesDelightItems.LEAF_FEAST_PANDESAL.get())
                .add(UbesDelightItems.LEAF_FEAST_PANDESAL_HALF.get())
                .add(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE.get())
                .add(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE_HALF.get())
                .add(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO.get())
                .add(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO_HALF.get())
                .add(UbesDelightItems.LEAF_FEAST_HOPIA_UBE.get())
                .add(UbesDelightItems.LEAF_FEAST_HOPIA_UBE_HALF.get())
                .add(UbesDelightItems.LEAF_FEAST_COOKED_RICE.get())
                .add(UbesDelightItems.LEAF_FEAST_COOKED_RICE_HALF.get())
                .add(UbesDelightItems.LEAF_FEAST_FRIED_RICE.get())
                .add(UbesDelightItems.LEAF_FEAST_FRIED_RICE_HALF.get())
                .add(UbesDelightItems.LEAF_FEAST_SINANGAG.get())
                .add(UbesDelightItems.LEAF_FEAST_SINANGAG_HALF.get())
        ;

        valueLookupBuilder(ConventionalItemTags.FOODS)
                .add(UbesDelightItems.POISONOUS_UBE.get())
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GARLIC_CHOP.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.GINGER_CHOP.get())
                .add(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .add(UbesDelightItems.MILK_TEA_UBE.get())
                .add(UbesDelightItems.HALO_HALO.get())
                .add(UbesDelightItems.SINANGAG.get())
                .add(UbesDelightItems.KINILAW.get())
                .add(UbesDelightItems.LUMPIA.get())
                .add(UbesDelightItems.TOCINO.get())
                .add(UbesDelightItems.CHICKEN_INASAL.get())
                .add(UbesDelightItems.CHICKEN_INASAL_RICE.get())
                .add(UbesDelightItems.TOSILOG.get())
                .add(UbesDelightItems.BANGSILOG.get())
                .add(UbesDelightItems.SISIG.get())
                .add(UbesDelightItems.BULALO.get())
                .add(UbesDelightItems.ARROZ_CALDO.get())
                .add(UbesDelightItems.MECHADO.get())
                .add(UbesDelightItems.COOKIE_UBE.get())
                .add(UbesDelightItems.COOKIE_GINGER.get())
                .add(UbesDelightItems.LECHE_FLAN.get())
                .add(UbesDelightItems.UBE_CAKE_SLICE.get())
                .add(UbesDelightItems.POLVORONE.get())
                .add(UbesDelightItems.POLVORONE_PINIPIG.get())
                .add(UbesDelightItems.POLVORONE_UBE.get())
                .add(UbesDelightItems.POLVORONE_CC.get())
                .add(UbesDelightItems.PANDESAL.get())
                .add(UbesDelightItems.PANDESAL_UBE.get())
                .add(UbesDelightItems.ENSAYMADA.get())
                .add(UbesDelightItems.ENSAYMADA_UBE.get())
                .add(UbesDelightItems.HOPIA_MUNGGO.get())
                .add(UbesDelightItems.HOPIA_UBE.get())
        ;

        valueLookupBuilder(ConventionalItemTags.SEEDS)
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());

        valueLookupBuilder(ConventionalItemTags.SOUP_FOODS)
                .add(UbesDelightItems.BULALO.get())
                .add(UbesDelightItems.ARROZ_CALDO.get())
                .add(UbesDelightItems.MECHADO.get());

        valueLookupBuilder(ConventionalItemTags.CROPS)
                .forceAddTag(CommonTags.C_CROPS_UBE)
                .forceAddTag(CommonTags.C_CROPS_UBE)
                .forceAddTag(CommonTags.C_CROPS_GARLIC)
                .forceAddTag(CommonTags.C_CROPS_GINGER)
                .forceAddTag(CommonTags.C_CROPS_LEMONGRASS);

        valueLookupBuilder(ConventionalItemTags.MILK_DRINKS)
                .add(UbesDelightItems.CONDENSED_MILK_BOTTLE.get());

        valueLookupBuilder(ConventionalItemTags.STORAGE_BLOCKS)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS);

        valueLookupBuilder(ConventionalItemTags.FOOD_POISONING_FOODS)
                .add(UbesDelightItems.PANDESAL_RAW.get())
                .add(UbesDelightItems.PANDESAL_UBE_RAW.get())
                .add(UbesDelightItems.ENSAYMADA_RAW.get())
                .add(UbesDelightItems.ENSAYMADA_UBE_RAW.get())
                .add(UbesDelightItems.HOPIA_MUNGGO_RAW.get())
                .add(UbesDelightItems.HOPIA_UBE_RAW.get())
        ;
    }
}
