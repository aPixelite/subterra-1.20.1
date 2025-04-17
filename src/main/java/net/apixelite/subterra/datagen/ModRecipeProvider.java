package net.apixelite.subterra.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.apixelite.subterra.block.ModBlocks;
import net.apixelite.subterra.fluid.ModFluids;
import net.apixelite.subterra.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

public class ModRecipeProvider extends FabricRecipeProvider{

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> ENDERITE_SMELTABLES = List.of(ModItems.RAW_ENDERITE, ModBlocks.ENDERITE_ORE);
                List<ItemConvertible> ARAGONITE_SMELTABLES = List.of(ModItems.RAW_ARAGONITE, ModBlocks.ARAGONITE_ORE);
                List<ItemConvertible> INFERNITE_SMELTABLES = List.of(ModItems.RAW_INFERNITE, ModBlocks.INFERNITE_ORE);
                List<ItemConvertible> FUEL_SMELTABLES = List.of(ModFluids.OIL_BARREL);

                // Drill Upgrade Station
                createShaped(RecipeCategory.TOOLS, ModBlocks.DRILL_UPGRADE_STATION)
                        .pattern("III")
                        .pattern("PAP")
                        .pattern("PSP")
                        .input('P', ItemTags.PLANKS)
                        .input('I', Items.IRON_INGOT)
                        .input('A', Items.ANVIL)
                        .input('S', Items.SMITHING_TABLE)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .criterion(hasItem(Items.ANVIL), conditionsFromItem(Items.ANVIL))
                        .criterion(hasItem(Items.SMITHING_TABLE), conditionsFromItem(Items.SMITHING_TABLE))
                        .offerTo(exporter);

