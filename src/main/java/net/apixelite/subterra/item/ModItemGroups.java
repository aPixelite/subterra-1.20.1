package net.apixelite.subterra.item;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.block.ModBlocks;
import net.apixelite.subterra.fluid.ModFluids;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup SUBTERRA_GROUP = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(Subterra.MOD_ID, "subterra_group"), FabricItemGroup.builder()
            .displayName(Text.translatable("itemgroup.subterra_group"))
            .icon(() -> new ItemStack(ModItems.ARAGONITE_INGOT))
            .entries((displayContext, entries) -> {
                
                // ENDERITE
                entries.add(ModBlocks.ENDERITE_ORE);

                entries.add(ModItems.RAW_ENDERITE);
                entries.add(ModItems.ENDERITE_INGOT);

                entries.add(ModItems.ENDERITE_STICK);

                entries.add(ModItems.ENDERITE_SWORD);
                entries.add(ModItems.ENDERITE_PICKAXE);
                entries.add(ModItems.ENDERITE_AXE);
                entries.add(ModItems.ENDERITE_SHOVEL);
                entries.add(ModItems.ENDERITE_HOE);

                entries.add(ModItems.ENDERITE_HELMET);
                entries.add(ModItems.ENDERITE_CHESTPLATE);
                entries.add(ModItems.ENDERITE_LEGGINGS);
                entries.add(ModItems.ENDERITE_BOOTS);
                
                // ARAGONITE
                entries.add(ModBlocks.ARAGONITE_ORE);

                entries.add(ModItems.RAW_ARAGONITE);
                entries.add(ModItems.ARAGONITE_INGOT);

                entries.add(ModItems.ARAGONITE_STICK);

                entries.add(ModItems.ARAGONITE_SWORD);
                entries.add(ModItems.ARAGONITE_PICKAXE);
                entries.add(ModItems.ARAGONITE_AXE);
                entries.add(ModItems.ARAGONITE_SHOVEL);
                entries.add(ModItems.ARAGONITE_HOE);

                entries.add(ModItems.ARAGONITE_HELMET);
                entries.add(ModItems.ARAGONITE_CHESTPLATE);
                entries.add(ModItems.ARAGONITE_LEGGINGS);
                entries.add(ModItems.ARAGONITE_BOOTS);
                
                // INFERNITE
                entries.add(ModBlocks.INFERNITE_ORE);

                entries.add(ModItems.RAW_INFERNITE);
                entries.add(ModItems.INFERNITE_INGOT);

                entries.add(ModItems.INFERNITE_STICK);

                entries.add(ModItems.INFERNITE_SWORD);
                entries.add(ModItems.INFERNITE_PICKAXE);
                entries.add(ModItems.INFERNITE_AXE);
                entries.add(ModItems.INFERNITE_SHOVEL);
                entries.add(ModItems.INFERNITE_HOE);

                entries.add(ModItems.INFERNITE_HELMET);
                entries.add(ModItems.INFERNITE_CHESTPLATE);
                entries.add(ModItems.INFERNITE_LEGGINGS);
                entries.add(ModItems.INFERNITE_BOOTS);
                
                // DRILL ITEMS
                entries.add(ModFluids.EMPTY_BARREL);
                entries.add(ModFluids.OIL_BARREL);
                entries.add(ModItems.FUEL_BARREL);
                entries.add(ModBlocks.DRILL_UPGRADE_STATION);

                entries.add(ModItems.DIAMOND_DRILL);
                entries.add(ModItems.NETHERITE_DRILL);
                entries.add(ModItems.ENDERITE_DRILL);
                entries.add(ModItems.ARAGONITE_DRILL);
                entries.add(ModItems.INFERNITE_DRILL);

                entries.add(ModItems.DRILL_ENGINE);
                entries.add(ModItems.DRILL_ENGINE_TIER_I);
                entries.add(ModItems.DRILL_ENGINE_TIER_II);
                entries.add(ModItems.DRILL_ENGINE_TIER_III);
                entries.add(ModItems.DRILL_ENGINE_TIER_IV);
                entries.add(ModItems.DRILL_ENGINE_TIER_V);

                entries.add(ModItems.FUEL_TANK);
                entries.add(ModItems.FUEL_TANK_TIER_I);
                entries.add(ModItems.FUEL_TANK_TIER_II);
                entries.add(ModItems.FUEL_TANK_TIER_III);
                entries.add(ModItems.FUEL_TANK_TIER_IV);

                entries.add(ModItems.MULTI_MINE_TIER_I);
                entries.add(ModItems.MULTI_MINE_TIER_II);
                entries.add(ModItems.MULTI_MINE_TIER_III);

            }).build());
    
    public static void registerItemGroups() {
        Subterra.LOGGER.info("Registering Item Groups for " + Subterra.MOD_ID);
    }

}
