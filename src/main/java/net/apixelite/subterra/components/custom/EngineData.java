package net.apixelite.subterra.components.custom;

import java.util.Objects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class EngineData {
    private final boolean hasEngine;
    private final int engineTier;

    public static final Codec<EngineData> CODEC = RecordCodecBuilder.create(instance ->
        instance.group(
            Codec.BOOL.fieldOf("has_engine").forGetter(EngineData::getHasEngine),
            Codec.INT.fieldOf("engine_tier").forGetter(EngineData::getEngineTier)
        ).apply(instance, EngineData::new));

    public EngineData(boolean hasEngine, int engineTier) {
        this.hasEngine = hasEngine;
        this.engineTier = engineTier;
    }

    public boolean getHasEngine() {
        return hasEngine;
    }

    public int getEngineTier() {
        return engineTier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.hasEngine, this.engineTier);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof EngineData ed
            && this.hasEngine == ed.hasEngine
            && this.engineTier == ed.engineTier;
        }
    }

}
