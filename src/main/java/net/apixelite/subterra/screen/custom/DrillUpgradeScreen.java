package net.apixelite.subterra.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;

import net.apixelite.subterra.Subterra;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DrillUpgradeScreen extends HandledScreen<DrillUpgradeScreenHandler> {
    private static final Identifier TEXTURE = Identifier.of(Subterra.MOD_ID, "textures/gui/drill_upgrade_station_gui.png");
    private static final Identifier BARREL_SLOT_TEXTURE = Identifier.of(Subterra.MOD_ID, "textures/gui/empty_barrel_slot.png");
    private static final Identifier DRILL_SLOT_TEXTURE = Identifier.of(Subterra.MOD_ID, "textures/gui/empty_drill_slot.png");
    private static final Identifier ENGINE_SLOT_TEXTURE = Identifier.of(Subterra.MOD_ID, "textures/gui/empty_engine_slot.png");
    private static final Identifier TANK_SLOT_TEXTURE = Identifier.of(Subterra.MOD_ID, "textures/gui/empty_tank_slot.png");

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
        RenderSystem.setShader(RenderSystem.getShader());
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        Slot drillSlot = this.handler.getSlot(0);
        Slot tankSlot = this.handler.getSlot(1);
        Slot engineSlot = this.handler.getSlot(2);
        Slot upgradeSlot = this.handler.getSlot(3);
        Slot fuelSlot = this.handler.getSlot(4);

        context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x, y, 0.0F, 0.0F, backgroundWidth, backgroundHeight, 256, 256);

        if (!drillSlot.hasStack()) {
            context.drawTexture(RenderLayer::getGuiTextured, DRILL_SLOT_TEXTURE, x + 80, y + 26, 0, 0, 16, 16, 16, 16);
        }
        if (!tankSlot.hasStack()) {
            context.drawTexture(RenderLayer::getGuiTextured, TANK_SLOT_TEXTURE, x + 36, y + 17, 0, 0, 16, 16, 16, 16);
        }
        if (!engineSlot.hasStack()) {
            context.drawTexture(RenderLayer::getGuiTextured,ENGINE_SLOT_TEXTURE, x + 36, y + 35, 0, 0, 16, 16, 16, 16);
        }
        /*
        if (!upgradeSlot.hasStack()) {
            context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x + 36, y + 53, 176, 65, 16, 16);
        }
        */
        if (!fuelSlot.hasStack()) {
            context.drawTexture(RenderLayer::getGuiTextured, BARREL_SLOT_TEXTURE, x + 124, y + 17, 0, 0, 16, 16, 16, 16);
        }

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseY, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }

}
