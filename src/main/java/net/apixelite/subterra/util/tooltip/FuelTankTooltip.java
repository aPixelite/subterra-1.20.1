package net.apixelite.subterra.util.tooltip;

import net.apixelite.subterra.item.custom.FuelTank;
import net.apixelite.subterra.util.TooltipHelper;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FuelTankTooltip {
    public static void buildTooltip(@NotNull List<Text> tooltip, int level) {
        List<String> tooltipText = new ArrayList<>();

        tooltipText.add("");
        tooltipText.add("§8Part Type: Fuel Tank");

        TooltipHelper.add(tooltip, tooltipText);
    }

}
