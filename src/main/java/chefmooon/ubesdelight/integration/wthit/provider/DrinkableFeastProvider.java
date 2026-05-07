package chefmooon.ubesdelight.integration.wthit.provider;

import chefmooon.ubesdelight.common.block.DrinkableFeastBlock;
import chefmooon.ubesdelight.common.utility.TextUtils;
import chefmooon.ubesdelight.integration.wthit.UbesDelightWailaPlugin;
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
