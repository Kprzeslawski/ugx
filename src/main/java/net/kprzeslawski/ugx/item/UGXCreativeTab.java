package net.kprzeslawski.ugx.item;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.block.UGXBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UGXCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UGX.MOD_ID);

    public static final RegistryObject<CreativeModeTab> UGX_TAB = CREATIVE_TAB.register("ugx_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.REDSTONE))
                    .title(Component.translatable("creative.ugx_tab"))
                    .displayItems((param,out)->{
                        out.accept(UGXItems.TP_DLV1_WAND.get());
                        out.accept(UGXItems.TP_DLV2_WAND.get());
                        out.accept(UGXItems.TP_DLV3_WAND.get());
                        out.accept(UGXItems.TP_DLV4_WAND.get());
                        out.accept(UGXItems.TP_DLV5_WAND.get());
                        out.accept(UGXItems.TP_DLV6_WAND.get());
                        out.accept(UGXItems.TP_DLV7_WAND.get());
                        out.accept(UGXItems.TP_DLV8_WAND.get());
                        out.accept(UGXItems.TP_DLV9_WAND.get());
                        out.accept(UGXItems.TP_DLV10_WAND.get());

                        out.accept(UGXItems.SW_1.get());
                        out.accept(UGXItems.AXE_1.get());
                        out.accept(UGXItems.BOW_1.get());

                        out.accept(UGXItems.XP_HOLDER.get());

                        out.accept(UGXBlocks.ENERGIZING_STATION_BLOCK.get());

                        out.accept(UGXItems.TANGERINE_HELMET.get());
                        out.accept(UGXItems.TANGERINE_CHESTPLATE.get());
                        out.accept(UGXItems.TANGERINE_LEGGINGS.get());
                        out.accept(UGXItems.TANGERINE_BOOTS.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {CREATIVE_TAB.register(eventBus);}
}
