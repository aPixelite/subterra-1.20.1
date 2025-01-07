package net.apixelite.subterra.components;

import java.util.function.UnaryOperator;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.components.custom.*;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModDataComponentTypes {
    public static final ComponentType<EngineData> ENGINE = register("engine", builder -> builder.codec(EngineData.CODEC));
    public static final ComponentType<TankData> TANK = register("tank", builder -> builder.codec(TankData.CODEC));
    public static final ComponentType<UpgradeData> UPGRADE = register("upgrade", builder -> builder.codec(UpgradeData.CODEC));
    public static final ComponentType<FuelData> FUEL = register("fuel", builder -> builder.codec(FuelData.CODEC));
    public static final ComponentType<MiningSpeedData> MINING_SPEED = register("mining_speed", builder -> builder.codec(MiningSpeedData.CODEC));

    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Subterra.MOD_ID, name),
            (builderOperator.apply(ComponentType.builder())).build());
    }

    public static void registerDataComponentTypes() {
        Subterra.LOGGER.info("Registering Data Component Types for " + Subterra.MOD_ID);
    }
}
