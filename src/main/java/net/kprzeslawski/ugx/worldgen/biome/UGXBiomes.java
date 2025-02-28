package net.kprzeslawski.ugx.worldgen.biome;

import net.kprzeslawski.ugx.UGX;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

import java.util.Objects;

public class UGXBiomes {

    public static final ResourceKey<Biome> BIOME_L1 = registerB("l1_biome");
    public static final ResourceKey<Biome> BIOME_L2 = registerB("l2_biome");
    public static final ResourceKey<Biome> BIOME_L3 = registerB("l3_biome");
    public static final ResourceKey<Biome> BIOME_L4 = registerB("l4_biome");
    public static final ResourceKey<Biome> BIOME_L5 = registerB("l5_biome");
    public static final ResourceKey<Biome> BIOME_L6 = registerB("l6_biome");
    public static final ResourceKey<Biome> BIOME_L7 = registerB("l7_biome");
    public static final ResourceKey<Biome> BIOME_L8 = registerB("l8_biome");
    public static final ResourceKey<Biome> BIOME_L9 = registerB("l9_biome");
    public static final ResourceKey<Biome> BIOME_L10 = registerB("l10_biome");

    public static void bootstrap(BootstrapContext<Biome> context) {
        UGXCustomBiomesLevels ugxCustomBiomesLevels = new UGXCustomBiomesLevels(context);

        context.register(BIOME_L1, ugxCustomBiomesLevels.createDimensionBiome_LV1());
        context.register(BIOME_L2, ugxCustomBiomesLevels.createDimensionBiome_LV2());
        context.register(BIOME_L3, ugxCustomBiomesLevels.createDimensionBiome_LV3());
        context.register(BIOME_L4, ugxCustomBiomesLevels.createDimensionBiome_LV4());
        context.register(BIOME_L5, ugxCustomBiomesLevels.createDimensionBiome_LV5());
        context.register(BIOME_L6, ugxCustomBiomesLevels.createDimensionBiome_LV6());
        context.register(BIOME_L7, ugxCustomBiomesLevels.createDimensionBiome_LV7());
        context.register(BIOME_L8, ugxCustomBiomesLevels.createDimensionBiome_LV8());
        context.register(BIOME_L9, ugxCustomBiomesLevels.createDimensionBiome_LV9());
        context.register(BIOME_L10, ugxCustomBiomesLevels.createDimensionBiome_LV10());
    }

    public static ResourceKey<Biome> registerB(String name){
        return ResourceKey.create(Registries.BIOME, Objects.requireNonNull(ResourceLocation.tryBuild(UGX.MOD_ID, name)));
    }
}
