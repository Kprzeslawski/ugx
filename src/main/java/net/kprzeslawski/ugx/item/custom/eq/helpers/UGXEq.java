package net.kprzeslawski.ugx.item.custom.eq.helpers;

import net.minecraft.world.item.Item;

import java.util.HashMap;

public interface UGXEq {
    public int getTierLv();
    public Item getNextTierItem();
    public int getEQType();
    public UGXItemLevelStats getCurrentStats(int level);
}
