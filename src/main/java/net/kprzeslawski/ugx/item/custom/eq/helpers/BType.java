package net.kprzeslawski.ugx.item.custom.eq.helpers;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;

import java.util.function.Function;

public class BType{
    int id;
    int eqId;
    int minRarity;
    public String toolTip;
    public Function<Integer,Float> mapper;
    public Holder<Attribute> attributeHolder;

    public BType(int id, int eqId, int minRarity, String toolTip, Function<Integer, Float> mapper, Holder<Attribute> attributeHolder) {
        this.id = id;
        this.eqId = eqId;
        this.minRarity = minRarity;
        this.toolTip = toolTip;
        this.mapper = mapper;
        this.attributeHolder = attributeHolder;
    }
}
