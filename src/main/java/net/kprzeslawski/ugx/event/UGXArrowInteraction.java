package net.kprzeslawski.ugx.event;

import net.kprzeslawski.ugx.UGX;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UGX.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class UGXArrowInteraction {

    @SubscribeEvent
    public static void arrowInteraction(ProjectileImpactEvent projectileImpactEvent){
        projectileImpactEvent.getImpactResult();
    }
}
