package net.kprzeslawski.ugx.worldgen.biome;

import net.kprzeslawski.ugx.entity.UGXEntities;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class UGXCustomBiomesLevels {

    private final HolderGetter<PlacedFeature> placed_feature;
    private final HolderGetter<ConfiguredWorldCarver<?>> carver;
    UGXCustomBiomesLevels(BootstrapContext<Biome> context){
        placed_feature = context.lookup(Registries.PLACED_FEATURE);
        carver = context.lookup(Registries.CONFIGURED_CARVER);
    }

    public Biome createDimensionBiome_LV1() {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placed_feature,carver);
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L1.get(), 1, 1, 1));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public Biome createDimensionBiome_LV2() {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placed_feature,carver);
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L1.get(), 5, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L2.get(), 3, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_SKELETON_L1.get(), 2, 1, 1));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public Biome createDimensionBiome_LV3() {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placed_feature,carver);
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L2.get(), 5, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L3.get(), 3, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_SKELETON_L2.get(), 2, 1, 1));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public Biome createDimensionBiome_LV4() {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placed_feature,carver);
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L3.get(), 5, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L4.get(), 2, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_SKELETON_L3.get(), 2, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_W_SKELETON_L1.get(), 1, 1, 1));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public Biome createDimensionBiome_LV5() {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placed_feature,carver);
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_W_SKELETON_L1.get(), 4, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L4.get(), 2, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L5.get(), 2, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_SKELETON_L4.get(), 1, 1, 1));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public Biome createDimensionBiome_LV6() {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placed_feature,carver);
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L6.get(), 3, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_W_SKELETON_L2.get(), 5, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_VINDICATOR_L1.get(), 2, 1, 1));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public Biome createDimensionBiome_LV7() {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placed_feature,carver);
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_VINDICATOR_L1.get(), 4, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_W_SKELETON_L3.get(), 4, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L7.get(), 2, 1, 1));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public Biome createDimensionBiome_LV8() {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placed_feature,carver);
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_VINDICATOR_L2.get(), 4, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_W_SKELETON_L4.get(), 4, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_ZOMBIE_L8.get(), 2, 1, 1));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public Biome createDimensionBiome_LV9() {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placed_feature,carver);
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_VINDICATOR_L3.get(), 5, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_W_SKELETON_L5.get(), 5, 1, 1));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

    public Biome createDimensionBiome_LV10() {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placed_feature,carver);
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_VINDICATOR_L4.get(), 5, 1, 1));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(UGXEntities.EN_W_SKELETON_L6.get(), 5, 1, 1));

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }
}
