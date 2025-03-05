package net.kprzeslawski.ugx.item.custom.eq;

import net.kprzeslawski.ugx.item.custom.eq.helpers.UGXEq;
import net.kprzeslawski.ugx.item.custom.eq.helpers.UGXEqStats;
import net.kprzeslawski.ugx.item.custom.eq.helpers.UGXItemLevelStats;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.UUID;

public class UGXArmor extends ArmorItem implements UGXEq{
    private static final EnumMap<Type, UUID> ARMOR_MODIFIER_UUID_PER_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266744_) -> {
        p_266744_.put(ArmorItem.Type.BOOTS, UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"));
        p_266744_.put(ArmorItem.Type.LEGGINGS, UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"));
        p_266744_.put(ArmorItem.Type.CHESTPLATE, UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"));
        p_266744_.put(ArmorItem.Type.HELMET, UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150"));
    });

    public List<UGXItemLevelStats> stats;
    public Item next;
    public int tierLv;

    public UGXArmor(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties, Item next, int tierLv, List<UGXItemLevelStats> stats) {
        super(pMaterial, pType, pProperties);
        this.stats = stats;
        this.next = next;
        this.tierLv = tierLv;
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
    public int getEQType() {
        return 1;
    }

    @Override
    public UGXItemLevelStats getCurrentStats(int level) {
        return stats.get(level);
    }

    @Override
    public Item getNextTierItem() {
        return next;
    }

    @Override
    public int getTierLv(){
        return tierLv;
    }
}
