package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.utility.TextUtils;
import net.minecraft.resources.Identifier;

public class UbesDelightBiomeModifiers {
    public static final Identifier PATCH_WILD_UBE = biomeModifier("patch_wild_ube");
    public static final Identifier PATCH_WILD_GARLIC = biomeModifier("patch_wild_garlic");
    public static final Identifier PATCH_WILD_GINGER = biomeModifier("patch_wild_ginger");
    public static final Identifier PATCH_WILD_LEMONGRASS = biomeModifier("patch_wild_lemongrass");

    private static Identifier biomeModifier(String string) {
        return TextUtils.res(string);
    }

    public static void init() {
    }
}
