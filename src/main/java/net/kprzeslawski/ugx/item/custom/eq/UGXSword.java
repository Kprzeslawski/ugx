package net.kprzeslawski.ugx.item.custom.eq;

import net.kprzeslawski.ugx.item.custom.eq.helpers.*;
import net.kprzeslawski.ugx.world.UGXAttributes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.Arrays;
import java.util.List;

public class UGXSword extends SwordItem implements UGXEq {
    public UGXSword(Tier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    @Override
    public void verifyComponentsAfterLoad(ItemStack pStack) {
        UGXEqStats.setupItemStack(pStack);
        super.verifyComponentsAfterLoad(pStack);
    }

    @Override
    public Component getName(ItemStack pStack) {
        return Component.translatable(this.getDescriptionId(pStack)).withStyle(ChatFormatting.DARK_PURPLE);
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        return UGXEqStats.getModifiers(stack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        UGXEqStats.appendHoverText(pStack,pTooltipComponents);
    }

    @Override
    public float getAttackDamageBonus(Entity pTarget, float pDamage, DamageSource pDamageSource) {
        return UGXEqStats.addBonusDamage(pTarget, pDamage, pDamageSource);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if(!(pAttacker instanceof Player))
            return super.hurtEnemy(pStack, pTarget, pAttacker);

        var h = (float) pAttacker.getAttributeValue(UGXAttributes.HP_ON_HIT.getHolder().get());
        if(h > 0)
            pAttacker.heal(h);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public int getEQType() {
        return 0;
    }

    @Override
    public UGXItemLevelStats getCurrentStats(int level) {
        return Arrays.asList(
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
        ).get(level);
    }
}
