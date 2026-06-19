package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import chefmooon.ubesdelight.common.tag.UbesDelightTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
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
        tag(UbesDelightTags.TOOLS_ROLLING_PIN)
                .add(key(UbesDelightItems.ROLLING_PIN_WOOD.get()))
                .add(key(UbesDelightItems.ROLLING_PIN_IRON.get()))
                .add(key(UbesDelightItems.ROLLING_PIN_GOLD.get()))
                .add(key(UbesDelightItems.ROLLING_PIN_DIAMOND.get()))
                .add(key(UbesDelightItems.ROLLING_PIN_NETHERITE.get()))
        ;
    }

    private void registerMinecraftItemTags() {
        // Minecraft Item Tags
        tag(BlockItemTags.SMALL_FLOWERS.item())
                .add(key(UbesDelightItems.WILD_UBE.get()))
                .add(key(UbesDelightItems.WILD_GARLIC.get()))
                .add(key(UbesDelightItems.WILD_GINGER.get()));

        tag(ConventionalItemTags.TALL_FLOWERS)
                .add(key(UbesDelightItems.WILD_LEMONGRASS.get()));

        tag(ItemTags.PARROT_FOOD)
                .add(key(UbesDelightItems.LEMONGRASS_SEEDS.get()));

        tag(ItemTags.CHICKEN_FOOD)
                .add(key(UbesDelightItems.LEMONGRASS_SEEDS.get()));

        tag(ItemTags.PIG_FOOD)
                .add(key(UbesDelightItems.UBE.get()))
                .add(key(UbesDelightItems.GARLIC.get()))
                .add(key(UbesDelightItems.GINGER.get()))
                .add(key(UbesDelightItems.LEMONGRASS.get()));

        tag(ItemTags.RABBIT_FOOD)
                .add(key(UbesDelightItems.GINGER.get()))
                .add(key(UbesDelightItems.LEMONGRASS.get()));

        tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        tag(ItemTags.BREAKS_DECORATED_POTS).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);

        tag(ItemTags.VILLAGER_PICKS_UP)
                .add(key(UbesDelightItems.UBE.get()))
                .add(key(UbesDelightItems.GARLIC.get()))
                .add(key(UbesDelightItems.GINGER.get()))
                .add(key(UbesDelightItems.LEMONGRASS.get()))
                .add(key(UbesDelightItems.LEMONGRASS_SEEDS.get()));

        tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(key(UbesDelightItems.UBE.get()))
                .add(key(UbesDelightItems.GARLIC.get()))
                .add(key(UbesDelightItems.GINGER.get()))
                .add(key(UbesDelightItems.LEMONGRASS_SEEDS.get()));
    }
    private void registerCompatibiltyItemTags() {
        // Create Item Tags
        tag(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
                .add(key(UbesDelightItems.MILK_TEA_UBE.get()))
                .add(key(UbesDelightItems.HALO_HALO.get()))
                .add(key(UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .add(key(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .add(key(UbesDelightItems.UBE_CAKE.get()))
                .add(key(UbesDelightItems.LECHE_FLAN_FEAST.get()))
                .add(key(UbesDelightItems.HALO_HALO_FEAST.get()))
                .add(key(UbesDelightItems.MILK_TEA_UBE_FEAST.get()))
                .add(key(UbesDelightItems.SINANGAG.get()))
                .add(key(UbesDelightItems.KINILAW.get()))
                .add(key(UbesDelightItems.CHICKEN_INASAL_RICE.get()))
                .add(key(UbesDelightItems.TOSILOG.get()))
                .add(key(UbesDelightItems.BANGSILOG.get()))
                .add(key(UbesDelightItems.SISIG.get()))
                .add(key(UbesDelightItems.BULALO.get()))
                .add(key(UbesDelightItems.ARROZ_CALDO.get()))
                .add(key(UbesDelightItems.MECHADO.get()));

        // Farmers Delight Item Tags
        tag(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS_ITEM)
                .add(key(UbesDelightItems.WILD_UBE.get()))
                .add(key(UbesDelightItems.WILD_GARLIC.get()))
                .add(key(UbesDelightItems.WILD_GINGER.get()))
                .add(key(UbesDelightItems.WILD_LEMONGRASS.get()));

        // Supplementaries Item Tags
        tag(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(key(UbesDelightItems.COOKIE_UBE.get()))
                .add(key(UbesDelightItems.COOKIE_GINGER.get()))
                .add(key(UbesDelightItems.POLVORONE.get()))
                .add(key(UbesDelightItems.POLVORONE_PINIPIG.get()))
                .add(key(UbesDelightItems.POLVORONE_UBE.get()))
                .add(key(UbesDelightItems.POLVORONE_CC.get()));

        // Dehydration Item Tags
        tag(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(key(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .add(key(UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .add(key(UbesDelightItems.MILK_TEA_UBE.get()))
                .add(key(UbesDelightItems.HALO_HALO.get()));

        tag(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(key(UbesDelightItems.BULALO.get()))
                .add(key(UbesDelightItems.ARROZ_CALDO.get()))
                .add(key(UbesDelightItems.MECHADO.get()));

        // Origins Item Tags
        tag(CompatibilityTags.ORIGINS_IGNORE_DIET)
                .add(key(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .add(key(UbesDelightItems.FISH_SAUCE_BOTTLE.get()));

        tag(CompatibilityTags.ORIGINS_MEAT)
                .add(key(UbesDelightItems.LUMPIA.get()))
                .add(key(UbesDelightItems.TOCINO.get()))
                .add(key(UbesDelightItems.CHICKEN_INASAL.get()))
                .add(key(UbesDelightItems.CHICKEN_INASAL_RICE.get()))
                .add(key(UbesDelightItems.TOSILOG.get()))
                .add(key(UbesDelightItems.BANGSILOG.get()))
                .add(key(UbesDelightItems.SISIG.get()))
                .add(key(UbesDelightItems.BULALO.get()))
                .add(key(UbesDelightItems.ARROZ_CALDO.get()))
                .add(key(UbesDelightItems.MECHADO.get()));

        // Serene Seasons
        tag(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS)
                .add(key(UbesDelightItems.GARLIC.get()))
                .add(key(UbesDelightItems.GINGER.get()));
        tag(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS)
                .add(key(UbesDelightItems.UBE.get()))
                .add(key(UbesDelightItems.LEMONGRASS_SEEDS.get()));
        tag(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS)
                .add(key(UbesDelightItems.UBE.get()))
                .add(key(UbesDelightItems.GARLIC.get()))
                .add(key(UbesDelightItems.GINGER.get()))
                .add(key(UbesDelightItems.LEMONGRASS_SEEDS.get()));
    }

    @SuppressWarnings("unchecked")
    private void registerCommonItemTags() {
        tag(CommonTags.C_FOOD_WRAPPERS)
                .forceAddTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER);
        tag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)
                .add(key(UbesDelightItems.LUMPIA_WRAPPER.get()));

        tag(CommonTags.C_TOOLS_ROLLING_PIN)
                .add(key(UbesDelightItems.ROLLING_PIN_WOOD.get()))
                .add(key(UbesDelightItems.ROLLING_PIN_IRON.get()))
                .add(key(UbesDelightItems.ROLLING_PIN_GOLD.get()))
                .add(key(UbesDelightItems.ROLLING_PIN_DIAMOND.get()))
                .add(key(UbesDelightItems.ROLLING_PIN_NETHERITE.get()));

        tag(CommonTags.C_TEA_INGREDIENTS)
                .forceAddTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK);
        tag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .add(key(Items.SUGAR))
                .add(key(UbesDelightItems.SUGAR_BROWN.get()));

        tag(CommonTags.C_CROPS_GARLIC)
                .add(key(UbesDelightItems.GARLIC.get()))
                .add(key(UbesDelightItems.GARLIC_CHOP.get()));
        tag(CommonTags.C_CROPS_GINGER)
                .add(key(UbesDelightItems.GINGER.get()))
                .add(key(UbesDelightItems.GINGER_CHOP.get()));
        tag(CommonTags.C_CROPS_LEMONGRASS)
                .add(key(UbesDelightItems.LEMONGRASS.get()));
        tag(CommonTags.C_CROPS_UBE)
                .add(key(UbesDelightItems.UBE.get()));

        tag(CommonTags.C_FOODS_GARLIC)
                .add(key(UbesDelightItems.GARLIC.get()))
                .add(key(UbesDelightItems.GARLIC_CHOP.get()));
        tag(CommonTags.C_FOODS_GINGER)
                .add(key(UbesDelightItems.GINGER.get()))
                .add(key(UbesDelightItems.GINGER_CHOP.get()));
        tag(CommonTags.C_FOODS_LEMONGRASS)
                .add(key(UbesDelightItems.LEMONGRASS.get()));
        tag(CommonTags.C_FOODS_UBE)
                .add(key(UbesDelightItems.UBE.get()));

        tag(CommonTags.C_FOODS_LEAFY_GREEN)
                .forceAddTag(CommonTags.C_FOODS_LEMONGRASS);

        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE).add(key(UbesDelightItems.UBE_CRATE.get()));
        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC).add(key(UbesDelightItems.GARLIC_CRATE.get()));
        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER).add(key(UbesDelightItems.GINGER_CRATE.get()));
        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS).add(key(UbesDelightItems.LEMONGRASS_CRATE.get()));

        // Create Dough Compat
        // todo - when create 1.21 releases check compatibility
//        tag(CommonTags.C_FOODS_DOUGH)
//                .addOptionalTag(CommonTags.C_DOUGH);
    }

    @SuppressWarnings("unchecked")
    private void registerConventionalItemTags() {
        tag(ConventionalItemTags.TOOLS).forceAddTag(CommonTags.C_TOOLS_ROLLING_PIN);

        tag(ConventionalItemTags.VEGETABLE_FOODS)
                .add(key(UbesDelightItems.UBE.get()))
                .add(key(UbesDelightItems.GARLIC.get()))
                .add(key(UbesDelightItems.GINGER.get()))
                .add(key(UbesDelightItems.LEMONGRASS.get()));

        tag(ConventionalItemTags.COOKIE_FOODS)
                .add(key(UbesDelightItems.COOKIE_UBE.get()))
                .add(key(UbesDelightItems.COOKIE_GINGER.get()))
                .add(key(UbesDelightItems.POLVORONE.get()))
                .add(key(UbesDelightItems.POLVORONE_PINIPIG.get()))
                .add(key(UbesDelightItems.POLVORONE_UBE.get()))
                .add(key(UbesDelightItems.POLVORONE_CC.get()));

        tag(ConventionalItemTags.EDIBLE_WHEN_PLACED_FOODS)
                .add(key(UbesDelightItems.UBE_CAKE.get()))
                .add(key(UbesDelightItems.LECHE_FLAN_FEAST.get()))
                .add(key(UbesDelightItems.HALO_HALO_FEAST.get()))
                .add(key(UbesDelightItems.MILK_TEA_UBE_FEAST.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_ENSAYMADA.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_ENSAYMADA_HALF.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE_HALF.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_PANDESAL.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_PANDESAL_HALF.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE_HALF.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO_HALF.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_HOPIA_UBE.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_HOPIA_UBE_HALF.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_COOKED_RICE.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_COOKED_RICE_HALF.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_FRIED_RICE.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_FRIED_RICE_HALF.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_SINANGAG.get()))
                .add(key(UbesDelightItems.LEAF_FEAST_SINANGAG_HALF.get()))
        ;

        tag(ConventionalItemTags.FOODS)
                .add(key(UbesDelightItems.POISONOUS_UBE.get()))
                .add(key(UbesDelightItems.UBE.get()))
                .add(key(UbesDelightItems.GARLIC.get()))
                .add(key(UbesDelightItems.GARLIC_CHOP.get()))
                .add(key(UbesDelightItems.GINGER.get()))
                .add(key(UbesDelightItems.GINGER_CHOP.get()))
                .add(key(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()))
                .add(key(UbesDelightItems.FISH_SAUCE_BOTTLE.get()))
                .add(key(UbesDelightItems.MILK_TEA_UBE.get()))
                .add(key(UbesDelightItems.HALO_HALO.get()))
                .add(key(UbesDelightItems.SINANGAG.get()))
                .add(key(UbesDelightItems.KINILAW.get()))
                .add(key(UbesDelightItems.LUMPIA.get()))
                .add(key(UbesDelightItems.TOCINO.get()))
                .add(key(UbesDelightItems.CHICKEN_INASAL.get()))
                .add(key(UbesDelightItems.CHICKEN_INASAL_RICE.get()))
                .add(key(UbesDelightItems.TOSILOG.get()))
                .add(key(UbesDelightItems.BANGSILOG.get()))
                .add(key(UbesDelightItems.SISIG.get()))
                .add(key(UbesDelightItems.BULALO.get()))
                .add(key(UbesDelightItems.ARROZ_CALDO.get()))
                .add(key(UbesDelightItems.MECHADO.get()))
                .add(key(UbesDelightItems.COOKIE_UBE.get()))
                .add(key(UbesDelightItems.COOKIE_GINGER.get()))
                .add(key(UbesDelightItems.LECHE_FLAN.get()))
                .add(key(UbesDelightItems.UBE_CAKE_SLICE.get()))
                .add(key(UbesDelightItems.POLVORONE.get()))
                .add(key(UbesDelightItems.POLVORONE_PINIPIG.get()))
                .add(key(UbesDelightItems.POLVORONE_UBE.get()))
                .add(key(UbesDelightItems.POLVORONE_CC.get()))
                .add(key(UbesDelightItems.PANDESAL.get()))
                .add(key(UbesDelightItems.PANDESAL_UBE.get()))
                .add(key(UbesDelightItems.ENSAYMADA.get()))
                .add(key(UbesDelightItems.ENSAYMADA_UBE.get()))
                .add(key(UbesDelightItems.HOPIA_MUNGGO.get()))
                .add(key(UbesDelightItems.HOPIA_UBE.get()))
        ;

        tag(ConventionalItemTags.SEEDS)
                .add(key(UbesDelightItems.LEMONGRASS_SEEDS.get()));

        tag(ConventionalItemTags.SOUP_FOODS)
                .add(key(UbesDelightItems.BULALO.get()))
                .add(key(UbesDelightItems.ARROZ_CALDO.get()))
                .add(key(UbesDelightItems.MECHADO.get()));

        tag(ConventionalItemTags.CROPS)
                .forceAddTag(CommonTags.C_CROPS_UBE)
                .forceAddTag(CommonTags.C_CROPS_UBE)
                .forceAddTag(CommonTags.C_CROPS_GARLIC)
                .forceAddTag(CommonTags.C_CROPS_GINGER)
                .forceAddTag(CommonTags.C_CROPS_LEMONGRASS);

        tag(ConventionalItemTags.MILK_DRINKS)
                .add(key(UbesDelightItems.CONDENSED_MILK_BOTTLE.get()));

        tag(ConventionalItemTags.STORAGE_BLOCKS)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS);

        tag(ConventionalItemTags.FOOD_POISONING_FOODS)
                .add(key(UbesDelightItems.PANDESAL_RAW.get()))
                .add(key(UbesDelightItems.PANDESAL_UBE_RAW.get()))
                .add(key(UbesDelightItems.ENSAYMADA_RAW.get()))
                .add(key(UbesDelightItems.ENSAYMADA_UBE_RAW.get()))
                .add(key(UbesDelightItems.HOPIA_MUNGGO_RAW.get()))
                .add(key(UbesDelightItems.HOPIA_UBE_RAW.get()))
        ;
    }

    private static ResourceKey<Item> key(Item item) {
        Identifier location = BuiltInRegistries.ITEM.getKey(item);
        return ResourceKey.create(Registries.ITEM, location);
    }
}
