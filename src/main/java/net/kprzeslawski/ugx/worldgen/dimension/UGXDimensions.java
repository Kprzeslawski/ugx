package net.kprzeslawski.ugx.worldgen.dimension;

import net.kprzeslawski.ugx.UGX;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;

import java.awt.*;
import java.util.Objects;
import java.util.OptionalLong;

public class UGXDimensions {
    public static final ResourceKey<LevelStem> UGX_DL1 = registerLS("ugx_dl1");
    public static final ResourceKey<LevelStem> UGX_DL2 = registerLS("ugx_dl2");
    public static final ResourceKey<LevelStem> UGX_DL3 = registerLS("ugx_dl3");
    public static final ResourceKey<LevelStem> UGX_DL4 = registerLS("ugx_dl4");
    public static final ResourceKey<LevelStem> UGX_DL5 = registerLS("ugx_dl5");
    public static final ResourceKey<LevelStem> UGX_DL6 = registerLS("ugx_dl6");
    public static final ResourceKey<LevelStem> UGX_DL7 = registerLS("ugx_dl7");
    public static final ResourceKey<LevelStem> UGX_DL8 = registerLS("ugx_dl8");
    public static final ResourceKey<LevelStem> UGX_DL9 = registerLS("ugx_dl9");
    public static final ResourceKey<LevelStem> UGX_DL10 = registerLS("ugx_dl10");
    public static final ResourceKey<Level> UGX_DIM_L1 = registerL("ugx_dl1");
    public static final ResourceKey<Level> UGX_DIM_L2 = registerL("ugx_dl2");
    public static final ResourceKey<Level> UGX_DIM_L3 = registerL("ugx_dl3");
    public static final ResourceKey<Level> UGX_DIM_L4 = registerL("ugx_dl4");
    public static final ResourceKey<Level> UGX_DIM_L5 = registerL("ugx_dl5");
    public static final ResourceKey<Level> UGX_DIM_L6 = registerL("ugx_dl6");
    public static final ResourceKey<Level> UGX_DIM_L7 = registerL("ugx_dl7");
    public static final ResourceKey<Level> UGX_DIM_L8 = registerL("ugx_dl8");
    public static final ResourceKey<Level> UGX_DIM_L9 = registerL("ugx_dl9");
    public static final ResourceKey<Level> UGX_DIM_L10 = registerL("ugx_dl10");

    public static final ResourceKey<DimensionType> UGX_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE,
            Objects.requireNonNull(ResourceLocation.tryBuild(UGX.MOD_ID, "ugx_dim_key")));

    public static void bootstrapType(BootstrapContext<DimensionType> context) {
        context.register(UGX_DIM_TYPE, new DimensionType( OptionalLong.empty(),
                false, false, false, false, 1.0,
                true, false, 0, 16, 16,
                BlockTags.INFINIBURN_OVERWORLD, BuiltinDimensionTypes.NETHER_EFFECTS, .5f,
                new DimensionType.MonsterSettings(false, false, ConstantInt.of(15), 15)));
    }

    public static void bootstrapStem(BootstrapContext<LevelStem> context) {
        UGXCustomDimensionsStems ugxCustomDimensionsStems = new UGXCustomDimensionsStems(context);

        context.register(UGX_DL1, ugxCustomDimensionsStems.createDimensionLevelStem_LV1());
        context.register(UGX_DL2, ugxCustomDimensionsStems.createDimensionLevelStem_LV2());
        context.register(UGX_DL3, ugxCustomDimensionsStems.createDimensionLevelStem_LV3());
        context.register(UGX_DL4, ugxCustomDimensionsStems.createDimensionLevelStem_LV4());
        context.register(UGX_DL5, ugxCustomDimensionsStems.createDimensionLevelStem_LV5());
        context.register(UGX_DL6, ugxCustomDimensionsStems.createDimensionLevelStem_LV6());
        context.register(UGX_DL7, ugxCustomDimensionsStems.createDimensionLevelStem_LV7());
        context.register(UGX_DL8, ugxCustomDimensionsStems.createDimensionLevelStem_LV8());
        context.register(UGX_DL9, ugxCustomDimensionsStems.createDimensionLevelStem_LV9());
        context.register(UGX_DL10, ugxCustomDimensionsStems.createDimensionLevelStem_LV10());
    }

    public static ResourceKey<Level> registerL(String name){
        return ResourceKey.create(Registries.DIMENSION, Objects.requireNonNull(ResourceLocation.tryBuild(UGX.MOD_ID, name)));
    }
    public static ResourceKey<LevelStem> registerLS(String name){
        return ResourceKey.create(Registries.LEVEL_STEM, Objects.requireNonNull(ResourceLocation.tryBuild(UGX.MOD_ID, name)));
    }
}
