package net.kprzeslawski.ugx.datagen;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.worldgen.biome.UGXBiomes;
import net.kprzeslawski.ugx.worldgen.dimension.UGXDimensions;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class UGXWorldGenProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.DIMENSION_TYPE, UGXDimensions::bootstrapType)
            .add(Registries.BIOME, UGXBiomes::bootstrap)
            .add(Registries.LEVEL_STEM, UGXDimensions::bootstrapStem)
    ;
    public UGXWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(UGX.MOD_ID));
    }
}
