package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import chefmooon.ubesdelight.common.tag.UbesDelightTags;
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
    }

    private void registerModItemTags() {
        getOrCreateTagBuilder(UbesDelightTags.TOOLS_ROLLING_PIN)
                .add(UbesDelightItems.ROLLING_PIN_WOOD.get())
                .add(UbesDelightItems.ROLLING_PIN_IRON.get())
                .add(UbesDelightItems.ROLLING_PIN_GOLD.get())
                .add(UbesDelightItems.ROLLING_PIN_DIAMOND.get())
                .add(UbesDelightItems.ROLLING_PIN_NETHERITE.get())
        ;
    }

    private void registerMinecraftItemTags() {
        // Minecraft Item Tags
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(UbesDelightItems.WILD_UBE.get())
                .add(UbesDelightItems.WILD_GARLIC.get())
                .add(UbesDelightItems.WILD_GINGER.get());

        getOrCreateTagBuilder(ItemTags.TALL_FLOWERS)
                .add(UbesDelightItems.WILD_LEMONGRASS.get());

        getOrCreateTagBuilder(ItemTags.PARROT_FOOD)
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());

        getOrCreateTagBuilder(ItemTags.CHICKEN_FOOD)
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());

        getOrCreateTagBuilder(ItemTags.PIG_FOOD)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS.get());

        getOrCreateTagBuilder(ItemTags.RABBIT_FOOD)
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS.get());

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        getOrCreateTagBuilder(ItemTags.BREAKS_DECORATED_POTS).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);

        getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());
    }
    private void registerCompatibiltyItemTags() {
        // Create Item Tags
        getOrCreateTagBuilder(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
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
        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS)
                .add(UbesDelightItems.UBE.get());

        getOrCreateTagBuilder(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS_ITEM)
                .add(UbesDelightItems.WILD_UBE.get())
                .add(UbesDelightItems.WILD_GARLIC.get())
                .add(UbesDelightItems.WILD_GINGER.get())
                .add(UbesDelightItems.WILD_LEMONGRASS.get());

        // Supplementaries Item Tags
        getOrCreateTagBuilder(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(UbesDelightItems.COOKIE_UBE.get())
                .add(UbesDelightItems.COOKIE_GINGER.get())
                .add(UbesDelightItems.POLVORONE.get())
                .add(UbesDelightItems.POLVORONE_PINIPIG.get())
                .add(UbesDelightItems.POLVORONE_UBE.get())
                .add(UbesDelightItems.POLVORONE_CC.get());

        // Dehydration Item Tags
        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .add(UbesDelightItems.MILK_TEA_UBE.get())
                .add(UbesDelightItems.HALO_HALO.get());

        getOrCreateTagBuilder(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(UbesDelightItems.BULALO.get())
                .add(UbesDelightItems.ARROZ_CALDO.get())
                .add(UbesDelightItems.MECHADO.get());

        // Origins Item Tags
        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_IGNORE_DIET)
                .add(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItems.FISH_SAUCE_BOTTLE.get());

        getOrCreateTagBuilder(CompatibilityTags.ORIGINS_MEAT)
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
        getOrCreateTagBuilder(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS)
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get());
        getOrCreateTagBuilder(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());
        getOrCreateTagBuilder(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());
    }

    private void registerCommonItemTags() {
        getOrCreateTagBuilder(CommonTags.C_FOOD_WRAPPERS)
                .forceAddTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER);
        getOrCreateTagBuilder(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)
                .add(UbesDelightItems.LUMPIA_WRAPPER.get());

        getOrCreateTagBuilder(CommonTags.C_TOOLS)
                .forceAddTag(CommonTags.C_TOOLS_ROLLING_PIN);
        getOrCreateTagBuilder(CommonTags.C_TOOLS_ROLLING_PIN)
                .add(UbesDelightItems.ROLLING_PIN_WOOD.get())
                .add(UbesDelightItems.ROLLING_PIN_IRON.get())
                .add(UbesDelightItems.ROLLING_PIN_GOLD.get())
                .add(UbesDelightItems.ROLLING_PIN_DIAMOND.get())
                .add(UbesDelightItems.ROLLING_PIN_NETHERITE.get());

        getOrCreateTagBuilder(CommonTags.C_TEA_INGREDIENTS)
                .forceAddTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK);
        getOrCreateTagBuilder(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .add(Items.SUGAR)
                .add(UbesDelightItems.SUGAR_BROWN.get());

        getOrCreateTagBuilder(CommonTags.C_CROPS)
                .forceAddTag(CommonTags.C_CROPS_UBE)
                .forceAddTag(CommonTags.C_CROPS_GARLIC)
                .forceAddTag(CommonTags.C_CROPS_GINGER)
                .forceAddTag(CommonTags.C_CROPS_LEMONGRASS);
        getOrCreateTagBuilder(CommonTags.C_CROPS_GARLIC)
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GARLIC_CHOP.get());
        getOrCreateTagBuilder(CommonTags.C_CROPS_GINGER)
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.GINGER_CHOP.get());
        getOrCreateTagBuilder(CommonTags.C_CROPS_LEMONGRASS)
                .add(UbesDelightItems.LEMONGRASS.get());
        getOrCreateTagBuilder(CommonTags.C_CROPS_UBE)
                .add(UbesDelightItems.UBE.get());

        getOrCreateTagBuilder(CommonTags.C_FOODS_VEGETABLE)
                .forceAddTag(CommonTags.C_FOODS_GARLIC)
                .forceAddTag(CommonTags.C_FOODS_GINGER)
                .forceAddTag(CommonTags.C_FOODS_LEMONGRASS)
                .forceAddTag(CommonTags.C_FOODS_UBE);
        getOrCreateTagBuilder(CommonTags.C_FOODS_GARLIC)
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GARLIC_CHOP.get());
        getOrCreateTagBuilder(CommonTags.C_FOODS_GINGER)
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.GINGER_CHOP.get());
        getOrCreateTagBuilder(CommonTags.C_FOODS_LEMONGRASS)
                .add(UbesDelightItems.LEMONGRASS.get());
        getOrCreateTagBuilder(CommonTags.C_FOODS_UBE)
                .add(UbesDelightItems.UBE.get());

        getOrCreateTagBuilder(CommonTags.C_FOODS)
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

        getOrCreateTagBuilder(ConventionalItemTags.MILK_DRINKS)
                .add(UbesDelightItems.CONDENSED_MILK_BOTTLE.get());

        getOrCreateTagBuilder(CommonTags.C_FOODS_LEAFY_GREEN)
                .forceAddTag(CommonTags.C_FOODS_LEMONGRASS);

        getOrCreateTagBuilder(CommonTags.C_SEEDS)
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());

        getOrCreateTagBuilder(CommonTags.C_FOODS_COOKIE)
                .add(UbesDelightItems.COOKIE_UBE.get())
                .add(UbesDelightItems.COOKIE_GINGER.get())
                .add(UbesDelightItems.POLVORONE.get())
                .add(UbesDelightItems.POLVORONE_PINIPIG.get())
                .add(UbesDelightItems.POLVORONE_UBE.get())
                .add(UbesDelightItems.POLVORONE_CC.get());

        getOrCreateTagBuilder(CommonTags.C_FOODS_SOUPS)
                .add(UbesDelightItems.BULALO.get())
                .add(UbesDelightItems.ARROZ_CALDO.get())
                .add(UbesDelightItems.MECHADO.get());

        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS);

        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE).add(UbesDelightItems.UBE_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC).add(UbesDelightItems.GARLIC_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER).add(UbesDelightItems.GINGER_CRATE.get());
        getOrCreateTagBuilder(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS).add(UbesDelightItems.LEMONGRASS_CRATE.get());

        getOrCreateTagBuilder(ConventionalItemTags.EDIBLE_WHEN_PLACED_FOODS)
                .add(UbesDelightItems.UBE_CAKE.get())
                .add(UbesDelightItems.LECHE_FLAN_FEAST.get())
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

        getOrCreateTagBuilder(ConventionalItemTags.FOOD_POISONING_FOODS)
                .add(UbesDelightItems.PANDESAL_RAW.get())
                .add(UbesDelightItems.PANDESAL_UBE_RAW.get())
                .add(UbesDelightItems.ENSAYMADA_RAW.get())
                .add(UbesDelightItems.ENSAYMADA_UBE_RAW.get())
                .add(UbesDelightItems.HOPIA_MUNGGO_RAW.get())
                .add(UbesDelightItems.HOPIA_UBE_RAW.get())
        ;

        // Create Dough Compat
        // todo - when create 1.21 releases check compatibility
//        getOrCreateTagBuilder(CommonTags.C_FOODS_DOUGH)
//                .addOptionalTag(CommonTags.C_DOUGH);
    }
}
