package net.kprzeslawski.ugx.datagen;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.datagen.block.UGXBlockLootTables;
import net.kprzeslawski.ugx.datagen.block.UGXBlockStateProvider;
import net.kprzeslawski.ugx.datagen.item.UGXItemModelProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = UGX.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator dataGenerator = event.getGenerator();
        PackOutput packOutput = dataGenerator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> completableFuture = event.getLookupProvider();

        dataGenerator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(UGXBlockLootTables::new, LootContextParamSets.BLOCK)), completableFuture));
        dataGenerator.addProvider(event.includeClient(), new UGXItemModelProvider(packOutput, UGX.MOD_ID, existingFileHelper));
        dataGenerator.addProvider(event.includeClient(), new UGXBlockStateProvider(packOutput, UGX.MOD_ID, existingFileHelper));
        dataGenerator.addProvider(event.includeServer(), new UGXWorldGenProvider(packOutput, completableFuture));
    }
}
