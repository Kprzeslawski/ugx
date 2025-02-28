package net.kprzeslawski.ugx.item.custom.eq;

import net.kprzeslawski.ugx.item.custom.eq.helpers.UGXEq;
import net.kprzeslawski.ugx.item.custom.eq.helpers.UGXEqStats;
import net.kprzeslawski.ugx.item.custom.eq.helpers.UGXItemLevelStats;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
    public UGXArmor(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
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
        return Arrays.asList(
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
        ).get(level);
    }
}
