package com.chefmooon.ubesdelight.common.registry.neoforge;

import com.chefmooon.ubesdelight.UbesDelight;
import com.chefmooon.ubesdelight.common.FoodValues;
import com.chefmooon.ubesdelight.common.item.UbesDelightBlockItem;
import com.chefmooon.ubesdelight.common.item.UbesDelightConsumableItem;
import com.chefmooon.ubesdelight.common.item.UbesDelightDrinkableBlockItem;
import com.chefmooon.ubesdelight.common.item.UbesDelightDrinkableItem;
import com.chefmooon.ubesdelight.common.item.neoforge.RollingPinItemImpl;
import com.chefmooon.ubesdelight.common.item.neoforge.UbesDelightFuelBlockItemImpl;
import com.chefmooon.ubesdelight.common.item.tiers.UDTiers;
import com.chefmooon.ubesdelight.common.registry.UbesDelightItems;
import com.google.common.collect.Sets;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

import static com.chefmooon.ubesdelight.common.registry.UbesDelightItems.*;

public class UbesDelightItemsImpl {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, UbesDelight.MOD_ID);
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

    public static final Supplier<Item> KALAN = registerItemWithTab(UbesDelightItems.KALAN,
            () -> new UbesDelightBlockItem(UbesDelightBlocksImpl.KALAN.get(), basicItem()));
    public static final Supplier<Item> BAKING_MAT_BAMBOO = registerItemWithTab(UbesDelightItems.BAKING_MAT_BAMBOO,
            () -> new UbesDelightFuelBlockItemImpl(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get(), basicItem(), false, false, 250));
    public static final Supplier<Item> ROLLING_PIN_WOOD = registerItemWithTab(UbesDelightItems.ROLLING_PIN_WOOD,
            () -> new RollingPinItemImpl(UDTiers.ROLLING_PIN_WOOD, basicItem()));

    public static final Supplier<Item> WILD_UBE = registerItemWithTab(UbesDelightItems.WILD_UBE,
            () -> new BlockItem(UbesDelightBlocksImpl.WILD_UBE.get(), basicItem()));
    public static final Supplier<Item> WILD_GARLIC = registerItemWithTab(UbesDelightItems.WILD_GARLIC,
            () -> new BlockItem(UbesDelightBlocksImpl.WILD_GARLIC.get(), basicItem()));
    public static final Supplier<Item> WILD_GINGER = registerItemWithTab(UbesDelightItems.WILD_GINGER,
            () -> new BlockItem(UbesDelightBlocksImpl.WILD_GINGER.get(), basicItem()));
    public static final Supplier<Item> WILD_LEMONGRASS = registerItemWithTab(UbesDelightItems.WILD_LEMONGRASS,
            () -> new BlockItem(UbesDelightBlocksImpl.WILD_LEMONGRASS.get(), basicItem()));

    public static final Supplier<Item> UBE_CRATE = registerItemWithTab(UbesDelightItems.UBE_CRATE,
            () -> new BlockItem(UbesDelightBlocksImpl.UBE_CRATE.get(), basicItem()));
    public static final Supplier<Item> GARLIC_CRATE = registerItemWithTab(UbesDelightItems.GARLIC_CRATE,
            () -> new BlockItem(UbesDelightBlocksImpl.GARLIC_CRATE.get(), basicItem()));
    public static final Supplier<Item> GINGER_CRATE = registerItemWithTab(UbesDelightItems.GINGER_CRATE,
            () -> new BlockItem(UbesDelightBlocksImpl.GINGER_CRATE.get(), basicItem()));
    public static final Supplier<Item> LEMONGRASS_CRATE = registerItemWithTab(UbesDelightItems.LEMONGRASS_CRATE,
            () -> new BlockItem(UbesDelightBlocksImpl.LEMONGRASS_CRATE.get(), basicItem()));

    public static final Supplier<Item> UBE_CAKE = registerItemWithTab(UbesDelightItems.UBE_CAKE,
            () -> new BlockItem(UbesDelightBlocksImpl.UBE_CAKE.get(), noStack()));
    public static final Supplier<Item> LECHE_FLAN_FEAST = registerItemWithTab(UbesDelightItems.LECHE_FLAN_FEAST,
            () -> new BlockItem(UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get(), noStack()));
    public static final Supplier<Item> LUMPIA_FEAST = registerItemWithTab(UbesDelightItems.LUMPIA_FEAST,
            () -> new BlockItem(UbesDelightBlocksImpl.LUMPIA_FEAST.get(), noStack()));
    public static final Supplier<Item> HALO_HALO_FEAST = registerItemWithTab(UbesDelightItems.HALO_HALO_FEAST,
            () -> new BlockItem(UbesDelightBlocksImpl.HALO_HALO_FEAST.get(), noStack()));
    public static final Supplier<Item> MILK_TEA_UBE_FEAST = registerItemWithTab(UbesDelightItems.MILK_TEA_UBE_FEAST,
            () -> new BlockItem(UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST.get(), noStack()));
    public static final Supplier<Item> POISONOUS_UBE = registerItemWithTab(UbesDelightItems.POISONOUS_UBE,
            () -> new Item(basicItem()));
    public static final Supplier<Item> UBE = registerItemWithTab(UbesDelightItems.UBE,
            () -> new ItemNameBlockItem(UbesDelightBlocksImpl.UBE_CROP.get(), foodItem(FoodValues.UBE)));
    public static final Supplier<Item> GARLIC = registerItemWithTab(UbesDelightItems.GARLIC,
            () -> new ItemNameBlockItem(UbesDelightBlocksImpl.GARLIC_CROP.get(), foodItem(FoodValues.GARLIC)));
    public static final Supplier<Item> GINGER = registerItemWithTab(UbesDelightItems.GINGER,
            () -> new ItemNameBlockItem(UbesDelightBlocksImpl.GINGER_CROP.get(), foodItem(FoodValues.GINGER)));
    public static final Supplier<Item> LEMONGRASS = registerItemWithTab(UbesDelightItems.LEMONGRASS,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.LEMONGRASS)));
    public static final Supplier<Item> LEMONGRASS_SEEDS = registerItemWithTab(UbesDelightItems.LEMONGRASS_SEEDS,
            () -> new ItemNameBlockItem(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get(), basicItem()));

    public static final Supplier<Item> CONDENSED_MILK_BOTTLE = registerItemWithTab(UbesDelightItems.CONDENSED_MILK_BOTTLE,
            () -> new UbesDelightDrinkableItem(drinkItem(FoodValues.CONDENSED_MILK_BOTTLE), true));
    public static final Supplier<Item> FISH_SAUCE_BOTTLE = registerItemWithTab(UbesDelightItems.FISH_SAUCE_BOTTLE,
            () -> new UbesDelightDrinkableItem(drinkItem(FoodValues.FISH_SAUCE_BOTTLE), true));
    public static final Supplier<Item> MILK_POWDER = registerItemWithTab(UbesDelightItems.MILK_POWDER,
            () -> new Item(basicItem()));
    public static final Supplier<Item> SUGAR_BROWN = registerItemWithTab(UbesDelightItems.SUGAR_BROWN,
            () -> new Item(basicItem()));
    public static final Supplier<Item> LUMPIA_WRAPPER = registerItemWithTab(UbesDelightItems.LUMPIA_WRAPPER,
            () -> new Item(basicItem()));

    public static final Supplier<Item> MILK_TEA_UBE = registerItemWithTab(UbesDelightItems.MILK_TEA_UBE,
            () -> new UbesDelightDrinkableItem(drinkItem(FoodValues.MILK_TEA_UBE), true));
    public static final Supplier<Item> HALO_HALO = registerItemWithTab(UbesDelightItems.HALO_HALO,
            () -> new UbesDelightDrinkableBlockItem(UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO.get(), drinkItem(FoodValues.HALO_HALO), true, true));

    public static final Supplier<Item> GARLIC_CHOP = registerItemWithTab(UbesDelightItems.GARLIC_CHOP,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.GARLIC_CHOP)));
    public static final Supplier<Item> GINGER_CHOP = registerItemWithTab(UbesDelightItems.GINGER_CHOP,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.GINGER_CHOP)));

    public static final Supplier<Item> SINANGAG = registerItemWithTab(UbesDelightItems.SINANGAG,
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.SINANGAG), true));
    public static final Supplier<Item> KINILAW = registerItemWithTab(UbesDelightItems.KINILAW,
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.KINILAW), true));
    public static final Supplier<Item> LUMPIA = registerItemWithTab(UbesDelightItems.LUMPIA,
            () -> new Item(foodItem(FoodValues.LUMPIA)));
    public static final Supplier<Item> TOCINO = registerItemWithTab(UbesDelightItems.TOCINO,
            () -> new Item(foodItem(FoodValues.TOCINO)));
    public static final Supplier<Item> CHICKEN_INASAL = registerItemWithTab(UbesDelightItems.CHICKEN_INASAL,
            () -> new Item(foodItem(FoodValues.CHICKEN_INASAL)));

    public static final Supplier<Item> CHICKEN_INASAL_RICE = registerItemWithTab(UbesDelightItems.CHICKEN_INASAL_RICE,
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.CHICKEN_INASAL_RICE), true));
    public static final Supplier<Item> TOSILOG = registerItemWithTab(UbesDelightItems.TOSILOG,
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.TOSILOG), true));
    public static final Supplier<Item> BANGSILOG = registerItemWithTab(UbesDelightItems.BANGSILOG,
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.BANGSILOG), true));
    public static final Supplier<Item> SISIG = registerItemWithTab(UbesDelightItems.SISIG,
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.SISIG), true));
    public static final Supplier<Item> BULALO = registerItemWithTab(UbesDelightItems.BULALO,
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.BULALO), true));
    public static final Supplier<Item> ARROZ_CALDO = registerItemWithTab(UbesDelightItems.ARROZ_CALDO,
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.ARROZ_CALDO), true));
    public static final Supplier<Item> MECHADO = registerItemWithTab(UbesDelightItems.MECHADO,
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.MECHADO), true));

    public static final Supplier<Item> COOKIE_UBE = registerItemWithTab(UbesDelightItems.COOKIE_UBE,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.COOKIES)));
    public static final Supplier<Item> COOKIE_GINGER = registerItemWithTab(UbesDelightItems.COOKIE_GINGER,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.COOKIES)));

    public static final Supplier<Item> LECHE_FLAN = registerItemWithTab(UbesDelightItems.LECHE_FLAN,
            () -> new Item(foodItem(FoodValues.LECHE_FLAN)));
    public static final Supplier<Item> UBE_CAKE_SLICE = registerItemWithTab(UbesDelightItems.UBE_CAKE_SLICE,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.UBE_CAKE_SLICE)));

    public static final Supplier<Item> RAW_POLVORONE = registerItemWithTab(UbesDelightItems.RAW_POLVORONE,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE = registerItemWithTab(UbesDelightItems.POLVORONE,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.POLVORONE)));
    public static final Supplier<Item> RAW_POLVORONE_PINIPIG = registerItemWithTab(UbesDelightItems.RAW_POLVORONE_PINIPIG,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_PINIPIG = registerItemWithTab(UbesDelightItems.POLVORONE_PINIPIG,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.POLVORONE)));
    public static final Supplier<Item> RAW_POLVORONE_UBE = registerItemWithTab(UbesDelightItems.RAW_POLVORONE_UBE,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_UBE = registerItemWithTab(UbesDelightItems.POLVORONE_UBE,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.POLVORONE)));
    public static final Supplier<Item> RAW_POLVORONE_CC = registerItemWithTab(UbesDelightItems.RAW_POLVORONE_CC,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_CC = registerItemWithTab(UbesDelightItems.POLVORONE_CC,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.POLVORONE)));

    public static final Supplier<Item> PANDESAL_RAW = registerItemWithTab(UbesDelightItems.PANDESAL_RAW,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.PANDESAL_RAW)));
    public static final Supplier<Item> PANDESAL = registerItemWithTab(UbesDelightItems.PANDESAL,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.PANDESAL)));
    public static final Supplier<Item> PANDESAL_UBE_RAW = registerItemWithTab(UbesDelightItems.PANDESAL_UBE_RAW,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.PANDESAL_RAW)));
    public static final Supplier<Item> PANDESAL_UBE = registerItemWithTab(UbesDelightItems.PANDESAL_UBE,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.PANDESAL_UBE), true));
    public static final Supplier<Item> ENSAYMADA_RAW = registerItemWithTab(UbesDelightItems.ENSAYMADA_RAW,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.ENSAYMADA_RAW)));
    public static final Supplier<Item> ENSAYMADA = registerItemWithTab(UbesDelightItems.ENSAYMADA,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.ENSAYMADA)));
    public static final Supplier<Item> ENSAYMADA_UBE_RAW = registerItemWithTab(UbesDelightItems.ENSAYMADA_UBE_RAW,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.ENSAYMADA_RAW)));
    public static final Supplier<Item> ENSAYMADA_UBE = registerItemWithTab(UbesDelightItems.ENSAYMADA_UBE,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.ENSAYMADA_UBE), true));
    public static final Supplier<Item> HOPIA_MUNGGO_RAW = registerItemWithTab(UbesDelightItems.HOPIA_MUNGGO_RAW,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.HOPIA_RAW)));
    public static final Supplier<Item> HOPIA_MUNGGO = registerItemWithTab(UbesDelightItems.HOPIA_MUNGGO,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.HOPIA_MUNGGO)));
    public static final Supplier<Item> HOPIA_UBE_RAW = registerItemWithTab(UbesDelightItems.HOPIA_UBE_RAW,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.HOPIA_RAW)));
    public static final Supplier<Item> HOPIA_UBE = registerItemWithTab(UbesDelightItems.HOPIA_UBE,
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.HOPIA_UBE), true));

    public static final Supplier<Item> POLVORONE_STAGE0 = registerItem(UbesDelightItems.POLVORONE_STAGE0,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_STAGE1 = registerItem(UbesDelightItems.POLVORONE_STAGE1,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_STAGE2 = registerItem(UbesDelightItems.POLVORONE_STAGE2,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE0 = registerItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE0,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE1 = registerItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE1,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE2 = registerItem(UbesDelightItems.POLVORONE_PINIPIG_STAGE2,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_UBE_STAGE0 = registerItem(UbesDelightItems.POLVORONE_UBE_STAGE0,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_UBE_STAGE1 = registerItem(UbesDelightItems.POLVORONE_UBE_STAGE1,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_UBE_STAGE2 = registerItem(UbesDelightItems.POLVORONE_UBE_STAGE2,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_CC_STAGE0 = registerItem(UbesDelightItems.POLVORONE_CC_STAGE0,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_CC_STAGE1 = registerItem(UbesDelightItems.POLVORONE_CC_STAGE1,
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_CC_STAGE2 = registerItem(UbesDelightItems.POLVORONE_CC_STAGE2,
            () -> new Item(basicItem()));

    public static final Supplier<Item> PANDESAL_STAGE0 = registerItem(UbesDelightItems.PANDESAL_STAGE0,
            () -> new Item(basicItem()));
    public static final Supplier<Item> PANDESAL_STAGE1 = registerItem(UbesDelightItems.PANDESAL_STAGE1,
            () -> new Item(basicItem()));
    public static final Supplier<Item> PANDESAL_STAGE2 = registerItem(UbesDelightItems.PANDESAL_STAGE2,
            () -> new Item(basicItem()));
    public static final Supplier<Item> PANDESAL_UBE_STAGE0 = registerItem(UbesDelightItems.PANDESAL_UBE_STAGE0,
            () -> new Item(basicItem()));
    public static final Supplier<Item> PANDESAL_UBE_STAGE1 = registerItem(UbesDelightItems.PANDESAL_UBE_STAGE1,
            () -> new Item(basicItem()));
    public static final Supplier<Item> PANDESAL_UBE_STAGE2 = registerItem(UbesDelightItems.PANDESAL_UBE_STAGE2,
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_STAGE0 = registerItem(UbesDelightItems.ENSAYMADA_STAGE0,
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_STAGE1 = registerItem(UbesDelightItems.ENSAYMADA_STAGE1,
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_STAGE2 = registerItem(UbesDelightItems.ENSAYMADA_STAGE2,
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_STAGE3 = registerItem(UbesDelightItems.ENSAYMADA_STAGE3,
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE0 = registerItem(UbesDelightItems.ENSAYMADA_UBE_STAGE0,
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE1 = registerItem(UbesDelightItems.ENSAYMADA_UBE_STAGE1,
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE2 = registerItem(UbesDelightItems.ENSAYMADA_UBE_STAGE2,
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE3 = registerItem(UbesDelightItems.ENSAYMADA_UBE_STAGE3,
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE0 = registerItem(UbesDelightItems.HOPIA_MUNGGO_STAGE0,
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE1 = registerItem(UbesDelightItems.HOPIA_MUNGGO_STAGE1,
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE2 = registerItem(UbesDelightItems.HOPIA_MUNGGO_STAGE2,
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_UBE_STAGE0 = registerItem(UbesDelightItems.HOPIA_UBE_STAGE0,
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_UBE_STAGE1 = registerItem(UbesDelightItems.HOPIA_UBE_STAGE1,
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_UBE_STAGE2 = registerItem(UbesDelightItems.HOPIA_UBE_STAGE2,
            () -> new Item(basicItem()));

    public static Supplier<Item> registerItemWithTab(final ResourceLocation location, final Supplier<Item> supplier) {
        Supplier<Item> item = ITEMS.register(location.getPath(), supplier);
        CREATIVE_TAB_ITEMS.add(item);
        return item;
    }

    public static Supplier<Item> registerItem(final ResourceLocation location, final Supplier<Item> supplier) {
        return ITEMS.register(location.getPath(), supplier);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
