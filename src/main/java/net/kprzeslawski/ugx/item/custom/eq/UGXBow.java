package net.kprzeslawski.ugx.item.custom.eq;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;

import javax.annotation.Nullable;

public class UGXBow extends BowItem {
    public UGXBow(Properties pProperties) {
        super(pProperties);
    }
    @Override
    protected void shootProjectile(
            LivingEntity pShooter, Projectile pProjectile, int pIndex, float pVelocity, float pInaccuracy, float pAngle, @Nullable LivingEntity pTarget
    ) {
        pProjectile.shootFromRotation(pShooter, pShooter.getXRot(), pShooter.getYRot() + pAngle, 0.0F, pVelocity * 5, pInaccuracy * 0.1f);
    }
}
