package mrthomas20121.tinkers_reforged.library.potion;

import mrthomas20121.tinkers_reforged.TinkersReforged;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = TinkersReforged.MODID)
public class PotionRegistry {

    public static Potion ender = new ReforgedPotion(new ResourceLocation(TinkersReforged.MODID, "ender"), false, 0x006C5F);

    @SubscribeEvent
    public static void registerPotions(RegistryEvent.Register<Potion> event) {
        event.getRegistry().registerAll(ender);
    }
}
