package net.kprzeslawski.ugx.menutype.energizestation;

import com.mojang.blaze3d.systems.RenderSystem;
import net.kprzeslawski.ugx.UGX;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;



public class EnergizeStationScreen extends AbstractContainerScreen<EnergizeStationMenu> {

    private static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(UGX.MOD_ID,"textures/gui/energizing_station_gui.png");
    private static final ResourceLocation SLOT1 = ResourceLocation.tryBuild(UGX.MOD_ID,"es/energizing_station_s1");
    private static final ResourceLocation SLOT2 = ResourceLocation.tryBuild(UGX.MOD_ID,"es/energizing_station_s2");
    private static final ResourceLocation EMPTY_SLOT = ResourceLocation.tryBuild(UGX.MOD_ID,"es/slot");


    private static final List<UGXButtonESSwitch> BUTTONS = Arrays.asList(
            new UGXButtonESSwitch(198,175, Component.literal("Level")),
            new UGXButtonESSwitch(198,200, Component.literal("Tier")),
            new UGXButtonESSwitch(198,225, Component.literal("Bonuses"))
    );

    private static final UGXButtonBaseConfirm CONFIRM_BUTTON =
            new UGXButtonBaseConfirm(45,148);




    public EnergizeStationScreen(EnergizeStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        imageHeight = 256;
        imageWidth = 256;
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;



        for(int i = 0; i < BUTTONS.size(); i++)
            if(BUTTONS.get(i).isEnabled() && BUTTONS.get(i).isOver(x,y,(int) pMouseX, (int) pMouseY))
                changeDisplayType(i);

        if(CONFIRM_BUTTON.isEnabled() && CONFIRM_BUTTON.isOver(x,y,(int) pMouseX, (int) pMouseY))
            if(this.menu.clickMenuButton(this.minecraft.player, this.menu.displayType)){
                this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, this.menu.displayType);
                return true;
            }


        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    public void changeDisplayType(int t){
        if(t == this.menu.displayType)
            return;

        if(this.menu.displayType == 1){
            this.menu.quickMoveStack(this.minecraft.player,1);
            this.menu.quickMoveStack(this.minecraft.player,2);
        } else if (this.menu.displayType == 2){
            this.menu.quickMoveStack(this.minecraft.player,3);
        }

        this.menu.displayType = t;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int mX, int mY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        if(this.menu.getSlot(0).getItem().isEmpty())
            return;

        for(UGXButtonESSwitch b :BUTTONS)
            b.render(guiGraphics,x,y,mX,mY,this.font);

        switch(this.menu.displayType){
            case 0 -> {

            }
            case 1 -> {
                guiGraphics.blitSprite(EMPTY_SLOT,7+x,150+y,18,18);
            }
            case 2 -> {
                guiGraphics.blitSprite(EMPTY_SLOT,7+x,150+y,18,18);
                guiGraphics.blitSprite(EMPTY_SLOT,25+x,150+y,18,18);
            }
        }



        CONFIRM_BUTTON.render(guiGraphics,x,y,mX,mY);

//        ItemStack item1 = this.menu.getSlot(0).getItem();
//        if(item1.isEmpty())
//            guiGraphics.blitSprite(SLOT1, x+12, y+22,16,16);
//        ItemStack item2 = this.menu.getSlot(1).getItem();
//        if(item2.isEmpty())
//            guiGraphics.blitSprite(SLOT2, x+12, y+44,16,16);
//
//        Player p = this.minecraft.player;
//        var exp = p.totalExperience;
//
//        if(item1.isEmpty() || !(item1.getItem() instanceof UGXEq))
//            return;
//
//        var stats = UGXEqStats.getCurrentStats(item1);
//        if(stats.cost > 0) {
//            guiGraphics.drawString(this.font, "EXP " + stats.cost + "/" + exp, x + 40, y + 10, ChatFormatting.BLUE.getColor(),false);
//            guiGraphics.drawString(this.font, "UPGRADE CHANCE " +stats.upgrade_chance, x + 40, y + 20, ChatFormatting.BLUE.getColor(),false);
//            if (exp >= stats.cost) {
//                BUTTONS.get(0).setEnabled(true);
//            } else {
//                BUTTONS.get(0).setEnabled(false);
//            }
//        } else {
//            BUTTONS.get(0).setEnabled(false);
//            guiGraphics.drawString(this.font, "MAX LEVEL REACHED", x + 40, y + 15, ChatFormatting.RED.getColor(),false);
//        }
//        BUTTONS.get(0).render(guiGraphics,x,y,mX,mY);
//
//        if(item2.getCount() > 0) {
//            BUTTONS.get(1).setEnabled(true);
//        } else {
//            BUTTONS.get(1).setEnabled(false);
//        }
//
//        var list = item1.get(UGXDataComponents.BONUSES.get());
//        if(list == null)return;
//        Font t = this.font.self();
//
//
//        guiGraphics.pose().pushPose();
//        float scale = 0.8f;
//        guiGraphics.pose().scale(scale,scale,1);
//        for(int i = 0; i<3; i++){
//            String s = UGXEqStats.BONUSES.get(list.get(i).getFirst()).toolTip + UGXEqStats.BONUSES.get(list.get(i).getFirst()).mapper.apply(list.get(i).getSecond());
//            Integer color = UGXEqStats.colors.get(list.get(i).getSecond()).getColor();
//            guiGraphics.drawString(this.font, s, (x + 40)/scale, (y + 45 + 8 * i)/scale, color,false);
//        }
//
//        guiGraphics.pose().popPose();
//        BUTTONS.get(1).render(guiGraphics,x,y,mX,mY);


    }
    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics, mouseX, mouseY, delta);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {}
}
