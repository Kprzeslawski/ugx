package net.kprzeslawski.ugx.entity;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.entity.custom.EnSkeleton;
import net.kprzeslawski.ugx.entity.custom.EnVindicator;
import net.kprzeslawski.ugx.entity.custom.EnWSkeleton;
import net.kprzeslawski.ugx.entity.custom.EnZombie;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UGXEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, UGX.MOD_ID);

    //region Entity Registry
    public static final RegistryObject<EntityType<EnZombie>> EN_ZOMBIE_L1 = registerEZ("en_zombie_l1");
    public static final RegistryObject<EntityType<EnZombie>> EN_ZOMBIE_L2 = registerEZ("en_zombie_l2");
    public static final RegistryObject<EntityType<EnZombie>> EN_ZOMBIE_L3 = registerEZ("en_zombie_l3");
    public static final RegistryObject<EntityType<EnZombie>> EN_ZOMBIE_L4 = registerEZ("en_zombie_l4");
    public static final RegistryObject<EntityType<EnZombie>> EN_ZOMBIE_L5 = registerEZ("en_zombie_l5");
    public static final RegistryObject<EntityType<EnZombie>> EN_ZOMBIE_L6 = registerEZ("en_zombie_l6");
    public static final RegistryObject<EntityType<EnZombie>> EN_ZOMBIE_L7 = registerEZ("en_zombie_l7");
    public static final RegistryObject<EntityType<EnZombie>> EN_ZOMBIE_L8 = registerEZ("en_zombie_l8");

    public static final RegistryObject<EntityType<EnSkeleton>> EN_SKELETON_L1 = registerES("en_skeleton_l1");
    public static final RegistryObject<EntityType<EnSkeleton>> EN_SKELETON_L2 = registerES("en_skeleton_l2");
    public static final RegistryObject<EntityType<EnSkeleton>> EN_SKELETON_L3 = registerES("en_skeleton_l3");
    public static final RegistryObject<EntityType<EnSkeleton>> EN_SKELETON_L4 = registerES("en_skeleton_l4");

    public static final RegistryObject<EntityType<EnWSkeleton>> EN_W_SKELETON_L1 = registerEWS("en_w_skeleton_l1");
    public static final RegistryObject<EntityType<EnWSkeleton>> EN_W_SKELETON_L2 = registerEWS("en_w_skeleton_l2");
    public static final RegistryObject<EntityType<EnWSkeleton>> EN_W_SKELETON_L3 = registerEWS("en_w_skeleton_l3");
    public static final RegistryObject<EntityType<EnWSkeleton>> EN_W_SKELETON_L4 = registerEWS("en_w_skeleton_l4");
    public static final RegistryObject<EntityType<EnWSkeleton>> EN_W_SKELETON_L5 = registerEWS("en_w_skeleton_l5");
    public static final RegistryObject<EntityType<EnWSkeleton>> EN_W_SKELETON_L6 = registerEWS("en_w_skeleton_l6");

    public static final RegistryObject<EntityType<EnVindicator>> EN_VINDICATOR_L1 = registerEV("en_vindicator_l1");
    public static final RegistryObject<EntityType<EnVindicator>> EN_VINDICATOR_L2 = registerEV("en_vindicator_l2");
    public static final RegistryObject<EntityType<EnVindicator>> EN_VINDICATOR_L3 = registerEV("en_vindicator_l3");
    public static final RegistryObject<EntityType<EnVindicator>> EN_VINDICATOR_L4 = registerEV("en_vindicator_l4");
    //endregion

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    //region registration helpers
    public static RegistryObject<EntityType<EnZombie>> registerEZ(String name){
        return ENTITY_TYPES.register(name,() -> EntityType.Builder
                .of(EnZombie::new, MobCategory.MONSTER).sized(1f,2f).build(name));
    }
    public static RegistryObject<EntityType<EnSkeleton>> registerES(String name){
        return ENTITY_TYPES.register(name,() -> EntityType.Builder
                .of(EnSkeleton::new, MobCategory.MONSTER).sized(1f,2f).build(name));
    }
    public static RegistryObject<EntityType<EnWSkeleton>> registerEWS(String name){
        return ENTITY_TYPES.register(name,() -> EntityType.Builder
                .of(EnWSkeleton::new, MobCategory.MONSTER).sized(1f,2.4f).build(name));
    }
    public static RegistryObject<EntityType<EnVindicator>> registerEV(String name){
        return ENTITY_TYPES.register(name,() -> EntityType.Builder
                .of(EnVindicator::new, MobCategory.MONSTER).sized(1f,2f).build(name));
    }
    //endregion
}
