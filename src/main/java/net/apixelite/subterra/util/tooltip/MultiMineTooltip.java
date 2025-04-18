package net.apixelite.subterra.util.tooltip;

import net.apixelite.subterra.util.TooltipHelper;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MultiMineTooltip {
    public static void buildTooltip(@NotNull List<Text> tooltip, int level) {
        List<String> tooltipText = new ArrayList<>();

        tooltipText.add("");
        tooltipText.add("§8Part Type: Multi Mine");

        TooltipHelper.add(tooltip, tooltipText);
    }
}
