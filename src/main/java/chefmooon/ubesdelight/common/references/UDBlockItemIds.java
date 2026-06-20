package chefmooon.ubesdelight.common.references;

import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class UDBlockItemIds {
    public static final BlockItemId KALAN = id("kalan");
    public static final BlockItemId BAKING_MAT_BAMBOO = id("baking_mat_bamboo");

    public static final BlockItemId UBE_CRATE = id("ube_crate");
    public static final BlockItemId GARLIC_CRATE = id("garlic_crate");
    public static final BlockItemId GINGER_CRATE = id("ginger_crate");
    public static final BlockItemId LEMONGRASS_CRATE = id("lemongrass_crate");

    public static final BlockItemId WILD_UBE = id("wild_ube");
    public static final BlockItemId WILD_GARLIC = id("wild_garlic");
    public static final BlockItemId WILD_GINGER = id("wild_ginger");
    public static final BlockItemId WILD_LEMONGRASS = id("wild_lemongrass");
    public static final BlockItemId UBE_CROP = id("ube_crop", "ube");
    public static final BlockItemId GARLIC_CROP = id("garlic_crop", "garlic");
    public static final BlockItemId GINGER_CROP = id("ginger_crop", "ginger");
    public static final BlockItemId LEMONGRASS_STALK_CROP = id("lemongrass_stalk_crop", "lemongrass_seeds");

    public static final BlockItemId GLASS_CUP_HALO_HALO = id("glass_cup_halo_halo", "halo_halo");
    public static final BlockItemId GLASS_CUP_MILK_TEA_UBE = id("glass_cup_milk_tea_ube", "milk_tea_ube");

    public static final BlockItemId UBE_CAKE = id("ube_cake");
    public static final BlockItemId LECHE_FLAN_FEAST = id("leche_flan_feast");
    public static final BlockItemId HALO_HALO_FEAST = id("halo_halo_feast");
    public static final BlockItemId MILK_TEA_UBE_FEAST = id("milk_tea_ube_feast");

    public static final BlockItemId LEAF_FEAST = id("leaf_feast");
    public static final BlockItemId LUMPIA_FEAST = id("lumpia_feast");
    public static final BlockItemId LEAF_FEAST_ENSAYMADA = id("leaf_feast_ensaymada");
    public static final BlockItemId LEAF_FEAST_ENSAYMADA_UBE = id("leaf_feast_ensaymada_ube");
    public static final BlockItemId LEAF_FEAST_PANDESAL = id("leaf_feast_pandesal");
    public static final BlockItemId LEAF_FEAST_PANDESAL_UBE = id("leaf_feast_pandesal_ube");
    public static final BlockItemId LEAF_FEAST_HOPIA_MUNGGO = id("leaf_feast_hopia_munggo");
    public static final BlockItemId LEAF_FEAST_HOPIA_UBE = id("leaf_feast_hopia_ube");
    public static final BlockItemId LEAF_FEAST_COOKED_RICE = id("leaf_feast_cooked_rice");
    public static final BlockItemId LEAF_FEAST_FRIED_RICE = id("leaf_feast_fried_rice");
    public static final BlockItemId LEAF_FEAST_SINANGAG = id("leaf_feast_sinangag");

    private static BlockItemId id(final String blockName, final String itemName) {
        Identifier blockId = TextUtils.res(blockName);
        Identifier itemId = TextUtils.res(itemName);
        return BlockItemId.create(blockId, itemId);
    }

    private static BlockItemId id(final String name) {
        return id(name, name);
    }
}
