package net.apixelite.subterra.item.custom;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.components.ModDataComponentTypes;
import net.apixelite.subterra.util.CustomRarity;
import net.apixelite.subterra.util.TooltipHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Arrays;

public class DrillEngine extends Item {

    private final CustomRarity rarity;
    private final int level;

    public DrillEngine(int level, CustomRarity rarity, Settings settings) {
        super(settings);
        this.rarity = rarity;
        this.level = level;
    }

    public static int getMiningSpeed(int level) {
        if (level != 0) {
            // 5 + 2.5 * ((x * x - x) + 5)
            return (int) (5 + 2.5 * (level * level - level) + 5);
        } else {
            return 0;
        }
    }
}
