package com.chefmooon.ubesdelight.common.utility;

import com.chefmooon.ubesdelight.UbesDelight;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;

public class TextUtils {

    public static MutableComponent getTranslatable(String string, Object... args) {
        return Component.translatable(UbesDelight.MOD_ID + "." + string, args);
    }

    public static ResourceLocation res(String string) {
        return ResourceLocation.fromNamespaceAndPath(UbesDelight.MOD_ID, string);
    }
}
