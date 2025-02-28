package net.kprzeslawski.ugx.worldgen.chunk;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.WorldGenRegion;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.NoiseColumn;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.blending.Blender;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class UGXFlatMeshChunkGenerator extends ChunkGenerator {
    public static final MapCodec<UGXFlatMeshChunkGenerator> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    BiomeSource.CODEC.fieldOf("biome").forGetter(UGXFlatMeshChunkGenerator::getBiomeSource),
                    Codec.INT.fieldOf("level").forGetter(UGXFlatMeshChunkGenerator::getLevel),
                    Codec.list(
                            Codec.pair(
                                    Codec.DOUBLE.fieldOf("key").codec(),
                                    BuiltInRegistries.BLOCK.byNameCodec().fieldOf("value").orElse(Blocks.AIR).codec()
                            )
                    ).fieldOf("blockProb").forGetter(UGXFlatMeshChunkGenerator::getBlockProb)
            ).apply(instance, UGXFlatMeshChunkGenerator::new));

    public UGXFlatMeshChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource);
    }
    public UGXFlatMeshChunkGenerator(BiomeSource biomeSource, int level, List<Pair<Double,Block>> lb) {
        super(biomeSource);
        this.level = level;
        this.blockProb = lb;
    }

    private int level;
    private List<Pair<Double, Block>> blockProb;

    public List<Pair<Double, Block>> getBlockProb() {
        return blockProb;
    }

    public void setBlockProb(List<Pair<Double, Block>> blockProb) {
        this.blockProb = blockProb;
    }


    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
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
                var maxVO = this.blockProb.stream().map(Pair::getFirst).reduce(Double::sum);
                if(maxVO.isEmpty())continue;
                double maxV = maxVO.get();
                Random r = new Random();

                for (int k = 0; k < 16; k++) {
                    for (int l = 0; l < 16; l++) {

                        Double randomValue = maxV * r.nextDouble();
                        BlockState bs = base;

                        for (int m = 0; m < this.blockProb.size(); m++) {
                            var p = this.blockProb.get(m);
                            if(p.getFirst() > randomValue){
                                bs = p.getSecond().defaultBlockState();
                                break;
                            }
                            randomValue -= p.getFirst();
                        }

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
