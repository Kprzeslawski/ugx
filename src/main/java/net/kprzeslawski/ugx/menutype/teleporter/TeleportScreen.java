package net.kprzeslawski.ugx.menutype.teleporter;

import com.mojang.blaze3d.systems.RenderSystem;
import net.kprzeslawski.ugx.UGX;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import java.util.Arrays;
import java.util.List;

public class TeleportScreen extends AbstractContainerScreen<TeleportMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.tryBuild(UGX.MOD_ID,"textures/gui/teleport_gui.png");

    private List<UGXButton> BUTTONS;

    public TeleportScreen(TeleportMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageHeight = 256;

        BUTTONS = Arrays.asList(
                new UGXButton(28,8, Component.translatable(UGX.MOD_ID + ":ugx_dl1")),
                new UGXButton(28,32, Component.translatable(UGX.MOD_ID + ":ugx_dl2")),
                new UGXButton(28,56, Component.translatable(UGX.MOD_ID + ":ugx_dl3")),
                new UGXButton(28,80, Component.translatable(UGX.MOD_ID + ":ugx_dl4")),
                new UGXButton(28,104, Component.translatable(UGX.MOD_ID + ":ugx_dl5")),
                new UGXButton(28,128, Component.translatable(UGX.MOD_ID + ":ugx_dl6")),
                new UGXButton(28,152, Component.translatable(UGX.MOD_ID + ":ugx_dl7")),
                new UGXButton(28,176, Component.translatable(UGX.MOD_ID + ":ugx_dl8")),
                new UGXButton(28,200, Component.translatable(UGX.MOD_ID + ":ugx_dl9")),
                new UGXButton(28,224, Component.translatable(UGX.MOD_ID + ":ugx_dl10"))
        );
        for(UGXButton b : BUTTONS)
            b.setEnabled(true);
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        for(int i = 0; i < BUTTONS.size(); i++)
            if(BUTTONS.get(i).isEnabled() && BUTTONS.get(i).isOver(x,y,(int) pMouseX, (int) pMouseY))
                if(this.menu.clickMenuButton(this.minecraft.player, i)){
                    this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, i);
                    return true;
                }

        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
        for(UGXButton b : BUTTONS)
            b.render(guiGraphics,x,y,pMouseX,pMouseY,this.font);
    }

    @Override
    protected void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {}
}
