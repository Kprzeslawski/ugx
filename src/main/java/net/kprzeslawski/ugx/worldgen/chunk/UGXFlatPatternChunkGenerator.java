package net.kprzeslawski.ugx.worldgen.chunk;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;
import net.minecraftforge.common.property.Properties;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class UGXFlatPatternChunkGenerator extends ChunkGenerator {
    public static final MapCodec<UGXFlatPatternChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    BiomeSource.CODEC.fieldOf("biome").forGetter(UGXFlatPatternChunkGenerator::getBiomeSource),
                    Codec.INT.fieldOf("level").forGetter(UGXFlatPatternChunkGenerator::getLevel),
                    Codec.list(
                            BlockState.CODEC.listOf()
                    ).fieldOf("pattern").forGetter(UGXFlatPatternChunkGenerator::getPattern)
            ).apply(instance, UGXFlatPatternChunkGenerator::new));

    public UGXFlatPatternChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource);
    }
    public UGXFlatPatternChunkGenerator(BiomeSource biomeSource, int level, List<List<BlockState>> pattern) {
        super(biomeSource);
        this.level = level;
        this.pattern = pattern;
    }

    private int level;
    public List<List<BlockState>> pattern;


    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public List<List<BlockState>> getPattern() {
        return pattern;
    }

    public void setPattern(List<List<BlockState>> pattern) {
        this.pattern = pattern;
    }

    @Override
    protected MapCodec<? extends ChunkGenerator> codec() {
        return CODEC;
    }

    @Override
    public void applyCarvers(WorldGenRegion pLevel, long pSeed, RandomState pRandom, BiomeManager pBiomeManager, StructureManager pStructureManager, ChunkAccess pChunk, GenerationStep.Carving pStep) {

    }

    @Override
    public void buildSurface(WorldGenRegion pLevel, StructureManager pStructureManager, RandomState pRandom, ChunkAccess pChunk) {

    }

    @Override
    public void spawnOriginalMobs(WorldGenRegion pLevel) {

    }

    @Override
    public int getSpawnHeight(LevelHeightAccessor pLevel) {
        return pLevel.getMinBuildHeight() + Math.min(pLevel.getHeight(), this.level);
    }

    @Override
    public int getGenDepth() {
        return 384;
    }

    @Override
    public CompletableFuture<ChunkAccess> fillFromNoise(Blender pBlender, RandomState pRandomState, StructureManager pStructureManager, ChunkAccess pChunk) {

        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
        Heightmap heightmap = pChunk.getOrCreateHeightmapUnprimed(Heightmap.Types.OCEAN_FLOOR_WG);
        Heightmap heightmap1 = pChunk.getOrCreateHeightmapUnprimed(Heightmap.Types.WORLD_SURFACE_WG);

        BlockState base = Blocks.BEDROCK.defaultBlockState();

        for (int i = 0; i < Math.min(pChunk.getHeight(), this.level); i++) {
            int j = pChunk.getMinBuildHeight() + i;
            if (i == this.level - 1){
                for (int k = 0; k < 16; k++) {
                    List<BlockState> bss = pattern.get(k % pattern.size());
                    for (int l = 0; l < 16; l++) {
                        BlockState bs = bss.get(l % bss.size());

                        pChunk.setBlockState(blockpos$mutableblockpos.set(k, j, l), bs, false);
                        heightmap.update(k, j, l, bs);
                        heightmap1.update(k, j, l, bs);
                    }
                }
            } else {

                for (int k = 0; k < 16; k++) {
                    for (int l = 0; l < 16; l++) {
                        pChunk.setBlockState(blockpos$mutableblockpos.set(k, j, l), base, false);
                        heightmap.update(k, j, l, base);
                        heightmap1.update(k, j, l, base);
                    }
                }
            }
        }

        return CompletableFuture.completedFuture(pChunk);
    }

    @Override
    public int getSeaLevel() {
        return -63;
    }

    @Override
    public int getMinY() {
        return 0;
    }

    @Override
    public int getBaseHeight(int pX, int pZ, Heightmap.Types pType, LevelHeightAccessor pLevel, RandomState pRandom) {
        return pLevel.getMinBuildHeight() + Math.min(level, pLevel.getMaxBuildHeight());
    }

    public static final BlockState[] column = {
            Blocks.BEDROCK.defaultBlockState(), Blocks.BEDROCK.defaultBlockState(),
            Blocks.BEDROCK.defaultBlockState(), Blocks.BEDROCK.defaultBlockState(),
            Blocks.BEDROCK.defaultBlockState(), Blocks.BEDROCK.defaultBlockState(),
            Blocks.BEDROCK.defaultBlockState(), Blocks.BEDROCK.defaultBlockState(),
            Blocks.BEDROCK.defaultBlockState(), Blocks.BEDROCK.defaultBlockState(),
            Blocks.BEDROCK.defaultBlockState(), Blocks.BEDROCK.defaultBlockState(),
            Blocks.BEDROCK.defaultBlockState(), Blocks.BEDROCK.defaultBlockState(),
            Blocks.BEDROCK.defaultBlockState(), Blocks.BEDROCK.defaultBlockState()
    };

    @Override
    public NoiseColumn getBaseColumn(int pX, int pZ, LevelHeightAccessor pHeight, RandomState pRandom) {
        return new NoiseColumn(
                pHeight.getMinBuildHeight(),
                column
        );
    }



    @Override
    public void addDebugScreenInfo(List<String> pInfo, RandomState pRandom, BlockPos pPos) {

    }
}

