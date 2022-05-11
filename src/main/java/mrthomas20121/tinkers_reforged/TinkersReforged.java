package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.datagen.*;
import mrthomas20121.tinkers_reforged.init.*;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedWorldGen;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
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
		TinkersReforgedModifiers.MODIFIERS.register(bus);
		TinkersReforgedBlocks.BLOCKS.register(bus);
		TinkersReforgedItems.ITEMS.register(bus);
		TinkersReforgedItems.registerCasts();
		TinkersReforgedFluids.FLUIDS.register(bus);
		TinkersReforgedWorldGen.CONFIGURED_FEATURES.register(bus);
		TinkersReforgedWorldGen.PLACED_FEATURES.register(bus);
		TinkersReforgedPotions.MOB_EFFECTS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ReforgedConfig.config);
	}

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		if (event.includeServer()) {
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
			gen.addProvider(new ReforgedItemModels(gen, fileHelper));
			gen.addProvider(new ReforgedBlockStates(gen, fileHelper));
			gen.addProvider(new ReforgedLang(gen));
			AbstractMaterialSpriteProvider provider = new ReforgedMaterialSpriteProvider();
			gen.addProvider(new MaterialPartTextureGenerator(gen, fileHelper, new TinkerPartSpriteProvider(), provider));
			gen.addProvider(new ReforgedRenderInfo(gen, provider));
			//gen.addProvider(new ReforgedLootTables(gen));
		}
	}
}
