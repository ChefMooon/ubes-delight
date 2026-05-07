package chefmooon.ubesdelight.data;

import chefmooon.ubesdelight.UbesDelight;
import chefmooon.ubesdelight.common.registry.UbesDelightBiomeModifiers;
import chefmooon.ubesdelight.common.registry.UbesDelightDamageTypes;
import chefmooon.ubesdelight.common.world.UDWildCropGeneration;
import chefmooon.ubesdelight.data.loot.UDBlockLoot;
import chefmooon.ubesdelight.data.loot.UDChestLoot;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = UbesDelight.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();

        RegistrySetBuilder registrySetBuilder = new RegistrySetBuilder()
                .add(Registries.CONFIGURED_FEATURE, UDWildCropGeneration::bootstrapConfiguredFeatures)
                .add(Registries.PLACED_FEATURE, UDWildCropGeneration::bootstrapPlacedFeatures)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, UbesDelightBiomeModifiers::bootstrapBiomeModifiers)
                .add(Registries.DAMAGE_TYPE, UbesDelightDamageTypes::bootstrapDamageTypes);
        DatapackBuiltinEntriesProvider datapackProvider = new DatapackBuiltinEntriesProvider(output, event.getLookupProvider(), registrySetBuilder, Set.of(UbesDelight.MOD_ID));
        CompletableFuture<HolderLookup.Provider> lookupProvider = datapackProvider.getRegistryProvider();
        generator.addProvider(event.includeServer(), datapackProvider);

        UDBlockTags blockTags = new UDBlockTags(output, lookupProvider, helper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new UDItemTags(output, lookupProvider, blockTags.contentsGetter(), helper));
        generator.addProvider(event.includeServer(), new UDDamageTypeTags(output, lookupProvider, UbesDelight.MOD_ID, helper));
        generator.addProvider(event.includeServer(), new UDRecipes(output, lookupProvider));
        generator.addProvider(event.includeServer(), new UDLootModifiers(output, lookupProvider, UbesDelight.MOD_ID));
        generator.addProvider(event.includeServer(), new UDDataMaps(output, lookupProvider));
        generator.addProvider(event.includeServer(), new Advancements(output, lookupProvider, helper));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(UDBlockLoot::new, LootContextParamSets.BLOCK),
                new LootTableProvider.SubProviderEntry(UDChestLoot::new, LootContextParamSets.CHEST)
        ), lookupProvider));

        BlockStates blockStates = new BlockStates(output, helper);
        generator.addProvider(event.includeClient(), blockStates);
        generator.addProvider(event.includeClient(), new UDItemModels(output, UbesDelight.MOD_ID, blockStates.models().existingFileHelper));
    }
}
