package net.apixelite.subterra.item.custom;

import java.util.List;

import net.apixelite.subterra.item.ModItems;
import net.apixelite.subterra.util.CustomRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

public class FuelTank extends Item {

    private final int fuelCapacity;
    private final CustomRarity rarity;

    public FuelTank(int fuelCapacity, CustomRarity rarity, Settings settings) {
        super(settings);
        this.fuelCapacity = fuelCapacity;
        this.rarity = rarity;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.clear();

        tooltip.add(Text.empty().append(this.getName()).formatted(this.rarity.formatting));
        if (!stack.isOf(ModItems.FUEL_TANK)) {
            tooltip.add(Text.literal("§8Drill Part"));
            tooltip.add(Text.literal(""));
            tooltip.add(Text.literal("§8Part Type: §bFuel Tank"));
            tooltip.add(Text.literal("§8Increases Fuel Capacity To: §c" + (this.fuelCapacity / 1000) + ".000"));
        }

        super.appendTooltip(stack, context, tooltip, type);
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
