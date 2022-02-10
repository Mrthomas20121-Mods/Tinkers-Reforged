package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.datagen.*;
import mrthomas20121.tinkers_reforged.init.Resources;
import mrthomas20121.tinkers_reforged.init.Traits;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
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

	public TinkersReforged() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		Traits.MODIFIERS.register(bus);
		Resources.BLOCKS.register(bus);
		Resources.ITEMS.register(bus);
		Resources.FLUIDS.register(bus);

		MinecraftForge.EVENT_BUS.register(this);
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
			AbstractMaterialSpriteProvider provider = new ReforgedMaterialSpriteProvider();
			gen.addProvider(new MaterialPartTextureGenerator(gen, fileHelper, new TinkerPartSpriteProvider(), provider));
			gen.addProvider(new ReforgedRenderInfo(gen, provider));
			gen.addProvider(new ReforgedItemModels(gen, fileHelper));
			gen.addProvider(new ReforgedBlockStates(gen, fileHelper));
			gen.addProvider(new ReforgedLang(gen));
			gen.addProvider(new ReforgedRecipes(gen));
		}
	}
}
