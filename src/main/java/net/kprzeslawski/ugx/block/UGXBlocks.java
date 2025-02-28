package net.kprzeslawski.ugx.block;

import net.kprzeslawski.ugx.UGX;
import net.kprzeslawski.ugx.block.custom.EnergizingStationBlock;
import net.kprzeslawski.ugx.item.UGXItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class UGXBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UGX.MOD_ID);

    public static final RegistryObject<Block> ENERGIZING_STATION_BLOCK = registerBlock("energizing_station",
            () -> new EnergizingStationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMITHING_TABLE).noOcclusion()));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return UGXItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
