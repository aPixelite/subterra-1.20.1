package net.apixelite.subterra.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;

import net.apixelite.subterra.Subterra;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DrillUpgradeScreen extends HandledScreen<DrillUpgradeScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(Subterra.MOD_ID, "textures/gui/drill_upgrade_station_gui.png");

    public DrillUpgradeScreen(DrillUpgradeScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleY = 1000;
        playerInventoryTitleY = 1000;
    }
    

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        Slot drillSlot = this.handler.getSlot(0);
        Slot engineSlot = this.handler.getSlot(1);
        Slot upgradeSlot = this.handler.getSlot(2);
        Slot tankSlot = this.handler.getSlot(3);

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        if (!drillSlot.hasStack()) {
            context.drawTexture(TEXTURE, x + 80, y + 17, 176, 0, 16, 16);
        }
        if (!engineSlot.hasStack()) {
            context.drawTexture(TEXTURE, x + 53, y + 39, 176, 15, 16, 16);
        }
        if (!upgradeSlot.hasStack()) {
            context.drawTexture(TEXTURE, x + 80, y + 53, 176, 48, 16, 16);
        }
        if (!tankSlot.hasStack()) {
            context.drawTexture(TEXTURE, x + 107, y + 39, 176, 33, 16, 16);
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseY, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

}
