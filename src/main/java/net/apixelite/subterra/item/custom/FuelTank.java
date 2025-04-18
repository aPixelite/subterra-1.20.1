package net.apixelite.subterra.item.custom;

import net.apixelite.subterra.util.CustomRarity;
import net.minecraft.item.Item;

public class FuelTank extends Item {

    private final int fuelCapacity;
    private final CustomRarity rarity;

    public FuelTank(int fuelCapacity, CustomRarity rarity, Settings settings) {
        super(settings);
        this.fuelCapacity = fuelCapacity;
        this.rarity = rarity;
    }

    public static int getFuel(int level) {
        if (level >= 2) {
            // 10000 * 2,5 * 2^(x-2)
            return (int) (10000 * (2.5 * Math.pow(2, (level - 2))));
        } else {
            return 7000 * level + 3000;
        }
    }
}
