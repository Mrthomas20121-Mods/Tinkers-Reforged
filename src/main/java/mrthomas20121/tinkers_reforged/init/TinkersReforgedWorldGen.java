package mrthomas20121.tinkers_reforged.init;

import mrthomas20121.tinkers_reforged.ReforgedConfig;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.common.registration.ConfiguredFeatureDeferredRegister;
import slimeknights.tconstruct.common.registration.PlacedFeatureDeferredRegister;

@Mod.EventBusSubscriber(modid = TinkersReforged.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TinkersReforgedWorldGen {

    public static final ConfiguredFeatureDeferredRegister CONFIGURED_FEATURES = new ConfiguredFeatureDeferredRegister(TinkersReforged.MOD_ID);
    public static final PlacedFeatureDeferredRegister PLACED_FEATURES = new PlacedFeatureDeferredRegister(TinkersReforged.MOD_ID);

    public static RegistryObject<ConfiguredFeature<OreConfiguration,Feature<OreConfiguration>>> ALUMINUM_ORE = CONFIGURED_FEATURES.registerSupplier("aluminum_ore", () -> Feature.ORE, () -> new OreConfiguration(OreFeatures.NATURAL_STONE, TinkersReforgedBlocks.aluminum_ore.get().defaultBlockState(), ReforgedConfig.COMMON.aluminumCount.get()));
    public static RegistryObject<PlacedFeature> placedAluminumOre = PLACED_FEATURES.register("aluminum_ore", ALUMINUM_ORE, CountPlacement.of(6), InSquarePlacement.spread(), PlacementUtils.RANGE_8_8, BiomeFilter.biome());

    @SubscribeEvent
    public static void onBiomeLoad(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        Biome.BiomeCategory category = event.getCategory();
        if(ReforgedConfig.COMMON.enableAluminumOre.get()) {
            if(category != Biome.BiomeCategory.NETHER && category != Biome.BiomeCategory.THEEND && category != Biome.BiomeCategory.NONE) {
                placedAluminumOre.getHolder().ifPresent(holder -> generation.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, holder));
            }
        }
    }
}
