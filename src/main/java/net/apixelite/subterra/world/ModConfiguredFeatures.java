package net.apixelite.subterra.world;

import java.util.List;

import net.apixelite.subterra.Subterra;
import net.apixelite.subterra.block.ModBlocks;
import net.apixelite.subterra.fluid.ModFluids;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDERITE_ORE_KEY = registerKey("enderite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ARAGONITE_ORE_KEY = registerKey("aragonite_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> INFERNITE_ORE_KEY = registerKey("infernite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> OIL_POCKEY_KEY = registerKey("oil_pocket");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> enderiteOres =
                List.of(OreFeatureConfig.createTarget(endReplacables, ModBlocks.ENDERITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> aragoniteOres =
                List.of(OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.ARAGONITE_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> inferniteOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.INFERNITE_ORE.getDefaultState()));

        
        register(context, ENDERITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(enderiteOres, 4 /* Ores Per Vein*/));
        register(context, ARAGONITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(aragoniteOres, 8 /* Ores Per Vein*/));
        register(context, INFERNITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(inferniteOres, 3 /* Ores Per Vein*/));

        register(context, OIL_POCKEY_KEY, Feature.GEODE, new GeodeFeatureConfig(new GeodeLayerConfig(
                BlockStateProvider.of(ModFluids.OIL_BLOCK),
                BlockStateProvider.of(ModFluids.OIL_BLOCK),
                BlockStateProvider.of(ModFluids.OIL_BLOCK),
                BlockStateProvider.of(Blocks.COAL_BLOCK),
                BlockStateProvider.of(Blocks.SMOOTH_BASALT),
                List.of(ModFluids.OIL_BLOCK.getDefaultState()),
                BlockTags.FEATURES_CANNOT_REPLACE , BlockTags.GEODE_INVALID_BLOCKS),

                new GeodeLayerThicknessConfig(1.7, 2.2, 2.5, 3.8),
                new GeodeCrackConfig(0.01, 1, 1),
                0.35,
                0.083,
                true,
                UniformIntProvider.create(4, 6),
                UniformIntProvider.create(3, 4),
                UniformIntProvider.create(1, 2),
                -16,
                16,
                0.05,
                1));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Subterra.MOD_ID, name));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                    RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature(feature, configuration));
    }

}
