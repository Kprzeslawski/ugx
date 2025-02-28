package net.kprzeslawski.ugx.datagen.block;

import net.kprzeslawski.ugx.block.UGXBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;

public class UGXBlockLootTables extends BlockLootSubProvider {
    public UGXBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),provider);
    }

    @Override
    protected void generate() {
        this.dropSelf(UGXBlocks.ENERGIZING_STATION_BLOCK.get());
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return UGXBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
