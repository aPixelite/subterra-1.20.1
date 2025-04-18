package net.apixelite.subterra.datagen;

import net.apixelite.subterra.block.ModBlocks;
import net.apixelite.subterra.fluid.ModFluids;
import net.apixelite.subterra.item.ModItems;
import net.apixelite.subterra.util.ModEquipmentKeys;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

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

        itemModelGenerator.register(ModFluids.EMPTY_BARREL, Models.GENERATED);
        itemModelGenerator.register(ModFluids.OIL_BARREL, Models.GENERATED);
        itemModelGenerator.register(ModItems.FUEL_BARREL, Models.GENERATED);


        // ENDERITE
        itemModelGenerator.register(ModItems.RAW_ENDERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ENDERITE_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.ENDERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_DRILL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_HOE, Models.HANDHELD);

        registerArmor(itemModelGenerator, ModItems.ENDERITE_HELMET, "helmet", ModEquipmentKeys.ENDERITE);
        registerArmor(itemModelGenerator, ModItems.ENDERITE_CHESTPLATE, "chestplate", ModEquipmentKeys.ENDERITE);
        registerArmor(itemModelGenerator, ModItems.ENDERITE_LEGGINGS, "leggings", ModEquipmentKeys.ENDERITE);
        registerArmor(itemModelGenerator, ModItems.ENDERITE_BOOTS, "boots", ModEquipmentKeys.ENDERITE);
        
        // ARAGONITE
        itemModelGenerator.register(ModItems.RAW_ARAGONITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARAGONITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ARAGONITE_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARAGONITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.ARAGONITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARAGONITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARAGONITE_DRILL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARAGONITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARAGONITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARAGONITE_HOE, Models.HANDHELD);

        registerArmor(itemModelGenerator, ModItems.ARAGONITE_HELMET, "helmet", ModEquipmentKeys.ARAGONITE);
        registerArmor(itemModelGenerator, ModItems.ARAGONITE_CHESTPLATE, "chestplate", ModEquipmentKeys.ARAGONITE);
        registerArmor(itemModelGenerator, ModItems.ARAGONITE_LEGGINGS, "leggings", ModEquipmentKeys.ARAGONITE);
        registerArmor(itemModelGenerator, ModItems.ARAGONITE_BOOTS, "boots", ModEquipmentKeys.ARAGONITE);

        // INFERNITE
        itemModelGenerator.register(ModItems.RAW_INFERNITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.INFERNITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.INFERNITE_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.INFERNITE_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.INFERNITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERNITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERNITE_DRILL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERNITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERNITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERNITE_HOE, Models.HANDHELD);

        registerArmor(itemModelGenerator, ModItems.INFERNITE_HELMET, "helmet", ModEquipmentKeys.INFERNITE);
        registerArmor(itemModelGenerator, ModItems.INFERNITE_CHESTPLATE, "chestplate", ModEquipmentKeys.INFERNITE);
        registerArmor(itemModelGenerator, ModItems.INFERNITE_LEGGINGS, "leggings", ModEquipmentKeys.INFERNITE);
        registerArmor(itemModelGenerator, ModItems.INFERNITE_BOOTS, "boots", ModEquipmentKeys.INFERNITE);
    }

    private void registerArmor(ItemModelGenerator itemModelGenerator, Item item, String type, RegistryKey<EquipmentAsset> equipmentAsset) {
        itemModelGenerator.registerArmor(item, equipmentAsset, Identifier.ofVanilla("trims/items/" + type + "_trim"), false);
//        EquipmentModel.builder().addHumanoidLayers(Identifier.of(Subterra.MOD_ID, name)).build();
    }

}
