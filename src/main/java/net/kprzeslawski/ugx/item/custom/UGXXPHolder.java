package net.kprzeslawski.ugx.item.custom;

import net.kprzeslawski.ugx.world.UGXDataComponents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class UGXXPHolder extends Item {
    public UGXXPHolder(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        var item = pPlayer.getMainHandItem();
        if(!(item.getItem() instanceof UGXXPHolder))
            return InteractionResultHolder.pass(item);

        var holding = item.get(UGXDataComponents.EXP_HOLDING.get());

        if(holding == null || holding <= 0) {
            item.set(UGXDataComponents.EXP_HOLDING.get(),pPlayer.totalExperience);
            pPlayer.experienceLevel = 0;
            pPlayer.totalExperience = 0;
            pPlayer.experienceProgress = 0;

        } else {
            pPlayer.giveExperiencePoints(holding);
            item.set(UGXDataComponents.EXP_HOLDING.get(),0);
        }

        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);

        var holding = pStack.get(UGXDataComponents.EXP_HOLDING.get());
        if(holding == null || holding < 0){
            holding = 0;
            pStack.set(UGXDataComponents.EXP_HOLDING.get(),0);
        }

        pTooltipComponents.add(
                Component.literal(
                        "Stored exp " + holding
                ).withStyle(
                        ChatFormatting.GREEN
                )
        );
    }
}
