package net.apixelite.subterra.components.custom;

import java.util.Objects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class FuelData {
    private final int fuel;
    private final int maxFuel;

    public static final Codec<FuelData> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            Codec.INT.fieldOf("fuel").forGetter(FuelData::getFuel),
            Codec.INT.fieldOf("max_fuel").forGetter(FuelData::getMaxFuel)
        ).apply(instance, FuelData::new));

    public FuelData(int fuel, int maxFuel) {
        this.fuel = fuel;
        this.maxFuel = maxFuel;
    }

    public int getFuel() {
        return this.fuel;
    }

    public int getMaxFuel() {
        return this.maxFuel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fuel, this.maxFuel);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof FuelData fd
            && this.fuel == fd.fuel
            && this.maxFuel == fd.maxFuel;
        }
    }
}
