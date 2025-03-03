package net.kprzeslawski.ugx.menutype;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.menutype.energizestation.EnergizeStationMenu;
import net.kprzeslawski.ugx.menutype.teleporter.TeleportMenu;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UGXMenu {
    public static final DeferredRegister<MenuType<?>> MENU =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, UGX.MOD_ID);

    public static final RegistryObject<MenuType<EnergizeStationMenu>> ENERGIZING_STATION_MENU =
            MENU.register("energizing_station_menu",
                    () -> new MenuType<>(EnergizeStationMenu::new, FeatureFlags.DEFAULT_FLAGS));

    public static final RegistryObject<MenuType<TeleportMenu>> TELEPORT_MENU =
            MENU.register("teleport_menu",
                    () -> new MenuType<>(TeleportMenu::new, FeatureFlags.DEFAULT_FLAGS));
    public static void register(IEventBus eventBus){
        MENU.register(eventBus);
    }
}
