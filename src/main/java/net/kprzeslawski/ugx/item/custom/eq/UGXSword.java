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

    public List<UGXItemLevelStats> stats;

    public UGXSword(Tier pTier, Properties pProperties, List<UGXItemLevelStats> stats) {
        super(pTier, pProperties);
        this.stats = stats;
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
        return stats.get(level);
    }


}
