package net.apixelite.subterra.item;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.item.custom.DrillEngine;
import net.apixelite.subterra.item.custom.DrillItem;
import net.apixelite.subterra.item.custom.FuelTank;
import net.apixelite.subterra.item.custom.upgrademodules.MultiMine;
import net.apixelite.subterra.util.CustomRarity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    // ENDERITE
    public static final Item RAW_ENDERITE = registerItem("raw_enderite", new Item(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot", new Item(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item ENDERITE_STICK = registerItem("enderite_stick", new Item(new Item.Settings().fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item ENDERITE_SWORD = registerItem("enderite_sword",
        new SwordItem(ModToolMaterials.ENDERITE,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 7, -2.4f)).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_PICKAXE = registerItem("enderite_pickaxe",
        new PickaxeItem(ModToolMaterials.ENDERITE, 
            new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 1, -2.8f)).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_AXE = registerItem("enderite_axe",
        new AxeItem(ModToolMaterials.ENDERITE,
            new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 12, -2.8f)).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_SHOVEL = registerItem("enderite_shovel",
        new ShovelItem(ModToolMaterials.ENDERITE, 
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ENDERITE, 1.5f, -3.0f)).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_HOE = registerItem("enderite_hoe",
        new HoeItem(ModToolMaterials.ENDERITE, 
            new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ENDERITE, -5, 0.0f)).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item ENDERITE_HELMET = registerItem("enderite_helmet", 
        new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(43)).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_CHESTPLATE = registerItem("enderite_chestplate", 
        new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(43)).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_LEGGINGS = registerItem("enderite_leggings", 
        new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, 
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(43)).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_BOOTS = registerItem("enderite_boots", 
        new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, 
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(43)).fireproof().rarity(Rarity.UNCOMMON)));
    

    // ARAGONITE
    public static final Item RAW_ARAGONITE = registerItem("raw_aragonite", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item ARAGONITE_INGOT = registerItem("aragonite_ingot", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));

    public static final Item ARAGONITE_STICK = registerItem("aragonite_stick", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));

    public static final Item ARAGONITE_SWORD = registerItem("aragonite_sword", 
        new SwordItem(ModToolMaterials.ARAGONITE, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ARAGONITE, 10, -2.4f)).fireproof().rarity(Rarity.RARE)));
    public static final Item ARAGONITE_PICKAXE = registerItem("aragonite_pickaxe",
        new PickaxeItem(ModToolMaterials.ARAGONITE, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ARAGONITE, 1, -2.8f)).fireproof().rarity(Rarity.RARE)));
    public static final Item ARAGONITE_AXE = registerItem("aragonite_axe",
        new AxeItem(ModToolMaterials.ARAGONITE, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.ARAGONITE, 18, -2.5f)).fireproof().rarity(Rarity.RARE)));
    public static final Item ARAGONITE_SHOVEL = registerItem("aragonite_shovel",
        new ShovelItem(ModToolMaterials.ARAGONITE, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ARAGONITE, 1.5f, -3.0f)).fireproof().rarity(Rarity.RARE)));
    public static final Item ARAGONITE_HOE = registerItem("aragonite_hoe",
        new HoeItem(ModToolMaterials.ARAGONITE, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.ARAGONITE, -6, 0.0f)).fireproof().rarity(Rarity.RARE)));

    public static final Item ARAGONITE_HELMET = registerItem("aragonite_helmet", 
            new ArmorItem(ModArmorMaterials.ARAGONITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(51)).fireproof().rarity(Rarity.RARE)));

    public static final Item ARAGONITE_CHESTPLATE = registerItem("aragonite_chestplate", 
            new ArmorItem(ModArmorMaterials.ARAGONITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(51)).fireproof().rarity(Rarity.RARE)));

    public static final Item ARAGONITE_LEGGINGS = registerItem("aragonite_leggings", 
            new ArmorItem(ModArmorMaterials.ARAGONITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
            .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(51)).fireproof().rarity(Rarity.RARE)));

    public static final Item ARAGONITE_BOOTS = registerItem("aragonite_boots", 
            new ArmorItem(ModArmorMaterials.ARAGONITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
            .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(51)).fireproof().rarity(Rarity.RARE)));
    

    // INFERNITE
    public static final Item RAW_INFERNITE = registerItem("raw_infernite", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item INFERNITE_INGOT = registerItem("infernite_ingot", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));

    public static final Item INFERNITE_STICK = registerItem("infernite_stick", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));


    public static final Item INFERNITE_SWORD = registerItem("infernite_sword", 
        new SwordItem(ModToolMaterials.INFERNITE, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.INFERNITE, 14, -2.4f)).fireproof().rarity(Rarity.EPIC)));
    public static final Item INFERNITE_PICKAXE = registerItem("infernite_pickaxe",
        new PickaxeItem(ModToolMaterials.INFERNITE, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.INFERNITE, 1, -2.8f)).fireproof().rarity(Rarity.EPIC)));
    public static final Item INFERNITE_AXE = registerItem("infernite_axe",
        new AxeItem(ModToolMaterials.INFERNITE, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.INFERNITE, 26, -2.5f)).fireproof().rarity(Rarity.EPIC)));
    public static final Item INFERNITE_SHOVEL = registerItem("infernite_shovel",
        new ShovelItem(ModToolMaterials.INFERNITE, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.INFERNITE, 1.5f, -3.0f)).fireproof().rarity(Rarity.EPIC)));
    public static final Item INFERNITE_HOE = registerItem("infernite_hoe",
        new HoeItem(ModToolMaterials.INFERNITE, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.INFERNITE, -7, 0.0f)).fireproof().rarity(Rarity.EPIC)));

    public static final Item INFERNITE_HELMET = registerItem("infernite_helmet", 
            new ArmorItem(ModArmorMaterials.INFERNITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
            .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(69)).fireproof().rarity(Rarity.EPIC)));
    public static final Item INFERNITE_CHESTPLATE = registerItem("infernite_chestplate", 
            new ArmorItem(ModArmorMaterials.INFERNITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
            .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(69)).fireproof().rarity(Rarity.EPIC)));
    public static final Item INFERNITE_LEGGINGS = registerItem("infernite_leggings", 
            new ArmorItem(ModArmorMaterials.INFERNITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
            .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(69)).fireproof().rarity(Rarity.EPIC)));
    public static final Item INFERNITE_BOOTS = registerItem("infernite_boots", 
            new ArmorItem(ModArmorMaterials.INFERNITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
            .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(69)).fireproof().rarity(Rarity.EPIC)));



    // DRILLS
    public static final Item DIAMOND_DRILL = registerItem("diamond_drill", 
    new DrillItem(ModToolMaterials.DRILL_MATERIAL, 15, 1, -2.8f, CustomRarity.COMMON, new Item.Settings()));
    public static final Item NETHERITE_DRILL = registerItem("netherite_drill", 
    new DrillItem(ModToolMaterials.DRILL_MATERIAL, 25, 1, -2.8f, CustomRarity.UNCOMMON, new Item.Settings()));
    public static final Item ENDERITE_DRILL = registerItem("enderite_drill", 
    new DrillItem(ModToolMaterials.DRILL_MATERIAL, 35, 2, -2.8f, CustomRarity.RARE, new Item.Settings()));
    public static final Item ARAGONITE_DRILL = registerItem("aragonite_drill", 
    new DrillItem(ModToolMaterials.DRILL_MATERIAL, 42, 3, -2.8f, CustomRarity.EPIC, new Item.Settings()));
    public static final Item INFERNITE_DRILL = registerItem("infernite_drill", 
    new DrillItem(ModToolMaterials.DRILL_MATERIAL, 50, 5, -2.8f, CustomRarity.LEGENDARY, new Item.Settings()));

    // DRILL PARTS
    // DRILL ENGINES
    public static final Item DRILL_ENGINE = registerItem("drill_engine", new DrillEngine(0, CustomRarity.RARE, new Item.Settings().maxCount(1)));
    public static final Item DRILL_ENGINE_TIER_I = registerItem("drill_engine_tier_1", new DrillEngine(1, CustomRarity.RARE, new Item.Settings().maxCount(1)));
    public static final Item DRILL_ENGINE_TIER_II = registerItem("drill_engine_tier_2", new DrillEngine(2, CustomRarity.RARE, new Item.Settings().maxCount(1)));
    public static final Item DRILL_ENGINE_TIER_III = registerItem("drill_engine_tier_3", new DrillEngine(3, CustomRarity.EPIC, new Item.Settings().maxCount(1)));
    public static final Item DRILL_ENGINE_TIER_IV = registerItem("drill_engine_tier_4", new DrillEngine(4, CustomRarity.LEGENDARY, new Item.Settings().maxCount(1)));
    public static final Item DRILL_ENGINE_TIER_V = registerItem("drill_engine_tier_5", new DrillEngine(5, CustomRarity.MYTHIC, new Item.Settings().maxCount(1)));
    
    // FUEL TANKS
    public static final Item FUEL_TANK = registerItem("fuel_tank", new FuelTank(0, CustomRarity.RARE, new Item.Settings().maxCount(1)));
    public static final Item FUEL_TANK_TIER_I = registerItem("fuel_tank_tier_1", new FuelTank(10000, CustomRarity.RARE, new Item.Settings().maxCount(1)));
    public static final Item FUEL_TANK_TIER_II = registerItem("fuel_tank_tier_2", new FuelTank(25000, CustomRarity.RARE, new Item.Settings().maxCount(1)));
    public static final Item FUEL_TANK_TIER_III = registerItem("fuel_tank_tier_3", new FuelTank(50000, CustomRarity.EPIC, new Item.Settings().maxCount(1)));
    public static final Item FUEL_TANK_TIER_IV = registerItem("fuel_tank_tier_4", new FuelTank(100000, CustomRarity.LEGENDARY, new Item.Settings().maxCount(1)));

    //UPGRADE MODULES
    //MULTIMINE
    public static final Item MULTI_MINE_TIER_I = registerItem("multi_mine_tier_1", new MultiMine(1, CustomRarity.RARE, new Item.Settings().maxCount(1)));
    public static final Item MULTI_MINE_TIER_II = registerItem("multi_mine_tier_2", new MultiMine(2, CustomRarity.RARE, new Item.Settings().maxCount(1)));
    public static final Item MULTI_MINE_TIER_III = registerItem("multi_mine_tier_3", new MultiMine(3, CustomRarity.EPIC, new Item.Settings().maxCount(1)));

    public static final Item EMPTY_BARREL = registerItem("empty_barrel", new Item(new Item.Settings().maxCount(16)));
    public static final Item OIL_BARREL = registerItem("oil_barrel", new Item(new Item.Settings().maxCount(1)));
    
    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Subterra.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Subterra.LOGGER.info("Registering Mod Items for " + Subterra.MOD_ID);
    }
    
}
