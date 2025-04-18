package net.apixelite.subterra.item.custom.upgrademodules;

import net.apixelite.subterra.util.CustomRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class MultiMine extends Item {

    private CustomRarity rarity;
    private int level;

    public MultiMine(int level, CustomRarity rarity, Settings settings) {
        super(settings);
        this.rarity = rarity;
        this.level = level;
    }

    // TODO: Render the tooltip
//    @Override
//    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
//        tooltip.clear();
//
//        tooltip.add(Text.empty().append(this.getName()).formatted(this.rarity.formatting));
//        tooltip.add(Text.literal("§8Drill Part"));
//        tooltip.add(Text.literal(""));
//        tooltip.add(Text.literal("§8Part Type: §6Multi Mine"));
//        tooltip.add(Text.literal("§8Allows you to mine in a " + getArea(level) + " area"));
//
//        super.appendTooltip(stack, context, tooltip, type);
//    }

    public static String getArea(int level) {
        String area;
        int size = 1 + 2 * level;

        area = size + "x" + size;

        return area;
    }
}
