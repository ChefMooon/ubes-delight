package com.chefmooon.ubesdelight.integration.rei.fabric;

import com.chefmooon.ubesdelight.integration.rei.baking_mat.fabric.BakingMatRecipeDisplay;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.plugins.REIServerPlugin;

public class ServerREIPluginImpl implements REIServerPlugin {
    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(REICategoryIdentifiersImpl.BAKING_MAT, BakingMatRecipeDisplay.serializer());
    }
}
