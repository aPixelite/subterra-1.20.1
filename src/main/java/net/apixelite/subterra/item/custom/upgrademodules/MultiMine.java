package net.apixelite.subterra.item.custom.upgrademodules;

import net.apixelite.subterra.util.CustomRarity;
import net.minecraft.item.Item;

public class MultiMine extends Item {

    private CustomRarity rarity;
    private int level;

    public MultiMine(int level, CustomRarity rarity, Settings settings) {
        super(settings);
        this.rarity = rarity;
        this.level = level;
    }

    public static String getArea(int level) {
        String area;
        int size = 1 + 2 * level;

        area = size + "x" + size;

        return area;
    }
}
