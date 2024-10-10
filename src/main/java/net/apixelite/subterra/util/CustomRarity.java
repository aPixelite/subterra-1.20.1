package net.apixelite.subterra.util;

import net.minecraft.util.Formatting;

public enum CustomRarity {
    COMMON(Formatting.WHITE),
    UNCOMMON(Formatting.GREEN),
    RARE(Formatting.BLUE),
    EPIC(Formatting.DARK_PURPLE),
    LEGENDARY(Formatting.GOLD),
    MYTHIC(Formatting.LIGHT_PURPLE),
    DIVINE(Formatting.AQUA),
    SPECIAL(Formatting.RED),
    VERY_SPECIAL(Formatting.DARK_RED);

    public final Formatting formatting;

    CustomRarity(Formatting formatting) {
        this.formatting = formatting;
    }

}
