package chefmooon.ubesdelight.common.registry;

import chefmooon.ubesdelight.UbesDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class UbesDelightCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UbesDelight.MOD_ID);
    public static final Supplier<CreativeModeTab> TAB_UBES_DELIGHT = CREATIVE_MODE_TAB.register(UbesDelight.MOD_ID,
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + UbesDelight.MOD_ID))
                    .icon(() -> new ItemStack(UbesDelightItems.UBE.get()))
                    .displayItems((parameters, output) -> UbesDelightItems.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get())))
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
