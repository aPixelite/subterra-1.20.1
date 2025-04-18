package net.apixelite.subterra.util;

import net.apixelite.subterra.item.ModItems;
import net.apixelite.subterra.util.tooltip.DrillEngineTooltip;
import net.apixelite.subterra.util.tooltip.DrillTooltip;
import net.apixelite.subterra.util.tooltip.FuelTankTooltip;
import net.apixelite.subterra.util.tooltip.MultiMineTooltip;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Environment(EnvType.CLIENT)
public class TooltipHelper {

    public static void appendTooltip(@NotNull ItemStack stack, @NotNull List<Text> tooltip) {
        if (stack.isIn(ModTags.Items.DRILL_ENGINE) && !stack.isOf(ModItems.DRILL_ENGINE)) {
            DrillEngineTooltip.buildTooltip(tooltip, getLevel(stack));
        }
        else if (stack.isIn(ModTags.Items.FUEL_TANK) && !stack.isOf(ModItems.FUEL_TANK)) {
            FuelTankTooltip.buildTooltip(tooltip, getLevel(stack));
        }
        else if (stack.isIn(ModTags.Items.MULTI_MINE)) {
            MultiMineTooltip.buildTooltip(tooltip, getLevel(stack));
        }
        else if (stack.isIn(ModTags.Items.DRILL)) {
            DrillTooltip.buildToolTip(stack, tooltip);
        }
    }

    public static int getLevel(ItemStack stack) {
        return Integer.parseInt(stack.getName().getString().split(" ")[3]);
    }

    public static void add(List<Text> tooltip, List<String> text) {
        for (int i = 1; i < text.size() + 1; i += 1) {
            tooltip.add(i, Text.literal(text.get(i - 1)));
        }
    }

}
