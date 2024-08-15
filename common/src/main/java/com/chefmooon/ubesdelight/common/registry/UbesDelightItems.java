package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class UbesDelightItems {

    public static Item.Properties basicItem() {
        return new Item.Properties();
    }

    public static Item.Properties noStack() {
        return new Item.Properties().stacksTo(1);
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

    public static final ResourceLocation KALAN = item("kalan");
    public static final ResourceLocation BAKING_MAT_BAMBOO = item("baking_mat_bamboo");
    public static final ResourceLocation ROLLING_PIN_WOOD = item("rolling_pin_wood");

    public static final ResourceLocation LEAF_FEAST = item("leaf_feast");

    public static final ResourceLocation WILD_UBE = item("wild_ube");
    public static final ResourceLocation WILD_GARLIC = item("wild_garlic");
    public static final ResourceLocation WILD_GINGER = item("wild_ginger");
    public static final ResourceLocation WILD_LEMONGRASS = item("wild_lemongrass");

    public static final ResourceLocation UBE_CRATE = item("ube_crate");
    public static final ResourceLocation GARLIC_CRATE = item("garlic_crate");
    public static final ResourceLocation GINGER_CRATE = item("ginger_crate");
    public static final ResourceLocation LEMONGRASS_CRATE = item("lemongrass_crate");

    public static final ResourceLocation UBE_CAKE = item("ube_cake");
    public static final ResourceLocation LECHE_FLAN_FEAST = item("leche_flan_feast");
    public static final ResourceLocation LUMPIA_FEAST = item("lumpia_feast");
    public static final ResourceLocation HALO_HALO_FEAST = item("halo_halo_feast");
    public static final ResourceLocation MILK_TEA_UBE_FEAST = item("milk_tea_ube_feast");

    public static final ResourceLocation POISONOUS_UBE = item("poisonous_ube");
    public static final ResourceLocation UBE = item("ube");
    public static final ResourceLocation GARLIC = item("garlic");
    public static final ResourceLocation GINGER = item("ginger");
    public static final ResourceLocation LEMONGRASS = item("lemongrass");
    public static final ResourceLocation LEMONGRASS_SEEDS = item("lemongrass_seeds");

    public static final ResourceLocation CONDENSED_MILK_BOTTLE = item("condensed_milk_bottle");
    public static final ResourceLocation FISH_SAUCE_BOTTLE = item("fish_sauce_bottle");
    public static final ResourceLocation MILK_POWDER = item("milk_powder");
    public static final ResourceLocation SUGAR_BROWN = item("sugar_brown");
    public static final ResourceLocation LUMPIA_WRAPPER = item("lumpia_wrapper");

    public static final ResourceLocation MILK_TEA_UBE = item("milk_tea_ube");
    public static final ResourceLocation HALO_HALO = item("halo_halo");

    public static final ResourceLocation GARLIC_CHOP = item("garlic_chop");
    public static final ResourceLocation GINGER_CHOP = item("ginger_chop");

    public static final ResourceLocation SINANGAG = item("sinangag");
    public static final ResourceLocation KINILAW = item("kinilaw");
    public static final ResourceLocation LUMPIA = item("lumpia");
    public static final ResourceLocation TOCINO = item("tocino");
    public static final ResourceLocation CHICKEN_INASAL = item("chicken_inasal");

    public static final ResourceLocation CHICKEN_INASAL_RICE = item("chicken_inasal_rice");
    public static final ResourceLocation TOSILOG = item("tosilog");
    public static final ResourceLocation BANGSILOG = item("bangsilog");
    public static final ResourceLocation SISIG = item("sisig");
    public static final ResourceLocation BULALO = item("bulalo");
    public static final ResourceLocation ARROZ_CALDO = item("arroz_caldo");
    public static final ResourceLocation MECHADO = item("mechado");

    public static final ResourceLocation COOKIE_UBE = item("cookie_ube");
    public static final ResourceLocation COOKIE_GINGER = item("cookie_ginger");

    public static final ResourceLocation LECHE_FLAN = item("leche_flan");
    public static final ResourceLocation UBE_CAKE_SLICE = item("ube_cake_slice");

    public static final ResourceLocation RAW_POLVORONE = item("raw_polvorone");
    public static final ResourceLocation POLVORONE = item("polvorone");
    public static final ResourceLocation RAW_POLVORONE_PINIPIG = item("raw_polvorone_pinipig");
    public static final ResourceLocation POLVORONE_PINIPIG = item("polvorone_pinipig");
    public static final ResourceLocation RAW_POLVORONE_UBE = item("raw_polvorone_ube");
    public static final ResourceLocation POLVORONE_UBE = item("polvorone_ube");
    public static final ResourceLocation RAW_POLVORONE_CC = item("raw_polvorone_cc");
    public static final ResourceLocation POLVORONE_CC = item("polvorone_cc");

    public static final ResourceLocation PANDESAL_RAW = item("pandesal_raw");
    public static final ResourceLocation PANDESAL = item("pandesal");
    public static final ResourceLocation PANDESAL_UBE_RAW = item("pandesal_ube_raw");
    public static final ResourceLocation PANDESAL_UBE = item("pandesal_ube");
    public static final ResourceLocation ENSAYMADA_RAW = item("ensaymada_raw");
    public static final ResourceLocation ENSAYMADA = item("ensaymada");
    public static final ResourceLocation ENSAYMADA_UBE_RAW = item("ensaymada_ube_raw");
    public static final ResourceLocation ENSAYMADA_UBE = item("ensaymada_ube");
    public static final ResourceLocation HOPIA_MUNGGO_RAW = item("hopia_munggo_raw");
    public static final ResourceLocation HOPIA_MUNGGO = item("hopia_munggo");
    public static final ResourceLocation HOPIA_UBE_RAW = item("hopia_ube_raw");
    public static final ResourceLocation HOPIA_UBE = item("hopia_ube");

    public static final ResourceLocation POLVORONE_STAGE0 = item("polvorone_stage0");
    public static final ResourceLocation POLVORONE_STAGE1 = item("polvorone_stage1");
    public static final ResourceLocation POLVORONE_STAGE2 = item("polvorone_stage2");
    public static final ResourceLocation POLVORONE_PINIPIG_STAGE0 = item("polvorone_pinipig_stage0");
    public static final ResourceLocation POLVORONE_PINIPIG_STAGE1 = item("polvorone_pinipig_stage1");
    public static final ResourceLocation POLVORONE_PINIPIG_STAGE2 = item("polvorone_pinipig_stage2");
    public static final ResourceLocation POLVORONE_UBE_STAGE0 = item("polvorone_ube_stage0");
    public static final ResourceLocation POLVORONE_UBE_STAGE1 = item("polvorone_ube_stage1");
    public static final ResourceLocation POLVORONE_UBE_STAGE2 = item("polvorone_ube_stage2");
    public static final ResourceLocation POLVORONE_CC_STAGE0 = item("polvorone_cc_stage0");
    public static final ResourceLocation POLVORONE_CC_STAGE1 = item("polvorone_cc_stage1");
    public static final ResourceLocation POLVORONE_CC_STAGE2 = item("polvorone_cc_stage2");

    public static final ResourceLocation PANDESAL_STAGE0 = item("pandesal_stage0");
    public static final ResourceLocation PANDESAL_STAGE1 = item("pandesal_stage1");
    public static final ResourceLocation PANDESAL_STAGE2 = item("pandesal_stage2");
    public static final ResourceLocation PANDESAL_UBE_STAGE0 = item("pandesal_ube_stage0");
    public static final ResourceLocation PANDESAL_UBE_STAGE1 = item("pandesal_ube_stage1");
    public static final ResourceLocation PANDESAL_UBE_STAGE2 = item("pandesal_ube_stage2");
    public static final ResourceLocation ENSAYMADA_STAGE0 = item("ensaymada_stage0");
    public static final ResourceLocation ENSAYMADA_STAGE1 = item("ensaymada_stage1");
    public static final ResourceLocation ENSAYMADA_STAGE2 = item("ensaymada_stage2");
    public static final ResourceLocation ENSAYMADA_STAGE3 = item("ensaymada_stage3");
    public static final ResourceLocation ENSAYMADA_UBE_STAGE0 = item("ensaymada_ube_stage0");
    public static final ResourceLocation ENSAYMADA_UBE_STAGE1 = item("ensaymada_ube_stage1");
    public static final ResourceLocation ENSAYMADA_UBE_STAGE2 = item("ensaymada_ube_stage2");
    public static final ResourceLocation ENSAYMADA_UBE_STAGE3 = item("ensaymada_ube_stage3");
    public static final ResourceLocation HOPIA_MUNGGO_STAGE0 = item("hopia_munggo_stage0");
    public static final ResourceLocation HOPIA_MUNGGO_STAGE1 = item("hopia_munggo_stage1");
    public static final ResourceLocation HOPIA_MUNGGO_STAGE2 = item("hopia_munggo_stage2");
    public static final ResourceLocation HOPIA_UBE_STAGE0 = item("hopia_ube_stage0");
    public static final ResourceLocation HOPIA_UBE_STAGE1 = item("hopia_ube_stage1");
    public static final ResourceLocation HOPIA_UBE_STAGE2 = item("hopia_ube_stage2");

    private static ResourceLocation item(String string) {
        return TextUtils.res(string);
    }

}
