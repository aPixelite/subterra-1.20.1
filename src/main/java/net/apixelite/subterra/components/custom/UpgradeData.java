package net.apixelite.subterra.components.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.Objects;

public class UpgradeData {
    private final boolean hasUpgrade;
    private final int level;

    public static final Codec<UpgradeData> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    Codec.BOOL.fieldOf("has_upgrade").forGetter(UpgradeData::getHasUpgrade),
                    Codec.INT.fieldOf("level").forGetter(UpgradeData::getLevel)
            ).apply(instance, UpgradeData::new));

    public UpgradeData(boolean hasUpgrade, int level) {
        this.hasUpgrade = hasUpgrade;
        this.level = level;
    }

    public boolean getHasUpgrade() {
        return this.hasUpgrade;
    }

    public int getLevel() {
        return this.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.hasUpgrade, this.level);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else {
            return obj instanceof UpgradeData ud
            && this.hasUpgrade == ud.hasUpgrade
            && this.level == ud.level;
        }
    }
}
