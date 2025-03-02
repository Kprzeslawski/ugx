package net.kprzeslawski.ugx.villager;

import com.google.common.collect.ImmutableSet;
import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.block.UGXBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UGXVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, UGX.MOD_ID);
    public static final DeferredRegister<VillagerProfession> PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, UGX.MOD_ID);

    public static final RegistryObject<PoiType> EN_STATION_POI = POI_TYPES.register("en_station_poi",
            () -> new PoiType(ImmutableSet.copyOf(UGXBlocks.ENERGIZING_STATION_BLOCK.get().getStateDefinition().getPossibleStates()),1,1));


    public static final RegistryObject<VillagerProfession> EN_STATION_PROF = PROFESSIONS.register("en_station_prof",
            () -> new VillagerProfession("en_station_prof", poiTypeHolder -> poiTypeHolder.value() == EN_STATION_POI.get(),
                    poiTypeHolder -> poiTypeHolder.value() == EN_STATION_POI.get(),ImmutableSet.of(),ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_WEAPONSMITH
                    ));



    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        PROFESSIONS.register(eventBus);
    }
}
