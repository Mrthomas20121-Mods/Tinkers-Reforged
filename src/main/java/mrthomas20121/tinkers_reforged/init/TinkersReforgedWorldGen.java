package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforgedConfig;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import mrthomas20121.tinkers_reforged.util.Helpers;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.common.registration.ConfiguredFeatureDeferredRegister;
import slimeknights.tconstruct.common.registration.PlacedFeatureDeferredRegister;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = TinkersReforged.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TinkersReforgedWorldGen {

    public static Function<EnumMetal, List<OreConfiguration.TargetBlockState>> metalReplace = (metal) -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TinkersReforgedBlocks.ORES.get(metal).ore().get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TinkersReforgedBlocks.ORES.get(metal).deepslateOre().get().defaultBlockState()));
    public static Function<EnumGem, List<OreConfiguration.TargetBlockState>> gemReplace = (gem) -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TinkersReforgedBlocks.GEM_ORES.get(gem).ore().get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TinkersReforgedBlocks.GEM_ORES.get(gem).deepslateOre().get().defaultBlockState()));
    public static Supplier<List<OreConfiguration.TargetBlockState>> redBerylReplace = () -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TinkersReforgedBlocks.red_beryl_ore.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TinkersReforgedBlocks.deepslate_red_beryl_ore.get().defaultBlockState()));
    public static final ConfiguredFeatureDeferredRegister CONFIGURED_FEATURES = new ConfiguredFeatureDeferredRegister(TinkersReforged.MOD_ID);
    public static final PlacedFeatureDeferredRegister PLACED_FEATURES = new PlacedFeatureDeferredRegister(TinkersReforged.MOD_ID);

    public static Map<EnumMetal, RegistryObject<ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>>> METAL_CONFIGURED_ORES = Helpers.mapOfKeys(EnumMetal.class, EnumMetal::isThisOre, metal -> {
        if(metal.equals(EnumMetal.KEPU) || metal.equals(EnumMetal.TITANIUM)) {
            return CONFIGURED_FEATURES.registerSupplier(metal.getName()+"_ore", () -> Feature.ORE, () -> new OreConfiguration(new TagMatchTest(Tags.Blocks.END_STONES), TinkersReforgedBlocks.ORES.get(metal).ore().get().defaultBlockState(), TinkersReforgedConfig.COMMON.ores.get(metal.getName()).getSize()));
        }
        else {
            return CONFIGURED_FEATURES.registerSupplier(metal.getName()+"_ore", () -> Feature.ORE, () -> new OreConfiguration(metalReplace.apply(metal), TinkersReforgedConfig.COMMON.ores.get(metal.getName()).getSize()));
        }
    });
    public static Map<EnumGem, RegistryObject<ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>>> GEM_CONFIGURED_ORES = Helpers.mapOfKeys(EnumGem.class, gem -> CONFIGURED_FEATURES.registerSupplier(gem.getName()+"_ore", () -> Feature.ORE, () -> new OreConfiguration(gemReplace.apply(gem), TinkersReforgedConfig.COMMON.ores.get(gem.getName()).getSize())));

    public static Map<EnumMetal, RegistryObject<PlacedFeature>> PLACED_METAL_ORES = Helpers.mapOfKeys(EnumMetal.class, EnumMetal::isThisOre, metal -> PLACED_FEATURES.register("aluminum_ore", METAL_CONFIGURED_ORES.get(metal), CountPlacement.of(TinkersReforgedConfig.COMMON.ores.get(metal.getName()).getCount()), InSquarePlacement.spread(), BiomeFilter.biome(), HeightRangePlacement.uniform(VerticalAnchor.absolute(TinkersReforgedConfig.COMMON.ores.get(metal.getName()).getMinY()), VerticalAnchor.absolute(TinkersReforgedConfig.COMMON.ores.get(metal.getName()).getMaxY()))));

    //public static RegistryObject<PlacedFeature> placedKepuOre = PLACED_FEATURES.register("kepu_ore", KEPU_ORE, CountPlacement.of(TinkersReforgedConfig.COMMON.kepuOre.getCount()), InSquarePlacement.spread(), BiomeFilter.biome(), HeightRangePlacement.uniform(VerticalAnchor.absolute(TinkersReforgedConfig.COMMON.kepuOre.getMinY()), VerticalAnchor.absolute(TinkersReforgedConfig.COMMON.kepuOre.getMaxY())));

    public static RegistryObject<ConfiguredFeature<OreConfiguration,Feature<OreConfiguration>>> EPIDOTE_ORE = CONFIGURED_FEATURES.registerSupplier("epidote_ore", () -> Feature.ORE, () -> new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TinkersReforgedBlocks.deepslate_epidote_ore.get().defaultBlockState(), TinkersReforgedConfig.COMMON.epidoteOre.getSize()));
    public static RegistryObject<PlacedFeature> placedEpidoteOre = PLACED_FEATURES.register("epidote_ore", EPIDOTE_ORE, CountPlacement.of(TinkersReforgedConfig.COMMON.epidoteOre.getCount()), InSquarePlacement.spread(), BiomeFilter.biome(), HeightRangePlacement.uniform(VerticalAnchor.absolute(TinkersReforgedConfig.COMMON.epidoteOre.getMinY()), VerticalAnchor.absolute(TinkersReforgedConfig.COMMON.epidoteOre.getMaxY())));

    public static RegistryObject<ConfiguredFeature<OreConfiguration,Feature<OreConfiguration>>> HUREAULITE_ORE = CONFIGURED_FEATURES.registerSupplier("hureaulite_ore", () -> Feature.ORE, () -> new OreConfiguration(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TinkersReforgedBlocks.deepslate_hureaulite_ore.get().defaultBlockState(), TinkersReforgedConfig.COMMON.hureauliteOre.getSize()));
    public static RegistryObject<PlacedFeature> placedHureauliteOre = PLACED_FEATURES.register("hureaulite_ore", HUREAULITE_ORE, CountPlacement.of(TinkersReforgedConfig.COMMON.hureauliteOre.getCount()), InSquarePlacement.spread(), BiomeFilter.biome(), HeightRangePlacement.uniform(VerticalAnchor.absolute(TinkersReforgedConfig.COMMON.hureauliteOre.getMinY()), VerticalAnchor.absolute(TinkersReforgedConfig.COMMON.hureauliteOre.getMaxY())));

    public static RegistryObject<ConfiguredFeature<OreConfiguration,Feature<OreConfiguration>>> RED_BERYL_ORE = CONFIGURED_FEATURES.registerSupplier("red_beryl_ore", () -> Feature.ORE, () -> new OreConfiguration(redBerylReplace.get(), TinkersReforgedConfig.COMMON.redBerylOre.getSize()));
    public static RegistryObject<PlacedFeature> placedRedBerylOre = PLACED_FEATURES.register("red_beryl_ore", RED_BERYL_ORE, CountPlacement.of(TinkersReforgedConfig.COMMON.redBerylOre.getCount()), InSquarePlacement.spread(), BiomeFilter.biome(), HeightRangePlacement.uniform(VerticalAnchor.absolute(TinkersReforgedConfig.COMMON.redBerylOre.getMinY()), VerticalAnchor.absolute(TinkersReforgedConfig.COMMON.redBerylOre.getMaxY())));

    @SubscribeEvent
    public static void onBiomeLoad(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        Biome.BiomeCategory category = event.getCategory();
        if(isOverworldBiome(category)) {
            if(TinkersReforgedConfig.COMMON.bauxiteOre.isEnabled()) {
                placedAluminumOre.getHolder().ifPresent(holder -> generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, holder));
            }
            if(TinkersReforgedConfig.COMMON.epidoteOre.isEnabled()) {
                placedEpidoteOre.getHolder().ifPresent(holder -> generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, holder));
            }
            if(TinkersReforgedConfig.COMMON.hureauliteOre.isEnabled()) {
                placedHureauliteOre.getHolder().ifPresent(holder -> generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, holder));
            }
            if(TinkersReforgedConfig.COMMON.redBerylOre.isEnabled()) {
                placedRedBerylOre.getHolder().ifPresent(holder -> generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, holder));
            }
        }
        if(isEndBiome(category)) {
            if(TinkersReforgedConfig.COMMON.kepuOre.isEnabled()) {
                placedKepuOre.getHolder().ifPresent(holder -> generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, holder));
            }
        }
    }

    public static boolean isOverworldBiome(Biome.BiomeCategory category) {

        return category != Biome.BiomeCategory.NONE && category != Biome.BiomeCategory.THEEND && category != Biome.BiomeCategory.NETHER;
    }

    public static boolean isNetherBiome(Biome.BiomeCategory category) {

        return category == Biome.BiomeCategory.NETHER;
    }

    public static boolean isEndBiome(Biome.BiomeCategory category) {

        return category == Biome.BiomeCategory.THEEND;
    }
}
