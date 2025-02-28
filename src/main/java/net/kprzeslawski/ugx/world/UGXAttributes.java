package net.kprzeslawski.ugx.world;

import net.kprzeslawski.ugx.UGX;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UGXAttributes {
    public static DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(Registries.ATTRIBUTE, UGX.MOD_ID);

    public static final RegistryObject<Attribute> CRITICAL_CHANCE = rA("critical_chance",20,0,100);
    public static final RegistryObject<Attribute> CRITICAL_DAMAGE = rA("critical_damage",150,0,1000);
    public static final RegistryObject<Attribute> AD_VS_MOBS = rA("ad_vs_mobs",0,0,100);
    public static final RegistryObject<Attribute> AD_MULTIPLIER = rA("ad_multiplier",1,0,100);
    public static final RegistryObject<Attribute> AD_VS_PLAYERS = rA("ad_vs_players",0,0,100);
    public static final RegistryObject<Attribute> HP_ON_HIT = rA("hp_on_hit",0,0,10);
    public static final RegistryObject<Attribute> AD_PER_MAX_HP = rA("ad_per_max_hp",0,0,10);
    public static final RegistryObject<Attribute> DODGE_CHANCE = rA("dodge_chance",0,0,80);
    public static final RegistryObject<Attribute> MAX_BLOCK_GENERATION = rA("max_block_stacks",0,0,30);

    public static void register(IEventBus eventBus) { ATTRIBUTES.register(eventBus);}

    public static RegistryObject<Attribute> rA(String name, float def, float min, float max){
        return ATTRIBUTES.register(UGX.MOD_ID + '.' + name,
                () -> new RangedAttribute(UGX.MOD_ID + ".attribute." + name, def, min, max).setSyncable(true)
                );
    }
}
