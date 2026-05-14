package chefmooon.ubesdelight;

import chefmooon.ubesdelight.common.crafting.condition.UDCrateEnabledCondition;
import chefmooon.ubesdelight.common.registry.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ModInitializer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UbesDelight implements ModInitializer {
    public static final String MOD_ID = "ubesdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static MutableComponent tooltip(String key, Object... args) {
        return Component.translatable(MOD_ID + "." + key, args);
    }
    public static ResourceLocation res(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }


    @Override
    public void onInitialize() {
        UbesDelightSounds.init();
        UbesDelightAdvancements.register();

        UbesDelightBlocks.register();
        UbesDelightBlockEntityTypes.register();
        UbesDelightItems.register();
        UbesDelightBiomeFeatures.register();
        UbesDelightCreativeTabs.register();
        UbesDelightDataComponentTypes.register();
        UbesDelightPlacementModifiers.register();
        UbesDelightRecipeTypes.register();
        UbesDelightRecipeSerializers.register();
//        Configuration.init();

        UDCrateEnabledCondition.init();
    }

}
