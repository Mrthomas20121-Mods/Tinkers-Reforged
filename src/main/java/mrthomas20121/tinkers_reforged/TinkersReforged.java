package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.api.CastItems;
import mrthomas20121.tinkers_reforged.datagen.*;
import mrthomas20121.tinkers_reforged.init.Resources;
import mrthomas20121.tinkers_reforged.init.Traits;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

@Mod(TinkersReforged.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TinkersReforged {

	public static final String MOD_ID = "tinkers_reforged";
	public static final Logger LOGGER = LogManager.getLogger();

	public static ConfiguredFeature<?,?> ALUMINUM_ORE_FEATURE;

	public TinkersReforged() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		Traits.MODIFIERS.register(bus);
		Resources.BLOCKS.register(bus);
		Resources.ITEMS.register(bus);
		CastItems.registerCasts();
		Resources.FLUIDS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ReforgedConfig.config);
	}

	@SubscribeEvent
	public static void setup(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			ALUMINUM_ORE_FEATURE = newConfiguredFeature("aluminum_ore", Feature.ORE.configured(
							new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Resources.aluminum_ore.get().defaultBlockState(), 9)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(30, 0, 60))))
					.squared().count(ReforgedConfig.COMMON.aluminumCount.get());
		});
	}

	public static ConfiguredFeature<?, ?> newConfiguredFeature(String registryName, ConfiguredFeature<?, ?> configuredFeature) {
		Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(TinkersReforged.MOD_ID, registryName), configuredFeature);
		return configuredFeature;
	}

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		if (event.includeServer()) {
			//gen.addProvider(new ReforgedLootTables(gen));
			AbstractMaterialDataProvider materials = new ReforgedMaterials(gen);
			gen.addProvider(materials);
			gen.addProvider(new ReforgedMaterials.ReforgedTraits(gen, materials));
			gen.addProvider(new ReforgedMaterials.ReforgedMaterialStats(gen, materials));
			gen.addProvider(new ReforgedRecipes(gen));
			ReforgedBlocksTags tags = new ReforgedBlocksTags(gen, fileHelper);
			gen.addProvider(tags);
			gen.addProvider(new ReforgedFluidTags(gen, fileHelper));
			gen.addProvider(new ReforgedItemsTags(gen, tags, fileHelper));
		}
		if(event.includeClient()) {
			AbstractMaterialSpriteProvider provider = new ReforgedMaterialSpriteProvider();
			gen.addProvider(new MaterialPartTextureGenerator(gen, fileHelper, new TinkerPartSpriteProvider(), provider));
			gen.addProvider(new ReforgedRenderInfo(gen, provider));
			gen.addProvider(new ReforgedItemModels(gen, fileHelper));
			gen.addProvider(new ReforgedBlockStates(gen, fileHelper));
			gen.addProvider(new ReforgedLang(gen));
		}
	}
}
