package net.apixelite.subterra.item;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.item.custom.DrillEngine;
import net.apixelite.subterra.item.custom.DrillItem;
import net.apixelite.subterra.item.custom.FuelTank;
import net.apixelite.subterra.item.custom.upgrademodules.MultiMine;
import net.apixelite.subterra.util.CustomRarity;
import net.apixelite.subterra.util.ModEquipmentKeys;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.component.DataComponentTypes;

public class ModItems {

    // ENDERITE
    public static final Item RAW_ENDERITE = registerItem("raw_enderite", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "raw_enderite")))
            .fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_INGOT = registerItem("enderite_ingot", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_ingot")))
            .fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item ENDERITE_STICK = registerItem("enderite_stick", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_stick")))
            .fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item ENDERITE_SWORD = registerItem("enderite_sword",
        new SwordItem(ModToolMaterials.ENDERITE, 7, -2.4f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_sword")))
                .fireproof()
                .rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_PICKAXE = registerItem("enderite_pickaxe",
        new PickaxeItem(ModToolMaterials.ENDERITE, 1, -2.8f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_pickaxe")))
                .fireproof()
                .rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_AXE = registerItem("enderite_axe",
        new AxeItem(ModToolMaterials.ENDERITE, 12, -2.8f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_pickaxe")))
                .fireproof()
                .rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_SHOVEL = registerItem("enderite_shovel",
        new ShovelItem(ModToolMaterials.ENDERITE, 1.5f, -3.0f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_pickaxe")))
                .fireproof()
                .rarity(Rarity.UNCOMMON)));
    public static final Item ENDERITE_HOE = registerItem("enderite_hoe",
        new HoeItem(ModToolMaterials.ENDERITE, -5, 0.0f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_pickaxe")))
                .fireproof()
                .rarity(Rarity.UNCOMMON)));

    public static final Item ENDERITE_HELMET = registerItem("enderite_helmet", 
        new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, EquipmentType.HELMET,
            new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_helmet")))
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(43)).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item ENDERITE_CHESTPLATE = registerItem("enderite_chestplate",
        new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE,
            new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_chestplate")))
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(43)).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item ENDERITE_LEGGINGS = registerItem("enderite_leggings",
        new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS,
            new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_leggings")))
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(43)).fireproof().rarity(Rarity.UNCOMMON)));

    public static final Item ENDERITE_BOOTS = registerItem("enderite_boots",
        new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, EquipmentType.BOOTS,
            new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_boots")))
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(43)).fireproof().rarity(Rarity.UNCOMMON)));
    

    // ARAGONITE
    public static final Item RAW_ARAGONITE = registerItem("raw_aragonite", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "raw_aragonite")))
            .fireproof().rarity(Rarity.RARE)));
    public static final Item ARAGONITE_INGOT = registerItem("aragonite_ingot", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_ingot")))
            .fireproof().rarity(Rarity.RARE)));

    public static final Item ARAGONITE_STICK = registerItem("aragonite_stick", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_stick")))
            .fireproof().rarity(Rarity.RARE)));

    public static final Item ARAGONITE_SWORD = registerItem("aragonite_sword", 
        new SwordItem(ModToolMaterials.ARAGONITE, 10, -2.4f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_sword")))
                .fireproof()
                .rarity(Rarity.RARE)));
    public static final Item ARAGONITE_PICKAXE = registerItem("aragonite_pickaxe",
        new PickaxeItem(ModToolMaterials.ARAGONITE, 1, -2.8f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_pickaxe")))
                .fireproof()
                .rarity(Rarity.RARE)));
    public static final Item ARAGONITE_AXE = registerItem("aragonite_axe",
        new AxeItem(ModToolMaterials.ARAGONITE, 18, -2.5f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_axe")))
                .fireproof()
                .rarity(Rarity.RARE)));
    public static final Item ARAGONITE_SHOVEL = registerItem("aragonite_shovel",
        new ShovelItem(ModToolMaterials.ARAGONITE, 1.5f, -3.0f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_shovel")))
                .fireproof()
                .rarity(Rarity.RARE)));
    public static final Item ARAGONITE_HOE = registerItem("aragonite_hoe",
        new HoeItem(ModToolMaterials.ARAGONITE, -6, 0.0f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_hoe")))
                .fireproof()
                .rarity(Rarity.RARE)));

    public static final Item ARAGONITE_HELMET = registerItem("aragonite_helmet", 
            new ArmorItem(ModArmorMaterials.ARAGONITE_ARMOR_MATERIAL, EquipmentType.HELMET, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_helmet")))
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(51)).fireproof().rarity(Rarity.RARE)));

    public static final Item ARAGONITE_CHESTPLATE = registerItem("aragonite_chestplate", 
            new ArmorItem(ModArmorMaterials.ARAGONITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_chestplate")))
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(51)).fireproof().rarity(Rarity.RARE)));

    public static final Item ARAGONITE_LEGGINGS = registerItem("aragonite_leggings", 
            new ArmorItem(ModArmorMaterials.ARAGONITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_leggings")))
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(51)).fireproof().rarity(Rarity.RARE)));

    public static final Item ARAGONITE_BOOTS = registerItem("aragonite_boots", 
            new ArmorItem(ModArmorMaterials.ARAGONITE_ARMOR_MATERIAL, EquipmentType.BOOTS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_boots")))
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(51)).fireproof().rarity(Rarity.RARE)));
    

    // INFERNITE
    public static final Item RAW_INFERNITE = registerItem("raw_infernite", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "raw_infernite")))
            .fireproof().rarity(Rarity.RARE)));
    public static final Item INFERNITE_INGOT = registerItem("infernite_ingot", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_ingot")))
            .fireproof().rarity(Rarity.RARE)));

    public static final Item INFERNITE_STICK = registerItem("infernite_stick", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_stick")))
            .fireproof().rarity(Rarity.RARE)));


    public static final Item INFERNITE_SWORD = registerItem("infernite_sword", 
        new SwordItem(ModToolMaterials.INFERNITE, 14, -2.4f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_sword")))
                .fireproof()
                .rarity(Rarity.EPIC)));
    public static final Item INFERNITE_PICKAXE = registerItem("infernite_pickaxe",
        new PickaxeItem(ModToolMaterials.INFERNITE, 1, -2.8f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_pickaxe")))
                .fireproof()
                .rarity(Rarity.EPIC)));
    public static final Item INFERNITE_AXE = registerItem("infernite_axe",
        new AxeItem(ModToolMaterials.INFERNITE, 26, -2.5f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_axe")))
                .fireproof()
                .rarity(Rarity.EPIC)));
    public static final Item INFERNITE_SHOVEL = registerItem("infernite_shovel",
        new ShovelItem(ModToolMaterials.INFERNITE, 1.5f, -3.0f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_shovel")))
                .fireproof()
                .rarity(Rarity.EPIC)));
    public static final Item INFERNITE_HOE = registerItem("infernite_hoe",
        new HoeItem(ModToolMaterials.INFERNITE, -7, 0.0f, new Item.Settings()
                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_hoe")))
                .fireproof()
                .rarity(Rarity.EPIC)));

    public static final Item INFERNITE_HELMET = registerItem("infernite_helmet", 
            new ArmorItem(ModArmorMaterials.INFERNITE_ARMOR_MATERIAL, EquipmentType.HELMET, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_helmet")))
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(69)).fireproof().rarity(Rarity.EPIC)));
    public static final Item INFERNITE_CHESTPLATE = registerItem("infernite_chestplate", 
            new ArmorItem(ModArmorMaterials.INFERNITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_chestplate")))
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(69)).fireproof().rarity(Rarity.EPIC)));
    public static final Item INFERNITE_LEGGINGS = registerItem("infernite_leggings", 
            new ArmorItem(ModArmorMaterials.INFERNITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_leggings")))
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(69)).fireproof().rarity(Rarity.EPIC)));
    public static final Item INFERNITE_BOOTS = registerItem("infernite_boots", 
            new ArmorItem(ModArmorMaterials.INFERNITE_ARMOR_MATERIAL, EquipmentType.BOOTS, new Item.Settings()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_boots")))
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(69)).fireproof().rarity(Rarity.EPIC)));



    // DRILLS
    public static final Item DIAMOND_DRILL = registerItem("diamond_drill", 
    new DrillItem(ModToolMaterials.DRILL_MATERIAL, 15, 1, -2.8f, CustomRarity.COMMON,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "diamond_drill")))));
    public static final Item NETHERITE_DRILL = registerItem("netherite_drill", 
    new DrillItem(ModToolMaterials.DRILL_MATERIAL, 25, 1, -2.8f, CustomRarity.UNCOMMON,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "netherite_drill")))));
    public static final Item ENDERITE_DRILL = registerItem("enderite_drill", 
    new DrillItem(ModToolMaterials.DRILL_MATERIAL, 35, 2, -2.8f, CustomRarity.RARE,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "enderite_drill")))));
    public static final Item ARAGONITE_DRILL = registerItem("aragonite_drill", 
    new DrillItem(ModToolMaterials.DRILL_MATERIAL, 42, 3, -2.8f, CustomRarity.EPIC,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "aragonite_drill")))));
    public static final Item INFERNITE_DRILL = registerItem("infernite_drill", 
    new DrillItem(ModToolMaterials.DRILL_MATERIAL, 50, 5, -2.8f, CustomRarity.LEGENDARY,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "infernite_drill")))));

    // DRILL PARTS
    // DRILL ENGINES
    public static final Item DRILL_ENGINE = registerItem("drill_engine", new DrillEngine(0, CustomRarity.RARE,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "drill_engine")))
                    .maxCount(1)));
    public static final Item DRILL_ENGINE_TIER_I = registerItem("drill_engine_tier_1", new DrillEngine(1, CustomRarity.RARE,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "drill_engine_tier_1")))
                    .maxCount(1)));
    public static final Item DRILL_ENGINE_TIER_II = registerItem("drill_engine_tier_2", new DrillEngine(2, CustomRarity.RARE,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "drill_engine_tier_2")))
                    .maxCount(1)));
    public static final Item DRILL_ENGINE_TIER_III = registerItem("drill_engine_tier_3", new DrillEngine(3, CustomRarity.EPIC,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "drill_engine_tier_3")))
                    .maxCount(1)));
    public static final Item DRILL_ENGINE_TIER_IV = registerItem("drill_engine_tier_4", new DrillEngine(4, CustomRarity.LEGENDARY,
                        new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "drill_engine_tier_4")))
                    .maxCount(1)));
    public static final Item DRILL_ENGINE_TIER_V = registerItem("drill_engine_tier_5", new DrillEngine(5, CustomRarity.MYTHIC,
                        new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "drill_engine_tier_5")))
                    .maxCount(1)));
    
    // FUEL TANKS
    public static final Item FUEL_TANK = registerItem("fuel_tank", new FuelTank(0, CustomRarity.RARE,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "fuel_tank")))
                    .maxCount(1)));
    public static final Item FUEL_TANK_TIER_I = registerItem("fuel_tank_tier_1", new FuelTank(10000, CustomRarity.RARE,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "fuel_tank_tier_1")))
                    .maxCount(1)));
    public static final Item FUEL_TANK_TIER_II = registerItem("fuel_tank_tier_2", new FuelTank(25000, CustomRarity.RARE,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "fuel_tank_tier_2")))
                    .maxCount(1)));
    public static final Item FUEL_TANK_TIER_III = registerItem("fuel_tank_tier_3", new FuelTank(50000, CustomRarity.EPIC,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "fuel_tank_tier_3")))
                    .maxCount(1)));
    public static final Item FUEL_TANK_TIER_IV = registerItem("fuel_tank_tier_4", new FuelTank(100000, CustomRarity.LEGENDARY,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "fuel_tank_tier_4")))
                    .maxCount(1)));

    //UPGRADE MODULES
    //MULTI MINE
    public static final Item MULTI_MINE_TIER_I = registerItem("multi_mine_tier_1", new MultiMine(1, CustomRarity.RARE,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "multi_mine_tier_1")))
                    .maxCount(1)));
    public static final Item MULTI_MINE_TIER_II = registerItem("multi_mine_tier_2", new MultiMine(2, CustomRarity.RARE,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "multi_mine_tier_2")))
                    .maxCount(1)));
    public static final Item MULTI_MINE_TIER_III = registerItem("multi_mine_tier_3", new MultiMine(3, CustomRarity.EPIC,
            new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "multi_mine_tier_3")))
                    .maxCount(1)));

    //FUEL
    public static final Item FUEL_BARREL = registerItem("fuel_barrel", new Item(new Item.Settings()
            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, "fuel_barrel")))
            .maxCount(1)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Subterra.MOD_ID, name)), item);
    }

    public static void registerModItems() {
        Subterra.LOGGER.info("Registering Mod Items for " + Subterra.MOD_ID);
    }
    
}
