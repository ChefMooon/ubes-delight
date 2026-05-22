package chefmooon.ubesdelight;

import chefmooon.ubesdelight.common.CommonSetup;
import chefmooon.ubesdelight.common.Configuration;
import chefmooon.ubesdelight.common.event.LootModifierEvents;
import chefmooon.ubesdelight.common.registry.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.recipe.v1.sync.RecipeSynchronization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UbesDelight implements ModInitializer {
    public static final String MOD_ID = "ubesdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    @Override
    public void onInitialize() {
        Configuration.init();

        UbesDelightAdvancements.register();
        UbesDelightSounds.register();
        UbesDelightBlocks.register();
        UbesDelightBlockEntityTypes.register();
        UbesDelightItems.register();
        UbesDelightBiomeFeatures.register();
        UbesDelightPlacementModifiers.register();
        UbesDelightCreativeTabs.register();
        UbesDelightDataComponentTypes.register();
        UbesDelightRecipeTypes.register();
        UbesDelightRecipeSerializers.register();
        UbesDelightRecipeBookCategories.register();

        CommonSetup.init();

        UbesDelightRecipeBookCategories.register();

        // 3.0.0
        LootModifierEvents.init();

        UbesDelightBiomeModifiers.init();

        RecipeSynchronization.synchronizeRecipeSerializer(UbesDelightRecipeSerializers.BAKING_MAT.get());
    }
}
