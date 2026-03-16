package mrthomas20121.tinkers_reforged;

import mrthomas20121.tinkers_reforged.client.TinkersReforgedBook;
import mrthomas20121.tinkers_reforged.data.TinkersReforgedDatagen;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedAttributes;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedBlocks;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedFluids;
import mrthomas20121.tinkers_reforged.init.TinkersReforgedItems;
import mrthomas20121.tinkers_reforged.module.*;
import mrthomas20121.tinkers_reforged.predicate.TinkersReforgedPredicates;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slimeknights.mantle.data.predicate.entity.LivingEntityPredicate;
import slimeknights.tconstruct.library.modifiers.modules.ModifierModule;

@Mod(TinkersReforged.MOD_ID)
public class TinkersReforged {

	public static final String MOD_ID = "tinkers_reforged";
	public static final Logger LOGGER = LogManager.getLogger();

	public TinkersReforged() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		TinkersReforgedBlocks.BLOCKS.register(bus);
		TinkersReforgedItems.register(bus);
		TinkersReforgedFluids.FLUIDS.register(bus);
		TinkersReforgedAttributes.ATTRIBUTES.register(bus);
		bus.addListener(TinkersReforgedDatagen::init);
		bus.addListener(this::registerSerializers);
		TinkersReforgedEvents.init();

		DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> TinkersReforgedBook::initBook);
	}

	public static ResourceLocation getResource(String resource) {
		return new ResourceLocation(MOD_ID, resource);
	}

	/** Makes a Tinkers Reforged description ID */
	public static String makeDescriptionId(String type, String name) {
		return type + "." + MOD_ID + "." + name;
	}

	public void registerSerializers(RegisterEvent event) {
		if (event.getRegistryKey() == Registries.RECIPE_SERIALIZER) {
			ModifierModule.LOADER.register(getResource("overfracture"), OverfractureModule.LOADER);
			ModifierModule.LOADER.register(getResource("triad"), TriadModule.LOADER);
			ModifierModule.LOADER.register(getResource("roast"), RoastModule.LOADER);
			ModifierModule.LOADER.register(getResource("flaming"), FlamingModule.LOADER);
			ModifierModule.LOADER.register(getResource("pitching"), PitchingModule.LOADER);

			LivingEntityPredicate.LOADER.register(getResource("above_sea_level"), TinkersReforgedPredicates.ABOVE_SEA_LEVEL.getLoader());
			LivingEntityPredicate.LOADER.register(getResource("baby"), TinkersReforgedPredicates.BABY.getLoader());
		}
	}
}