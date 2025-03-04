package net.kprzeslawski.ugx.item;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.item.custom.UGXXPHolder;
import net.kprzeslawski.ugx.item.custom.eq.UGXArmor;
import net.kprzeslawski.ugx.item.custom.eq.UGXAxe;
import net.kprzeslawski.ugx.item.custom.eq.UGXBow;
import net.kprzeslawski.ugx.item.custom.eq.UGXSword;
import net.kprzeslawski.ugx.item.custom.UGXDimensionTeleport;
import net.kprzeslawski.ugx.worldgen.dimension.UGXDimensions;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class UGXItems {
    public static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UGX.MOD_ID);

    public static final RegistryObject<Item> TP_WAND = ITEMS.register("tp_dlv1_wand",
            () -> new UGXDimensionTeleport(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SW_1 = ITEMS.register("sw_1",
            () -> new UGXSword(Tiers.NETHERITE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> AXE_1 = ITEMS.register("axe_1",
            () -> new UGXAxe(Tiers.NETHERITE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BOW_1 = ITEMS.register("bow_1",
            () -> new UGXBow(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> XP_HOLDER = ITEMS.register("xp_holder",
            () -> new UGXXPHolder(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> TANGERINE_HELMET = ITEMS.register("tangerine_helmet",
            () -> new UGXArmor(ArmorMaterials.NETHERITE, ArmorItem.Type.HELMET, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TANGERINE_CHESTPLATE = ITEMS.register("tangerine_chestplate",
            () -> new UGXArmor(ArmorMaterials.NETHERITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TANGERINE_LEGGINGS = ITEMS.register("tangerine_leggings",
            () -> new UGXArmor(ArmorMaterials.NETHERITE, ArmorItem.Type.LEGGINGS, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TANGERINE_BOOTS = ITEMS.register("tangerine_boots",
            () -> new UGXArmor(ArmorMaterials.NETHERITE, ArmorItem.Type.BOOTS, new Item.Properties().stacksTo(1)));


    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }

}
