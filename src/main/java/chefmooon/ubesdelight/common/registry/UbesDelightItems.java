package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.FoodValues;
import chefmooon.ubesdelight.common.item.*;
import chefmooon.ubesdelight.common.utility.RegistrationUtils;
import chefmooon.ubesdelight.common.utility.TextUtils;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class UbesDelightItems {

    public static Item.Properties basicItem() {
        return new Item.Properties();
    }

    public static Item.Properties rollingPinItem(ToolMaterial toolMaterial) {
        HolderGetter<Block> holderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return new Item.Properties()
                .durability(toolMaterial.durability())
                .repairable(toolMaterial.repairItems())
                .enchantable(toolMaterial.enchantmentValue())
                .attributes(RollingPinItem.createAttributes(toolMaterial, 1.0F, -2.0F))
                .component(DataComponents.TOOL, new Tool(
                        List.of(Tool.Rule.deniesDrops(holderGetter.getOrThrow(toolMaterial.incorrectBlocksForDrops()))), 1.0F, 1, false))
                .component(DataComponents.WEAPON, new Weapon(1));
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
        return foodItem(food, null);
    }
    public static Item.Properties foodItem(FoodProperties food, @Nullable Consumable consumable) {
        return new Item.Properties().food(food)
                .component(DataComponents.CONSUMABLE, consumable != null ? consumable : Consumables.DEFAULT_FOOD);
    }

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return bowlFoodItem(food, null);
    }
    public static Item.Properties bowlFoodItem(FoodProperties food, @Nullable Consumable consumable) {
        return new Item.Properties().food(food)
                .component(DataComponents.CONSUMABLE, consumable != null ? consumable : Consumables.DEFAULT_FOOD)
                .craftRemainder(Items.BOWL).stacksTo(16);
    }

    public static Item.Properties drinkItem(FoodProperties food) {
        return drinkItem(food, null);
    }
    public static Item.Properties drinkItem(FoodProperties food, @Nullable Consumable consumable) {
        return new Item.Properties().food(food)
                .component(DataComponents.CONSUMABLE, consumable != null ? consumable : Consumables.DEFAULT_FOOD)
                .craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }

    public static final Supplier<Item> KALAN = registerBlockWithTab("kalan", UbesDelightBlockItem::new,
            UbesDelightBlocks.KALAN.get(), basicItem());
    public static final Supplier<Item> BAKING_MAT_BAMBOO = registerItemWithTab("baking_mat_bamboo",
            (properties) -> new UbesDelightFuelBlockItem(UbesDelightBlocks.BAKING_MAT_BAMBOO.get(), properties, false, false, 250),
            basicItem().useBlockDescriptionPrefix());
    public static final Supplier<Item> ROLLING_PIN_WOOD = registerItemWithTab("rolling_pin_wood",
            RollingPinItem::new, rollingPinItem(UDToolMaterials.ROLLING_PIN_WOOD));
    public static final Supplier<Item> ROLLING_PIN_IRON = registerItemWithTab("rolling_pin_iron",
            RollingPinItem::new, rollingPinItem(ToolMaterial.IRON));
    public static final Supplier<Item> ROLLING_PIN_GOLD = registerItemWithTab("rolling_pin_gold",
            RollingPinItem::new, rollingPinItem(ToolMaterial.GOLD));
    public static final Supplier<Item> ROLLING_PIN_DIAMOND = registerItemWithTab("rolling_pin_diamond",
            RollingPinItem::new, rollingPinItem(ToolMaterial.DIAMOND));
    public static final Supplier<Item> ROLLING_PIN_NETHERITE = registerItemWithTab("rolling_pin_netherite",
            RollingPinItem::new, rollingPinItem(ToolMaterial.NETHERITE));

    public static final Supplier<Item> WILD_UBE = registerBlockWithTab("wild_ube",
            BlockItem::new, UbesDelightBlocks.WILD_UBE.get(), basicItem());
    public static final Supplier<Item> WILD_GARLIC = registerBlockWithTab("wild_garlic",
            BlockItem::new, UbesDelightBlocks.WILD_GARLIC.get(), basicItem());
    public static final Supplier<Item> WILD_GINGER = registerBlockWithTab("wild_ginger",
            BlockItem::new, UbesDelightBlocks.WILD_GINGER.get(), basicItem());
    public static final Supplier<Item> WILD_LEMONGRASS = registerBlockWithTab("wild_lemongrass",
            BlockItem::new, UbesDelightBlocks.WILD_LEMONGRASS.get(), basicItem());

    public static final Supplier<Item> UBE_CRATE = registerBlockWithTab("ube_crate",
            BlockItem::new, UbesDelightBlocks.UBE_CRATE.get(), basicItem());
    public static final Supplier<Item> GARLIC_CRATE = registerBlockWithTab("garlic_crate",
            BlockItem::new, UbesDelightBlocks.GARLIC_CRATE.get(), basicItem());
    public static final Supplier<Item> GINGER_CRATE = registerBlockWithTab("ginger_crate",
            BlockItem::new, UbesDelightBlocks.GINGER_CRATE.get(), basicItem());
    public static final Supplier<Item> LEMONGRASS_CRATE = registerBlockWithTab("lemongrass_crate",
            BlockItem::new, UbesDelightBlocks.LEMONGRASS_CRATE.get(), basicItem());

    public static final Supplier<Item> UBE_CAKE = registerBlockWithTab("ube_cake",
            BlockItem::new, UbesDelightBlocks.UBE_CAKE.get(), noStack());
    public static final Supplier<Item> LECHE_FLAN_FEAST = registerBlockWithTab("leche_flan_feast",
            BlockItem::new, UbesDelightBlocks.LECHE_FLAN_FEAST.get(), noStack());
    public static final Supplier<Item> HALO_HALO_FEAST = registerBlockWithTab("halo_halo_feast",
            BlockItem::new, UbesDelightBlocks.HALO_HALO_FEAST.get(), noStack());
    public static final Supplier<Item> MILK_TEA_UBE_FEAST = registerBlockWithTab("milk_tea_ube_feast",
            BlockItem::new, UbesDelightBlocks.MILK_TEA_UBE_FEAST.get(), noStack());

    public static final Supplier<Item> LEAF_FEAST = registerBlockWithTab("leaf_feast",
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST.get(), basicItem());
    public static final Supplier<Item> LUMPIA_FEAST = registerBlockWithTab("lumpia_feast",
            BlockItem::new, UbesDelightBlocks.LUMPIA_FEAST.get(), halfLeafFeast());

    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA = registerBlockWithTab("leaf_feast_ensaymada",
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_ENSAYMADA.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_HALF = registerBlockWithTab("leaf_feast_ensaymada_half",
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_ENSAYMADA.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_UBE = registerBlockWithTab("leaf_feast_ensaymada_ube",
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_UBE_HALF = registerBlockWithTab("leaf_feast_ensaymada_ube_half",
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_PANDESAL = registerBlockWithTab("leaf_feast_pandesal",
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_PANDESAL.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_PANDESAL_HALF = registerBlockWithTab("leaf_feast_pandesal_half",
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_PANDESAL.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_PANDESAL_UBE = registerBlockWithTab("leaf_feast_pandesal_ube",
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_PANDESAL_UBE_HALF = registerBlockWithTab("leaf_feast_pandesal_ube_half",
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_HOPIA_MUNGGO = registerBlockWithTab("leaf_feast_hopia_munggo",
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_HOPIA_MUNGGO_HALF = registerBlockWithTab("leaf_feast_hopia_munggo_half",
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_HOPIA_UBE = registerBlockWithTab("leaf_feast_hopia_ube",
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_HOPIA_UBE_HALF = registerBlockWithTab("leaf_feast_hopia_ube_half",
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_COOKED_RICE = registerBlockWithTab("leaf_feast_cooked_rice",
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_COOKED_RICE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_COOKED_RICE_HALF = registerBlockWithTab("leaf_feast_cooked_rice_half",
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_COOKED_RICE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_FRIED_RICE = registerBlockWithTab("leaf_feast_fried_rice",
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_FRIED_RICE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_FRIED_RICE_HALF = registerBlockWithTab("leaf_feast_fried_rice_half",
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_FRIED_RICE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_SINANGAG = registerBlockWithTab("leaf_feast_sinangag",
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_SINANGAG.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_SINANGAG_HALF = registerBlockWithTab("leaf_feast_sinangag_half",
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_SINANGAG.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> POISONOUS_UBE = registerItemWithTab("poisonous_ube", Item::new, basicItem());
    public static final Supplier<Item> UBE = registerItemWithTab("ube",
            (properties) -> new BlockItem(UbesDelightBlocks.UBE_CROP.get(), properties), foodItem(FoodValues.UBE));
    public static final Supplier<Item> GARLIC = registerItemWithTab("garlic",
            (properties) -> new BlockItem(UbesDelightBlocks.GARLIC_CROP.get(), properties), foodItem(FoodValues.GARLIC));
    public static final Supplier<Item> GINGER = registerItemWithTab("ginger",
            (properties) -> new BlockItem(UbesDelightBlocks.GINGER_CROP.get(), properties), foodItem(FoodValues.GINGER));
    public static final Supplier<Item> LEMONGRASS = registerItemWithTab("lemongrass",
            UbesDelightConsumableItem::new, foodItem(FoodValues.LEMONGRASS));
    public static final Supplier<Item> LEMONGRASS_SEEDS = registerItemWithTab("lemongrass_seeds",
            (properties) -> new BlockItem(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), properties), basicItem());

    public static final Supplier<Item> CONDENSED_MILK_BOTTLE = registerItemWithTab("condensed_milk_bottle",
            (properties) -> new UbesDelightDrinkableItem(properties, true), drinkItem(FoodValues.CONDENSED_MILK_BOTTLE, FoodValues.ConsumableValues.CONDENSED_MILK_BOTTLE));
    public static final Supplier<Item> FISH_SAUCE_BOTTLE = registerItemWithTab("fish_sauce_bottle",
            (properties) -> new UbesDelightDrinkableItem(properties, true), drinkItem(FoodValues.FISH_SAUCE_BOTTLE, FoodValues.ConsumableValues.FISH_SAUCE_BOTTLE));
    public static final Supplier<Item> MILK_POWDER = registerItemWithTab("milk_powder",
            Item::new, basicItem());
    public static final Supplier<Item> SUGAR_BROWN = registerItemWithTab("sugar_brown",
            Item::new, basicItem());
    public static final Supplier<Item> LUMPIA_WRAPPER = registerItemWithTab("lumpia_wrapper",
            Item::new, basicItem());

    public static final Supplier<Item> MILK_TEA_UBE = registerItemWithTab("milk_tea_ube",
            (properties) -> new UbesDelightDrinkableBlockItem(UbesDelightBlocks.GLASS_CUP_MILK_TEA_UBE.get(), properties, true, true),
            drinkItem(FoodValues.MILK_TEA_UBE, FoodValues.ConsumableValues.MILK_TEA_UBE));
    public static final Supplier<Item> HALO_HALO = registerItemWithTab("halo_halo",
            (properties) -> new UbesDelightDrinkableBlockItem(UbesDelightBlocks.GLASS_CUP_HALO_HALO.get(), properties, true, true),
            drinkItem(FoodValues.HALO_HALO, FoodValues.ConsumableValues.HALO_HALO));

    public static final Supplier<Item> GARLIC_CHOP = registerItemWithTab("garlic_chop",
            UbesDelightConsumableItem::new, foodItem(FoodValues.GARLIC_CHOP));
    public static final Supplier<Item> GINGER_CHOP = registerItemWithTab("ginger_chop",
            UbesDelightConsumableItem::new, foodItem(FoodValues.GINGER_CHOP));

    public static final Supplier<Item> SINANGAG = registerItemWithTab("sinangag",
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SINANGAG, FoodValues.ConsumableValues.SINANGAG));
    public static final Supplier<Item> KINILAW = registerItemWithTab("kinilaw",
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.KINILAW, FoodValues.ConsumableValues.KINILAW));
    public static final Supplier<Item> LUMPIA = registerItemWithTab("lumpia",
            Item::new, foodItem(FoodValues.LUMPIA));
    public static final Supplier<Item> TOCINO = registerItemWithTab("tocino",
            Item::new, foodItem(FoodValues.TOCINO, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> CHICKEN_INASAL = registerItemWithTab("chicken_inasal",
            Item::new, foodItem(FoodValues.CHICKEN_INASAL, FoodValues.ConsumableValues.FAST_FOOD));

    public static final Supplier<Item> CHICKEN_INASAL_RICE = registerItemWithTab("chicken_inasal_rice",
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.CHICKEN_INASAL_RICE, FoodValues.ConsumableValues.CHICKEN_INASAL_RICE));
    public static final Supplier<Item> TOSILOG = registerItemWithTab("tosilog",
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.TOSILOG, FoodValues.ConsumableValues.TOSILOG));
    public static final Supplier<Item> BANGSILOG = registerItemWithTab("bangsilog",
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.BANGSILOG, FoodValues.ConsumableValues.BANGSILOG));
    public static final Supplier<Item> SISIG = registerItemWithTab("sisig",
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SISIG, FoodValues.ConsumableValues.SISIG));
    public static final Supplier<Item> BULALO = registerItemWithTab("bulalo",
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.BULALO, FoodValues.ConsumableValues.BULALO));
    public static final Supplier<Item> ARROZ_CALDO = registerItemWithTab("arroz_caldo",
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.ARROZ_CALDO, FoodValues.ConsumableValues.ARROZ_CALDO));
    public static final Supplier<Item> MECHADO = registerItemWithTab("mechado",
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.MECHADO, FoodValues.ConsumableValues.MECHADO));

    public static final Supplier<Item> COOKIE_UBE = registerItemWithTab("cookie_ube",
            UbesDelightConsumableItem::new, foodItem(FoodValues.COOKIES, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> COOKIE_GINGER = registerItemWithTab("cookie_ginger",
            UbesDelightConsumableItem::new, foodItem(FoodValues.COOKIES, FoodValues.ConsumableValues.FAST_FOOD));

    public static final Supplier<Item> LECHE_FLAN = registerItemWithTab("leche_flan",
            Item::new, foodItem(FoodValues.LECHE_FLAN));
    public static final Supplier<Item> UBE_CAKE_SLICE = registerItemWithTab("ube_cake_slice",
            UbesDelightConsumableItem::new, foodItem(FoodValues.UBE_CAKE_SLICE, FoodValues.ConsumableValues.UBE_CAKE_SLICE));

    public static final Supplier<Item> RAW_POLVORONE = registerItemWithTab("raw_polvorone",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE = registerItemWithTab("polvorone",
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> RAW_POLVORONE_PINIPIG = registerItemWithTab("raw_polvorone_pinipig",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG = registerItemWithTab("polvorone_pinipig",
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> RAW_POLVORONE_UBE = registerItemWithTab("raw_polvorone_ube",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE = registerItemWithTab("polvorone_ube",
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> RAW_POLVORONE_CC = registerItemWithTab("raw_polvorone_cc",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC = registerItemWithTab("polvorone_cc",
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));

    public static final Supplier<Item> PANDESAL_RAW = registerItemWithTab("pandesal_raw",
            UbesDelightConsumableItem::new, foodItem(FoodValues.PANDESAL_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> PANDESAL = registerItemWithTab("pandesal",
            UbesDelightLeafFeastConsumableItem::new, foodItem(FoodValues.PANDESAL));
    public static final Supplier<Item> PANDESAL_UBE_RAW = registerItemWithTab("pandesal_ube_raw",
            UbesDelightConsumableItem::new, foodItem(FoodValues.PANDESAL_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> PANDESAL_UBE = registerItemWithTab("pandesal_ube",
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            foodItem(FoodValues.PANDESAL_UBE, FoodValues.ConsumableValues.PASTRY_UBE));
    public static final Supplier<Item> ENSAYMADA_RAW = registerItemWithTab("ensaymada_raw",
            UbesDelightConsumableItem::new, foodItem(FoodValues.ENSAYMADA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> ENSAYMADA = registerItemWithTab("ensaymada",
            UbesDelightLeafFeastConsumableItem::new, foodItem(FoodValues.ENSAYMADA));
    public static final Supplier<Item> ENSAYMADA_UBE_RAW = registerItemWithTab("ensaymada_ube_raw",
            UbesDelightConsumableItem::new, foodItem(FoodValues.ENSAYMADA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> ENSAYMADA_UBE = registerItemWithTab("ensaymada_ube",
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            foodItem(FoodValues.ENSAYMADA_UBE, FoodValues.ConsumableValues.PASTRY_UBE));
    public static final Supplier<Item> HOPIA_MUNGGO_RAW = registerItemWithTab("hopia_munggo_raw",
            UbesDelightConsumableItem::new, foodItem(FoodValues.HOPIA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> HOPIA_MUNGGO = registerItemWithTab("hopia_munggo",
            UbesDelightLeafFeastConsumableItem::new, foodItem(FoodValues.HOPIA_MUNGGO));
    public static final Supplier<Item> HOPIA_UBE_RAW = registerItemWithTab("hopia_ube_raw",
            UbesDelightConsumableItem::new, foodItem(FoodValues.HOPIA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> HOPIA_UBE = registerItemWithTab("hopia_ube",
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            foodItem(FoodValues.HOPIA_UBE, FoodValues.ConsumableValues.PASTRY_UBE));

    public static final Supplier<Item> POLVORONE_STAGE0 = registerItemNoTab("polvorone_stage0",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_STAGE1 = registerItemNoTab("polvorone_stage1",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_STAGE2 = registerItemNoTab("polvorone_stage2",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE0 = registerItemNoTab("polvorone_pinipig_stage0",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE1 = registerItemNoTab("polvorone_pinipig_stage1",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE2 = registerItemNoTab("polvorone_pinipig_stage2",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE_STAGE0 = registerItemNoTab("polvorone_ube_stage0",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE_STAGE1 = registerItemNoTab("polvorone_ube_stage1",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE_STAGE2 = registerItemNoTab("polvorone_ube_stage2",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC_STAGE0 = registerItemNoTab("polvorone_cc_stage0",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC_STAGE1 = registerItemNoTab("polvorone_cc_stage1",
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC_STAGE2 = registerItemNoTab("polvorone_cc_stage2",
            Item::new, basicItem());

    public static final Supplier<Item> PANDESAL_STAGE0 = registerItemNoTab("pandesal_stage0",
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_STAGE1 = registerItemNoTab("pandesal_stage1",
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_STAGE2 = registerItemNoTab("pandesal_stage2",
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_UBE_STAGE0 = registerItemNoTab("pandesal_ube_stage0",
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_UBE_STAGE1 = registerItemNoTab("pandesal_ube_stage1",
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_UBE_STAGE2 = registerItemNoTab("pandesal_ube_stage2",
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE0 = registerItemNoTab("ensaymada_stage0",
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE1 = registerItemNoTab("ensaymada_stage1",
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE2 = registerItemNoTab("ensaymada_stage2",
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE3 = registerItemNoTab("ensaymada_stage3",
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE0 = registerItemNoTab("ensaymada_ube_stage0",
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE1 = registerItemNoTab("ensaymada_ube_stage1",
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE2 = registerItemNoTab("ensaymada_ube_stage2",
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE3 = registerItemNoTab("ensaymada_ube_stage3",
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE0 = registerItemNoTab("hopia_munggo_stage0",
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE1 = registerItemNoTab("hopia_munggo_stage1",
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE2 = registerItemNoTab("hopia_munggo_stage2",
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_UBE_STAGE0 = registerItemNoTab("hopia_ube_stage0",
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_UBE_STAGE1 = registerItemNoTab("hopia_ube_stage1",
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_UBE_STAGE2 = registerItemNoTab("hopia_ube_stage2",
            Item::new, basicItem());

    public static Supplier<Item> registerItemWithTab(final String location, final Function<Item.Properties, Item> function, final Item.Properties properties) {
        properties.setId(ResourceKey.create(Registries.ITEM, TextUtils.res(location)));
        Supplier<Item> item = RegistrationUtils.register(location, () -> function.apply(properties), BuiltInRegistries.ITEM);
        CreativeModeTabEvents.modifyOutputEvent(UbesDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item.get()));
        return item;
    }

    public static Supplier<Item> registerBlockWithTab(final String location, final BiFunction<Block, Item.Properties, Item> function, final Block block, final Item.Properties properties) {
        properties.setId(ResourceKey.create(Registries.ITEM, TextUtils.res(location)));
        properties.useBlockDescriptionPrefix();
        Supplier<Item> item = RegistrationUtils.register(location, () -> function.apply(block, properties), BuiltInRegistries.ITEM);
        CreativeModeTabEvents.modifyOutputEvent(UbesDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item.get()));
        return item;
    }

    private static Supplier<Item> registerItemNoTab(final String location, final Function<Item.Properties, Item> function, final Item.Properties properties) {
        properties.setId(ResourceKey.create(Registries.ITEM, TextUtils.res(location)));
        return RegistrationUtils.register(location, () -> function.apply(properties), BuiltInRegistries.ITEM);
    }

    public static void register() {
    }
}

