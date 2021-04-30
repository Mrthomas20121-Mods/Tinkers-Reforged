package mrthomas20121.tinkers_reforged.library.module;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import slimeknights.tconstruct.library.modifiers.Modifier;

import java.util.*;

public class ModuleManager {

    private static Map<String, ModuleReforgedBase> modules = new LinkedHashMap<>();
    public static List<Item> items = new ArrayList<>();
    public static List<Block> blocks = new ArrayList<>();
    public static List<Modifier> modifiers = new ArrayList<>();

    public static CreativeTabs tab = new CreativeTabs("tinkers_reforged") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.REDSTONE);
        }
    };

    public enum type {
        INGOT,
        DUST,
        NUGGET,
        PLATE,
        GEAR
    }

    public static void addModule(String dep, ModuleReforgedBase module) {
        modules.put(dep, module);
    }

    public static void earlyPreInit() {
        modules.forEach((mod, module)-> {
            if(isModLoaded(mod) && module.canLoad()) {
                module.earlyPreInit();
            }
        });
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
