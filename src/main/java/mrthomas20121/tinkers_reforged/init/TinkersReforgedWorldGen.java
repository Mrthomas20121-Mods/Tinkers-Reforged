package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.ReforgedConfig;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import mrthomas20121.tinkers_reforged.datagen.ReforgedBlocksTags;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.common.registration.ConfiguredFeatureDeferredRegister;
import slimeknights.tconstruct.common.registration.PlacedFeatureDeferredRegister;

import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber(modid = TinkersReforged.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TinkersReforgedWorldGen {

    public static final ConfiguredFeatureDeferredRegister CONFIGURED_FEATURES = new ConfiguredFeatureDeferredRegister(TinkersReforged.MOD_ID);
    public static final PlacedFeatureDeferredRegister PLACED_FEATURES = new PlacedFeatureDeferredRegister(TinkersReforged.MOD_ID);

    public static RegistryObject<ConfiguredFeature<OreConfiguration,Feature<OreConfiguration>>> ALUMINUM_ORE = CONFIGURED_FEATURES.registerSupplier("aluminum_ore", () -> Feature.ORE, () -> new OreConfiguration(List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, TinkersReforgedBlocks.aluminum_ore.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, TinkersReforgedBlocks.deepslate_aluminum_ore.get().defaultBlockState()))
, ReforgedConfig.COMMON.aluminumCount.get()));
    public static RegistryObject<PlacedFeature> placedAluminumOre = PLACED_FEATURES.register("aluminum_ore", ALUMINUM_ORE, CountPlacement.of(6), InSquarePlacement.spread(), PlacementUtils.RANGE_8_8, BiomeFilter.biome());

    public static RegistryObject<ConfiguredFeature<OreConfiguration,Feature<OreConfiguration>>> KEPU_ORE = CONFIGURED_FEATURES.registerSupplier("kepu_ore", () -> Feature.ORE, () -> new OreConfiguration(new BlockMatchTest(Blocks.END_STONE), TinkersReforgedBlocks.kepu_ore.get().defaultBlockState(), ReforgedConfig.COMMON.aluminumCount.get()));
    public static RegistryObject<PlacedFeature> placedKepuOre = PLACED_FEATURES.register("kepu_ore", KEPU_ORE, CountPlacement.of(6), InSquarePlacement.spread(), PlacementUtils.RANGE_8_8, BiomeFilter.biome());

    @SubscribeEvent
    public static void onBiomeLoad(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        Biome.BiomeCategory category = event.getCategory();
        if(category != Biome.BiomeCategory.NONE) {
            if(ReforgedConfig.COMMON.enableAluminumOre.get()) {
                if(category != Biome.BiomeCategory.NETHER && category != Biome.BiomeCategory.THEEND) {
                    placedAluminumOre.getHolder().ifPresent(holder -> generation.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, holder));
                }
            }
            else if(category == Biome.BiomeCategory.THEEND) {
                placedKepuOre.getHolder().ifPresent(holder -> generation.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, holder));
            }
        }
    }
}
