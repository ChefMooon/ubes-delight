package chefmooon.ubesdelight.integration.rei;

import chefmooon.ubesdelight.integration.rei.baking_mat.BakingMatRecipeDisplay;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.plugins.REIServerPlugin;
import me.shedaniel.rei.forge.REIPluginDedicatedServer;

@REIPluginDedicatedServer
public class ServerREIPlugin implements REIServerPlugin {
    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(REICategoryIdentifiers.BAKING_MAT, BakingMatRecipeDisplay.serializer());
    }
}
