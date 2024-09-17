package net.apixelite.subterra;

import net.apixelite.subterra.datagen.ModBlockTagProvider;
import net.apixelite.subterra.datagen.ModItemTagProvider;
import net.apixelite.subterra.datagen.ModLootTableProvider;
import net.apixelite.subterra.datagen.ModModelProvider;
import net.apixelite.subterra.datagen.ModRecipeProvider;
import net.apixelite.subterra.datagen.ModWorldGenerator;
import net.apixelite.subterra.world.ModConfiguredFeatures;
import net.apixelite.subterra.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class SubterraDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::boostrap);
	}
}
