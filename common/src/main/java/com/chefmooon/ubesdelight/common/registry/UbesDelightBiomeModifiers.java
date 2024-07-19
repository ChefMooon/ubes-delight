package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.resources.ResourceLocation;

public class UbesDelightBiomeModifiers {
    public static final ResourceLocation PATCH_WILD_UBE = biomeModifier("patch_wild_ube");
    public static final ResourceLocation PATCH_WILD_GARLIC = biomeModifier("patch_wild_garlic");
    public static final ResourceLocation PATCH_WILD_GINGER = biomeModifier("patch_wild_ginger");
    public static final ResourceLocation PATCH_WILD_LEMONGRASS = biomeModifier("patch_wild_lemongrass");

    private static ResourceLocation biomeModifier(String string) {
        return TextUtils.res(string);
    }
}
