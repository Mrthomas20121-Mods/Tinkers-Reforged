package mrthomas20121.tinkers_reforged;

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

		//MinecraftForge.EVENT_BUS.register(this);

		// execute this only on the client
		//DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> TinkersReforgedBook::initBook);
		//bus.addListener(EventPriority.NORMAL, false, RegisterEvent.class, this::register);
	}

	private ResourceLocation getResource(String resource) {
		return new ResourceLocation(MOD_ID, resource);
	}
}