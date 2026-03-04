package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class TinkersReforgedPlacedFeatures {

    public static final ResourceKey<PlacedFeature> YTTRIUM_ORE = createKey("yttrium_ore");
    public static final ResourceKey<PlacedFeature> YTTRIUM_ORE_CONIFEROUS = createKey("yttrium_ore_coniferous");
    public static final ResourceKey<PlacedFeature> BARIUM_ORE = createKey("barium_ore");
    public static final ResourceKey<PlacedFeature> THALLIUM_ORE = createKey("thallium_ore");

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, TinkersReforged.getResource(name));
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> YTTRIUM = holdergetter.getOrThrow(TinkersReforgedConfiguredFeatures.YTTRIUM_ORE);
        Holder<ConfiguredFeature<?, ?>> BARIUM = holdergetter.getOrThrow(TinkersReforgedConfiguredFeatures.BARIUM_ORE);
        Holder<ConfiguredFeature<?, ?>> THALLIUM = holdergetter.getOrThrow(TinkersReforgedConfiguredFeatures.THALLIUM_ORE);

        register(context, YTTRIUM_ORE, YTTRIUM, CountPlacement.of(UniformInt.of(2, 5)), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(20)));
        register(context, YTTRIUM_ORE_CONIFEROUS, YTTRIUM, CountPlacement.of(UniformInt.of(3, 6)), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(40)));
        register(context, BARIUM_ORE, BARIUM, CountPlacement.of(UniformInt.of(3, 4)), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()));
        register(context, THALLIUM_ORE, THALLIUM, CountPlacement.of(UniformInt.of(1, 3)), HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.top()));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }


    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
