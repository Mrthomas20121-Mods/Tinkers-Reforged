package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.data.Metal;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

import java.util.List;

public class TinkersReforgedConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> YTTRIUM_ORE = createKey("yttrium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BARIUM_ORE = createKey("barium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> THALLIUM_ORE = createKey("thallium_ore");

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, TinkersReforged.getResource(name));
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        register(context, YTTRIUM_ORE, Feature.ORE, new OreConfiguration(yttriumOreConfig(), 15));
        register(context, BARIUM_ORE, Feature.ORE, new OreConfiguration(
                new BlockMatchTest(Blocks.NETHERRACK), TinkersReforgedBlocks.BARIUM_ORE.get().defaultBlockState(), 11));
        register(context, THALLIUM_ORE, Feature.ORE,
                new OreConfiguration(new BlockMatchTest(Blocks.END_STONE), TinkersReforgedBlocks.THALLIUM_ORE.get().defaultBlockState(), 9));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static List<OreConfiguration.TargetBlockState> yttriumOreConfig() {
        return List.of(OreConfiguration.target(new BlockMatchTest(Blocks.STONE), TinkersReforgedBlocks.YTTRIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(new BlockMatchTest(Blocks.DEEPSLATE), TinkersReforgedBlocks.YTTRIUM_ORE.getDeepslateOre().defaultBlockState()));
    }
}
