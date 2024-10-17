package net.apixelite.subterra.enchantment;

import com.mojang.serialization.MapCodec;
import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.enchantment.custom.FuellessEnchantmentEffect;
import net.apixelite.subterra.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.enchantment.effect.EnchantmentValueEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER =
            registerEntityEffect("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);
    public static final MapCodec<? extends EnchantmentValueEffect> FUELLESS =
            registerValueEffect("fuelless", FuellessEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentValueEffect> registerValueEffect(String name,
                                                                                    MapCodec<? extends EnchantmentValueEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_VALUE_EFFECT_TYPE, Identifier.of(Subterra.MOD_ID, name), codec);
    }
    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Subterra.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        Subterra.LOGGER.info("Registering Mod Enchantment Effects for " + Subterra.MOD_ID);
    }
}
