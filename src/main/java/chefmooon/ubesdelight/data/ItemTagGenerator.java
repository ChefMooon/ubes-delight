package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.references.UDBlockItemIds;
import chefmooon.ubesdelight.common.references.UDItemIds;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import chefmooon.ubesdelight.common.tag.UbesDelightTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemId;
import net.minecraft.references.ItemIds;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

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
                .add(UDItemIds.ROLLING_PIN_WOOD)
                .add(UDItemIds.ROLLING_PIN_IRON)
                .add(UDItemIds.ROLLING_PIN_GOLD)
                .add(UDItemIds.ROLLING_PIN_DIAMOND)
                .add(UDItemIds.ROLLING_PIN_NETHERITE)
        ;
    }

    private void registerMinecraftItemTags() {
        // Minecraft Item Tags
        tag(BlockItemTags.SMALL_FLOWERS.item())
                .add(key(UDBlockItemIds.WILD_UBE))
                .add(key(UDBlockItemIds.WILD_GARLIC))
                .add(key(UDBlockItemIds.WILD_GINGER));

        tag(ConventionalItemTags.TALL_FLOWERS)
                .add(key(UDBlockItemIds.WILD_LEMONGRASS));

        tag(ItemTags.PARROT_FOOD)
                .add(key(UDBlockItemIds.LEMONGRASS_STALK_CROP));

        tag(ItemTags.CHICKEN_FOOD)
                .add(key(UDBlockItemIds.LEMONGRASS_STALK_CROP));

        tag(ItemTags.PIG_FOOD)
                .add(key(UDBlockItemIds.UBE_CROP))
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(UDItemIds.LEMONGRASS);

        tag(ItemTags.RABBIT_FOOD)
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(UDItemIds.LEMONGRASS);

        tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        tag(ItemTags.BREAKS_DECORATED_POTS).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);

        tag(ItemTags.VILLAGER_PICKS_UP)
                .add(key(UDBlockItemIds.UBE_CROP))
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(UDItemIds.LEMONGRASS)
                .add(key(UDBlockItemIds.LEMONGRASS_STALK_CROP));

        tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(key(UDBlockItemIds.UBE_CROP))
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(key(UDBlockItemIds.LEMONGRASS_STALK_CROP));
    }
    private void registerCompatibiltyItemTags() {
        // Create Item Tags
        tag(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
                .add(key(UDBlockItemIds.GLASS_CUP_MILK_TEA_UBE))
                .add(key(UDBlockItemIds.GLASS_CUP_HALO_HALO))
                .add(UDItemIds.FISH_SAUCE_BOTTLE)
                .add(UDItemIds.CONDENSED_MILK_BOTTLE)
                .add(key(UDBlockItemIds.UBE_CAKE))
                .add(key(UDBlockItemIds.LECHE_FLAN_FEAST))
                .add(key(UDBlockItemIds.HALO_HALO_FEAST))
                .add(key(UDBlockItemIds.MILK_TEA_UBE_FEAST))
                .add(UDItemIds.SINANGAG)
                .add(UDItemIds.KINILAW)
                .add(UDItemIds.CHICKEN_INASAL_RICE)
                .add(UDItemIds.TOSILOG)
                .add(UDItemIds.BANGSILOG)
                .add(UDItemIds.SISIG)
                .add(UDItemIds.BULALO)
                .add(UDItemIds.ARROZ_CALDO)
                .add(UDItemIds.MECHADO);

        // Farmers Delight Item Tags
        tag(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS_ITEM)
                .add(key(UDBlockItemIds.WILD_UBE))
                .add(key(UDBlockItemIds.WILD_GARLIC))
                .add(key(UDBlockItemIds.WILD_GINGER))
                .add(key(UDBlockItemIds.WILD_LEMONGRASS));

        // Supplementaries Item Tags
        tag(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(UDItemIds.COOKIE_UBE)
                .add(UDItemIds.COOKIE_GINGER)
                .add(UDItemIds.POLVORONE)
                .add(UDItemIds.POLVORONE_PINIPIG)
                .add(UDItemIds.POLVORONE_UBE)
                .add(UDItemIds.POLVORONE_CC);

        // Dehydration Item Tags
        tag(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(UDItemIds.CONDENSED_MILK_BOTTLE)
                .add(UDItemIds.FISH_SAUCE_BOTTLE)
                .add(key(UDBlockItemIds.GLASS_CUP_MILK_TEA_UBE))
                .add(key(UDBlockItemIds.GLASS_CUP_HALO_HALO));

        tag(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(UDItemIds.BULALO)
                .add(UDItemIds.ARROZ_CALDO)
                .add(UDItemIds.MECHADO);

        // Origins Item Tags
        tag(CompatibilityTags.ORIGINS_IGNORE_DIET)
                .add(UDItemIds.CONDENSED_MILK_BOTTLE)
                .add(UDItemIds.FISH_SAUCE_BOTTLE);

        tag(CompatibilityTags.ORIGINS_MEAT)
                .add(UDItemIds.LUMPIA)
                .add(UDItemIds.TOCINO)
                .add(UDItemIds.CHICKEN_INASAL)
                .add(UDItemIds.CHICKEN_INASAL_RICE)
                .add(UDItemIds.TOSILOG)
                .add(UDItemIds.BANGSILOG)
                .add(UDItemIds.SISIG)
                .add(UDItemIds.BULALO)
                .add(UDItemIds.ARROZ_CALDO)
                .add(UDItemIds.MECHADO);

        // Serene Seasons
        tag(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS)
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(key(UDBlockItemIds.GINGER_CROP));
        tag(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS)
                .add(key(UDBlockItemIds.UBE_CROP))
                .add(key(UDBlockItemIds.LEMONGRASS_STALK_CROP));
        tag(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS)
                .add(key(UDBlockItemIds.UBE_CROP))
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(key(UDBlockItemIds.LEMONGRASS_STALK_CROP));
    }

    @SuppressWarnings("unchecked")
    private void registerCommonItemTags() {
        tag(CommonTags.C_FOOD_WRAPPERS)
                .forceAddTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER);
        tag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)
                .add(UDItemIds.LUMPIA_WRAPPER);

        tag(CommonTags.C_TOOLS_ROLLING_PIN)
                .add(UDItemIds.ROLLING_PIN_WOOD)
                .add(UDItemIds.ROLLING_PIN_IRON)
                .add(UDItemIds.ROLLING_PIN_GOLD)
                .add(UDItemIds.ROLLING_PIN_DIAMOND)
                .add(UDItemIds.ROLLING_PIN_NETHERITE);

        tag(CommonTags.C_TEA_INGREDIENTS)
                .forceAddTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK);
        tag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .add(ItemIds.SUGAR)
                .add(UDItemIds.SUGAR_BROWN);

        tag(CommonTags.C_CROPS_GARLIC)
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(UDItemIds.GARLIC_CHOP);
        tag(CommonTags.C_CROPS_GINGER)
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(UDItemIds.GINGER_CHOP);
        tag(CommonTags.C_CROPS_LEMONGRASS)
                .add(UDItemIds.LEMONGRASS);
        tag(CommonTags.C_CROPS_UBE)
                .add(key(UDBlockItemIds.UBE_CROP));

        tag(CommonTags.C_FOODS_GARLIC)
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(UDItemIds.GARLIC_CHOP);
        tag(CommonTags.C_FOODS_GINGER)
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(UDItemIds.GINGER_CHOP);
        tag(CommonTags.C_FOODS_LEMONGRASS)
                .add(UDItemIds.LEMONGRASS);
        tag(CommonTags.C_FOODS_UBE)
                .add(key(UDBlockItemIds.UBE_CROP));

        tag(CommonTags.C_FOODS_LEAFY_GREEN)
                .forceAddTag(CommonTags.C_FOODS_LEMONGRASS);

        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE).add(key(UDBlockItemIds.UBE_CRATE));
        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC).add(key(UDBlockItemIds.GARLIC_CRATE));
        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER).add(key(UDBlockItemIds.GINGER_CRATE));
        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS).add(key(UDBlockItemIds.LEMONGRASS_CRATE));

        // Create Dough Compat
        // todo - when create 1.21 releases check compatibility
