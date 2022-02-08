package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.datagen.ReforgedBlocksLoot;
import mrthomas20121.tinkers_reforged.datagen.ReforgedLootTables;
import mrthomas20121.tinkers_reforged.datagen.ReforgedMaterials;
import mrthomas20121.tinkers_reforged.init.Resources;
import mrthomas20121.tinkers_reforged.init.Traits;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

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

		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void gatherData(final GatherDataEvent event) {
		if (event.includeServer()) {
			DataGenerator gen = event.getGenerator();
			//gen.addProvider(new ReforgedLootTables(gen));
			AbstractMaterialDataProvider materials = new ReforgedMaterials(gen);
			gen.addProvider(materials);
			gen.addProvider(new ReforgedMaterials.ReforgedTraits(gen, materials));
		}
		//else if(event.includeClient()) {
			// lang and other stuff
		//}
	}
}
