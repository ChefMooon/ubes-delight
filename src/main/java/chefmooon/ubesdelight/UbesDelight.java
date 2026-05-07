package chefmooon.ubesdelight;

import chefmooon.ubesdelight.client.UbesDelightClient;
import chefmooon.ubesdelight.common.CommonSetup;
import chefmooon.ubesdelight.common.Configuration;
import chefmooon.ubesdelight.common.registry.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(UbesDelight.MOD_ID)
public class UbesDelight {
    public static final String MOD_ID = "ubesdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static MutableComponent tooltip(String key, Object... args) {
        return Component.translatable(MOD_ID + "." + key, args);
    }
    public static ResourceLocation res(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public UbesDelight(IEventBus modEventBus, ModContainer modContainer) {
        Configuration.init();

        modEventBus.addListener(CommonSetup::init);
        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(UbesDelightClient::init);
//            modEventBus.addListener(UbesDelightClient::onBuiltinPackRegistration);
        }

        UbesDelightSounds.register(modEventBus);
        UbesDelightBlocks.register(modEventBus);
        UbesDelightItems.register(modEventBus);
        UbesDelightBlockEntityTypes.register(modEventBus);
        UbesDelightRecipeTypes.register(modEventBus);
        UbesDelightRecipeSerializers.register(modEventBus);
        UbesDelightBiomeFeatures.register(modEventBus);
        UbesDelightCreativeTabs.register(modEventBus);
        UbesDelightDataComponentTypes.register(modEventBus);
        UbesDelightPlacementModifiers.register(modEventBus);
        UbesDelightBiomeModifiers.register(modEventBus);
        UbesDelightLootModifiers.register(modEventBus);
        UbesDelightConditionCodecs.register(modEventBus);
        UbesDelightAdvancements.register(modEventBus);
    }

}
