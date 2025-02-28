package net.kprzeslawski.ugx.entity.custom;

import net.kprzeslawski.ugx.entity.custom.helper.CMH;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class EnZombie extends Zombie {
    String baseName;
    public EnZombie(EntityType<? extends Zombie> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        baseName = getName().getString();
        this.setCustomName(
                CMH.getNameAndHealthComponent(
                        getName().getString(),getHealth(),getMaxHealth()
                )
        );
        this.setCustomNameVisible(true);
    }

    @Override
    public boolean hurt(DamageSource pSource, float pAmount) {
        boolean doHurt = super.hurt(pSource, pAmount);
        this.setCustomName(
                CMH.getNameAndHealthComponent(
                        baseName,getHealth(),getMaxHealth()
                )
        );
        return doHurt;
    }
}