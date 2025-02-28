package net.kprzeslawski.ugx.event;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.entity.UGXEntities;
import net.kprzeslawski.ugx.entity.custom.EnSkeleton;
import net.kprzeslawski.ugx.entity.custom.EnZombie;
import net.kprzeslawski.ugx.entity.custom.helper.CMH;
import net.kprzeslawski.ugx.world.UGXAttributes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.jar.Attributes;

@Mod.EventBusSubscriber(modid = UGX.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UGXEntityAttributeCreation {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {

        event.put(UGXEntities.EN_ZOMBIE_L1.get(), CMH.sAttr(30f,3f,0.25f,2f,0f));
        event.put(UGXEntities.EN_ZOMBIE_L2.get(), CMH.sAttr(40f,4f,0.25f,2f,0f));
        event.put(UGXEntities.EN_ZOMBIE_L3.get(), CMH.sAttr(55f,5f,0.25f,3f,0f));
        event.put(UGXEntities.EN_ZOMBIE_L4.get(), CMH.sAttr(75f,6f,0.3f,4f,0f));
        event.put(UGXEntities.EN_ZOMBIE_L5.get(), CMH.sAttr(100f,8f,0.3f,4f,0f));
        event.put(UGXEntities.EN_ZOMBIE_L6.get(), CMH.sAttr(130f,9f,0.35f,5f,0f));
        event.put(UGXEntities.EN_ZOMBIE_L7.get(), CMH.sAttr(160f,11f,0.4f,6f,1f));
        event.put(UGXEntities.EN_ZOMBIE_L8.get(), CMH.sAttr(200f,14f,0.45f,8f,2f));

        event.put(UGXEntities.EN_SKELETON_L1.get(), CMH.sAttr(30f,3f,0.25f,2f,0f));
        event.put(UGXEntities.EN_SKELETON_L2.get(), CMH.sAttr(40f,4f,0.25f,2f,0f));
        event.put(UGXEntities.EN_SKELETON_L3.get(), CMH.sAttr(55f,5f,0.25f,3f,0f));
        event.put(UGXEntities.EN_SKELETON_L4.get(), CMH.sAttr(75f,6f,0.3f,4f,0f));

        event.put(UGXEntities.EN_W_SKELETON_L1.get(), CMH.sAttr(100f,6f,0.25f,6f,1f));
        event.put(UGXEntities.EN_W_SKELETON_L2.get(), CMH.sAttr(150f,7f,0.3f,7f,1f));
        event.put(UGXEntities.EN_W_SKELETON_L3.get(), CMH.sAttr(200f,8f,0.35f,8f,2f));
        event.put(UGXEntities.EN_W_SKELETON_L4.get(), CMH.sAttr(250f,10f,0.35f,10f,3f));
        event.put(UGXEntities.EN_W_SKELETON_L5.get(), CMH.sAttr(320f,12f,0.4f,12f,4f));
        event.put(UGXEntities.EN_W_SKELETON_L6.get(), CMH.sAttr(400f,14f,0.4f,14f,5f));

        event.put(UGXEntities.EN_VINDICATOR_L1.get(), CMH.sAttr(150f,14f,0.45f,2f,0f));
        event.put(UGXEntities.EN_VINDICATOR_L2.get(), CMH.sAttr(175f,17f,0.55f,3f,0f));
        event.put(UGXEntities.EN_VINDICATOR_L3.get(), CMH.sAttr(210f,20f,0.7f,4f,0f));
        event.put(UGXEntities.EN_VINDICATOR_L4.get(), CMH.sAttr(250f,24f,0.9f,5f,1f));
    }

}
