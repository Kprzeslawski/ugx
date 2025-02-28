package net.kprzeslawski.ugx.block.custom;

import net.kprzeslawski.ugx.menutype.energizestation.EnergizeStationMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class EnergizingStationBlock extends Block {
    private static final Component CONTAINER_TITLE = Component.translatable("container.upgrade");

    public EnergizingStationBlock(Properties pProperties) {
        super(pProperties);
    }

    public MenuProvider getMenuProvider(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos) {
        return new SimpleMenuProvider((p_277304_, p_277305_, p_277306_)
                -> new EnergizeStationMenu(p_277304_, p_277305_, ContainerLevelAccess.create(pLevel, pPos)), CONTAINER_TITLE);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        use(pPlayer, pState, pLevel, pPos);
        return super.useWithoutItem(pState, pLevel, pPos, pPlayer, pHitResult);
    }
    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        use(pPlayer, pState, pLevel, pPos);
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }

    public InteractionResult use(Player player, BlockState state, Level level, BlockPos pos) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            player.openMenu(state.getMenuProvider(level, pos));
            return InteractionResult.CONSUME;
        }
    }
}
