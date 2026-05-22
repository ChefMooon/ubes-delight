package chefmooon.ubesdelight.integration.wthit;

import chefmooon.ubesdelight.common.block.DrinkableFeastBlock;
import chefmooon.ubesdelight.common.utility.TextUtils;
import chefmooon.ubesdelight.integration.wthit.provider.DrinkableFeastProvider;
import mcp.mobius.waila.api.IRegistrar;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.TooltipPosition;
import net.minecraft.resources.Identifier;

public class UbesDelightWailaPlugin implements IWailaPlugin {

    public static class Options {
        public static final Identifier PUNCHBOWL_SERVINGS = TextUtils.res("punchbowl_servings");
        public static final Identifier FEAST_SERVINGS = TextUtils.res("feast_servings"); // todo - maybe use for all feast, must make extend AbstractFeastBlock
    }

    @Override
    public void register(IRegistrar registrar) {
        registrar.addConfig(Options.PUNCHBOWL_SERVINGS, true);
        //registrar.addConfig(Options.FEAST_SERVINGS, true);

        registrar.addComponent(DrinkableFeastProvider.INSTANCE, TooltipPosition.BODY, DrinkableFeastBlock.class);
    }
}
