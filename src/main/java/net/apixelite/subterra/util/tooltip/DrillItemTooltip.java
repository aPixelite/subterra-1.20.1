package net.apixelite.subterra.util.tooltip;

import net.apixelite.subterra.components.ModDataComponentTypes;
import net.apixelite.subterra.item.custom.DrillEngine;
import net.apixelite.subterra.item.custom.DrillItem;
import net.apixelite.subterra.item.custom.FuelTank;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.List;

public class DrillItemTooltip {

    private static boolean hasEngine;
    private static boolean hasTank;
    private static boolean hasEnchantments;
    private static boolean hasUpgrade;
    private static int engineTier;
    private static int tankTier;
    private static int upgradeTier;
    private static int fuel;
    private static int maxFuel;
    private static MutableText name;



    public static void setTooltip(DrillItem item, ItemStack stack, List<Text> tooltip) {
        getVariables(stack, item);

        // Item name
        tooltip.add(name);
        tooltip.add(Text.literal("§8Mining level 8"));
        tooltip.add(Text.literal(""));



        // Item Enchants
        if(hasEnchantments) {
            tooltip.add(Text.literal(""));

            tooltip.add(Text.literal("§8Enchantments:"));
            tooltip.add((Text) stack.get(DataComponentTypes.ENCHANTMENTS));
            tooltip.add(Text.literal(""));
        }

        // Drill parts
        // Fuel tank
        if (hasTank) {
            tooltip.add(Text.literal("§aFuel Tank Tier " + tankTier));
            tooltip.add(Text.literal("§7Increase your fuel capacity"));
            tooltip.add(Text.literal("§7to: §2" + FuelTank.getFuel(tankTier)));
        } else {
            tooltip.add(Text.literal("§7Fuel Tank: §cNot Installed"));
            tooltip.add(Text.literal("§7Increase your fuel capacity"));
            tooltip.add(Text.literal("§7with tank installed"));
        }

        tooltip.add(Text.literal(""));

        // Drill Engine
        if (hasEngine) {
            tooltip.add(Text.literal("§aDrill Engine Tier " + engineTier));
            tooltip.add(Text.literal("§7Grants an extra "));
            tooltip.add(Text.literal("§6" + DrillEngine.getMiningSpeed(engineTier) + " Mining Speed"));
        } else {
            tooltip.add(Text.literal("§7Drill Engine: §cNot Installed"));
            tooltip.add(Text.literal("§7Increase your mining speed"));
            tooltip.add(Text.literal("§7with engine installed."));
        }

        tooltip.add(Text.literal(""));

        // Upgrade Module
       if (hasUpgrade) {
            tooltip.add(Text.literal("§aMulti Mine Tier " + upgradeTier));
        } else {
           tooltip.add(Text.literal("§7Upgrade Module: §cNot Installed"));
        }
        tooltip.add(Text.literal(""));


        // Tool ability
        tooltip.add(Text.literal("§7Item Ability: §6Mining Speed Boost"));
        tooltip.add(Text.literal("§7Usage: §e§lRIGHT CLICK"));
        tooltip.add(Text.literal("§7Grants §c300% §6Mining Speed"));
        tooltip.add(Text.literal("§8Duration: §c20s"));
        tooltip.add(Text.literal("§8Cooldown: §c120s"));

        tooltip.add(Text.literal(""));

        // Fuel
        if(fuel > 0) {
            if (fuel > 10000) {
                tooltip.add(Text.literal("§8Fuel: " + "§2" + (fuel / 1000) + "k§8/" + (maxFuel / 1000) + "k"));
            } else {
                tooltip.add(Text.literal("§8Fuel: " + "§2" + fuel + "§8/" + (maxFuel / 1000) + "k"));
            }
        } else {
            tooltip.add(Text.literal("§8Fuel: §cEmpty"));
        }

    }

    private static void getVariables(ItemStack stack, DrillItem item) {
        hasEngine = stack.get(ModDataComponentTypes.ENGINE).getHasEngine();
        hasTank = stack.get(ModDataComponentTypes.TANK).getHasTank();
        hasUpgrade = stack.get(ModDataComponentTypes.UPGRADE).getHasUpgrade();
        hasEnchantments = stack.hasEnchantments();
        engineTier = DrillItem.getEngineTier(stack);
        tankTier = DrillItem.getTankTier(stack);
        upgradeTier = DrillItem.getUpgradeTier(stack);
        fuel = DrillItem.getFuel(stack);
        maxFuel = DrillItem.getMaxFuel(stack);
        name = Text.empty().append(item.getName()).formatted(item.rarity.formatting);

    }

}
