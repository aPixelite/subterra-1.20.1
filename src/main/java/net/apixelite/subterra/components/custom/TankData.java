package net.apixelite.subterra.components.custom;

import java.util.Objects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class TankData {
    private final boolean hasTank;
    private final int tankTier;

    public static final Codec<TankData> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            Codec.BOOL.fieldOf("has_tank").forGetter(TankData::getHasTank),
            Codec.INT.fieldOf("tank_tier").forGetter(TankData::getTankTier)
        ).apply(instance, TankData::new));

    public TankData(boolean hasTank, int tankTier) {
        this.hasTank = hasTank;
        this.tankTier = tankTier;
    }

    public boolean getHasTank() {
        return this.hasTank;
    }

    public int getTankTier() {
        return this.tankTier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.hasTank, this.tankTier);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof TankData td
            && this.hasTank == td.hasTank
            && this.tankTier == td.tankTier;
        }
    }

}
