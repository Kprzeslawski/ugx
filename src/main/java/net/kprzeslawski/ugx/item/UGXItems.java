package net.kprzeslawski.ugx.item;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.item.custom.UGXXPHolder;
import net.kprzeslawski.ugx.item.custom.eq.UGXArmor;
import net.kprzeslawski.ugx.item.custom.eq.UGXAxe;
import net.kprzeslawski.ugx.item.custom.eq.UGXBow;
import net.kprzeslawski.ugx.item.custom.eq.UGXSword;
import net.kprzeslawski.ugx.item.custom.UGXDimensionTeleport;
import net.kprzeslawski.ugx.item.custom.eq.helpers.UGXItemLevelStats;
import net.kprzeslawski.ugx.worldgen.dimension.UGXDimensions;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;

public class UGXItems {
    public static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UGX.MOD_ID);

    public static final RegistryObject<Item> TP_WAND = ITEMS.register("tp_dlv1_wand",
            () -> new UGXDimensionTeleport(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> XP_HOLDER = ITEMS.register("xp_holder",
            () -> new UGXXPHolder(new Item.Properties().stacksTo(1)));


    //region EQ

    //region Swords
    public static final RegistryObject<Item> SW_3 = ITEMS.register("sw_3",
            () -> new UGXSword(Tiers.NETHERITE, new Item.Properties().stacksTo(1),
                    null, 2,
                    Arrays.asList(
                            new UGXItemLevelStats(50, 90,8f,1.6f,0),
                            new UGXItemLevelStats(75, 80,8.2f,1.6f,0),
                            new UGXItemLevelStats(125, 70,8.4f,1.6f,0),
                            new UGXItemLevelStats(200, 60,8.7f,1.6f,0),
                            new UGXItemLevelStats(350, 50,9f,1.7f,0),
                            new UGXItemLevelStats(600, 40,9.4f,1.7f,0),
                            new UGXItemLevelStats(1000, 30,9.9f,1.7f,1),
                            new UGXItemLevelStats(1600, 20,10.5f,1.8f,1),
                            new UGXItemLevelStats(2500, 10,11.2f,1.9f,1),
                            new UGXItemLevelStats(0, 0,12f,2f,2)
                    )));
    public static final RegistryObject<Item> SW_2 = ITEMS.register("sw_2",
            () -> new UGXSword(Tiers.NETHERITE, new Item.Properties().stacksTo(1),
                    SW_3.get(), 1,
                    Arrays.asList(
                            new UGXItemLevelStats(50, 90,8f,1.6f,0),
                            new UGXItemLevelStats(75, 80,8.2f,1.6f,0),
                            new UGXItemLevelStats(125, 70,8.4f,1.6f,0),
                            new UGXItemLevelStats(200, 60,8.7f,1.6f,0),
                            new UGXItemLevelStats(350, 50,9f,1.7f,0),
                            new UGXItemLevelStats(600, 40,9.4f,1.7f,0),
                            new UGXItemLevelStats(1000, 30,9.9f,1.7f,1),
                            new UGXItemLevelStats(1600, 20,10.5f,1.8f,1),
                            new UGXItemLevelStats(2500, 10,11.2f,1.9f,1),
                            new UGXItemLevelStats(0, 0,12f,2f,2)
                    )));
    public static final RegistryObject<Item> SW_1 = ITEMS.register("sw_1",
            () -> new UGXSword(Tiers.NETHERITE, new Item.Properties().stacksTo(1),
                    SW_2.get(), 0,
                    Arrays.asList(
                            new UGXItemLevelStats(50, 90,8f,1.6f,0),
                            new UGXItemLevelStats(75, 80,8.2f,1.6f,0),
                            new UGXItemLevelStats(125, 70,8.4f,1.6f,0),
                            new UGXItemLevelStats(200, 60,8.7f,1.6f,0),
                            new UGXItemLevelStats(350, 50,9f,1.7f,0),
                            new UGXItemLevelStats(600, 40,9.4f,1.7f,0),
                            new UGXItemLevelStats(1000, 30,9.9f,1.7f,1),
                            new UGXItemLevelStats(1600, 20,10.5f,1.8f,1),
                            new UGXItemLevelStats(2500, 10,11.2f,1.9f,1),
                            new UGXItemLevelStats(0, 0,12f,2f,2)
                    )));
    //endregion

    //region Axe
    public static final RegistryObject<Item> AXE_3 = ITEMS.register("axe_3",
            () -> new UGXAxe(Tiers.NETHERITE, new Item.Properties().stacksTo(1),
                    null, 2,
                    Arrays.asList(
                            new UGXItemLevelStats(50, 90,11f,1f,0),
                            new UGXItemLevelStats(75, 80,11.3f,1f,0),
                            new UGXItemLevelStats(125, 70,11.6f,1f,0),
                            new UGXItemLevelStats(200, 60,12f,1f,0),
                            new UGXItemLevelStats(350, 50,12.4f,1f,0),
                            new UGXItemLevelStats(600, 40,12.8f,1.1f,0),
                            new UGXItemLevelStats(1000, 30,13.3f,1.1f,1),
                            new UGXItemLevelStats(1600, 20,13.8f,1.2f,1),
                            new UGXItemLevelStats(2500, 10,14.4f,1.2f,1),
                            new UGXItemLevelStats(0, 0,15f,1.3f,2)
                    )
            ));
    public static final RegistryObject<Item> AXE_2 = ITEMS.register("axe_2",
            () -> new UGXAxe(Tiers.NETHERITE, new Item.Properties().stacksTo(1),
                    AXE_3.get(), 1,
                    Arrays.asList(
                            new UGXItemLevelStats(50, 90,11f,1f,0),
                            new UGXItemLevelStats(75, 80,11.3f,1f,0),
                            new UGXItemLevelStats(125, 70,11.6f,1f,0),
                            new UGXItemLevelStats(200, 60,12f,1f,0),
                            new UGXItemLevelStats(350, 50,12.4f,1f,0),
                            new UGXItemLevelStats(600, 40,12.8f,1.1f,0),
                            new UGXItemLevelStats(1000, 30,13.3f,1.1f,1),
                            new UGXItemLevelStats(1600, 20,13.8f,1.2f,1),
                            new UGXItemLevelStats(2500, 10,14.4f,1.2f,1),
                            new UGXItemLevelStats(0, 0,15f,1.3f,2)
                    )
            ));
    public static final RegistryObject<Item> AXE_1 = ITEMS.register("axe_1",
            () -> new UGXAxe(Tiers.NETHERITE, new Item.Properties().stacksTo(1),
                    AXE_2.get(), 0,
                    Arrays.asList(
                            new UGXItemLevelStats(50, 90,11f,1f,0),
                            new UGXItemLevelStats(75, 80,11.3f,1f,0),
                            new UGXItemLevelStats(125, 70,11.6f,1f,0),
                            new UGXItemLevelStats(200, 60,12f,1f,0),
                            new UGXItemLevelStats(350, 50,12.4f,1f,0),
                            new UGXItemLevelStats(600, 40,12.8f,1.1f,0),
                            new UGXItemLevelStats(1000, 30,13.3f,1.1f,1),
                            new UGXItemLevelStats(1600, 20,13.8f,1.2f,1),
                            new UGXItemLevelStats(2500, 10,14.4f,1.2f,1),
                            new UGXItemLevelStats(0, 0,15f,1.3f,2)
                    )
            ));
    //endregion

    //region Bow
    public static final RegistryObject<Item> BOW_1 = ITEMS.register("bow_1",
            () -> new UGXBow(new Item.Properties().stacksTo(1)));
    //endregion

    //region Armor
    public static final RegistryObject<Item> TANGERINE_HELMET = ITEMS.register("tangerine_helmet",
            () -> new UGXArmor(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1),
                    null,0,
                    Arrays.asList(
                            new UGXItemLevelStats(50, 90,0,9f, 3f, 1f),
                            new UGXItemLevelStats(75, 80,0,9.2f, 3f, 1f),
                            new UGXItemLevelStats(125, 70,0,9.4f, 3f, 1f),
                            new UGXItemLevelStats(200, 60,1,9.6f, 3f, 1f),
                            new UGXItemLevelStats(350, 50,1,9.8f, 3.5f, 1f),
                            new UGXItemLevelStats(600, 40,2,10f, 3.5f, 1f),
                            new UGXItemLevelStats(1000, 30,2,10.3f, 3.5f, 2f),
                            new UGXItemLevelStats(1600, 20,3,10.6f, 3.5f, 2f),
                            new UGXItemLevelStats(2500, 10,3,11f, 3.5f, 2f),
                            new UGXItemLevelStats(0, 0,4,12f, 4f, 2f)
                    )
            ));
    public static final RegistryObject<Item> TANGERINE_CHESTPLATE = ITEMS.register("tangerine_chestplate",
            () -> new UGXArmor(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1),
                    null,0,
                    Arrays.asList(
                            new UGXItemLevelStats(50, 90,0,9f, 3f, 1f),
                            new UGXItemLevelStats(75, 80,0,9.2f, 3f, 1f),
                            new UGXItemLevelStats(125, 70,0,9.4f, 3f, 1f),
                            new UGXItemLevelStats(200, 60,1,9.6f, 3f, 1f),
                            new UGXItemLevelStats(350, 50,1,9.8f, 3.5f, 1f),
                            new UGXItemLevelStats(600, 40,2,10f, 3.5f, 1f),
                            new UGXItemLevelStats(1000, 30,2,10.3f, 3.5f, 2f),
                            new UGXItemLevelStats(1600, 20,3,10.6f, 3.5f, 2f),
                            new UGXItemLevelStats(2500, 10,3,11f, 3.5f, 2f),
                            new UGXItemLevelStats(0, 0,4,12f, 4f, 2f)
                    )
            ));
    public static final RegistryObject<Item> TANGERINE_LEGGINGS = ITEMS.register("tangerine_leggings",
            () -> new UGXArmor(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1),
                    null,0,
                    Arrays.asList(
                            new UGXItemLevelStats(50, 90,0,9f, 3f, 1f),
                            new UGXItemLevelStats(75, 80,0,9.2f, 3f, 1f),
                            new UGXItemLevelStats(125, 70,0,9.4f, 3f, 1f),
                            new UGXItemLevelStats(200, 60,1,9.6f, 3f, 1f),
                            new UGXItemLevelStats(350, 50,1,9.8f, 3.5f, 1f),
                            new UGXItemLevelStats(600, 40,2,10f, 3.5f, 1f),
                            new UGXItemLevelStats(1000, 30,2,10.3f, 3.5f, 2f),
                            new UGXItemLevelStats(1600, 20,3,10.6f, 3.5f, 2f),
                            new UGXItemLevelStats(2500, 10,3,11f, 3.5f, 2f),
                            new UGXItemLevelStats(0, 0,4,12f, 4f, 2f)
                    )
            ));
    public static final RegistryObject<Item> TANGERINE_BOOTS = ITEMS.register("tangerine_boots",
            () -> new UGXArmor(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1),
                    null,0,
                    Arrays.asList(
                            new UGXItemLevelStats(50, 90,0,9f, 3f, 1f),
                            new UGXItemLevelStats(75, 80,0,9.2f, 3f, 1f),
                            new UGXItemLevelStats(125, 70,0,9.4f, 3f, 1f),
                            new UGXItemLevelStats(200, 60,1,9.6f, 3f, 1f),
                            new UGXItemLevelStats(350, 50,1,9.8f, 3.5f, 1f),
                            new UGXItemLevelStats(600, 40,2,10f, 3.5f, 1f),
                            new UGXItemLevelStats(1000, 30,2,10.3f, 3.5f, 2f),
                            new UGXItemLevelStats(1600, 20,3,10.6f, 3.5f, 2f),
                            new UGXItemLevelStats(2500, 10,3,11f, 3.5f, 2f),
                            new UGXItemLevelStats(0, 0,4,12f, 4f, 2f)
                    )
            ));
    //endregion

    //endregion


    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }

}
