package net.apixelite.subterra.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.apixelite.subterra.block.ModBlocks;
import net.apixelite.subterra.fluid.ModFluids;
import net.apixelite.subterra.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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

                // Upgrade Templates
                offerSmithingTemplateCopyingRecipe(ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, Blocks.END_STONE_BRICKS);
                offerSmithingTemplateCopyingRecipe(ModItems.ARAGONITE_UPGRADE_SMITHING_TEMPLATE, Blocks.GRASS_BLOCK);
                offerSmithingTemplateCopyingRecipe(ModItems.INFERNITE_UPGRADE_SMITHING_TEMPLATE, Blocks.SOUL_SAND);

                // Smelting
                OreSmeltingRecipe(ENDERITE_SMELTABLES, ModItems.ENDERITE_INGOT, 2.0f, 200, "enderite");
                OreSmeltingRecipe(ARAGONITE_SMELTABLES, ModItems.ARAGONITE_INGOT, 4.0f, 200, "aragonite");
                OreSmeltingRecipe(INFERNITE_SMELTABLES, ModItems.INFERNITE_INGOT, 6.0f, 200, "infernite");
                offerSmelting(FUEL_SMELTABLES, RecipeCategory.MISC, ModItems.FUEL_BARREL, 8.5f, 400, "fuel");

                // Helmet
                offerEnderiteUpgradeRecipe(Items.NETHERITE_HELMET, ModItems.ENDERITE_HELMET, RecipeCategory.COMBAT, exporter);
                offerAragoniteUpgradeRecipe(ModItems.ENDERITE_HELMET, ModItems.ARAGONITE_HELMET, RecipeCategory.COMBAT, exporter);
                offerInferniteUpgradeRecipe(ModItems.ARAGONITE_HELMET, ModItems.INFERNITE_HELMET, RecipeCategory.COMBAT, exporter);
                // Chestplate
                offerEnderiteUpgradeRecipe(Items.NETHERITE_CHESTPLATE, ModItems.ENDERITE_CHESTPLATE, RecipeCategory.COMBAT, exporter);
                offerAragoniteUpgradeRecipe(ModItems.ENDERITE_CHESTPLATE, ModItems.ARAGONITE_CHESTPLATE, RecipeCategory.COMBAT, exporter);
                offerInferniteUpgradeRecipe(ModItems.ARAGONITE_CHESTPLATE, ModItems.INFERNITE_CHESTPLATE, RecipeCategory.COMBAT, exporter);

                // Leggings
                offerEnderiteUpgradeRecipe(Items.NETHERITE_LEGGINGS, ModItems.ENDERITE_LEGGINGS, RecipeCategory.COMBAT, exporter);
                offerAragoniteUpgradeRecipe(ModItems.ENDERITE_LEGGINGS, ModItems.ARAGONITE_LEGGINGS, RecipeCategory.COMBAT, exporter);
                offerInferniteUpgradeRecipe(ModItems.ARAGONITE_LEGGINGS, ModItems.INFERNITE_LEGGINGS, RecipeCategory.COMBAT, exporter);

                // Boots
                offerEnderiteUpgradeRecipe(Items.NETHERITE_BOOTS, ModItems.ENDERITE_BOOTS, RecipeCategory.COMBAT, exporter);
                offerAragoniteUpgradeRecipe(ModItems.ENDERITE_BOOTS, ModItems.ARAGONITE_BOOTS, RecipeCategory.COMBAT, exporter);
                offerInferniteUpgradeRecipe(ModItems.ARAGONITE_BOOTS, ModItems.INFERNITE_BOOTS, RecipeCategory.COMBAT, exporter);

                // Sword
                offerEnderiteUpgradeRecipe(Items.NETHERITE_SWORD, ModItems.ENDERITE_SWORD, RecipeCategory.COMBAT, exporter);
                offerAragoniteUpgradeRecipe(ModItems.ENDERITE_SWORD, ModItems.ARAGONITE_SWORD, RecipeCategory.COMBAT, exporter);
                offerInferniteUpgradeRecipe(ModItems.ARAGONITE_SWORD, ModItems.INFERNITE_SWORD, RecipeCategory.COMBAT, exporter);

                // Pickaxe
                offerEnderiteUpgradeRecipe(Items.NETHERITE_PICKAXE, ModItems.ENDERITE_PICKAXE, RecipeCategory.TOOLS, exporter);
                offerAragoniteUpgradeRecipe(ModItems.ENDERITE_PICKAXE, ModItems.ARAGONITE_PICKAXE, RecipeCategory.TOOLS, exporter);
                offerInferniteUpgradeRecipe(ModItems.ARAGONITE_PICKAXE, ModItems.INFERNITE_PICKAXE, RecipeCategory.TOOLS, exporter);

                // Axe
                offerEnderiteUpgradeRecipe(Items.NETHERITE_AXE, ModItems.ENDERITE_AXE, RecipeCategory.TOOLS, exporter);
                offerAragoniteUpgradeRecipe(ModItems.ENDERITE_AXE, ModItems.ARAGONITE_AXE, RecipeCategory.TOOLS, exporter);
                offerInferniteUpgradeRecipe(ModItems.ARAGONITE_AXE, ModItems.INFERNITE_AXE, RecipeCategory.TOOLS, exporter);

                //Shovel
                offerEnderiteUpgradeRecipe(Items.NETHERITE_SHOVEL, ModItems.ENDERITE_SHOVEL, RecipeCategory.TOOLS, exporter);
                offerAragoniteUpgradeRecipe(ModItems.ENDERITE_SHOVEL, ModItems.ARAGONITE_SHOVEL, RecipeCategory.TOOLS, exporter);
                offerInferniteUpgradeRecipe(ModItems.ARAGONITE_SHOVEL, ModItems.INFERNITE_SHOVEL, RecipeCategory.TOOLS, exporter);

                // Hoe
                offerEnderiteUpgradeRecipe(Items.NETHERITE_HOE, ModItems.ENDERITE_HOE, RecipeCategory.TOOLS, exporter);
                offerAragoniteUpgradeRecipe(ModItems.ENDERITE_HOE, ModItems.ARAGONITE_HOE, RecipeCategory.TOOLS, exporter);
                offerInferniteUpgradeRecipe(ModItems.ARAGONITE_HOE, ModItems.INFERNITE_HOE, RecipeCategory.TOOLS, exporter);

                // Stick
                StickRecipeBuilder(ModItems.ENDERITE_INGOT, ModItems.ENDERITE_STICK, exporter);
                StickRecipeBuilder(ModItems.ARAGONITE_INGOT, ModItems.ARAGONITE_STICK, exporter);
                StickRecipeBuilder(ModItems.INFERNITE_INGOT, ModItems.INFERNITE_STICK, exporter);
            }

            private void offerEnderiteUpgradeRecipe(Item input, Item result, RecipeCategory category, RecipeExporter exporter) {
                ItemUpgradeRecipe(input, ModItems.ENDERITE_INGOT, ModItems.ENDERITE_UPGRADE_SMITHING_TEMPLATE, result, exporter, category);
            }
            private void offerAragoniteUpgradeRecipe(Item input, Item result, RecipeCategory category, RecipeExporter exporter) {
                ItemUpgradeRecipe(input, ModItems.ARAGONITE_INGOT, ModItems.ARAGONITE_UPGRADE_SMITHING_TEMPLATE, result, exporter, category);
            }
            private void offerInferniteUpgradeRecipe(Item input, Item result, RecipeCategory category, RecipeExporter exporter) {
                ItemUpgradeRecipe(input, ModItems.INFERNITE_INGOT, ModItems.INFERNITE_UPGRADE_SMITHING_TEMPLATE, result, exporter, category);
            }

            private void ItemUpgradeRecipe(Item item, Item ingot, Item template, Item result, RecipeExporter exporter, RecipeCategory category) {
                SmithingTransformRecipeJsonBuilder.create(
                                Ingredient.ofItem(template),
                                Ingredient.ofItem(item),
                                Ingredient.ofItem(ingot),
                                category,
                                result
                        )
                        .criterion("has_required_ingot", conditionsFromItem(ingot))
                        .offerTo(exporter, getItemPath(result) + "_smithing");
            }

            private void StickRecipeBuilder(Item item, Item result, RecipeExporter exporter) {
                createShaped(RecipeCategory.TOOLS, result)
                        .pattern("   ")
                        .pattern(" # ")
                        .pattern(" # ")
                        .input('#', item)
                        .criterion(hasItem(item), conditionsFromItem(item))
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
