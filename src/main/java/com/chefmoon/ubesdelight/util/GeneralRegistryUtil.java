package com.chefmoon.ubesdelight.util;

import com.chefmoon.ubesdelight.util.registryutil.BiomeModificationUtil;
import com.chefmoon.ubesdelight.util.registryutil.LootTableUtil;
import com.chefmoon.ubesdelight.util.registryutil.TradeUtil;

public class GeneralRegistryUtil {

    public static void register() {
        LootTableUtil.register();
        BiomeModificationUtil.register();
        TradeUtil.register();
    }
}
