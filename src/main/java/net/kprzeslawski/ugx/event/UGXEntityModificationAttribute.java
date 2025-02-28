package net.kprzeslawski.ugx.event;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.world.UGXAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UGX.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UGXEntityModificationAttribute {

    @SubscribeEvent
    public static void modification(EntityAttributeModificationEvent event){
        for(var atr : UGXAttributes.ATTRIBUTES.getEntries())
            if(!event.has(EntityType.PLAYER, atr.getHolder().get()))
                event.add(EntityType.PLAYER, atr.getHolder().get());
    }
}
