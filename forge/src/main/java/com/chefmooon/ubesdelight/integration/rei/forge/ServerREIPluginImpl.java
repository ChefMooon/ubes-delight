package com.chefmooon.ubesdelight.integration.rei.forge;

import com.chefmooon.ubesdelight.integration.rei.baking_mat.forge.BakingMatRecipeDisplay;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.plugins.REIServerPlugin;
import me.shedaniel.rei.forge.REIPluginDedicatedServer;

@REIPluginDedicatedServer
public class ServerREIPluginImpl implements REIServerPlugin {
    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(REICategoryIdentifiersImpl.BAKING_MAT, BakingMatRecipeDisplay.serializer());
    }
}
