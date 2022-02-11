package mrthomas20121.tinkers_reforged.world;

import mrthomas20121.tinkers_reforged.ReforgedConfig;
import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TinkersReforged.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class WorldGen {

    @SubscribeEvent(priority = EventPriority.LOW)
    public static void generateOre(final BiomeLoadingEvent event) {
        if(ReforgedConfig.COMMON.enableAluminumOre.get()) {
            if(event.getCategory().equals(Biome.Category.TAIGA)) {
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> TinkersReforged.ALUMINUM_ORE_FEATURE);
            }
        }
    }
}
