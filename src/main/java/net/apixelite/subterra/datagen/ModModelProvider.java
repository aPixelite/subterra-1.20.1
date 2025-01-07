package net.apixelite.subterra.datagen;

import net.apixelite.subterra.block.ModBlocks;
import net.apixelite.subterra.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider{

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ENDERITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ARAGONITE_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.INFERNITE_ORE);

        blockStateModelGenerator.registerSimpleState(ModBlocks.DRILL_UPGRADE_STATION);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        // OTHER
        itemModelGenerator.register(ModItems.DIAMOND_DRILL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_DRILL, Models.HANDHELD);

        // DRILL ENGINES
        itemModelGenerator.register(ModItems.DRILL_ENGINE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DRILL_ENGINE_TIER_I, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DRILL_ENGINE_TIER_II, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DRILL_ENGINE_TIER_III, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DRILL_ENGINE_TIER_IV, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DRILL_ENGINE_TIER_V, Models.HANDHELD);

        // FUEL TANKS
        itemModelGenerator.register(ModItems.FUEL_TANK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FUEL_TANK_TIER_I, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FUEL_TANK_TIER_II, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FUEL_TANK_TIER_III, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FUEL_TANK_TIER_IV, Models.HANDHELD);

        // UPGRADE MODULES
        // MULTI MINE
        itemModelGenerator.register(ModItems.MULTI_MINE_TIER_I, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MULTI_MINE_TIER_II, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MULTI_MINE_TIER_III, Models.HANDHELD);

        itemModelGenerator.register(ModItems.EMPTY_BARREL, Models.GENERATED);
        itemModelGenerator.register(ModItems.OIL_BARREL, Models.GENERATED);


        // ENDERITE
        itemModelGenerator.register(ModItems.RAW_ENDERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ENDERITE_STICK, Models.GENERATED);

        itemModelGenerator.register(ModItems.ENDERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_DRILL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ENDERITE_BOOTS));
        
        // ARAGONITE
        itemModelGenerator.register(ModItems.RAW_ARAGONITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARAGONITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ARAGONITE_STICK, Models.GENERATED);

        itemModelGenerator.register(ModItems.ARAGONITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARAGONITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARAGONITE_DRILL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARAGONITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARAGONITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARAGONITE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARAGONITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARAGONITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARAGONITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.ARAGONITE_BOOTS));

        // INFERNITE
        itemModelGenerator.register(ModItems.RAW_INFERNITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.INFERNITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.INFERNITE_STICK, Models.GENERATED);

        itemModelGenerator.register(ModItems.INFERNITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERNITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERNITE_DRILL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERNITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERNITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERNITE_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INFERNITE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INFERNITE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INFERNITE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.INFERNITE_BOOTS));
    }

}
