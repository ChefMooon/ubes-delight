package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.common.FoodValues;
import com.chefmooon.ubesdelight.common.item.*;
import com.chefmooon.ubesdelight.common.item.fabric.RollingPinItemImpl;
import com.chefmooon.ubesdelight.common.item.fabric.UbesDelightFuelBlockItemImpl;
import com.chefmooon.ubesdelight.common.registry.UbesDelightItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.chefmooon.ubesdelight.common.registry.UbesDelightItems.*;

public class UbesDelightItemsImpl {

    public static final Supplier<Item> KALAN = registerBlockWithTab(UbesDelightItems.KALAN, UbesDelightBlockItem::new,
            UbesDelightBlocksImpl.KALAN.get(), basicItem());
    public static final Supplier<Item> BAKING_MAT_BAMBOO = registerItemWithTab(UbesDelightItems.BAKING_MAT_BAMBOO,
            (properties) -> new UbesDelightFuelBlockItemImpl(UbesDelightBlocksImpl.BAKING_MAT_BAMBOO.get(), properties, false, false, 250),
            basicItem().useBlockDescriptionPrefix());
    public static final Supplier<Item> ROLLING_PIN_WOOD = registerItemWithTab(UbesDelightItems.ROLLING_PIN_WOOD,
            RollingPinItemImpl::new, rollingPinItem(UDToolMaterials.ROLLING_PIN_WOOD));
    public static final Supplier<Item> ROLLING_PIN_IRON = registerItemWithTab(UbesDelightItems.ROLLING_PIN_IRON,
            RollingPinItemImpl::new, rollingPinItem(ToolMaterial.IRON));
    public static final Supplier<Item> ROLLING_PIN_GOLD = registerItemWithTab(UbesDelightItems.ROLLING_PIN_GOLD,
            RollingPinItemImpl::new, rollingPinItem(ToolMaterial.GOLD));
    public static final Supplier<Item> ROLLING_PIN_DIAMOND = registerItemWithTab(UbesDelightItems.ROLLING_PIN_DIAMOND,
            RollingPinItemImpl::new, rollingPinItem(ToolMaterial.DIAMOND));
    public static final Supplier<Item> ROLLING_PIN_NETHERITE = registerItemWithTab(UbesDelightItems.ROLLING_PIN_NETHERITE,
            RollingPinItemImpl::new, rollingPinItem(ToolMaterial.NETHERITE));

    public static final Supplier<Item> WILD_UBE = registerBlockWithTab(UbesDelightItems.WILD_UBE,
            BlockItem::new, UbesDelightBlocksImpl.WILD_UBE.get(), basicItem());
    public static final Supplier<Item> WILD_GARLIC = registerBlockWithTab(UbesDelightItems.WILD_GARLIC,
            BlockItem::new, UbesDelightBlocksImpl.WILD_GARLIC.get(), basicItem());
    public static final Supplier<Item> WILD_GINGER = registerBlockWithTab(UbesDelightItems.WILD_GINGER,
            BlockItem::new, UbesDelightBlocksImpl.WILD_GINGER.get(), basicItem());
    public static final Supplier<Item> WILD_LEMONGRASS = registerBlockWithTab(UbesDelightItems.WILD_LEMONGRASS,
            BlockItem::new, UbesDelightBlocksImpl.WILD_LEMONGRASS.get(), basicItem());

    public static final Supplier<Item> UBE_CRATE = registerBlockWithTab(UbesDelightItems.UBE_CRATE,
            BlockItem::new, UbesDelightBlocksImpl.UBE_CRATE.get(), basicItem());
    public static final Supplier<Item> GARLIC_CRATE = registerBlockWithTab(UbesDelightItems.GARLIC_CRATE,
            BlockItem::new, UbesDelightBlocksImpl.GARLIC_CRATE.get(), basicItem());
    public static final Supplier<Item> GINGER_CRATE = registerBlockWithTab(UbesDelightItems.GINGER_CRATE,
            BlockItem::new, UbesDelightBlocksImpl.GINGER_CRATE.get(), basicItem());
    public static final Supplier<Item> LEMONGRASS_CRATE = registerBlockWithTab(UbesDelightItems.LEMONGRASS_CRATE,
            BlockItem::new, UbesDelightBlocksImpl.LEMONGRASS_CRATE.get(), basicItem());

