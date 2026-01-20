package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.ToIntFunction;

public class UbesDelightBlocks {

    public static final Identifier KALAN = block("kalan");
    public static final Identifier BAKING_MAT_BAMBOO = block("baking_mat_bamboo");

    public static final Identifier UBE_CRATE = block("ube_crate");
    public static final Identifier GARLIC_CRATE = block("garlic_crate");
    public static final Identifier GINGER_CRATE = block("ginger_crate");
    public static final Identifier LEMONGRASS_CRATE = block("lemongrass_crate");

    public static final Identifier WILD_UBE = block("wild_ube");
    public static final Identifier WILD_GARLIC = block("wild_garlic");
    public static final Identifier WILD_GINGER = block("wild_ginger");
    public static final Identifier WILD_LEMONGRASS = block("wild_lemongrass");
    public static final Identifier POTTED_UBE = block("potted_ube");
    public static final Identifier POTTED_GARLIC = block("potted_garlic");
    public static final Identifier POTTED_GINGER = block("potted_ginger");

    public static final Identifier UBE_CROP = block("ube_crop");
    public static final Identifier GARLIC_CROP = block("garlic_crop");
    public static final Identifier GINGER_CROP = block("ginger_crop");
    public static final Identifier LEMONGRASS_CROP = block("lemongrass_crop"); //TODO: datafixer this
    public static final Identifier LEMONGRASS_STALK_CROP = block("lemongrass_stalk_crop");
    public static final Identifier LEMONGRASS_LEAF_CROP = block("lemongrass_leaf_crop");

    public static final Identifier GLASS_CUP_HALO_HALO = block("glass_cup_halo_halo");
    public static final Identifier GLASS_CUP_MILK_TEA_UBE = block("glass_cup_milk_tea_ube");

    public static final Identifier UBE_CAKE = block("ube_cake");
    public static final Identifier LECHE_FLAN_FEAST = block("leche_flan_feast");
    public static final Identifier HALO_HALO_FEAST = block("halo_halo_feast");
    public static final Identifier MILK_TEA_UBE_FEAST = block("milk_tea_ube_feast");
    public static final Identifier LUMPIA_FEAST = block("lumpia_feast");

    public static final Identifier LEAF_FEAST = block("leaf_feast");
    public static final Identifier UNIVERSAL_LEAF_FEAST = block("universal_leaf_feast");

    public static final Identifier LEAF_FEAST_ENSAYMADA = block("leaf_feast_ensaymada");
    public static final Identifier LEAF_FEAST_ENSAYMADA_HALF = block("leaf_feast_ensaymada_half");

    public static final Identifier LEAF_FEAST_ENSAYMADA_UBE = block("leaf_feast_ensaymada_ube");
    public static final Identifier LEAF_FEAST_ENSAYMADA_UBE_HALF = block("leaf_feast_ensaymada_ube_half");

    public static final Identifier LEAF_FEAST_PANDESAL = block("leaf_feast_pandesal");
    public static final Identifier LEAF_FEAST_PANDESAL_HALF = block("leaf_feast_pandesal_half");

    public static final Identifier LEAF_FEAST_PANDESAL_UBE = block("leaf_feast_pandesal_ube");
    public static final Identifier LEAF_FEAST_PANDESAL_UBE_HALF = block("leaf_feast_pandesal_ube_half");

    public static final Identifier LEAF_FEAST_HOPIA_MUNGGO = block("leaf_feast_hopia_munggo");
    public static final Identifier LEAF_FEAST_HOPIA_MUNGGO_HALF = block("leaf_feast_hopia_munggo_half");

    public static final Identifier LEAF_FEAST_HOPIA_UBE = block("leaf_feast_hopia_ube");
    public static final Identifier LEAF_FEAST_HOPIA_UBE_HALF = block("leaf_feast_hopia_ube_half");
    public static final Identifier LEAF_FEAST_COOKED_RICE = block("leaf_feast_cooked_rice");
    public static final Identifier LEAF_FEAST_COOKED_RICE_HALF = block("leaf_feast_cooked_rice_half");
    public static final Identifier LEAF_FEAST_FRIED_RICE = block("leaf_feast_fried_rice");
    public static final Identifier LEAF_FEAST_FRIED_RICE_HALF = block("leaf_feast_fried_rice_half");
    public static final Identifier LEAF_FEAST_SINANGAG = block("leaf_feast_sinangag");
    public static final Identifier LEAF_FEAST_SINANGAG_HALF = block("leaf_feast_sinangag_half");

    public static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    private static Identifier block(String string) {
        return TextUtils.res(string);
    }

    public static void init() {
    }

}
