package net.apixelite.subterra.enchantment.custom;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.util.ModTags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> FUELLESS =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Subterra.MOD_ID, "fuelless"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, FUELLESS, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ModTags.Items.DRILL),
                items.getOrThrow(ModTags.Items.DRILL),
                5,
                3,
                Enchantment.leveledCost(5, 8),
                Enchantment.leveledCost(55, 8),
                2

        )));
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