    public static final Supplier<Item> UBE_CAKE = registerBlockWithTab(UbesDelightItems.UBE_CAKE,
            BlockItem::new, UbesDelightBlocksImpl.UBE_CAKE.get(), noStack());
    public static final Supplier<Item> LECHE_FLAN_FEAST = registerBlockWithTab(UbesDelightItems.LECHE_FLAN_FEAST,
            BlockItem::new, UbesDelightBlocksImpl.LECHE_FLAN_FEAST.get(), noStack());
    public static final Supplier<Item> HALO_HALO_FEAST = registerBlockWithTab(UbesDelightItems.HALO_HALO_FEAST,
            BlockItem::new, UbesDelightBlocksImpl.HALO_HALO_FEAST.get(), noStack());
    public static final Supplier<Item> MILK_TEA_UBE_FEAST = registerBlockWithTab(UbesDelightItems.MILK_TEA_UBE_FEAST,
            BlockItem::new, UbesDelightBlocksImpl.MILK_TEA_UBE_FEAST.get(), noStack());

    public static final Supplier<Item> LEAF_FEAST = registerBlockWithTab(UbesDelightItems.LEAF_FEAST,
            BlockItem::new, UbesDelightBlocksImpl.LEAF_FEAST.get(), basicItem());
    public static final Supplier<Item> LUMPIA_FEAST = registerBlockWithTab(UbesDelightItems.LUMPIA_FEAST,
            BlockItem::new, UbesDelightBlocksImpl.LUMPIA_FEAST.get(), halfLeafFeast());

    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_ENSAYMADA,
            BlockItem::new, UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_HALF = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_ENSAYMADA_HALF,
            LeafFeastItem::new, UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA.get(), halfLeafFeast().component(UbesDelightDataComponentTypesImpl.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_UBE = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE,
            BlockItem::new, UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA_UBE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_UBE_HALF = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_ENSAYMADA_UBE_HALF,
            LeafFeastItem::new, UbesDelightBlocksImpl.LEAF_FEAST_ENSAYMADA_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypesImpl.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_PANDESAL = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_PANDESAL,
            BlockItem::new, UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_PANDESAL_HALF = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_PANDESAL_HALF,
            LeafFeastItem::new, UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL.get(), halfLeafFeast().component(UbesDelightDataComponentTypesImpl.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_PANDESAL_UBE = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE,
            BlockItem::new, UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL_UBE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_PANDESAL_UBE_HALF = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_PANDESAL_UBE_HALF,
            LeafFeastItem::new, UbesDelightBlocksImpl.LEAF_FEAST_PANDESAL_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypesImpl.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_HOPIA_MUNGGO = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO,
            BlockItem::new, UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_MUNGGO.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_HOPIA_MUNGGO_HALF = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_HOPIA_MUNGGO_HALF,
            LeafFeastItem::new, UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_MUNGGO.get(), halfLeafFeast().component(UbesDelightDataComponentTypesImpl.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_HOPIA_UBE = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_HOPIA_UBE,
            BlockItem::new, UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_UBE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_HOPIA_UBE_HALF = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_HOPIA_UBE_HALF,
            LeafFeastItem::new, UbesDelightBlocksImpl.LEAF_FEAST_HOPIA_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypesImpl.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_COOKED_RICE = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_COOKED_RICE,
            BlockItem::new, UbesDelightBlocksImpl.LEAF_FEAST_COOKED_RICE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_COOKED_RICE_HALF = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_COOKED_RICE_HALF,
            LeafFeastItem::new, UbesDelightBlocksImpl.LEAF_FEAST_COOKED_RICE.get(), halfLeafFeast().component(UbesDelightDataComponentTypesImpl.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_FRIED_RICE = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_FRIED_RICE,
            BlockItem::new, UbesDelightBlocksImpl.LEAF_FEAST_FRIED_RICE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_FRIED_RICE_HALF = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_FRIED_RICE_HALF,
            LeafFeastItem::new, UbesDelightBlocksImpl.LEAF_FEAST_FRIED_RICE.get(), halfLeafFeast().component(UbesDelightDataComponentTypesImpl.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_SINANGAG = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_SINANGAG,
            BlockItem::new, UbesDelightBlocksImpl.LEAF_FEAST_SINANGAG.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_SINANGAG_HALF = registerBlockWithTab(UbesDelightItems.LEAF_FEAST_SINANGAG_HALF,
            LeafFeastItem::new, UbesDelightBlocksImpl.LEAF_FEAST_SINANGAG.get(), halfLeafFeast().component(UbesDelightDataComponentTypesImpl.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> POISONOUS_UBE = registerItemWithTab(UbesDelightItems.POISONOUS_UBE, Item::new, basicItem());
    public static final Supplier<Item> UBE = registerItemWithTab(UbesDelightItems.UBE,
            (properties) -> new BlockItem(UbesDelightBlocksImpl.UBE_CROP.get(), properties), foodItem(FoodValues.UBE));
    public static final Supplier<Item> GARLIC = registerItemWithTab(UbesDelightItems.GARLIC,
            (properties) -> new BlockItem(UbesDelightBlocksImpl.GARLIC_CROP.get(), properties), foodItem(FoodValues.GARLIC));
    public static final Supplier<Item> GINGER = registerItemWithTab(UbesDelightItems.GINGER,
            (properties) -> new BlockItem(UbesDelightBlocksImpl.GINGER_CROP.get(), properties), foodItem(FoodValues.GINGER));
    public static final Supplier<Item> LEMONGRASS = registerItemWithTab(UbesDelightItems.LEMONGRASS,
            UbesDelightConsumableItem::new, foodItem(FoodValues.LEMONGRASS));
    public static final Supplier<Item> LEMONGRASS_SEEDS = registerItemWithTab(UbesDelightItems.LEMONGRASS_SEEDS,
            (properties) -> new BlockItem(UbesDelightBlocksImpl.LEMONGRASS_STALK_CROP.get(), properties), basicItem());

    public static final Supplier<Item> CONDENSED_MILK_BOTTLE = registerItemWithTab(UbesDelightItems.CONDENSED_MILK_BOTTLE,
            (properties) -> new UbesDelightDrinkableItem(properties, true), drinkItem(FoodValues.CONDENSED_MILK_BOTTLE, FoodValues.ConsumableValues.CONDENSED_MILK_BOTTLE));
    public static final Supplier<Item> FISH_SAUCE_BOTTLE = registerItemWithTab(UbesDelightItems.FISH_SAUCE_BOTTLE,
            (properties) -> new UbesDelightDrinkableItem(properties, true), drinkItem(FoodValues.FISH_SAUCE_BOTTLE, FoodValues.ConsumableValues.FISH_SAUCE_BOTTLE));
    public static final Supplier<Item> MILK_POWDER = registerItemWithTab(UbesDelightItems.MILK_POWDER,
            Item::new, basicItem());
    public static final Supplier<Item> SUGAR_BROWN = registerItemWithTab(UbesDelightItems.SUGAR_BROWN,
            Item::new, basicItem());
    public static final Supplier<Item> LUMPIA_WRAPPER = registerItemWithTab(UbesDelightItems.LUMPIA_WRAPPER,
            Item::new, basicItem());

    public static final Supplier<Item> MILK_TEA_UBE = registerItemWithTab(UbesDelightItems.MILK_TEA_UBE,
            (properties) -> new UbesDelightDrinkableBlockItem(UbesDelightBlocksImpl.GLASS_CUP_MILK_TEA_UBE.get(), properties, true, true),
            drinkItem(FoodValues.MILK_TEA_UBE, FoodValues.ConsumableValues.MILK_TEA_UBE));
    public static final Supplier<Item> HALO_HALO = registerItemWithTab(UbesDelightItems.HALO_HALO,
            (properties) -> new UbesDelightDrinkableBlockItem(UbesDelightBlocksImpl.GLASS_CUP_HALO_HALO.get(), properties, true, true),
            drinkItem(FoodValues.HALO_HALO, FoodValues.ConsumableValues.HALO_HALO));

    public static final Supplier<Item> GARLIC_CHOP = registerItemWithTab(UbesDelightItems.GARLIC_CHOP,
            UbesDelightConsumableItem::new, foodItem(FoodValues.GARLIC_CHOP));
    public static final Supplier<Item> GINGER_CHOP = registerItemWithTab(UbesDelightItems.GINGER_CHOP,
            UbesDelightConsumableItem::new, foodItem(FoodValues.GINGER_CHOP));

    public static final Supplier<Item> SINANGAG = registerItemWithTab(UbesDelightItems.SINANGAG,
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SINANGAG, FoodValues.ConsumableValues.SINANGAG));
    public static final Supplier<Item> KINILAW = registerItemWithTab(UbesDelightItems.KINILAW,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.KINILAW, FoodValues.ConsumableValues.KINILAW));
    public static final Supplier<Item> LUMPIA = registerItemWithTab(UbesDelightItems.LUMPIA,
            Item::new, foodItem(FoodValues.LUMPIA));
    public static final Supplier<Item> TOCINO = registerItemWithTab(UbesDelightItems.TOCINO,
            Item::new, foodItem(FoodValues.TOCINO, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> CHICKEN_INASAL = registerItemWithTab(UbesDelightItems.CHICKEN_INASAL,
            Item::new, foodItem(FoodValues.CHICKEN_INASAL, FoodValues.ConsumableValues.FAST_FOOD));

    public static final Supplier<Item> CHICKEN_INASAL_RICE = registerItemWithTab(UbesDelightItems.CHICKEN_INASAL_RICE,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.CHICKEN_INASAL_RICE, FoodValues.ConsumableValues.CHICKEN_INASAL_RICE));
    public static final Supplier<Item> TOSILOG = registerItemWithTab(UbesDelightItems.TOSILOG,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.TOSILOG, FoodValues.ConsumableValues.TOSILOG));
    public static final Supplier<Item> BANGSILOG = registerItemWithTab(UbesDelightItems.BANGSILOG,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.BANGSILOG, FoodValues.ConsumableValues.BANGSILOG));
    public static final Supplier<Item> SISIG = registerItemWithTab(UbesDelightItems.SISIG,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SISIG, FoodValues.ConsumableValues.SISIG));
    public static final Supplier<Item> BULALO = registerItemWithTab(UbesDelightItems.BULALO,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.BULALO, FoodValues.ConsumableValues.BULALO));
    public static final Supplier<Item> ARROZ_CALDO = registerItemWithTab(UbesDelightItems.ARROZ_CALDO,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.ARROZ_CALDO, FoodValues.ConsumableValues.ARROZ_CALDO));
    public static final Supplier<Item> MECHADO = registerItemWithTab(UbesDelightItems.MECHADO,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.MECHADO, FoodValues.ConsumableValues.MECHADO));

