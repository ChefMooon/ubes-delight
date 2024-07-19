package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.FoodValues;
import com.chefmooon.ubesdelight.common.item.UbesDelightBlockItem;
import com.chefmooon.ubesdelight.common.item.UbesDelightDrinkableBlockItem;
import com.chefmooon.ubesdelight.common.item.fabric.RollingPinItemImpl;
import com.chefmooon.ubesdelight.common.item.fabric.UbesDelightConsumableItemImpl;
import com.chefmooon.ubesdelight.common.item.fabric.UbesDelightDrinkableItemImpl;
import com.chefmooon.ubesdelight.common.item.fabric.UbesDelightFuelBlockItemImpl;
import com.chefmooon.ubesdelight.common.item.tiers.UDTiers;
import com.chefmooon.ubesdelight.common.registry.UbesDelightItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

import static com.chefmooon.ubesdelight.common.registry.UbesDelightItems.*;

public class UbesDelightItemsImpl {

    public static final Item KALAN = registerItemWithTab(UbesDelightItems.KALAN,
            new UbesDelightBlockItem(UbesDelightBlocksImpl.KALAN, basicItem()));
    public static final Item BAKING_MAT_BAMBOO = registerItemWithTab(UbesDelightItems.BAKING_MAT_BAMBOO,
            new UbesDelightFuelBlockItemImpl(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO, basicItem(), false, false, 250));
    public static final Item ROLLING_PIN_WOOD = registerItemWithTab(UbesDelightItems.ROLLING_PIN_WOOD,
            new RollingPinItemImpl(1.0F, 1.0F, UDTiers.ROLLING_PIN_WOOD, basicItem()));

    // todo - remove after dev branch
    public static final Item BANANA_LEAF = registerItem(UbesDelightItems.BANANA_LEAF,
            new BlockItem(UbesDelightBlocksImpl.BANANA_LEAF, basicItem()));

    public static final Item WILD_UBE = registerItemWithTab(UbesDelightItems.WILD_UBE,
            new BlockItem(UbesDelightBlocksImpl.WILD_UBE, basicItem()));
    public static final Item WILD_GARLIC = registerItemWithTab(UbesDelightItems.WILD_GARLIC,
            new BlockItem(UbesDelightBlocksImpl.WILD_GARLIC, basicItem()));
    public static final Item WILD_GINGER = registerItemWithTab(UbesDelightItems.WILD_GINGER,
            new BlockItem(UbesDelightBlocksImpl.WILD_GINGER, basicItem()));
    public static final Item WILD_LEMONGRASS = registerItemWithTab(UbesDelightItems.WILD_LEMONGRASS,
            new BlockItem(UbesDelightBlocksImpl.WILD_LEMONGRASS, basicItem()));

    public static final Item UBE_CRATE = registerItemWithTab(UbesDelightItems.UBE_CRATE,
            new BlockItem(UbesDelightBlocksImpl.UBE_CRATE, basicItem()));
    public static final Item GARLIC_CRATE = registerItemWithTab(UbesDelightItems.GARLIC_CRATE,
            new BlockItem(UbesDelightBlocksImpl.GARLIC_CRATE, basicItem()));
    public static final Item GINGER_CRATE = registerItemWithTab(UbesDelightItems.GINGER_CRATE,
            new BlockItem(UbesDelightBlocksImpl.GINGER_CRATE, basicItem()));
    public static final Item LEMONGRASS_CRATE = registerItemWithTab(UbesDelightItems.LEMONGRASS_CRATE,
            new BlockItem(UbesDelightBlocksImpl.LEMONGRASS_CRATE, basicItem()));

