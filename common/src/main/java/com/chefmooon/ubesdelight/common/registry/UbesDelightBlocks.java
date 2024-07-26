package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.ToIntFunction;

public class UbesDelightBlocks {

    public static final ResourceLocation KALAN = block("kalan");
    public static final ResourceLocation BAKING_MAT_BAMBOO = block("baking_mat_bamboo");

    public static final ResourceLocation UBE_CRATE = block("ube_crate");
    public static final ResourceLocation GARLIC_CRATE = block("garlic_crate");
    public static final ResourceLocation GINGER_CRATE = block("ginger_crate");
    public static final ResourceLocation LEMONGRASS_CRATE = block("lemongrass_crate");

    public static final ResourceLocation WILD_UBE = block("wild_ube");
    public static final ResourceLocation WILD_GARLIC = block("wild_garlic");
    public static final ResourceLocation WILD_GINGER = block("wild_ginger");
    public static final ResourceLocation WILD_LEMONGRASS = block("wild_lemongrass");
    public static final ResourceLocation POTTED_UBE = block("potted_ube");
    public static final ResourceLocation POTTED_GARLIC = block("potted_garlic");
    public static final ResourceLocation POTTED_GINGER = block("potted_ginger");

    public static final ResourceLocation UBE_CROP = block("ube_crop");
    public static final ResourceLocation GARLIC_CROP = block("garlic_crop");
    public static final ResourceLocation GINGER_CROP = block("ginger_crop");
    public static final ResourceLocation LEMONGRASS_CROP = block("lemongrass_crop"); //TODO: datafixer this
    public static final ResourceLocation LEMONGRASS_STALK_CROP = block("lemongrass_stalk_crop");
    public static final ResourceLocation LEMONGRASS_LEAF_CROP = block("lemongrass_leaf_crop");

    public static final ResourceLocation GLASS_CUP_HALO_HALO = block("glass_cup_halo_halo");

    public static final ResourceLocation UBE_CAKE = block("ube_cake");
    public static final ResourceLocation LECHE_FLAN_FEAST = block("leche_flan_feast");
    public static final ResourceLocation HALO_HALO_FEAST = block("halo_halo_feast");
    public static final ResourceLocation MILK_TEA_UBE_FEAST = block("milk_tea_ube_feast");
    public static final ResourceLocation LUMPIA_FEAST = block("lumpia_feast");

    public static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    private static ResourceLocation block(String string) {
        return TextUtils.res(string);
    }

}
