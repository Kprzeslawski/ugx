package net.kprzeslawski.ugx.item.custom.eq.helpers;

import com.mojang.datafixers.util.Pair;
import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.world.UGXDataComponents;
import net.kprzeslawski.ugx.world.UGXAttributes;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraftforge.eventbus.api.Event;

import java.util.*;

import static net.minecraft.world.item.Item.BASE_ATTACK_DAMAGE_ID;
import static net.minecraft.world.item.Item.BASE_ATTACK_SPEED_ID;

public class UGXEqStats {

    public static final BType AD_BONUS = new BType(0,0,0,"Attack damage bonus",  i -> i+1f , null);
    public static final BType AD_BONUS_VS_MOBS = new BType(1,0,0,"Attack damage bonus vs mobs",  i -> (i+1)*2f, UGXAttributes.AD_VS_MOBS.getHolder().get());
    public static final BType AD_BONUS_VS_PLAYERS = new BType(2,0,0,"Attack damage bonus vs players",  i -> (i+1)*2f, UGXAttributes.AD_VS_PLAYERS.getHolder().get());
    public static final BType AD_BONUS_PERCENT = new BType(3,0,0,"Bonus % attack",  i -> (i+1)*0.05f, UGXAttributes.AD_MULTIPLIER.getHolder().get());
    public static final BType CRITICAL_BONUS = new BType(4,0,0,"Critical chance bonus",  i -> (i+1)*5f, UGXAttributes.CRITICAL_CHANCE.getHolder().get() );
    public static final BType CRITICAL_DAMAGE_BONUS = new BType(5,0,0,"Critical damage bonus",  i -> (i+1)*10f, UGXAttributes.CRITICAL_DAMAGE.getHolder().get());
    public static final BType AS_BONUS = new BType(6,0,0,"Attack speed bonus",  i -> (i+1)*0.05f, null);
    public static final BType HP_ON_HIT = new BType(7,0,2,"Hp heal on hit",  i -> i-1f, UGXAttributes.HP_ON_HIT.getHolder().get());
    public static final BType AD_PER_MAX_HP = new BType(8,0,3,"Attack damage per 10 enemy hp",  i -> i-2f, UGXAttributes.AD_PER_MAX_HP.getHolder().get());
    public static final BType HP_BONUS = new BType(9,1,0,"Bonus Hp",  i -> (i+1) * 2f, null );
    public static final BType ARMOR_BONUS = new BType(10,1,0,"Bonus armor",  i -> (i+1f), null );
    public static final BType DODGE_CHANCE = new BType(11,1,0,"Dodge chance",  i -> (i+1) * 2f, UGXAttributes.DODGE_CHANCE.getHolder().get());
    public static final BType MOVE_SPEED = new BType(12,1,0,"Move Speed",  i -> (i+1) * 0.01f, Attributes.MOVEMENT_SPEED);
    public static final BType ARMOR_TOUGHNESS_BONUS = new BType(13,1,1,"Bonus armor toughness", i -> i*1f, null);
    public static final BType MAX_BLOCK_GENERATION = new BType(14,1,3,"Max block generation",  i -> i-2f, UGXAttributes.MAX_BLOCK_GENERATION.getHolder().get());

    public static final List<BType> BONUSES = Arrays.asList(
            AD_BONUS,AD_BONUS_VS_MOBS,AD_BONUS_VS_PLAYERS,
            AD_BONUS_PERCENT,CRITICAL_BONUS,CRITICAL_DAMAGE_BONUS,
            AS_BONUS,HP_ON_HIT,AD_PER_MAX_HP,

            HP_BONUS,ARMOR_BONUS,DODGE_CHANCE,
            MOVE_SPEED,ARMOR_TOUGHNESS_BONUS,MAX_BLOCK_GENERATION
    );
    public static final List<ChatFormatting> colors = Arrays.asList(
            ChatFormatting.WHITE,
            ChatFormatting.GREEN,
            ChatFormatting.BLUE,
            ChatFormatting.DARK_PURPLE,
            ChatFormatting.GOLD
    );