    public static final Item UBE_CAKE = registerItemWithTab(UbesDelightItems.UBE_CAKE,
            new BlockItem(UbesDelightBlocksImpl.UBE_CAKE, noStack()));
    public static final Item LECHE_FLAN_FEAST = registerItemWithTab(UbesDelightItems.LECHE_FLAN_FEAST,
            new BlockItem(UbesDelightBlocksImpl.LECHE_FLAN_FEAST, noStack()));
    public static final Item LUMPIA_FEAST = registerItemWithTab(UbesDelightItems.LUMPIA_FEAST,
            new BlockItem(UbesDelightBlocksImpl.LUMPIA_FEAST, noStack()));
    public static final Item HALO_HALO_FEAST = registerItemWithTab(UbesDelightItems.HALO_HALO_FEAST,
            new BlockItem(UbesDelightBlocksImpl.HALO_HALO_FEAST, noStack()));
    public static final Item MILK_TEA_UBE_FEAST = registerItemWithTab(UbesDelightItems.MILK_TEA_UBE_FEAST,
            new BlockItem(UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST, noStack()));
    public static final Item POISONOUS_UBE = registerItemWithTab(UbesDelightItems.POISONOUS_UBE,
            new Item(basicItem()));
    public static final Item UBE = registerItemWithTab(UbesDelightItems.UBE,
            new ItemNameBlockItem(UbesDelightBlocksImpl.UBE_CROP, foodItem(FoodValues.UBE)));
    public static final Item GARLIC = registerItemWithTab(UbesDelightItems.GARLIC,
            new ItemNameBlockItem(UbesDelightBlocksImpl.GARLIC_CROP, foodItem(FoodValues.GARLIC)));
    public static final Item GINGER = registerItemWithTab(UbesDelightItems.GINGER,
            new ItemNameBlockItem(UbesDelightBlocksImpl.GINGER_CROP, foodItem(FoodValues.GINGER)));
    public static final Item LEMONGRASS = registerItemWithTab(UbesDelightItems.LEMONGRASS,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.LEMONGRASS)));
    public static final Item LEMONGRASS_SEEDS = registerItemWithTab(UbesDelightItems.LEMONGRASS_SEEDS,
            new ItemNameBlockItem(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP, basicItem()));

    public static final Item CONDENSED_MILK_BOTTLE = registerItemWithTab(UbesDelightItems.CONDENSED_MILK_BOTTLE,
            new UbesDelightDrinkableItemImpl(drinkItem(FoodValues.CONDENSED_MILK_BOTTLE), true));
    public static final Item FISH_SAUCE_BOTTLE = registerItemWithTab(UbesDelightItems.FISH_SAUCE_BOTTLE,
            new UbesDelightDrinkableItemImpl(drinkItem(FoodValues.FISH_SAUCE_BOTTLE), true));
    public static final Item MILK_POWDER = registerItemWithTab(UbesDelightItems.MILK_POWDER,
            new Item(basicItem()));
    public static final Item SUGAR_BROWN = registerItemWithTab(UbesDelightItems.SUGAR_BROWN,
            new Item(basicItem()));
    public static final Item LUMPIA_WRAPPER = registerItemWithTab(UbesDelightItems.LUMPIA_WRAPPER,
            new Item(basicItem()));

    public static final Item MILK_TEA_UBE = registerItemWithTab(UbesDelightItems.MILK_TEA_UBE,
            new UbesDelightDrinkableItemImpl(drinkItem(FoodValues.MILK_TEA_UBE), true));
    public static final Item HALO_HALO = registerItemWithTab(UbesDelightItems.HALO_HALO,
            new UbesDelightDrinkableBlockItem(UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO, drinkItem(FoodValues.HALO_HALO), true, true));

    public static final Item GARLIC_CHOP = registerItemWithTab(UbesDelightItems.GARLIC_CHOP,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.GARLIC_CHOP)));
    public static final Item GINGER_CHOP = registerItemWithTab(UbesDelightItems.GINGER_CHOP,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.GINGER_CHOP)));

    public static final Item SINANGAG = registerItemWithTab(UbesDelightItems.SINANGAG,
            new UbesDelightConsumableItemImpl(bowlFoodItem(FoodValues.SINANGAG), true));
    public static final Item KINILAW = registerItemWithTab(UbesDelightItems.KINILAW,
            new UbesDelightConsumableItemImpl(bowlFoodItem(FoodValues.KINILAW), true));
    public static final Item LUMPIA = registerItemWithTab(UbesDelightItems.LUMPIA,
            new Item(foodItem(FoodValues.LUMPIA)));
    public static final Item TOCINO = registerItemWithTab(UbesDelightItems.TOCINO,
            new Item(foodItem(FoodValues.TOCINO)));
    public static final Item CHICKEN_INASAL = registerItemWithTab(UbesDelightItems.CHICKEN_INASAL,
            new Item(foodItem(FoodValues.CHICKEN_INASAL)));

    public static final Item CHICKEN_INASAL_RICE = registerItemWithTab(UbesDelightItems.CHICKEN_INASAL_RICE,
            new UbesDelightConsumableItemImpl(bowlFoodItem(FoodValues.CHICKEN_INASAL_RICE), true));
    public static final Item TOSILOG = registerItemWithTab(UbesDelightItems.TOSILOG,
            new UbesDelightConsumableItemImpl(bowlFoodItem(FoodValues.TOSILOG), true));
    public static final Item BANGSILOG = registerItemWithTab(UbesDelightItems.BANGSILOG,
            new UbesDelightConsumableItemImpl(bowlFoodItem(FoodValues.BANGSILOG), true));
    public static final Item SISIG = registerItemWithTab(UbesDelightItems.SISIG,
            new UbesDelightConsumableItemImpl(bowlFoodItem(FoodValues.SISIG), true));
    public static final Item BULALO = registerItemWithTab(UbesDelightItems.BULALO,
            new UbesDelightConsumableItemImpl(bowlFoodItem(FoodValues.BULALO), true));
    public static final Item ARROZ_CALDO = registerItemWithTab(UbesDelightItems.ARROZ_CALDO,
            new UbesDelightConsumableItemImpl(bowlFoodItem(FoodValues.ARROZ_CALDO), true));
    public static final Item MECHADO = registerItemWithTab(UbesDelightItems.MECHADO,
            new UbesDelightConsumableItemImpl(bowlFoodItem(FoodValues.MECHADO), true));

    public static final Item COOKIE_UBE = registerItemWithTab(UbesDelightItems.COOKIE_UBE,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.COOKIES)));
    public static final Item COOKIE_GINGER = registerItemWithTab(UbesDelightItems.COOKIE_GINGER,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.COOKIES)));

    public static final Item LECHE_FLAN = registerItemWithTab(UbesDelightItems.LECHE_FLAN,
            new Item(foodItem(FoodValues.LECHE_FLAN)));
    public static final Item UBE_CAKE_SLICE = registerItemWithTab(UbesDelightItems.UBE_CAKE_SLICE,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.UBE_CAKE_SLICE)));

    public static final Item RAW_POLVORONE = registerItemWithTab(UbesDelightItems.RAW_POLVORONE,
            new Item(basicItem()));
    public static final Item POLVORONE = registerItemWithTab(UbesDelightItems.POLVORONE,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.POLVORONE)));
    public static final Item RAW_POLVORONE_PINIPIG = registerItemWithTab(UbesDelightItems.RAW_POLVORONE_PINIPIG,
            new Item(basicItem()));
    public static final Item POLVORONE_PINIPIG = registerItemWithTab(UbesDelightItems.POLVORONE_PINIPIG,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.POLVORONE)));
    public static final Item RAW_POLVORONE_UBE = registerItemWithTab(UbesDelightItems.RAW_POLVORONE_UBE,
            new Item(basicItem()));
    public static final Item POLVORONE_UBE = registerItemWithTab(UbesDelightItems.POLVORONE_UBE,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.POLVORONE)));
    public static final Item RAW_POLVORONE_CC = registerItemWithTab(UbesDelightItems.RAW_POLVORONE_CC,
            new Item(basicItem()));
    public static final Item POLVORONE_CC = registerItemWithTab(UbesDelightItems.POLVORONE_CC,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.POLVORONE)));

    public static final Item PANDESAL_RAW = registerItemWithTab(UbesDelightItems.PANDESAL_RAW,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.PANDESAL_RAW)));
    public static final Item PANDESAL = registerItemWithTab(UbesDelightItems.PANDESAL,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.PANDESAL)));
    public static final Item PANDESAL_UBE_RAW = registerItemWithTab(UbesDelightItems.PANDESAL_UBE_RAW,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.PANDESAL_RAW)));
    public static final Item PANDESAL_UBE = registerItemWithTab(UbesDelightItems.PANDESAL_UBE,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.PANDESAL_UBE), true));
    public static final Item ENSAYMADA_RAW = registerItemWithTab(UbesDelightItems.ENSAYMADA_RAW,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.ENSAYMADA_RAW)));
    public static final Item ENSAYMADA = registerItemWithTab(UbesDelightItems.ENSAYMADA,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.ENSAYMADA)));
    public static final Item ENSAYMADA_UBE_RAW = registerItemWithTab(UbesDelightItems.ENSAYMADA_UBE_RAW,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.ENSAYMADA_RAW)));
    public static final Item ENSAYMADA_UBE = registerItemWithTab(UbesDelightItems.ENSAYMADA_UBE,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.ENSAYMADA_UBE), true));
    public static final Item HOPIA_MUNGGO_RAW = registerItemWithTab(UbesDelightItems.HOPIA_MUNGGO_RAW,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.HOPIA_RAW)));
    public static final Item HOPIA_MUNGGO = registerItemWithTab(UbesDelightItems.HOPIA_MUNGGO,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.HOPIA_MUNGGO)));
    public static final Item HOPIA_UBE_RAW = registerItemWithTab(UbesDelightItems.HOPIA_UBE_RAW,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.HOPIA_RAW)));
    public static final Item HOPIA_UBE = registerItemWithTab(UbesDelightItems.HOPIA_UBE,
            new UbesDelightConsumableItemImpl(foodItem(FoodValues.HOPIA_UBE), true));

    public static final Item POLVORONE_STAGE0 = registerItem(UbesDelightItems.POLVORONE_STAGE0,
            new Item(basicItem()));
    public static final Item POLVORONE_STAGE1 = registerItem(UbesDelightItems.POLVORONE_STAGE1,
            new Item(basicItem()));
    public static final Item POLVORONE_STAGE2 = registerItem(UbesDelightItems.POLVORONE_STAGE2,
            new Item(basicItem()));
    public static final Item POLVORONE_PINIPIG_STAGE0 = registerItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE0,
            new Item(basicItem()));
    public static final Item POLVORONE_PINIPIG_STAGE1 = registerItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE1,
            new Item(basicItem()));
    public static final Item POLVORONE_PINIPIG_STAGE2 = registerItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE2,
            new Item(basicItem()));
    public static final Item POLVORONE_UBE_STAGE0 = registerItem(UbesDelightItems.POLVORONE_UBE_STAGE0,
            new Item(basicItem()));
    public static final Item POLVORONE_UBE_STAGE1 = registerItem(UbesDelightItems.POLVORONE_UBE_STAGE1,
            new Item(basicItem()));
    public static final Item POLVORONE_UBE_STAGE2 = registerItem(UbesDelightItems.POLVORONE_UBE_STAGE2,
            new Item(basicItem()));
    public static final Item POLVORONE_CC_STAGE0 = registerItem(UbesDelightItems.POLVORONE_CC_STAGE0,
            new Item(basicItem()));
    public static final Item POLVORONE_CC_STAGE1 = registerItem(UbesDelightItems.POLVORONE_CC_STAGE1,
            new Item(basicItem()));
    public static final Item POLVORONE_CC_STAGE2 = registerItem(UbesDelightItems.POLVORONE_CC_STAGE2,
            new Item(basicItem()));

    public static final Item PANDESAL_STAGE0 = registerItem(UbesDelightItems.PANDESAL_STAGE0,
            new Item(basicItem()));
    public static final Item PANDESAL_STAGE1 = registerItem(UbesDelightItems.PANDESAL_STAGE1,
            new Item(basicItem()));
    public static final Item PANDESAL_STAGE2 = registerItem(UbesDelightItems.PANDESAL_STAGE2,
            new Item(basicItem()));
    public static final Item PANDESAL_UBE_STAGE0 = registerItem(UbesDelightItems.PANDESAL_UBE_STAGE0,
            new Item(basicItem()));
    public static final Item PANDESAL_UBE_STAGE1 = registerItem(UbesDelightItems.PANDESAL_UBE_STAGE1,
            new Item(basicItem()));
    public static final Item PANDESAL_UBE_STAGE2 = registerItem(UbesDelightItems.PANDESAL_UBE_STAGE2,
            new Item(basicItem()));
    public static final Item ENSAYMADA_STAGE0 = registerItem(UbesDelightItems.ENSAYMADA_STAGE0,
            new Item(basicItem()));
    public static final Item ENSAYMADA_STAGE1 = registerItem(UbesDelightItems.ENSAYMADA_STAGE1,
            new Item(basicItem()));
    public static final Item ENSAYMADA_STAGE2 = registerItem(UbesDelightItems.ENSAYMADA_STAGE2,
            new Item(basicItem()));
    public static final Item ENSAYMADA_STAGE3 = registerItem(UbesDelightItems.ENSAYMADA_STAGE3,
            new Item(basicItem()));
    public static final Item ENSAYMADA_UBE_STAGE0 = registerItem(UbesDelightItems.ENSAYMADA_UBE_STAGE0,
            new Item(basicItem()));
    public static final Item ENSAYMADA_UBE_STAGE1 = registerItem(UbesDelightItems.ENSAYMADA_UBE_STAGE1,
            new Item(basicItem()));
    public static final Item ENSAYMADA_UBE_STAGE2 = registerItem(UbesDelightItems.ENSAYMADA_UBE_STAGE2,
            new Item(basicItem()));
    public static final Item ENSAYMADA_UBE_STAGE3 = registerItem(UbesDelightItems.ENSAYMADA_UBE_STAGE3,
            new Item(basicItem()));
    public static final Item HOPIA_MUNGGO_STAGE0 = registerItem(UbesDelightItems.HOPIA_MUNGGO_STAGE0,
            new Item(basicItem()));
    public static final Item HOPIA_MUNGGO_STAGE1 = registerItem(UbesDelightItems.HOPIA_MUNGGO_STAGE1,
            new Item(basicItem()));
    public static final Item HOPIA_MUNGGO_STAGE2 = registerItem(UbesDelightItems.HOPIA_MUNGGO_STAGE2,
            new Item(basicItem()));
    public static final Item HOPIA_UBE_STAGE0 = registerItem(UbesDelightItems.HOPIA_UBE_STAGE0,
            new Item(basicItem()));
    public static final Item HOPIA_UBE_STAGE1 = registerItem(UbesDelightItems.HOPIA_UBE_STAGE1,
            new Item(basicItem()));
    public static final Item HOPIA_UBE_STAGE2 = registerItem(UbesDelightItems.HOPIA_UBE_STAGE2,
            new Item(basicItem()));

    public static Item registerItemWithTab(final ResourceLocation location, final Item item) {
        Registry.register(BuiltInRegistries.ITEM, location, item);
        ItemGroupEvents.modifyEntriesEvent(UbesDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item));
        return item;
    }

    public static Item registerItem(final ResourceLocation location, final Item item) {
        Registry.register(BuiltInRegistries.ITEM, location, item);
        return item;
    }

    public static void register() {

    }
}
