package net.apixelite.subterra.world;

import java.util.List;

import net.apixelite.subterra.Subterra;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

public class ModPlacedFeatures {
    
    public static final RegistryKey<PlacedFeature> ENDERITE_ORE_PLACED_KEY = registerKey("enderite_ore_placed");
    public static final RegistryKey<PlacedFeature> ARAGONITE_ORE_PLACED_KEY = registerKey("aragonite_ore_placed");
    public static final RegistryKey<PlacedFeature> INFERNITE_ORE_PLACED_KEY = registerKey("infernite_ore_placed");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, ENDERITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDERITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // Veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(80))));
        register(context, ARAGONITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ARAGONITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // Veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(-32))));
        register(context, INFERNITE_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.INFERNITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(3, // Veins per chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(96), YOffset.fixed(125))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Subterra.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
