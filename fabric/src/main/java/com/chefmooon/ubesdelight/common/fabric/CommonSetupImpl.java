package com.chefmooon.ubesdelight.common.fabric;

import com.chefmooon.ubesdelight.common.CommonSetup;
import com.chefmooon.ubesdelight.common.block.entity.dispenser.fabric.BakingMatDispenseBehaviorImpl;
import com.chefmooon.ubesdelight.common.crafting.condition.fabric.UDCrateEnabledCondition;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;

public class CommonSetupImpl {

    public static void init() {
        CommonSetup.init();
        registerDispenserBehaviors();

        ResourceConditions.register(UDCrateEnabledCondition.TYPE);
    }

    public static void registerDispenserBehaviors() {
        BakingMatDispenseBehaviorImpl.register();
    }
}
