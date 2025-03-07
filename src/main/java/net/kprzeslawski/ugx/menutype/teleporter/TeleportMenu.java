package net.kprzeslawski.ugx.menutype.teleporter;

import net.kprzeslawski.ugx.item.custom.UGXDimensionTeleport;
import net.kprzeslawski.ugx.menutype.UGXMenu;
import net.kprzeslawski.ugx.world.UGXDataComponents;
import net.kprzeslawski.ugx.worldgen.dimension.UGXDimensions;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;

import java.util.Arrays;

public class TeleportMenu extends AbstractContainerMenu {

    public ItemStack item;
    public TeleportMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }

    public TeleportMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(UGXMenu.TELEPORT_MENU.get(), pContainerId);
        item = pPlayerInventory.getSelected();
        if(item.isEmpty())
            return;
    }

    public boolean clickMenuButton(Player player, int id){

        if(item.isEmpty() || !(item.getItem() instanceof UGXDimensionTeleport)){
            player.closeContainer();
            return false;
        }
        if (!(player.level() instanceof ServerLevel serverlevel))
            return true;

        ResourceKey<Level> targetDim = switch (id){
            case 0 -> UGXDimensions.UGX_DIM_L1;
            case 1 -> UGXDimensions.UGX_DIM_L2;
            case 2 -> UGXDimensions.UGX_DIM_L3;
            case 3 -> UGXDimensions.UGX_DIM_L4;
            case 4 -> UGXDimensions.UGX_DIM_L5;
            case 5 -> UGXDimensions.UGX_DIM_L6;
            case 6 -> UGXDimensions.UGX_DIM_L7;
            case 7 -> UGXDimensions.UGX_DIM_L8;
            case 8 -> UGXDimensions.UGX_DIM_L9;
            case 9 -> UGXDimensions.UGX_DIM_L10;
            default -> Level.OVERWORLD;
        };

        MinecraftServer minecraftserver = serverlevel.getServer();
        ServerLevel portalDimension = minecraftserver.getLevel(targetDim);
        if (portalDimension == null || player.isPassenger()) {
            player.closeContainer();
            return true;
        }

        double x = 0, y = 0, z = 100;
        x = player.position().x;
        y = 16;
        z = player.position().z;
        item.set(UGXDataComponents.TELEPORT_INITIAL_POSITION.get(), Arrays.asList(
                player.position().x,
                player.position().y,
                player.position().z
        ));
        player.changeDimension(
                new DimensionTransition(portalDimension,
                        new Vec3(x,y,z), new Vec3(0,0,0),
                        player.getYRot(), player.getXRot(),
                        DimensionTransition.DO_NOTHING)
        );
        player.closeContainer();
        return true;
    }
    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        return null;
    }
    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }
}
