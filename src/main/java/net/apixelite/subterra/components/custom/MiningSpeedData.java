package net.apixelite.subterra.components.custom;

import java.util.Objects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class MiningSpeedData {
    private final int miningSpeed;

    public static final Codec<MiningSpeedData> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            Codec.INT.fieldOf("miningSpeed").forGetter(MiningSpeedData::getMiningSpeed)
        ).apply(instance, MiningSpeedData::new));

    public MiningSpeedData(int miningSpeed) {
        this.miningSpeed = miningSpeed;
    }

    public int getMiningSpeed() {
        return this.miningSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.miningSpeed);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof MiningSpeedData msd
            && this.miningSpeed == msd.miningSpeed;
        }
    }
}