//        tag(CommonTags.C_FOODS_DOUGH)
//                .addOptionalTag(CommonTags.C_DOUGH);
    }

    @SuppressWarnings("unchecked")
    private void registerConventionalItemTags() {
        tag(ConventionalItemTags.TOOLS).forceAddTag(CommonTags.C_TOOLS_ROLLING_PIN);

        tag(ConventionalItemTags.VEGETABLE_FOODS)
                .add(key(UDBlockItemIds.UBE_CROP))
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(UDItemIds.LEMONGRASS);

        tag(ConventionalItemTags.COOKIE_FOODS)
                .add(UDItemIds.COOKIE_UBE)
                .add(UDItemIds.COOKIE_GINGER)
                .add(UDItemIds.POLVORONE)
                .add(UDItemIds.POLVORONE_PINIPIG)
                .add(UDItemIds.POLVORONE_UBE)
                .add(UDItemIds.POLVORONE_CC);

        tag(ConventionalItemTags.EDIBLE_WHEN_PLACED_FOODS)
                .add(key(UDBlockItemIds.UBE_CAKE))
                .add(key(UDBlockItemIds.LECHE_FLAN_FEAST))
                .add(key(UDBlockItemIds.HALO_HALO_FEAST))
                .add(key(UDBlockItemIds.MILK_TEA_UBE_FEAST))
                .add(key(UDBlockItemIds.LEAF_FEAST_ENSAYMADA))
                .add(UDItemIds.LEAF_FEAST_ENSAYMADA_HALF)
                .add(key(UDBlockItemIds.LEAF_FEAST_ENSAYMADA_UBE))
                .add(UDItemIds.LEAF_FEAST_ENSAYMADA_UBE_HALF)
                .add(key(UDBlockItemIds.LEAF_FEAST_PANDESAL))
                .add(UDItemIds.LEAF_FEAST_PANDESAL_HALF)
                .add(key(UDBlockItemIds.LEAF_FEAST_PANDESAL_UBE))
                .add(UDItemIds.LEAF_FEAST_PANDESAL_UBE_HALF)
                .add(key(UDBlockItemIds.LEAF_FEAST_HOPIA_MUNGGO))
                .add(UDItemIds.LEAF_FEAST_HOPIA_MUNGGO_HALF)
                .add(key(UDBlockItemIds.LEAF_FEAST_HOPIA_UBE))
                .add(UDItemIds.LEAF_FEAST_HOPIA_UBE_HALF)
                .add(key(UDBlockItemIds.LEAF_FEAST_COOKED_RICE))
                .add(UDItemIds.LEAF_FEAST_COOKED_RICE_HALF)
                .add(key(UDBlockItemIds.LEAF_FEAST_FRIED_RICE))
                .add(UDItemIds.LEAF_FEAST_FRIED_RICE_HALF)
                .add(key(UDBlockItemIds.LEAF_FEAST_SINANGAG))
                .add(UDItemIds.LEAF_FEAST_SINANGAG_HALF)
        ;

        tag(ConventionalItemTags.FOODS)
                .add(UDItemIds.POISONOUS_UBE)
                .add(key(UDBlockItemIds.UBE_CROP))
                .add(key(UDBlockItemIds.GARLIC_CROP))
                .add(UDItemIds.GARLIC_CHOP)
                .add(key(UDBlockItemIds.GINGER_CROP))
                .add(UDItemIds.GINGER_CHOP)
                .add(UDItemIds.CONDENSED_MILK_BOTTLE)
                .add(UDItemIds.FISH_SAUCE_BOTTLE)
                .add(key(UDBlockItemIds.GLASS_CUP_MILK_TEA_UBE))
                .add(key(UDBlockItemIds.GLASS_CUP_HALO_HALO))
                .add(UDItemIds.SINANGAG)
                .add(UDItemIds.KINILAW)
                .add(UDItemIds.LUMPIA)
                .add(UDItemIds.TOCINO)
                .add(UDItemIds.CHICKEN_INASAL)
                .add(UDItemIds.CHICKEN_INASAL_RICE)
                .add(UDItemIds.TOSILOG)
                .add(UDItemIds.BANGSILOG)
                .add(UDItemIds.SISIG)
                .add(UDItemIds.BULALO)
                .add(UDItemIds.ARROZ_CALDO)
                .add(UDItemIds.MECHADO)
                .add(UDItemIds.COOKIE_UBE)
                .add(UDItemIds.COOKIE_GINGER)
                .add(UDItemIds.LECHE_FLAN)
                .add(UDItemIds.UBE_CAKE_SLICE)
                .add(UDItemIds.POLVORONE)
                .add(UDItemIds.POLVORONE_PINIPIG)
                .add(UDItemIds.POLVORONE_UBE)
                .add(UDItemIds.POLVORONE_CC)
                .add(UDItemIds.PANDESAL)
                .add(UDItemIds.PANDESAL_UBE)
                .add(UDItemIds.ENSAYMADA)
                .add(UDItemIds.ENSAYMADA_UBE)
                .add(UDItemIds.HOPIA_MUNGGO)
                .add(UDItemIds.HOPIA_UBE)
        ;

        tag(ConventionalItemTags.SEEDS)
                .add(key(UDBlockItemIds.LEMONGRASS_STALK_CROP));

        tag(ConventionalItemTags.SOUP_FOODS)
                .add(UDItemIds.BULALO)
                .add(UDItemIds.ARROZ_CALDO)
                .add(UDItemIds.MECHADO);

        tag(ConventionalItemTags.CROPS)
                .forceAddTag(CommonTags.C_CROPS_UBE)
                .forceAddTag(CommonTags.C_CROPS_UBE)
                .forceAddTag(CommonTags.C_CROPS_GARLIC)
                .forceAddTag(CommonTags.C_CROPS_GINGER)
                .forceAddTag(CommonTags.C_CROPS_LEMONGRASS);

        tag(ConventionalItemTags.MILK_DRINKS)
                .add(UDItemIds.CONDENSED_MILK_BOTTLE);

        tag(ConventionalItemTags.STORAGE_BLOCKS)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER)
                .forceAddTag(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS);

        tag(ConventionalItemTags.FOOD_POISONING_FOODS)
                .add(UDItemIds.PANDESAL_RAW)
                .add(UDItemIds.PANDESAL_UBE_RAW)
                .add(UDItemIds.ENSAYMADA_RAW)
                .add(UDItemIds.ENSAYMADA_UBE_RAW)
                .add(UDItemIds.HOPIA_MUNGGO_RAW)
                .add(UDItemIds.HOPIA_UBE_RAW)
        ;
    }

    private static ResourceKey<Item> key(BlockItemId blockItemId) {
        return blockItemId.item();
    }
}
