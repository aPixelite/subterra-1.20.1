package net.apixelite.subterra;

import net.apixelite.subterra.fluid.ModFluids;
import net.apixelite.subterra.screen.ModScreenHandlers;
import net.apixelite.subterra.screen.custom.DrillUpgradeScreen;
import net.apixelite.subterra.util.TooltipHelper;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class SubterraClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ItemTooltipCallback.EVENT.register((stack, context, tooltipType, lines) -> {
            TooltipHelper.appendTooltip(stack, lines);
        });

        HandledScreens.register(ModScreenHandlers.DRILL_UPGRADE_SCREEN_HANDLER, DrillUpgradeScreen::new);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_OIL, ModFluids.FLOWING_OIL,
                new SimpleFluidRenderHandler(
                        Identifier.of(Subterra.MOD_ID, "block/oil_still"),
                        Identifier.of(Subterra.MOD_ID, "block/oil_flowing"),
                        Identifier.of(Subterra.MOD_ID, "block/oil_overlay")));
        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_OIL, ModFluids.FLOWING_OIL);

    }

}
