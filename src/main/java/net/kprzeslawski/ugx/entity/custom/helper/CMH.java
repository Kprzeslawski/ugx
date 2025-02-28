package net.kprzeslawski.ugx.entity.custom.helper;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;

public class CMH { //Custom Mob Helper
    public static Component getNameAndHealthComponent(String name, float currentHealth, float maxHealth){
        float percentageHealth = currentHealth / maxHealth;

        ChatFormatting healthColor;
        if(percentageHealth > 0.7) healthColor = ChatFormatting.GREEN;
        else if (percentageHealth > 0.3) healthColor = ChatFormatting.GOLD;
        else healthColor = ChatFormatting.RED;

        return Component
                .literal(name + " ")
                .withStyle(ChatFormatting.AQUA)
                .append(
                    Component.literal(
                            Math.round(currentHealth * 100.f) / 100.f + "/" + maxHealth
                    ).withStyle(healthColor)
                );
    }

    public static AttributeSupplier sAttr(float mh, float ad, float ms, float arm, float art){
        return Monster
                .createMobAttributes()
                .add(Attributes.FOLLOW_RANGE, 50)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE)
                .add(Attributes.MAX_HEALTH, mh)
                .add(Attributes.ATTACK_DAMAGE, ad)
                .add(Attributes.MOVEMENT_SPEED, ms)
                .add(Attributes.ARMOR,arm)
                .add(Attributes.ARMOR_TOUGHNESS,art)
                .build();
    }

}
