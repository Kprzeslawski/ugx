package net.kprzeslawski.ugx.menutype.energizestation;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public class UGXButtonBaseConfirm {
    int posX;
    int posY;
    static final int sizeX = 22;
    static final int sizeY = 22;
    boolean enabled;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    static final ResourceLocation BUTTON_DISABLED_SPRITE = ResourceLocation.withDefaultNamespace("container/beacon/button_disabled");
    static final ResourceLocation BUTTON_HIGHLIGHTED_SPRITE = ResourceLocation.withDefaultNamespace("container/beacon/button_highlighted");
    static final ResourceLocation BUTTON_SPRITE = ResourceLocation.withDefaultNamespace("container/beacon/button");
    static final ResourceLocation CONFIRM_SPRITE = ResourceLocation.withDefaultNamespace("container/beacon/confirm");

    public UGXButtonBaseConfirm(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.enabled = false;
    }

    public boolean isOver(int ofX, int ofY,int mouseX, int mouseY){
        return posX + ofX <= mouseX && mouseX <= posX + sizeX + ofX &&
                posY + ofY <= mouseY && mouseY <= posY + sizeY + ofY;
    }

    public void render(GuiGraphics pGuiGraphics, int ofX, int ofY, int pMouseX, int pMouseY){
        if(this.enabled){
            if(isOver(ofX,ofY,pMouseX,pMouseY))
                pGuiGraphics.blitSprite(BUTTON_HIGHLIGHTED_SPRITE,ofX+posX,ofY+posY,sizeX,sizeY);
            else
                pGuiGraphics.blitSprite(BUTTON_SPRITE,ofX+posX,ofY+posY,sizeX,sizeY);
        }else
            pGuiGraphics.blitSprite(BUTTON_DISABLED_SPRITE,ofX+posX,ofY+posY,sizeX,sizeY);

        pGuiGraphics.blitSprite(CONFIRM_SPRITE,ofX+posX,ofY+posY,sizeX,sizeY);
    }


}