                // Barrel
                createShaped(RecipeCategory.TOOLS, ModFluids.EMPTY_BARREL)
                        .pattern("P P")
                        .pattern("III")
                        .pattern("PPP")
                        .input('P', ItemTags.PLANKS)
                        .input('I', Items.IRON_INGOT)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);

                // Engines
                createShaped(RecipeCategory.TOOLS, ModItems.DRILL_ENGINE)
                        .pattern("III")
                        .pattern("BFB")
                        .pattern("BTB")
                        .input('B', Items.IRON_BLOCK)
                        .input('I', Items.IRON_INGOT)
                        .input('F', Items.FIRE_CHARGE)
                        .input('T', ModItems.FUEL_TANK)
                        .criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.DRILL_ENGINE_TIER_I)
                        .pattern("III")
                        .pattern("BEB")
                        .pattern("BBB")
                        .input('B', Items.GOLD_BLOCK)
                        .input('I', Items.GOLD_INGOT)
                        .input('E', ModItems.DRILL_ENGINE)
                        .criterion(hasItem(ModItems.DRILL_ENGINE), conditionsFromItem(ModItems.DRILL_ENGINE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.DRILL_ENGINE_TIER_II)
                        .pattern("CHC")
                        .pattern("BEB")
                        .pattern("CIC")
                        .input('B', Items.BLAST_FURNACE)
                        .input('I', Items.DIAMOND)
                        .input('C', Items.PRISMARINE_CRYSTALS)
                        .input('H', Items.HEART_OF_THE_SEA)
                        .input('E', ModItems.DRILL_ENGINE)
                        .criterion(hasItem(ModItems.DRILL_ENGINE), conditionsFromItem(ModItems.DRILL_ENGINE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.DRILL_ENGINE_TIER_III)
                        .pattern("SSS")
                        .pattern("IEI")
                        .pattern("TIT")
                        .input('S', Items.SUGAR)
                        .input('T', ModItems.FUEL_TANK)
                        .input('I', ModItems.ARAGONITE_INGOT)
                        .input('E', ModItems.DRILL_ENGINE_TIER_II)
                        .criterion(hasItem(ModItems.DRILL_ENGINE), conditionsFromItem(ModItems.DRILL_ENGINE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.DRILL_ENGINE_TIER_IV)
                        .pattern("INI")
                        .pattern("OEO")
                        .pattern("IOI")
                        .input('N', Items.NETHER_STAR)
                        .input('I', Items.NETHERITE_INGOT)
                        .input('O', Items.OBSIDIAN)
                        .input('E', ModItems.DRILL_ENGINE_TIER_III)
                        .criterion(hasItem(ModItems.DRILL_ENGINE), conditionsFromItem(ModItems.DRILL_ENGINE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.DRILL_ENGINE_TIER_V)
                        .pattern("DID")
                        .pattern("MEM")
                        .pattern("IMI")
                        .input('M', Items.MAGMA_BLOCK)
                        .input('D', Items.DRAGON_BREATH)
                        .input('I', ModItems.INFERNITE_INGOT)
                        .input('E', ModItems.DRILL_ENGINE_TIER_IV)
                        .criterion(hasItem(ModItems.DRILL_ENGINE), conditionsFromItem(ModItems.DRILL_ENGINE))
                        .offerTo(exporter);


                // Fuel Tanks
                createShaped(RecipeCategory.TOOLS, ModItems.FUEL_TANK)
                        .pattern("BIB")
                        .pattern("BGB")
                        .pattern("BIB")
                        .input('B', Items.IRON_BLOCK)
                        .input('I', Items.IRON_INGOT)
                        .input('G', Items.GLASS_PANE)
                        .criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.FUEL_TANK_TIER_I)
                        .pattern("BGB")
                        .pattern("BTB")
                        .pattern("BIB")
                        .input('B', Items.GOLD_BLOCK)
                        .input('G', Items.GLOWSTONE_DUST)
                        .input('I', Items.GOLD_INGOT)
                        .input('T', ModItems.FUEL_TANK)
                        .criterion(hasItem(ModItems.FUEL_TANK), conditionsFromItem(ModItems.FUEL_TANK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.FUEL_TANK_TIER_II)
                        .pattern("CHC")
                        .pattern("BTB")
                        .pattern("CIC")
                        .input('B', Items.DIAMOND_BLOCK)
                        .input('I', Items.DIAMOND)
                        .input('H', Items.HEART_OF_THE_SEA)
                        .input('C', Items.PRISMARINE_CRYSTALS)
                        .input('T', ModItems.FUEL_TANK_TIER_I)
                        .criterion(hasItem(ModItems.FUEL_TANK), conditionsFromItem(ModItems.FUEL_TANK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.FUEL_TANK_TIER_III)
                        .pattern("PNP")
                        .pattern("ATA")
                        .pattern("PNP")
                        .input('P', Items.PHANTOM_MEMBRANE)
                        .input('N', Items.NETHERITE_INGOT)
                        .input('A', ModItems.ARAGONITE_INGOT)
                        .input('T', ModItems.FUEL_TANK_TIER_II)
                        .criterion(hasItem(ModItems.FUEL_TANK), conditionsFromItem(ModItems.FUEL_TANK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.FUEL_TANK_TIER_IV)
                        .pattern("SNS")
                        .pattern("ITI")
                        .pattern("SIS")
                        .input('N', Items.NETHER_STAR)
                        .input('S', Items.SHULKER_BOX)
                        .input('I', ModItems.INFERNITE_INGOT)
                        .input('T', ModItems.FUEL_TANK_TIER_III)
                        .criterion(hasItem(ModItems.FUEL_TANK), conditionsFromItem(ModItems.FUEL_TANK))
                        .offerTo(exporter);

                // Upgrade Modules
                // Multi Mine
                createShaped(RecipeCategory.TOOLS, ModItems.MULTI_MINE_TIER_I)
                        .pattern(" E ")
                        .pattern("EDE")
                        .pattern(" E ")
                        .input('E', ModItems.ENDERITE_INGOT)
                        .input('D', ModItems.DRILL_ENGINE)
                        .criterion(hasItem(ModItems.ENDERITE_INGOT), conditionsFromItem(ModItems.ENDERITE_INGOT))
                        .criterion(hasItem(ModItems.DRILL_ENGINE), conditionsFromItem(ModItems.DRILL_ENGINE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.MULTI_MINE_TIER_II)
                        .pattern(" A ")
                        .pattern("AMA")
                        .pattern(" A ")
                        .input('A', ModItems.ARAGONITE_INGOT)
                        .input('M', ModItems.MULTI_MINE_TIER_I)
                        .criterion(hasItem(ModItems.ARAGONITE_INGOT), conditionsFromItem(ModItems.ARAGONITE_INGOT))
                        .criterion(hasItem(ModItems.MULTI_MINE_TIER_I), conditionsFromItem(ModItems.MULTI_MINE_TIER_I))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.MULTI_MINE_TIER_III)
                        .pattern(" I ")
                        .pattern("IMI")
                        .pattern(" I ")
                        .input('I', ModItems.INFERNITE_INGOT)
                        .input('M', ModItems.MULTI_MINE_TIER_II)
                        .criterion(hasItem(ModItems.INFERNITE_INGOT), conditionsFromItem(ModItems.INFERNITE_INGOT))
                        .criterion(hasItem(ModItems.MULTI_MINE_TIER_II), conditionsFromItem(ModItems.MULTI_MINE_TIER_II))
                        .offerTo(exporter);

                // Drills
                createShaped(RecipeCategory.TOOLS, ModItems.DIAMOND_DRILL)
                        .pattern("PD ")
                        .pattern("DTB")
                        .pattern(" BE")
                        .input('D', Items.DIAMOND)
                        .input('P', Items.DIAMOND_PICKAXE)
                        .input('B', Items.IRON_BLOCK)
                        .input('E', ModItems.DRILL_ENGINE)
                        .input('T', ModItems.FUEL_TANK)
                        .criterion(hasItem(ModItems.FUEL_TANK), conditionsFromItem(ModItems.FUEL_TANK))
                        .criterion(hasItem(ModItems.DRILL_ENGINE), conditionsFromItem(ModItems.DRILL_ENGINE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.NETHERITE_DRILL)
                        .pattern("PN ")
                        .pattern("NDB")
                        .pattern(" BE")
                        .input('N', Items.NETHERITE_INGOT)
                        .input('P', Items.NETHERITE_PICKAXE)
                        .input('B', Items.IRON_BLOCK)
                        .input('E', ModItems.DRILL_ENGINE)
                        .input('D', ModItems.DIAMOND_DRILL)
                        .criterion(hasItem(ModItems.DIAMOND_DRILL), conditionsFromItem(ModItems.DIAMOND_DRILL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERITE_DRILL)
                        .pattern("SI ")
                        .pattern("IDB")
                        .pattern(" BE")
                        .input('B', Items.IRON_BLOCK)
                        .input('I', ModItems.ENDERITE_INGOT)
                        .input('S', ModItems.ENDERITE_STICK)
                        .input('E', ModItems.DRILL_ENGINE)
                        .input('D', ModItems.NETHERITE_DRILL)
                        .criterion(hasItem(ModItems.DIAMOND_DRILL), conditionsFromItem(ModItems.NETHERITE_DRILL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ARAGONITE_DRILL)
                        .pattern("SI ")
                        .pattern("IDB")
                        .pattern(" BE")
                        .input('B', Items.DIAMOND_BLOCK)
                        .input('I', ModItems.ARAGONITE_INGOT)
                        .input('S', ModItems.ARAGONITE_STICK)
                        .input('E', ModItems.DRILL_ENGINE)
                        .input('D', ModItems.ENDERITE_DRILL)
                        .criterion(hasItem(ModItems.DIAMOND_DRILL), conditionsFromItem(ModItems.ENDERITE_DRILL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.INFERNITE_DRILL)
                        .pattern("SI ")
                        .pattern("IDB")
                        .pattern(" BE")
                        .input('B', Items.OBSIDIAN)
                        .input('I', ModItems.INFERNITE_INGOT)
                        .input('S', ModItems.INFERNITE_STICK)
                        .input('E', ModItems.DRILL_ENGINE)
                        .input('D', ModItems.ARAGONITE_DRILL)
                        .criterion(hasItem(ModItems.DIAMOND_DRILL), conditionsFromItem(ModItems.ARAGONITE_DRILL))
                        .offerTo(exporter);


                // Smelting
                OreSmeltingRecipe(ENDERITE_SMELTABLES, ModItems.ENDERITE_INGOT, 2.0f, 200, "enderite");
                OreSmeltingRecipe(ARAGONITE_SMELTABLES, ModItems.ARAGONITE_INGOT, 4.0f, 200, "aragonite");
                OreSmeltingRecipe(INFERNITE_SMELTABLES, ModItems.INFERNITE_INGOT, 6.0f, 200, "infernite");
                offerSmelting(FUEL_SMELTABLES, RecipeCategory.MISC, ModItems.FUEL_BARREL, 8.5f, 400, "fuel");

                // Helmet
                ShapedToolRecipeBuilder("III", "I#I", "   ", ModItems.ENDERITE_INGOT, Items.NETHERITE_HELMET, "enderite_helmet", ModItems.ENDERITE_HELMET, exporter);
                ShapedToolRecipeBuilder("III", "I#I", "   ", ModItems.ARAGONITE_INGOT, ModItems.ENDERITE_HELMET, "aragonite_helmet", ModItems.ARAGONITE_HELMET, exporter);
                ShapedToolRecipeBuilder("III", "I#I", "   ", ModItems.INFERNITE_INGOT, ModItems.ARAGONITE_HELMET, "infernite_helmet", ModItems.INFERNITE_HELMET, exporter);

                // Chestplate
                ShapedToolRecipeBuilder("I#I", "III", "III", ModItems.ENDERITE_INGOT, Items.NETHERITE_CHESTPLATE, "enderite_chestplate", ModItems.ENDERITE_CHESTPLATE, exporter);
                ShapedToolRecipeBuilder("I#I", "III", "III", ModItems.ARAGONITE_INGOT, ModItems.ENDERITE_CHESTPLATE, "aragonite_chestplate", ModItems.ARAGONITE_CHESTPLATE, exporter);
                ShapedToolRecipeBuilder("I#I", "III", "III", ModItems.INFERNITE_INGOT, ModItems.ARAGONITE_CHESTPLATE, "infernite_chestplate", ModItems.INFERNITE_CHESTPLATE, exporter);

                // Leggings
                ShapedToolRecipeBuilder("III", "I#I", "I I", ModItems.ENDERITE_INGOT, Items.NETHERITE_LEGGINGS, "enderite_leggings", ModItems.ENDERITE_LEGGINGS, exporter);
                ShapedToolRecipeBuilder("III", "I#I", "I I", ModItems.ARAGONITE_INGOT, ModItems.ENDERITE_LEGGINGS, "aragonite_leggings", ModItems.ARAGONITE_LEGGINGS, exporter);
                ShapedToolRecipeBuilder("III", "I#I", "I I", ModItems.INFERNITE_INGOT, ModItems.ARAGONITE_LEGGINGS, "infernite_leggings", ModItems.INFERNITE_LEGGINGS, exporter);

                // Boots
                ShapedToolRecipeBuilder("   ", "I#I", "I I", ModItems.ENDERITE_INGOT, Items.NETHERITE_BOOTS, "enderite_boots", ModItems.ENDERITE_BOOTS, exporter);
                ShapedToolRecipeBuilder("   ", "I#I", "I I", ModItems.ARAGONITE_INGOT, ModItems.ENDERITE_BOOTS, "aragonite_boots", ModItems.ARAGONITE_BOOTS, exporter);
                ShapedToolRecipeBuilder("   ", "I#I", "I I", ModItems.INFERNITE_INGOT, ModItems.ARAGONITE_BOOTS, "infernite_boots", ModItems.INFERNITE_BOOTS, exporter);

                // Sword
                ShapedToolRecipeBuilder(" I ", " I ", " # ", ModItems.ENDERITE_INGOT, ModItems.ENDERITE_STICK, "enderite_sword", ModItems.ENDERITE_SWORD, exporter);
                ShapedToolRecipeBuilder(" I ", " I ", " # ", ModItems.ARAGONITE_INGOT, ModItems.ARAGONITE_STICK, "aragonite_sword", ModItems.ARAGONITE_SWORD, exporter);
                ShapedToolRecipeBuilder(" I ", " I ", " # ", ModItems.INFERNITE_INGOT, ModItems.INFERNITE_STICK, "infernite_sword", ModItems.INFERNITE_SWORD, exporter);

                // Pickaxe
                ShapedToolRecipeBuilder("III", " # ", " # ", ModItems.ENDERITE_INGOT, ModItems.ENDERITE_STICK, "enderite_pickaxe", ModItems.ENDERITE_PICKAXE, exporter);
                ShapedToolRecipeBuilder("III", " # ", " # ", ModItems.ARAGONITE_INGOT, ModItems.ARAGONITE_STICK, "aragonite_pickaxe", ModItems.ARAGONITE_PICKAXE, exporter);
                ShapedToolRecipeBuilder("III", " # ", " # ", ModItems.INFERNITE_INGOT, ModItems.INFERNITE_STICK, "infernite_pickaxe", ModItems.INFERNITE_PICKAXE, exporter);

                // Axe
                ShapedToolRecipeBuilder("II ", "I# ", " # ", ModItems.ENDERITE_INGOT, ModItems.ENDERITE_STICK, "enderite_axe", ModItems.ENDERITE_AXE, exporter);
                ShapedToolRecipeBuilder("II ", "I# ", " # ", ModItems.ARAGONITE_INGOT, ModItems.ARAGONITE_STICK, "aragonite_axe", ModItems.ARAGONITE_AXE, exporter);
                ShapedToolRecipeBuilder("II ", "I# ", " # ", ModItems.INFERNITE_INGOT, ModItems.INFERNITE_STICK, "infernite_axe", ModItems.INFERNITE_AXE, exporter);

                //Shovel
                ShapedToolRecipeBuilder(" I ", " # ", " # ", ModItems.ENDERITE_INGOT, ModItems.ENDERITE_STICK, "enderite_shovel", ModItems.ENDERITE_SHOVEL, exporter);
                ShapedToolRecipeBuilder(" I ", " # ", " # ", ModItems.ARAGONITE_INGOT, ModItems.ARAGONITE_STICK, "aragonite_shovel", ModItems.ARAGONITE_SHOVEL, exporter);
                ShapedToolRecipeBuilder(" I ", " # ", " # ", ModItems.INFERNITE_INGOT, ModItems.INFERNITE_STICK, "infernite_shovel", ModItems.INFERNITE_SHOVEL, exporter);

                // Hoe
                ShapedToolRecipeBuilder("II ", " # ", " # ", ModItems.ENDERITE_INGOT, ModItems.ENDERITE_STICK, "enderite_hoe", ModItems.ENDERITE_HOE, exporter);
                ShapedToolRecipeBuilder("II ", " # ", " # ", ModItems.ARAGONITE_INGOT, ModItems.ARAGONITE_STICK, "aragonite_hoe", ModItems.ARAGONITE_HOE, exporter);
                ShapedToolRecipeBuilder("II ", " # ", " # ", ModItems.INFERNITE_INGOT, ModItems.INFERNITE_STICK, "infernite_hoe", ModItems.INFERNITE_HOE, exporter);

                // Stick
                ShapedToolRecipeBuilder("   ", " I ", " # ", ModItems.ENDERITE_INGOT, ModItems.ENDERITE_INGOT, "enderite_stick", ModItems.ENDERITE_STICK, exporter);
                ShapedToolRecipeBuilder("   ", " I ", " # ", ModItems.ARAGONITE_INGOT, ModItems.ARAGONITE_INGOT, "aragonite_stick", ModItems.ARAGONITE_STICK, exporter);
                ShapedToolRecipeBuilder("   ", " I ", " # ", ModItems.INFERNITE_INGOT, ModItems.INFERNITE_INGOT, "infernite_stick", ModItems.INFERNITE_STICK, exporter);

            }
            private void ShapedToolRecipeBuilder(String pat1, String pat2, String pat3,
                                                 Item ingot, Item item, String name, Item result, RecipeExporter exporter) {
                createShaped(RecipeCategory.TOOLS, result)
                        .pattern(pat1)
                        .pattern(pat2)
                        .pattern(pat3)
                        .input('#', item)
                        .input('I', ingot)
                        .criterion(hasItem(ingot), conditionsFromItem(ingot))
                        .offerTo(exporter);
            }

            private void OreSmeltingRecipe(List<ItemConvertible> input, Item result,
                                                  float reward, int time, String name) {
                offerSmelting(input, RecipeCategory.MISC, result,
                        reward, time, name);
                offerBlasting(input, RecipeCategory.MISC, result,
                        reward, (time / 2), name);
            }
        };
    }

    @Override
    public String getName() {
        return "";
    }
}
