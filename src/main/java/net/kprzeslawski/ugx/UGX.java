package net.kprzeslawski.ugx;

import com.mojang.logging.LogUtils;
import net.kprzeslawski.ugx.block.UGXBlocks;
import net.kprzeslawski.ugx.entity.UGXEntities;
import net.kprzeslawski.ugx.item.UGXCreativeTab;
import net.kprzeslawski.ugx.menutype.teleporter.TeleportScreen;
import net.kprzeslawski.ugx.villager.UGXVillagers;
import net.kprzeslawski.ugx.world.UGXDataComponents;
import net.kprzeslawski.ugx.item.UGXItems;
import net.kprzeslawski.ugx.menutype.UGXMenu;
import net.kprzeslawski.ugx.menutype.energizestation.EnergizeStationScreen;
import net.kprzeslawski.ugx.world.UGXAttributes;
import net.kprzeslawski.ugx.worldgen.chunk.UGXChunkGenerators;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.entity.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UGX.MOD_ID)
public class UGX
{
    public static final String MOD_ID = "ugx";
    public static final Logger LOGGER = LogUtils.getLogger();


    public UGX(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        UGXDataComponents.register(modEventBus);
        UGXAttributes.register(modEventBus);
        UGXItems.register(modEventBus);
        UGXBlocks.register(modEventBus);
        UGXEntities.register(modEventBus);
        UGXVillagers.register(modEventBus);
        UGXChunkGenerators.register(modEventBus);
        UGXCreativeTab.register(modEventBus);
        UGXMenu.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = UGX.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            MenuScreens.register(UGXMenu.ENERGIZING_STATION_MENU.get(), EnergizeStationScreen::new);
            MenuScreens.register(UGXMenu.TELEPORT_MENU.get(), TeleportScreen::new);

            EntityRenderers.register(UGXEntities.EN_ZOMBIE_L1.get(), ZombieRenderer::new);
            EntityRenderers.register(UGXEntities.EN_ZOMBIE_L2.get(), ZombieRenderer::new);
            EntityRenderers.register(UGXEntities.EN_ZOMBIE_L3.get(), ZombieRenderer::new);
            EntityRenderers.register(UGXEntities.EN_ZOMBIE_L4.get(), ZombieRenderer::new);
            EntityRenderers.register(UGXEntities.EN_ZOMBIE_L5.get(), ZombieRenderer::new);
            EntityRenderers.register(UGXEntities.EN_ZOMBIE_L6.get(), ZombieRenderer::new);
            EntityRenderers.register(UGXEntities.EN_ZOMBIE_L7.get(), ZombieRenderer::new);
            EntityRenderers.register(UGXEntities.EN_ZOMBIE_L8.get(), ZombieRenderer::new);

            EntityRenderers.register(UGXEntities.EN_SKELETON_L1.get(), SkeletonRenderer::new);
            EntityRenderers.register(UGXEntities.EN_SKELETON_L2.get(), SkeletonRenderer::new);
            EntityRenderers.register(UGXEntities.EN_SKELETON_L3.get(), SkeletonRenderer::new);
            EntityRenderers.register(UGXEntities.EN_SKELETON_L4.get(), SkeletonRenderer::new);

            EntityRenderers.register(UGXEntities.EN_W_SKELETON_L1.get(), WitherSkeletonRenderer::new);
            EntityRenderers.register(UGXEntities.EN_W_SKELETON_L2.get(), WitherSkeletonRenderer::new);
            EntityRenderers.register(UGXEntities.EN_W_SKELETON_L3.get(), WitherSkeletonRenderer::new);
            EntityRenderers.register(UGXEntities.EN_W_SKELETON_L4.get(), WitherSkeletonRenderer::new);
            EntityRenderers.register(UGXEntities.EN_W_SKELETON_L5.get(), WitherSkeletonRenderer::new);
            EntityRenderers.register(UGXEntities.EN_W_SKELETON_L6.get(), WitherSkeletonRenderer::new);

            EntityRenderers.register(UGXEntities.EN_VINDICATOR_L1.get(), VindicatorRenderer::new);
            EntityRenderers.register(UGXEntities.EN_VINDICATOR_L2.get(), VindicatorRenderer::new);
            EntityRenderers.register(UGXEntities.EN_VINDICATOR_L3.get(), VindicatorRenderer::new);
            EntityRenderers.register(UGXEntities.EN_VINDICATOR_L4.get(), VindicatorRenderer::new);

        }
    }
}
