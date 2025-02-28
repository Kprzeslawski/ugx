package net.kprzeslawski.ugx.entity.custom;

import net.kprzeslawski.ugx.entity.custom.helper.CMH;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.level.Level;

public class EnVindicator extends Vindicator {
    String baseName;
    public EnVindicator(EntityType<? extends Vindicator> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        baseName = getName().getString();
        this.setCustomName(
                CMH.getNameAndHealthComponent(
                        baseName,getHealth(),getMaxHealth()
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
