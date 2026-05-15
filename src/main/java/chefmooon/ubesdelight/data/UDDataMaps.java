package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.common.registry.UbesDelightItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class UDDataMaps extends DataMapProvider {
    protected UDDataMaps(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    protected void gather(HolderLookup.Provider provider) {
        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(item(UbesDelightItems.BAKING_MAT_BAMBOO.get()), new FurnaceFuel(250), false)
        ;

        builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(item(UbesDelightItems.LEMONGRASS_SEEDS.get()), new Compostable(0.3F), false)

                .add(item(UbesDelightItems.GARLIC_CHOP.get()), new Compostable(0.4F), false)
                .add(item(UbesDelightItems.GINGER_CHOP.get()), new Compostable(0.4F), false)
                .add(item(UbesDelightItems.LUMPIA_WRAPPER.get()), new Compostable(0.4F), false)

                .add(item(UbesDelightItems.WILD_UBE.get()), new Compostable(0.65F), false)
                .add(item(UbesDelightItems.WILD_GARLIC.get()), new Compostable(0.65F), false)
                .add(item(UbesDelightItems.WILD_GINGER.get()), new Compostable(0.65F), false)
                .add(item(UbesDelightItems.WILD_LEMONGRASS.get()), new Compostable(0.65F), false)
                .add(item(UbesDelightItems.UBE.get()), new Compostable(0.65F), false)
                .add(item(UbesDelightItems.GARLIC.get()), new Compostable(0.65F), false)
                .add(item(UbesDelightItems.GINGER.get()), new Compostable(0.65F), false)
                .add(item(UbesDelightItems.LEMONGRASS.get()), new Compostable(0.65F), false)

                .add(item(UbesDelightItems.PANDESAL.get()), new Compostable(0.7F), false)
                .add(item(UbesDelightItems.PANDESAL_UBE.get()), new Compostable(0.7F), false)
                .add(item(UbesDelightItems.ENSAYMADA.get()), new Compostable(0.7F), false)
                .add(item(UbesDelightItems.ENSAYMADA_UBE.get()), new Compostable(0.7F), false)
                .add(item(UbesDelightItems.HOPIA_MUNGGO.get()), new Compostable(0.7F), false)
                .add(item(UbesDelightItems.HOPIA_UBE.get()), new Compostable(0.7F), false)

                .add(item(UbesDelightItems.COOKIE_UBE.get()), new Compostable(0.85F), false)
                .add(item(UbesDelightItems.COOKIE_GINGER.get()), new Compostable(0.85F), false)
                .add(item(UbesDelightItems.POLVORONE.get()), new Compostable(0.85F), false)
                .add(item(UbesDelightItems.POLVORONE_PINIPIG.get()), new Compostable(0.85F), false)
                .add(item(UbesDelightItems.POLVORONE_UBE.get()), new Compostable(0.85F), false)
                .add(item(UbesDelightItems.POLVORONE_CC.get()), new Compostable(0.85F), false)
                .add(item(UbesDelightItems.LECHE_FLAN.get()), new Compostable(0.85F), false)
                .add(item(UbesDelightItems.UBE_CAKE_SLICE.get()), new Compostable(0.85F), false)

                .add(item(UbesDelightItems.UBE_CAKE.get()), new Compostable(1.0F), false)
                .add(item(UbesDelightItems.LECHE_FLAN_FEAST.get()), new Compostable(1.0F), false)
        ;
    }

    private static ResourceKey<Item> item(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).orElseThrow();
    }
}
