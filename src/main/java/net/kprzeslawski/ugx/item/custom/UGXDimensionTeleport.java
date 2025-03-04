package net.kprzeslawski.ugx.item.custom;

import net.kprzeslawski.ugx.menutype.energizestation.EnergizeStationMenu;
import net.kprzeslawski.ugx.menutype.teleporter.TeleportMenu;
import net.kprzeslawski.ugx.world.UGXDataComponents;
import net.kprzeslawski.ugx.worldgen.dimension.UGXDimensions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class UGXDimensionTeleport extends Item {
    public UGXDimensionTeleport(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        use(pContext.getLevel(), pContext.getPlayer(), pContext.getHand());
        return InteractionResult.SUCCESS;
    }

    private static final Component CONTAINER_TITLE = Component.translatable("container.teleport");
    public MenuProvider getMenuProvider(@NotNull Level pLevel) {
        return new SimpleMenuProvider((p_277304_, p_277305_, p_277306_)
                -> new TeleportMenu(p_277304_, p_277305_, ContainerLevelAccess.NULL), CONTAINER_TITLE);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        if (!(pPlayer.level() instanceof ServerLevel serverlevel))
            return InteractionResultHolder.pass(itemstack);

        ResourceKey<Level> levelResourceKey = pPlayer.level().dimension();

        if(levelResourceKey == Level.OVERWORLD) {
            pPlayer.openMenu(getMenuProvider(pLevel));
            return InteractionResultHolder.success(itemstack);
        } else if(
                levelResourceKey == UGXDimensions.UGX_DIM_L1
                || levelResourceKey == UGXDimensions.UGX_DIM_L2
                || levelResourceKey == UGXDimensions.UGX_DIM_L3
                || levelResourceKey == UGXDimensions.UGX_DIM_L4
                || levelResourceKey == UGXDimensions.UGX_DIM_L5
                || levelResourceKey == UGXDimensions.UGX_DIM_L6
                || levelResourceKey == UGXDimensions.UGX_DIM_L7
                || levelResourceKey == UGXDimensions.UGX_DIM_L8
                || levelResourceKey == UGXDimensions.UGX_DIM_L9
                || levelResourceKey == UGXDimensions.UGX_DIM_L10
        ){
            double x = 0, y = 0, z = 100;
            var dest = itemstack.get(UGXDataComponents.TELEPORT_INITIAL_POSITION.get());
            x = dest.get(0);
            y = dest.get(1);
            z = dest.get(2);

            MinecraftServer minecraftserver = serverlevel.getServer();
            ServerLevel portalDimension = minecraftserver.getLevel(Level.OVERWORLD);

            pPlayer.changeDimension(
                new DimensionTransition(portalDimension,
                        new Vec3(x,y,z), new Vec3(0,0,0),
                        pPlayer.getYRot(), pPlayer.getXRot(),
                        DimensionTransition.DO_NOTHING)
            );

        } else
            pPlayer.sendSystemMessage(Component.literal("You can only use this item in overworld and target dimension"));

        return InteractionResultHolder.fail(itemstack);

//        if(pPlayer.level().dimension() != targetDim && pPlayer.level().dimension() == Level.OVERWORLD) {
//            pPlayer.sendSystemMessage(Component.literal("You can only use this item in overworld and target dimension"));
//            return InteractionResultHolder.success(itemstack);
//        }
//
//        if (!(pPlayer.level() instanceof ServerLevel serverlevel))
//            return InteractionResultHolder.success(itemstack);
//
//        MinecraftServer minecraftserver = serverlevel.getServer();
//        ResourceKey<Level> currentTarget = pPlayer.level().dimension() == targetDim ? Level.OVERWORLD : targetDim;
//
//        ServerLevel portalDimension = minecraftserver.getLevel(currentTarget);
//        if (portalDimension == null || pPlayer.isPassenger())
//            return InteractionResultHolder.success(itemstack);
//
//        double x = 0, y = 0, z = 100;
//
//        if(currentTarget == targetDim) {
//            x = pPlayer.position().x;
//            y = 16;
//            z = pPlayer.position().z;
//            itemstack.set(UGXDataComponents.TELEPORT_INITIAL_POSITION.get(), Arrays.asList(
//                    pPlayer.position().x,
//                    pPlayer.position().y,
//                    pPlayer.position().z
//            ));
//        } else {
//            var dest = itemstack.get(UGXDataComponents.TELEPORT_INITIAL_POSITION.get());
//            x = dest.get(0);
//            y = dest.get(1);
//            z = dest.get(2);
//        }
//
//        pPlayer.changeDimension(
//                new DimensionTransition(portalDimension,
//                        new Vec3(x,y,z), new Vec3(0,0,0),
//                        pPlayer.getYRot(), pPlayer.getXRot(),
//                        DimensionTransition.DO_NOTHING)
//        );
//
//        return InteractionResultHolder.success(itemstack);
    }
}
