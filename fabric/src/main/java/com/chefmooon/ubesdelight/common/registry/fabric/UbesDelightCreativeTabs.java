package com.chefmooon.ubesdelight.common.registry.fabric;

import com.chefmooon.ubesdelight.UbesDelight;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class UbesDelightCreativeTabs {
    public static final ResourceKey<CreativeModeTab> ITEM_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB, UbesDelight.res(UbesDelight.MOD_ID));

    public static void register() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEM_GROUP, FabricItemGroup.builder()
                .title(Component.translatable("itemGroup." + UbesDelight.MOD_ID))
                .icon(() -> new ItemStack(UbesDelightItemsImpl.UBE))
                .build());
    }
}
