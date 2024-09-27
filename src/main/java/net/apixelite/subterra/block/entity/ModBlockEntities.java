package net.apixelite.subterra.block.entity;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.block.ModBlocks;
import net.apixelite.subterra.block.entity.custom.DrillUpgradeStationBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    
    @SuppressWarnings("deprecation")
    public static final BlockEntityType<DrillUpgradeStationBlockEntity> DRILL_UPGRADE_STATION_BLOCK_ENTITY =
        Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Subterra.MOD_ID, "drill_upgrade_be"),
            FabricBlockEntityTypeBuilder.create(DrillUpgradeStationBlockEntity::new,
                ModBlocks.DRILL_UPGRADE_STATION).build());

    public static void registerBlockEntities() {
        Subterra.LOGGER.info("Registering Block Entities for " + Subterra.MOD_ID);
    }
}
