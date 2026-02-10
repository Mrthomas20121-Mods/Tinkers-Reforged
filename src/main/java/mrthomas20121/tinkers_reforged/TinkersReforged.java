package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.data.TinkersReforgedDatagen;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(TinkersReforged.MOD_ID)
public class TinkersReforged {

	public static final String MOD_ID = "tinkers_reforged";
	public static final Logger LOGGER = LogManager.getLogger();

	public TinkersReforged() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		// execute this only on the client
		//DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> TinkersReforgedBook::initBook);
		//bus.addListener(EventPriority.NORMAL, false, RegisterEvent.class, this::register);

		TinkersReforgedBlocks.BLOCKS.register(bus);
		TinkersReforgedItems.register(bus);
		bus.addListener(TinkersReforgedDatagen::init);
	}

	private ResourceLocation getResource(String resource) {
		return new ResourceLocation(MOD_ID, resource);
	}
}