package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.common.FoodValues;
import chefmooon.ubesdelight.common.item.*;
import chefmooon.ubesdelight.common.references.UDBlockItemIds;
import chefmooon.ubesdelight.common.references.UDItemIds;
import chefmooon.ubesdelight.common.utility.RegistrationUtils;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
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

    public static final Supplier<Item> KALAN = registerBlockWithTab(UDBlockItemIds.KALAN, UbesDelightBlockItem::new,
            UbesDelightBlocks.KALAN.get(), basicItem());
    public static final Supplier<Item> BAKING_MAT_BAMBOO = registerItemWithTab(UDBlockItemIds.BAKING_MAT_BAMBOO.item(),
            (properties) -> new UbesDelightFuelBlockItem(UbesDelightBlocks.BAKING_MAT_BAMBOO.get(), properties, false, false, 250),
            basicItem().useBlockDescriptionPrefix());
    public static final Supplier<Item> ROLLING_PIN_WOOD = registerItemWithTab(UDItemIds.ROLLING_PIN_WOOD,
            RollingPinItem::new, rollingPinItem(UDToolMaterials.ROLLING_PIN_WOOD));
    public static final Supplier<Item> ROLLING_PIN_IRON = registerItemWithTab(UDItemIds.ROLLING_PIN_IRON,
            RollingPinItem::new, rollingPinItem(ToolMaterial.IRON));
    public static final Supplier<Item> ROLLING_PIN_GOLD = registerItemWithTab(UDItemIds.ROLLING_PIN_GOLD,
            RollingPinItem::new, rollingPinItem(ToolMaterial.GOLD));
    public static final Supplier<Item> ROLLING_PIN_DIAMOND = registerItemWithTab(UDItemIds.ROLLING_PIN_DIAMOND,
            RollingPinItem::new, rollingPinItem(ToolMaterial.DIAMOND));
    public static final Supplier<Item> ROLLING_PIN_NETHERITE = registerItemWithTab(UDItemIds.ROLLING_PIN_NETHERITE,
            RollingPinItem::new, rollingPinItem(ToolMaterial.NETHERITE));

    public static final Supplier<Item> WILD_UBE = registerBlockWithTab(UDBlockItemIds.WILD_UBE,
            BlockItem::new, UbesDelightBlocks.WILD_UBE.get(), basicItem());
    public static final Supplier<Item> WILD_GARLIC = registerBlockWithTab(UDBlockItemIds.WILD_GARLIC,
            BlockItem::new, UbesDelightBlocks.WILD_GARLIC.get(), basicItem());
    public static final Supplier<Item> WILD_GINGER = registerBlockWithTab(UDBlockItemIds.WILD_GINGER,
            BlockItem::new, UbesDelightBlocks.WILD_GINGER.get(), basicItem());
    public static final Supplier<Item> WILD_LEMONGRASS = registerBlockWithTab(UDBlockItemIds.WILD_LEMONGRASS,
            BlockItem::new, UbesDelightBlocks.WILD_LEMONGRASS.get(), basicItem());

    public static final Supplier<Item> UBE_CRATE = registerBlockWithTab(UDBlockItemIds.UBE_CRATE,
            BlockItem::new, UbesDelightBlocks.UBE_CRATE.get(), basicItem());
    public static final Supplier<Item> GARLIC_CRATE = registerBlockWithTab(UDBlockItemIds.GARLIC_CRATE,
            BlockItem::new, UbesDelightBlocks.GARLIC_CRATE.get(), basicItem());
    public static final Supplier<Item> GINGER_CRATE = registerBlockWithTab(UDBlockItemIds.GINGER_CRATE,
            BlockItem::new, UbesDelightBlocks.GINGER_CRATE.get(), basicItem());
    public static final Supplier<Item> LEMONGRASS_CRATE = registerBlockWithTab(UDBlockItemIds.LEMONGRASS_CRATE,
            BlockItem::new, UbesDelightBlocks.LEMONGRASS_CRATE.get(), basicItem());

    public static final Supplier<Item> UBE_CAKE = registerBlockWithTab(UDBlockItemIds.UBE_CAKE,
            BlockItem::new, UbesDelightBlocks.UBE_CAKE.get(), noStack());
    public static final Supplier<Item> LECHE_FLAN_FEAST = registerBlockWithTab(UDBlockItemIds.LECHE_FLAN_FEAST,
            BlockItem::new, UbesDelightBlocks.LECHE_FLAN_FEAST.get(), noStack());
    public static final Supplier<Item> HALO_HALO_FEAST = registerBlockWithTab(UDBlockItemIds.HALO_HALO_FEAST,
            BlockItem::new, UbesDelightBlocks.HALO_HALO_FEAST.get(), noStack());
    public static final Supplier<Item> MILK_TEA_UBE_FEAST = registerBlockWithTab(UDBlockItemIds.MILK_TEA_UBE_FEAST,
            BlockItem::new, UbesDelightBlocks.MILK_TEA_UBE_FEAST.get(), noStack());

    public static final Supplier<Item> LEAF_FEAST = registerBlockWithTab(UDBlockItemIds.LEAF_FEAST,
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST.get(), basicItem());
    public static final Supplier<Item> LUMPIA_FEAST = registerBlockWithTab(UDBlockItemIds.LUMPIA_FEAST,
            BlockItem::new, UbesDelightBlocks.LUMPIA_FEAST.get(), halfLeafFeast());

    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA = registerBlockWithTab(UDBlockItemIds.LEAF_FEAST_ENSAYMADA,
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_ENSAYMADA.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_HALF = registerBlockWithTab(UDItemIds.LEAF_FEAST_ENSAYMADA_HALF,
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_ENSAYMADA.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_UBE = registerBlockWithTab(UDBlockItemIds.LEAF_FEAST_ENSAYMADA_UBE,
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_ENSAYMADA_UBE_HALF = registerBlockWithTab(UDItemIds.LEAF_FEAST_ENSAYMADA_UBE_HALF,
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_ENSAYMADA_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_PANDESAL = registerBlockWithTab(UDBlockItemIds.LEAF_FEAST_PANDESAL,
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_PANDESAL.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_PANDESAL_HALF = registerBlockWithTab(UDItemIds.LEAF_FEAST_PANDESAL_HALF,
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_PANDESAL.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_PANDESAL_UBE = registerBlockWithTab(UDBlockItemIds.LEAF_FEAST_PANDESAL_UBE,
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_PANDESAL_UBE_HALF = registerBlockWithTab(UDItemIds.LEAF_FEAST_PANDESAL_UBE_HALF,
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_PANDESAL_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_HOPIA_MUNGGO = registerBlockWithTab(UDBlockItemIds.LEAF_FEAST_HOPIA_MUNGGO,
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_HOPIA_MUNGGO_HALF = registerBlockWithTab(UDItemIds.LEAF_FEAST_HOPIA_MUNGGO_HALF,
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_HOPIA_MUNGGO.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_HOPIA_UBE = registerBlockWithTab(UDBlockItemIds.LEAF_FEAST_HOPIA_UBE,
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_HOPIA_UBE_HALF = registerBlockWithTab(UDItemIds.LEAF_FEAST_HOPIA_UBE_HALF,
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_HOPIA_UBE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_COOKED_RICE = registerBlockWithTab(UDBlockItemIds.LEAF_FEAST_COOKED_RICE,
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_COOKED_RICE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_COOKED_RICE_HALF = registerBlockWithTab(UDItemIds.LEAF_FEAST_COOKED_RICE_HALF,
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_COOKED_RICE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_FRIED_RICE = registerBlockWithTab(UDBlockItemIds.LEAF_FEAST_FRIED_RICE,
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_FRIED_RICE.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_FRIED_RICE_HALF = registerBlockWithTab(UDItemIds.LEAF_FEAST_FRIED_RICE_HALF,
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_FRIED_RICE.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> LEAF_FEAST_SINANGAG = registerBlockWithTab(UDBlockItemIds.LEAF_FEAST_SINANGAG,
            BlockItem::new, UbesDelightBlocks.LEAF_FEAST_SINANGAG.get(), leafFeast());
    public static final Supplier<Item> LEAF_FEAST_SINANGAG_HALF = registerBlockWithTab(UDItemIds.LEAF_FEAST_SINANGAG_HALF,
            LeafFeastItem::new, UbesDelightBlocks.LEAF_FEAST_SINANGAG.get(), halfLeafFeast().component(UbesDelightDataComponentTypes.SIMPLE_LEAF_FEAST_SERVINGS, 3));

    public static final Supplier<Item> POISONOUS_UBE = registerItemWithTab(UDItemIds.POISONOUS_UBE, Item::new, basicItem());
    public static final Supplier<Item> UBE = registerItemWithTab(UDBlockItemIds.UBE_CROP,
            (properties) -> new BlockItem(UbesDelightBlocks.UBE_CROP.get(), properties), foodItem(FoodValues.UBE));
    public static final Supplier<Item> GARLIC = registerItemWithTab(UDBlockItemIds.GARLIC_CROP,
            (properties) -> new BlockItem(UbesDelightBlocks.GARLIC_CROP.get(), properties), foodItem(FoodValues.GARLIC));
    public static final Supplier<Item> GINGER = registerItemWithTab(UDBlockItemIds.GINGER_CROP,
            (properties) -> new BlockItem(UbesDelightBlocks.GINGER_CROP.get(), properties), foodItem(FoodValues.GINGER));
    public static final Supplier<Item> LEMONGRASS = registerItemWithTab(UDItemIds.LEMONGRASS,
            UbesDelightConsumableItem::new, foodItem(FoodValues.LEMONGRASS));
    public static final Supplier<Item> LEMONGRASS_SEEDS = registerItemWithTab(UDBlockItemIds.LEMONGRASS_STALK_CROP,
            (properties) -> new BlockItem(UbesDelightBlocks.LEMONGRASS_STALK_CROP.get(), properties), basicItem());

    public static final Supplier<Item> CONDENSED_MILK_BOTTLE = registerItemWithTab(UDItemIds.CONDENSED_MILK_BOTTLE,
            (properties) -> new UbesDelightDrinkableItem(properties, true), drinkItem(FoodValues.CONDENSED_MILK_BOTTLE, FoodValues.ConsumableValues.CONDENSED_MILK_BOTTLE));
    public static final Supplier<Item> FISH_SAUCE_BOTTLE = registerItemWithTab(UDItemIds.FISH_SAUCE_BOTTLE,
            (properties) -> new UbesDelightDrinkableItem(properties, true), drinkItem(FoodValues.FISH_SAUCE_BOTTLE, FoodValues.ConsumableValues.FISH_SAUCE_BOTTLE));
    public static final Supplier<Item> MILK_POWDER = registerItemWithTab(UDItemIds.MILK_POWDER,
            Item::new, basicItem());
    public static final Supplier<Item> SUGAR_BROWN = registerItemWithTab(UDItemIds.SUGAR_BROWN,
            Item::new, basicItem());
    public static final Supplier<Item> LUMPIA_WRAPPER = registerItemWithTab(UDItemIds.LUMPIA_WRAPPER,
            Item::new, basicItem());

    public static final Supplier<Item> MILK_TEA_UBE = registerItemWithTab(UDBlockItemIds.GLASS_CUP_MILK_TEA_UBE,
            (properties) -> new UbesDelightDrinkableBlockItem(UbesDelightBlocks.GLASS_CUP_MILK_TEA_UBE.get(), properties, true, true),
            drinkItem(FoodValues.MILK_TEA_UBE, FoodValues.ConsumableValues.MILK_TEA_UBE));
    public static final Supplier<Item> HALO_HALO = registerItemWithTab(UDBlockItemIds.GLASS_CUP_HALO_HALO,
            (properties) -> new UbesDelightDrinkableBlockItem(UbesDelightBlocks.GLASS_CUP_HALO_HALO.get(), properties, true, true),
            drinkItem(FoodValues.HALO_HALO, FoodValues.ConsumableValues.HALO_HALO));

    public static final Supplier<Item> GARLIC_CHOP = registerItemWithTab(UDItemIds.GARLIC_CHOP,
            UbesDelightConsumableItem::new, foodItem(FoodValues.GARLIC_CHOP));
    public static final Supplier<Item> GINGER_CHOP = registerItemWithTab(UDItemIds.GINGER_CHOP,
            UbesDelightConsumableItem::new, foodItem(FoodValues.GINGER_CHOP));

    public static final Supplier<Item> SINANGAG = registerItemWithTab(UDItemIds.SINANGAG,
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SINANGAG, FoodValues.ConsumableValues.SINANGAG));
    public static final Supplier<Item> KINILAW = registerItemWithTab(UDItemIds.KINILAW,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.KINILAW, FoodValues.ConsumableValues.KINILAW));
    public static final Supplier<Item> LUMPIA = registerItemWithTab(UDItemIds.LUMPIA,
            Item::new, foodItem(FoodValues.LUMPIA));
    public static final Supplier<Item> TOCINO = registerItemWithTab(UDItemIds.TOCINO,
            Item::new, foodItem(FoodValues.TOCINO, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> CHICKEN_INASAL = registerItemWithTab(UDItemIds.CHICKEN_INASAL,
            Item::new, foodItem(FoodValues.CHICKEN_INASAL, FoodValues.ConsumableValues.FAST_FOOD));

    public static final Supplier<Item> CHICKEN_INASAL_RICE = registerItemWithTab(UDItemIds.CHICKEN_INASAL_RICE,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.CHICKEN_INASAL_RICE, FoodValues.ConsumableValues.CHICKEN_INASAL_RICE));
    public static final Supplier<Item> TOSILOG = registerItemWithTab(UDItemIds.TOSILOG,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.TOSILOG, FoodValues.ConsumableValues.TOSILOG));
    public static final Supplier<Item> BANGSILOG = registerItemWithTab(UDItemIds.BANGSILOG,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.BANGSILOG, FoodValues.ConsumableValues.BANGSILOG));
    public static final Supplier<Item> SISIG = registerItemWithTab(UDItemIds.SISIG,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SISIG, FoodValues.ConsumableValues.SISIG));
    public static final Supplier<Item> BULALO = registerItemWithTab(UDItemIds.BULALO,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.BULALO, FoodValues.ConsumableValues.BULALO));
    public static final Supplier<Item> ARROZ_CALDO = registerItemWithTab(UDItemIds.ARROZ_CALDO,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.ARROZ_CALDO, FoodValues.ConsumableValues.ARROZ_CALDO));
    public static final Supplier<Item> MECHADO = registerItemWithTab(UDItemIds.MECHADO,
            (properties) -> new UbesDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.MECHADO, FoodValues.ConsumableValues.MECHADO));

    public static final Supplier<Item> COOKIE_UBE = registerItemWithTab(UDItemIds.COOKIE_UBE,
            UbesDelightConsumableItem::new, foodItem(FoodValues.COOKIES, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> COOKIE_GINGER = registerItemWithTab(UDItemIds.COOKIE_GINGER,
            UbesDelightConsumableItem::new, foodItem(FoodValues.COOKIES, FoodValues.ConsumableValues.FAST_FOOD));

    public static final Supplier<Item> LECHE_FLAN = registerItemWithTab(UDItemIds.LECHE_FLAN,
            Item::new, foodItem(FoodValues.LECHE_FLAN));
    public static final Supplier<Item> UBE_CAKE_SLICE = registerItemWithTab(UDItemIds.UBE_CAKE_SLICE,
            UbesDelightConsumableItem::new, foodItem(FoodValues.UBE_CAKE_SLICE, FoodValues.ConsumableValues.UBE_CAKE_SLICE));

    public static final Supplier<Item> RAW_POLVORONE = registerItemWithTab(UDItemIds.RAW_POLVORONE,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE = registerItemWithTab(UDItemIds.POLVORONE,
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> RAW_POLVORONE_PINIPIG = registerItemWithTab(UDItemIds.RAW_POLVORONE_PINIPIG,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG = registerItemWithTab(UDItemIds.POLVORONE_PINIPIG,
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> RAW_POLVORONE_UBE = registerItemWithTab(UDItemIds.RAW_POLVORONE_UBE,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE = registerItemWithTab(UDItemIds.POLVORONE_UBE,
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));
    public static final Supplier<Item> RAW_POLVORONE_CC = registerItemWithTab(UDItemIds.RAW_POLVORONE_CC,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC = registerItemWithTab(UDItemIds.POLVORONE_CC,
            UbesDelightConsumableItem::new, foodItem(FoodValues.POLVORONE, FoodValues.ConsumableValues.FAST_FOOD));

    public static final Supplier<Item> PANDESAL_RAW = registerItemWithTab(UDItemIds.PANDESAL_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.PANDESAL_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> PANDESAL = registerItemWithTab(UDItemIds.PANDESAL,
            UbesDelightLeafFeastConsumableItem::new, foodItem(FoodValues.PANDESAL));
    public static final Supplier<Item> PANDESAL_UBE_RAW = registerItemWithTab(UDItemIds.PANDESAL_UBE_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.PANDESAL_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> PANDESAL_UBE = registerItemWithTab(UDItemIds.PANDESAL_UBE,
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            foodItem(FoodValues.PANDESAL_UBE, FoodValues.ConsumableValues.PASTRY_UBE));
    public static final Supplier<Item> ENSAYMADA_RAW = registerItemWithTab(UDItemIds.ENSAYMADA_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.ENSAYMADA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> ENSAYMADA = registerItemWithTab(UDItemIds.ENSAYMADA,
            UbesDelightLeafFeastConsumableItem::new, foodItem(FoodValues.ENSAYMADA));
    public static final Supplier<Item> ENSAYMADA_UBE_RAW = registerItemWithTab(UDItemIds.ENSAYMADA_UBE_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.ENSAYMADA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> ENSAYMADA_UBE = registerItemWithTab(UDItemIds.ENSAYMADA_UBE,
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            foodItem(FoodValues.ENSAYMADA_UBE, FoodValues.ConsumableValues.PASTRY_UBE));
    public static final Supplier<Item> HOPIA_MUNGGO_RAW = registerItemWithTab(UDItemIds.HOPIA_MUNGGO_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.HOPIA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> HOPIA_MUNGGO = registerItemWithTab(UDItemIds.HOPIA_MUNGGO,
            UbesDelightLeafFeastConsumableItem::new, foodItem(FoodValues.HOPIA_MUNGGO));
    public static final Supplier<Item> HOPIA_UBE_RAW = registerItemWithTab(UDItemIds.HOPIA_UBE_RAW,
            UbesDelightConsumableItem::new, foodItem(FoodValues.HOPIA_RAW, FoodValues.ConsumableValues.RAW_DOUGH));
    public static final Supplier<Item> HOPIA_UBE = registerItemWithTab(UDItemIds.HOPIA_UBE,
            (properties) -> new UbesDelightLeafFeastConsumableItem(properties, true),
            foodItem(FoodValues.HOPIA_UBE, FoodValues.ConsumableValues.PASTRY_UBE));

    public static final Supplier<Item> POLVORONE_STAGE0 = registerItemNoTab(UDItemIds.POLVORONE_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_STAGE1 = registerItemNoTab(UDItemIds.POLVORONE_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_STAGE2 = registerItemNoTab(UDItemIds.POLVORONE_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE0 = registerItemNoTab(UDItemIds.POLVORONE_PINIPIG_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE1 = registerItemNoTab(UDItemIds.POLVORONE_PINIPIG_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_PINIPIG_STAGE2 = registerItemNoTab(UDItemIds.POLVORONE_PINIPIG_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE_STAGE0 = registerItemNoTab(UDItemIds.POLVORONE_UBE_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE_STAGE1 = registerItemNoTab(UDItemIds.POLVORONE_UBE_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_UBE_STAGE2 = registerItemNoTab(UDItemIds.POLVORONE_UBE_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC_STAGE0 = registerItemNoTab(UDItemIds.POLVORONE_CC_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC_STAGE1 = registerItemNoTab(UDItemIds.POLVORONE_CC_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> POLVORONE_CC_STAGE2 = registerItemNoTab(UDItemIds.POLVORONE_CC_STAGE2,
            Item::new, basicItem());

    public static final Supplier<Item> PANDESAL_STAGE0 = registerItemNoTab(UDItemIds.PANDESAL_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_STAGE1 = registerItemNoTab(UDItemIds.PANDESAL_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_STAGE2 = registerItemNoTab(UDItemIds.PANDESAL_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_UBE_STAGE0 = registerItemNoTab(UDItemIds.PANDESAL_UBE_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_UBE_STAGE1 = registerItemNoTab(UDItemIds.PANDESAL_UBE_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> PANDESAL_UBE_STAGE2 = registerItemNoTab(UDItemIds.PANDESAL_UBE_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE0 = registerItemNoTab(UDItemIds.ENSAYMADA_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE1 = registerItemNoTab(UDItemIds.ENSAYMADA_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE2 = registerItemNoTab(UDItemIds.ENSAYMADA_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_STAGE3 = registerItemNoTab(UDItemIds.ENSAYMADA_STAGE3,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE0 = registerItemNoTab(UDItemIds.ENSAYMADA_UBE_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE1 = registerItemNoTab(UDItemIds.ENSAYMADA_UBE_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE2 = registerItemNoTab(UDItemIds.ENSAYMADA_UBE_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> ENSAYMADA_UBE_STAGE3 = registerItemNoTab(UDItemIds.ENSAYMADA_UBE_STAGE3,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE0 = registerItemNoTab(UDItemIds.HOPIA_MUNGGO_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE1 = registerItemNoTab(UDItemIds.HOPIA_MUNGGO_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_MUNGGO_STAGE2 = registerItemNoTab(UDItemIds.HOPIA_MUNGGO_STAGE2,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_UBE_STAGE0 = registerItemNoTab(UDItemIds.HOPIA_UBE_STAGE0,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_UBE_STAGE1 = registerItemNoTab(UDItemIds.HOPIA_UBE_STAGE1,
            Item::new, basicItem());
    public static final Supplier<Item> HOPIA_UBE_STAGE2 = registerItemNoTab(UDItemIds.HOPIA_UBE_STAGE2,
            Item::new, basicItem());

    private static Supplier<Item> registerItemWithTab(final BlockItemId id, final Function<Item.Properties, Item> function, final Item.Properties properties) {
        return registerItemWithTab(id.item().identifier(), function, properties);
    }

    private static Supplier<Item> registerItemWithTab(final ResourceKey<Item> key, final Function<Item.Properties, Item> function, final Item.Properties properties) {
        return registerItemWithTab(key.identifier(), function, properties);
    }

    private static Supplier<Item> registerBlockWithTab(final ResourceKey<Item> key, final BiFunction<Block, Item.Properties, Item> function, final Block block, final Item.Properties properties) {
        return registerBlockWithTab(key.identifier(), function, block, properties);
    }

    private static Supplier<Item> registerBlockWithTab(final BlockItemId id, final BiFunction<Block, Item.Properties, Item> function, final Block block, final Item.Properties properties) {
        return registerBlockWithTab(id.item().identifier(), function, block, properties);
    }

    private static Supplier<Item> registerItemNoTab(final ResourceKey<Item> key, final Function<Item.Properties, Item> function, final Item.Properties properties) {
        return registerItemNoTab(key.identifier(), function, properties);
    }

    public static Supplier<Item> registerItemWithTab(final Identifier identifier, final Function<Item.Properties, Item> function, final Item.Properties properties) {
        properties.setId(ResourceKey.create(Registries.ITEM, identifier));
        Supplier<Item> item = RegistrationUtils.register(identifier.getPath(), () -> function.apply(properties), BuiltInRegistries.ITEM);
        CreativeModeTabEvents.modifyOutputEvent(UbesDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item.get()));
        return item;
    }

    public static Supplier<Item> registerBlockWithTab(final Identifier identifier, final BiFunction<Block, Item.Properties, Item> function, final Block block, final Item.Properties properties) {
        properties.setId(ResourceKey.create(Registries.ITEM,identifier));
        properties.useBlockDescriptionPrefix();
        Supplier<Item> item = RegistrationUtils.register(identifier.getPath(), () -> function.apply(block, properties), BuiltInRegistries.ITEM);
        CreativeModeTabEvents.modifyOutputEvent(UbesDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item.get()));
        return item;
    }

    private static Supplier<Item> registerItemNoTab(final Identifier identifier, final Function<Item.Properties, Item> function, final Item.Properties properties) {
        properties.setId(ResourceKey.create(Registries.ITEM, identifier));
        return RegistrationUtils.register(identifier.getPath(), () -> function.apply(properties), BuiltInRegistries.ITEM);
    }

    public static void register() {
    }
}

