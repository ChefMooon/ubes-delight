package com.chefmoon.ubesdelight;

import com.chefmoon.ubesdelight.networking.ModMessages;
import com.chefmoon.ubesdelight.registry.*;
import com.chefmoon.ubesdelight.util.GeneralRegistryUtil;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

public class UbesDelightMod implements ModInitializer {
    public static final String MOD_ID = "ubesdelight";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static Configuration CONFIG = new Configuration();
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID),
            () -> new ItemStack(ItemsRegistry.UBE.get()));

    public static MutableText tooltip(String key, Object... args) {
        return Text.translatable(MOD_ID + "." + key, args);
    }

    @Override
    public void onInitialize() {
        initConfiguration();

        ItemsRegistry.registerAll();
        BlocksRegistry.registerAll();
        BlockEntityTypesRegistry.registerAll();
        ConfiguredFeaturesRegistry.registerAll();
        PlacementModifiersRegistry.registerAll();
        BiomeFeaturesRegistry.registerAll();
        RecipeTypesRegistry.registerAll();
        AdvancementsRegistry.registerAll();
        SoundsRegistry.registerAll();
        GeneralRegistryUtil.register();
        ModMessages.registerC2SPackets();
    }

    private void initConfiguration() {
        CONFIG = Configuration.load();

        ResourceConditions.register(new Identifier(MOD_ID, "ud_crates_enabled"),
                jsonObject -> UbesDelightMod.CONFIG.isEnableUDCropCrates());

        ResourceConditions.register(new Identifier(MOD_ID, "garlic_compat"),
                jsonObject -> UbesDelightMod.CONFIG.isEnableGarlicCompat());

        ResourceConditions.register(new Identifier(MOD_ID, "ginger_compat"),
                jsonObject -> UbesDelightMod.CONFIG.isEnableGingerCompat());
    }
}