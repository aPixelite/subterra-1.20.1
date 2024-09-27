package net.apixelite.subterra.screen;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.screen.custom.DrillUpgradeScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<DrillUpgradeScreenHandler> DRILL_UPGRADE_SCREEN_HANDLER =
        Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Subterra.MOD_ID, "drill_upgrade_screen_handler"),
            new ExtendedScreenHandlerType<>(DrillUpgradeScreenHandler::new, BlockPos.PACKET_CODEC));
    
    public static void registerScreenHandlers() {
        Subterra.LOGGER.info("Registering Screen Handlers for " + Subterra.MOD_ID);
    }

}
