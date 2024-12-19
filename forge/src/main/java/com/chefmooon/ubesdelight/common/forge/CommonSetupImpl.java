package com.chefmooon.ubesdelight.common.forge;

import com.chefmooon.ubesdelight.common.CommonSetup;
import com.chefmooon.ubesdelight.common.crafting.condition.forge.UDCrateEnabledCondition;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetupImpl {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CommonSetup.init();
        });

        CraftingHelper.register(new UDCrateEnabledCondition.Serializer());
    }
}
