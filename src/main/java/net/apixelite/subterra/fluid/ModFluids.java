package net.apixelite.subterra.fluid;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.item.custom.BarrelItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static final FlowableFluid STILL_OIL = Registry.register(Registries.FLUID,
            Identifier.of(Subterra.MOD_ID, "oil_still"), new OilFluid.Still());
    public static final FlowableFluid FLOWING_OIL = Registry.register(Registries.FLUID,
            Identifier.of(Subterra.MOD_ID, "oil_flowing"), new OilFluid.Flowing());

    public static final Block OIL_BLOCK = Registry.register(Registries.BLOCK, Identifier.of(Subterra.MOD_ID, "oil_block"),
            new FluidBlock(ModFluids.STILL_OIL, AbstractBlock.Settings.copy(Blocks.WATER)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Subterra.MOD_ID, "oil_block")))
                    .replaceable().liquid()));
    public static final Item OIL_BARREL = Registry.register(Registries.ITEM, Identifier.of(Subterra.MOD_ID, "oil_barrel"),
            new BarrelItem(ModFluids.STILL_OIL, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "oil_barrel")))
                    .recipeRemainder(ModFluids.EMPTY_BARREL).maxCount(1)));

    public static final Item EMPTY_BARREL = Registry.register(Registries.ITEM, Identifier.of(Subterra.MOD_ID, "empty_barrel"),
            new BarrelItem(Fluids.EMPTY, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "empty_barrel")))
                    .maxCount(16)));

    public static void registerFluids() {
        Subterra.LOGGER.info("Registering Fluid for " + Subterra.MOD_ID);
    }
}