    public static void setupItemStack(ItemStack is){
        if(is.get(UGXDataComponents.EQ_LV.get()) == null)
            is.set(UGXDataComponents.EQ_LV.get(),0);

        if(is.get(UGXDataComponents.BONUSES.get()) == null)
            shuffleBonuses(is);
    }
    public static void upgradeItem(ItemStack is){
        if(!(is.getItem() instanceof UGXEq))
            return;

        var id = is.get(UGXDataComponents.EQ_LV.get());
        if(id == null || ((UGXEq)is.getItem()).getCurrentStats(id).cost == 0)
            return;

        is.set(UGXDataComponents.EQ_LV.get(),id+1);
    }

    public static void shuffleBonuses(ItemStack is){
        if(!(is.getItem() instanceof UGXEq))
            return;

        var res = new HashMap<Integer,Integer>();
        Random r = new Random();
        int type = ((UGXEq) is.getItem()).getEQType();
        int bCount = 9;

        while(res.size() < 3){
            var c = r.nextDouble(0.,1.);
            var rarity = 0;
            if (c >= 0.45 && c < 0.7) { rarity = 1;
            } else if (c < 0.85) { rarity = 2;
            } else if (c < 0.95) { rarity = 3;
            } else { rarity = 4; }

            while(true){
                var k = r.nextInt(BONUSES.size());
                BType b = BONUSES.get(k);
                if(b.eqId != type || b.minRarity > rarity || res.containsKey(k)) continue;

                res.put(k,rarity);
                break;
            }
        }
        var list = new ArrayList<Pair<Integer,Integer>>();
        res.forEach((k, v) -> list.add(new Pair<>(k,v)));
        is.set(UGXDataComponents.BONUSES.get(), list);
    }

    public static float retrieveValue(BType b, ItemStack is){
        if(is == null || !(is.getItem() instanceof UGXEq))
            return 0;
        var list = is.get(UGXDataComponents.BONUSES.get());
        if(list == null)
            return 0;

        for(Pair<Integer,Integer> elem : list)
            if(elem.getFirst().equals(b.id))
                return b.mapper.apply(elem.getSecond());

        return 0;
    }

    public static UGXItemLevelStats getCurrentStats(ItemStack item1) {
        var lv = item1.get(UGXDataComponents.EQ_LV.get());
        if(lv == null)
            return null;
        return ((UGXEq) item1.getItem()).getCurrentStats(lv);
    }

