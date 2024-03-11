package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.api.material.EnumGem;
import mrthomas20121.tinkers_reforged.api.material.EnumMetal;
import mrthomas20121.tinkers_reforged.api.material.ReforgedData;
import mrthomas20121.tinkers_reforged.block.OverworldOreBlock;
import mrthomas20121.tinkers_reforged.util.Helpers;
import net.minecraft.data.worldgen.features.OreFeatures;
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

@Mod.EventBusSubscriber(modid = TinkersReforged.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TinkersReforgedWorldGen {

    public static Function<EnumMetal, List<OreConfiguration.TargetBlockState>> metalReplace = (metal) -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TinkersReforgedBlocks.ORES.get(metal).ore().get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ((OverworldOreBlock)TinkersReforgedBlocks.ORES.get(metal)).deepslateOre().get().defaultBlockState()));
    public static Function<EnumGem, List<OreConfiguration.TargetBlockState>> gemReplace = (gem) -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TinkersReforgedBlocks.GEM_ORES.get(gem).ore().get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TinkersReforgedBlocks.GEM_ORES.get(gem).deepslateOre().get().defaultBlockState()));
    public static final ConfiguredFeatureDeferredRegister CONFIGURED_FEATURES = new ConfiguredFeatureDeferredRegister(TinkersReforged.MOD_ID);
    public static final PlacedFeatureDeferredRegister PLACED_FEATURES = new PlacedFeatureDeferredRegister(TinkersReforged.MOD_ID);

    public static Map<EnumMetal, RegistryObject<ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>>> METAL_CONFIGURED_ORES = Helpers.mapOfKeys(EnumMetal.class, EnumMetal::isThisOre, metal -> {
        if(metal.equals(EnumMetal.KEPU) || metal.equals(EnumMetal.TITANIUM)) {
            return CONFIGURED_FEATURES.registerSupplier(metal.getName()+"_ore", () -> Feature.ORE, () -> new OreConfiguration(new TagMatchTest(Tags.Blocks.END_STONES), TinkersReforgedBlocks.ORES.get(metal).ore().get().defaultBlockState(), ReforgedData.oreData.get(metal).size()));
        }
        else {
            return CONFIGURED_FEATURES.registerSupplier(metal.getName()+"_ore", () -> Feature.ORE, () -> new OreConfiguration(metalReplace.apply(metal), ReforgedData.oreData.get(metal).size()));
        }
    });
    public static Map<EnumGem, RegistryObject<ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>>> GEM_CONFIGURED_ORES = Helpers.mapOfKeys(EnumGem.class, gem -> CONFIGURED_FEATURES.registerSupplier(gem.getName()+"_ore", () -> Feature.ORE, () -> new OreConfiguration(gemReplace.apply(gem), ReforgedData.oreData.get(gem).size())));

    public static Map<EnumMetal, RegistryObject<PlacedFeature>> PLACED_METAL_ORES = Helpers.mapOfKeys(EnumMetal.class, EnumMetal::isThisOre, metal -> PLACED_FEATURES.register(metal.getName()+"_ore_placement", METAL_CONFIGURED_ORES.get(metal), CountPlacement.of(ReforgedData.oreData.get(metal).count()), InSquarePlacement.spread(), BiomeFilter.biome(), HeightRangePlacement.uniform(VerticalAnchor.absolute(ReforgedData.oreData.get(metal).minY()), VerticalAnchor.absolute(ReforgedData.oreData.get(metal).maxY()))));
    public static Map<EnumGem, RegistryObject<PlacedFeature>> PLACED_GEM_ORES = Helpers.mapOfKeys(EnumGem.class, gem -> PLACED_FEATURES.register(gem.getName()+"_ore_placement", GEM_CONFIGURED_ORES.get(gem), CountPlacement.of(ReforgedData.oreData.get(gem).count()), InSquarePlacement.spread(), BiomeFilter.biome(), HeightRangePlacement.uniform(VerticalAnchor.absolute(ReforgedData.oreData.get(gem).minY()), VerticalAnchor.absolute(ReforgedData.oreData.get(gem).maxY()))));

    @SubscribeEvent
    public static void onBiomeLoad(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        Biome.BiomeCategory category = event.getCategory();
        for(EnumMetal metal: EnumMetal.values()) {
            if(metal.isThisOverworldOre() && isOverworldBiome(category)) {
                PLACED_METAL_ORES.get(metal).getHolder().ifPresent(holder -> generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, holder));
            }
            else if(metal.isThisOtherOre() && isEndBiome(category)) {
                PLACED_METAL_ORES.get(metal).getHolder().ifPresent(holder -> generation.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, holder));
            }
        }
        for(EnumGem gem: EnumGem.values()) {
            if(isOverworldBiome(category)) {
                PLACED_GEM_ORES.get(gem).getHolder();
            }
        }
    }

    public static boolean isOverworldBiome(Biome.BiomeCategory category) {

        return category != Biome.BiomeCategory.NONE && category != Biome.BiomeCategory.THEEND && category != Biome.BiomeCategory.NETHER;
    }

//    public static boolean isNetherBiome(Biome.BiomeCategory category) {
//
//        return category == Biome.BiomeCategory.NETHER;
//    }

    public static boolean isEndBiome(Biome.BiomeCategory category) {

        return category == Biome.BiomeCategory.THEEND;
    }
}
