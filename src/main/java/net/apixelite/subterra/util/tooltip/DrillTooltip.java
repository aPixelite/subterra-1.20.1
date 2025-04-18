package net.apixelite.subterra.util.tooltip;

import net.apixelite.subterra.components.ModDataComponentTypes;
import net.apixelite.subterra.item.custom.DrillEngine;
import net.apixelite.subterra.item.custom.DrillItem;
import net.apixelite.subterra.item.custom.FuelTank;
import net.apixelite.subterra.item.custom.upgrademodules.MultiMine;
import net.apixelite.subterra.util.TooltipHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class DrillTooltip {

    private static boolean hasEngine;
    private static boolean hasTank;
    private static boolean hasUpgrade;
    private static int engineTier;
    private static int tankTier;
    private static int upgradeTier;
    private static int fuel;
    private static int maxFuel;

    private static String engineEmoji = "§8[⛏]";
    private static String tankEmoji = "§8[⏳]";
    private static String upgradeEmoji = "§8[⬆]";


    public static void buildToolTip(@NotNull ItemStack stack, @NotNull List<Text> tooltip) {
        List<String> tooltipText = new ArrayList<>();
        getVariables(stack);

        getEmojis();

        tooltipText.add(tankEmoji + " " + engineEmoji + " " + upgradeEmoji);
        tooltipText.add("");

        // Drill parts
        // Fuel tank

        if (hasTank) {
            tooltipText.add("§aFuel Tank Tier " + tankTier);
            tooltipText.add("§7Increase your fuel capacity");
            tooltipText.add("§7to: §2" + FuelTank.getFuel(tankTier));
        } else {
            tooltipText.add("§7Fuel Tank: §cNot Installed");
            tooltipText.add("§7Increase your fuel capacity");
            tooltipText.add("§7with tank installed");
        }

        tooltipText.add("");

        // Drill Engine
        if (hasEngine) {
            tooltipText.add("§aDrill Engine Tier " + engineTier);
            tooltipText.add("§7Grants an extra ");
            tooltipText.add("§6" + DrillEngine.getMiningSpeed(engineTier) + " Mining Speed");
        } else {
            tooltipText.add("§7Drill Engine: §cNot Installed");
            tooltipText.add("§7Increase your mining speed");
            tooltipText.add("§7with engine installed.");
        }

        tooltipText.add("");

        // Upgrade Module
        if (hasUpgrade) {
            tooltipText.add("§aMulti Mine Tier " + upgradeTier);
            tooltipText.add("§7Allows you to mine a bigger area");
            tooltipText.add("§7Mine a §6" + MultiMine.getArea(upgradeTier) + "§7 area");
        } else {
            tooltipText.add("§7Upgrade Module: §cNot Installed");
            tooltipText.add("§7Upgrade your drill with");
            tooltipText.add("§7special upgrades");
        }
        tooltipText.add("");

        // Tool ability
        tooltipText.add("§7Item Ability: §6Mining Speed Boost");
        tooltipText.add("§7Usage: §e§lRIGHT CLICK");
        tooltipText.add("§7Grants §c300% §6Mining Speed");
        tooltipText.add("§8Duration: §c20s");
        tooltipText.add("§8Cooldown: §c120s");

        tooltipText.add("");

        // Fuel
        if(fuel > 0) {
            if (fuel > 10000) {
                tooltipText.add("§8Fuel: " + "§2" + (fuel / 1000) + "k§8/" + (maxFuel / 1000) + "k");
            } else {
                tooltipText.add("§8Fuel: " + "§2" + fuel + "§8/" + (maxFuel / 1000) + "k");
            }
        } else {
            tooltipText.add("§8Fuel: §cEmpty");
        }

        TooltipHelper.add(tooltip, tooltipText);
    }

    private static void getVariables(ItemStack stack) {
        hasEngine = stack.get(ModDataComponentTypes.ENGINE).getHasEngine();
        hasTank = stack.get(ModDataComponentTypes.TANK).getHasTank();
        hasUpgrade = stack.get(ModDataComponentTypes.UPGRADE).getHasUpgrade();
        engineTier = DrillItem.getEngineTier(stack);
        tankTier = DrillItem.getTankTier(stack);
        upgradeTier = DrillItem.getUpgradeTier(stack);
        fuel = DrillItem.getFuel(stack);
        maxFuel = DrillItem.getMaxFuel(stack);

    }

    private static void getEmojis() {
        engineEmoji = "§8[⛏]";
        tankEmoji = "§8[⏳]";
        upgradeEmoji = "§8[⬆]";

        if (hasEngine) {
            engineEmoji = "§6[⛏]";
        }
        if (hasTank) {
            tankEmoji = "§2[⏳]";
        }
        if (hasUpgrade) {
            upgradeEmoji = "§d[⬆]";
        }

    }

}
