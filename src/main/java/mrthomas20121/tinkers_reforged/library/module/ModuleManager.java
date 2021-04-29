package mrthomas20121.tinkers_reforged.library.module;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModuleManager {

    private static Map<String, ModuleReforgedBase> modules = new LinkedHashMap<>();

    public void addModule(String dep, ModuleReforgedBase module) {
        modules.put(dep, module);
    }

    public static void preInit() {
        modules.forEach((mod, module)-> {
            if(isModLoaded(mod) && module.canLoad()) {
                module.preInit();
            }
        });
    }

    public static void init() {
        modules.forEach((mod, module)-> {
            if(isModLoaded(mod) && module.canLoad()) {
                module.init();
            }
        });
    }

    public static void postInit() {
        modules.forEach((mod, module)-> {
            if(isModLoaded(mod) && module.canLoad()) {
                module.postInit();
            }
        });
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        modules.forEach((mod, module)-> {
            if(isModLoaded(mod) && module.canLoad()) {
                module.registerItems(r);
            }
        });
    }

    private static boolean isModLoaded(String mod) {
        return Loader.isModLoaded(mod);
    }
}
