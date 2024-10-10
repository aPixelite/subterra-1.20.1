package net.apixelite.subterra.util.tooltip;

import net.apixelite.subterra.components.ModDataComponentTypes;
import net.apixelite.subterra.item.custom.DrillItem;
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
    private static int fuel;
    private static int maxFuel;
    private static String upgrade;
    private static MutableText name;



    public static void setTooltip(DrillItem item, ItemStack stack, List<Text> tooltip) {
        getVariables(stack, item);

        // Item name
        tooltip.add(name);
        tooltip.add(Text.literal(""));


        // Item Enchants
        if(hasEnchantments) {
            tooltip.add(Text.literal(""));

            tooltip.add(Text.literal("§8Enchantments:"));
            tooltip.add((Text) stack.get(DataComponentTypes.ENCHANTMENTS));
        }

        // Drill parts
        // Fuel tank
        if (hasTank) {
            tooltip.add(Text.literal("§3Fuel Tank Tier " + tankTier));
        } else {
            tooltip.add(Text.literal("§8Fuel Tank: §cNot Installed"));
        }

        // Drill Engine
        if (hasEngine) {
            tooltip.add(Text.literal("§3Drill Engine Tier " + engineTier));
        } else {
            tooltip.add(Text.literal("§8Drill Engine: §cNot Installed"));
        }

        // Upgrade Module
        if (hasUpgrade) {
            tooltip.add(Text.literal("§3" + upgrade));
        } else {
            tooltip.add(Text.literal("§8Upgrade Module: §cNot Installed"));
        }
        tooltip.add(Text.literal(""));


        // Tool ability
        tooltip.add(Text.literal("§7Item Ability: §bMining Speed Boost"));
        tooltip.add(Text.literal("§7Usage: §e§lRIGHT CLICK"));
        tooltip.add(Text.literal("§7Grants §c300% §bMining Speed"));
        tooltip.add(Text.literal("§8Duration: §c20s"));
        tooltip.add(Text.literal("§8Cooldown: §c120s"));

        tooltip.add(Text.literal(""));

        // Fuel
        if(fuel > 0) {
            if (fuel > 10000) {
                tooltip.add(Text.literal("§8Fuel: " + "§3" + (fuel / 1000) + "k§8/" + (maxFuel / 1000) + "k"));
            } else {
                tooltip.add(Text.literal("§8Fuel: " + "§3" + fuel + "§8/" + (maxFuel / 1000) + "k"));
            }
        } else {
            tooltip.add(Text.literal("§8Fuel: §cEmpty"));
        }

    }

    private static void getVariables(ItemStack stack, DrillItem item) {
        hasEngine = stack.get(ModDataComponentTypes.ENGINE).getHasEngine();
        hasTank = stack.get(ModDataComponentTypes.TANK).getHasTank();
        hasEnchantments = stack.hasEnchantments();
        hasUpgrade = DrillItem.hasUpgrade;
        engineTier = DrillItem.getEngineTier(stack);
        tankTier = DrillItem.getTankTier(stack);
        fuel = DrillItem.getFuel(stack);
        maxFuel = DrillItem.getMaxFuel(stack);
        upgrade = DrillItem.upgrade;
        name = Text.empty().append(item.getName()).formatted(item.rarity.formatting);

    }

}
