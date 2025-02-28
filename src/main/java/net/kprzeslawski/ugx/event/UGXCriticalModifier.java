package net.kprzeslawski.ugx.event;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.world.UGXAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = UGX.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UGXCriticalModifier {

    @SubscribeEvent
    public static void overrideCritical(CriticalHitEvent event){
        if(!(event.getEntity() instanceof Player))
            return;

        Player p = event.getEntity();
        event.setDamageModifier((float) p.getAttributeValue(UGXAttributes.CRITICAL_DAMAGE.getHolder().get()) / 100);
        Random r = new Random();

        event.setResult(
                r.nextInt(100) < p.getAttributeValue(UGXAttributes.CRITICAL_CHANCE.getHolder().get()) ?
                        Event.Result.ALLOW : Event.Result.DENY
        );
    }
}
