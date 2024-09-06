package com.chefmooon.ubesdelight.common.neoforge;

import com.chefmooon.ubesdelight.common.block.entity.dispenser.neoforge.BakingMatDispenseBehaviorImpl;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetupImpl {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            //CommonSetup.init();
            registerDispenserBehaviors();
        });

        //CraftingHelper.register(new UDCrateEnabledCondition.Serializer());
    }

    public static void registerDispenserBehaviors() {
        BakingMatDispenseBehaviorImpl.register();
    }
}
