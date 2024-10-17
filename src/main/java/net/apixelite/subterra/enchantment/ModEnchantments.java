package net.apixelite.subterra.enchantment;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.apixelite.subterra.util.ModTags;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> LIGHTNING_STRIKER =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Subterra.MOD_ID, "lightning_striker"));
    public static final RegistryKey<Enchantment> FUELLESS =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Subterra.MOD_ID, "fuelless"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);


        register(registerable, LIGHTNING_STRIKER, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        5,
                        2,
                        Enchantment.leveledCost(5, 8),
                        Enchantment.leveledCost(25, 7),
                        2,
                        AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new LightningStrikerEnchantmentEffect(1)));

        register(registerable, FUELLESS, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ModTags.Items.DRILL),
                items.getOrThrow(ModTags.Items.DRILL),
                5,
                3,
                Enchantment.leveledCost(5, 8),
                Enchantment.leveledCost(55, 8),
                2,
                AttributeModifierSlot.MAINHAND))
                /* .addEffect(
                        EnchantmentEffectComponentTypes.ITEM_DAMAGE,
                        new RemoveBinomialEnchantmentEffect(
                                new EnchantmentLevelBasedValue.Fraction(EnchantmentLevelBasedValue.linear(2.0F), EnchantmentLevelBasedValue.linear(10.0F, 5.0F))
                        )
                )
                .addEffect(
                        EnchantmentEffectComponentTypes.ITEM_DAMAGE,
                        new RemoveBinomialEnchantmentEffect(
                                new EnchantmentLevelBasedValue.Fraction(EnchantmentLevelBasedValue.linear(1.0F), EnchantmentLevelBasedValue.linear(2.0F, 1.0F))
                        )
                )
                */
        );
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
