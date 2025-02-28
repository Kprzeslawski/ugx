package net.kprzeslawski.ugx.item.custom;

import net.kprzeslawski.ugx.world.UGXDataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;

import java.util.Arrays;

public class UGXDimensionTeleport extends Item {
    public UGXDimensionTeleport(Properties pProperties, ResourceKey<Level> target) {
        super(pProperties);
        this.targetDim = target;
    }
    private final ResourceKey<Level> targetDim;


    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        use(pContext.getLevel(), pContext.getPlayer(), pContext.getHand());
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);

        if(pPlayer.level().dimension() != targetDim && pPlayer.level().dimension() == Level.OVERWORLD) {
            pPlayer.sendSystemMessage(Component.literal("You can only use this item in overworld and target dimension"));
            return InteractionResultHolder.success(itemstack);
        }

        if (!(pPlayer.level() instanceof ServerLevel serverlevel))
            return InteractionResultHolder.success(itemstack);

        MinecraftServer minecraftserver = serverlevel.getServer();
        ResourceKey<Level> currentTarget = pPlayer.level().dimension() == targetDim ? Level.OVERWORLD : targetDim;

        ServerLevel portalDimension = minecraftserver.getLevel(currentTarget);
        if (portalDimension == null || pPlayer.isPassenger())
            return InteractionResultHolder.success(itemstack);

        double x = 0, y = 0, z = 100;

        if(currentTarget == targetDim) {
            x = pPlayer.position().x;
            y = 16;
            z = pPlayer.position().z;
            itemstack.set(UGXDataComponents.TELEPORT_INITIAL_POSITION.get(), Arrays.asList(
                    pPlayer.position().x,
                    pPlayer.position().y,
                    pPlayer.position().z
            ));
        } else {
            var dest = itemstack.get(UGXDataComponents.TELEPORT_INITIAL_POSITION.get());
            x = dest.get(0);
            y = dest.get(1);
            z = dest.get(2);
        }

        pPlayer.changeDimension(
                new DimensionTransition(portalDimension,
                        new Vec3(x,y,z), new Vec3(0,0,0),
                        pPlayer.getYRot(), pPlayer.getXRot(),
                        DimensionTransition.DO_NOTHING)
        );

        return InteractionResultHolder.success(itemstack);
    }
}
