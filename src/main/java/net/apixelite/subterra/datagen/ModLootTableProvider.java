package net.apixelite.subterra.datagen;

import net.apixelite.subterra.block.ModBlocks;
import net.apixelite.subterra.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider{

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ENDERITE_ORE, oreLikeDrops(ModBlocks.ENDERITE_ORE, ModItems.RAW_ENDERITE));
        addDrop(ModBlocks.ARAGONITE_ORE, oreLikeDrops(ModBlocks.ARAGONITE_ORE, ModItems.RAW_ARAGONITE));
        addDrop(ModBlocks.INFERNITE_ORE, oreLikeDrops(ModBlocks.INFERNITE_ORE, ModItems.RAW_INFERNITE));

        addDrop(ModBlocks.DRILL_UPGRADE_STATION);
    }

    public LootTable.Builder oreLikeDrops(Block dropWithSilkTouch, Item drop) {
		return dropsWithSilkTouch(
			dropWithSilkTouch,
			(LootPoolEntry.Builder<?>)this.applyExplosionDecay(dropWithSilkTouch, ItemEntry.builder(drop))
		);
	}

}
