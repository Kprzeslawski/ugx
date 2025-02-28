package net.kprzeslawski.ugx.worldgen.dimension;

import com.mojang.datafixers.util.Pair;
import net.kprzeslawski.ugx.worldgen.biome.UGXBiomes;
import net.kprzeslawski.ugx.worldgen.chunk.UGXFlatMeshChunkGenerator;
import net.kprzeslawski.ugx.worldgen.chunk.UGXFlatPatternChunkGenerator;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.FixedBiomeSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class UGXCustomDimensionsStems {
    private final HolderGetter<DimensionType> dimTypes;
    private final HolderGetter<Biome> biomeHolderGetter;
    public UGXCustomDimensionsStems(BootstrapContext<LevelStem> context){
        dimTypes = context.lookup(Registries.DIMENSION_TYPE);
        biomeHolderGetter = context.lookup(Registries.BIOME);
    }
    public LevelStem createDimensionLevelStem_LV1(){
        UGXFlatMeshChunkGenerator ugxFlatMeshChunkGenerator =
                new UGXFlatMeshChunkGenerator(
                        new FixedBiomeSource(biomeHolderGetter.getOrThrow(UGXBiomes.BIOME_L1))
                );

        List<Pair<Double, Block>> blockAtLayer = new LinkedList<>();
        blockAtLayer.add(new Pair(1.,Blocks.STONE));
        blockAtLayer.add(new Pair(1.,Blocks.COBBLESTONE));
        blockAtLayer.add(new Pair(1.,Blocks.BLACKSTONE));
        blockAtLayer.add(new Pair(1.,Blocks.OBSIDIAN));

        ugxFlatMeshChunkGenerator.setLevel(16);
        ugxFlatMeshChunkGenerator.setBlockProb(blockAtLayer);

        return new LevelStem(dimTypes.getOrThrow(UGXDimensions.UGX_DIM_TYPE), ugxFlatMeshChunkGenerator);
    }

    public LevelStem createDimensionLevelStem_LV2(){
        UGXFlatMeshChunkGenerator ugxFlatMeshChunkGenerator =
                new UGXFlatMeshChunkGenerator(
                        new FixedBiomeSource(biomeHolderGetter.getOrThrow(UGXBiomes.BIOME_L2))
                );

        List<Pair<Double, Block>> blockAtLayer = new LinkedList<>();
        blockAtLayer.add(new Pair(1.,Blocks.STONE));
        blockAtLayer.add(new Pair(1.,Blocks.COBBLESTONE));
        blockAtLayer.add(new Pair(1.,Blocks.BLACKSTONE));
        blockAtLayer.add(new Pair(1.,Blocks.OBSIDIAN));

        ugxFlatMeshChunkGenerator.setLevel(16);
        ugxFlatMeshChunkGenerator.setBlockProb(blockAtLayer);

        return new LevelStem(dimTypes.getOrThrow(UGXDimensions.UGX_DIM_TYPE), ugxFlatMeshChunkGenerator);
    }

    public LevelStem createDimensionLevelStem_LV3(){
        UGXFlatMeshChunkGenerator ugxFlatMeshChunkGenerator =
                new UGXFlatMeshChunkGenerator(
                        new FixedBiomeSource(biomeHolderGetter.getOrThrow(UGXBiomes.BIOME_L3))
                );

        List<Pair<Double, Block>> blockAtLayer = new LinkedList<>();
        blockAtLayer.add(new Pair(1.,Blocks.STONE));
        blockAtLayer.add(new Pair(1.,Blocks.COBBLESTONE));
        blockAtLayer.add(new Pair(1.,Blocks.BLACKSTONE));
        blockAtLayer.add(new Pair(1.,Blocks.OBSIDIAN));

        ugxFlatMeshChunkGenerator.setLevel(16);
        ugxFlatMeshChunkGenerator.setBlockProb(blockAtLayer);

        return new LevelStem(dimTypes.getOrThrow(UGXDimensions.UGX_DIM_TYPE), ugxFlatMeshChunkGenerator);
    }

    public LevelStem createDimensionLevelStem_LV4(){
        UGXFlatMeshChunkGenerator ugxFlatMeshChunkGenerator =
                new UGXFlatMeshChunkGenerator(
                        new FixedBiomeSource(biomeHolderGetter.getOrThrow(UGXBiomes.BIOME_L4))
                );

        List<Pair<Double, Block>> blockAtLayer = new LinkedList<>();
        blockAtLayer.add(new Pair(1.,Blocks.STONE));
        blockAtLayer.add(new Pair(1.,Blocks.COBBLESTONE));
        blockAtLayer.add(new Pair(1.,Blocks.BLACKSTONE));
        blockAtLayer.add(new Pair(1.,Blocks.OBSIDIAN));

        ugxFlatMeshChunkGenerator.setLevel(16);
        ugxFlatMeshChunkGenerator.setBlockProb(blockAtLayer);

        return new LevelStem(dimTypes.getOrThrow(UGXDimensions.UGX_DIM_TYPE), ugxFlatMeshChunkGenerator);
    }

    public LevelStem createDimensionLevelStem_LV5(){
        UGXFlatMeshChunkGenerator ugxFlatMeshChunkGenerator =
                new UGXFlatMeshChunkGenerator(
                        new FixedBiomeSource(biomeHolderGetter.getOrThrow(UGXBiomes.BIOME_L5))
                );

        List<Pair<Double, Block>> blockAtLayer = new LinkedList<>();
        blockAtLayer.add(new Pair(1.,Blocks.STONE));
        blockAtLayer.add(new Pair(1.,Blocks.COBBLESTONE));
        blockAtLayer.add(new Pair(1.,Blocks.BLACKSTONE));
        blockAtLayer.add(new Pair(1.,Blocks.OBSIDIAN));

        ugxFlatMeshChunkGenerator.setLevel(16);
        ugxFlatMeshChunkGenerator.setBlockProb(blockAtLayer);

        return new LevelStem(dimTypes.getOrThrow(UGXDimensions.UGX_DIM_TYPE), ugxFlatMeshChunkGenerator);
    }

    public LevelStem createDimensionLevelStem_LV6(){
        UGXFlatPatternChunkGenerator ugxFlatPatternChunkGenerator =
                new UGXFlatPatternChunkGenerator(
                        new FixedBiomeSource(biomeHolderGetter.getOrThrow(UGXBiomes.BIOME_L6))
                );

        List<List<BlockState>> blockPattern = Arrays.asList(
                Arrays.asList(Blocks.BLACKSTONE.defaultBlockState(),Blocks.OBSIDIAN.defaultBlockState()),
                Arrays.asList(Blocks.BASALT.defaultBlockState(),Blocks.BLACKSTONE.defaultBlockState())
        );

        ugxFlatPatternChunkGenerator.setLevel(16);
        ugxFlatPatternChunkGenerator.setPattern(blockPattern);

        return new LevelStem(dimTypes.getOrThrow(UGXDimensions.UGX_DIM_TYPE), ugxFlatPatternChunkGenerator);
    }

    public LevelStem createDimensionLevelStem_LV7(){
        UGXFlatPatternChunkGenerator ugxFlatPatternChunkGenerator =
                new UGXFlatPatternChunkGenerator(
                        new FixedBiomeSource(biomeHolderGetter.getOrThrow(UGXBiomes.BIOME_L7))
                );

        List<List<BlockState>> blockPattern = Arrays.asList(
                Arrays.asList(Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState()),
                Arrays.asList(Blocks.DEEPSLATE_TILES.defaultBlockState()),
                Arrays.asList(Blocks.DEEPSLATE_BRICKS.defaultBlockState()),
                Arrays.asList(Blocks.COBBLED_DEEPSLATE.defaultBlockState()),
                Arrays.asList(Blocks.DEEPSLATE.defaultBlockState()),
                Arrays.asList(Blocks.STONE_BRICKS.defaultBlockState()),
                Arrays.asList(Blocks.ANDESITE.defaultBlockState()),
                Arrays.asList(Blocks.CLAY.defaultBlockState()),
                Arrays.asList(Blocks.DIORITE.defaultBlockState()),
                Arrays.asList(Blocks.CALCITE.defaultBlockState())
        );

        ugxFlatPatternChunkGenerator.setLevel(16);
        ugxFlatPatternChunkGenerator.setPattern(blockPattern);

        return new LevelStem(dimTypes.getOrThrow(UGXDimensions.UGX_DIM_TYPE), ugxFlatPatternChunkGenerator);
    }

    public LevelStem createDimensionLevelStem_LV8(){
        UGXFlatPatternChunkGenerator ugxFlatPatternChunkGenerator =
                new UGXFlatPatternChunkGenerator(
                        new FixedBiomeSource(biomeHolderGetter.getOrThrow(UGXBiomes.BIOME_L8))
                );

        List<List<BlockState>> blockPattern = Arrays.asList(
                Arrays.asList(Blocks.BLACKSTONE.defaultBlockState(),Blocks.OBSIDIAN.defaultBlockState()),
                Arrays.asList(Blocks.BASALT.defaultBlockState(),Blocks.BLACKSTONE.defaultBlockState())
        );

        ugxFlatPatternChunkGenerator.setLevel(16);
        ugxFlatPatternChunkGenerator.setPattern(blockPattern);

        return new LevelStem(dimTypes.getOrThrow(UGXDimensions.UGX_DIM_TYPE), ugxFlatPatternChunkGenerator);
    }

    public LevelStem createDimensionLevelStem_LV9(){
        UGXFlatPatternChunkGenerator ugxFlatPatternChunkGenerator =
                new UGXFlatPatternChunkGenerator(
                        new FixedBiomeSource(biomeHolderGetter.getOrThrow(UGXBiomes.BIOME_L9))
                );

        List<List<BlockState>> blockPattern = Arrays.asList(
                Arrays.asList(Blocks.BLACKSTONE.defaultBlockState(),Blocks.OBSIDIAN.defaultBlockState()),
                Arrays.asList(Blocks.BASALT.defaultBlockState(),Blocks.BLACKSTONE.defaultBlockState())
        );

        ugxFlatPatternChunkGenerator.setLevel(16);
        ugxFlatPatternChunkGenerator.setPattern(blockPattern);

        return new LevelStem(dimTypes.getOrThrow(UGXDimensions.UGX_DIM_TYPE), ugxFlatPatternChunkGenerator);
    }

    public LevelStem createDimensionLevelStem_LV10(){
        UGXFlatPatternChunkGenerator ugxFlatPatternChunkGenerator =
                new UGXFlatPatternChunkGenerator(
                        new FixedBiomeSource(biomeHolderGetter.getOrThrow(UGXBiomes.BIOME_L10))
                );

        List<List<BlockState>> blockPattern = Arrays.asList(
                Arrays.asList(Blocks.BLACKSTONE.defaultBlockState(),Blocks.OBSIDIAN.defaultBlockState()),
                Arrays.asList(Blocks.BASALT.defaultBlockState(),Blocks.BLACKSTONE.defaultBlockState())
        );

        ugxFlatPatternChunkGenerator.setLevel(16);
        ugxFlatPatternChunkGenerator.setPattern(blockPattern);

        return new LevelStem(dimTypes.getOrThrow(UGXDimensions.UGX_DIM_TYPE), ugxFlatPatternChunkGenerator);
    }

}
