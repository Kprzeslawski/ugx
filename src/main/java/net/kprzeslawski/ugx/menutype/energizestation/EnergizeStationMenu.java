package net.kprzeslawski.ugx.menutype.energizestation;

import net.kprzeslawski.ugx.block.UGXBlocks;
import net.kprzeslawski.ugx.item.custom.eq.helpers.UGXEq;
import net.kprzeslawski.ugx.item.custom.eq.helpers.UGXEqStats;
import net.kprzeslawski.ugx.menutype.UGXMenu;
import net.minecraft.Util;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class EnergizeStationMenu extends AbstractContainerMenu {
    private final Container cont_slots = new SimpleContainer(2) {
        @Override
        public void setChanged() {
            super.setChanged();
        }
    };
    private final ContainerLevelAccess access;
    public EnergizeStationMenu(int pContainerId, Inventory pPlayerInventory) {
        this(pContainerId, pPlayerInventory, ContainerLevelAccess.NULL);
    }
    public EnergizeStationMenu(int pContainerId, Inventory pPlayerInventory, ContainerLevelAccess pAccess) {
        super(UGXMenu.ENERGIZING_STATION_MENU.get(), pContainerId);
        this.access = pAccess;
        this.addSlot(new Slot(this.cont_slots, 0, 12, 22) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.getItem() instanceof UGXEq;
            }
            @Override
            public int getMaxStackSize() {
                return 1;
            }
        });
        this.addSlot(new Slot(this.cont_slots, 1, 12, 44) {
            @Override
            public boolean mayPlace(ItemStack itemStack) {
                return itemStack.is(Items.REDSTONE);
            }

        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(pPlayerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; k++) {
            this.addSlot(new Slot(pPlayerInventory, k, 8 + k * 18, 142));
        }
    }


    @Override
    public boolean clickMenuButton(Player pPlayer, int pId) {
        if(pId < 0 || pId > 1){
            Util.logAndPauseIfInIde(pPlayer.getName() + " pressed invalid button id: " + pId);
            return false;
        }

        ItemStack itemstack = this.slots.get(0).getItem();
        ItemStack itemstack1 = this.slots.get(1).getItem();

        if(itemstack.isEmpty())
            return false;

        if(pId == 0){
            var stats = UGXEqStats.getCurrentStats(itemstack);
            var exp_need = stats.cost;
            var pXp = pPlayer.totalExperience;
            if(pXp < exp_need)
                return false;

            pPlayer.experienceLevel = 0;
            pPlayer.experienceProgress = 0;
            pPlayer.totalExperience = 0;
            pPlayer.giveExperiencePoints(pXp - exp_need);


            this.access.execute((p_341512_, p_341513_) -> {
                if(stats.roll())
                    UGXEqStats.upgradeItem(itemstack);
            });

        } else if (pId == 1) {
            if(itemstack1.isEmpty())
                return false;

            this.access.execute((p_341512_, p_341513_) -> {
                itemstack1.consume(1, pPlayer);
                UGXEqStats.shuffleBonuses(itemstack);
            });
        }
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex == 0 || pIndex == 1) {
                if (!this.moveItemStackTo(itemstack1, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.slots.get(1).mayPlace(itemstack1)) {
                if (!this.moveItemStackTo(itemstack1, 1, 2, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (this.slots.get(0).hasItem() || !this.slots.get(0).mayPlace(itemstack1)) {
                    return ItemStack.EMPTY;
                }

                ItemStack itemstack2 = itemstack1.copyWithCount(1);
                itemstack1.shrink(1);
                this.slots.get(0).setByPlayer(itemstack2);
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, itemstack1);
        }

        return itemstack;
    }

    @Override
    public void removed(Player pPlayer) {
        super.removed(pPlayer);

        this.clearContainer(pPlayer, this.slots.get(0).container);
        this.clearContainer(pPlayer, this.slots.get(1).container);
    }

    @Override
    public boolean stillValid(Player pPlayer)  {
        return stillValid(this.access, pPlayer, UGXBlocks.ENERGIZING_STATION_BLOCK.get());
    }
}
