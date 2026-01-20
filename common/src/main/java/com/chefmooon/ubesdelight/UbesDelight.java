package com.chefmooon.ubesdelight;

import com.chefmooon.ubesdelight.common.Configuration;
import com.chefmooon.ubesdelight.common.registry.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UbesDelight {
    public static final String MOD_ID = "ubesdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static MutableComponent tooltip(String key, Object... args) {
        return Component.translatable(MOD_ID + "." + key, args);
    }
    public static Identifier res(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }

    public static void init() {
        Configuration.init();

        UbesDelightSounds.init();
        UbesDelightBlocks.init();
        UbesDelightItems.init();
        UbesDelightBlockEntityTypes.init();
        UbesDelightBiomeFeatures.init();
        UbesDelightBiomeModifiers.init();
        UbesDelightPlacementModifiers.init();
        UbesDelightAdvancements.init();
        UbesDelightRecipeBookCategories.init();
    }

    @ExpectPlatform
    public static String findVersion() {
        throw new AssertionError();
    }

}
