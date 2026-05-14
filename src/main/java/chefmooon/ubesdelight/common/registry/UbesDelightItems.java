package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.FoodValues;
import chefmooon.ubesdelight.common.item.*;
import chefmooon.ubesdelight.common.item.tiers.UDTiers;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

import java.util.function.Supplier;

public class UbesDelightItems {

    public static Item.Properties basicItem() {
        return new Item.Properties();
    }

    public static Item.Properties rollingPinItem(Tier tier) {
        return new Item.Properties().attributes(RollingPinItem.createAttributes(tier, 1.0F, -2.0F));
    }

    public static Item.Properties noStack() {
        return new Item.Properties().stacksTo(1);
    }

    public static Item.Properties leafFeast() {
        return basicItem().stacksTo(8);
    }

    public static Item.Properties halfLeafFeast() {
        return basicItem().stacksTo(16);
    }

    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }

    public static Item.Properties drinkItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }

    public static final Supplier<Item> KALAN = registerItemWithTab("kalan",
            () -> new UbesDelightBlockItem(UbesDelightBlocks.KALAN.get(), basicItem()));
    public static final Supplier<Item> BAKING_MAT_BAMBOO = registerItemWithTab("baking_mat_bamboo",
            () -> new UbesDelightFuelBlockItem(UbesDelightBlocks.BAKING_MAT_BAMBOO.get(), basicItem(), false, false, 250));
    public static final Supplier<Item> ROLLING_PIN_WOOD = registerItemWithTab("rolling_pin_wood",
            () -> new RollingPinItem(UDTiers.ROLLING_PIN_WOOD, rollingPinItem(UDTiers.ROLLING_PIN_WOOD)));
    public static final Supplier<Item> ROLLING_PIN_IRON = registerItemWithTab("rolling_pin_iron",
            () -> new RollingPinItem(Tiers.IRON, rollingPinItem(Tiers.IRON)));
    public static final Supplier<Item> ROLLING_PIN_GOLD = registerItemWithTab("rolling_pin_gold",
            () -> new RollingPinItem(Tiers.GOLD, rollingPinItem(Tiers.GOLD)));
    public static final Supplier<Item> ROLLING_PIN_DIAMOND = registerItemWithTab("rolling_pin_diamond",
            () -> new RollingPinItem(Tiers.DIAMOND, rollingPinItem(Tiers.DIAMOND)));
    public static final Supplier<Item> ROLLING_PIN_NETHERITE = registerItemWithTab("rolling_pin_netherite",
            () -> new RollingPinItem(Tiers.NETHERITE, rollingPinItem(Tiers.NETHERITE)));

    public static final Supplier<Item> WILD_UBE = registerItemWithTab("wild_ube",
            () -> new BlockItem(UbesDelightBlocks.WILD_UBE.get(), basicItem()));
    public static final Supplier<Item> WILD_GARLIC = registerItemWithTab("wild_garlic",
            () -> new BlockItem(UbesDelightBlocks.WILD_GARLIC.get(), basicItem()));
    public static final Supplier<Item> WILD_GINGER = registerItemWithTab("wild_ginger",
            () -> new BlockItem(UbesDelightBlocks.WILD_GINGER.get(), basicItem()));
    public static final Supplier<Item> WILD_LEMONGRASS = registerItemWithTab("wild_lemongrass",
            () -> new BlockItem(UbesDelightBlocks.WILD_LEMONGRASS.get(), basicItem()));

    public static final Supplier<Item> UBE_CRATE = registerItemWithTab("ube_crate",
            () -> new BlockItem(UbesDelightBlocks.UBE_CRATE.get(), basicItem()));
    public static final Supplier<Item> GARLIC_CRATE = registerItemWithTab("garlic_crate",
            () -> new BlockItem(UbesDelightBlocks.GARLIC_CRATE.get(), basicItem()));
    public static final Supplier<Item> GINGER_CRATE = registerItemWithTab("ginger_crate",
            () -> new BlockItem(UbesDelightBlocks.GINGER_CRATE.get(), basicItem()));
    public static final Supplier<Item> LEMONGRASS_CRATE = registerItemWithTab("lemongrass_crate",
            () -> new BlockItem(UbesDelightBlocks.LEMONGRASS_CRATE.get(), basicItem()));

    public static final Supplier<Item> UBE_CAKE = registerItemWithTab("ube_cake",
            () -> new BlockItem(UbesDelightBlocks.UBE_CAKE.get(), noStack()));
    public static final Supplier<Item> LECHE_FLAN_FEAST = registerItemWithTab("leche_flan_feast",
            () -> new BlockItem(UbesDelightBlocks.LECHE_FLAN_FEAST.get(), noStack()));
    public static final Supplier<Item> HALO_HALO_FEAST = registerItemWithTab("halo_halo_feast",
            () -> new BlockItem(UbesDelightBlocks.HALO_HALO_FEAST.get(), noStack()));
    public static final Supplier<Item> MILK_TEA_UBE_FEAST = registerItemWithTab("milk_tea_ube_feast",
            () -> new BlockItem(UbesDelightBlocks.MILK_TEA_UBE_FEAST.get(), noStack()));

    public static final Supplier<Item> LEAF_FEAST = registerItemWithTab("leaf_feast",
            () -> new BlockItem(UbesDelightBlocks.LEAF_FEAST.get(), basicItem()));
    public static final Supplier<Item> LUMPIA_FEAST = registerItemWithTab("lumpia_feast",
            () -> new BlockItem(UbesDelightBlocks.LUMPIA_FEAST.get(), halfLeafFeast()));

    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA = registerItemWithTab("leaf_feast_ensaymada",
            () -> new BlockItem(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA.get(), leafFeast()));
    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_HALF = registerItemWithTab("leaf_feast_ensaymada_half",
            () -> new LeafFeastItem(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3)));

    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_UBE = registerItemWithTab("leaf_feast_ensaymada_ube",
            () -> new BlockItem(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE.get(), leafFeast()));
    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_UBE_HALF = registerItemWithTab("leaf_feast_ensaymada_ube_half",
            () -> new LeafFeastItem(UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3)));

    public static final Supplier<Item> LEAF_FEAST_PANDESAL = registerItemWithTab("leaf_feast_pandesal",
            () -> new BlockItem(UbesDelightBlocks.LEAF_FEAST_PANDESAL.get(), leafFeast()));
    public static final Supplier<Item> LEAF_FEAST_PANDESAL_HALF = registerItemWithTab("leaf_feast_pandesal_half",
            () -> new LeafFeastItem(UbesDelightBlocks.LEAF_FEAST_PANDESAL.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3)));

    public static final Supplier<Item> LEAF_FEAST_PANDESAL_UBE = registerItemWithTab("leaf_feast_pandesal_ube",
            () -> new BlockItem(UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE.get(), leafFeast()));
    public static final Supplier<Item> LEAF_FEAST_PANDESAL_UBE_HALF = registerItemWithTab("leaf_feast_pandesal_ube_half",
            () -> new LeafFeastItem(UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3)));

    public static final Supplier<Item> LEAF_FEAST_HOPIA_MUNGGO = registerItemWithTab("leaf_feast_hopia_munggo",
            () -> new BlockItem(UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO.get(), leafFeast()));
    public static final Supplier<Item> LEAF_FEAST_HOPIA_MUNGGO_HALF = registerItemWithTab("leaf_feast_hopia_munggo_half",
            () -> new LeafFeastItem(UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3)));

    public static final Supplier<Item> LEAF_FEAST_HOPIA_UBE = registerItemWithTab("leaf_feast_hopia_ube",
            () -> new BlockItem(UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE.get(), leafFeast()));
    public static final Supplier<Item> LEAF_FEAST_HOPIA_UBE_HALF = registerItemWithTab("leaf_feast_hopia_ube_half",
            () -> new LeafFeastItem(UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3)));

    public static final Supplier<Item> LEAF_FEAST_COOKED_RICE = registerItemWithTab("leaf_feast_cooked_rice",
            () -> new BlockItem(UbesDelightBlocks.LEAF_FEAST_COOKED_RICE.get(), leafFeast()));
    public static final Supplier<Item> LEAF_FEAST_COOKED_RICE_HALF = registerItemWithTab("leaf_feast_cooked_rice_half",
            () -> new LeafFeastItem(UbesDelightBlocks.LEAF_FEAST_COOKED_RICE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3)));

    public static final Supplier<Item> LEAF_FEAST_FRIED_RICE = registerItemWithTab("leaf_feast_fried_rice",
            () -> new BlockItem(UbesDelightBlocks.LEAF_FEAST_FRIED_RICE.get(), leafFeast()));
    public static final Supplier<Item> LEAF_FEAST_FRIED_RICE_HALF = registerItemWithTab("leaf_feast_fried_rice_half",
            () -> new LeafFeastItem(UbesDelightBlocks.LEAF_FEAST_FRIED_RICE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3)));

    public static final Supplier<Item> LEAF_FEAST_SINANGAG = registerItemWithTab("leaf_feast_sinangag",
            () -> new BlockItem(UbesDelightBlocks.LEAF_FEAST_SINANGAG.get(), leafFeast()));
    public static final Supplier<Item> LEAF_FEAST_SINANGAG_HALF = registerItemWithTab("leaf_feast_sinangag_half",
            () -> new LeafFeastItem(UbesDelightBlocks.LEAF_FEAST_SINANGAG.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3)));

    public static final Supplier<Item> POISONOUS_UBE = registerItemWithTab("poisonous_ube",
            () -> new Item(basicItem()));
    public static final Supplier<Item> UBE = registerItemWithTab("ube",
            () -> new ItemNameBlockItem(UbesDelightBlocks.UBE_CROP.get(), foodItem(FoodValues.UBE)));
    public static final Supplier<Item> GARLIC = registerItemWithTab("garlic",
            () -> new ItemNameBlockItem(UbesDelightBlocks.GARLIC_CROP.get(), foodItem(FoodValues.GARLIC)));
    public static final Supplier<Item> GINGER = registerItemWithTab("ginger",
            () -> new ItemNameBlockItem(UbesDelightBlocks.GINGER_CROP.get(), foodItem(FoodValues.GINGER)));
    public static final Supplier<Item> LEMONGRASS = registerItemWithTab("lemongrass",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.LEMONGRASS)));
    public static final Supplier<Item> LEMONGRASS_SEEDS = registerItemWithTab("lemongrass_seeds",
            () -> new ItemNameBlockItem(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), basicItem()));

    public static final Supplier<Item> CONDENSED_MILK_BOTTLE = registerItemWithTab("condensed_milk_bottle",
            () -> new UbesDelightDrinkableItem(drinkItem(FoodValues.CONDENSED_MILK_BOTTLE), true));
    public static final Supplier<Item> FISH_SAUCE_BOTTLE = registerItemWithTab("fish_sauce_bottle",
            () -> new UbesDelightDrinkableItem(drinkItem(FoodValues.FISH_SAUCE_BOTTLE), true));
    public static final Supplier<Item> MILK_POWDER = registerItemWithTab("milk_powder",
            () -> new Item(basicItem()));
    public static final Supplier<Item> SUGAR_BROWN = registerItemWithTab("sugar_brown",
            () -> new Item(basicItem()));
    public static final Supplier<Item> LUMPIA_WRAPPER = registerItemWithTab("lumpia_wrapper",
            () -> new Item(basicItem()));

    public static final Supplier<Item> MILK_TEA_UBE = registerItemWithTab("milk_tea_ube",
            () -> new UbesDelightDrinkableBlockItem(UbesDelightBlocks.GLASS_CUP_MILK_TEA_UBE.get(), drinkItem(FoodValues.MILK_TEA_UBE), true, true));
    public static final Supplier<Item> HALO_HALO = registerItemWithTab("halo_halo",
            () -> new UbesDelightDrinkableBlockItem(UbesDelightBlocks.GLASS_CUP_HALO_HALO.get(), drinkItem(FoodValues.HALO_HALO), true, true));

    public static final Supplier<Item> GARLIC_CHOP = registerItemWithTab("garlic_chop",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.GARLIC_CHOP)));
    public static final Supplier<Item> GINGER_CHOP = registerItemWithTab("ginger_chop",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.GINGER_CHOP)));

    public static final Supplier<Item> SINANGAG = registerItemWithTab("sinangag",
            () -> new UbesDelightLeafFeastConsumableItem(bowlFoodItem(FoodValues.SINANGAG), true));
    public static final Supplier<Item> KINILAW = registerItemWithTab("kinilaw",
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.KINILAW), true));
    public static final Supplier<Item> LUMPIA = registerItemWithTab("lumpia",
            () -> new Item(foodItem(FoodValues.LUMPIA)));
    public static final Supplier<Item> TOCINO = registerItemWithTab("tocino",
            () -> new Item(foodItem(FoodValues.TOCINO)));
    public static final Supplier<Item> CHICKEN_INASAL = registerItemWithTab("chicken_inasal",
            () -> new Item(foodItem(FoodValues.CHICKEN_INASAL)));

    public static final Supplier<Item> CHICKEN_INASAL_RICE = registerItemWithTab("chicken_inasal_rice",
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.CHICKEN_INASAL_RICE), true));
    public static final Supplier<Item> TOSILOG = registerItemWithTab("tosilog",
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.TOSILOG), true));
    public static final Supplier<Item> BANGSILOG = registerItemWithTab("bangsilog",
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.BANGSILOG), true));
    public static final Supplier<Item> SISIG = registerItemWithTab("sisig",
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.SISIG), true));
    public static final Supplier<Item> BULALO = registerItemWithTab("bulalo",
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.BULALO), true));
    public static final Supplier<Item> ARROZ_CALDO = registerItemWithTab("arroz_caldo",
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.ARROZ_CALDO), true));
    public static final Supplier<Item> MECHADO = registerItemWithTab("mechado",
            () -> new UbesDelightConsumableItem(bowlFoodItem(FoodValues.MECHADO), true));

    public static final Supplier<Item> COOKIE_UBE = registerItemWithTab("cookie_ube",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.COOKIES)));
    public static final Supplier<Item> COOKIE_GINGER = registerItemWithTab("cookie_ginger",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.COOKIES)));

    public static final Supplier<Item> LECHE_FLAN = registerItemWithTab("leche_flan",
            () -> new Item(foodItem(FoodValues.LECHE_FLAN)));
    public static final Supplier<Item> UBE_CAKE_SLICE = registerItemWithTab("ube_cake_slice",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.UBE_CAKE_SLICE)));

    public static final Supplier<Item> RAW_POLVORONE = registerItemWithTab("raw_polvorone",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE = registerItemWithTab("polvorone",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.POLVORONE)));
    public static final Supplier<Item> RAW_POLVORONE_PINIPIG = registerItemWithTab("raw_polvorone_pinipig",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_PINIPIG = registerItemWithTab("polvorone_pinipig",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.POLVORONE)));
    public static final Supplier<Item> RAW_POLVORONE_UBE = registerItemWithTab("raw_polvorone_ube",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_UBE = registerItemWithTab("polvorone_ube",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.POLVORONE)));
    public static final Supplier<Item> RAW_POLVORONE_CC = registerItemWithTab("raw_polvorone_cc",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_CC = registerItemWithTab("polvorone_cc",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.POLVORONE)));

    public static final Supplier<Item> PANDESAL_RAW = registerItemWithTab("pandesal_raw",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.PANDESAL_RAW)));
    public static final Supplier<Item> PANDESAL = registerItemWithTab("pandesal",
            () -> new UbesDelightLeafFeastConsumableItem(foodItem(FoodValues.PANDESAL)));
    public static final Supplier<Item> PANDESAL_UBE_RAW = registerItemWithTab("pandesal_ube_raw",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.PANDESAL_RAW)));
    public static final Supplier<Item> PANDESAL_UBE = registerItemWithTab("pandesal_ube",
            () -> new UbesDelightLeafFeastConsumableItem(foodItem(FoodValues.PANDESAL_UBE), true));
    public static final Supplier<Item> ENSAYMADA_RAW = registerItemWithTab("ensaymada_raw",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.ENSAYMADA_RAW)));
    public static final Supplier<Item> ENSAYMADA = registerItemWithTab("ensaymada",
            () -> new UbesDelightLeafFeastConsumableItem(foodItem(FoodValues.ENSAYMADA)));
    public static final Supplier<Item> ENSAYMADA_UBE_RAW = registerItemWithTab("ensaymada_ube_raw",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.ENSAYMADA_RAW)));
    public static final Supplier<Item> ENSAYMADA_UBE = registerItemWithTab("ensaymada_ube",
            () -> new UbesDelightLeafFeastConsumableItem(foodItem(FoodValues.ENSAYMADA_UBE), true));
    public static final Supplier<Item> HOPIA_MUNGGO_RAW = registerItemWithTab("hopia_munggo_raw",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.HOPIA_RAW)));
    public static final Supplier<Item> HOPIA_MUNGGO = registerItemWithTab("hopia_munggo",
            () -> new UbesDelightLeafFeastConsumableItem(foodItem(FoodValues.HOPIA_MUNGGO)));
    public static final Supplier<Item> HOPIA_UBE_RAW = registerItemWithTab("hopia_ube_raw",
            () -> new UbesDelightConsumableItem(foodItem(FoodValues.HOPIA_RAW)));
    public static final Supplier<Item> HOPIA_UBE = registerItemWithTab("hopia_ube",
            () -> new UbesDelightLeafFeastConsumableItem(foodItem(FoodValues.HOPIA_UBE), true));

    public static final Supplier<Item> POLVORONE_STAGE0 = registerItem("polvorone_stage0",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_STAGE1 = registerItem("polvorone_stage1",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_STAGE2 = registerItem("polvorone_stage2",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE0 = registerItem("polvorone_pinipig_stage0",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE1 = registerItem("polvorone_pinipig_stage1",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE2 = registerItem("polvorone_pinipig_stage2",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_UBE_STAGE0 = registerItem("polvorone_ube_stage0",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_UBE_STAGE1 = registerItem("polvorone_ube_stage1",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_UBE_STAGE2 = registerItem("polvorone_ube_stage2",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_CC_STAGE0 = registerItem("polvorone_cc_stage0",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_CC_STAGE1 = registerItem("polvorone_cc_stage1",
            () -> new Item(basicItem()));
    public static final Supplier<Item> POLVORONE_CC_STAGE2 = registerItem("polvorone_cc_stage2",
            () -> new Item(basicItem()));

    public static final Supplier<Item> PANDESAL_STAGE0 = registerItem("pandesal_stage0",
            () -> new Item(basicItem()));
    public static final Supplier<Item> PANDESAL_STAGE1 = registerItem("pandesal_stage1",
            () -> new Item(basicItem()));
    public static final Supplier<Item> PANDESAL_STAGE2 = registerItem("pandesal_stage2",
            () -> new Item(basicItem()));
    public static final Supplier<Item> PANDESAL_UBE_STAGE0 = registerItem("pandesal_ube_stage0",
            () -> new Item(basicItem()));
    public static final Supplier<Item> PANDESAL_UBE_STAGE1 = registerItem("pandesal_ube_stage1",
            () -> new Item(basicItem()));
    public static final Supplier<Item> PANDESAL_UBE_STAGE2 = registerItem("pandesal_ube_stage2",
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_STAGE0 = registerItem("ensaymada_stage0",
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_STAGE1 = registerItem("ensaymada_stage1",
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_STAGE2 = registerItem("ensaymada_stage2",
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_STAGE3 = registerItem("ensaymada_stage3",
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE0 = registerItem("ensaymada_ube_stage0",
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE1 = registerItem("ensaymada_ube_stage1",
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE2 = registerItem("ensaymada_ube_stage2",
            () -> new Item(basicItem()));
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE3 = registerItem("ensaymada_ube_stage3",
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE0 = registerItem("hopia_munggo_stage0",
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE1 = registerItem("hopia_munggo_stage1",
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE2 = registerItem("hopia_munggo_stage2",
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_UBE_STAGE0 = registerItem("hopia_ube_stage0",
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_UBE_STAGE1 = registerItem("hopia_ube_stage1",
            () -> new Item(basicItem()));
    public static final Supplier<Item> HOPIA_UBE_STAGE2 = registerItem("hopia_ube_stage2",
            () -> new Item(basicItem()));

    public static Supplier<Item> registerItemWithTab(final String location, final Supplier<Item> itemSupplier) {
        Item item = itemSupplier.get();
        Registry.register(BuiltInRegistries.ITEM, TextUtils.res(location), item);
        ItemGroupEvents.modifyEntriesEvent(UbesDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item));
        return () -> item;
    }

    public static Supplier<Item> registerItem(final String location, final Supplier<Item> itemSupplier) {
        Item item = itemSupplier.get();
        Registry.register(BuiltInRegistries.ITEM, TextUtils.res(location), item);
        return () -> item;
    }

    public static void register() {
    }

    private static ResourceLocation item(String string) {
        return TextUtils.res(string);
    }

}
