package net.apixelite.subterra.item.custom;

import java.util.List;

import net.apixelite.subterra.item.ModItems;
import net.apixelite.subterra.util.CustomRarity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class FuelTank extends Item {

    private int fuelCapacity;
    private CustomRarity rarity;

    public FuelTank(int fuelCapacity, CustomRarity rarity, Settings settings) {
        super(settings);
        this.fuelCapacity = fuelCapacity;
        this.rarity = rarity;
    }

    public int getFuelCapacity(ItemStack stack) {
        return this.fuelCapacity;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.clear();

        tooltip.add(Text.empty().append(this.getName()).formatted(this.rarity.formatting));
        if (!stack.isOf(ModItems.FUEL_TANK)) {
            tooltip.add(Text.literal("§8Drill Part"));
            tooltip.add(Text.literal(""));
            tooltip.add(Text.literal("§7Part Type: §6Fuel Tank"));
            tooltip.add(Text.literal("§7Increases Fuel Capacity To: §2" + (this.fuelCapacity / 1000) + ".000"));
            tooltip.add(Text.literal(""));
        }
        tooltip.add(Text.literal("§l" + this.rarity).formatted(this.rarity.formatting));

        super.appendTooltip(stack, world, tooltip, context);
    }

    public static int getFuel(int level) {
        if (level >= 2) {
            // 10000 * 2,5 * 2^(x-2)
            return (int) (10000 * (2.5 * Math.pow(2, (level - 2))));
        } else {
            return (int) 10000 * level;
        }
    }
}