    public static final Supplier<Item> COOKIE_UBE = registerItemWithTab(UbesDelightItems.COOKIE_UBE,
            UbesDelightConsumableItem::new, foodItem(FoodValues.COOKIES, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> COOKIE_GINGER = registerItemWithTab(UbesDelightItems.COOKIE_GINGER,
            UbesDelightConsumableItem::new, foodItem(FoodValues.COOKIES, FoodValues.ConsumableValues.FAST_FOOD));

    public static final Supplier<Item> LECHE_FLAN = registerItemWithTab(UbesDelightItems.LECHE_FLAN,
            Item::new, foodItem(FoodValues.LECHE_FLAN));
    public static final Supplier<Item> UBE_CAKE_SLICE = registerItemWithTab(UbesDelightItems.UBE_CAKE_SLICE,
            UbesDelightConsumableItem::new, foodItem(FoodValues.UBE_CAKE_SLICE, FoodValues.ConsumableValues.UBE_CAKE_SLICE));

    public static final Supplier<Item> RAW_POLVORONE = registerItemWithTab(UbesDelightItems.RAW_POLVORONE,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE = registerItemWithTab(UbesDelightItems.POLVORONE,
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> RAW_POLVORONE_PINIPIG = registerItemWithTab(UbesDelightItems.RAW_POLVORONE_PINIPIG,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG = registerItemWithTab(UbesDelightItems.POLVORONE_PINIPIG,
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> RAW_POLVORONE_UBE = registerItemWithTab(UbesDelightItems.RAW_POLVORONE_UBE,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE = registerItemWithTab(UbesDelightItems.POLVORONE_UBE,
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> RAW_POLVORONE_CC = registerItemWithTab(UbesDelightItems.RAW_POLVORONE_CC,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC = registerItemWithTab(UbesDelightItems.POLVORONE_CC,
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));

    public static final Supplier<Item> PANDESAL_RAW = registerItemWithTab(UbesDelightItems.PANDESAL_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.PANDESAL_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> PANDESAL = registerItemWithTab(UbesDelightItems.PANDESAL,
            UbesDelightLeafFeastConsumableItem::new, foodItem(FoodValues.PANDESAL));
    public static final Supplier<Item> PANDESAL_UBE_RAW = registerItemWithTab(UbesDelightItems.PANDESAL_UBE_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.PANDESAL_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> PANDESAL_UBE = registerItemWithTab(UbesDelightItems.PANDESAL_UBE,
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            foodItem(FoodValues.PANDESAL_UBE, FoodValues.ConsumableValues.PASTRY_UBE));
    public static final Supplier<Item> ENSAYMADA_RAW = registerItemWithTab(UbesDelightItems.ENSAYMADA_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.ENSAYMADA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> ENSAYMADA = registerItemWithTab(UbesDelightItems.ENSAYMADA,
            UbesDelightLeafFeastConsumableItem::new, foodItem(FoodValues.ENSAYMADA));
    public static final Supplier<Item> ENSAYMADA_UBE_RAW = registerItemWithTab(UbesDelightItems.ENSAYMADA_UBE_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.ENSAYMADA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> ENSAYMADA_UBE = registerItemWithTab(UbesDelightItems.ENSAYMADA_UBE,
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            foodItem(FoodValues.ENSAYMADA_UBE, FoodValues.ConsumableValues.PASTRY_UBE));
    public static final Supplier<Item> HOPIA_MUNGGO_RAW = registerItemWithTab(UbesDelightItems.HOPIA_MUNGGO_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.HOPIA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> HOPIA_MUNGGO = registerItemWithTab(UbesDelightItems.HOPIA_MUNGGO,
            UbesDelightLeafFeastConsumableItem::new, foodItem(FoodValues.HOPIA_MUNGGO));
    public static final Supplier<Item> HOPIA_UBE_RAW = registerItemWithTab(UbesDelightItems.HOPIA_UBE_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.HOPIA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> HOPIA_UBE = registerItemWithTab(UbesDelightItems.HOPIA_UBE,
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            foodItem(FoodValues.HOPIA_UBE, FoodValues.ConsumableValues.PASTRY_UBE));

    public static final Supplier<Item> POLVORONE_STAGE0 = registerItemNoTab(UbesDelightItems.POLVORONE_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_STAGE1 = registerItemNoTab(UbesDelightItems.POLVORONE_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_STAGE2 = registerItemNoTab(UbesDelightItems.POLVORONE_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE0 = registerItemNoTab(UbesDelightItems.POLVORONE_PINIPIG_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE1 = registerItemNoTab(UbesDelightItems.POLVORONE_PINIPIG_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE2 = registerItemNoTab(UbesDelightItems.POLVORONE_PINIPIG_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE_STAGE0 = registerItemNoTab(UbesDelightItems.POLVORONE_UBE_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE_STAGE1 = registerItemNoTab(UbesDelightItems.POLVORONE_UBE_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE_STAGE2 = registerItemNoTab(UbesDelightItems.POLVORONE_UBE_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC_STAGE0 = registerItemNoTab(UbesDelightItems.POLVORONE_CC_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC_STAGE1 = registerItemNoTab(UbesDelightItems.POLVORONE_CC_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC_STAGE2 = registerItemNoTab(UbesDelightItems.POLVORONE_CC_STAGE2,
            Item::new, basicItem());

    public static final Supplier<Item> PANDESAL_STAGE0 = registerItemNoTab(UbesDelightItems.PANDESAL_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_STAGE1 = registerItemNoTab(UbesDelightItems.PANDESAL_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_STAGE2 = registerItemNoTab(UbesDelightItems.PANDESAL_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_UBE_STAGE0 = registerItemNoTab(UbesDelightItems.PANDESAL_UBE_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_UBE_STAGE1 = registerItemNoTab(UbesDelightItems.PANDESAL_UBE_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_UBE_STAGE2 = registerItemNoTab(UbesDelightItems.PANDESAL_UBE_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE0 = registerItemNoTab(UbesDelightItems.ENSAYMADA_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE1 = registerItemNoTab(UbesDelightItems.ENSAYMADA_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE2 = registerItemNoTab(UbesDelightItems.ENSAYMADA_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE3 = registerItemNoTab(UbesDelightItems.ENSAYMADA_STAGE3,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE0 = registerItemNoTab(UbesDelightItems.ENSAYMADA_UBE_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE1 = registerItemNoTab(UbesDelightItems.ENSAYMADA_UBE_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE2 = registerItemNoTab(UbesDelightItems.ENSAYMADA_UBE_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE3 = registerItemNoTab(UbesDelightItems.ENSAYMADA_UBE_STAGE3,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE0 = registerItemNoTab(UbesDelightItems.HOPIA_MUNGGO_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE1 = registerItemNoTab(UbesDelightItems.HOPIA_MUNGGO_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE2 = registerItemNoTab(UbesDelightItems.HOPIA_MUNGGO_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_UBE_STAGE0 = registerItemNoTab(UbesDelightItems.HOPIA_UBE_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_UBE_STAGE1 = registerItemNoTab(UbesDelightItems.HOPIA_UBE_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_UBE_STAGE2 = registerItemNoTab(UbesDelightItems.HOPIA_UBE_STAGE2,
            Item::new, basicItem());

    public static Supplier<Item> registerItemWithTab(final ResourceLocation location, final Function<Item.Properties, Item> function, final Item.Properties properties) {
        properties.setId(ResourceKey.create(Registries.ITEM, location));
        Supplier<Item> item = registerItemNoTab(location, () -> function.apply(properties));
        ItemGroupEvents.modifyEntriesEvent(UbesDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item.get()));
        return item;
    }

    public static Supplier<Item> registerBlockWithTab(final ResourceLocation location, final BiFunction<Block, Item.Properties, Item> function, final Block block, final Item.Properties properties) {
        properties.setId(ResourceKey.create(Registries.ITEM, location));
        properties.useBlockDescriptionPrefix();
        Supplier<Item> item = registerItemNoTab(location, () -> function.apply(block, properties));
        ItemGroupEvents.modifyEntriesEvent(UbesDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item.get()));
        return item;
    }

    private static Supplier<Item> registerItemNoTab(final ResourceLocation location, final Function<Item.Properties, Item> function, final Item.Properties properties) {
        properties.setId(ResourceKey.create(Registries.ITEM, location));
        return registerItemNoTab(location, () -> function.apply(properties));
    }

    private static <T extends Item> Supplier<T> registerItemNoTab(ResourceLocation location, Supplier<T> supplier) {
        T object = supplier.get();
        Registry.register(BuiltInRegistries.ITEM, location, object);
        return () -> object;
    }

//    public static Item registerItemWithTab(final ResourceLocation location, final Item item) {
//        Registry.register(BuiltInRegistries.ITEM, location, item);
//        ItemGroupEvents.modifyEntriesEvent(UbesDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item));
//        return item;
//    }
//
//    public static Item registerItem(final ResourceLocation location, final Item item) {
//        Registry.register(BuiltInRegistries.ITEM, location, item);
//        return item;
//    }

    public static void register() {

    }
}
