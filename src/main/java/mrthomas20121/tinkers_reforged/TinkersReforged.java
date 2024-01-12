package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.client.TinkersReforgedBook;
import mrthomas20121.tinkers_reforged.datagen.*;
import mrthomas20121.tinkers_reforged.datagen.tcon.*;
import mrthomas20121.tinkers_reforged.init.*;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedWorldGen;
import mrthomas20121.tinkers_reforged.util.ReforgedTiers;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.client.model.tools.ToolModel;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;
import slimeknights.tconstruct.tools.data.sprite.TinkerPartSpriteProvider;

import java.util.List;

@Mod(TinkersReforged.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TinkersReforged {

	public static final String MOD_ID = "tinkers_reforged";
	public static final Logger LOGGER = LogManager.getLogger();

	public TinkersReforged() {
		TinkersReforgedTags.init();

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		TinkersReforgedModifiers.MODIFIERS.register(bus);
		TinkersReforgedBlocks.BLOCKS.register(bus);
		TinkersReforgedItems.ITEMS.register(bus);
		TinkersReforgedFluids.FLUIDS.register(bus);
		TinkersReforgedWorldGen.CONFIGURED_FEATURES.register(bus);
		TinkersReforgedWorldGen.PLACED_FEATURES.register(bus);
		TinkersReforgedPotions.MOB_EFFECTS.register(bus);
		TinkersReforgedPotions.POTIONS.register(bus);
		bus.addListener(this::commonEvent);

		MinecraftForge.EVENT_BUS.register(this);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, TinkersReforgedConfig.config);

		// execute this only on the client
		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> TinkersReforgedBook::initBook);
	}

	public void commonEvent(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TierSortingRegistry.registerTier(ReforgedTiers.KEPU, new ResourceLocation(MOD_ID, "kepu"), List.of(), List.of(Tiers.NETHERITE));
		});
	}

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		if (event.includeServer()) {
			AbstractMaterialDataProvider materials = new ReforgedMaterials(gen);
			gen.addProvider(materials);
			gen.addProvider(new ReforgedTraits(gen, materials));
			gen.addProvider(new ReforgedMaterialStats(gen, materials));
			gen.addProvider(new ReforgedToolDefinitionDataProvider(gen));
			gen.addProvider(new ReforgedToolSlotLayout(gen));
			gen.addProvider(new ReforgedRecipes(gen));
			ReforgedBlocksTags tags = new ReforgedBlocksTags(gen, fileHelper);
			gen.addProvider(tags);
			gen.addProvider(new ReforgedFluidTags(gen, fileHelper));
			gen.addProvider(new ReforgedItemsTags(gen, tags, fileHelper));
			gen.addProvider(new ReforgedEntityTags(gen, fileHelper));
		}
		if(event.includeClient()) {
			gen.addProvider(new ReforgedItemModels(gen, fileHelper));
			gen.addProvider(new ReforgedBlockStates(gen, fileHelper));
			gen.addProvider(new ReforgedLang(gen));
			AbstractMaterialSpriteProvider provider = new ReforgedMaterialSpriteProvider();
			AbstractMaterialSpriteProvider tinkersProvider = new TinkerMaterialSpriteProvider();
			gen.addProvider(new MaterialPartTextureGenerator(gen, fileHelper, new TinkerPartSpriteProvider(), provider));
			gen.addProvider(new MaterialPartTextureGenerator(gen, fileHelper, new ReforgedPartSprite(), provider));
			gen.addProvider(new MaterialPartTextureGenerator(gen, fileHelper, new ReforgedPartSprite(), tinkersProvider));
			gen.addProvider(new ReforgedRenderInfo(gen, provider));
			gen.addProvider(new ReforgedLootTables(gen));
		}
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = MOD_ID, value = Dist.CLIENT)
	public static class TinkersReforgedClient {
		public @SubscribeEvent
		static void itemColors(ColorHandlerEvent.Item event) {
			final ItemColors colors = event.getItemColors();

			ToolModel.registerItemColors(colors, TinkersReforgedItems.LONGSWORD);
			ToolModel.registerItemColors(colors, TinkersReforgedItems.GREATSWORD);
		}
	}
}
