package chefmooon.ubesdelight.common.references;

import chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public class UDBlockIds {
    public static final ResourceKey<Block> POTTED_UBE = key("potted_ube");
    public static final ResourceKey<Block> POTTED_GARLIC = key("potted_garlic");
    public static final ResourceKey<Block> POTTED_GINGER = key("potted_ginger");

    public static final ResourceKey<Block> LEMONGRASS_LEAF_CROP = key("lemongrass_leaf_crop");
    public static final ResourceKey<Block> UNIVERSAL_LEAF_FEAST = key("universal_leaf_feast");
    private static ResourceKey<Block> key(final String name) {
        return ResourceKey.create(Registries.BLOCK, TextUtils.res(name));
    }
}
