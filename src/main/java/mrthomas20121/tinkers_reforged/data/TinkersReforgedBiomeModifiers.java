package mrthomas20121.tinkers_reforged.data;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class TinkersReforgedBiomeModifiers {

    public static ResourceKey<BiomeModifier> YTTRIUM_ORE_CONIFEROUS = createKey("yttrium_ore_coniferous");
    public static ResourceKey<BiomeModifier> YTTRIUM_ORE = createKey("yttrium_ore");
    public static ResourceKey<BiomeModifier> BARIUM_ORE = createKey("barium_ore");
    public static ResourceKey<BiomeModifier> THALLIUM_ORE = createKey("thallium_ore");

    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, TinkersReforged.getResource(name));
    }

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<Biome> biomeLookup = context.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatureLookup = context.lookup(Registries.PLACED_FEATURE);

        register(context, YTTRIUM_ORE_CONIFEROUS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeLookup.getOrThrow(Tags.Biomes.IS_CONIFEROUS),
                HolderSet.direct(placedFeatureLookup.getOrThrow(TinkersReforgedPlacedFeatures.YTTRIUM_ORE_CONIFEROUS)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        register(context, YTTRIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeLookup.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatureLookup.getOrThrow(TinkersReforgedPlacedFeatures.YTTRIUM_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        register(context, BARIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeLookup.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatureLookup.getOrThrow(TinkersReforgedPlacedFeatures.BARIUM_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));

        register(context, THALLIUM_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeLookup.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatureLookup.getOrThrow(TinkersReforgedPlacedFeatures.THALLIUM_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static <T extends BiomeModifier> void register(BootstapContext<BiomeModifier> context, ResourceKey<BiomeModifier> key, T modifier) {
        context.register(key, modifier);
    }
}
