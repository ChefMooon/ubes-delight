package com.chefmooon.ubesdelight.integration.wthit.provider;

import com.chefmooon.ubesdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.ubesdelight.common.utility.TextUtils;
import com.chefmooon.ubesdelight.integration.wthit.UbesDelightWailaPlugin;
import mcp.mobius.waila.api.IBlockAccessor;
import mcp.mobius.waila.api.IBlockComponentProvider;
import mcp.mobius.waila.api.IPluginConfig;
import mcp.mobius.waila.api.ITooltip;

public enum DrinkableFeastProvider implements IBlockComponentProvider {
    INSTANCE;

    @Override
    public void appendBody(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config) {
        if (config.getBoolean(UbesDelightWailaPlugin.Options.PUNCHBOWL_SERVINGS)) {
            if (accessor.getBlock() instanceof DrinkableFeastBlock punchbowl) {
                addServingTooltip(tooltip, accessor.getBlockState().getValue(punchbowl.getServingsProperty()));
            }
        }
    }

    private static void addServingTooltip(ITooltip tooltip, int servings) {
        tooltip.addLine(TextUtils.getTranslatable("tooltip.waila.punchbowl_servings").append(": ")
                .append(String.valueOf(servings))
        );
    }
}
