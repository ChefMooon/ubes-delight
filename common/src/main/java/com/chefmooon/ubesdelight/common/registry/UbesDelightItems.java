package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.item.RollingPinItem;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.food.FoodProperties;
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

    public static final Identifier KALAN = item("kalan");
    public static final Identifier BAKING_MAT_BAMBOO = item("baking_mat_bamboo");

    public static final Identifier ROLLING_PIN_WOOD = item("rolling_pin_wood");
    public static final Identifier ROLLING_PIN_IRON = item("rolling_pin_iron");
    public static final Identifier ROLLING_PIN_GOLD = item("rolling_pin_gold");
    public static final Identifier ROLLING_PIN_DIAMOND = item("rolling_pin_diamond");
    public static final Identifier ROLLING_PIN_NETHERITE = item("rolling_pin_netherite");

    public static final Identifier WILD_UBE = item("wild_ube");
    public static final Identifier WILD_GARLIC = item("wild_garlic");
    public static final Identifier WILD_GINGER = item("wild_ginger");
    public static final Identifier WILD_LEMONGRASS = item("wild_lemongrass");

    public static final Identifier UBE_CRATE = item("ube_crate");
    public static final Identifier GARLIC_CRATE = item("garlic_crate");
    public static final Identifier GINGER_CRATE = item("ginger_crate");
    public static final Identifier LEMONGRASS_CRATE = item("lemongrass_crate");

    public static final Identifier UBE_CAKE = item("ube_cake");
    public static final Identifier LECHE_FLAN_FEAST = item("leche_flan_feast");
    public static final Identifier LUMPIA_FEAST = item("lumpia_feast");
    public static final Identifier HALO_HALO_FEAST = item("halo_halo_feast");
    public static final Identifier MILK_TEA_UBE_FEAST = item("milk_tea_ube_feast");

    public static final Identifier LEAF_FEAST = item("leaf_feast");

    public static final Identifier LEAF_FEAST_ENSAYMADA = item("leaf_feast_ensaymada");
    public static final Identifier LEAF_FEAST_ENSAYMADA_HALF = item("leaf_feast_ensaymada_half");

    public static final Identifier LEAF_FEAST_ENSAYMADA_UBE = item("leaf_feast_ensaymada_ube");
    public static final Identifier LEAF_FEAST_ENSAYMADA_UBE_HALF = item("leaf_feast_ensaymada_ube_half");

    public static final Identifier LEAF_FEAST_PANDESAL = item("leaf_feast_pandesal");
    public static final Identifier LEAF_FEAST_PANDESAL_HALF = item("leaf_feast_pandesal_half");

    public static final Identifier LEAF_FEAST_PANDESAL_UBE = item("leaf_feast_pandesal_ube");
    public static final Identifier LEAF_FEAST_PANDESAL_UBE_HALF = item("leaf_feast_pandesal_ube_half");

    public static final Identifier LEAF_FEAST_HOPIA_MUNGGO = item("leaf_feast_hopia_munggo");
    public static final Identifier LEAF_FEAST_HOPIA_MUNGGO_HALF = item("leaf_feast_hopia_munggo_half");

    public static final Identifier LEAF_FEAST_HOPIA_UBE = item("leaf_feast_hopia_ube");
    public static final Identifier LEAF_FEAST_HOPIA_UBE_HALF = item("leaf_feast_hopia_ube_half");
    public static final Identifier LEAF_FEAST_COOKED_RICE = item("leaf_feast_cooked_rice");
    public static final Identifier LEAF_FEAST_COOKED_RICE_HALF = item("leaf_feast_cooked_rice_half");
    public static final Identifier LEAF_FEAST_FRIED_RICE = item("leaf_feast_fried_rice");
    public static final Identifier LEAF_FEAST_FRIED_RICE_HALF = item("leaf_feast_fried_rice_half");
    public static final Identifier LEAF_FEAST_SINANGAG = item("leaf_feast_sinangag");
    public static final Identifier LEAF_FEAST_SINANGAG_HALF = item("leaf_feast_sinangag_half");

    public static final Identifier POISONOUS_UBE = item("poisonous_ube");
    public static final Identifier UBE = item("ube");
    public static final Identifier GARLIC = item("garlic");
    public static final Identifier GINGER = item("ginger");
    public static final Identifier LEMONGRASS = item("lemongrass");
    public static final Identifier LEMONGRASS_SEEDS = item("lemongrass_seeds");

    public static final Identifier CONDENSED_MILK_BOTTLE = item("condensed_milk_bottle");
    public static final Identifier FISH_SAUCE_BOTTLE = item("fish_sauce_bottle");
    public static final Identifier MILK_POWDER = item("milk_powder");
    public static final Identifier SUGAR_BROWN = item("sugar_brown");
    public static final Identifier LUMPIA_WRAPPER = item("lumpia_wrapper");

    public static final Identifier MILK_TEA_UBE = item("milk_tea_ube");
    public static final Identifier HALO_HALO = item("halo_halo");

    public static final Identifier GARLIC_CHOP = item("garlic_chop");
    public static final Identifier GINGER_CHOP = item("ginger_chop");

    public static final Identifier SINANGAG = item("sinangag");
    public static final Identifier KINILAW = item("kinilaw");
    public static final Identifier LUMPIA = item("lumpia");
    public static final Identifier TOCINO = item("tocino");
    public static final Identifier CHICKEN_INASAL = item("chicken_inasal");

    public static final Identifier CHICKEN_INASAL_RICE = item("chicken_inasal_rice");
    public static final Identifier TOSILOG = item("tosilog");
    public static final Identifier BANGSILOG = item("bangsilog");
    public static final Identifier SISIG = item("sisig");
    public static final Identifier BULALO = item("bulalo");
    public static final Identifier ARROZ_CALDO = item("arroz_caldo");
    public static final Identifier MECHADO = item("mechado");

    public static final Identifier COOKIE_UBE = item("cookie_ube");
    public static final Identifier COOKIE_GINGER = item("cookie_ginger");

    public static final Identifier LECHE_FLAN = item("leche_flan");
    public static final Identifier UBE_CAKE_SLICE = item("ube_cake_slice");

    public static final Identifier RAW_POLVORONE = item("raw_polvorone");
    public static final Identifier POLVORONE = item("polvorone");
    public static final Identifier RAW_POLVORONE_PINIPIG = item("raw_polvorone_pinipig");
    public static final Identifier POLVORONE_PINIPIG = item("polvorone_pinipig");
    public static final Identifier RAW_POLVORONE_UBE = item("raw_polvorone_ube");
    public static final Identifier POLVORONE_UBE = item("polvorone_ube");
    public static final Identifier RAW_POLVORONE_CC = item("raw_polvorone_cc");
    public static final Identifier POLVORONE_CC = item("polvorone_cc");

    public static final Identifier PANDESAL_RAW = item("pandesal_raw");
    public static final Identifier PANDESAL = item("pandesal");
    public static final Identifier PANDESAL_UBE_RAW = item("pandesal_ube_raw");
    public static final Identifier PANDESAL_UBE = item("pandesal_ube");
    public static final Identifier ENSAYMADA_RAW = item("ensaymada_raw");
    public static final Identifier ENSAYMADA = item("ensaymada");
    public static final Identifier ENSAYMADA_UBE_RAW = item("ensaymada_ube_raw");
    public static final Identifier ENSAYMADA_UBE = item("ensaymada_ube");
    public static final Identifier HOPIA_MUNGGO_RAW = item("hopia_munggo_raw");
    public static final Identifier HOPIA_MUNGGO = item("hopia_munggo");
    public static final Identifier HOPIA_UBE_RAW = item("hopia_ube_raw");
    public static final Identifier HOPIA_UBE = item("hopia_ube");

    public static final Identifier POLVORONE_STAGE0 = item("polvorone_stage0");
    public static final Identifier POLVORONE_STAGE1 = item("polvorone_stage1");
    public static final Identifier POLVORONE_STAGE2 = item("polvorone_stage2");
    public static final Identifier POLVORONE_PINIPIG_STAGE0 = item("polvorone_pinipig_stage0");
    public static final Identifier POLVORONE_PINIPIG_STAGE1 = item("polvorone_pinipig_stage1");
    public static final Identifier POLVORONE_PINIPIG_STAGE2 = item("polvorone_pinipig_stage2");
    public static final Identifier POLVORONE_UBE_STAGE0 = item("polvorone_ube_stage0");
    public static final Identifier POLVORONE_UBE_STAGE1 = item("polvorone_ube_stage1");
    public static final Identifier POLVORONE_UBE_STAGE2 = item("polvorone_ube_stage2");
    public static final Identifier POLVORONE_CC_STAGE0 = item("polvorone_cc_stage0");
    public static final Identifier POLVORONE_CC_STAGE1 = item("polvorone_cc_stage1");
    public static final Identifier POLVORONE_CC_STAGE2 = item("polvorone_cc_stage2");

    public static final Identifier PANDESAL_STAGE0 = item("pandesal_stage0");
    public static final Identifier PANDESAL_STAGE1 = item("pandesal_stage1");
    public static final Identifier PANDESAL_STAGE2 = item("pandesal_stage2");
    public static final Identifier PANDESAL_UBE_STAGE0 = item("pandesal_ube_stage0");
    public static final Identifier PANDESAL_UBE_STAGE1 = item("pandesal_ube_stage1");
    public static final Identifier PANDESAL_UBE_STAGE2 = item("pandesal_ube_stage2");
    public static final Identifier ENSAYMADA_STAGE0 = item("ensaymada_stage0");
    public static final Identifier ENSAYMADA_STAGE1 = item("ensaymada_stage1");
    public static final Identifier ENSAYMADA_STAGE2 = item("ensaymada_stage2");
    public static final Identifier ENSAYMADA_STAGE3 = item("ensaymada_stage3");
    public static final Identifier ENSAYMADA_UBE_STAGE0 = item("ensaymada_ube_stage0");
    public static final Identifier ENSAYMADA_UBE_STAGE1 = item("ensaymada_ube_stage1");
    public static final Identifier ENSAYMADA_UBE_STAGE2 = item("ensaymada_ube_stage2");
    public static final Identifier ENSAYMADA_UBE_STAGE3 = item("ensaymada_ube_stage3");
    public static final Identifier HOPIA_MUNGGO_STAGE0 = item("hopia_munggo_stage0");
    public static final Identifier HOPIA_MUNGGO_STAGE1 = item("hopia_munggo_stage1");
    public static final Identifier HOPIA_MUNGGO_STAGE2 = item("hopia_munggo_stage2");
    public static final Identifier HOPIA_UBE_STAGE0 = item("hopia_ube_stage0");
    public static final Identifier HOPIA_UBE_STAGE1 = item("hopia_ube_stage1");
    public static final Identifier HOPIA_UBE_STAGE2 = item("hopia_ube_stage2");

    private static Identifier item(String string) {
        return TextUtils.res(string);
    }

    public static void init() {
    }

}
