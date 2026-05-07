package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import chefmooon.ubesdelight.common.tag.CommonTags;
import chefmooon.ubesdelight.common.tag.CompatibilityTags;
import chefmooon.ubesdelight.common.tag.UbesDelightTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class UDItemTags extends ItemTagsProvider {
    public UDItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, UbesDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        registerModItemTags();
        registerMinecraftItemTags();
        registerCompatibilityItemTags();
        registerCommonItemTags();
    }
    
    private void registerModItemTags() {
        tag(UbesDelightTags.TOOLS_ROLLING_PIN)
                .add(UbesDelightItems.ROLLING_PIN_WOOD.get())
                .add(UbesDelightItems.ROLLING_PIN_IRON.get())
                .add(UbesDelightItems.ROLLING_PIN_GOLD.get())
                .add(UbesDelightItems.ROLLING_PIN_DIAMOND.get())
                .add(UbesDelightItems.ROLLING_PIN_NETHERITE.get());
    }
    
    private void registerMinecraftItemTags() {
        tag(ItemTags.SMALL_FLOWERS)
                .add(UbesDelightItems.WILD_UBE.get())
                .add(UbesDelightItems.WILD_GARLIC.get())
                .add(UbesDelightItems.WILD_GINGER.get());

        tag(ItemTags.TALL_FLOWERS)
                .add(UbesDelightItems.WILD_LEMONGRASS.get());

        tag(ItemTags.PARROT_FOOD)
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());

        tag(ItemTags.CHICKEN_FOOD)
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());

        tag(ItemTags.PIG_FOOD)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS.get());

        tag(ItemTags.RABBIT_FOOD)
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);
        tag(ItemTags.BREAKS_DECORATED_POTS).addTag(UbesDelightTags.TOOLS_ROLLING_PIN);

        tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());
    }
    
    private void registerCompatibilityItemTags() {
        // Create Item Tags
        tag(CompatibilityTags.CREATE_UPRIGHT_ON_BELT)
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
        tag(CompatibilityTags.FARMERS_DELIGHT_CABBAGE_ROLL_INGREDIENTS)
                .add(UbesDelightItems.UBE.get());

        tag(CompatibilityTags.FARMERS_DELIGHT_WILD_CROPS_ITEM)
                .add(UbesDelightItems.WILD_UBE.get())
                .add(UbesDelightItems.WILD_GARLIC.get())
                .add(UbesDelightItems.WILD_GINGER.get())
                .add(UbesDelightItems.WILD_LEMONGRASS.get());

        // Supplementaries Item Tags
        tag(CompatibilityTags.SUPPLEMENTARIES_COOKIES)
                .add(UbesDelightItems.COOKIE_UBE.get())
                .add(UbesDelightItems.COOKIE_GINGER.get())
                .add(UbesDelightItems.POLVORONE.get())
                .add(UbesDelightItems.POLVORONE_PINIPIG.get())
                .add(UbesDelightItems.POLVORONE_UBE.get())
                .add(UbesDelightItems.POLVORONE_CC.get());

        // Dehydration Item Tags
        tag(CompatibilityTags.DEHYDRATION_HYDRATING_DRINKS)
                .add(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItems.FISH_SAUCE_BOTTLE.get())
                .add(UbesDelightItems.MILK_TEA_UBE.get())
                .add(UbesDelightItems.HALO_HALO.get());

        tag(CompatibilityTags.DEHYDRATION_HYDRATING_STEW)
                .add(UbesDelightItems.BULALO.get())
                .add(UbesDelightItems.ARROZ_CALDO.get())
                .add(UbesDelightItems.MECHADO.get());

        // Origins Item Tags
        tag(CompatibilityTags.ORIGINS_IGNORE_DIET)
                .add(UbesDelightItems.CONDENSED_MILK_BOTTLE.get())
                .add(UbesDelightItems.FISH_SAUCE_BOTTLE.get());

        tag(CompatibilityTags.ORIGINS_MEAT)
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
        tag(CompatibilityTags.SERENE_SEASONS_AUTUMN_CROPS)
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get());
        tag(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());
        tag(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS)
                .add(UbesDelightItems.UBE.get())
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());
    }
    
    private void registerCommonItemTags() {
         tag(CommonTags.C_FOOD_WRAPPERS)
                .addTag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER);
        tag(CommonTags.C_FOOD_WRAPPERS_LUMPIA_WRAPPER)
                .add(UbesDelightItems.LUMPIA_WRAPPER.get());
        
        tag(CommonTags.C_TOOLS)
                .addTag(CommonTags.C_TOOLS_ROLLING_PIN);
        tag(CommonTags.C_TOOLS_ROLLING_PIN)
                .add(UbesDelightItems.ROLLING_PIN_WOOD.get())
                .add(UbesDelightItems.ROLLING_PIN_IRON.get())
                .add(UbesDelightItems.ROLLING_PIN_GOLD.get())
                .add(UbesDelightItems.ROLLING_PIN_DIAMOND.get())
                .add(UbesDelightItems.ROLLING_PIN_NETHERITE.get());

        tag(CommonTags.C_TEA_INGREDIENTS)
                .addTag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK);
        tag(CommonTags.C_TEA_INGREDIENTS_SWEET_WEAK)
                .add(Items.SUGAR)
                .add(UbesDelightItems.SUGAR_BROWN.get());

        tag(CommonTags.C_CROPS)
                .addTag(CommonTags.C_CROPS_UBE)
                .addTag(CommonTags.C_CROPS_GARLIC)
                .addTag(CommonTags.C_CROPS_GINGER)
                .addTag(CommonTags.C_CROPS_LEMONGRASS);
        tag(CommonTags.C_CROPS_GARLIC)
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GARLIC_CHOP.get());
        tag(CommonTags.C_CROPS_GINGER)
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.GINGER_CHOP.get());
        tag(CommonTags.C_CROPS_LEMONGRASS)
                .add(UbesDelightItems.LEMONGRASS.get());
        tag(CommonTags.C_CROPS_UBE)
                .add(UbesDelightItems.UBE.get());

        tag(CommonTags.C_FOODS_VEGETABLE)
                .addTag(CommonTags.C_FOODS_GARLIC)
                .addTag(CommonTags.C_FOODS_GINGER)
                .addTag(CommonTags.C_FOODS_LEMONGRASS)
                .addTag(CommonTags.C_FOODS_UBE);
        tag(CommonTags.C_FOODS_GARLIC)
                .add(UbesDelightItems.GARLIC.get())
                .add(UbesDelightItems.GARLIC_CHOP.get());
        tag(CommonTags.C_FOODS_GINGER)
                .add(UbesDelightItems.GINGER.get())
                .add(UbesDelightItems.GINGER_CHOP.get());
        tag(CommonTags.C_FOODS_LEMONGRASS)
                .add(UbesDelightItems.LEMONGRASS.get());
        tag(CommonTags.C_FOODS_UBE)
                .add(UbesDelightItems.UBE.get());

        tag(CommonTags.C_FOODS)
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

        tag(Tags.Items.DRINKS_MILK)
                .add(UbesDelightItems.CONDENSED_MILK_BOTTLE.get());

        tag(CommonTags.C_FOODS_LEAFY_GREEN)
                .addTag(CommonTags.C_FOODS_LEMONGRASS);

        tag(CommonTags.C_SEEDS)
                .add(UbesDelightItems.LEMONGRASS_SEEDS.get());

        tag(CommonTags.C_FOODS_COOKIE)
                .add(UbesDelightItems.COOKIE_UBE.get())
                .add(UbesDelightItems.COOKIE_GINGER.get())
                .add(UbesDelightItems.POLVORONE.get())
                .add(UbesDelightItems.POLVORONE_PINIPIG.get())
                .add(UbesDelightItems.POLVORONE_UBE.get())
                .add(UbesDelightItems.POLVORONE_CC.get());

        tag(CommonTags.C_FOODS_SOUPS)
                .add(UbesDelightItems.BULALO.get())
                .add(UbesDelightItems.ARROZ_CALDO.get())
                .add(UbesDelightItems.MECHADO.get());

        tag(CommonTags.C_STORAGE_BLOCKS_ITEM)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER)
                .addTag(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS);

        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_UBE).add(UbesDelightItems.UBE_CRATE.get());
        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_GARLIC).add(UbesDelightItems.GARLIC_CRATE.get());
        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_GINGER).add(UbesDelightItems.GINGER_CRATE.get());
        tag(CommonTags.C_STORAGE_BLOCKS_ITEM_LEMONGRASS).add(UbesDelightItems.LEMONGRASS_CRATE.get());

        tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED)
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

        tag(Tags.Items.FOODS_FOOD_POISONING)
                .add(UbesDelightItems.PANDESAL_RAW.get())
                .add(UbesDelightItems.PANDESAL_UBE_RAW.get())
                .add(UbesDelightItems.ENSAYMADA_RAW.get())
                .add(UbesDelightItems.ENSAYMADA_UBE_RAW.get())
                .add(UbesDelightItems.HOPIA_MUNGGO_RAW.get())
                .add(UbesDelightItems.HOPIA_UBE_RAW.get())
        ;
    }
}
