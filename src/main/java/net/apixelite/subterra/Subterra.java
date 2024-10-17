package net.apixelite.subterra;

import net.apixelite.subterra.block.ModBlocks;
import net.apixelite.subterra.block.entity.ModBlockEntities;
import net.apixelite.subterra.components.ModDataComponentTypes;
import net.apixelite.subterra.enchantment.ModEnchantmentEffects;
import net.apixelite.subterra.item.ModItemGroups;
import net.apixelite.subterra.item.ModItems;
import net.apixelite.subterra.screen.ModScreenHandlers;
import net.apixelite.subterra.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Subterra implements ModInitializer {
	public static final String MOD_ID = "subterra";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlock();

		ModWorldGeneration.generateModWorldGen();

		ModBlockEntities.registerBlockEntities();

		ModScreenHandlers.registerScreenHandlers();

		ModDataComponentTypes.registerDataComponentTypes();

		ModEnchantmentEffects.registerEnchantmentEffects();
	
	}
}