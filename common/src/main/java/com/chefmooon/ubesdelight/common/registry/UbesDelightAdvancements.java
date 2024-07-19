package com.chefmooon.ubesdelight.common.registry;

import com.chefmooon.ubesdelight.common.advancement.BakingMatTrigger;
import net.minecraft.advancements.CriteriaTriggers;

public class UbesDelightAdvancements {

    public static BakingMatTrigger BAKING_MAT = new BakingMatTrigger();

    public static void register() {
        CriteriaTriggers.register(BAKING_MAT);
    }
}
