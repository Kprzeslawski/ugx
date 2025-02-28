package net.kprzeslawski.ugx.world;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.kprzeslawski.ugx.UGX;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class UGXDataComponents {
    public static DeferredRegister<DataComponentType<?>> DATA_COMPONENTS =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, UGX.MOD_ID);

    public static final RegistryObject<DataComponentType<List<Double>>> TELEPORT_INITIAL_POSITION = DATA_COMPONENTS.register(
            "teleport_initial_position", () -> DataComponentType.<List<Double>>builder()
                    .persistent(Codec.DOUBLE.listOf())
                    .networkSynchronized(ByteBufCodecs.DOUBLE.apply(ByteBufCodecs.list()))
                    .build()
    );
    public static final RegistryObject<DataComponentType<Integer>> EQ_LV = DATA_COMPONENTS.register(
            "eq_lv", () -> DataComponentType.<Integer>builder()
                    .persistent(Codec.INT)
                    .networkSynchronized(ByteBufCodecs.INT)
                    .build()
    );
    public static final RegistryObject<DataComponentType<List<Pair<Integer,Integer>>>> BONUSES = DATA_COMPONENTS.register(
            "bonuses_id", () -> DataComponentType.<List<Pair<Integer,Integer>>>builder()
                    .persistent(Codec.list(Codec.pair(
                            Codec.INT.fieldOf("key").codec(), Codec.INT.fieldOf("value").codec()
                    )))
                    .networkSynchronized(ByteBufCodecs.fromCodec(Codec.list(Codec.pair(
                            Codec.INT.fieldOf("key").codec(), Codec.INT.fieldOf("value").codec()
                    ))))
                    .build()
    );
    public static final RegistryObject<DataComponentType<Integer>> EXP_HOLDING = DATA_COMPONENTS.register(
            "stored_xp", () -> DataComponentType.<Integer>builder()
                    .persistent(Codec.INT)
                    .networkSynchronized(ByteBufCodecs.INT)
                    .build()
    );

    public static void register(IEventBus eventBus) { DATA_COMPONENTS.register(eventBus); }
}
