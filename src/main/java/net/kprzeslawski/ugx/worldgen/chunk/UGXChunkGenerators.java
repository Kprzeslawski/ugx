package net.kprzeslawski.ugx.worldgen.chunk;

import com.mojang.serialization.MapCodec;
import net.kprzeslawski.ugx.UGX;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UGXChunkGenerators {

    public static final DeferredRegister<MapCodec<? extends ChunkGenerator>> CHUNK_GENERATORS =
            DeferredRegister.create(Registries.CHUNK_GENERATOR, UGX.MOD_ID);

    public static final RegistryObject<MapCodec<? extends ChunkGenerator>> UGX_MIXED_FLAT =
            CHUNK_GENERATORS.register("ugx_mixed_flat", () -> UGXFlatMeshChunkGenerator.CODEC);


    public static final RegistryObject<MapCodec<? extends ChunkGenerator>> UGX_PATTERN_FLAT =
            CHUNK_GENERATORS.register("ugx_pattern_flat", () -> UGXFlatPatternChunkGenerator.CODEC);

    public static void register(IEventBus eventBus) {
        CHUNK_GENERATORS.register(eventBus);
    }
}
