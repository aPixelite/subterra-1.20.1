package net.apixelite.subterra.enchantment.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentValueEffect;
import net.minecraft.util.math.random.Random;

public record FuellessEnchantmentEffect(EnchantmentLevelBasedValue chance) implements EnchantmentValueEffect {
    public static final MapCodec<FuellessEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(instance -> instance
            .group(EnchantmentLevelBasedValue.CODEC.fieldOf("chance").forGetter(FuellessEnchantmentEffect::chance))
            .apply(instance, FuellessEnchantmentEffect::new));


    @Override
    public float apply(int level, Random random, float inputValue) {
        return inputValue;
    }

    @Override
    public MapCodec<? extends EnchantmentValueEffect> getCodec() {
        return CODEC;
    }

    @Override
    public EnchantmentLevelBasedValue chance() {
        return this.chance;
    }
}
