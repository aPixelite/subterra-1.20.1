package net.apixelite.subterra.item.custom;

import net.apixelite.subterra.util.CustomRarity;
import net.minecraft.item.Item;

public class UpgradeModule extends Item {

    private int id;

    public UpgradeModule(int id, Settings settings) {
        super(settings);
        this.id = id;
    }
}
