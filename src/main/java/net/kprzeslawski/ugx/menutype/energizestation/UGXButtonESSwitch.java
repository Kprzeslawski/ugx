package net.kprzeslawski.ugx.menutype.energizestation;

import net.kprzeslawski.ugx.UGX;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class UGXButtonESSwitch  {
    int posX;
    int posY;
    static final int sizeX = 50;
    static final int sizeY = 20;
    boolean enabled;
    Component text;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    static final ResourceLocation BUTTON_DISABLED_SPRITE = ResourceLocation.tryBuild(UGX.MOD_ID,"es/button_disabled");
    static final ResourceLocation BUTTON_HIGHLIGHTED_SPRITE = ResourceLocation.tryBuild(UGX.MOD_ID,"es/button_highlighted");
    static final ResourceLocation BUTTON_SPRITE = ResourceLocation.tryBuild(UGX.MOD_ID,"es/button");

    public UGXButtonESSwitch(int posX, int posY, Component text) {
        this.posX = posX;
        this.posY = posY;
        this.enabled = true;
        this.text = text;
    }

    public boolean isOver(int ofX, int ofY,int mouseX, int mouseY){
        return posX + ofX <= mouseX && mouseX <= posX + sizeX + ofX &&
                posY + ofY <= mouseY && mouseY <= posY + sizeY + ofY;
    }

    public void render(GuiGraphics pGuiGraphics, int ofX, int ofY, int pMouseX, int pMouseY, Font font){
        if(this.enabled){
            if(isOver(ofX,ofY,pMouseX,pMouseY))
                pGuiGraphics.blitSprite(BUTTON_HIGHLIGHTED_SPRITE,ofX+posX,ofY+posY,sizeX,sizeY);
            else
                pGuiGraphics.blitSprite(BUTTON_SPRITE,ofX+posX,ofY+posY,sizeX,sizeY);
        }else
            pGuiGraphics.blitSprite(BUTTON_DISABLED_SPRITE,ofX+posX,ofY+posY,sizeX,sizeY);

        pGuiGraphics.drawCenteredString(font,this.text,ofX+posX + 25,ofY+posY + 5, ChatFormatting.WHITE.getColor());
    }
}

