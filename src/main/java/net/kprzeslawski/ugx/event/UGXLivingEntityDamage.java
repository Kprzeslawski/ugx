package net.kprzeslawski.ugx.event;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.world.UGXAttributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UGX.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UGXLivingEntityDamage {

    @SubscribeEvent
    public static void livingEntityAttack(LivingAttackEvent livingAttackEvent){
        if(!(livingAttackEvent.getEntity() instanceof Player) ||
                !(livingAttackEvent.getSource().getEntity() instanceof LivingEntity))
            return;

        Player p = (Player) livingAttackEvent.getEntity();
        var val = p.getAttributeValue(UGXAttributes.DODGE_CHANCE.getHolder().get());
        livingAttackEvent.setCanceled(true);
    }
}
