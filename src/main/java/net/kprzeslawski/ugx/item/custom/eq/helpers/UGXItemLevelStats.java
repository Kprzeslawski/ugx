package net.kprzeslawski.ugx.item.custom.eq.helpers;

import java.util.Random;

public class UGXItemLevelStats {
    public int cost;
    public int upgrade_chance;

    public int eqType;
    public float ad;
    public float as;
    public float range;
    public float hp;
    public float armor;
    public float armor_t;
    public float knockback_res;

    public UGXItemLevelStats(int cost, int upgrade_chance, float hp, float armor, float armor_t, float knockback_res) {
        this.eqType = 1;
        this.cost = cost;
        this.upgrade_chance = upgrade_chance;
        this.hp = hp;
        this.armor = armor;
        this.armor_t = armor_t;
        this.knockback_res = knockback_res;
    }

    public UGXItemLevelStats(int cost, int upgrade_chance, float ad, float as, float range) {
        this.eqType = 0;
        this.cost = cost;
        this.upgrade_chance = upgrade_chance;
        this.ad = ad;
        this.as = as;
        this.range = range;
    }

    public boolean roll(){
        return new Random().nextInt(100) < upgrade_chance;
    }

}