    public static ItemAttributeModifiers getModifiers(ItemStack stack){
        if(!(stack.getItem() instanceof UGXEq))
            return null;

        var base = getCurrentStats(stack);
        var eq_type = ((UGXEq) stack.getItem()).getEQType();
        if(base == null)return null;

        var attrs = ItemAttributeModifiers.builder();
        EquipmentSlotGroup eqs = EquipmentSlotGroup.ANY;
        ResourceLocation rl = ResourceLocation.tryBuild(UGX.MOD_ID,"any");

        if(eq_type == 0){
            var ad = base.ad + retrieveValue(AD_BONUS,stack);
            var as = base.as * (1f + retrieveValue(AS_BONUS,stack));
            eqs = EquipmentSlotGroup.MAINHAND;
            rl = ResourceLocation.tryBuild(UGX.MOD_ID,"main_hand_weapon");
            attrs
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(BASE_ATTACK_DAMAGE_ID, ad, AttributeModifier.Operation.ADD_VALUE),
                        eqs
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, as - 4f, AttributeModifier.Operation.ADD_VALUE),
                        eqs
                )
                .add(
                        Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(rl, (double)base.range, AttributeModifier.Operation.ADD_VALUE),
                        eqs
                )
                .add(
                        Attributes.BLOCK_INTERACTION_RANGE,
                        new AttributeModifier(rl, (double)base.range, AttributeModifier.Operation.ADD_VALUE),
                        eqs
                );
        }
        else if (eq_type == 1) {
            if(!(stack.getItem() instanceof ArmorItem))
                return null;

            int arm_modifier = 0;
            var att =  ItemAttributeModifiers.builder();
            var type = ((ArmorItem) stack.getItem()).getType();
            rl = ResourceLocation.tryBuild(UGX.MOD_ID,"armor." + type.getName());
            eqs = EquipmentSlotGroup.bySlot(type.getSlot());
            switch (type){
                case BOOTS -> {
                    arm_modifier = 6;
                    att.add(
                            Attributes.STEP_HEIGHT,
                            new AttributeModifier(rl,0.5f,AttributeModifier.Operation.ADD_VALUE),
                            eqs
                    );
                }
                case HELMET -> arm_modifier = 5;
                case LEGGINGS -> arm_modifier = 2;
            }

            att
                .add(
                        Attributes.MAX_HEALTH,
                        new AttributeModifier(rl,base.hp + retrieveValue(HP_BONUS,stack), AttributeModifier.Operation.ADD_VALUE),
                        eqs
                )
                .add(
                        Attributes.ARMOR,
                        new AttributeModifier(rl,base.armor - arm_modifier + retrieveValue(ARMOR_BONUS,stack), AttributeModifier.Operation.ADD_VALUE),
                        eqs
                )
                .add(
                        Attributes.ARMOR_TOUGHNESS,
                        new AttributeModifier(rl,base.armor_t  + retrieveValue(ARMOR_TOUGHNESS_BONUS,stack),AttributeModifier.Operation.ADD_VALUE),
                        eqs
                )
                .add(
                        Attributes.KNOCKBACK_RESISTANCE,
                        new AttributeModifier(rl,base.knockback_res * 0.1f,AttributeModifier.Operation.ADD_VALUE),
                        eqs
                );
        }

        var list = stack.get(UGXDataComponents.BONUSES.get());
        if(list == null)
            return null;

        for(Pair<Integer,Integer> elem : list)
            if(BONUSES.get(elem.getFirst()).attributeHolder != null)
                attrs.add(
                        BONUSES.get(elem.getFirst()).attributeHolder,
                        new AttributeModifier(rl,BONUSES.get(elem.getFirst()).mapper.apply(elem.getSecond()), AttributeModifier.Operation.ADD_VALUE),
                        eqs
                );

        return attrs.build();
    }

    public static void appendHoverText(ItemStack item, List<Component> tooltips){
        if(!(item.getItem() instanceof UGXEq))
            return;

        var list = item.get(UGXDataComponents.BONUSES.get());
        var lv = item.get(UGXDataComponents.EQ_LV.get());
        var eq_type = ((UGXEq) item.getItem()).getEQType();

        if(lv == null || list == null || list.isEmpty())
            return;

        tooltips.add(Component.literal("Upgrade level " + (lv+1)).withStyle(ChatFormatting.AQUA));
        tooltips.add(Component.empty());
        tooltips.add(Component.literal("Bonuses:").withStyle(ChatFormatting.AQUA));

        for(Pair<Integer,Integer> pair : list)
            tooltips.add(
                    Component.literal(
                            BONUSES.get(pair.getFirst()).toolTip +" "+ BONUSES.get(pair.getFirst()).mapper.apply(pair.getSecond())
                    ).withStyle(
                            colors.get(pair.getSecond())
                    )
            );

        tooltips.add(Component.empty());

        if(eq_type == 0){

            tooltips.add(Component.literal("Critical chance " + (retrieveValue(CRITICAL_BONUS,item)+20) + "%").withStyle(ChatFormatting.RED));
            tooltips.add(Component.literal("Critical damage " + (retrieveValue(CRITICAL_DAMAGE_BONUS,item)+150) + "%").withStyle(ChatFormatting.RED));

            tooltips.add(Component.empty());
        }
    }

    public static float addBonusDamage(Entity pTarget, float pDamage, DamageSource pDamageSource) {
        if(!(pDamageSource.getEntity() instanceof Player))
            return 0f;

        var damage = 0f;


        var multiplier = (float) ((Player) pDamageSource.getEntity()).getAttributeValue(UGXAttributes.AD_MULTIPLIER.getHolder().get());

        if(pTarget instanceof Mob)
            damage += (float) ((Player) pDamageSource.getEntity()).getAttributeValue(UGXAttributes.AD_VS_MOBS.getHolder().get());

        if(pTarget instanceof Player)
            damage += (float) ((Player) pDamageSource.getEntity()).getAttributeValue(UGXAttributes.AD_VS_PLAYERS.getHolder().get());

        if(pTarget instanceof LivingEntity)
            damage += (float) ((Player) pDamageSource.getEntity()).getAttributeValue(UGXAttributes.AD_PER_MAX_HP.getHolder().get())
                    * ((LivingEntity) pTarget).getMaxHealth() / 10f;

        return damage * multiplier
                + pDamage * (multiplier - 1f);
    }

}
